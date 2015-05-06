package com.sawdayee.service;

import java.util.Calendar;
import java.util.Date;

import com.sawdayee.model.Portfolio;
import com.sawdayee.model.Stock;


/**
 * Portfolio controller. responsible to create and update the portfolio details
 * @author      Meirs
 * @version     1.0                
 * @since       05-05-2015         
 */
public class PortfolioManager {

	/**
	* Create and returns a new portfolio with 3 stocks
	* @return new Portfolio instance with stocks
	*/
	public Portfolio getPortfolio() {
		
		Portfolio portfolio = new Portfolio ("Meir's Portfolio");
		Stock s1, s2, s3;
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2014, 10, 15);
		Date date1 = cal1.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, 10, 15);
		Date date2 = cal2.getTime();
		
		Calendar cal3 = Calendar.getInstance();
		cal3.set(2014, 10, 15);
		Date date3 = cal3.getTime();
		
		s1 = new Stock("PIH", 13.1f, 12.4f, date1, 0, 0);
		portfolio.addStock(s1);
		
		s2 = new Stock("AAL", 5.78f, 5.5f, date2, 0, 0);
		portfolio.addStock(s2);
		
		s3 = new Stock("CAAS", 32.2f, 31.5f, date3, 0, 0);
		portfolio.addStock(s3);
	
		return portfolio;
	}
}
