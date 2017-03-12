package liuyan.youyin.wexin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.weixin.dispatcher.EventDispatcher;
import liuyan.youyin.weixin.dispatcher.MsgDispatcher;
import liuyan.youyin.weixin.util.MessageUtil;
import liuyan.youyin.weixin.util.SignUtil;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = null;
        try {
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if (SignUtil.checkSignature(signature, timestamp, nonce)) {
                out.print(echostr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            out = null;
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String respMessage = null;
		PrintWriter out = null;  
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");

            Map<String, String> map=MessageUtil.parseXml(request);
            String msgtype=map.get("MsgType");
            if(MessageUtil.REQ_MESSAGE_TYPE_EVENT.equals(msgtype)){
                respMessage = EventDispatcher.processEvent(map); //进入事件处理
            }else{
                respMessage = MsgDispatcher.processMessage(map); //进入消息处理
            }
            
            out = response.getWriter();
            out.print(respMessage);
        }catch(Exception e){
//            logger.error(e,e);
        }
	}

}
