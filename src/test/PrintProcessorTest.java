package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.BankAccount;
import lib.Payment;
import lib.PrintProcessor;

class PrintProcessorTest {
	
	String testDate;
	BankAccount testAccount;
	
	@BeforeEach
	void initialize() {
		testAccount = new BankAccount();
	}

	@Test
	void bankAccountPrintsTestExamplePayment() {
		testDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		List<Payment> stubPaymentHistory = new ArrayList<>();
		stubPaymentHistory.add( new Payment(500, 600));
		String testOutputString = (
				"date || credit || debit || balance\n"  +
				testDate + " || || 500.00 || 100.00\n"
		);
		assertEquals(testOutputString, PrintProcessor.printStatement(stubPaymentHistory));
	}

}
