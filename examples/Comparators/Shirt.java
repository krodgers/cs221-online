package lesson;

/**
 * A class representing a shirt with a size of small, medium or large.
 * Implements comparable so Shirts can be compared by size, with small
 * being the least and large being the greatest.
 *
 * @author krodgers
 */
public class Shirt implements Comparable<Shirt>{
    // type-safe size
    public static enum Size {SMALL, MEDIUM, LARGE};

    // size of the shirt
    private Size size;

    /**
     * Creates a shirt with specified size
     * @param size - the size of the shirt as defined by Shirt.Size
     */
    public Shirt(Size size){
	this.size = size;
    }


    /**
     * Compares this shirt to other based on the shirts' sizes.
     *
     * @param other - the shirt to compare to this shirt
     * @return something negative, if this shirt has a smaller size than other
     *         something positive, if this shirt has a larger size than other
     *         zero, if shirts have the same size
     *
     */
    public int compareTo(Shirt other){
	return this.size.compareTo(other.size);
    }
    

    /**
     * Compares this shirt to other based on the shirts' sizes.
     *
     * @param other - the shirt to compare to this shirt
     * @return true if shirts have the same size; false otherwise
     *
     */
    public boolean equals(Shirt other){
	return this.size == other.size;
    }

}
