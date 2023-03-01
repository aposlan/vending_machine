package vending_machine;

public enum Item {

	CHOCOLATE(1.5), PEPSI(1), BREADSTICKS(0.8), CHIPS(2.2);

	private double price;

	Item(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

}
