package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
/**
 * Elert when choosing to remove or sell a stock that doesnt exist in the portfolio
 * @author      Meirs
 * @version     1.0                
 * @since       11-06-2015         
 */
public class StockNotExistException extends PortfolioException{

	public StockNotExistException (String symbol) {
		super ("The stock " + symbol + " youve entered doesnt exist in the portfolio");		
	}
}
