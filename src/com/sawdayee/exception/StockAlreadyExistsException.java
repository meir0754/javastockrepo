package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
/**
 * Elert when you added a stock that is already exist in the portfolio
 * @author      Meirs
 * @version     1.0                
 * @since       11-06-2015         
 */
public class StockAlreadyExistsException extends PortfolioException {

	public StockAlreadyExistsException (String symbol) {
		super ("Sorry, The stock " + symbol + " already exist in the portfolio");
	}
}
