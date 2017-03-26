package liuyan.youyin.service;

import java.util.UUID;

import liuyan.youyin.pojo.MachineEntity;
import liuyan.youyin.pojo.MachineStatus;
import liuyan.youyin.pojo.MachinesCollection;
import liuyan.youyin.weixin.constants.GlobalConstants;
import net.sf.json.JSONObject;

public class LoginService {

	private JSONObject jsonRequest;
	private JSONObject jsonResponse = new JSONObject();
	
	public String handleData(String data){
		jsonRequest = JSONObject.fromObject(data);
		String operation = jsonRequest.optString("operation");
		if(operation.equals("logout")){
			doLogout();
			return jsonResponse.toString();
		}else{
			doLogin();
			return jsonResponse.toString();
		}
	}

	private void doLogin() {
		int machineID = jsonRequest.getInt("machineID");
		String machineName = jsonRequest.optString("machine-name");
		if(machineName.isEmpty())
			machineName = "未命名机器";
		String token = jsonRequest.getString("token");
		
		if(!token.equals(GlobalConstants.getInterfaceUrl("token"))){
			jsonResponse.put("result", "failed.");
			jsonResponse.put("reason", "wrong token.");
			return;
		}
		
		MachineStatus ms = new MachineStatus();
		ms.setState(MachineStatus.PRINTER_ONLINE);
		ms.setExplain("在线");
		MachineEntity me = new MachineEntity(machineID,machineName,System.currentTimeMillis(),ms);
		
		MachinesCollection.INSTANCE.put(me);
		me.setToken(UUID.randomUUID().toString());
		
		jsonResponse.put("result", "success");
		jsonResponse.put("new-token", me.getToken());
		jsonResponse.put("machine-count",MachinesCollection.INSTANCE.getSize());
		
	}

	private void doLogout() {
		int machineID = jsonRequest.getInt("machineID");
		String machineName = jsonRequest.optString("machine-name");
		if(machineName.isEmpty())
			machineName = "未命名机器";
		String token = jsonRequest.getString("token");
		if(token.equals(MachinesCollection.INSTANCE.get(machineID).getToken())){
			MachinesCollection.INSTANCE.get(machineID).getStatus().setState(0);
			MachinesCollection.INSTANCE.get(machineID).getStatus().setExplain("离线");;
			jsonRequest.put("result", "success");
			return;
		}
		jsonRequest.put("result", "failed");
		jsonRequest.put("reason", "Not registered.");
	}
}
