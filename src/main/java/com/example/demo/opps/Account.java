package com.example.demo.opps;

import java.util.Objects;
import java.util.Scanner;

public class Account {

	private Long acc_id;
	private double amount;
	private String acc_holder;
	private static Account acc;

	public Account(String acc_holder, Long acc_id, double amount) {
		this.setAcc_id(acc_id);
		this.amount = amount;
		this.acc_holder = acc_holder;
	}

	public String getAcc_holder() {
		return acc_holder;
	}

	public void setAcc_holder(String acc_holder) {
		this.acc_holder = acc_holder;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBal() {
		return getAmount();
	}

	public static void main(String[] args) {

		
		System.out.println("*** Select Options ***");
		System.out.println("1: Open Accoint");
		System.out.println("2: Enter withdraw Amount");
		System.out.println("3: Enter the deposite Amount");
		System.out.println("4: Check balance");
		System.out.println("5: Exit : Please enter -1");
		System.out.print("Enter option :");
		Scanner in = new Scanner(System.in);
		int input = in.nextInt();
		while (input > 0) {
			switch (input) {
			case 1:
				Scanner in1 = new Scanner(System.in);
				System.out.print("Enter yr name :");
				
				String acc_name = in1.nextLine();
				Scanner in2 = new Scanner(System.in);
				System.out.print("Enter deposite amount :");
				float amount = in2.nextFloat();
				
				
				Long accID = createAccountID(Math.random());
				Account ob1 = createAccount(acc_name, accID,amount);
				System.out.println("Welcome Yr account has been open successfully !!");
				ob1.displayAccount(ob1);
				input = newoption(in);
				break;
			case 2:
				System.out.print("Enter withdraw Amount : ");
				double salary = in.nextDouble();
				if(Objects.nonNull(getAccount())) 
				{
					getAccount().withdrawAmount(salary);
				}
				else {
					System.out.println("You dont have account .Plese open new account.");
				}
				input = newoption(in);
				break;
			case 3:
				System.out.print("Enter deposite Amount : ");
				double draw = in.nextDouble();
				if(Objects.nonNull(getAccount())) 
				{
					getAccount().deposit(draw);
				}
				else {
					System.out.println("You dont have account .Plese open new account.");
				}

				input = newoption(in);
				break;
			case 4:
				if(Objects.nonNull(getAccount())) 
				{
					getAccount().getBal();	
				}
				else {
					System.out.println("You dont have account .Plese open new account.");
				}
				input = newoption(in);
				break;

			default:
				System.out.println("Enter the correct options");
				input = newoption(in);
				break;
			}
		}
		if(input<0) {
			System.out.println("Thannk you for visit our bank !!!!");
		}
		

	}

	private static int newoption(Scanner in) {
		int input;
		System.out.print("Enter new option :");
		input =in.nextInt();
		return input;
	}

	private static Account createAccount(String acc_name, Long accID, float amount) {
		Account ob1 = new Account(acc_name, accID, amount);
		ob1.setAcc(ob1);
		return ob1;
	}

	public static Account getAccount() {
		return acc;

	}

	private void displayAccount(Account acc) {
		StringBuilder sb = new StringBuilder();
		sb.append("Your name : " + acc.getAcc_holder()).append("\r").append("Amount : " + acc.getBal()).append("\r")
				.append("Account ID :" + acc.getAcc_id());
		System.out.println(sb.toString());

	}

	private static Long createAccountID(double d) {
		System.out.println(d);
		return (long) ((d+1) * 100000);

	}

	private void deposit(double amount) {
		if (amount < 0) {
			System.out.println("Please enter the amount greater than 0");
		} else {
			setAmount(amount + getBal());
			System.out.println("Total Balance is : "+getBal());
		}

	}

	private void withdrawAmount(double amount) {
		if (getBal() <= 0) {
			System.out.println("No sufficient amount is availble ");
		} else if (amount > getBal()) {
			System.out.println("Please enter less than amount " + getBal());
		} else {
			System.out.println("Please collect withdraw Amount :" + amount);
			setAmount(getBal() - amount);
			System.out.println("Total Bal :" + getBal());
		}

	}

	public Long getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(Long acc_id) {
		this.acc_id = acc_id;
	}

	public Account getAcc() {
		return acc;
	}

	public void setAcc(Account acc) {
		this.acc = acc;
	}

}
