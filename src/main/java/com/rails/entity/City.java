package com.rails.entity;

import lombok.Data;

@Data
public class City {

	private Integer cityCode;
	private String cityName;
	private String cityNameEn;
	private String pinyin;
	private Integer priority;
	private String validFlag;
	private String suoXie;
	private Integer provinceCode;
	private String provinceName;
	private Integer countryCode;
	private String countryName;
	private String hotFlag;
	private Integer parentCityCode;
	private Double lng;
	private Double lat;
	private String location;

}
