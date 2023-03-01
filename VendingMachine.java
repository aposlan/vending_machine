package vending_machine;

import java.util.ArrayList;;

public class VendingMachine {

	private double balance;
	private double income;

	VendingMachine() {
		balance = 0;
		income = 0;
	}

	public double getBalance() {
		return balance;
	}

	public double getIncome() {
		return income;
	}

	public boolean addMoney(double money) throws UnrecognisedMoneyException {
		try {
			UnrecognisedMoneyException.validate(money);
			balance += Double.parseDouble(String.format("%.1f", money));
			income += money;
			System.out.println("Balance : " + balance);
		} catch (UnrecognisedMoneyException ucobe) {
			System.out.println(ucobe.getMessage());
			return false;
		}
		return true;
	}

	public void resetMoney() throws InterruptedException {
		income -= balance;
		System.out.println(calculateChange());
		balance = 0;
	}

	public Item getItem(int index) throws NotEnoughMoneyException, InterruptedException {
		try {
			NotEnoughMoneyException.validate(balance, index);
			balance -= Item.values()[index].getPrice();
		} catch (NotEnoughMoneyException neme) {
			System.out.println(neme.getMessage());
			return null;
		}
		System.out.println(calculateChange());
		return Item.values()[index];
	}

	public ArrayList<Double> calculateChange() throws InterruptedException {
		ArrayList<Double> change = new ArrayList<>();
		for (Money m : Money.values()) {
			while (balance >= m.getValue()) {
				balance -= m.getValue();
				Money.valueOf(m.name()).modifyQuantity(-1);
				change.add(m.getValue());
			}
		}
		return change;
	}

}
