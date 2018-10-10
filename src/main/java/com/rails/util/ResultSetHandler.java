package com.rails.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 反射获取实体
 * 
 * @author qiaodongjie
 * @date 2018年10月10日 上午9:27:10
 *
 */
public class ResultSetHandler {

	public static <T> List<T> getBeans(ResultSet resultSet, Class<T> className) {
		List<T> list = new ArrayList<T>();
		Field fields[] = className.getDeclaredFields();

		try {
			while (resultSet.next()) {
				T instance = className.newInstance();
				for (Field field : fields) {
					String underline = CamelToUnderLine.getUnderline(field.getName());
					Object result = resultSet.getObject(underline);
					boolean flag = field.isAccessible();
					field.setAccessible(true);
					field.set(instance, result);
					field.setAccessible(flag);
				}
				list.add(instance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return list;
	}
}
