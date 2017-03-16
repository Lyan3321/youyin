package liuyan.youyin.start;

import org.apache.log4j.Logger;

public class NodeClient {

	private static final Logger logger = Logger.getLogger(NodeClient.class);
	private ClientConfig cc = null;
	private NodeConnection nc;
	public static NodeClient INSTANCE = new NodeClient();
	
	//无参构造
	private NodeClient(){}
	
	public static void main(String[] args) {
	logger.debug("Started.............");	
	INSTANCE.init();
	
	}

	private void init() {
		// TODO Auto-generated method stub
		nc = NodeConnection.INSTANCE;
		nc.init();
		cc = new ClientConfig();
		cc.load();
		
	}
	
	public ClientConfig getClientConfig(){
		return cc;
	}
}
