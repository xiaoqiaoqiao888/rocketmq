package com.rails.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

import com.rails.entity.Hotel;
import com.rails.util.PostgreSqlJDBC;
import com.rails.util.SendMessageUtil;

public class HotelProducer {

	public static void main() throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		System.out.println(producer.getNamesrvAddr());
		System.out.println(producer.getClientIP());
		System.out.println("start producer");
		String sql = "select * from gt10_hotel_adapter ";
		List<Hotel> list = PostgreSqlJDBC.getListT(sql, Hotel.class);
		System.out.println("查询的数据总条数为：" + list.size());
		// 发送消息
		System.out.println(list);
		SendMessageUtil.getT(list, producer, "Hotel_gt10_hotel_adapter");
	}
}
