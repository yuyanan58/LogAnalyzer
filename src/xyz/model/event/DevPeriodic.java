package xyz.model.event;

public class DevPeriodic {
	private long timeStamp;
	private String devType;
	private String info;
	
	public DevPeriodic() {}
	public DevPeriodic(long timeStamp, String devType, String info) {
		this.timeStamp = timeStamp;
		this.devType = devType;
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "DevPeriodic [timeStamp=" + timeStamp + ", devType=" + devType
				+ ", info=" + info + "]";
	}
	
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
}
