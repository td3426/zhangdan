package top.rreeff.topUpQuery.pojo.link;

import top.rreeff.common.db.impl.PageCond;

/**
 * TTopupRecord 数据传输类
 * @author 何显宝 @QQ 69974879 @tel 15579748073
 * @Email td3426@foxmail.com
 * @date 2017-04-15 11:03:55
 * @version 1.0
 */
public class TopupRecordParam extends PageCond implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private long date;
	private String channel;
	private String stage;
	private int money;

	/** setter and getter method */
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setDate(long date){
		this.date = date;
	}
	public long getDate(){
		return this.date;
	}
	public void setChannel(String channel){
		this.channel = channel;
	}
	public String getChannel(){
		return this.channel;
	}
	public void setStage(String stage){
		this.stage = stage;
	}
	public String getStage(){
		return this.stage;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return this.money;
	}

}