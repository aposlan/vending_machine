package vending_machine;

public class NotEnoughMoneyException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = "Not enough money exception!";

	public String getMessage() {
		return message;
	}

	public static boolean validate(double balance, int index) throws NotEnoughMoneyException {
		if (balance >= Item.values()[index].getPrice())
			return true;
		throw new NotEnoughMoneyException();
	}

}
