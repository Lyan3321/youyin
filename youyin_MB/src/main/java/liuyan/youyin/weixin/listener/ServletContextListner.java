package liuyan.youyin.weixin.listener;

import java.util.Properties;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import liuyan.youyin.weixin.start.InterfaceUrlInti;
import liuyan.youyin.weixin.util.TimerTaskUtil;

@WebListener
public class ServletContextListner implements ServletContextListener {
	public static Properties interfaceUrlProperties;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

		System.out.println("监听器。。。。");
		
		InterfaceUrlInti.init();
		
//        WeChatTask timer = new WeChatTask();
//        try {
//			timer.getToken_getTicket();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		Timer timer = new Timer();
		timer.schedule(new TimerTaskUtil(), 1000,7000000);
	}

}
