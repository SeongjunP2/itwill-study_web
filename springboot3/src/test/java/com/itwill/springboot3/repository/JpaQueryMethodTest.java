package com.itwill.springboot3.repository;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itwill.springboot3.domain.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class JpaQueryMethodTest {
	@Autowired
	private EmployeeRepository empRepo;
	
	@Test
	public void test() {
		List<Employee> list; 
//		list = empRepo.findByDepartmentId(30);
//		list = empRepo.findByFirstName("Steven");
//		list = empRepo.findByFirstNameContaining("te");
//		list = empRepo.findByFirstNameLike("%te%");
//		list = empRepo.findByFirstNameContainingIgnoreCase("Te");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrderByFirstNameDesc("TE");
//		list = empRepo.findBySalaryGreaterThan(10_000.0);
//		list = empRepo.findBySalaryLessThan(3000);
//		list = empRepo.findBySalaryBetween(3000, 4000);
//		list = empRepo.findByHireDateLessThan(LocalDate.of(2002, 12, 12));
//		list = empRepo.findByHireDateGreaterThan(LocalDate.of(2002, 12, 12));
//		list = empRepo.findByHireDateBetween(LocalDate.of(2002, 12, 12), LocalDate.of(2005, 12, 12));
//		list = empRepo.findByDepartmentDepartmentName("IT");
//		list = empRepo.findByDepartmentLocationCity("Seattle");
//		list = empRepo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase("te", "te");
//		list = empRepo.findByName("tE", "Te");
//		list = empRepo.findByName2("te");
//		list = empRepo.findByDeptName("IT");
//		list = empRepo.findByCity("Seattle");
//		list = empRepo.findByCountry("Canada");
		list = empRepo.findByRegion("Europe");
		
		list.forEach(System.out::println);
	}

}
