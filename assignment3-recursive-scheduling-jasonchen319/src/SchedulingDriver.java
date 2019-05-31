import java.util.ArrayList;

public class SchedulingDriver {
	
	public static void main (String[] args) {
		
		Activity[] activities = new Activity[4];
		activities[0] = new Activity("A", 1, 2);
		activities[1] = new Activity("B", 2, 5);
		activities[2] = new Activity("C", 1, 3);
		activities[3] = new Activity("D", 5, 6);
		
		Scheduling s = new Scheduling();
		ArrayList<Activity> optimalActivities = s.getOptimalSchedule(1, 7, activities);
		
		for (int i = 0; i < optimalActivities.size(); i++) {
			System.out.println(optimalActivities.get(i).getActivityName());
		}
	}

}
