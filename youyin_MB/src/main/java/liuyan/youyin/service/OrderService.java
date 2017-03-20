package liuyan.youyin.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import net.sf.json.JSONArray;

public class OrderService {

	public static JSONArray readJsonFromFile(String filePath){
		JSONArray jsonArray = JSONArray.fromObject(ReadFile(filePath));
		return jsonArray;
	}

	private static String ReadFile(String filePath) {
		BufferedReader reader = null;
		String laststr = "";
		
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
			reader = new BufferedReader(inputStreamReader);
			String tempString = null;
			while((tempString = reader.readLine()) != null){
				laststr += tempString;
			}
			reader.close();
		} catch (Exception e) {
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return laststr;
	}

	public static void writeJsonToFile(String path, JSONArray jsonArray) {
		String string = jsonArray.toString();
		
		OutputStreamWriter fw;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(path),"UTF-8");
			PrintWriter out = new PrintWriter(fw);
			out.write(string);
			out.println();
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
