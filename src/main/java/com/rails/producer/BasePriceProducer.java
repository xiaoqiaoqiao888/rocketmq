package com.rails.producer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.rails.entity.BasePrice;
import com.rails.util.MessageRequest;
import com.rails.util.MsgJson;
import com.rails.util.ResultSetHandler;

@Component
public class BasePriceProducer {

	public static void main(String[] args) throws Exception {
		// 生产者,可以指定producer集群
		DefaultMQProducer producer = new DefaultMQProducer("Hotel_12306_Consumer");
		// 设置name server的地址
		producer.setNamesrvAddr("127.0.0.1:9876");
		producer.start();
		System.out.println(producer.getNamesrvAddr());
		System.out.println(producer.getClientIP());
		System.out.println("启动了生产者producer");
		// message必须指定topic,和消息体body
		// 可以选择指定tag,key来进行细分message

		// Message msgA = new Message("Hotel_gt10_hotel_adapter",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgB = new Message("Hotel_gt10_business_area",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgC = new Message("Hotel_gt10_city",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgD = new Message("Hotel_gt10_landmark",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgE = new Message("Hotel_gt10_price_adapter",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgF = new Message("Hotel_gt10_product_adapter",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgG = new Message("Hotel_gt10_province",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgH = new Message("Hotel_gt10_room_type_adapter",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		// Message msgI = new Message("Hotel_gt10_zone",
		// "".getBytes(RemotingHelper.DEFAULT_CHARSET));
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel_db", "postgres", "postgres");
			c.setAutoCommit(false);
			System.out.println("连接数据库成功！");
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from gt10_base_price ");
			List<BasePrice> basePrices = ResultSetHandler.getBeans(rs, BasePrice.class);

			basePrices.stream().forEach(e -> {
				MessageRequest basePriceMr = new MessageRequest();
				JSONObject basePriceJsonObject = new JSONObject();
				@SuppressWarnings("static-access")
				String jsonStringe = basePriceJsonObject.toJSONString(e);
				basePriceMr.setBody(jsonStringe);
				basePriceMr.setRequest_id("");
				MsgJson msgJson = new MsgJson();
				msgJson.setMessageRequest(basePriceMr);
				msgJson.setTags("*");
				msgJson.setTitle("酒店同步");
				msgJson.setTopic("Hotel_gt10_base_price");
				JSONObject JS = new JSONObject();
				@SuppressWarnings("static-access")
				String jsonString = JS.toJSONString(msgJson);
				Message msgJ = new Message("Hotel_gt10_base_price", "*", jsonString.getBytes());
				SendResult result = null;
				try {
					result = producer.send(msgJ);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				System.out.println("消息发送成功:id:" + result.getMsgId() + " result:" + result.getSendStatus());
			});
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
