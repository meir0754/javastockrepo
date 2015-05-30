package com.sawdayee.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.algo.model.StockInterface;

import com.sawdayee.model.Portfolio.ALGO_RECOMMENDATION;

/**
 * Represents a stock
 * @author      Meirs
 * @version     3.0                
 * @since       29-05-2015
 */
public class Stock implements StockInterface{

	private String symbol;
	private float ask;
	private float bid;	
	private Date date;
	private Portfolio.ALGO_RECOMMENDATION recommendation;
	private int stockQuantity;

	/**
	 * The class constractor
	 */
	public Stock() {
		this.symbol = null;
		this.ask = 0;
		this.bid = 0;
		this.date = null;
		this.recommendation = ALGO_RECOMMENDATION.HOLD;
		this.stockQuantity = 0;
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
		this.stockQuantity = (stock.getStockQuantity());
	}

	/**
	* Returns html string that described this stock
	* @return html string that represents this stock details
	*/
	public String getHtmlDescription() {
		SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String dateStr = df.format(getDate());
		String str ="";
		str += "<b>Stock symbol</b> : "+this.getSymbol()+", <b>Ask</b> : "+this.getAsk();
		str += ", <b>Bid</b>: "+this.getBid()+", <b>Date</b>: " +dateStr;
		str += ", <b>Quantity</b>: " + this.getStockQuantity(); 
		return str;
	}

	
	// Setters&Getters
	
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

	public ALGO_RECOMMENDATION getRecommendation() {
		return this.recommendation;
	}

	public void setRecommendation(ALGO_RECOMMENDATION recommendation) {
		this.recommendation = recommendation;
	}

	public int getStockQuantity() {
		return this.stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

}


