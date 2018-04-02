package com.way.waybillsystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		  HttpServletRequest req = (HttpServletRequest)request;
	        HttpServletResponse resp =(HttpServletResponse) response;
	        HttpSession session = req.getSession();
	        String uri = req.getRequestURI();//得到请求地址
	        System.out.println("--------"+uri);
	        if(uri.contains("/login")||uri.contains("/register")||uri.contains("/nav")||uri.contains("/head")||uri.contains("/footer")||uri.contains("/sidebar")){
	        	chain.doFilter(req, resp);
	        }else{
	        	 if(uri.contains("/user")&&!uri.contains("manage")){
	        		 if(session.getAttribute("user")!=null){
	 	        		chain.doFilter(req, resp);
	 		        }else{
	 		        	resp.sendRedirect("login.html");
	 		        }
	        	 }
	        	
	        	 if(uri.contains("/admin")){
	        		 if(session.getAttribute("admin")!=null){
	 	        		chain.doFilter(req, resp);
	 		        }else{
	 		        	resp.sendRedirect("login.html");
	 		        }
	        	 }
	        	
	        }
	        
	        
	        
	       
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
