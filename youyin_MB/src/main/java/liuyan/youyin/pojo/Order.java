package liuyan.youyin.pojo;

public class Order {

	private String orderID;
	private String userID;
	private String imageURL;
	private OrderStatus status;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Order(String orderID, String userID, String imageURL,
			OrderStatus status) {
		super();
		this.orderID = orderID;
		this.userID = userID;
		this.imageURL = imageURL;
		this.status = status;
	}
	
	public Order(){}
	
}
