package lib;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {

	public String paymentDate;
	public float paymentAmount;
	public float postTransactionBalance;
	
	public Payment(float paymentAmount, float payerBalance) {
		this.paymentAmount = paymentAmount;
		this.paymentDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		verifyPayment(payerBalance);
	}
	
	public void verifyPayment(float payerBalance) {
		if(this.paymentAmount > payerBalance) {
			this.postTransactionBalance = payerBalance;
			throw new IllegalArgumentException("Insufficient Funds");
		} else {
			this.postTransactionBalance = payerBalance - paymentAmount;
		}
	} 
}
