package liuyan.youyin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import liuyan.youyin.weixin.common.JSSDK_Config;

public class JSSDK_config extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String url = request.getParameter("url");
		PrintWriter out = null;
		System.out.println(url);
		try {
			Map<String, String> configMap = JSSDK_Config.jsSDK_Sign(url);
			System.out.println(configMap);
			JSONObject config = JSONObject.fromObject(configMap);
			out = response.getWriter();
            out.print(config);
            out.flush();
            out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
