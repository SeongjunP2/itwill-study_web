package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Location;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class LocationRepositoryTest {
	
	@Autowired
	private LocationRepository locRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(locRepo).isNotNull();
		log.info("locRepo={}", locRepo);
	}
	
//	@Test
	public void testFindAll() {
		long count = locRepo.count();
		assertThat(count).isEqualTo(23L);
	}
	
	@Transactional
	@Test
	public void testFindById() {
		Location loc = locRepo.findById(1000).orElseThrow();
		
		log.info("loc={}", loc);
		log.info("loc.country={}", loc.getCountry());
	}

}
