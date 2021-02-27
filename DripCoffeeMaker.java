package io.github.oliviercailloux.samples.coffee;

/**
 * <p>
 * A <a href=
 * "https://www.startpage.com/sp/search?query=drip+coffee+maker&cat=pics">drip
 * coffee maker</a>. It uses a specific brand of coffee, which makes it able to
 * produce coffee of any strength from 0 to 10. It takes a constant time of 2
 * minutes to produce coffee (of strength higher than zero). Unrealistically, we
 * suppose here that it produces only one coffee at a time.
 * </p>
 * <p>
 * The energy required for producing a coffee (of strength higher than zero) is
 * an estimated 83 <a href="https://en.wikipedia.org/wiki/Watt_hour">watt
 * hours</a>.
 * </p>
 */
public class DripCoffeeMaker implements CoffeeMachine {

	public double strength;
	public int numberOfCoffees;
	public int energy;
	public int time;
	public double max_strength;
	public double lastCoffeeEnergy;

	@Override
	// perhaps I misunderstood your indications and you only except me to return 10
	// I return the strength of the strongest coffee ordered by the user
	public double getMaxStrength() {
		// TODO Auto-generated method stub
		if ((max_strength > 10) || (max_strength < 0)) {
			throw new IllegalArgumentException("Must be between 0 and 10.");
		}
		return max_strength; 
	}


	@Override
	public int getTimeForCoffee(double strength) {
		// TODO Auto-generated method stub
		int time = (int) Math.round(120-(9*strength)); // The highest the strength is, the quickest the time is
		return time;
	}

	@Override
	public void produceCoffee(double strength) {
		// TODO Auto-generated method stub
		numberOfCoffees ++;
		if (strength > max_strength) {
			max_strength = strength; //we store the maximum strength used by the coffee user
		}
		lastCoffeeEnergy = strength * getTimeForCoffee(strength); //let's pretend that the calculation of the energy is reliable
		// TODO Auto-generated method stub	
	}

	@Override
	public int getNumberOfCoffeesProduced() {
		// TODO Auto-generated method stub
		if (numberOfCoffees < 0) {
			throw new IllegalArgumentException("Cant be lower than 0");
		}
		return numberOfCoffees;
	}

	@Override
	public double getEnergySpent() throws IllegalStateException {
		// TODO Auto-generated method stub
		if (numberOfCoffees < 0) {
			throw new IllegalStateException("The machine has never produced coffee.");
		}
		if ((lastCoffeeEnergy == 0) && (strength == 0)) {
			return energy;
		}
		return lastCoffeeEnergy;
	}

	
}