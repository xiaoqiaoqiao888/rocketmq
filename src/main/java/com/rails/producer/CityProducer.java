package com.rails.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rails.entity.City;
import com.rails.util.PostgreSqlJDBC;
import com.rails.util.SendMessageUtil;

public class CityProducer {
	private static Logger logger = LoggerFactory.getLogger(CityProducer.class);

	public static void main(String[] args) throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		logger.info("start producer");
		String sql = "select * from gt10_city ";
		List<City> list = PostgreSqlJDBC.getListT(sql, City.class);
		logger.info("查询的数据总条数为：" + list.size());
		// 发送消息
		SendMessageUtil.getT(list, producer, "Hotel_gt10_city");
	}
}
