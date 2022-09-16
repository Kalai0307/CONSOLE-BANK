package com.zoho.bank;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankManagement bankManagement = new BankManagement();
		System.out.println("bank");
		System.out.println("press 1:managerlogin");
		System.out.println("press 2:customer login");
		int number = sc.nextInt();
		if (number == 1) {
			if (bankManagement.login()) {
				while (true) {
					System.out.println("press 1 :all customer detals");
					System.out.println("press 2: add customer");
					int num = sc.nextInt();
					if (num == 1) {
						bankManagement.viewCustomers();
					} else if (num == 2) {
						bankManagement.addCustomer();
					}
				}
			} else {
				System.out.println("please enter correct userid and password");
			}
		} else {

			if (bankManagement.customerLogin()) {
				while (true) {
					System.out.println("press 1 :view account detals");
					System.out.println("press 2: change  password");
					System.out.println("press 3: view balance");
					System.out.println("press 4:transfer amount");
					System.out.println("press 5: view transacations");
					System.out.println("press 6: logout");
					int num = sc.nextInt();
					if (num == 1) {
						bankManagement.viewMyAccount();
					} else if (num == 2) {
						bankManagement.changeCustomerPINnumber();
					} else if (num == 3) {
						bankManagement.viewBalance();
					} else if (num == 4) {
						bankManagement.moneyTransfer();
					} else if (num == 5) {
						bankManagement.transactionHistory();
					} else if (num == 6) {
						System.exit(0);
					}
				}
			} else {
				System.out.println("please enter correct userid and password");
			}
		}
	}
}
