package com.rails.util;

import java.io.Serializable;

import lombok.Data;

/**
 * 封装导入MQ实体
 * 
 * @author qiaodongjie
 * @date 2018年10月10日 上午9:35:30
 *
 */
@Data
public class MsgJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageRequest messageRequest;
	private String tags;
	private String topic;
	private String title;

	@Override
	public String toString() {
		return "MsgJson {" + messageRequest + " ,tags=" + tags + ", topic=" + topic + ", title=" + title + "}";
	}
}
