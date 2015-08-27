package com.zehao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
public class PermissionFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public PermissionFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String servletPath = httpServletRequest.getServletPath();

		HttpSession session = httpServletRequest.getSession();

		String flag = (String) session.getAttribute("flag");
		if(flag!=null){
			System.out.println("=========="+flag+"===============");
		}else{
			System.out.println(flag==null);
		}
		System.out.println("````````````"+servletPath+"````````````````");

		if (servletPath != null || servletPath.equals("/16/login.jsp") || servletPath.equals("/16/index.jsp")
				|| servletPath.equals("/Loginservlet16")) {
			System.out.println("登录进行中！");
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("login_success")) {
				System.out.println("您已经登录！");
				chain.doFilter(request, response);
			} else if (flag != null && flag.equals("login_error")) {
				System.out.println("登录失败，请重新登录！！！<br />");
				httpServletRequest.setAttribute("msg", "登录失败，请重新登录！！！<br />");
				httpServletRequest.setAttribute("return_uri", servletPath);
				RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/16/login.jsp");
				requestDispatcher.forward(httpServletRequest, httpServletResponse);
			} else {
				System.out.println("您尚未登录，请先登录!");
				httpServletRequest.setAttribute("msg", "您尚未登录，请先登录!");
				httpServletRequest.setAttribute("return_uri", servletPath);
				RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/16/login.jsp");
				requestDispatcher.forward(httpServletRequest, httpServletResponse);
			}
		}

		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
