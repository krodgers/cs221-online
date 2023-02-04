package lesson;

public class Shirt implements Comparable<Shirt>{
    public static enum Size {SMALL, MEDIUM, LARGE};

    private Size size;
    
    public Shirt(Size size){
	this.size = size;
    }


    public int compareTo(Shirt other){
	return this.size.compareTo(other.size);
    }
    

    public boolean equals(Shirt other){
	return this.size == other.size;
    }

}
