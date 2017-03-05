package liuyan.youyin.pojo;

public class AdminUser {

	private int id;
	private String adminName;
	private String password;
	private int level;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "AdminUser [id=" + id + ", adminName=" + adminName
				+ ", password=" + password + ", level=" + level + "]";
	}
	
	
}
