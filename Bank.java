package project1_5102;

import java.util.*;

/**
 * @author Mitul
 * 
 * StudentId 
 */
public class Bank {static Scanner input = new Scanner(System.in);
	String name, actype;
	public static String bank_name;
	public static String bank_number;
	int accno, bal, a;
	public static String account_number;
	public static String account_type;
	
	// Array accounts_number used to store the account numbers.
	public static String[] accounts_number = new String[] { "886869870", "886869871", "886869872", "886869873", "886869874", "886869875" };
	// Array accounts_type used to store the corresponding account types.
	public static String[] accounts_type = new String[] { "saving", "saving", "current", "saving", "current", "saving" };
	// Array accounts_amount used to store the corresponding amount in accounts
	public static String[] accounts_amount = new String[] { "999", "1500", "500", "2000", "150", "20000" };
	// Array accounts_bank used to store the corresponding amount in accounts
	public static String[] accounts_bank = new String[] { "ICICI Bank", "CIBC Bank", "ICICI Bank", "CIBC Bank", "Bank of Nova Scotia", "ICICI Bank" };
	// Array accounts_bank_number used to store the corresponding amount in accounts
	public static String[] accounts_bank_number = new String[] { "101", "102", "101", "102", "103", "101" };

	
	Bank(String name, int accno, String actype) {
		this.name = name;
		this.accno = accno;
		this.actype = actype;
	}

	public static String bankname = "ICICI bank";
	public static int BankNo;

	public int Deposit() {
		System.out.println("Enter the amount to deposit: ");
		a = input.nextInt();
		if (a < 0) {
			System.out.println("Invalid Amount");
			return 1;
		}
		bal = bal + a;
		return 0;
	}

	// Helper function to deposit amount to selected account
	public static String deposit(String accountNumber, String amount, int record_key) {
		accounts_amount[record_key] = String.valueOf( Integer.parseInt( accounts_amount[record_key] ) + Integer.parseInt( amount ) );
		return amount + " added into " + accountNumber + " succesfully";
	}
	
	// Helper function to withdraw amount to selected account
	public static String withdraw(String accountNumber, String amount, int record_key) {
		String str;
		if( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) > 0) {
			accounts_amount[record_key] = String.valueOf( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) );
			str = amount + " withdraw from " + accountNumber + " succesfully";
		} else {
			str = "Insufficient balance";
		}
		return str;
	}
	
	// Helper function to get balance amount from selected account
	public static String getBalance(int record_key) {
		return accounts_amount[record_key] + " is the Current Balance";
	}
	
	// Helper function to pay bill from selected account
	public static String payBill(String accountNumber, String amount, int record_key) {
		String str;
		if( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) > 0) {
			accounts_amount[record_key] = String.valueOf( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(amount) ) );
			str = amount + " paid succesfully from " + accountNumber;
		} else {
			str = "Insufficient balance";
		}
		return str;
	}

	// Helper function to send money from one account to another
	public static String sendMoney( String account_number, String sending_amount, int record_key, String receiver_account_number) {
		String str;
		boolean record_status = false;
		if( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(sending_amount) ) > 0) {
			accounts_amount[record_key] = String.valueOf( ( Integer.parseInt( accounts_amount[record_key] ) - Integer.parseInt(sending_amount) ) );
			str = sending_amount + " paid succesfully from " + account_number;
		} else {
			str = "Insufficient balance";
		}
		// getting the record key of entered account number.
		for(int i = 0; i < accounts_number.length; i++){
			if( receiver_account_number.equals( accounts_number[i] ) && !receiver_account_number.equals(account_number) ) {
				record_key = i;
				record_status = true;
				break;
			} else {
				record_status = false;
			}
		}
		if( record_status == true ) {
			accounts_amount[record_key] = String.valueOf( Integer.parseInt( accounts_amount[record_key] ) + Integer.parseInt( sending_amount ) );
			str =  sending_amount + " succesfully debited from " + account_number + " and credited to " + receiver_account_number;
		} else if( record_status == false ) {
			str = "Receiver's account number is invalid";
		}
		return str;
	}
	
	public static void getUniqueOnly(String arr[], int num) {
		for (int i = 0; i < num; i++) {
			int j;
			for (j = 0; j < i; j++) 
				if (arr[i] == arr[j])
					break;
			if (i == j)
				System.out.print( arr[i] + " : " + accounts_bank_number[getKey(arr, arr[i])]  + ", ");
		}
	}
	
	public static int getKey(String arr[], String element) {
		int key = 0;
		for (int i = 0; i < arr.length; i++) {
			if( element.equals( arr[i] )) {
				key = i;
				break;
			}
		}
		return key;
	}
	
	public static void validateAccountNumber(String account_number) {
//		System.out.println(" *** " + account_number + " *** ");
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
	}
	
	public static void main(String[] args) {
		int acc_type = 0;
		int record_key = 0;
		boolean record_status = false;
		String choice = "yes";
		int menu = 0;
		
		System.out.println("**Welcome to Bank Managment System**");
		System.out.println(" ");
		System.out.println("List of Banks we have :");
		getUniqueOnly(accounts_bank, accounts_bank.length);
		System.out.println("");
		System.out.println("Select the Bank by entering it's three digit code :");
		Scanner scanner = new Scanner(System.in);
		bank_number = scanner.nextLine();
		// Bank number length should be of Exactly 3 digits
		if( bank_number.length() != 3 ) {
			System.out.println("Invalid Bank Number Entered");
			System.exit(0);
		} else {
			System.out.println("Accounts in selected banks :");
			for (int i = 0; i < accounts_bank_number.length; i++) {
				if( bank_number.equals( accounts_bank_number[i] )) {
					System.out.println("Accounts Number : " + accounts_number[i] + ", Accounts Type : " + accounts_type[i] + ", Accounts amount : " + accounts_amount[i]);
				}
			}
		}
		
		System.out.println("Enter your from 6 to 16 digit numeric account number");
		account_number = scanner.nextLine();
		validateAccountNumber(account_number);
		
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
				System.out.println("Press 3 to Pay a bill ");
				System.out.println("Press 4 to Sending money");
				System.out.println("Press 5 to Exit");
				menu = scanner.nextInt();
				switch (menu) {
		            case 0: 
		            	int deposit_amount;
		            	System.out.println("Enter Amount to deposit : ");
		            	deposit_amount = scanner.nextInt();
		            	System.out.println(deposit( account_number, String.valueOf(deposit_amount), record_key ));
		            	break;
		            case 1: 
		            	int withdraw_amount;
		            	System.out.println("Enter Amount to withdraw : ");
		            	withdraw_amount = scanner.nextInt();
		            	System.out.println(withdraw( account_number, String.valueOf(withdraw_amount), record_key ));
		            	break;
		            case 2: 
		            	System.out.println(getBalance( record_key ));
		            	break;
		            case 3: 
		            	int bill_amount;
		            	System.out.println("Enter Amount of Bill : ");
		            	bill_amount = scanner.nextInt();
		            	System.out.println( payBill( account_number, String.valueOf(bill_amount), record_key) );
		            	break;
		            case 4:
		            	int sending_amount;
		            	String receiver_account_number;
		            	System.out.println("Enter Amount to send : ");
		            	sending_amount = scanner.nextInt();
		            	
		            	// Skip the newline
		            	scanner.nextLine();
		            	
		            	System.out.println("Enter Receiver's account number, it should be from 6 to 16 digit numeric account number : ");
		        		receiver_account_number = scanner.nextLine();
		        		validateAccountNumber(receiver_account_number);
		        		
		            	System.out.println( sendMoney( account_number, String.valueOf(sending_amount), record_key, receiver_account_number) );
		            	break;
		            case 5: 
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
}