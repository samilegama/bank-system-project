/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 8
 * Date: November 19, 2018
 */

package lab8;

/**
 * This class tries to catch CapacityOutOfBoundsException.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 */
public class CapacityOutOfBoundsException extends RuntimeException {
	/**
	 * The default constructor for calls for super class for RuntimeException.
	 */
	public CapacityOutOfBoundsException() {
		super();
	}

	/**
	 * The initial constructor calling super class for CapacityOutOfBoundsException.
	 * 
	 * @param s
	 *            The super class CapacityOutOfBoundsException.
	 */
	public CapacityOutOfBoundsException(String s) {

		super(s);

	} // End of the constructor CapacityOutOfBoundsException.
} // End of the class CapacityOutOfBoundsException extends RuntimeException.
