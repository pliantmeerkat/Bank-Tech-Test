package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.BankAccount;


class BankAccountTest {
	 
	private String testDate;
	private float depositAmount = 50.25f;
	private float testBalance = 700.55f;
	private float goodTestPaymentAmount = 500;
	private float badTestPaymentAmount = 1000;
	private BankAccount testAccount;
	
	void processTestExamplePayment() {
		testAccount.deposit(1000);
		testAccount.deposit(2000);
		testAccount.withdraw(500);
	}

	void makeSucessfulestWithdrawl(float testPaymentAmount) {
		try {
			testAccount.withdraw(testPaymentAmount);
		} catch(IllegalArgumentException e) {
			fail("Exception should not be trhown");
		}
	}
	
	void makeUnsucessfulWithdrawl(float testPaymentAmount) {
		try {
			testAccount.withdraw(testPaymentAmount);
			fail("No exception thrown");
		} catch(IllegalArgumentException e) {
			
		}
	}
	
	@BeforeEach
	void initialize() {
		testAccount = new BankAccount();
	}

	// account creation/ initialisation tests
	
	@Test
	void bankAccountHasZeroBalanceOnCreate() {
		assertEquals(0.00, testAccount.balance);
	}
	
	@Test
	void bankAccountHasEmptyArrayForHistory() {
		assertEquals(0, testAccount.paymentHistory.size());
	}
	
	// post account creation tests with good balance
	
	@Test
	void bankAccountDepositAddsToBalance() {
		testAccount.deposit(depositAmount);
		assertEquals(depositAmount, testAccount.balance);
	}
	
	@Test 
	void bankAccountBalanceDecreasesWIthWithdrawlPayment() {
		testAccount.balance = testBalance;
		float newBalance = testBalance - goodTestPaymentAmount;
		makeSucessfulestWithdrawl(goodTestPaymentAmount);
		assertEquals(newBalance, testAccount.balance);
	}
	
	@Test
	void bankAccountAddsPaymentToHistory() {
		testAccount.balance = testBalance;
		makeSucessfulestWithdrawl(goodTestPaymentAmount);
		assertEquals(1, testAccount.paymentHistory.size());
	}
	
	// bad payment tests
	
	@Test
	void bankAccountBalanceIsNotChangedByBadPayment() {
		makeUnsucessfulWithdrawl(badTestPaymentAmount);
		assertEquals(0, testAccount.balance);
	}
	
	@Test
	void bankAccountPaymentHistoryIsNotChangedByBadPayment() {
		makeUnsucessfulWithdrawl(badTestPaymentAmount);
		assertEquals(0, testAccount.paymentHistory.size());
	}
	
	// output Tests
	@Test
	void bankAccountPrintsTestExamplePayment() {
		processTestExamplePayment();
		testDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		String testOutputString = (
				"date || credit || debit || balance\n"  +
				testDate + " || || 500.00 || 2500.00\n" +
				testDate + " || 2000.00 || || 3000.00\n"   +
				testDate + " || 1000.00 || || 1000.00\n"
		);
		assertEquals(testOutputString, testAccount.printStatement());
	}
}
