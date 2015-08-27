package com.zehao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterOne
 */
public class FilterOne implements Filter {

	/**
	 * Default constructor.
	 */
	public FilterOne() {
		// TODO Auto-generated constructor stub
		System.out.println("-------------FilterOne構造函數----------------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("------------FilterOne初始化方法------------");
		String initParam = fConfig.getInitParameter("param");
		System.out.println("initparam=" + initParam);
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("------FilterOne开始执行doFilter方法------");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		System.out.println("------FilterOne结束执行doFilter方法------");
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----------FilterOne销毁方法----------");
	}

}
