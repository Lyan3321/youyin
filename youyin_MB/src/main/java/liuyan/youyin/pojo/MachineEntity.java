package liuyan.youyin.pojo;

/**
 * 本类实现机器节点
 * @author Frank
 *
 */
public class MachineEntity {

	private int id;
	private String name;
	private long lastVisit;
	private String token;
	private MachineStatus status;
	
	public MachineEntity(int id, String name, long lastVisit,
			MachineStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.lastVisit = lastVisit;
		this.status = status;
	}

	public MachineEntity(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getLastVisit() {
		return lastVisit;
	}
	public void setLastVisit(long lastVisit) {
		this.lastVisit = lastVisit;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public MachineStatus getStatus() {
		return status;
	}
	public void setStatus(MachineStatus status) {
		this.status = status;
	}
	
	
}
