package liuyan.youyin.controller.pic;

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
import liuyan.youyin.weixin.constants.GlobalConstants;
import liuyan.youyin.weixin.util.HttpUtils;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SavePic
 */
public class SavePic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			//2,遍历items：若是一个一般的表单域，打印信息
			for(FileItem item: items){
				Order order = new Order();
				if(item.isFormField()){
					if(item.getFieldName().equals("username")){
						String username = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						order.setUserName(username);
						params.put("username", username);
					}
					if(item.getFieldName().equals("address")){
						String address = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						order.setAddress(address);
						params.put("address", address);
					}
					if(item.getFieldName().equals("machineID")){
						String machineID = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
						order.setMachineID(machineID);
						params.put("machineID", machineID);
					}
//					String name = item.getFieldName();
//					String value = new String(item.getString().getBytes("ISO-8859-1"),"UTF-8");
//					System.out.println(name + ":" + value);
				}else{
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					
					
					
					fileName = System.currentTimeMillis() + fileName;
					order.setPicName(fileName);
					params.put("fileName", fileName);
					
					InputStream in = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					fileName = getServletContext().getRealPath(FILE_PATH) + "\\" + fileName;
//					fileName = "G:\\apache-tomcat-7.0.73\\webapps\\youyin_MB\\files\\" + fileName;
					order.setPicPath(fileName);
					System.out.println(fileName);
					OutputStream out = new FileOutputStream(fileName);
					
					while((len = in.read(buffer)) != -1){
						out.write(buffer,0,len);
					}
					out.flush();
					out.close();
					in.close();
					
					response.setCharacterEncoding("UTF-8");
					PrintWriter writer = response.getWriter();
					
					writer.print("上传成功");
					writer.flush();
					writer.close();
					
//					Thread.sleep(5000); 
					
					if((new File(fileName)).exists()){
					HttpUtils.sendGet(GlobalConstants.getInterfaceUrl("node1"), params);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{

		}

		
	}

}
