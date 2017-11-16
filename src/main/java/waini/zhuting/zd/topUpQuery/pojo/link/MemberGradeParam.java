package top.rreeff.topUpQuery.pojo.link;

import top.rreeff.common.db.impl.PageCond;

/**
 * TMemberGrade 数据传输类
 * @author 何显宝 @QQ 69974879 @tel 15579748073
 * @Email td3426@foxmail.com
 * @date 2017-04-14 16:05:23
 * @version 1.0
 */
public class MemberGradeParam extends PageCond implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private int grade;
	private int money;

	/** setter and getter method */
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setGrade(int grade){
		this.grade = grade;
	}
	public int getGrade(){
		return this.grade;
	}
	public void setMoney(int money){
		this.money = money;
	}
	public int getMoney(){
		return this.money;
	}

}