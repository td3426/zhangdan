package waini.zhuting.zd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import waini.zhuting.zd.dao.IUserDao;
import waini.zhuting.zd.pojo.User;
import waini.zhuting.zd.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Resource
	private IUserDao userDao;
	@Override
	public User getUserById(int i) {
		User user = userDao.getgetUserById(i);
		return user;
	}

}
