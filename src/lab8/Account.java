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
 * This class contains the basic properties and features of account.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 */

public abstract class Account {

	private long accountNum;
	private Client client;
	private double balance;

	public Account(Client client, double balance) {
		Random random = new Random();
		this.accountNum = random.nextLong();
		this.client = client;
		this.balance = balance;

	}

	abstract void monthlyProcess() throws Exception;

	public String getName() {
		return client.getFirstName() + " " + client.getLastName();
	}

	public void deposit(double amt) {
		balance = balance + amt;
	}

	public boolean withdraw(double amt) {

		if (balance - amt >= 0) {
			balance = balance - amt;
			return true;
		} else {
			return false;
		}

	}

	public long getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(long accountNum) {
		this.accountNum = accountNum;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return client.toString() + " " + balance;
	}

}
