package liuyan.youyin.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.pojo.Order;
import liuyan.youyin.pojo.OrderStatus;
import liuyan.youyin.queue.Queue;
import liuyan.youyin.weixin.constants.GlobalConstants;
import liuyan.youyin.weixin.util.HttpUtils;
import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SavePic
 */
public class OrderCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	//常数，用来记录订单ID
	public static int count = 1;
	//图片的URL
	private String filePath;
	//图片的相对位置
	private static final String FILE_PATH = "/files/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//1,得到FileItemde 集合items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		factory.setSizeThreshold(1024 * 500);
		File file = new File("d:\\temp"); 
		factory.setRepository(file);
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		upload.setSizeMax(1024 * 1024 * 5);
		
		Map<String, String> params = new HashMap<String, String>();
		//订单数加1
		count++;
		//新建订单Map，存储订单队列
		Map<String, String> orderMap = new HashMap<String, String>();
		Order order = new Order();
		order.setOrderID(String.valueOf(count));
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			//2,遍历items：若是一个一般的表单域，打印信息
			for(FileItem item: items){
				
				
				if(item.isFormField()){
					String name = item.getFieldName();
					String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
					System.out.println(name + ":" + value);
					//orderMap.put(name, value);
					if(name == "username"){
						order.setUserID(value);
					}
				}else{
					//得到item的信息
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);
					//从item中获取文件名，并拼接系统时间纺织重复
					fileName = System.currentTimeMillis() + fileName;
					//将文件名加入到Map集合中
//					params.put("fileName", fileName);
					
					//将图片写入到项目文件夹中
					InputStream in = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + fileName;
//					fileName = "G:\\apache-tomcat-7.0.73\\webapps\\youyin_MB\\files\\" + fileName;
					System.out.println(filePath);
					order.setImageURL(filePath);
					
					//检查订单是有重复
					int flag = order.checkOrder();
					
					OutputStream out = new FileOutputStream(filePath);
					
					while((len = in.read(buffer)) != -1){
						out.write(buffer,0,len);
					}
					out.close();
					in.close();
					/*
					//创建订单状态数据
					OrderStatus orderStatus = new OrderStatus();
					orderStatus.setState(OrderStatus.ORDER_STATUS_CREATED);
					//判断图片是否读取到文件夹
					if(!(new File(filePath)).exists()){
						orderStatus.setErrorCode(0);
						orderStatus.setErrorMsg(GlobalConstants.getInterfaceUrl("error_0"));
					}else{
						orderStatus.setErrorCode(-1);
					}

					//将订单信息写入到队列中
					order.setImageURL(filePath);
					order.setOrderID(String.valueOf(count));
					order.setStatus(orderStatus);
					Queue.orderlist.add(order);
					
					//回应微信前端
					PrintWriter writer = response.getWriter();
					//根据Order生成json对象
					JSONObject jsonResp = JSONObject.fromObject(order);
					System.out.println(jsonResp);
					
					writer.print(jsonResp);
					writer.flush();
					writer.close();
					
					//转发到节点
					//HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("node1"), params);
					
					 */
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{

		}

		
	}

}
