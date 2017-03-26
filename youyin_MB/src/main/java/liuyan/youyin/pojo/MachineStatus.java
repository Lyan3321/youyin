package liuyan.youyin.pojo;

public class MachineStatus {

	/**
	 * PRINTER_OFFLINE：离线
	 * PRINTER_ONLINE：在线
	 */
	public static final int PRINTER_OFFLINE = 0;
	public static final int PRINTER_ONLINE = 1;
	public static final int PRINTER_OUTOFINK = 2;
	public static final int PRINTER_OUTOFPAPER = 3;
	public static final int PRINTER_UNKOWNERROR = 8;
	public static final int PRINTER_NOPERINER = 9;
	
	private int state = PRINTER_OFFLINE;
	private String explain = "离线";
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
}
