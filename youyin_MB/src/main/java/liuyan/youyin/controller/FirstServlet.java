package liuyan.youyin.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.pojo.Order;
import liuyan.youyin.queue.Queue;
import liuyan.youyin.weixin.constants.GlobalConstants;
import liuyan.youyin.weixin.util.HttpUtils;
import net.sf.json.JSONObject;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String code = request.getParameter("code");
		Map<String, String> params = new HashMap<String, String>();
		String reqUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
		params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
		params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
		params.put("code", code);
		params.put("grant_type", "authorization_code");
		if(code!=null&&code!=""){
			try {
				String tmp = HttpUtils.sendGet(reqUrl, params);
				JSONObject jsonObject = JSONObject.fromObject(tmp);
				String openid = (String) jsonObject.get("openid");
				if(openid!=null&&openid!=""){
				request.getSession().setAttribute("openid", openid);
//				Order order = new Order();
//				Queue.userOrder.put(openid, order);
				}
//				System.out.println(request.getSession().getAttribute("openid"));
				request.getRequestDispatcher("/html5/weixin.html").forward(request, response);
//				System.out.println("------------------------------------");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
