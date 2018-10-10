package com.rails.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BasePrice implements Serializable {
	private String hotelId;
	private Integer city;
	private Double basePrice;
	private String bizdate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	@Override
	public String toString() {
		return "hotelId:" + hotelId + ", city:" + city + ", basePrice:" + basePrice + ", bizdate:" + bizdate
				+ ", createTime:" + createTime + ", updateTime:" + updateTime;
	}

}
