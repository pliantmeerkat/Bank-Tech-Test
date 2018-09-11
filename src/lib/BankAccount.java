package lib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class BankAccount {
	
	private final static Logger log = Logger.getLogger(BankAccount.class.getName());
	public float balance;
	public List<Payment> paymentHistory;
	
	public BankAccount() {
		this.balance = 0.00f;
		this.paymentHistory = new ArrayList<Payment>();
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
	
	public String printStatement() {
		String output = "date || credit || debit || balance\n";
		Collections.reverse(paymentHistory);
		for(Payment payment: paymentHistory) {
			output += payment.paymentDate + " || " +
				      writeCreditOrDebit(payment.paymentAmount) +
				      String.format("%.2f", payment.postTransactionBalance) + "\n";
		}
		System.out.println(output);
		Collections.reverse(paymentHistory); // set back to normal
		return output;
	} 
	
	private void makePayment(float paymentAmount) {
		this.paymentHistory.add(new Payment(paymentAmount, this.balance));	
	}
	
	private String writeCreditOrDebit(float paymentAmount) {
		if(paymentAmount > 0) {
			return "|| " + String.format("%.2f", ( paymentAmount)) + " || ";
		} else {
			return String.format("%.2f", (0 -  paymentAmount)) + " || || ";
		}
	}
}
