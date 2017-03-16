package liuyan.youyin.start;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClientConfig {

	public Properties p = null;
	
	public ClientConfig(){
		
	}
	
	public void load(){
		p = new Properties();
		InputStream is = getClass().getClassLoader().getResourceAsStream("clientconfig.properties");
		try {
			p.load(is);
			is.close();
			System.out.println(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getConfigValue(String key){
		return p.getProperty(key);
	}
}
