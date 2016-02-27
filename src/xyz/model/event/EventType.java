package xyz.model.event;

public class EventType {
	private String eventType;
	private String explain;
	
	@Override
	public String toString() {
		return "EventType [eventType=" + eventType + ", explain=" + explain + "]";
	}
	
	//constructed function
	public EventType() {}
	public EventType(String eventType, String explain){
		this.eventType = eventType;
		this.explain = explain;
	}
	
	// set & get
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}
