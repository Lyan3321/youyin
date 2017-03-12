package liuyan.youyin.weixin.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import liuyan.youyin.weixin.constants.GlobalConstants;
import liuyan.youyin.weixin.util.HttpUtils;
import net.sf.json.JSONObject;

/**
 * ClassName: WeChatTask
 * @Description: 微信两小时定时任务体
 * @author dapengniao
 * @date 2016 年 3 月 10 日 下午 1:42:29
 */
public class WeChatTask {
    /**
     * @Description: 任务执行体
     * @param @throws Exception
     * @author dapengniao
     * @date 2016 年 3 月 10 日 下午 2:04:37
     */
    public  static void getToken_getTicket() throws Exception {
        Map<String, String> params = new HashMap<String, String>();
        params.put("grant_type", "client_credential");
        params.put("appid", GlobalConstants.getInterfaceUrl("appid"));
        params.put("secret", GlobalConstants.getInterfaceUrl("AppSecret"));
        String jstoken = HttpUtils.sendGet(
        		GlobalConstants.getInterfaceUrl("tokenUrl"), params);
//        params.put("appid", "wx7389161d04e4f201");
//        params.put("secret", "4b21c392b48e9bc80357abfd966d3698");
//        String jstoken = HttpUtils.sendGet("https://api.weixin.qq.com/cgi-bin/token",params);
//        System.out.println(JSONObject.fromObject(jstoken));
//        System.out.println(JSONObject.fromObject(jstoken).toString());
        String access_token = JSONObject.fromObject(jstoken).getString(
                "access_token"); // 获取到 token 并赋值保存
        GlobalConstants.interfaceUrlProperties.put("access_token", access_token);
//                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token 为=============================="+access_token);
                
//获取jsticket的执行体
        params.clear();
        params.put("access_token", access_token);
        params.put("type", "jsapi");
        String jsticket = HttpUtils.sendGet(
                GlobalConstants.getInterfaceUrl("ticketUrl"), params);
        String jsapi_ticket = JSONObject.fromObject(jsticket).getString(
                "ticket"); 
        GlobalConstants.interfaceUrlProperties
        .put("jsapi_ticket", jsapi_ticket); // 获取到js-SDK的ticket并赋值保存
         
        System.out.println("jsapi_ticket================================================" + jsapi_ticket);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"token为=============================="+access_token);
    }

}