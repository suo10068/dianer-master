package com.dianer.test;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class FreemarkerUtil {

	private Configuration cfg; // 模版配置对象

	public String process(Map<String, Object> map, String temp) throws Exception {
		StringWriter out = new StringWriter();
		// 创建模版对象
		Template t = cfg.getTemplate(temp + ".ftl");
		// 在模版上执行插值操作，并输出到制定的输出流中
		t.process(map, out);
		return out.toString();
	}

	public Configuration getCfg() {
		return cfg;
	}

	public void setCfg(Configuration cfg) {
		this.cfg = cfg;
	}
	
	public String toFixedLength(String str, int length, String filler,String coding) {
		byte[] ret = new byte[length];
		try {
			byte[] b = str.getBytes(coding);
			byte[] z_zero = filler.getBytes(coding);
			for (int i = 0; i < length; i++) {
				if (i < length - b.length)
					ret[i] = z_zero[0];
				else {
					ret[i] = b[(i - (length - b.length))];
				}
			}
			return new String(ret, coding);
		} catch (UnsupportedEncodingException e) {

		}
		return str;
	}

}