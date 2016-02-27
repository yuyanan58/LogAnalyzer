package xyz.model.event;

public class Event {
	private long timeStamp;
	private String devType;
	private String bala;
	private String eventType;
	private String extraInfo;
	
	public Event() {}
	public Event(long timeStamp, String devType, String bala, String eventType, String extraInfo){
		this.bala = bala;
		this.timeStamp = timeStamp;
		this.devType = devType;
		this.eventType = eventType;
		this.extraInfo = extraInfo;
	}
	@Override
	public String toString() {
		return "Event [timeStamp=" + timeStamp + ", devType=" + devType	+ ", bala=" + bala + ", eventType=" + eventType + ", extraInfo=" + extraInfo + "]";
	}
	
	// set & get
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
	public String getBala() {
		return bala;
	}
	public void setBala(String bala) {
		this.bala = bala;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getExtraInfo() {
		return extraInfo;
	}
	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}	
}
