package liuyan.youyin.weixin.util;

import java.util.TimerTask;

import liuyan.youyin.weixin.common.WeChatTask;

public class TimerTaskUtil extends TimerTask {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			WeChatTask.getToken_getTicket();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
