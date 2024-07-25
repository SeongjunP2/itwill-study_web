package com.itwill.springboot3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Department;
import com.itwill.springboot3.repository.DepartmentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartmentService {
	private final DepartmentRepository deptRepo;
	
	@Transactional(readOnly = true)
	public Page<Department> read(int pageNo, Sort sort) {
		log.info("read(pageNo={}, sort={})", pageNo, sort);
		
		Pageable pageable = PageRequest.of(pageNo, 5, sort);
		
		Page<Department> page = deptRepo.findAll(pageable);
		log.info("hasPrevious = {}", page.hasPrevious()); // 이전 페이지가 있는 지 여부
		log.info("hasNext = {}", page.hasNext()); // 다음 페이지가 있는 지 여부
		log.info("getTotalPages = {}", page.getTotalPages()); // 전체 페이지 개수
		
		return page;
	}
	
	public Department readById(Integer id) {
		log.info("read", id);
		
		Department department = deptRepo.findById(id).orElseThrow();
		
		return department;
	}

}
