package com.sawdayee.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represents a stock
 * @author      Meirs
 * @version     1.0                
 * @since       05-05-2015
 */
public class Stock{

	private static final int BUY = 0, SELL = 1, REMOVE = 2, HOLD = 3;

	private String symbol;
	private float ask;
	private float bid;	
	private Date date;
	private int recommendation;
	private int stockQuentity;

	/**
	 * The class constractor
	 * @param the stock symbol and values
	 */
	public Stock(String initSymbol, float initAsk, float initBid, Date initDate, int initRecommendation, int initStockQuentity) {
		this.symbol = initSymbol;
		this.ask = initAsk;
		this.bid = initBid;
		this.date = initDate;
		this.recommendation = initRecommendation;
		this.stockQuentity = initStockQuentity;
	}
	
	/**
	 * The copy constractor
	 * @param stock - the original stock
	 */
	public Stock (Stock stock) {
		this.symbol = new String (stock.getSymbol());
		this.ask = (stock.getAsk());
		this.bid = (stock.getBid());
		this.date = new Date (stock.getDate().getTime());	
		this.recommendation = (stock.getRecommendation());
		this.stockQuentity = (stock.getStockQuentity());
	}

	/**
	* Returns html string that described this stock
	* @return html string that represents this stock details
	*/
	public String getHtmlDescription() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = df.format(getDate());

		return "<b>Stock symbol</b> : "+this.getSymbol()+", <b>ask</b> : "+this.getAsk()+", <b>Bid</b>: "+this.getBid()+", <b>Date</b>: " +dateStr; 
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

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(int recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuentity() {
		return this.stockQuentity;
	}

	public void setStockQuentity(int stockQuentity) {
		this.stockQuentity = stockQuentity;
	}

}


