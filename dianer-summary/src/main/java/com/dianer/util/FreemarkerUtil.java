package com.dianer.util;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public class FreemarkerUtil {

	private Configuration conf; // 模版配置对象

    public Configuration getConf() {
        return conf;
    }

    public void setConf(Configuration conf) {
        this.conf = conf;
    }


	public String process(Map<String, Object> map, String temp) throws Exception {
		StringWriter out = new StringWriter();
		Template t = this.conf.getTemplate(temp + ".ftl"); // 创建模版对象
		t.process(map, out); // 在模版上执行插值操作，并输出到制定的输出流中
		return out.toString();
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