package com.rails.entity;

import java.util.List;

import lombok.Data;

@Data
public class RoomType {

	private String hotelId;
	private String roomTypeAdapterId;
	private Integer city;
	private String roomName;
	private String feature;
	private String introductions;
	private Integer roomTypeNum;
	private String bedDetail;
	private String bedDetailAdd;
	private String capacity;
	private String capacityExtend;
	private String storeyNum;
	private String storeyTotal;
	private String roomArea;
	private String kuandaiDetail;
	private String smokelessDetail;
	private String winDetail;
	private String breakfastDetail;
	private String toiletDetail;
	private List<RoomFacilitys> roomFacilitys;
	private String flag1;
	private String flag2;
	private String flag3;
	private String flag4;
	private String flag5;

}
