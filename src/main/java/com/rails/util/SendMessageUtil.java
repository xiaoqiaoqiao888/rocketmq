package com.rails.util;

import java.util.List;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class SendMessageUtil {
	private static Logger logger = LoggerFactory.getLogger(SendMessageUtil.class);

	@SuppressWarnings("static-access")
	public static <T> void getT(List<T> list, DefaultMQProducer producer, String topic) {
		list.stream().forEach(e -> {
			MessageRequest messageRequest = new MessageRequest();
			JSONObject jsonObject = new JSONObject();
			String jsonStringe = jsonObject.toJSONString(e);
			messageRequest.setBody(jsonStringe);
			messageRequest.setRequest_id("");
			MsgJson msgJson = new MsgJson();
			msgJson.setMessageRequest(messageRequest);
			msgJson.setTags("*");
			msgJson.setTitle("酒店同步");
			msgJson.setTopic(topic);
			JSONObject JS = new JSONObject();
			String jsonString = JS.toJSONString(msgJson);
			// message必须指定topic,和消息体body，可以选择指定tag,key来进行细分message
			Message msgJ = new Message(topic, "*", jsonString.getBytes());
			SendResult result = null;
			try {
				result = producer.send(msgJ);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			logger.info("消息发送成功:id:" + result.getMsgId() + " result:" + result.getSendStatus());
		});
	}
}
