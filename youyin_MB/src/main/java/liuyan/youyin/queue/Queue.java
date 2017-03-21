package liuyan.youyin.queue;

import java.util.Hashtable;
import java.util.Vector;

import liuyan.youyin.pojo.Order;

public class Queue {

	//订单队列
	public static Vector<Order> orderlist = new Vector<Order>();
	public static Hashtable<String, Object> userOrder = new Hashtable<String, Object>();
}
