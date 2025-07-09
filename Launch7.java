package com.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Launch7 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession s = request.getSession();
		
		s.removeAttribute("utoken");
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userlogin");
		
		return mv;
	}

}
