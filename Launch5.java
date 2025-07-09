package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.UsersDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch5 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		String uemail = request.getParameter("uemail");
		
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
		UsersDao uDao = cxt.getBean("uDao", UsersDao.class);
		
		
		uDao.addUser(uname, upass, uemail);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userlogin");
		
		
		return mv;
	}

}
