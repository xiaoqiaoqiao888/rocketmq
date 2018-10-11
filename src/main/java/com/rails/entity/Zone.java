package com.rails.entity;

import lombok.Data;

@Data
public class Zone {
	private Integer zoneCode;
	private String zoneName;
	private String priority;
	private String validFlag;
	private Integer cityCode;
	private String cityName;
	private String hotFlag;
	private String vaildFlag;

}
