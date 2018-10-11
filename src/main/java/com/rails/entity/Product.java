package com.rails.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Product {
	private String productId;
	private String oldProductId;
	private String productName;
	private Integer city;
	private String supplierId;
	private String supplierName;
	private String vendorId;
	private String vendorName;
	private Integer priority;
	private String fromChannel;
	private String hotelId;
	private String oldHotelOutid;
	private String roomTypeId;
	private String roomTypeName;
	private String oldRoomTypeId;
	private String oldRoomTypeName;
	private String oldRoomTypeId1;
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
	private Integer applicability;
	private String applicabilityDetail;
	private String payWay;
	private String payCanChange;
	private String lineChannel;
	private String isSupported;
	private Double depositRatio;
	private String receiptFlag;
	private String isSpecialInvoice;
	private String isHourlyRoom;
	private String isConnection;
	private String isAgency;
	private String receiveTextRemark;
	private String stockSaleFlag;
	private String examineType;
	private String productState;
	private String validFlag;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date versionNo;
	private String exchangeFlag;
	private String integralFlag;
	private String hotelFlag1;
	private String hotelFlag2;
	private String hotelFlag3;
	private String hotelFlag4;
	private String hotelFlag5;
	private String hotelFlag6;
	private String hotelFlag7;
	private String hotelFlag8;
	private String hotelFlag9;
	private String hotelFlag10;

}
