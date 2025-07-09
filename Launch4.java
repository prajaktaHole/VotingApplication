package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.CandidatesDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch4 extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		String cname = request.getParameter("cname");
		
		ApplicationContext cxt = new ClassPathXmlApplicationContext("config.xml");
		CandidatesDao cDao = cxt.getBean("cDao", CandidatesDao.class);
		
		cDao.deleteCandidate(cname);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("adminhome");
		
		return mv;
	}

}
