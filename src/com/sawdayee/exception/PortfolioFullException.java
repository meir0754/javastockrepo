package com.sawdayee.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
/**
 * Elert when the portfolio is full
 * @author      Meirs
 * @version     1.0                
 * @since       11-06-2015         
 */
public class PortfolioFullException extends PortfolioException {

	public PortfolioFullException (int maxSize) {
		super ("Cant add new stock, The portfolio can have only "+ maxSize +" stocks");
	}
}
