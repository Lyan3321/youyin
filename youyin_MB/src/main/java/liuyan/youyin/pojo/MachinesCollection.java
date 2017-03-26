package liuyan.youyin.pojo;

import java.util.Collection;
import java.util.Hashtable;

/**
 * 机器节点集合
 * 
 * @author Frank
 *
 */
public class MachinesCollection {

	public static MachinesCollection INSTANCE = new MachinesCollection();
	private Hashtable<Integer,MachineEntity> collection = new Hashtable<>();
	
	private MachinesCollection(){}
	
	public void put(MachineEntity machine){
		collection.put(machine.getId(), machine);
	}
	
	public MachineEntity get(int id){
		return collection.get(id);
	}
	
	public Collection<MachineEntity> getMachinesCollection(){
		return collection.values();
	}
	
	public int getSize(){
		return collection.size();
	}
	
	public Integer[] getKeys(){
		return (Integer[]) collection.keySet().toArray();
	}
	
	/**
	 * check the token
	 * @param id
	 * @param token
	 * @return
	 */
	public boolean checkToken(int id, String token){
		MachineEntity me = collection.get(id);
		return (token != null) && (me != null) && (token.equals(me.getToken()));
	}
	
	public boolean isEmpty(){
		return collection.isEmpty();
	}
}
