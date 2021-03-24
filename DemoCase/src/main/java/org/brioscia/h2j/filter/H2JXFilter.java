package org.brioscia.h2j.filter;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.brioscia.javaz.h2j.filter.H2JProcessorFilter;

public class H2JXFilter extends H2JProcessorFilter {

	public void init(FilterConfig fConfig) throws ServletException {
		super.init(fConfig);
		System.out.println("Filter started at: " + fConfig.getServletContext().getContextPath());
	}
}
