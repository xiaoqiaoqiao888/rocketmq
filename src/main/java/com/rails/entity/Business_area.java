package com.rails.entity;

import lombok.Data;

@Data
public class Business_area {
	private Integer businessCode;
	private String businessName;
	private String shortName;
	private String priority;
	private String validFlag;
	private Integer cityCode;
	private String cityName;
	private String hotFlag;
	private Double lng;
	private Double lat;
	private String vaildFlag;
	private String location;

}
