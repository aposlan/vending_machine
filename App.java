package vending_machine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
	
	public static BufferedReader reader;

	public static void main(String[] args) throws UnrecognisedMoneyException, InterruptedException, NumberFormatException, NotEnoughMoneyException, IOException {

		VendingMachine vm = new VendingMachine();

		System.out.println("MACHINE WORKS WITH "
				+ "\n0.01, 0.02, 0.05. 0.10 0.20"
				+ "\n0.50, 1.00, 2.00, 5.00, 10.00 LEVA"
				+ "\nINPUT THE NUMBER OF THE ITEM THAT YOU'D LIKE"
				+ "\nAFTER INSERTING MONEY, YOU CAN TYPE -1 TO GET"
				+ "\nA FULL REFUND");
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		int item = Integer.parseInt(reader.readLine());
		
		try {
			System.out.println("Item price: " + Item.values()[item].getPrice());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		double money = 0;
		
		while(!(money == -1) && vm.getBalance() < Item.values()[item].getPrice()) {
			System.out.print("Input money : ");
			money = Double.parseDouble(reader.readLine());
			vm.addMoney(money);
		}
		
		if(money == -1)
			System.out.println(vm.calculateChange());
		
		System.out.println("---------------------");
		
		System.out.println(vm.getItem(item));
		
		System.out.println("---------------------");

		for (Money m : Money.values())
			System.out.println(m.name() + " : " + m.getQuantity());
		
		System.out.println("---------------------");
		
		reader.close();

	}

}
