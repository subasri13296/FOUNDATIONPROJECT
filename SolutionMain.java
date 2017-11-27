package org.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.inherit.CurrentAccount;
import org.inherit.SavingsAccount;
import org.inherit.BankAccount;

public class SolutionMain {

	public static void main(String[] args) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		session.beginTransaction();
		// int numberOftransactionsHeld;
		String memberName;
		double amountTransferred;
		
		System.out.println("Enter the account number:");
		long accountNumber = Long.valueOf(bf.readLine());
		System.out.println("Enter the account holder:");
		String accountHolder = bf.readLine();
		System.out.println("Enter the address:");
		String address = bf.readLine();
		System.out.println("Enter the phone number:");
		long phoneNumber = Long.valueOf(bf.readLine());
		System.out.println("Enter the balance:");
		double balance = Double.valueOf(bf.readLine());
		BankAccount ba = new BankAccount(accountNumber, accountHolder, address, phoneNumber, balance);
		ba.setAccountNumber(accountNumber);
		ba.setAccountHolder(accountHolder);
		ba.setAddress(address);
		ba.setPhoneNumber(phoneNumber);
		ba.setBalance(balance);
		
		System.out.println("enter your choice:\n1.withdraw\n 2.deposit");
		int ch = Integer.valueOf(bf.readLine());
		switch (ch) {

		case 1:
			System.out.println("Enter the amount to withdraw");
			amountTransferred = Double.valueOf(bf.readLine());

			System.out.println("Enter the type of account:");
			System.out.println("1.Savings\n 2. Current");
			int type = Integer.valueOf(bf.readLine());
			switch (type) {
			case 1:
				System.out.println("SAVINGS ACCOUNT");
				System.out.println("Enter the member name:");
				memberName = bf.readLine();

				
				SavingsAccount sa = new SavingsAccount(accountNumber, accountHolder, address, phoneNumber, balance,
						memberName, amountTransferred);
				sa.withdraw(amountTransferred);
				sa.setAccountNumber(accountNumber);
				sa.setAccountHolder(accountHolder);
				sa.setAddress(address);
				sa.setPhoneNumber(phoneNumber);
				sa.setMemberName(memberName);
				sa.setAmountTransferred(amountTransferred);
				sa.setBalance(balance);
				
				System.out.println("Transaction saved");

				session.save(sa);
				break;
			// session.save(acc);
			// session.save(four);
			case 2:

				System.out.println("CURENT ACCOUNT");
				System.out.println("Enter the member name:");
				memberName = bf.readLine();
				CurrentAccount ca = new CurrentAccount(accountNumber, accountHolder, address, phoneNumber, balance,
						memberName, amountTransferred);
				ca.withdraw(amountTransferred);
				ca.setAccountNumber(accountNumber);
				ca.setAccountHolder(accountHolder);
				ca.setAddress(address);
				ca.setPhoneNumber(phoneNumber);
				ca.setMemberName(memberName);
				ca.setAmountTransferred(amountTransferred);
				ca.setBalance(balance);
				
				System.out.println("Transaction saved");
				session.save(ca);
				break;
			}
			break;
		case 2:
			System.out.println("Enter the amount to deposit");
			amountTransferred = Double.valueOf(bf.readLine());

			System.out.println("Enter the type of account:");
			System.out.println("1.Savings\n 2. Current");
			int type1 = Integer.valueOf(bf.readLine());
			switch (type1) {
			case 1:
				System.out.println("SAVINGS ACCOUNT");
				System.out.println("Enter the member name:");
				memberName = bf.readLine();
				SavingsAccount sa = new SavingsAccount(accountNumber, accountHolder, address, phoneNumber, balance,
						memberName, amountTransferred);
				sa.deposit(amountTransferred);
				System.out.println("Transaction saved");
				sa.setAccountNumber(accountNumber);
				sa.setAccountHolder(accountHolder);
				sa.setAddress(address);
				sa.setPhoneNumber(phoneNumber);
				sa.setMemberName(memberName);
				sa.setAmountTransferred(amountTransferred);
				sa.setBalance(balance);
				session.save(sa);
				break;
			// session.save(acc);
			// session.save(four);
			case 2:

				System.out.println("CURENT ACCOUNT");
				System.out.println("Enter the member name:");
				memberName = bf.readLine();
				CurrentAccount ca = new CurrentAccount(accountNumber, accountHolder, address, phoneNumber, balance,
						memberName, amountTransferred);
				ca.deposit(amountTransferred);
				ca.setAccountNumber(accountNumber);
				ca.setAccountHolder(accountHolder);
				ca.setAddress(address);
				ca.setPhoneNumber(phoneNumber);
				ca.setMemberName(memberName);
				ca.setAmountTransferred(amountTransferred);
				ca.setBalance(balance);
			
				System.out.println("Transaction saved");
				session.save(ca);
				break;
			}
			break;

		}
		session.getTransaction().commit();
		session.close();
		sf.close();

	}
}
