package com.sawdayee.model;

import com.sawdayee.Stock;

public class Portfolio {

	private final static int MAX_PORTFOLIO_SIZE = 5;
	private String title;
	private Stock[] stocks;
	private int portfolioSize;

	public Portfolio() {
		this.title = title;
		this.stocks = new Stock[MAX_PORTFOLIO_SIZE];
		this.portfolioSize = 0;
	}

	public void addStock(Stock stock) {
		if (stock != null && portfolioSize < MAX_PORTFOLIO_SIZE) {
		stocks[portfolioSize] = stock;
		portfolioSize++;
		} else {
			System.out.println("Error - The insert stock value is Null or the Portfolio is full");
		}
	}

	public Stock[] getStocks() {
		return this.stocks;
	}

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
