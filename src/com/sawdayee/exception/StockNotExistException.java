package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockNotExistException extends PortfolioException{

	public StockNotExistException (String symbol) {
		super ("The stock " + symbol + " youve entered doesnt exist in the portfolio");		
	}
}
