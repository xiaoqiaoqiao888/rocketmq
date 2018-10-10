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

	@Override
	public String toString() {
		return "{zoneCode=" + zoneCode + ", zoneName=" + zoneName + ", priority=" + priority + ", validFlag="
				+ validFlag + ", cityCode=" + cityCode + ", cityName=" + cityName + ", hotFlag=" + hotFlag
				+ ", vaildFlag=" + vaildFlag + "}";
	}

}
