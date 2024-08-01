package com.itwill.springboot5.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot5.domain.Comment;
import com.itwill.springboot5.domain.Post;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CommentRepositoryTest {
	// CommentRepository의 CURD 기능을 단위 테스트.
	@Autowired private CommentRepository commentRepo;
	@Autowired private PostRepository postRepo;
	
//	@Test
	public void testFindAll() {
		List<Comment> list = commentRepo.findAll();
		assertThat(list).size().isEqualTo(0);
		
		list.forEach(System.out::println);
	}
	
//	@Test
	public void testSave() {
		Post post = postRepo.findById(3L).orElseThrow();
		Comment comment = Comment.builder()
				.post(post)
				.ctext("save 테스트 내용1")
				.writer("save 테스트 작성자1")
				.build();
		log.info("save 전: {}", comment);
		
		commentRepo.save(comment);
		log.info("save 후: {}", comment);
	}
	
	@Test
	public void testUpdate() {
		Comment comment = commentRepo.findById(1L).orElseThrow();
		log.info("findById 결과 = {}", comment);
	}
	
//	@Test
	public void testDelete() {
		commentRepo.deleteById(1L);
	}

}
