package com.itwill.springboot3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.springboot3.domain.Job;
import com.itwill.springboot3.repository.JobRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class JobService {
	private final JobRepository jobRepo;
	
	public List<Job> read() {
		log.info("read()");
		
		return jobRepo.findAll();
	}
	
	public Job readById(String id) {
		log.info("read", id);
		
		return jobRepo.findById(id).orElseThrow();
	}

}
