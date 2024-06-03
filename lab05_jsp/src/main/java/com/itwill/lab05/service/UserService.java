package com.itwill.lab05.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.repository.User;
import com.itwill.lab05.repository.UserDao;

// 서비스(비즈니스) 계층 싱글턴 객체.
public enum UserService {
	INSTANCE;
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private final UserDao userDao = UserDao.INSTANCE;
	
	// TODO: 회원 가입에 필요한 메서드.userDao.insert() 호출.
	public int create(User user) {
		log.debug("create(user)={}",user);
		
		int result = userDao.insert(user);
		log.debug("insert result = {}", user);
		
		return result;
	}
	
	public User signIn(String userid, String password) {
		log.debug("signIn(userid={}, password={})", userid, password);
		
		// DTO(Data Transfer Object)
		User dto = User.builder().userId(userid).password(password).build();
		User user = userDao.selectByUseridandPassword(dto);
		log.debug("로그인 결과 = {}", user);
		
		return user;
	}
	
	public User read(String userId) {
		log.debug("read(id={})", userId);
		
		// 영속성 계층의 메서드를 호출해서 DB 테이블에서 id로 검색하는 SQL을 실행.
		User user = userDao.selectByUserid(userId);
		log.debug("{}", user);
		
		return user; //컨트롤러에게 검색한 Post 객체를 리턴.
	}

}
