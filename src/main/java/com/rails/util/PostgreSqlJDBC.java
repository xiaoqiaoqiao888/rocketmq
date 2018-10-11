package com.rails.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PostgreSqlJDBC {
	public static <T> List<T> getListT(String sql, Class<T> clazz) {
		Connection c = null;
		Statement stmt = null;
		List<T> beans = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel_db", "postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("connection DBs success！");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			beans = ResultSetHandler.getBeans(rs, clazz);
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("select datas success！");
		return beans;
	}

}
