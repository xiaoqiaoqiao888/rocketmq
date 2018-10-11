package com.rails.util;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

import com.alibaba.fastjson.JSONObject;

public class SendMessageUtil {
	public static <T> void getT(List<T> list, DefaultMQProducer producer, String topic) {
		list.stream().forEach(e -> {
			MessageRequest messageRequest = new MessageRequest();
			JSONObject jsonObject = new JSONObject();
			@SuppressWarnings("static-access")
			String jsonStringe = jsonObject.toJSONString(e);
			messageRequest.setBody(jsonStringe);
			messageRequest.setRequest_id("");
			MsgJson msgJson = new MsgJson();
			msgJson.setMessageRequest(messageRequest);
			msgJson.setTags("*");
			msgJson.setTitle("酒店同步");
			msgJson.setTopic(topic);
			JSONObject JS = new JSONObject();
			@SuppressWarnings("static-access")
			String jsonString = JS.toJSONString(msgJson);
			// message必须指定topic,和消息体body，可以选择指定tag,key来进行细分message
			Message msgJ = new Message(topic, "*", jsonString.getBytes());
			SendResult result = null;
			try {
				result = producer.send(msgJ);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("消息发送成功:id:" + result.getMsgId() + " result:" + result.getSendStatus());
		});
	}
}
