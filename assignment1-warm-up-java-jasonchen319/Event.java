
public class Event {
	
	private Date date;
	private int start;
	private int end;
	private String description;
	
	public Event (Date date, int start, int end, String description) 
			throws IllegalArgumentException {
		if (start < 0 || start > 23 || end < 0 || end > 23 || start > end) {
			throw new IllegalArgumentException();
		}
		else {
			this.date = date;
			this.start = start;
			this.end = end;
			this.description = description;
		}
	}

	public Date getDate() {
		return date;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public String toString() {
		return date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + " " 
				+ this.getStart() + "--" + this.getEnd() + ":" + this.getDescription();
	}
	
	public boolean equals(Object obj) {
		Event otherEvent = (Event)obj;
		return (this.date.toString().equals(otherEvent.date.toString()) 
				&& this.getStart() == otherEvent.getStart() 
				&& this.getEnd() == otherEvent.getEnd() 
				&& this.getDescription().equals(otherEvent.getDescription()));
	}

}
