package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository deptRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(deptRepo).isNotNull();
		log.info("deptRepo={}", deptRepo);
	}
	
//	@Test
	public void testFindAll() {
		long count = deptRepo.count();
		assertThat(count).isEqualTo(27L);
		
		List<Department> list = deptRepo.findAll();
		log.info("Department[0]={}", list.get(0));
	}
	
	@Transactional
	@Test
	public void testFindById() {
		Department dept = deptRepo.findById(10).orElseThrow();
		
		log.info("dept={}", dept);
		log.info("dept.manager={}", dept.getManager());
		log.info("dept.location={}", dept.getLocation());
	}

}
