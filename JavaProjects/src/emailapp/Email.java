package emailapp;

import java.util.Scanner;

public class Email { 

	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500; 
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "Johnnycompany.com";
	
	public Email(String firstName, String lastName) { 
		this.firstName = firstName; 
		this.lastName = lastName;
		this.department = setDepartment(); 
		System.out.println("Department: "+ this.department);
		
		this.password = randomPassword(defaultPasswordLength); 
		System.out.println("Your Password is: " + this.password);
		
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	private String setDepartment() {
		Scanner in = new Scanner(System.in); 
		System.out.print("New Worker: " + firstName + ", DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		int depChoice = in.nextInt();
		if (depChoice == 1) {
			return "Sales";
		}else if(depChoice == 2){
			return "dev";
		}else if(depChoice == 3) {
			return "acct";
		}else {
			return "Wrong input";
		}
	}
	
	private String randomPassword(int length) { 
		String passwordSet = "ABCDEFGHIJKLMOPQRSTUVWXYZ!@#$%&*123456789";
		char[] password = new char[length]; 
		for(int i=0; i<length; i++) {

			int rand = (int) (Math.random() * passwordSet.length()); 
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password); 
	}
	
	public void setMailboxCapcity(int capacity) { 
		this.mailboxCapacity = capacity; 
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail; 
	}

	public void changePassword(String password) {
		this.password = password;
	}
	public int getmailboxCapacity(){ return mailboxCapacity;} 
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() {return password;}
	
	public String showInfo() {
		return "DISPLAY NAME: " + firstName + " " + lastName + 
				"\nCOMPANY EMAIL:�@" + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}






