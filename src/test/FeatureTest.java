package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import lib.BankAccount;

class FeatureTest {
	
	private BankAccount testAccount;
	private String testDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	private String testOutputString = (
			"date || credit || debit || balance\n"  +
			testDate + " || || 500.00 || 2500.00\n" +
			testDate + " || 2000.00 || || 3000.00\n"   +
			testDate + " || 1000.00 || || 1000.00\n"
	);
	
	void processTestExamplePayment() {
		testAccount.deposit(1000);
		testAccount.deposit(2000);
		testAccount.withdraw(500);
	}

	@Test
	void bankAccountCanProcessPaymentsAndPrintStatement() {
		testAccount = new BankAccount();
		processTestExamplePayment();
		assertEquals(testAccount.printStatement(), testOutputString);
	}

}
