package top.rreeff.common.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import org.springframework.http.converter.json.MappingJacksonValue;

import net.sf.json.JSONObject;


public class ResponseJsonp {
	
	/*private HttpServletRequest request;
	private HttpServletResponse response;
	
	public static ResponseJsonp getInstance(HttpServletRequest req, HttpServletResponse res) {
		single.request = req;
		single.response = res;
		return single;
	}*/
	
	
	/*public void callBack(Response retVal){
		String dataContent = JSONObject.fromObject(retVal).toString();
		String callback = request.getParameter("callback");  
        callback = callback == null ? "" : callback;  
        response.setContentType("application/x-javascript");  
        response.setCharacterEncoding("UTF-8");  
        response.setHeader("P3P", "CP=CURa ADMa DEVa PSAo PSDo OUR BUS UNI PUR INT DEM STA PRE COM NAV OTC NOI DSP COR");  
        try {  
            PrintWriter out = response.getWriter();  
            if(callback.equals("")){  
                out.write(dataContent);   
            }else{  
                out.write(callback+ "("+ dataContent +");");   
            }  
            out.flush();  
            out.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
	}*/
	public static  Object callBack(String callback,Response retVal){
		//String callback = req.getParameter("callback");  
        MappingJacksonValue json = new MappingJacksonValue(retVal);
        json.setJsonpFunction(callback);
        return json;
	}
}
