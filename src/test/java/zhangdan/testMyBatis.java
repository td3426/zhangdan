package zhangdan;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import waini.zhuting.zd.pojo.User;
import waini.zhuting.zd.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class testMyBatis {
	
	private static Logger logger = Logger.getLogger(testMyBatis.class);
	
	@Resource
	private IUserService userService;
	@Test
	public void test() {
		User user = userService.getUserById(1);
		System.out.println(user.toString());
	}
}
