package liuyan.youyin.pojo;

public class OrderStatus {

	public static final int ORDER_STATUS_CREATED = 7;
	public static final int ORDER_STATUS_PAID = 1;
	public static final int ORDER_STATUS_PRINTERALLOCATION = 2;
	public static final int ORDER_STATUS_WAITINGPRINTERQUEUE = 3;
	public static final int ORDER_STATUS_PRINTING = 4;
	public static final int ORDER_STATUS_FINISH_SUCCESS = 5;
	public static final int ORDER_STATUS_FINISH_FAILURE = 6;
	
	private int state;
	private int errorCode;
	private String errorMsg;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
