package com.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Launch1 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String name = request.getParameter("aname");
		String pass = request.getParameter("apass");
		
		ModelAndView mv = new ModelAndView();
		HttpSession s = request.getSession();
		if(name.equals("Ram") && pass.equals("Pass@123"))
		{
			s.setAttribute("atoken", name);
			mv.setViewName("adminhome");
		}
		else
		{
			mv.setViewName("adminlogin");
		}
		
		return mv;
	}

}
