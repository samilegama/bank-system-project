/* 
 * Name: Samuel Ebba
 * Student ID: 040902847
 * Course & Section: CST8132 301
 * Assignment: Lab 8
 * Date: November 19, 2018
 */

package lab8;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.Scanner;

/**
 * This class stores four Account instances, of which two ChequingAccount and
 * two SavingsAccount.
 * 
 * @author Samuel Ebba
 * @version 1.4
 * @since 1.8
 */
public class Bank {
	private String bankName;
	private GenericArray accountArray;
	private static Scanner input;
	private DecimalFormat df;
	private Scanner scanner;
	private File file;
	private Formatter formatter;

	public Bank() {
		int num = 0;
		input = new Scanner(System.in);
		System.out.println("Please enter bank name: ");
		bankName = input.nextLine();
		System.out.println("Please create two chequing accounts ");
		accountArray = new GenericArray();

	}

	public void addAccount() {
		for (int i = 0; i < 2; i++) {
			System.out.println("Please enter the first name: ");
			String firstNmae = input.next();
			input.nextLine();
			System.out.println("Please enter the last name: ");
			String lastName = input.nextLine();
			System.out.println("Please enter the phone number: ");
			Long phoneNum = input.nextLong();
			System.out.println("Please enter the email: ");
			String email = input.nextLine();
			input.nextLine();
			Client client = new Client(firstNmae, lastName, phoneNum, email);

			System.out.println("Please enter the opening balance: ");
			double balance = input.nextDouble();

			Account a = new ChequingAccount(client, balance);
			accountArray.add(a);
		}

		System.out.println("Please create two saving accounts ");

		for (int i = 0; i < 2; i++) {
			System.out.println("Please enter the first name: ");
			String firstNmae = input.next();
			input.nextLine();
			System.out.println("Please enter the last name: ");
			String lastName = input.nextLine();
			System.out.println("Please enter the phone number: ");
			Long phoneNum = input.nextLong();
			System.out.println("Please enter the email: ");
			String email = input.nextLine();
			input.nextLine();
			Client client = new Client(firstNmae, lastName, phoneNum, email);

			System.out.println("Please enter the opening balance: ");
			double balance = input.nextDouble();

			Account a = new SavingsAccount(client, balance);
			accountArray.add(a);
		}
	}

	public void printAccounts() {
		df = new DecimalFormat();
		System.out.println("----------------Accounts List------------------ ");

		for (int i = 0; i < accountArray.size(); i++) {
			Account a = (Account) accountArray.get(i);
			System.out.println(a.toString());
		}
		openOutputFile();
		closeOutputFile();

	}

	public void openInputFile() {

		file = new File("src/bankinput.txt");
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void readRecords() {

		while (scanner.hasNextLine()) {
			String record = scanner.nextLine();

			String[] records = record.split(" ");
			if (records[0].toUpperCase().equals("C")) {

				Client client = new Client(records[1], records[2], Long.parseLong(records[3]), records[4]);
				Account a = new ChequingAccount(client, Double.parseDouble(records[5]));
				accountArray.add(a);

			} else if (records[0].toUpperCase().equals("S")) {
				Client client = new Client(records[1], records[2], Long.parseLong(records[3]), records[4]);
				Account a = new SavingsAccount(client, Double.parseDouble(records[5]));
				accountArray.add(a);
			}

		}
		System.out.println("Read input file sucessfully");

	}

	public void closeInputFile() {
		scanner.close();

	}

	public void openOutputFile() {

		try {
			formatter = new Formatter("src/bankoutput.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < accountArray.size(); i++) {
			Account a = (Account) accountArray.get(i);
			String output = a.toString();
			formatter.format("%s%n", output);
		}

	}

	public void closeOutputFile() {
		formatter.close();
	}

	public static void main(String[] args) throws Exception {
		input = new Scanner(System.in);
		Account[] accounts;
		Bank bank = new Bank();

		boolean flag = true;
		while (flag == true) {

			System.out.println(
					"Enter A for add 4 accounts, R for read record, P for print account, W for withdraw, D for Deposit, M for MonthlyProcess, Q for exit.");
			char choose = input.next().charAt(0);
			switch (choose) {
			case 'A':
			case 'a':
				bank.addAccount();
				break;
			case 'R':
			case 'r':
				bank.openInputFile();
				bank.readRecords();
				bank.closeInputFile();
				break;
			case 'P':
			case 'p':
				bank.printAccounts();
				break;

			case 'W':
			case 'w':
				System.out.println("Please enter index of the account:");
				int index = input.nextInt();
				System.out.println("Please enter amount of withdraw:");
				double amount = input.nextDouble();
				boolean boo = ((Account) bank.getAccountArray().get(index)).withdraw(amount);
				if (boo == false) {
					System.out.println("Insufficient Funds! Balance is $"
							+ ((Account) bank.getAccountArray().get(index)).getBalance() + ".");
					break;
				}
				break;
			case 'D':
			case 'd':
				System.out.println("Please enter index of the account:");
				int indexD = input.nextInt();
				System.out.println("Please enter amount of deposit:");
				double depositAmount = input.nextDouble();
				((Account) bank.getAccountArray().get(indexD)).deposit(depositAmount);
				System.out.println("You have already deposited $" + depositAmount + ".");
				break;

			case 'M':
			case 'm':
				for (int i = 0; i < bank.accountArray.size(); i++) {
					Account a = (Account) bank.accountArray.get(i);
					a.monthlyProcess();
				}
				System.out.println("monthlyProcess succesful!");
				break;
			case 'Q':
			case 'q':
				System.out.println("You have already exit the system, Please run it again");
				flag = false;
				break;
			}
		}
	}

	public GenericArray getAccountArray() {
		return accountArray;
	}

}