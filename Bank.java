package project1_5102;

import java.util.*;

public class Bank {static Scanner input = new Scanner(System.in);
String name, actype;
static String bank_name = "ICICI Bank";
int accno, bal, a;

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

public int Withdraw() {
	System.out.println("Enter the amount to withdraw: ");
	a = input.nextInt();
	if (a < 0) {
		System.out.println();
		return 1;
	} else if (bal < a) {
		System.out.println("Not sufficient balance!");
		return 1;
	}
	bal = bal - a;
	return 0;
}

void displayBalance() {
	System.out.println("Balance:" + bal);
}

public int Paybill() {
	System.out.println("Enter the amount to Pay Bill: ");
	a = input.nextInt();
	if (a < 0) {
		System.out.println("Bill paid successfully");
		return 1;
	} else if (bal < a) {
		System.out.println("Not sufficient balance!");
		return 1;
	}
	bal = bal - a;
	return 0;
}

public int Sendmoney() {
	return 0;
}

public static void main(String[] args) {
	System.out.println(" Welcome to " + bank_name);
	int[] array = {100015245, 789541206, 879100653, 466352204, 811336655};
    for (int element: array) 
    {
        System.out.println(" List of accounts: " +element);
    }
	System.out.println("Enter your name: ");
	String n = input.nextLine();
	System.out.println("Enter Account number: ");
	int acc = input.nextInt();
	System.out.println("Enter Account Type: ");
	String acctype = input.next();
	Bank b1 = new Bank(n, acc, acctype);
	System.out.println("1. Deposit Amount");
	System.out.println("2. Withdraw Amount");
	System.out.println("3. Request Bank balance");
	System.out.println("4. Pay a Bill");
	System.out.println("5. Send Money to another account");
	System.out.println("6. Exit");
	int c;
	do {
		System.out.println("Enter your option:");
		c = input.nextInt();
		switch (c) {
		case 1:
			b1.Deposit();
			break;
		case 2:
			b1.Withdraw();
			break;
		case 3:
			b1.displayBalance();
			break;
		case 4:
			b1.Paybill();
			break;
		case 5:
			b1.Sendmoney();
			break;
		case 6:
			System.out.println("Thank you for banking with us!");
			break;

		}
	} while (c != 6);

}


}