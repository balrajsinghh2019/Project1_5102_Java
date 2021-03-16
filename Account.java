/**
 * 
 */
package project1_5102;

import java.util.Scanner;

/**
 * @author Mitul Champaneri
 *
 *         StudentId n01452882
 */
public class Account {

	public static String account_number;
	public static String account_type;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String choice = "yes";
		int acc_type = 0;
		int menu = 0;
		int record_key = 0;
		boolean record_status = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your from 6 to 16 digit numeric account number");//we request the account number from the user.
		account_number = scanner.nextLine();
		// Account number length should be from 6 to 16
		if (account_number.length() < 6 || account_number.length() > 16) {
			System.out.println("Invalid Account Number");
			System.exit(0);
		} else {
			for (char ch : account_number.toCharArray()) {
				// Account number length should contain only numbers
				if (ch <= '0' && ch >= '9') {
					System.out.println("Invalid Account Number");
					System.exit(0);
				}
			}
		}
		System.out.println("Please select account type. Press 1 for Saving and 2 for Checking");//we request user to enter 1 for saving and 2 for checking account.
		acc_type = scanner.nextInt();
		if (acc_type != 1 && acc_type != 2) {
			System.out.println("Invalid Selection");
			System.exit(0);
		} else if (acc_type == 1) {
			account_type = "saving";
		} else if (acc_type == 2) {
			account_type = "checking";
		}

		// getting the record key of entered account number.
		//record_key as explained in the video recording is the index which links the account number,its type, balance etc with one another.
		//it is basically the position.
		for (int i = 0; i < Bank.accounts_number.length; i++) {
			if (account_number.equals(Bank.accounts_number[i]) && account_type.equals(Bank.accounts_type[i])) {
				record_key = i;
				record_status = true;
				break;
			} else {
				record_status = false;
			}
		}

		if (record_status == true) {// we use switch case to create a menu driven program. 
			while (choice.equalsIgnoreCase("YES")) {
				System.out.println("Press 0 to Deposit");
				System.out.println("Press 1 to Withdraw");
				System.out.println("Press 2 to Check Balance");
				System.out.println("Press 3 to Exit");
				menu = scanner.nextInt();
				switch (menu) {
				case 0:
					int deposit_amount;
					System.out.println("Enter Amount to deposit : ");//deposit use case .
					deposit_amount = scanner.nextInt();
					System.out.println(Bank.deposit(account_number, String.valueOf(deposit_amount), record_key));
					break;
				case 1:
					int withdraw_amount;
					System.out.println("Enter Amount to withdraw : ");//withdraw use case.
					withdraw_amount = scanner.nextInt();
					System.out.println(Bank.withdraw(account_number, String.valueOf(withdraw_amount), record_key));
					break;
				case 2:
					System.out.println(Bank.getBalance(record_key));//request the balance for the account number mentioned above.
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Incorrect Choice");
					break;
				}
				System.out.println("Press YES if you want to continue.");
				choice = scanner.next();
			}
		} else if (record_status == false) {
			System.out.println("No " + account_type + " account exsist with " + account_number
					+ " number Please ask bank to create account");
		}
	}


}
