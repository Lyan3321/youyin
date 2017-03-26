package liuyan.youyin.pojo;

import java.util.Collection;
import java.util.Hashtable;

public class OrdersCollection {

	public static OrdersCollection INSTANCE = new OrdersCollection();
	private Hashtable<String, OrderEntity> collection = new Hashtable<>();
	
	private OrdersCollection(){}
	
	public void put(OrderEntity orderEntity){
		collection.put(orderEntity.getUserID(), orderEntity);
	}
	
	public OrderEntity get(String userID){
		return collection.get(userID);
	}
	
	public Collection<OrderEntity> getOrdersCollection(){
		return collection.values();
	}
	
	public int getSize(){
		return collection.size();
	}
	
	public Integer[] getKeys(){
		return (Integer[]) collection.keySet().toArray();
	}
	
	public boolean isEmpty(){
		return collection.isEmpty();
	}
}
