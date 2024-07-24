package com.itwill.springboot3.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor @Getter @ToString @EqualsAndHashCode
@Entity @Table(name = "COUNTRIES")
public class Country {
	
	@Id @Column(name = "COUNTRY_ID")
	private String id;
	
	private String countryName;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "REGION_id")
	private Region region;

}
