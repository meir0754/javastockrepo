package com.sawdayee;

public class Stock{

	private String symbol;
	private float ask;
	private float bid;	
	private java.util.Date date;
	
	public Stock(String initSymbol, float initAsk, float initBid, java.util.Date initDate) {
		this.setSymbol(initSymbol);
		this.setAsk(initAsk);
		this.setBid(initBid);
		this.setDate(initDate);
	}
	
	public String getHtmlDescription() {
		return "<b>Stock symbol</b> : "+this.getSymbol()+", <b>ask</b> : "+this.getAsk()+", <b>Bid</b>: "+this.getBid()+", <b>Date</b>: "+this.getDateMonth()+"/"+this.getDateDay()+"/"+this.getDateYear(); 
	}
	
	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public float getAsk() {
		return this.ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}

	public float getBid() {
		return this.bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}

	public java.util.Date getDate() {
		return this.date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public int getDateDay() {
		return this.date.getDate();
	}
	
	public int getDateMonth() {
		return this.date.getMonth();
	}
	
	public int getDateYear() {
		return this.date.getYear();
	}
	
}


