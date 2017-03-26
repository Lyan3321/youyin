package liuyan.youyin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.pojo.OrderEntity;
import liuyan.youyin.pojo.OrderStatus;
import liuyan.youyin.pojo.OrdersCollection;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONObject jsonResponse = new JSONObject();
	//图片的相对位置
	private static final String FILE_PATH = "/files/";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String openid = (String) request.getSession().getAttribute("openid");
		
		String result = handle(openid,request);
		PrintWriter out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

	private String handle(String openid,HttpServletRequest request) {
		/**
		 * 验证openid，创建订单实体
		 */
		if(openid!=null&&openid!=""){
		OrderEntity order = checkOpenid(openid);
		OrdersCollection.INSTANCE.put(order);
		OrderStatus status = new OrderStatus();
		//设置状态为创建订单
		status.setState(OrderStatus.ORDER_STATUS_CREATED);
		order.setStatus(status);
		//设置OrderID
		String orderID = String.valueOf(getOrderID(request));
		order.setOrderID(orderID);
		
		/**
		 * 从表单得到data
		 */
		//1,得到FileItemde 集合items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(1024 * 500);
		File file = new File("d:\\temp"); 
		factory.setRepository(file);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(1024 * 1024 * 5);
		try {
			List<FileItem> items = upload.parseRequest(request);
			//2,遍历items：若是一个一般的表单域，打印信息
			for(FileItem item: items){
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(name + ":" + value);
				}else{
					//得到item的信息
					String fileName = item.getName();
					//从item中获取文件名，并拼接系统时间
					fileName = System.currentTimeMillis() + fileName;
					//将图片写入到项目文件夹中
					InputStream in = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					String imageURL = getServletContext().getRealPath(FILE_PATH) + "\\" + fileName;
					order.setImageURL(imageURL);
					OutputStream os = new FileOutputStream(imageURL);
					
					while((len = in.read(buffer))!=-1){
						os.write(buffer, 0, len);
					}
					os.close();
					in.close();
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			jsonResponse.put("result", "failed");
			jsonResponse.put("reason", "openid is empty");
			return jsonResponse.toString();
		}
		System.out.println(OrdersCollection.INSTANCE.getSize());
		System.out.println(OrdersCollection.INSTANCE.getOrdersCollection());
		jsonResponse.put("result", "success");
		return jsonResponse.toString();
	}

	private int getOrderID(HttpServletRequest request) {
		ServletContext application = request.getSession().getServletContext();
		int count;
		if(application.getAttribute("count")==null){
			application.setAttribute("count", 1);
			count = 1;
		}else{
			count = (Integer)application.getAttribute("count") + 1;
		}
		return count;
	}

	private OrderEntity checkOpenid(String openid) {
//		Integer[] keys = OrdersCollection.INSTANCE.getKeys();
//		for(int i=0;i<keys.length;i++){
//			if(openid==keys[i]){
//				return OrdersCollection.INSTANCE.get(String.valueOf(openid));
//			}
//		}
		OrderEntity orderEntity = new OrderEntity(openid);
		return orderEntity;
	}

}
