package com.rails.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import com.rails.entity.BasePrice;

public class PostgreSqlJdbcConnSelectDatas {
	public static void main(String args[]) {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel_db", "postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("连接数据库成功！");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gt10_base_price ");
			while (rs.next()) {
				String hotelId = rs.getString("hotel_id");
				Integer city = rs.getInt("city");
				Double basePrice = rs.getDouble("base_price");
				String bizdate = rs.getString("bizdate");
				Timestamp createTime = rs.getTimestamp("create_time");
				Timestamp updateTime = rs.getTimestamp("update_time");

				BasePrice basePrice2 = new BasePrice();
				basePrice2.setHotelId(hotelId);
				basePrice2.setCity(city);
				basePrice2.setBasePrice(basePrice);
				basePrice2.setBizdate(bizdate);
				basePrice2.setCreateTime(createTime);
				basePrice2.setUpdateTime(updateTime);
				System.out.println(basePrice2);
			}
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("查询数据成功！");
	}

}
