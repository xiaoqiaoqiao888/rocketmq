package com.rails.producer;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;

import com.rails.entity.RoomType;
import com.rails.util.PostgreSqlJDBC;
import com.rails.util.SendMessageUtil;

public class RoomTypeProducer {

	public static void main(String[] args) throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		System.out.println(producer.getNamesrvAddr());
		System.out.println(producer.getClientIP());
		System.out.println("start producer");
		String sql = "select * from gt10_room_type_adapter ";
		List<RoomType> list = PostgreSqlJDBC.getListT(sql, RoomType.class);
		System.out.println("查询的数据总条数为：" + list.size());
		// 发送消息
		SendMessageUtil.getT(list, producer, "Hotel_gt10_room_type_adapter");
	}
}
