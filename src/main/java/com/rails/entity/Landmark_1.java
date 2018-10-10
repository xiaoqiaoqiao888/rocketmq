package com.rails.entity;

import lombok.Data;

@Data
public class Landmark_1 {
	private String landmarkCode;
	private String landmarkName;
	private Integer landmarkType;
	private String validFlag;
	private Integer cityCode;
	private String cityName;
	private Integer belongCode;
	private String belongName;
	private String hotFlag;
	private Double lng;
	private Double lat;
	private Integer priority;
	private String location;

}
