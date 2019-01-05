/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 8
 * Date: November 19, 2018
 */

package lab8;

import java.util.Scanner;

/**
 * The class for client object contains the information of client.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 * @see java.util.Scanner
 */
public class Client {
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	public Client() {
		getFirstNameInput();
	}

	/**
	 * This constructor constructs clients with specified for fisrs name, last name,
	 * phone number and email.
	 * 
	 * @param firstName
	 *            First name of the client.
	 * @param lastName
	 *            Last name of the client.
	 * @param phoneNum
	 *            Phone number of the client.
	 * @param email
	 *            Email of the client.
	 */
	public Client(String firstName, String lastName, Long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	/**
	 * This method gets first name of the client.
	 * 
	 * @return First name of the client.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This method requests the user to enter the first name of the client.
	 */
	public void getFirstNameInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("enter firstname");
		this.firstName = in.next();
	}

	/**
	 * This method gets the last name of client.
	 * 
	 * @return The last name of the client.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This method gets the phone number of client.
	 * 
	 * @return Phone number of the client.
	 */
	public long getPhoneNum() {
		return phoneNum;
	}

	/**
	 * This method gets email of client.
	 * 
	 * @return Email of the client.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * This method is toString for the client.
	 * 
	 * @return The content of the client
	 */
	@Override
	public String toString() {
		return "Client [firstName=" + firstName + ", lastName=" + lastName + ", phoneNum=" + phoneNum + ", email="
				+ email + "]";
	} // End of the method.

} // End of the class.