package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class PortfolioFullException extends PortfolioException {

	public PortfolioFullException (int maxSize) {
		super ("Cant add new stock, The portfolio can have only "+ maxSize +" stocks");
	}
}
