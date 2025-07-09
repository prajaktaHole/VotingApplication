package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.VotesDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch8 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String username = request.getParameter("uname");
		String candidatename = request.getParameter("cname");
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
		VotesDao vDao = cxt.getBean("vDao", VotesDao.class);
		
		vDao.addVote(username, candidatename);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("userhome");
		
		return mv;
	}

}
