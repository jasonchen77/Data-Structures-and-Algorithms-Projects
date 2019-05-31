
public class Activity {

	private String activityName;
	private int startTime;
	private int stopTime;
	
	public Activity(String activityName, int startTime, int stopTime) {
		this.activityName = activityName;
		this.startTime = startTime;
		this.stopTime = stopTime;
	}
	
	public String getActivityName() {
		return activityName;
	}
	
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public int getStartTime() {
		return startTime;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	
	public int getStopTime() {
		return stopTime;
	}
	
	public void setStopTime(int stopTime) {
		this.stopTime = stopTime;
	}
}
