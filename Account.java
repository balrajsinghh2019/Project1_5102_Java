/**
 * 
 */
package project1_5102;

import java.util.Scanner;

/**
 * @author Balraj Singh
 *
 */
public class Account {
	
	public static String accountNo;
	public static String accountType;
	// record is used to store each account number with its account type and amount : {accountNo, accountType, amount}
	public static String[][] record = new String[][] {
		{"886869870", "saving", "999"},
	    {"886869871", "saving", "999"}
	};
	
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
		accountNo = scanner.nextLine();
		// Account number length should be from 6 to 16
		if( accountNo.length() < 6 || accountNo.length() > 16) {
			System.out.println("Invalid Account Number");
			System.exit(0);
		} else {
			for (char ch: accountNo.toCharArray()) { 
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
			accountType = "saving";
		} else if( acc_type == 2 ) {
			accountType = "checking";
		}
		
		// getting the record inner-array with matching entered account number.
		for(int i = 0; i < record.length; i++){
			if( accountNo.equals( record[i][0] ) && accountType.equals( record[i][1] ) ) {
				record_key = i;
				record_status = true;
				break;
			} else {
				record_status = false;
			}
		}
		
		if( record_status == true ) {
			while( choice.equalsIgnoreCase("YES") ) {
				System.out.println("Press 0 to Deposit, Press 1 to Withdraw, Press 2 to Check Balance and Press 3 to Exit.");
				menu = scanner.nextInt();
				switch (menu) {
		            case 0: 
		            	int deposit_amount;
		            	System.out.println("Enter Amount to deposit : ");
		            	deposit_amount = scanner.nextInt();
		            	System.out.println(deposit( accountNo, String.valueOf(deposit_amount), record_key ));
		            	break;
		            case 1: 
		            	int withdraw_amount;
		            	System.out.println("Enter Amount to withdraw : ");
		            	withdraw_amount = scanner.nextInt();
		            	System.out.println(withdraw( accountNo, String.valueOf(withdraw_amount), record_key ));
		            	break;
		            case 2: 
		            	System.out.println(getBalance( record_key ));
		            	break;
		            case 3: 
		            	System.out.println("exit");
		            	break;
		            default: 
		            	System.out.println("Incorrect Choice");
		            	break;
		        }
				System.out.println("Press YES if you want to continue.");
				choice = scanner.next();
			}	
		} else if( record_status == false ) {
			System.out.println("No " + accountType + " account exsist with " + accountNo + " number Please ask bank to create account");
		}
	}
	
	// Helper function to deposit amount to selected account
	public static String deposit(String accountNumber, String amount, int record_key) {
		record[record_key][2] = String.valueOf( Integer.parseInt( record[record_key][2] ) + Integer.parseInt( amount ) );
		return amount + " added into " + accountNumber + " succesfully";
	}

	// Helper function to withdraw amount to selected account
	public static String withdraw(String accountNumber, String amount, int record_key) {
		String str;
		if( ( Integer.parseInt(record[record_key][2]) - Integer.parseInt(amount) ) > 0) {
			record[record_key][2] = String.valueOf( ( Integer.parseInt(record[record_key][2]) - Integer.parseInt(amount) ) );
			str = amount + " withdraw from " + accountNumber + " succesfully";
		} else {
			str = "Insufficient balance";
		}
		return str;
	}

	// Helper function to get balance amount from selected account
	public static String getBalance(int record_key) {
		return record[record_key][2] + " is the Current Balance";
	}
}
