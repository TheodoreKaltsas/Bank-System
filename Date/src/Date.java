/*
 * TODO: 
 *  Design a class Date that has the following: 
 * - int month, day and year (COMPLETE)
 * - getters and setters for each (COMPLETE)
 * - constructor that accepts day, month and year (COMPLETE) 
 * - default constructor that sets date to 01/01/2000 (COMPLETE)
 * - constructor that accepts a date as a string in the form "mm/dd/yyyy" or "yyyy-mm-dd" (COMPLETE)
 * extracts day, month and year from the string. 
 * -toString to display the date in the form mm/dd/yyyy. (COMPLETE)
 */

public class Date {
	private int month, day, year;
	String date;
	
	private static int[] daysInMonths = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	//Sets date default to 01/01/2000
	public Date() {
		month = 01;
		day = 01;
		year = 2000;
	}
	
	public Date(int m, int d, int y) {
		if(m <= 1 || m >= 12) {
			System.out.println("Please input a valid date out of the month");
		}
		
		if(y <= 1900) {
			System.out.println("Please input a year that is past 1900, thank you.");
		}
		
		if(d == 29 && m == 2 && isLeap(y)) {
			month = m;
			day = d;
			year = y;
			return;
		}
		
		if(d > daysInMonths[m] || d < 1) {
			System.out.println("Please input a valid date"); 	
		}
		
		this.month = m;
		this.day = d;
		this.year = y;
	}
	
	//Takes date as a string
	public Date(String date) {
		if(date.contains("/")) {
			String[] strSplit  = date.split("/");
			if(strSplit.length != 3) {
				System.out.println("The date is in an invalid format");
			}
			
			this.setYear(Integer.parseInt(strSplit[2]));
			this.setDay(Integer.parseInt(strSplit[1]));
			this.setMonth(Integer.parseInt(strSplit[0]));
			
		} else if(date.contains("-")) {
			String[] strSplit  = date.split("-");
			if(strSplit.length != 3) {
				System.out.println("The date is in an invalid format");
			}
			
			this.setYear(Integer.parseInt(strSplit[0]));
			this.setDay(Integer.parseInt(strSplit[2]));
			this.setMonth(Integer.parseInt(strSplit[1]));
			
		}	else {
			System.out.println("Invalid date inputted, try again.");
		}
	}
	
	//Setters for month, date and year
	public void setMonth(int m) {
		if(m < 1 || m > 12) {
			System.out.println("Please input a valid date out of the month");
		} else {
			this.month = m;
		}
	}
	
	public void setDay(int d) {
		if(d > 28 && this.month == 2 && !isLeap(this.year)) {
			System.out.println("There are not that many days in Februrary");
		}
		
		if(d > daysInMonths[this.month] || d < 1) {
			System.out.println("Please input a valid day"); 	
		} 
		
		this.day = d;
			
	}
	
	public void setYear(int y) {
		if(y < 1900) {
			System.out.println("Please input a year that is past 1900, thank you.");
		}else { 
			this.year = y; 
		}
	}
	
	//Getters for month, date and year
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public Boolean isLeap(int y) {
		if(y % 4 == 0 || y % 100 == 0) {
			return true;
		} else {
			return false;
		}
	}

	//displays date in form mm/dd/yyyy (for now returns null)
	public String toString() {
		String st = this.month + "/" + this.day + "/" + this.year;
		return st;
		
	}
}