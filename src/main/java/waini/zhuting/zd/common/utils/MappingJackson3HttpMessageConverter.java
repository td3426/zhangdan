package top.rreeff.common.utils;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;

/**
 * 为了兼容参数不匹配的情况重写转换方法
 * 
 * @author wuxundi@gz.iscas.ac.cn
 *
 */
public class MappingJackson3HttpMessageConverter extends
		MappingJackson2HttpMessageConverter {

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
			return JSONObject.parseObject(
					StreamUtils.InputStreamTOString(inputMessage.getBody()),
					javaType.getRawClass());
		}
	}

}
