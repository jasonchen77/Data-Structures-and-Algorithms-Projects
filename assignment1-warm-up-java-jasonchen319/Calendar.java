
public class Calendar {

	private static final int MAXEVENTS = 4;
	private Event[] events;
	private int numEvents;
	
	public Calendar() {
		this.events = new Event[MAXEVENTS];
		this.numEvents = 0;
	}
	
	public boolean addEvent(Event e) {
		if (numEvents < MAXEVENTS) {
			for(int i = 0; i < MAXEVENTS; i++) {
				if (events[i] == null) {
					events[i] = e;
					numEvents++;
					break;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public int findEvent(Event e) {
		for(int i = 0; i < MAXEVENTS-1; i++) {
			if (events[i] == null) {
				continue;
			}
			else {
				if (events[i].equals(e)) {
					return i;
				}
				else {
					continue;
				}
			}
		}
		if (events[MAXEVENTS-1] != null && events[MAXEVENTS-1].equals(e)) {
			return MAXEVENTS-1;
		}
		else {
			return -1;
		}		
	}
	
	public boolean removeEvent(Event e) {
		int eventIndex = this.findEvent(e);
		if (eventIndex == -1) {
			return false;
		}
		else {
			events[eventIndex] = null;
			numEvents--;
			return true;
		}
	}
	
	public void dump() {
		for (int i = 0; i < MAXEVENTS; i++) {
			if (events[i] != null) {
				System.out.println(events[i].toString());
			}
		}
	}
}
