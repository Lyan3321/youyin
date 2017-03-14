package com.liuyan.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUtils {
//	public static String URL_PATH = "http://192.168.0.100:8080/myhttp/pic1.jpg";  

	public static void saveImageToDisk(String picUrl,String filePath) {  
		  
        InputStream inputStream = getInputStream(picUrl);
//		InputStream inputStream = getInputStream("http://127.0.0.1:8080/youyin_MB/files/1.txt");
        byte[] data = new byte[1024];  
        int len = 0;  
        FileOutputStream fileOutputStream = null;  
        try {  
            fileOutputStream = new FileOutputStream(filePath);  
            System.out.println(inputStream);
            while ((len = inputStream.read(data)) != -1) {  
                fileOutputStream.write(data, 0, len);  
  
            } 
            fileOutputStream.flush();
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } finally {  
  
            if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
            if (fileOutputStream != null) {  
                try {  
                    fileOutputStream.close();  
                } catch (IOException e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }  
            }  
  
        }
  
    } 

	public static InputStream getInputStream(String picUrl) {  
        InputStream inputStream = null;  
        HttpURLConnection httpURLConnection = null;  
  
        try {  
            URL url = new URL(picUrl);  
            httpURLConnection = (HttpURLConnection) url.openConnection();  
            // 设置网络连接超时时间  
            httpURLConnection.setConnectTimeout(10000);  
            // 设置应用程序要从网络连接读取数据  
            httpURLConnection.setDoInput(true);  
  
            httpURLConnection.setRequestMethod("GET");  
            int responseCode = httpURLConnection.getResponseCode(); 
            System.out.println(responseCode);
            if (responseCode == 200) {  
            	System.out.println("---------------------");
                // 从服务器返回一个输入流  
                inputStream = httpURLConnection.getInputStream();  
  
            }  
  
        } catch (MalformedURLException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        return inputStream;  
  
    }  
}
