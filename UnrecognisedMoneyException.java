package vending_machine;

public class UnrecognisedMoneyException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message = "Unrecognised coin or bill exception!";

	public String getMessage() {
		return message;
	}

	public static boolean validate(double money) throws UnrecognisedMoneyException {
		for (Money m : Money.values())
			if (m.getValue() == money)
				return true;
		throw new UnrecognisedMoneyException();
	}

}
