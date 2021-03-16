/**
 * 
 */
package project1_5102;

import java.util.Scanner;

/**
 * @author Balraj Singh
 *
 * StudentId n01415998
 */
public class Account {
	
	public static String account_number;
	public static String account_type;

	// Array accounts_number used to store the account numbers.
	public static String[] accounts_number = new String[] { "886869870", "886869871" };
	// Array accounts_type used to store the corresponding account types.
	public static String[] accounts_type = new String[] { "saving", "saving" };
	// Array accounts_amount used to store the corresponding amount in accounts
	public static String[] accounts_amount = new String[] { "999", "1500" };
	
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
		System.out.println("Enter your from 6 to 16 digit numeric account number");
		account_number = scanner.nextLine();
		// Account number length should be from 6 to 16
		if( account_number.length() < 6 || account_number.length() > 16) {
			System.out.println("Invalid Account Number");
			System.exit(0);
		} else {
			for (char ch: account_number.toCharArray()) { 
				// Account number length should contain only numbers
				if( ch <= '0' && ch >= '9' ) {
					System.out.println("Invalid Account Number");
					System.exit(0);		
				}
			}
		}
		System.out.println("Please select account type. Press 1 for Saving and 2 for Checking");
		acc_type = scanner.nextInt();
		if( acc_type != 1 && acc_type != 2 ) {
			System.out.println("Invalid Selection");
			System.exit(0);
		} else if( acc_type == 1 ) {
			account_type = "saving";
		} else if( acc_type == 2 ) {
			account_type = "checking";
		}
		
		// getting the record key of entered account number.
		for(int i = 0; i < accounts_number.length; i++){
			if( account_number.equals( accounts_number[i] ) && account_type.equals( accounts_type[i] ) ) {
				record_key = i;
				record_status = true;
				break;
			} else {
				record_status = false;
			}
		}
		
		if( record_status == true ) {
			while( choice.equalsIgnoreCase("YES") ) {
				System.out.println("Press 0 to Deposit");
				System.out.println("Press 1 to Withdraw");
				System.out.println("Press 2 to Check Balance");
				System.out.println("Press 3 to Exit");
				menu = scanner.nextInt();
				switch (menu) {
		            case 0: 
		            	int deposit_amount;
		            	System.out.println("Enter Amount to deposit : ");
		            	deposit_amount = scanner.nextInt();
		            	System.out.println(Bank.deposit( account_number, String.valueOf(deposit_amount), record_key ));
		            	break;
		            case 1: 
		            	int withdraw_amount;
		            	System.out.println("Enter Amount to withdraw : ");
		            	withdraw_amount = scanner.nextInt();
		            	System.out.println(Bank.withdraw( account_number, String.valueOf(withdraw_amount), record_key ));
		            	break;
		            case 2: 
		            	System.out.println(Bank.getBalance( record_key ));
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
		} else if( record_status == false ) {
			System.out.println("No " + account_type + " account exsist with " + account_number + " number Please ask bank to create account");
		}
	}
	
//	// Helper function to deposit amount to selected account
//	public static String deposit(String accountNumber, String amount, int record_key) {
//		accounts_amount[record_key] = String.valueOf( Integer.parseInt( accounts_amount[record_key] ) + Integer.parseInt( amount ) );
//		return amount + " added into " + accountNumber + " succesfully";
//	}
//
//	// Helper function to withdraw amount to selected account
//	public static String withdraw(String accountNumber, String amount, int record_key) {
//		String str;
//		if( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) > 0) {
//			accounts_amount[record_key] = String.valueOf( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) );
//			str = amount + " withdraw from " + accountNumber + " succesfully";
//		} else {
//			str = "Insufficient balance";
//		}
//		return str;
//	}
//
//	// Helper function to get balance amount from selected account
//	public static String getBalance(int record_key) {
//		return accounts_amount[record_key] + " is the Current Balance";
//	}
}
