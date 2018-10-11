package com.rails.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class Hotel implements Serializable {
	private String hotelId;
	private String oldHotelId;
	private String hotelName;
	private String hotelNameEn;
	private String hotelGroup;
	private String companyType;
	private String fromChannel;
	private String hotelClass1;
	private String hotelClass2;
	private String hotelClass2Name;
	private String oldHotelClass;
	private String starLevel;
	private String oldStarLevel;
	private String chainBrand;
	private String chainBrandName;
	private String oldChainBrand;
	private String oldChainBrandName;
	private String isOnlineSignUp;
	private String address;
	private String tel;
	private String email;
	private String fax;
	private String linkman;
	private String linkmanPhone;
	private String linkmanOther;
	private Integer priority;
	private Double longitude;
	private Double latitude;
	private Integer country;
	private String countryName;
	private String oldCountry;
	private String oldCountryName;
	private Integer province;
	private String provinceName;
	private String oldProvince;
	private String oldProvinceName;
	private Integer city;
	private String cityName;
	private String oldCity;
	private String oldCityName;
	private String countyCode;
	private String countyName;
	private String oldCountyCode;
	private String oldCountyName;
	private String landmark;
	private String landmarkName;
	private String oldLandmark;
	private String oldLandmarkName;
	private String businessArea;
	private String businessAreaName;
	private String oldBusinessArea;
	private String oldBusinessAreaName;
	private String announcement;
	private String introduction;
	private String setupYear;
	private String decorateYear;
	private List<HotelPolicy> hotelPolicy;
	private List<HotelFacility> hotelFacility;
	private String tags;
	private String hotelTips;
	private String supportCard;
	private String supportCurrency;
	private String foreignGuests;
	private String isSmokeless;
	private String dawnFlag;
	private String receiptFlag;
	private String examineType;
	private String hotelState;
	private String validFlag;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date versionNo;
	private String introductionVector;
	private Double hotelScore;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS", timezone = "GMT+8")
	private Date latestOrderTime;
	private String belongComp1;
	private String belongComp2;
	private String nodeNum;
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