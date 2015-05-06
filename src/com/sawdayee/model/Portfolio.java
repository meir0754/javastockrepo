package com.sawdayee.model;

/**
 * Represents a portfolio of stocks
 * @author      Meirs
 * @version     1.0                
 * @since       05-05-2015         
 */
public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks;
	private int portfolioSize;

	/**
	 * The class constractor
	 * @param title - the protfolio title
	 */
	public Portfolio(String title) {
		this.title = title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
	}

	/**
	 * The copy constractor
	 * @param portfolio - the original portfolio
	 */
	public Portfolio (Portfolio portfolio) {
		this.title = new String (portfolio.getTitle());
		this.portfolioSize = (portfolio.getPortfolioSize());
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		for (int i = 0; i < portfolio.portfolioSize; i++) {
			this.stocks[i] = new Stock (portfolio.getStocks()[i]);		
		}
	}

	/**
	 * Adding a new stock to the portfolio
	 * @param stock - the stock to add to this portfolio
	 */
	public void addStock(Stock stock) {
		if (stock != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
			stocks[portfolioSize] = stock;
			portfolioSize++;
		} else {
			System.out.println("Error - The insert stock value is Null or the Portfolio is full");
		}
	}

	/**
	 * Remove a selected stock from the portfolio
	 * @param symbol - the stock symbol chosen to be removed 
	 */
	public void removeStock (String symbol) {
		if (symbol == null){
			System.out.println("False stock symbol");
		}
		if (symbol.equals(stocks[portfolioSize-1].getSymbol())) {
			stocks[portfolioSize-1] = null;
			portfolioSize--;
		}
		else {
			for(int i = 0; i < portfolioSize; i++) {
				if (symbol.equals(stocks[i].getSymbol())) {
					stocks[i] = stocks[portfolioSize - 1];
					stocks[portfolioSize-1] = null;
					portfolioSize--;
				}
			}
		}
	}

	public Stock[] getStocks() {
		return this.stocks;
	}

	/**
	 * Returns html string that described this portfolio
	 * @return html string that represents this current portfolio and its stocks details
	 */
	public String getHtmlString() { 
		String str = "<h1>" + this.getTitle() + "</h1>";
		int i;
		for (i = 0; i < this.portfolioSize; i++) {
			str +=  this.stocks[i].getHtmlDescription() + "<br/>";
		}
		return str;
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

	public void setPortfolioSize(int portfolioSize) {
		this.portfolioSize = portfolioSize;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}

}
