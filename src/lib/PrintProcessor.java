package lib;

import java.text.SimpleDateFormat;
import java.util.Collections;

import java.util.List;

public class PrintProcessor {

	public static String printStatement(List<Payment>paymentHistory) {
		String dateString;
		String output = "date || credit || debit || balance\n";
		Collections.reverse(paymentHistory);
		for(Payment payment: paymentHistory) {
			dateString = new SimpleDateFormat("yyyy/MM/dd").format(payment.paymentDate);
			output += dateString + " || " +
				      writeCreditOrDebit(payment.paymentAmount) +
				      String.format("%.2f", payment.postTransactionBalance) + "\n";
		}
		System.out.println(output);
		Collections.reverse(paymentHistory); // set back to normal
		return output;
	} 
	
	private static String writeCreditOrDebit(float paymentAmount) {
		if(paymentAmount > 0) {
			return "|| " + String.format("%.2f", ( paymentAmount)) + " || ";
		} else {
			return String.format("%.2f", (0 -  paymentAmount)) + " || || ";
		}
	}
}
