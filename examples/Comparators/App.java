package lesson;

/**
 * Demonstrates the correct and incorrect way to compare objects
 * @author: TODO
 */

public class App {

    public static void main(String[] args) {

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
	
	
    }
}
