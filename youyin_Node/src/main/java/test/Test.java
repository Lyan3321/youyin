package test;

import java.util.HashMap;
import java.util.Map;

import liuyan.youyin.utils.HttpUtils;
import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		String reqUrl = "http://localhost:8080/youyin_MB/machineLogin";
		Map<String,String> params = new HashMap<String,String>();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("operation", "login");
		jsonObject.put("machineID", 1);
		jsonObject.put("machine-name", "NO1");
		jsonObject.put("token", "e45a5780-b848-4b19-ac82-775879678afc");
		String json = jsonObject.toString();
		params.put("data", json);
		try {
			String result = HttpUtils.sendPost(reqUrl, params);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
