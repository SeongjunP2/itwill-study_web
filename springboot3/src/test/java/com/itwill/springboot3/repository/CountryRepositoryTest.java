package com.itwill.springboot3.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.springboot3.domain.Country;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class CountryRepositoryTest {
	
	@Autowired
	private CountryRepository countryRepo;
	
//	@Test
	public void testDependencyInjection() {
		assertThat(countryRepo).isNotNull();
		log.info("locRepo={}", countryRepo);
	}
	
	@Test
	public void testFindAll() {
		long count = countryRepo.count();
		assertThat(count).isEqualTo(25L);
	}
	
	@Transactional
	@Test
	public void testFindById() {
		Country country = countryRepo.findById("AR").orElseThrow();
		
		log.info("country={}", country);
		log.info("country.regionId={}", country.getRegionId());
	}

}
