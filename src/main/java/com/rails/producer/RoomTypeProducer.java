package com.rails.producer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rails.entity.RoomFacilitys;
import com.rails.entity.RoomType;
import com.rails.util.CamelUnderLineTransfor;
import com.rails.util.SendMessageUtil;

public class RoomTypeProducer {
	private static Logger logger = LoggerFactory.getLogger(RoomTypeProducer.class);

	public static void main(String[] args) throws Exception {
		Connection c = null;
		Statement stmt = null;
		List<RoomType> list = null;
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		logger.info("start producer");
		String sql = "select * from gt10_room_type_adapter ";
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
				RoomType roomType = new RoomType();
				for (int i = 1; i <= columnCount; i++) {
					List<RoomFacilitys> javaList = null;
					rowData.put(CamelUnderLineTransfor.getCamel(md.getColumnName(i), true), rs.getObject(i));
					if ("roomFacilitys".equals(CamelUnderLineTransfor.getCamel(md.getColumnName(i), true))) {
						Object object = rowData.get("roomFacilitys");
						JSONObject js = new JSONObject();

						@SuppressWarnings("static-access")
						JSONArray parseArray = js.parseArray(object.toString());
						javaList = parseArray.toJavaList(RoomFacilitys.class);
						roomType.setRoomFacilitys(javaList);
					}
					roomType.setHotelId((String) rowData.get("hotelId"));
					roomType.setRoomTypeAdapterId((String) rowData.get("roomTypeAdapterId"));
					roomType.setCity((Integer) rowData.get("city"));
					roomType.setRoomName((String) rowData.get("roomName"));
					roomType.setFeature((String) rowData.get("feature"));
					roomType.setIntroductions((String) rowData.get("introductions"));
					roomType.setRoomTypeNum((Integer) rowData.get("roomTypeNum"));
					roomType.setBedDetail((String) rowData.get("bedDetail"));
					roomType.setBedDetailAdd((String) rowData.get("bedDetailAdd"));
					roomType.setCapacity((String) rowData.get("capacity"));
					roomType.setCapacityExtend((String) rowData.get("capacityExtend"));
					roomType.setStoreyNum((String) rowData.get("storeyNum"));
					roomType.setStoreyTotal((String) rowData.get("storeyTotal"));
					roomType.setRoomArea((String) rowData.get("roomArea"));
					roomType.setKuandaiDetail((String) rowData.get("kuandaiDetail"));
					roomType.setSmokelessDetail((String) rowData.get("smokelessDetail"));
					roomType.setWinDetail((String) rowData.get("winDetail"));
					roomType.setBreakfastDetail((String) rowData.get("breakfastDetail"));
					roomType.setToiletDetail((String) rowData.get("toiletDetail"));
					roomType.setFlag1((String) rowData.get("flag1"));
					roomType.setFlag2((String) rowData.get("flag2"));
					roomType.setFlag3((String) rowData.get("flag3"));
					roomType.setFlag4((String) rowData.get("flag4"));
					roomType.setFlag5((String) rowData.get("flag5"));
				}
				list.add(roomType);
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
		SendMessageUtil.getT(list, producer, "Hotel_gt10_room_type_adapter");
	}
}
