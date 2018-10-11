package com.rails.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

import com.rails.entity.BasePrice;
import com.rails.util.PostgreSqlJDBC;
import com.rails.util.SendMessageUtil;

public class BasePriceProducer {

	public static void main(String[] args) throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		System.out.println(producer.getNamesrvAddr());
		System.out.println(producer.getClientIP());
		System.out.println("start producer");
		String sql = "select * from gt10_base_price ";
		List<BasePrice> list = PostgreSqlJDBC.getListT(sql, BasePrice.class);
		System.out.println("查询的数据总条数为：" + list.size());
		// 发送消息
		SendMessageUtil.getT(list, producer, "Hotel_gt10_base_price");
	}
}
