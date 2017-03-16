package liuyan.youyin.start;

import java.util.HashMap;
import java.util.Map;

import liuyan.youyin.utils.HttpUtils;

import org.apache.log4j.Logger;

public class NodeConnection {

	public static final NodeConnection INSTANCE = new NodeConnection();
	public static final String URL = "http://127.0.0.1:8080/youyin_MB/nodeconnection";
	private static final String machineID = NodeClient.INSTANCE.getClientConfig().getConfigValue("machineID");
	
	private Logger logger = Logger.getLogger(NodeClient.class);
	private Map<String, String> params = new HashMap<String,String>();
	
	private NodeConnection(){
		params.put("machineID", machineID);
		params.put("msg", "success");
	}
	
	public void init(){
		logger.debug("节点初始化连接.......");
		try {
			HttpUtils.sendGet(URL, params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
