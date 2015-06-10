package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockAlreadyExistsException extends PortfolioException {

	public StockAlreadyExistsException (String symbol) {
		super ("Sorry, The stock " + symbol + " already exist in the portfolio");
	}
}
