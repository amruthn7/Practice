package inter;

import genericUtilities.Cars;

public class EnumSwtichBlock {

	public static void main(String[] args) {
		
		Cars c = Cars.AUDI;

		switch (c) {

		case BMW:
			System.out.println("You choose BMW !");
			break;
		case JEEP:
			System.out.println("You choose JEEP !");
			break;
		case AUDI:
			System.out.println("You choose AUDI !");
			break;
		case VOLKSWAGEN:
			System.out.println("You choose VOLKSWAGEN !");
			break;
		case NANO:
			System.out.println("You choose NANO !");
			break;
		case FIAT:
			System.out.println("You choose FIAT !");

		default:
			System.out.println("NEW BRAND'S CAR.");
			break;
		}
	}
}
