package lib;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	
	public int balance;
	public List paymentHistory;
	
	public BankAccount() {
		this.balance = 0;
		this.paymentHistory = new ArrayList();
	}
	
	public void makePayment() {
		
	}
	
}
