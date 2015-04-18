package com.sawdayee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sawdayee.Stock;

@SuppressWarnings("serial")
public class StockDetailsServlet extends HttpServlet {
	@SuppressWarnings("deprecation")
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");

		Stock stock1, stock2, stock3;

		stock1= new Stock("PIH", 13.1f, 12.4f, new java.util.Date(2014,11,15));
		stock2= new Stock("AAL", 5.78f, 5.5f, new java.util.Date(2014,11,15));
		stock3= new Stock("CAAS", 32.2f, 31.5f, new java.util.Date(2014,11,15));

		String line1 = new String(stock1.getHtmlDescription());
		String line2 = new String(stock2.getHtmlDescription());
		String line3 = new String(stock3.getHtmlDescription());
		String resultStr = line1 + "<br><br>" + line2 + "<br><br>" + line3; 
		resp.getWriter().println(resultStr);

	}
}