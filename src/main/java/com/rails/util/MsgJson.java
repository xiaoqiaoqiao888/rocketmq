package com.rails.util;

import lombok.Data;

/**
 * 封装导入MQ实体
 * 
 * @author qiaodongjie
 * @date 2018年10月10日 上午9:35:30
 *
 */
@Data
public class MsgJson {
	private MessageRequest messageRequest;
	private String tags;
	private String topic;
	private String title;

}
