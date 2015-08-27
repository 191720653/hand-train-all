package com.zehao.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PermissionFilter
 */
public class PermissionFilter implements Filter {

	String encoding = null;

	/**
	 * Default constructor.
	 */
	public PermissionFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("----------构造方法---------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("---------初始化方法----------");
		encoding = fConfig.getInitParameter("encoding");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("---------dofilter方法----------");
		// TODO Auto-generated method stub
		// place your code here

		if (!encoding.equals(request.getCharacterEncoding())) {
			request.setCharacterEncoding(encoding);
		}
		response.setCharacterEncoding(encoding);

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		String servletPath = httpServletRequest.getServletPath();
		System.out.println("---------" + servletPath + "----------");

		HttpSession session = httpServletRequest.getSession();
		String flag = (String) session.getAttribute("flag");
		System.out.println("---------" + flag + "----------");
		if (servletPath != null && servletPath.equals("/login.jsp") || servletPath.equals("/index.jsp")
				|| servletPath.equals("/LoginServlet")) {
			chain.doFilter(request, response);
		} else {
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(request, response);
			} else if (flag != null && flag.equals("login_error")) {
				httpServletRequest.setAttribute("msg", "用户账号或密码错误！");
				httpServletRequest.setAttribute("return_uri", servletPath);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(request, response);
			} else {
				System.out.println("---------您尚未登录！----------");
				httpServletRequest.setAttribute("msg", "您尚未登录！");
				httpServletRequest.setAttribute("return_uri", servletPath);
				RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("login.jsp");
				requestDispatcher.forward(httpServletRequest, httpServletResponse);
			}
		}
		System.out.println("---------dofilter结束----------");
		// pass the request along the filter chain
		// chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("----------销毁方法---------");
	}

}
