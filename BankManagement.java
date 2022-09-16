package com.zoho.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class BankManagement {
	static Long accountnumber = 9488034532l;
	static int currentId = 0;
	static int userid = 12346;
	Stack<String> transactionHistory = new Stack<>();
	HashMap<Integer, CustomerDetails> customer = new HashMap<Integer, CustomerDetails>() {
		{
			put(12345, new CustomerDetails(12345, "kalai", "kalaivani", 9488034531l, 1234, 2000.00));
			put(12346, new CustomerDetails(12346, "venkat", "venkataaman", 9488034532l, 9999, 20.00));
		}
	};

	public boolean login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the userId");
		String userid = sc.nextLine();
		System.out.println("enter password");
		String passWord = sc.nextLine();
		if (userid.equals("12345") && passWord.equals("kalai")) {
			return true;
		}
		return false;
	}

	public void viewCustomers() {

		for (Map.Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			CustomerDetails detail = customerList.getValue();
			System.out.println("acoount number" + detail.getAccountNumber());
			System.out.println("customer name " + detail.getName());
			System.out.println("balanace" + detail.getBalance());
		}
	}

	public void addCustomer() {
		Scanner sc = new Scanner(System.in);
		CustomerDetails customerDetails = new CustomerDetails();
		System.out.println("enter your name");
		String CustomerName = sc.nextLine();
		customerDetails.setName(CustomerName);
		Long accountNumber = accountnumber++;
		customerDetails.setAccountNumber(accountNumber);
		customerDetails.setPinNumber(1999);
		customerDetails.setBalance(0);
		customerDetails.setPassword(CustomerName);
		int userId = userid++;
		customerDetails.setUserId(userid);
		customer.put(userid, customerDetails);
	}

	public boolean customerLogin() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your user id ");
		int userid = sc.nextInt();
		for (Map.Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			CustomerDetails detail = customerList.getValue();
			if (userid == detail.getUserId()) {
				System.out.println("enter your password");
				{
					String password = sc.next();
					if (password.equals(detail.getPassword())) {
						currentId = detail.getUserId();
						return true;
					}
				}
			}
		}
		return false;
	}

	public void viewMyAccount() {
		for (Map.Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			if (currentId == customerList.getKey()) {
				CustomerDetails detail = customerList.getValue();
				System.out.println("           CANARA BANK -madurai branch              ");
				System.out.println("           ---------------------------              ");
				System.out.println("acoount number :" + detail.getAccountNumber());
				System.out.println("customer name  : " + detail.getName());
				System.out.println("balanace       :" + detail.getBalance());
			}
		}

	}

	public void changeCustomerPINnumber() {
		Scanner sc = new Scanner(System.in);
		for (Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			if (currentId == customerList.getKey()) {
				CustomerDetails detail = customerList.getValue();
				System.out.println("enetr your old pin");
				for (int i = 0; i < 3; i++) {
					int pin = sc.nextInt();
					if (pin == detail.getPinNumber()) {
						System.out.println("enter your  new pin number");
						pin = sc.nextInt();
						detail.setPinNumber(pin);
						return;
					} else {
						System.out.println("wrong pin");
					}

				}
				System.out.println("forget password");
				Random rand = new Random();
				int otpGenerated = rand.nextInt(10000);
				System.out.printf("your otp is :%04d%n", otpGenerated);

				for (int i = 0; i < 3; i++) {
					System.out.println("enter the otp");
					int otp = sc.nextInt();
					if (otp == otpGenerated) {
						System.out.println("enter your  new pin number");
						int pin = sc.nextInt();
						detail.setPinNumber(pin);
						System.out.println("your pin number is succesfully changed");
						return;
					} else {
						System.out.println("enter otp is wrong..please try again");
					}
				}
				System.out.println("sorry you are out of time ...please try again tommorrow");
			}
		}

	}

	public void viewBalance() {

		for (Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			if (currentId == customerList.getKey()) {
				CustomerDetails detail = customerList.getValue();
				System.out.println("your balance is :" + detail.getBalance());
			}
		}

	}

	public void moneyTransfer() {
		for (Entry<Integer, CustomerDetails> customerList : customer.entrySet()) {
			Scanner sc = new Scanner(System.in);
			if (currentId == customerList.getKey()) {
				CustomerDetails detail = customerList.getValue();
				System.out.println("enter the account number");
				long accountNoToBeDeposited = sc.nextLong();
				System.out.println("enter the amount to be deposited");
				double amountobedeposited = sc.nextDouble();
				if (detail.getBalance() > amountobedeposited && detail.getBalance() > 1000) {
					for (int i = 0; i < 3; i++) {
						System.out.println("enter the pin");
						int pin = sc.nextInt();
						if (pin == detail.getPinNumber()) {
							System.out.println("amount is successfully deposited into the recepient account");
							double balance = (detail.getBalance() - amountobedeposited);
							detail.setBalance(balance);
							System.out.println("your balance is " + detail.getBalance());
							transactionHistory.push(
									" the amount " + amountobedeposited + "vdeposited tov" + accountNoToBeDeposited);
							return;
						} else {
							System.out.println("wrong pin/...please try again");
						}

					}
				} else {
					System.out.println("your balance not sufficent to make this payment \n youe balance is  :"
							+ detail.getBalance());
				}

			}
		}

	}

	public void transactionHistory() {
		System.out.println(transactionHistory);
	}

}
