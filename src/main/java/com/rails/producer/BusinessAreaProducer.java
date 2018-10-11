package com.rails.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rails.entity.BusinessArea;
import com.rails.util.PostgreSqlJDBC;
import com.rails.util.SendMessageUtil;

public class BusinessAreaProducer {
	private static Logger logger = LoggerFactory.getLogger(BusinessAreaProducer.class);

	public static void main(String[] args) throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		logger.info("start producer");
		String sql = "select * from gt10_business_area ";
		List<BusinessArea> list = PostgreSqlJDBC.getListT(sql, BusinessArea.class);
		logger.info("查询的数据总条数为：" + list.size());
		// 发送消息
		SendMessageUtil.getT(list, producer, "Hotel_gt10_business_area");
	}
}
