package waini.zhuting.zd.common.utils;

/**
 * 存储处理结果
 * 自动转化为JSON对象
 * @author David
 *
 */
public class Response {
	private Response() {
		this.data=null;
	}

	//private static final Response single = new Response();

	public static Response getInstance() {
		Response single = new Response();
		single.data=null;
		return single;
	}
	
	private int  result=1; 
	Object error="";
	Object data=null;


	/**
	 * type:推送消息时区分消息类型
	 *  0: 一般结果
	 *  1:
	 *  2:
	 */
	int  type = 0; 
	
	/**
	 * 1 表示成功 ，默认值
	 * 0 表示出现错误
	 * @return
	 */
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public Object getError() {
		return error;
	}
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public int  getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Response success(){
		result=1;
		this.type= 200;
		this.data=null;
		this.error="";
		return this;
	}
	public Response success(Object data){
		result=1;
		this.type= 200;
		this.data=data;
		this.error="";
		return this;
	}
	public Response successButDeny(Object data){
		result = 0;
		this.type= 200;
		this.data=data;
		this.error="";
		return this;
	}
	public Response failure(Object msg){
		result=0;
		this.type = 401;
		this.error=msg;
		this.data="";
		return this;
	}
	public Response setParamError(){
		result = 0;
		this.type = 414;
		this.error = "请求失败";
		return this;
	}
	public Response setRightError(){
		result = 0;
		this.type = 403;
		this.error = "请求失败";
		return this;
	}
	public Response setInternalError(){
		result = 0;
		this.type = 500;
		this.error = "服务器异常";
		return this;
	}
	public Response setOKError(String msg){
		result=1;
		this.error=msg;
		this.data="";
		return this;
	}
}
