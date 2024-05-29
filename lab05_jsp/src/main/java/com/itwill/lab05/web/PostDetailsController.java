package com.itwill.lab05.web;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postDetailsController", urlPatterns = {"/post/details"})
public class PostDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDetailsController.class);
	
	private final PostService postService = PostService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("doGet()");
//		log.debug(getClientIp(req)); // postDetail에 접속한 아이피를 getClientIp 메서드를 사용해 콘솔에 로그 출력
		// 질의 문자열(query string)에 포함된 요청 파라미터 id 값을 읽음.
		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id={}", id);
		
		// 서비스 계층의 메서드를 호출해서 해당 id의 Post 정보를 DB에서 읽음.
		Post post = postService.read(id); 
		
		// 검색된 Post 객체를 뷰(JSP)에게 전달.
		req.setAttribute("post", post);
		
		// 뷰로 이동(forward)
		req.getRequestDispatcher("/WEB-INF/views/post/details.jsp").forward(req, resp);
	}
	
//	 postDetail에 접속하는 아이피 주소를 알아내기 위한 메서드
//	public static String getClientIp(HttpServletRequest request) throws UnknownHostException {
//	    String ip = request.getHeader("X-Forwarded-For");
//
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("Proxy-Client-IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("WL-Proxy-Client-IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("HTTP_CLIENT_IP"); 
//	    } 
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
//	    }
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("X-Real-IP");
//	    }
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("X-RealIP"); 
//	    }
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getHeader("REMOTE_ADDR");
//	    }
//	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
//	        ip = request.getRemoteAddr(); 
//	    }
//
//	    if(ip.equals("0:0:0:0:0:0:0:1") || ip.equals("127.0.0.1")) 
//	    {
//	        InetAddress address = InetAddress.getLocalHost();
//	        ip = address.getHostName() + "/" + address.getHostAddress();
//	    }
//
//	    return ip;
//	}

}
