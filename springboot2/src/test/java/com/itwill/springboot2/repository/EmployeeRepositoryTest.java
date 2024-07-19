package com.itwill.springboot2.repository;

// import static 구문: static 매서드, 필드 이름을 임포트.
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot2.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class EmployeeRepositoryTest {
	
	@Autowired // 의존성 주입(DI: dependency injection), 제어의 역전(IoC: Inversion of Control)
	private EmployeeRepository empRepo;
	private DepartmentRepository deptRepo;
	
	//@Test
	public void test() {
		//Assertions.assertNotNull(empRepo);
		assertThat(empRepo).isNotNull(); // empRepo 객체가 null이 아니면 테스트 성공.
		log.info("***** empRepo: {}", empRepo);
	}
	
	// select * from emp
	//@Test
	public void findAllTest() {
		List<Employee> list = empRepo.findAll();
		assertThat(list.size()).isEqualTo(14);
		
		for (Employee e : list) {
			System.out.println(e);
		}
	}
	
	//@Test
	public void findByTest() {
		// TODO: 사번으로 검색하는 매서드를 찾아서 단위 테스트 코드 작성.
		Optional<Employee> employee = empRepo.findById(7369);
		
		System.out.println(employee);
	}
	
	// TODO: DEPT 테이블과 매핑되는 엔터티 클래스를 설계, 리포지토리 인터페이스 작성(도메인, 인터페이스)
	// 단위 테스트 클래스 작성.
	@Test
	public void testd() {
		assertThat(deptRepo).isNull();
		log.info("***** deptRepo: {}", deptRepo);
	}

}
