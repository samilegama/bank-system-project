/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 8
 * Date: November 19, 2018
 */

package lab8;

import java.util.Random;

/**
 * This class has a monthlyFee property which is initialized to a value of $5.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 */
public class ChequingAccount extends Account {

	private double monthlyFee = (double) (new Random().nextInt(6)) + 5.0;

	public ChequingAccount(Client client, double balance) {
		super(client, balance);
	}

	/**
	 * This method attempts to withdraw the monthly fee from the balance. If the
	 * balance is insufficient, an Exception should be thrown indicating the account
	 * number, balance, and fee in the Exception message. When caught, System.err
	 * will be displayed.
	 */
	public void monthlyProcess() throws Exception {
		if (super.getBalance() - monthlyFee < 0) {
			System.err.println("the balance is insufficient");
			throw new Exception("the balance is insufficient! Account Number:" + super.getAccountNum() + ", Balance:"
					+ super.getBalance() + ", Monthly Fee:" + monthlyFee);
		} else {
			super.setBalance(super.getBalance() - monthlyFee);
		}
	}

	/**
	 * This method overrides the object toString, and returns a String that
	 * containing all the properties of an Account and its Client.
	 */
	@Override
	public String toString() {
		return super.toString() + "ChequingAccount [monthlyFee=" + monthlyFee + "]";

	} // End of the method.
} // End of the class.