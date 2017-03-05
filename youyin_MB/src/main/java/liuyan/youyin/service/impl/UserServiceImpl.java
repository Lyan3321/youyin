package liuyan.youyin.service.impl;

import liuyan.youyin.dao.Dao;
import liuyan.youyin.pojo.AdminUser;
import liuyan.youyin.service.UserService;

public class UserServiceImpl implements UserService {
	
	private Dao dao;
	
	@Override
	public AdminUser findUserInfo(String name, String password) {
		dao = new Dao();
		String sql = "SELECT id,adminname adminName,password,level from t_admin_info" + 
				" WHERE adminName = ? AND password = ?";
		return dao.get(AdminUser.class, sql, name,password);
	}

}
