package com.sawdayee.stock.servlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import com.sawdayee.service.PortfolioManager;

import org.algo.service.ServiceManager;

@SuppressWarnings("serial")
public class InitServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		super.init();

		PortfolioManager pm = new PortfolioManager();
		ServiceManager.setPortfolioManager(pm);
	}
}