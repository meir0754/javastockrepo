package com.sawdayee.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

import com.sawdayee.exception.BalanceException;
import com.sawdayee.exception.PortfolioFullException;
import com.sawdayee.exception.StockAlreadyExistsException;
import com.sawdayee.exception.StockNotExistException;

/**
 * Represents a portfolio of stocks
 * @author      Meirs
 * @version     4.0                
 * @since       11-06-2015         
 */
public class Portfolio implements PortfolioInterface{

	public enum ALGO_RECOMMENDATION {
		BUY, SELL, REMOVE, HOLD;
	}

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private StockInterface[] stocks;
	private int portfolioSize;
	private float balance;
	private float amount;

	/**
	 * The class constractor 
	 */
	public Portfolio() {
		this.title = null;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.balance = 0;
	}

	/**
	 * The class constractor with title
	 * @param title - the portfolio title
	 */
	public Portfolio(String title) {
		this.title = title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
		this.balance = 0;
	}

	/**
	 * The class constractor with Stock Array
	 * @param stockArray - the Stock's we add to the portfolio
	 */
	public Portfolio(StockInterface[] stockArray) {
		this.title = new String("temp");
		this.portfolioSize = stockArray.length;
		this.balance = 0;
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		for(int i = 0; i<this.portfolioSize; i++){
			this.stocks[i]= new Stock ((Stock)stockArray[i]);
		}
	}

	/**
	 * The copy constractor
	 * @param portfolio - the original portfolio
	 */
	public Portfolio (Portfolio portfolio) {
		this (new String (portfolio.getTitle()));
		this.portfolioSize = (portfolio.getPortfolioSize());
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		for (int i = 0; i < portfolio.portfolioSize; i++) {
			this.stocks[i] = new Stock((Stock)portfolio.getStocks()[i]);
		}
	}

	/**
	 * Adding a new stock to the portfolio
	 * @param stock - the stock choosen to add to this portfolio
	 */
	public void addStock(Stock stock) throws PortfolioFullException, StockAlreadyExistsException, IllegalArgumentException {
		if (stock.getSymbol() == null) {
			throw new IllegalArgumentException("Error The insert stock value is Null");
		}
		else if (portfolioSize >= MAX_PORTFOLIO_SIZE) {
			throw new PortfolioFullException(MAX_PORTFOLIO_SIZE);
		}
		else if (getStockIndex(stock.getSymbol()) != -1) {
			throw new StockAlreadyExistsException(stock.getSymbol());
		}
		else {
			stocks[portfolioSize] = stock;
			stock.setStockQuantity(0);
			portfolioSize++;
		}
	}

	/**
	 * Remove a selected stock from the portfolio
	 * @param symbol - the stock symbol chosen to be removed 
	 */
	public void removeStock (String symbol) throws StockNotExistException, BalanceException {

		if (getStockIndex(symbol) == -1 || symbol == null) {
			throw new StockNotExistException(symbol);
		}
		else {
			sellStock(stocks[getStockIndex(symbol)].getSymbol(), ((Stock)stocks[getStockIndex(symbol)]).getStockQuantity());
			stocks[getStockIndex(symbol)] = stocks[portfolioSize - 1];
			stocks[portfolioSize-1] = null;
			portfolioSize--;
		}
	}

	/**
	 * Sell a selected stock from the portfolio
	 * @param symbol - the stock symbol chosen to be sold
	 * @param quantity - Number of this symbol’s stock to sell
	 */
	public void sellStock (String symbol, int quantity) throws StockNotExistException, BalanceException, IllegalArgumentException{

		if (quantity < -1 || symbol == null) {
			throw new IllegalArgumentException("You cant sell negative quantity or check your symbol");
		}
		else if (getStockIndex(symbol) != -1) {
			if (quantity > ((Stock) stocks[getStockIndex(symbol)]).getStockQuantity()) {
				throw new IllegalArgumentException("Not enough stocks to sell");
			}
			if ((quantity == -1)) {
				updateBalance(((Stock) stocks[getStockIndex(symbol)]).getStockQuantity() * stocks[getStockIndex(symbol)].getBid());
				((Stock)stocks[getStockIndex(symbol)]).setStockQuantity(0);
			}
			if (quantity <= ((Stock)stocks[getStockIndex(symbol)]).getStockQuantity()){
				updateBalance(quantity * stocks[getStockIndex(symbol)].getBid());
				((Stock)stocks[getStockIndex(symbol)]).setStockQuantity(((Stock)stocks[getStockIndex(symbol)]).getStockQuantity() - quantity);
			}
		}
	}

	/**
	 * Buy a new stock or quantity from an existing stock and add's it to the portfolio
	 * @param stock - the stock chosen to be bought
	 * @param quantity - Number of stocks to buy
	 * @return indicating operation success/fail
	 */
	public void buyStock (Stock stock, int quantity) throws BalanceException, PortfolioFullException, StockAlreadyExistsException, IllegalArgumentException {
		if (stock == null || quantity < -1) {
			throw new IllegalArgumentException("You cant buy negative quantity or check your symbol"); 
		}
		else if (getBalance() < (quantity * stock.getAsk())) {
			throw new IllegalArgumentException("Not enough balance to buy");
		}
		else if (getStockIndex(stock.getSymbol()) == -1) {
			addStock(stock);
		}
		if (quantity == -1) {
			quantity = (int) (getBalance() / stock.getAsk());
			updateBalance ((-1) * (quantity * stock.getAsk()));
			((Stock)stocks[getStockIndex(stock.getSymbol())]).setStockQuantity(stock.getStockQuantity() + quantity);
		}
		else if (getBalance() >= (quantity * stock.getAsk())) {
			updateBalance((-1) * (quantity * stock.getAsk()));
			((Stock) stocks[getStockIndex(stock.getSymbol())]).setStockQuantity(stock.getStockQuantity() + quantity);	
		}
	}

	/**
	 * calculate the value of stocks in the portfolio
	 * @return the total value of protfolio's stocks
	 */
	public float getStocksValue () {
		float stockValue = 0;
		for (int i = 0; i < portfolioSize; i++) {
			stockValue += stocks[i].getBid() * ((Stock) stocks[i]).getStockQuantity();
		}
		return stockValue;
	}

	/** 
	 * Update the current balance
	 * @param amount - the money that was added or removed from the balance
	 */
	public void updateBalance(float amount) throws BalanceException{
		if ((this.balance + amount) < 0) {
			throw new BalanceException(amount);
		}
		else {
			this.balance += amount;
		}
	}

	/**
	 * Sum the all stocks value and portfolio’s balance
	 * @return the total amount of the sum
	 */
	public float getTotalValue () {
		float totalValue = 0;
		totalValue = getBalance() + getStocksValue();
		return totalValue;
	}

	/**
	 * Returns html string that described this portfolio
	 * @return html string that represents this current portfolio and its stocks details
	 */
	public String getHtmlString() { 
		String str = "<h1>" + this.getTitle() + "</h1>";
		int i;
		for (i = 0; i < this.portfolioSize; i++) {
			str +=  ((Stock)this.stocks[i]).getHtmlDescription() + "<br/>";
		}
		str += "<br/><b>Total Portfolio Value:</b> " + this.getTotalValue();
		str += "$, <b>Total Stocks value:</b> " + getStocksValue();
		str += "$, <b>Balance:</b> " + getBalance() + "$";
		return str;
	}

	/**
	 * find the stock place in the portfolio
	 * @param stock - the stock we want to find
	 * @return the array index of the stock , if not exist return -1 
	 */
	private int getStockIndex(String symbol) {
		int i;
		for (i = 0; i < this.portfolioSize; i++) {
			if (symbol.equals(stocks[i].getSymbol())) {
				return i;
			}
		}
		return i = -1;
	}

	/**
	 * find the choosen stock in the portfolio
	 * @param symbol - the stock's name
	 * @return the Stock Found in the array , if not exist return null
	 */
	public StockInterface findStock(String symbol) {
		int i;
		for (i = 0; i < this.portfolioSize; i++) {
			if (symbol.equals(stocks[i].getSymbol())) {
				return stocks[i];
			}
		}
		return null;
	}

	// Setters&Getters

	public StockInterface[] getStocks() {
		return this.stocks;
	}

	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getPortfolioSize() {
		return this.portfolioSize;
	}

	public void setStocks(StockInterface[] stocks) {
		this.stocks = stocks;
	}

	public float getBalance() {
		return this.balance;
	}

	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public static int getMaxSize() {
		return MAX_PORTFOLIO_SIZE;
	}

}
