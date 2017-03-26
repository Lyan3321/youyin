package liuyan.youyin.pojo;

public class OrderEntity {

	private String orderID;
	private String userID;//key
	private String imageURL;
	private OrderStatus status;
	
	public OrderEntity(String openid) {
		this.userID = openid;
	}
	
	public OrderEntity(){}
	
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

	@Override
	public String toString() {
		return "OrderEntity [orderID=" + orderID + ", userID=" + userID
				+ ", imageURL=" + imageURL + ", status=" + status + "]";
	}
	
	
	
}
