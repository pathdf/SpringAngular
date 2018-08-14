package com.pankaj.util;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;

import com.pankaj.bean.LabelValueBean;

@Component("jsonResponseWriterUtil")
public class JSONResponseWriterUtil {

	@Autowired
	private JSONUtil jsonUtil;

	private static Log log = LogFactory.getLog(JSONResponseWriterUtil.class);

	public void writeResponse(HttpServletResponse response,
			Map<String, Object> jsonMap) {
		try {
			String jsonString = jsonUtil.writeJsonString(jsonMap);
			AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();

			MediaType mimeType = new MediaType("text", "html",
					Charset.forName("UTF-8"));

			if (stringHttpMessageConverter.canWrite(String.class, mimeType)) {
				stringHttpMessageConverter.write(jsonString, mimeType,
						new ServletServerHttpResponse(response));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	public void writeJSONResponse(HttpServletResponse response,
			Object returnValue) {
		try {
			String jsonString = jsonUtil.writeJsonString(returnValue);
			AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();

			MediaType mimeType = new MediaType("application", "json",
					Charset.forName("UTF-8"));

			if (stringHttpMessageConverter.canWrite(String.class, mimeType)) {
				stringHttpMessageConverter.write(jsonString, mimeType,
						new ServletServerHttpResponse(response));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
	
	
	public void writeListJSONResponse(HttpServletResponse response,
			List<LabelValueBean> returnValue) {
		try {
			String jsonString = jsonUtil.writeJsonString(returnValue);
			AbstractHttpMessageConverter<String> stringHttpMessageConverter = new StringHttpMessageConverter();

			MediaType mimeType = new MediaType("application", "json",
					Charset.forName("UTF-8"));

			if (stringHttpMessageConverter.canWrite(String.class, mimeType)) {
				stringHttpMessageConverter.write(jsonString, mimeType,
						new ServletServerHttpResponse(response));
			}
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}
	
	
	
}
