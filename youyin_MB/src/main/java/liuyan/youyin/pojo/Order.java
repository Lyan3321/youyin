package liuyan.youyin.pojo;

import java.io.File;
import java.io.IOException;

import liuyan.youyin.service.OrderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 该类实现本地储存订单
 * @author Frank
 *
 */
public class Order {

	private int flag = 0;
	public final static String path = "D:/order.json";
	public JSONArray jsonArray = null;
	public JSONObject jsonObject = null;
	private String orderID = "-10";
	private String userID = "-10";
	private String imageURL = "-10";
	private OrderStatus status = null;
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
	
	public Order(){
		File file = new File(path);
		if(!file.exists()){
			createFile();
		}
		jsonArray = OrderService.readJsonFromFile(path);
//		jsonObject = jsonArray.getJSONObject(0);
//		//遍订单队列
//		for(int i = 0;i < jsonArray.size();i++){
//			
//		}
//		orderID = (String) getValue("orderID");
		
	}
	private void createFile() {
		// TODO Auto-generated method stub
		File file = new File(path);
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonArray = new JSONArray();
		jsonObject = new JSONObject();
		updateRecord();
	}
	
	private void updateRecord() {

		jsonObject.put("orderID", orderID);
		jsonObject.put("userID", userID);
		jsonObject.put("imageURL", imageURL);
		jsonArray.clear();
		jsonArray.add(jsonObject);
		OrderService.writeJsonToFile(path, jsonArray);
	}
	
	public Object getValue(String key){
		if(jsonObject.get(key)!=null&&!jsonObject.get(key).equals("")){
			return(jsonObject.get(key));
		}
		jsonObject.put(key, "-10");
		jsonArray.clear();
		return null;
	}
	
	public int checkOrder(){
		for(int i = 0;i < jsonArray.size();i++ ){
			if(jsonArray.getJSONObject(i).get("userID")== userID){
				return 0;
			}
		}
		jsonObject = JSONObject.fromObject(this);
		jsonArray.add(jsonObject);
		OrderService.writeJsonToFile(path,jsonArray);
		return 1;
	}
}
