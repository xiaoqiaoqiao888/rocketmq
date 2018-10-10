package com.rails.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 驼峰法转下划线
 * 
 * @param line
 *            源字符串
 * @return 转换后的字符串
 */
public class CamelToUnderLine {
	public static String getUnderline(String line) {
		if (line == null || "".equals(line)) {
			return "";
		}
		line = String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
		StringBuffer sb = new StringBuffer();
		Pattern pattern = Pattern.compile("[A-Z]([a-z\\d]+)?");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			String word = matcher.group();
			sb.append(word.toUpperCase());
			sb.append(matcher.end() == line.length() ? "" : "_");
		}
		return sb.toString();
	}
}
