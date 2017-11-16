package top.rreeff.common.utils;


import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by donghua on 16/1/12.
 */
public class JacksonUtils {

    private static ObjectMapper mapper;

    public static String beanToJson(Object obj) throws IOException {
        // 这里异常都未进行处理，而且流的关闭也不规范。开发中请勿这样写，如果发生异常流关闭不了
        ObjectMapper mapper = getMapperInstance(false);
        StringWriter writer = new StringWriter();
        JsonGenerator gen = new JsonFactory().createJsonGenerator(writer);
        mapper.writeValue(gen, obj);
        gen.close();
        String json = writer.toString();
        writer.close();
        return json;
    }

    private static synchronized ObjectMapper getMapperInstance(boolean createNew) {
        if (createNew) {
            return new ObjectMapper();
        } else if (mapper == null) {
            mapper = new ObjectMapper();
        }

        return mapper;
    }
}
