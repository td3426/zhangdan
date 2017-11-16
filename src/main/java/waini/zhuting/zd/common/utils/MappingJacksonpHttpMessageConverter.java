package top.rreeff.common.utils;


import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Type;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;

/**
 * 兼容jsonp格式 供调试时使用
 * 
 * @author wuxundi@gz.iscas.ac.cn
 *
 */
public class MappingJacksonpHttpMessageConverter extends
		MappingJackson2HttpMessageConverter {

	private static final Logger logger = Logger
			.getLogger(MappingJacksonpHttpMessageConverter.class);

	/**
	 * 兼容参数不匹配的情况,就是多传了参数
	 */
	@Override
	public Object read(Type type, Class<?> contextClass,
			HttpInputMessage inputMessage) throws IOException,
			HttpMessageNotReadableException {
		try {
			return super.read(type, contextClass, inputMessage);
		} catch (HttpMessageNotReadableException e) {
			JavaType javaType = getJavaType(type, contextClass);
			String jsonString = StreamUtils.InputStreamTOString(inputMessage
					.getBody());
			logger.info("http json param: " + jsonString);
			return JSONObject.parseObject(jsonString, javaType.getRawClass());
		}
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		if (clazz.getName().equals("cn.jojo.common.web.common.util.Response")) {
			// 只接受m站定义的返回数据格式
			return super.canWrite(clazz, mediaType);
		} else {
			return false;
		}
	}

	@Override
	protected void writeInternal(Object object, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException {

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();

		String jsonpFunction = request.getParameter("callback");
		// 如果是以jsonp方式请求，则返回jsonp形式的数据
		if (StringUtils.isNotBlank(jsonpFunction)) {
			OutputStream out = outputMessage.getBody();
			String text = jsonpFunction + "(" + JacksonUtils.beanToJson(object)
					+ ")";
			byte[] bytes = text.getBytes("UTF-8");
			try {
				out.write(bytes);
				out.flush();
			} catch (Exception e) {
			}
		} else {
			super.writeInternal(object, outputMessage);
		}
	}

}
