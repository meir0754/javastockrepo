package com.sawdayee.model;

import org.algo.model.PortfolioInterface;
import org.algo.model.StockInterface;

/**
 * Represents a portfolio of stocks
 * @author      Meirs
 * @version     3.0                
 * @since       29-05-2015         
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
		this.title = new String (portfolio.getTitle());
		this.portfolioSize = (portfolio.getPortfolioSize());
		this.stocks = new StockInterface[MAX_PORTFOLIO_SIZE];
		this.balance = (portfolio.getBalance());
		for (int i = 0; i < portfolio.portfolioSize; i++) {
			this.stocks[i] = new Stock((Stock)portfolio.getStocks()[i]);
		}
	}

	/**
	 * Adding a new stock to the portfolio
	 * @param stock - the stock to add to this portfolio
	 */
	public void addStock(Stock stock) {
		if (stock.getSymbol() == null) {
			System.out.println("Error - The insert stock value is Null");
		}
		else if (portfolioSize >= MAX_PORTFOLIO_SIZE) {
			System.out.println("Can’t add new stock, portfolio can have only" + MAX_PORTFOLIO_SIZE + "stocks");
		}
		else if (getStockIndex(stock.getSymbol()) == -1) {
			stocks[portfolioSize] = stock;
			stock.setStockQuantity(0);
			portfolioSize++;
		}
	}

	/**
	 * Remove a selected stock from the portfolio
	 * @param symbol - the stock symbol chosen to be removed 
	 * @return boolean indicating operation success/fail
	 */
	public boolean removeStock (String symbol) {
		if (symbol == null){
			System.out.println("The symbol you entered is null");
			return false;
		}

		else if (getStockIndex(symbol) == -1) {
			System.out.println("The symbol doesn't exist in the portfolio");
			return false;
		}
		else {
			sellStock(stocks[getStockIndex(symbol)].getSymbol(), ((Stock)stocks[getStockIndex(symbol)]).getStockQuantity());
			stocks[getStockIndex(symbol)] = stocks[portfolioSize - 1];
			stocks[portfolioSize-1] = null;
			portfolioSize--;
			return true;
		}
	}

	/**
	 * Sell a selected stock from the portfolio
	 * @param symbol - the stock symbol chosen to be sold
	 * @param quantity - Number of this symbol’s stock to sell
	 * @return boolean indicating operation success/fail
	 */
	public boolean sellStock (String symbol, int quantity) {
		if (symbol == null || getStockIndex(symbol) == -1){
			System.out.println("False stock symbol");
			return false;
		}
		else if (quantity < 1 && quantity != -1) {
			System.out.println("Stock quantity can't be nothing or negative");
			return false;
		}
		else if (getStockIndex(symbol) != -1) {
			if (quantity > ((Stock) stocks[getStockIndex(symbol)]).getStockQuantity()) {
				System.out.println("Not enough stocks to sell");
				return false;
			}
			if ((quantity == -1)) {
				updateBalance(((Stock) stocks[getStockIndex(symbol)]).getStockQuantity() * stocks[getStockIndex(symbol)].getBid());
				((Stock)stocks[getStockIndex(symbol)]).setStockQuantity(0);
				return true;
			}
			if (quantity <= ((Stock)stocks[getStockIndex(symbol)]).getStockQuantity()){
				updateBalance(quantity * stocks[getStockIndex(symbol)].getBid());
				((Stock)stocks[getStockIndex(symbol)]).setStockQuantity(((Stock)stocks[getStockIndex(symbol)]).getStockQuantity() - quantity);
				return true;
			}
		}
		return false;
	}

	/**
	 * Buy a new stock or quantity from an existing stock and add's it to the portfolio
	 * @param stock - the stock chosen to be bought
	 * @param quantity - Number of stocks to buy
	 * @return indicating operation success/fail
	 */
	public boolean buyStock (Stock stock, int quantity) {
		if (quantity < 1 && quantity != -1) {
			System.out.println("Stock quantity can't be nothing or negative");
			return false;
		}
		else if (getBalance() < (quantity * stock.getAsk())) {
			System.out.println("Not enough balance to complete purchase");
			return false;
		}
		else if (getStockIndex(stock.getSymbol()) == -1) {
			addStock(stock);
		}
		if (quantity == -1) {
			quantity = (int) (getBalance() / stock.getAsk());
			updateBalance ((-1) * (quantity * stock.getAsk()));
			((Stock)stocks[getStockIndex(stock.getSymbol())]).setStockQuantity(stock.getStockQuantity() + quantity);
			return true;
		}
		else if (getBalance() >= (quantity * stock.getAsk())) {
			updateBalance((-1) * (quantity * stock.getAsk()));
			((Stock) stocks[getStockIndex(stock.getSymbol())]).setStockQuantity(stock.getStockQuantity() + quantity);	
			return true;
		}
		return false;
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
	public void updateBalance(float amount) {
		if ((this.balance + amount) < 0) {
			System.out.println("The amount can't be bigger then balance");
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
