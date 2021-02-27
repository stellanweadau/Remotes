package io.github.oliviercailloux.samples.coffee;

/**
 * A specific espresso machine, that produces coffee of strength up to 20, whose
 * power is 2000 watts, and that produces a coffee of strength <em>s</em> in
 * <em>140 + 2 * s</em> seconds.
 *
 */
public class MyEspressoMachine implements EspressoMachine {

	public double strength;
	public int numberOfCoffees;
	public int energy;
	public int time;
	public double max_strength;
	public double lastCoffeeEnergy;

	@Override
	public double getMaxStrength() {
		// TODO Auto-generated method stub
		if (max_strength < 20) {
			throw new IllegalArgumentException("Must be upper than 20.");
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
			throw new IllegalStateException("machine has never produced coffee");
		}
		if ((lastCoffeeEnergy == 0) && (strength == 0)) {
			return energy;
		}
		return lastCoffeeEnergy;
	}


	@Override
	public double getPower() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}