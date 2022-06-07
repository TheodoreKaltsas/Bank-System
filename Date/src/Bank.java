import java.util.Vector;

/*
 * Design a class bank that manages a vector of bank accounts 
 * - Vector of bankAccounts (COMPLETE)
 * - Account number that changes each time an account is created
  methods to (COMPLETE)
 * - create a new account and add it to the vector (COMPLETE)
 * - retrieve an existing account based on SSN (COMPLETE)
 * - retrieve account based on first and last name (COMPLETE)
 * - modify an account with new info, except the account number (COMPLETE)
 * - delete an account based on SSN or first and last name. (COMPLETE)
 */

public class Bank {
	Vector<BankAccount> accounts;
	
	public Bank() {
		accounts = new Vector<BankAccount>();
	}
	
	public void addNewAccount(double balance, double interestRate, String interestPaid, Date accountOpen, Date interestLastPaid,
			Vector<Client> secondaryHolders, Client primaryMemClient) {
		
		BankAccount newestAccount = new BankAccount(balance, interestRate, interestPaid, accountOpen, interestLastPaid,
			 secondaryHolders, primaryMemClient);
		
		accounts.add(newestAccount);
	}
	
	public BankAccount retrieveAccount(String ssn) {
        for (BankAccount account : accounts) {
            if (account.getPrimaryMemClient().getSSN() == ssn) 
            	return account;
        }
        
		return null;
	}
	
	public BankAccount retrieveAccount(String fn, String ln) {
        for (BankAccount account : accounts) {
            if (account.getPrimaryMemClient().getFirstName() == fn && account.getPrimaryMemClient().getLastName() == ln) 
            	return account;
        }
        
		return null;
	}
	
	public void modify(double balance, double interestRate, String interestPaid, Date accountOpen, Date interestLastPaid,
			Vector<Client> secondaryHolders, Client primaryMemClient, String ssn) throws Exception {
		
		BankAccount accountModify = retrieveAccount(ssn);
		
		if(accountModify == null) {
			throw new Exception("Account does not exist");
		} else {
			accountModify.setBalance(balance);
			accountModify.setInterestRate(interestRate);
			accountModify.setInterestLastPaid(interestLastPaid);
			accountModify.setAccountOpen(accountOpen);
			accountModify.setPrimaryMemClient(primaryMemClient);
			accountModify.setSecondaryHolders(secondaryHolders);
		}
	}
	
	
	public void removeAccount(String ssn) throws Exception {
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getPrimaryMemClient().getSSN() == ssn) {
            	accounts.remove(i);
			} else {
				throw new Exception("Account does not exist");
			}
		}
	} 
	
	
	public void removeAccount(String fn, String ln) throws Exception {
		for(int i = 0; i < accounts.size(); i++) {
			if(accounts.get(i).getPrimaryMemClient().getFirstName() == fn && accounts.get(i).getPrimaryMemClient().getLastName() == ln) {
            	accounts.remove(i);
			} else {
				throw new Exception("Account does not exist");
			}
		}
	} 
	
	
}
