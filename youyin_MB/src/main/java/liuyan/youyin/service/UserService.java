package liuyan.youyin.service;

import liuyan.youyin.pojo.AdminUser;

public interface UserService {

	public AdminUser findUserInfo(String name,String password);
}
