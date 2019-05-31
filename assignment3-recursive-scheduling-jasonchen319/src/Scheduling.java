import java.util.ArrayList;

public class Scheduling {
	
	int index = 0;
	int usageIndex = 0;
	int actualUsage = 0;
	int maxUsage = 0;
	ArrayList <Activity> usageActivity = new ArrayList<Activity>(); //Array for keep track of optimal activities
	
	public ArrayList<Activity> getOptimalSchedule (int roomStartTime, int roomEndTime, 
			Activity[] activities) {
		
		int roomUsage = roomEndTime - roomStartTime;
		//Base case
		if (index >= activities.length) {
			return usageActivity;
		}
		
//		if (index == 0) {
//			actualUsage = actualUsage + (activities[index].getStopTime() - activities[index].getStartTime());
//		}
		//check if overlap
		if (activities[index].getStartTime() >= roomStartTime) { 
			actualUsage = actualUsage + (activities[index].getStopTime() - activities[index].getStartTime());
		}
		
		//Case when the first index is not included
		if (//maxUsage <= roomUsage && 
				actualUsage <= maxUsage) {
			index++;
			getOptimalSchedule(roomStartTime, roomEndTime, activities);
			//return usageActivity;
		}
		
		//Case when the first index is included
		if (//maxUsage <= roomUsage && 
				actualUsage > maxUsage) {
			maxUsage = actualUsage;
			usageActivity.add(activities[index]);
			index++;
			usageIndex++;
			getOptimalSchedule(activities[index-1].getStopTime(), roomEndTime, activities);
			//return usageActivity;
		}
		
		return usageActivity;
	}
	

}
