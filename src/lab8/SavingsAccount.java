/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 7
 * Date: November 19, 2018
 */

package lab8;

import java.util.Random;

/**
 * This class has an annual interest rate property which is be initialized to a
 * value 3%.
 * 
 * @author Samuel Ebba
 * @version 1.3
 * @since 1.8
 * 
 */
public class SavingsAccount extends Account {

	private double annualRate = ((double) (new Random().nextInt(5)) + 3.0) / 100;

	public SavingsAccount(Client client, double balance) {
		super(client, balance);
	}

	/**
	 * This method adds the calculated monthly interest to the balance. It overrides
	 * the object toString.
	 */
	@Override
	void monthlyProcess() throws Exception {
		super.setBalance(super.getBalance() + super.getBalance() * annualRate);

	}

	/**
	 * This method overrides the object toString, and returns a String that
	 * containing all the properties of an Account and its Client.
	 */
	@Override
	public String toString() {
		return super.toString() + "SavingsAccount [annualRate=" + annualRate + "]";

	} // End of the method.

} // End of the class.
