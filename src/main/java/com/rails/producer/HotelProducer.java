package com.rails.producer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rails.entity.Hotel;
import com.rails.entity.HotelFacility;
import com.rails.entity.HotelPolicy;
import com.rails.util.CamelUnderLineTransfor;
import com.rails.util.SendMessageUtil;

public class HotelProducer {
	private static Logger logger = LoggerFactory.getLogger(HotelProducer.class);

	public static void main(String[] args) throws Exception {
		Connection c = null;
		Statement stmt = null;
		List<Hotel> list = null;
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		logger.info("start producer");
		String sql = "select * from gt10_hotel_adapter ";
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel_db", "postgres", "postgres");
			c.setAutoCommit(false);
			logger.info("connection DBs success！");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			list = new ArrayList<>();
			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> rowData = new HashMap<String, Object>();
				Hotel hotel = new Hotel();
				for (int i = 1; i <= columnCount; i++) {
					List<HotelPolicy> hotelPolicyList = null;
					List<HotelFacility> hotelFacilityList = null;
					rowData.put(CamelUnderLineTransfor.getCamel(md.getColumnName(i), true), rs.getObject(i));
					if ("hotelPolicy".equals(CamelUnderLineTransfor.getCamel(md.getColumnName(i), true))) {
						Object object = rowData.get("hotelPolicy");
						JSONObject js = new JSONObject();

						@SuppressWarnings("static-access")
						JSONArray parseArray = js.parseArray(object.toString());
						hotelPolicyList = parseArray.toJavaList(HotelPolicy.class);
						hotel.setHotelPolicy(hotelPolicyList);
					}
					if ("hotelFacility".equals(CamelUnderLineTransfor.getCamel(md.getColumnName(i), true))) {
						Object object = rowData.get("hotelFacility");
						JSONObject js = new JSONObject();

						@SuppressWarnings("static-access")
						JSONArray parseArray = js.parseArray(object.toString());
						hotelFacilityList = parseArray.toJavaList(HotelFacility.class);
						hotel.setHotelFacility(hotelFacilityList);
					}
					hotel.setHotelId((String) rowData.get("hotelId"));
					hotel.setOldHotelId((String) rowData.get("oldHotelId"));
					hotel.setHotelName((String) rowData.get("hotelName"));
					hotel.setHotelNameEn((String) rowData.get("hotelNameEn"));
					hotel.setHotelGroup((String) rowData.get("hotelGroup"));
					hotel.setCompanyType((String) rowData.get("companyType"));
					hotel.setFromChannel((String) rowData.get("fromChannel"));
					hotel.setHotelClass1((String) rowData.get("hotelClass1"));
					hotel.setHotelClass2((String) rowData.get("hotelClass2"));
					hotel.setHotelClass2Name((String) rowData.get("hotelClass2Name"));
					hotel.setOldHotelClass((String) rowData.get("oldHotelClass"));
					hotel.setStarLevel((String) rowData.get("starLevel"));
					hotel.setOldStarLevel((String) rowData.get("oldStarLevel"));
					hotel.setChainBrand((String) rowData.get("chainBrand"));
					hotel.setChainBrandName((String) rowData.get("chainBrandName"));
					hotel.setOldChainBrand((String) rowData.get("oldChainBrand"));
					hotel.setOldChainBrandName((String) rowData.get("oldChainBrandName"));
					hotel.setIsOnlineSignUp((String) rowData.get("isOnlineSignUp"));
					hotel.setAddress((String) rowData.get("address"));
					hotel.setTel((String) rowData.get("tel"));
					hotel.setEmail((String) rowData.get("email"));
					hotel.setFax((String) rowData.get("fax"));
					hotel.setLinkman((String) rowData.get("linkman"));
					hotel.setLinkmanPhone((String) rowData.get("linkmanPhone"));
					hotel.setLinkmanOther((String) rowData.get("linkmanOther"));
					hotel.setPriority((Integer) rowData.get("priority"));
					hotel.setLongitude((Double) rowData.get("longitude"));
					hotel.setLatitude((Double) rowData.get("latitude"));
					hotel.setCountry((Integer) rowData.get("country"));
					hotel.setCountryName((String) rowData.get("countryName"));
					hotel.setOldCountry((String) rowData.get("oldCountry"));
					hotel.setOldCountryName((String) rowData.get("oldCountryName"));
					hotel.setProvince((Integer) rowData.get("province"));
					hotel.setProvinceName((String) rowData.get("provinceName"));
					hotel.setOldProvince((String) rowData.get("oldProvince"));
					hotel.setOldProvinceName((String) rowData.get("oldProvinceName"));
					hotel.setCity((Integer) rowData.get("city"));
					hotel.setCityName((String) rowData.get("cityName"));
					hotel.setOldCity((String) rowData.get("oldCity"));
					hotel.setOldCityName((String) rowData.get("oldCityName"));
					hotel.setCountyCode((String) rowData.get("countyCode"));
					hotel.setCountyName((String) rowData.get("countyName"));
					hotel.setOldCountyCode((String) rowData.get("oldCountyCode"));
					hotel.setOldCountyName((String) rowData.get("oldCountyName"));
					hotel.setLandmark((String) rowData.get("landmark"));
					hotel.setLandmarkName((String) rowData.get("landmarkName"));
					hotel.setOldLandmark((String) rowData.get("oldLandmark"));
					hotel.setOldLandmarkName((String) rowData.get("oldLandmarkName"));
					hotel.setBusinessArea((String) rowData.get("businessArea"));
					hotel.setBusinessAreaName((String) rowData.get("businessAreaName"));
					hotel.setOldBusinessArea((String) rowData.get("oldBusinessArea"));
					hotel.setOldBusinessAreaName((String) rowData.get("oldBusinessAreaName"));
					hotel.setAnnouncement((String) rowData.get("announcement"));
					hotel.setIntroduction((String) rowData.get("introduction"));
					hotel.setSetupYear((String) rowData.get("setupYear"));
					hotel.setDecorateYear((String) rowData.get("decorateYear"));
					hotel.setTags((String) rowData.get("tags"));
					hotel.setHotelTips((String) rowData.get("hotelTips"));
					hotel.setSupportCard((String) rowData.get("supportCard"));
					hotel.setSupportCurrency((String) rowData.get("supportCurrency"));
					hotel.setForeignGuests((String) rowData.get("foreignGuests"));
					hotel.setIsSmokeless((String) rowData.get("isSmokeless"));
					hotel.setDawnFlag((String) rowData.get("dawnFlag"));
					hotel.setReceiptFlag((String) rowData.get("receiptFlag"));
					hotel.setExamineType((String) rowData.get("examineType"));
					hotel.setHotelState((String) rowData.get("hotelState"));
					hotel.setValidFlag((String) rowData.get("validFlag"));
					hotel.setCreateTime((Date) rowData.get("createTime"));
					hotel.setVersionNo((Date) rowData.get("versionNo"));
					hotel.setIntroductionVector((String) rowData.get("introductionVector"));
					hotel.setHotelScore((Double) rowData.get("hotelScore"));
					hotel.setLatestOrderTime((Date) rowData.get("latestOrderTime"));
					hotel.setBelongComp1((String) rowData.get("belongComp1"));
					hotel.setBelongComp2((String) rowData.get("belongComp2"));
					hotel.setNodeNum((String) rowData.get("flag1"));
					hotel.setHotelFlag1((String) rowData.get("flag1"));
					hotel.setHotelFlag2((String) rowData.get("flag2"));
					hotel.setHotelFlag3((String) rowData.get("flag3"));
					hotel.setHotelFlag4((String) rowData.get("flag4"));
					hotel.setHotelFlag5((String) rowData.get("flag5"));
					hotel.setHotelFlag6((String) rowData.get("flag6"));
					hotel.setHotelFlag7((String) rowData.get("flag7"));
					hotel.setHotelFlag8((String) rowData.get("flag8"));
					hotel.setHotelFlag9((String) rowData.get("flag9"));
					hotel.setHotelFlag10((String) rowData.get("flag10"));
				}
				list.add(hotel);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		logger.info("查询的数据总条数为：" + list.size());
		// 发送消息
		SendMessageUtil.getT(list, producer, "Hotel_gt10_hotel_adapter");
	}
}
