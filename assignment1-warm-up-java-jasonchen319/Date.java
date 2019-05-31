
public class Date implements Comparable<Date> {

	private int year;
	private int month;
	private int day;
	
	public Date(int year, int month, int day) throws IllegalArgumentException {
		if (year < 2014 || year > 2020 || month < 1 || month > 12 || day < 1 || day > 31) {
			throw new IllegalArgumentException();
		}
		else {
			this.year = year;
			this.month = month;
			this.day = day;
		}
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	public boolean equals(Object obj) {
		Date otherDate = (Date)obj;
		return (this.year == otherDate.year && this.month == otherDate.month 
				&& this.day == otherDate.day);		
	}
	
	@Override
	public int compareTo(Date otherDate) {
		if (this.year - otherDate.year == 0) {
			if (this.month - otherDate.month == 0) {
				if (this.day - otherDate.day == 0) {
					return 0;
				}
				else if (this.day - otherDate.day > 0) {
					return 1;
				}
				else {
					return -1;
				}
			}
			else if (this.month - otherDate.month > 0) {
				return 1;
			}
			else {
				return -1;
			}
		}
		else if (this.year - otherDate.year > 0) {
			return 1;
		}
		else {
			return -1;
		}
		
	}

}
