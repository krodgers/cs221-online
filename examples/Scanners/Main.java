import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


/**
   Rules for using Scanners:
   - you should only ever have exactly ONE scanner open on the same resource
   - you should not mix calls to nextLine and nextInt/nextDouble/next using the same scanner
   - if a Scanner is passed as a parameter, assume it has been opened and do not close it
   - if YOU open a Scanner, don't forget to close it

   Example "resources" - System.in, a particular file, a String

 */
public class Main{



    public static void main(String[] args){

	// Create Main object so we can call the other methods
	Main mainObj = new Main();
	
	// Exactly ONE scanner open on System.in
	// kbd will read input from the user
	Scanner kbd = new Scanner(System.in);

	// Ask how many files there are to readEveryLine
	System.out.print("How many files to echo? ");
	
	// parse the int instead of nextInt otherwise, you'll get
	// input being skipped due to the difference in the way
	// nextLine and next/nextInt/etc handle newline characters
	int numFiles = Integer.parseInt(kbd.nextLine());

	for(int i = 0; i < numFiles; i++){
	    System.out.print("\nEnter filename: ");
	    String filename = kbd.nextLine();
	    System.out.println("\n\n");

	    try {
		// Opening a file could throw a FileNotFoundException
		// FileNotFoundException is a checked exception.  You have to handle it.
		
		// new Scanner to use to open the file
		Scanner fileScan = new Scanner(new File(filename));

		// Read and echo the file
		mainObj.readEveryLine(fileScan);
		
		// close fileScan
		fileScan.close();

	    } catch (FileNotFoundException e){
		System.out.println("Could not open " + filename);
	    }
	}

	// Generate data to read
	// Just to illustrate that because you're passing a Scanner,
	// the Scanner could be open on anything - a file, a string,
	// the keyboard, etc

	int[] ids = {1234, 2345, 3455, 4567};
	String[] names = {"Lilo", "Luna", "Philip", "Bucky"};
	int[] ages = {9, 12, 3, 1};

	String data = "";
	for(int i = 0; i < ids.length; i++){
	    data += ids[i] + " " + names[i] + " " + ages[i] + "\n";
	}

	// Read id/name/age data
	// Scanner open on the data
	System.out.println("\nReading Cat Data: " );
	Scanner petScan = new Scanner(data);
	mainObj.parseLines(petScan);
	petScan.close();

	kbd.close();

    }

    /**
       Reads and echos every line from scan
       @param scan - Scanner object already opened 
     */
    private void readEveryLine(Scanner scan){
	while(scan.hasNext()){
	    String line = scan.nextLine();
	    System.out.println(line);
	}
    }

    /**
       Each line contains 
       <idNumber> <name> <age>
     */
    private void parseLines(Scanner scan){
	// you don't have to open scan. Assume it's already been
	// opened.  Just use it like you normally would.  Don't create
	// a new Scanner object.  Just use scan.
	
	while(scan.hasNext()){
	    String line = scan.nextLine();

	    Scanner lineScan = new Scanner(line);
	    // using nextInt because we never call nextLine on lineScan
	    int id = lineScan.nextInt(); 
	    String name = lineScan.next();
	    int age = lineScan.nextInt();
	    // lineScan was opened in this method, so it should be closed in this method
	    lineScan.close();

	    System.out.println("ID: " + id + " (" + name + ", " + age + ")");
	}

    }

}
