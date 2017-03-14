package com.liuyan.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyan.utils.HttpUtils;

public class ReceiveOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "/files/";
	private String picUrl = "http://127.0.0.1:8080/youyin_MB/files/";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = request.getParameter("fileName");
		System.out.println(fileName);
		String a = picUrl + fileName;
		String filePath = getServletContext().getRealPath(FILE_PATH) + "\\" + fileName;
//		HttpUtils httpUtils = new HttpUtils();
//		HttpUtils.saveImageToDisk(picUrl, filePath);
//		HttpUtils.saveImageToDisk(picUrl, filePath);
		URL imageurl = new URL(a); 
		DataInputStream dis = new DataInputStream(imageurl.openStream());
		  FileOutputStream fos = new FileOutputStream(new File(filePath));
		    
		    byte[] buffer = new byte[1024];
		   
		    int length;
		   
		   
		    while( (length = dis.read(buffer))>0){
		   
		    fos.write(buffer,0,length);
		   
		    }
		   
		    dis.close();
		   
		    fos.close();
	} 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
