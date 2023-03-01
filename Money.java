package vending_machine;

public enum Money {

	TEN_LEVA(10, 25), FIVE_LEVA(5, 25), TWO_LEVA(2, 25), LEV(1, 25), FIFTY(0.5, 25), TWENTY(0.2, 25), TEN(0.1, 25),
	FIVE(0.05, 25), TWO(0.02, 25), ONE(0.01, 25),;

	private double value;
	private int quantity;

	Money(double value, int quantity) {
		this.value = value;
		this.quantity = quantity;
	}

	public double getValue() {
		return value;
	}

	public double getQuantity() {
		return quantity;
	}

	public void modifyQuantity(double modifier) {
		quantity += modifier;
	}

}
