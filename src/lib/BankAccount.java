package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BankAccount {
	
	private static final Logger log = Logger.getLogger(BankAccount.class.getName());
	public float balance;
	private final List<Payment> paymentHistory;
	
	public BankAccount() {
		this.balance = 0.00f;
		this.paymentHistory = new ArrayList<>();
	}
	
	public void deposit(float paymentAmount) {
		makePayment(0 - paymentAmount);
		this.balance += paymentAmount;
	}
	
	public void withdraw(float paymentAmount) {
		try {
			makePayment(paymentAmount);
			this.balance -= paymentAmount;
		} catch(IllegalArgumentException e) {
			log.warning("invalid Payment: Your account has not been charged");
			throw e;
		}	
	} 
	
	public int numPayments() {
		return paymentHistory.size();
	}
	
	public String printStatement() {
		return PrintProcessor.printStatement(this.paymentHistory);
	} 
	
	private void makePayment(float paymentAmount) {
		this.paymentHistory.add(new Payment(paymentAmount, this.balance));	
	}
	
}
