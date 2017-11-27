package org.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("savings")
public class SavingsAccount extends BankAccount {
	private String memberName;
	private static double maximumAmountCanTransfer = 100000.00;
	private static int maximumNumberOfTransactions = 5;
	private double amountTransferred;
	private int numberOfTransactionsHeld=0;

	public SavingsAccount() {
		super();
		this.numberOfTransactionsHeld++;
	}

	public SavingsAccount(long accountNumber, String accountHolder, String address, long phoneNumber, double balance,
			String memberName, double amountTransferred) {
		super(accountNumber, accountHolder, address, phoneNumber, balance);
		this.memberName = memberName;
		this.amountTransferred = amountTransferred;
		//this.numberOfTransactionsHeld = numberOfTransactionsHeld;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public static double getMaximumAmountCanTransfer() {
		return maximumAmountCanTransfer;
	}

	public static void setMaximumAmountCanTransfer(double maximumAmountCanTransfer) {
		SavingsAccount.maximumAmountCanTransfer = maximumAmountCanTransfer;
	}

	public static int getMaximumNumberOfTransactions() {
		return maximumNumberOfTransactions;
	}

	public static void setMaximumNumberOfTransactions(int maximumNumberOfTransactions) {
		SavingsAccount.maximumNumberOfTransactions = maximumNumberOfTransactions;
	}

	public double getAmountTransferred() {
		return amountTransferred;
	}

	public void setAmountTransferred(double amount) {
		this.amountTransferred = amountTransferred;
	}

	public int getNumberOfTransactionsHeld() {
		return numberOfTransactionsHeld;
	}

	public void setNumberOfTransactionsHeld(int numberOfTransactionsHeld) {
		this.numberOfTransactionsHeld = numberOfTransactionsHeld;
	}

	@Override
	public boolean withdraw(double amount) {
		// TODO Auto-generated method stub
		return super.withdraw(amount);
	}

	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return super.deposit(amount);
	}

}
