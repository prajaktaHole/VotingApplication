package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.UsersDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Launch6 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		
		
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
		UsersDao uDao = cxt.getBean("uDao", UsersDao.class);
		
		
		boolean status = uDao.checkUser(uname, upass);
		
		ModelAndView mv = new ModelAndView();
		HttpSession s = request.getSession();
		
		if(status)
		{
			s.setAttribute("utoken", uname);
			mv.setViewName("userhome");
		}
		else
		{
			mv.setViewName("userlogin");
		}
		
		
		return mv;
	}

}
