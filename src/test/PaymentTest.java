package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.Payment;

class PaymentTest {
	
	private Payment testPayment;
	
	@BeforeEach
	void initialize() {
		testPayment = new Payment();
	}
	
	// payment instance variable tests, all tests assume amounts == instances in initialise

	@Test
	void paymentHasDateVariable() {
		
	}
	
	@Test
	void paymentHasPaymentAmountVariable() {
		
	}
	
	@Test
	void paymentHasPayerBalanceVariable() {
		
	}
	
	// completed payment tests

}
