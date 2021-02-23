
public class Date {
	private String day;
	private String month;
	private String year;
	
	public Date(String day, String month, String year) {
		if (Integer.parseInt(day)<1 || Integer.parseInt(day)>31) {
			System.out.println("Invalid day input. Null assigned");
		} else {
			this.day = day;
		}
		if (Integer.parseInt(month)<1 || Integer.parseInt(month)>31) {
			System.out.println("Invalid month input. Null assigned");
		} else {
			this.month = month;
		}
		this.year = year;
	}
	
	public Date() {
		this.day = "Not known";
		this.month = "Not known";
		this.year = "Not known";
	}

	public String getDay() {return day;}
	public String getMonth() {return month;}
	public String getYear() {return year;}
	
	public void setDay(String day) {this.day = day;}
	public void setMonth(String month) {this.month = month;}
	public void setYear(String year) {this.year = year;}
	
	public String displayDate() {
		return day + "/" + month + "/" + year;
	}
}
