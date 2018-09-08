package com.rails.consumer;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

@Component
public class Consumer2 {

	public static void main(String[] args) throws Exception {
		// 定义消费者,可以指定消费集群
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer_group_name");
		// 同样的,指定name server 的地址
		consumer.setNamesrvAddr("127.0.0.1:9876");

		/*
		 * //订阅topicA下的所有消息 consumer.subscribe("topicA","*"); //一个consumer可以订阅多个topic
		 * consumer.subscribe("topicB","*");
		 */

		consumer.subscribe("topicC", "tag-a");

		// 程序第一次启动从消息队列头取数据
		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
		// 注册订阅消息
		consumer.registerMessageListener(new MessageListenerConcurrently() {
			@Override
			public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext Context) {
				MessageExt msg = list.get(0);
				try {
					System.out.println(new Date() + "-收到消息:id-" + msg.getMsgId() + ","
							+ new String(msg.getBody(), "UTF-8") + "," + "keys: " + msg.getKeys());
					System.out.println("msg全部信息:" + msg.toString());

				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
			}
		});
		consumer.start();
		System.out.println("consumer消费者启动");
		while (true) {

		}
	}

}
