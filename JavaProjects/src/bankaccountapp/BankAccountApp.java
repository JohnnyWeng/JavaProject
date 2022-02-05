package bankaccountapp;

import java.util.LinkedList;
import java.util.List;
public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>(); 
		
		String file = "D:\\Johnny\\COMPUTER_SCIENCE\\CS_ALL_Project\\Github_Work\\final\\Java_foundation\\Practice Java by Building Projects-BY Tim Short\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for(String[] accountHolder : newAccountHolders) {
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]); 
			if (accountType.equals("Savings")) {

				accounts.add(new Savings(name, sSN, initDeposit)); 
			}
			else if (accountType.equals("Checking")){
				accounts.add(new Checking(name, sSN, initDeposit));
			}
			else {
				System.out.println("ERROR READING ACCOUNT TYPE");
			}
		}
		accounts.get(5).showInfo();
		System.out.println("\n=====================");
		
		for (Account acc : accounts) {
			System.out.println("\n*******************");
			acc.showInfo();
		}
		accounts.get((int)Math.random()* accounts.size()).deposit(10000); 
		accounts.get((int)Math.random()* accounts.size()).deposit(1500);
	}
}









