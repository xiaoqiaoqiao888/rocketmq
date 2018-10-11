package com.rails.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Price {
	private String productPriceId;
	private String fromChannel;
	private String hotelId;
	private String productId;
	private Integer city;
	private String oldProductId;
	private String roomTypeId;
	private String oldRoomtypeId;
	private String activityId;
	private String oldActivityId;
	private String bizdate;
	private Double listingPrice;
	private Double salePrice;
	private Double purchasePrice;
	private Double minimumFloating;
	private Double maximumFloating;
	private Double commission;
	private Double commissionRate;
	private Double extrabedPrice;
	private Double doublePrice;
	private Double triplePrice;
	private Double quadPrice;
	private Double exchangeValue;
	private Double webScore;
	private Double burScore;
	private Double webCommission;
	private Double burCommission;
	private String feesRemark;
	private String isBreakFast;
	private Integer numberOfBreakfast;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date laterBookingTime;
	private String guaranteeCode;
	private String holdTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date starCancel;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endCancel;
	private Double forfeit;
	private String priceRemark;
	private Integer productRemain;
	private Integer productBooked;
	private String avstat;
	private String isInstantConfirm;
	private String validFlag;
	private String publishState;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date versionNo;
	private String nodeNum;
	private String flag1;
	private String flag2;
	private String flag3;
	private String flag4;
	private String flag5;
	private String flag6;
	private String flag7;
	private String flag8;
	private String flag9;
	private String flag10;

}
