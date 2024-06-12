package com.itwill.spring2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostSearchDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자.
@Service // 스프링 컨테이너에 서비스 컴포넌트
public class PostService {
	
	// 애너테이션을 사용한 의존성 주입(DI: Dependency Injection):
	// @Autowired private PostDao postDao;
	
	// 생성자에 의한 의존성 주입:
	// (1) final 필드 선언. (2) final 필드를 초기화하는 생성자 작성.
	private final PostDao postDao;
//	public PostService(PostDao postDao) {
//		this.postDao = postDao;
//	}
	
	public List<PostListDto> read() {
		log.debug("read()");
		
		List<Post> list = postDao.selectOrderByIdDesc();
		
//		List<PostListDto> result = new ArrayList<>();
//		for (Post p : list) {
//			result.add(PostListDto.fromEntity(p));
//		}
		
		return list.stream()
				.map(PostListDto::fromEntity) // map((x) -> PostListDto.fromEntity(x))
				.toList();
	}
	
	public Post read(int id) {
//		Post post = postDao.selectById(id);
		
		return postDao.selectById(id);
	}
	
	public int create(PostCreateDto dto) {
		log.debug("create({}", dto);
		
		int result = postDao.insertPost(dto.toEntity()); // insert 결과를 확인하기 위해 result에 출력 정수를 보관. 
		log.debug("insert 결과 = {}", result); // insert 결과를 로그로 확인.(result 결과가 1이면 정상적으로 insert 완료)
		
		return result;
	}
	
	public int delete(int id) {
		log.debug("delete(id={})", id);
		
		// 리포지토리 컴포넌트의 메서드를 호출해서 delete 쿼리를 실행.
		int result = postDao.deletePost(id);
		log.debug("delete 결과 = {}", result);
		
		return result;
	}
	
	public int update(PostUpdateDto dto) {
		log.debug("update(id={})", dto);
		
		// 리포지토리 컴포넌트의 메서드를 호출해서 update 쿼리를 실행.
		int result = postDao.updatePost(dto.toEntity());
		log.debug("update 결과 = {}", result);
		
		return result;
	}
	
	public List<PostListDto> search(PostSearchDto dto) {
        log.debug("search({})", dto);
		
		List<Post> list = postDao.search(dto);
		
		return list.stream().map(PostListDto::fromEntity).toList();
	}
	
}
