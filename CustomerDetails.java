package com.zoho.bank;

public class CustomerDetails {
	private int userId;
	private String password;
	private String name;
	private Long accountNumber;
	private int pinNumber;
	private double balance;

	public CustomerDetails(int userId, String password, String name, long l, int pinNumber, double balance) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.accountNumber = l;
		this.pinNumber = pinNumber;
		this.balance = balance;
	}

	public CustomerDetails() {
		
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return accountNumber;
	}

	public void setId(Long id) {
		this.accountNumber = id;
	}

	public int getUsername() {
		return userId;
	}

	public void setUsername(int username) {
		this.userId = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
