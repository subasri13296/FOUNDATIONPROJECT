package org.inherit;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("current")
public class CurrentAccount extends BankAccount {
	private String memberName;
	private static double minimumAmountCanTransfer = 500000.00;
	private static int minimumNumberOfTransactions = 7;
	private double amountTransferred;
	private int numberOfTransactionsHeld=0;
	public CurrentAccount() {
		super();
		this.numberOfTransactionsHeld++;
	}
	public CurrentAccount(long accountNumber, String accountHolder, String address, long phoneNumber, double balance,
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
	public static double getMinimumAmountCanTransfer() {
		return minimumAmountCanTransfer;
	}
	public static void setMinimumAmountCanTransfer(double minimumAmountCanTransfer) {
		CurrentAccount.minimumAmountCanTransfer = minimumAmountCanTransfer;
	}
	public static int getMinimumNumberOfTransactions() {
		return minimumNumberOfTransactions;
	}
	public static void setMinimumNumberOfTransactions(int minimumNumberOfTransactions) {
		CurrentAccount.minimumNumberOfTransactions = minimumNumberOfTransactions;
	}
	public double getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(double amountTransferred) {
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

		return super.withdraw(amount);
	}
	@Override
	public boolean deposit(double amount) {
		// TODO Auto-generated method stub
		return super.deposit(amount);
	}
	
	
}
