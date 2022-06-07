import java.time.LocalDate;

/*
 * Design a class client, which is a person. 
 * - first name (COMPLETE)
 * - last name (COMPLETE)
 * - Date of birth (COMPLETE)
 * - address (COMPLETE)
 * - phone number (COMPLETE)
 * - email address (COMPLETE)
 * - SSN (to be able to retrieve account holders). (COMPLETE)
 * - getters and setters for all of them * (COMPLETE)
 * 
 */

public class Client {
	
	private String firstName, lastName, dob, address, SSN, emailAddress, phoneNumber;
	private int ageOfClient;
	
	//The date object takes the string DOB in its constructor to parse as ints
	//The local date gets the current date of the user accessing banking information
	private LocalDate current_date;
	private Date date;
	
	public Client() {
		firstName = lastName = dob = address = SSN = emailAddress = phoneNumber = "unknown";
	}
	
	public Client(String fn, String ln, String dob, String address, String SSN, String email, String phoneNum) throws Exception {
		this.firstName = fn;
		this.lastName = ln;
		this.dob = dob;
		this.address = address;
		
		//SSN must contain - character for SSN of type 000-00-0000
		if(SSN.contains("-")) {
			String[] strSplit  = SSN.split("/");
			if(strSplit.length != 3) {
				System.out.println("The SSN is in an invalid format");
			} else { 
				this.SSN = SSN;
			}
		} else {
			throw new Exception("SSN is invalid format");
		}
		
		this.emailAddress = email;
		
		if(phoneNumber.length() > 10) {
			throw new Exception("Phone number cannot be more than 10 digits");
		} else {
			this.phoneNumber = phoneNum;
		}
	}
	
	public int getAgeOfClient(String dob) {
		date = new Date(dob);
		int birthYear = date.getYear();
		current_date = LocalDate.now();
		int currentYear = current_date.getYear();
		
		ageOfClient = currentYear - birthYear;
		
		if(current_date.getMonthValue() < date.getMonth()) 
		{
			--ageOfClient;
		}
		
		if(current_date.getMonthValue() == date.getMonth() && current_date.getDayOfMonth() < date.getDay())
		{
			--ageOfClient;
		}
		
		return ageOfClient; 
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", address=" + address
				+ ", SSN=" + SSN + ", emailAddress=" + emailAddress + ", phoneNumber=" + phoneNumber + ", ageOfClient="
				+ ageOfClient + ", current_date=" + current_date + ", date=" + date + "]";
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSSN() {
		return this.SSN;
	}

	public void setSSN(String SSN) throws Exception {
		if(SSN.contains("-")) {
			String[] strSplit  = SSN.split("-");
			if(strSplit.length != 3) {
				throw new Exception("The SSN is in an invalid format");
			} else { 
				this.SSN = SSN;
			}
		}
	}

	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws Exception {
		if(phoneNumber.length() > 10) {
			throw new Exception("Phone number cannot be more than 10 digits");
		} else {
			this.phoneNumber = phoneNumber;
		}
	}
	
	
}
