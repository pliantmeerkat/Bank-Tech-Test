package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.BankAccount;

class BankAccountTest {
	
	private BankAccount testAccount;
	
	@BeforeEach
	void initialize() {
		testAccount = new BankAccount();
	}

	// account creation/ initialisation tests
	
	@Test
	void bankAccountHasZeroBalanceOnCreate() {
		assertEquals(testAccount.balance, 0);
	}
	
	@Test
	void bankAccountHasEmptyArrayForHistory() {
		assertEquals(testAccount.paymentHistory.size(), 0);
	}
	
	// post account creation tests
	
	@Test
	void bankAccountCanAddAPaymentToHistory() {
		
	}
	
	@Test
	void bankAccountPaymentEffectsBalance() {
		
	}

}
