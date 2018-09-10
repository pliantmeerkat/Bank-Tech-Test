package test;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lib.Payment;
 
class PaymentTest {
	
	private Payment testPayment;
	private String testDate;
	private float testAmount = 500;
	private float goodPayerBalance = 1000;
	private float badPayerBalance = 200;
	private float postTransactionBalance = 500;
	
	@BeforeEach
	void initialize() {
		testDate = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		paymentDoesNotThrowErrorWhenValidAmount(); // in case of exception thrown improperly
	}
	
	// processed payment test
	
	@Test
	void paymentDoesNotThrowErrorWhenValidAmount() {
		try {
			testPayment = new Payment(testAmount, goodPayerBalance);
		} catch(IllegalArgumentException e) {
			fail("Exception should not be thrown for good info");
		}
	}
	
	// payment instance variable tests, all tests assume amounts == instances in initialise

	@Test
	void paymentHasDateVariable() {
		assertEquals(testDate, testPayment.paymentDate);
	}
	
	@Test
	void paymentHasPaymentAmountVariable() {
		assertEquals(testAmount, testPayment.paymentAmount);
	}
	
	@Test 
	void paymentSetsCurrentBalance() {
		assertEquals(testPayment.postTransactionBalance, postTransactionBalance);
	}
	
	//bad payment test
	
	@Test
	void paymentThrowsIllegalArgumentExceptionWhenInvalidAmount() {
		try {
			testPayment = new Payment(testAmount, badPayerBalance);
			fail("No exception thrown for bad input");
		} catch(IllegalArgumentException e) {
			assertEquals("Insufficient Funds", e.getMessage());
		}
	}
}
