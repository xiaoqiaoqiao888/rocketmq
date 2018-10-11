package com.rails.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostgreSqlJDBC {
	private static Logger logger = LoggerFactory.getLogger(PostgreSqlJDBC.class);

	public static <T> List<T> getListT(String sql, Class<T> clazz) {
		Connection c = null;
		Statement stmt = null;
		List<T> beans = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel_db", "postgres", "postgres");
			c.setAutoCommit(false);
			logger.info("connection DBs success！");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			beans = ResultSetHandler.getBeans(rs, clazz);
			rs.close();
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		logger.info("select datas success！");
		return beans;
	}

}
