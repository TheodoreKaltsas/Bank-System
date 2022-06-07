import java.util.Vector;

/*
 * Design a class that serves as records of bank accounts. Member variables are 
 * - balance (COMPLETE)
 * - interest rate (COMPLETE)
 * - last date interest was payed. (COMPLETE)
 * - date of opening the account (COMPLETE)
 * - primary member client (see Client class) (COMPLETE)
 * - Vector of secondary holders up to three secondary holders (COMPLETE)
 * - Methods:
 * - getters and setters to balance, interest rate, primary holder, .... (COMPLETE)
 * - payInterest that computes the interest to be payed starting at the last date to today. (COMPLETE)
 * - deposit(double m) deposits increases balance by m (COMPLETE)
 * - withdraw(double m) decreases the balance by m or set to 0 if not enough funds. (COMPLETE)
 * - setPrimaryHolder(Client C) changes primary holder to new Client. (COMPLETE)
 * 
 */

public class BankAccount {
	private double balance, interestRate;
	private Date accountOpen, interestLastPaid;
	
	private Client primaryMemClient;

	Vector<Client> secondaryHolders;
	
	//TODO: payInterest method that computes the interest to be paid (DONE)
	public BankAccount() {
		balance = interestRate = 0.0;
		accountOpen = interestLastPaid = new Date();
		
		primaryMemClient = new Client();
		secondaryHolders = new Vector<Client>();
	}
		
	public BankAccount(double balance, double interestRate, String interestPaid, Date accountOpen, Date interestLastPaid,
			Vector<Client> secondaryHolders, Client primaryMemClient) {
		
		this.interestLastPaid = interestLastPaid;
		this.balance = balance;
		this.interestRate = interestRate;
		this.accountOpen = accountOpen;
		this.secondaryHolders = secondaryHolders;
		this.primaryMemClient = primaryMemClient;
	}

	public Date getInterestLastPaid() {
		return interestLastPaid;
	}

	public void setInterestLastPaid(Date interestLastPaid) {
		this.interestLastPaid = interestLastPaid;
	}

	public Client getPrimaryMemClient() {
		return primaryMemClient;
	}

	public void setPrimaryMemClient(Client primaryMemClient) {
		this.primaryMemClient = primaryMemClient;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public Date getAccountOpen() {
		return accountOpen;
	}

	public void setAccountOpen(Date accountOpen) {
		this.accountOpen = accountOpen;
	}
	
	public Vector<Client> getSecondaryHolders() {
		return secondaryHolders;
	}

	public void setSecondaryHolders(Vector<Client> secondaryHolders) throws Exception {
		if(secondaryHolders.size() > 3) {
			throw new Exception("Only can have up to three secondary holders");
		}
		
		this.secondaryHolders = secondaryHolders;
	}
	
	public void payInterest() {
		double paidInterest = balance * interestRate * 1;
		balance += paidInterest;
	}


	public void deposit(double m) {
		balance += m;
	}
	
	public void withdraw(double m) {
		if(balance < 0) { 
			balance = 0;
		} else {
			balance -= m;
		}
	}
}
