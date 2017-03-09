package liuyan.youyin.controller.pic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class SavePic
 */
public class SavePic extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
	
//		InputStream in = request.getInputStream();
//		
//		Reader reader = new InputStreamReader(in);
//		BufferedReader bufferedReader = new BufferedReader(reader);
//		
//		String str = null;
//		
//		while((str = bufferedReader.readLine()) != null){
//			System.out.println(str);
//		}
		
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
					String value = item.getString();
					System.out.println(name + ":" + value);
				}else{
					String fieldName = item.getFieldName();
					String fileName = item.getName();
					String contentType = item.getContentType();
					long sizeInBytes = item.getSize();
					
					System.out.println(fieldName);
					System.out.println(fileName);
					System.out.println(contentType);
					System.out.println(sizeInBytes);
					
					InputStream in = item.getInputStream();
					byte [] buffer = new byte[1024];
					int len = 0;
					
					fileName = "d:\\files\\" + fileName;
					System.out.println(fileName);
					OutputStream out = new FileOutputStream(fileName);
					
					while((len = in.read(buffer)) != -1){
						out.write(buffer,0,len);
					}
					
					out.close();
					in.close();
					
					response.setCharacterEncoding("UTF-8");
					PrintWriter writer = response.getWriter();
					
					writer.print("上传成功");
					writer.flush();
					writer.close();
					
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
