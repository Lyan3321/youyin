package youyin_MB;

import java.util.List;

import liuyan.youyin.dao.Dao;
import liuyan.youyin.pojo.AdminUser;

import org.apache.log4j.Logger;
import org.junit.Test;

public class DaoTest {

	Dao dao = new Dao();
	
	@Test
	public void testDao() {
		String sql = "SELECT id,adminname adminName,password,level from t_admin_info" + 
					" WHERE adminName = ? AND password = ?";
		AdminUser adminUser = dao.get(AdminUser.class, sql, "liuyan","123456");
		System.out.println(adminUser);
	}
	
	@Test
	public void testLog4j(){
		Logger logger = Logger.getLogger(DaoTest.class);
		
		logger.debug("This is debug message");
		
		logger.info("This is info message");
		
		logger.error("This is error message");
	}
	
	@Test
	public void testDaoList(){
		String sql = "SELECT id,adminname adminName,password,level from t_admin_info";
		List<AdminUser> adminUserList = dao.getForList(AdminUser.class, sql);
		System.out.println(adminUserList);
	}

}
