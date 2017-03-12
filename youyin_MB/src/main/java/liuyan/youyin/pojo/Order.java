package liuyan.youyin.pojo;

public class Order {

	private Integer id;
	private String userName;
	private String address;
	private String machineID;
	private String picName;
	private String picPath;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMachineID() {
		return machineID;
	}
	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}
	
	public String getPicName() {
		return picName;
	}
	public void setPicName(String picName) {
		this.picName = picName;
	}

	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", userName=" + userName + ", address="
				+ address + ", machineID=" + machineID + ", picName=" + picName
				+ ", picAddress=" + picPath + "]";
	}
	
	public Order(String userName, String address, String machineID,
			String picName, String picAddress) {
		super();
		this.userName = userName;
		this.address = address;
		this.machineID = machineID;
		this.picName = picName;
		this.picPath = picAddress;
	}
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}


}
