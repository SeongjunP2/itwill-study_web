package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "userInfoController", urlPatterns = {"/user/userinfo"})
public class UserInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostListController.class);
	
	private final UserService userService = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
		
		String userId = req.getParameter("userid");
		
		// 서비스 계층의 메서드를 호출해서 해당 id의 User 정보를 DB에서 읽음.
		User user = userService.read(userId); 
		
		// 검색된 User 객체를 뷰(JSP)에게 전달.
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/WEB-INF/views/user/userinfo.jsp").forward(req, resp);
	}

}
