package lesson;

/**
 * Demonstrates the correct and incorrect way to compare objects
 * @author: krodgers
 */

public class App {

    public static void main(String[] args) {

	// Create three shirt objects
	// tshirt and dressShirt are considered equal, since they have
	// the same size
	Shirt tshirt = new Shirt(Shirt.Size.SMALL);
	Shirt gymShirt = new Shirt(Shirt.Size.LARGE);
	Shirt dressShirt = new Shirt(Shirt.Size.SMALL);


	// this compares addresses
	System.out.println("tshirt == dressShirt:");
	System.out.println(tshirt == dressShirt);

	// Java doesn't allow other relational operations
	// on addresses.
	// These cause an error
	//System.out.println("tshirt < gymShirt:");
	//System.out.println(tshirt < gymShirt);
	

	// this compares the instance variables
	System.out.println("tshirt.equals(dressShirt):");
	System.out.println(tshirt.equals(dressShirt));

	System.out.println("tshirt < gymShirt:");
	System.out.println((tshirt.compareTo(gymShirt) < 0) ? "Yes" : "No");
	// the line above uses a ternary operator
	// condition ? resultIfTrue : restultIfFalse
	
    }
}
