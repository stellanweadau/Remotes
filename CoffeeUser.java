package io.github.oliviercailloux.samples.coffee;

public class CoffeeUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DripCoffeeMaker coffee = new DripCoffeeMaker();
		coffee.produceCoffee(5);
		coffee.produceCoffee(8);
		coffee.produceCoffee(2.545);
		System.out.println("Coffee preparation takes "+coffee.getTimeForCoffee(5) +" sec");
		System.out.println("The energy is "+ coffee.getEnergySpent());
		System.out.println(coffee.getNumberOfCoffeesProduced() +" have been produced thus far");
		System.out.println("The strength maximum is "+ coffee.getMaxStrength());


	}

}
