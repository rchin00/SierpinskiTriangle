/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        //pythagoren theorem 
        double height = length*Math.sqrt(3)/2;
        return height;
	// WRITE YOUR CODE HERE
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        // have to create a new array with x values and y values because each one is different and corresponds to different coordinates
        double[] xValues = new double[] { x, x - length/2, x + length/2 };
        // can aslo use this method 
        //double[] xValues = new double[] 
        // xValues = { x, x-length/2, x + length/2 }; both will produce same result but current code is more concise
        double[] yValues = new double[] { y, y + height(length), y + height(length)};
       
        StdDraw.filledPolygon(xValues, yValues);
	// WRITE YOUR CODE HERE
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        //double[] xValuesSierpinski = 
        //StdDraw.polygon(x, y)
        if(n == 0) {// dont call return statement here bc u are just calling the function
            return;
        }

	// WRITE YOUR CODE HERE
        filledTriangle(x, y, length);
        sierpinski(n-1, x, y + height(length), length/2); // triangle up top coorinate point for bottom 
        sierpinski(n-1, x - length/2, y, length/2); //triangle to the left
        sierpinski(n-1, x + length/2, y, length/2); // triangle to the right that is small
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        double[] xCoordinates = new double[] {0.0, 0.5, 1.0};
        double[] yCoordinates = new double[] {0.0, Math.sqrt(3)/2, 0.0};
        int n = Integer.parseInt(args[0]);
        double length = 1.0;
        StdDraw.polygon(xCoordinates, yCoordinates);
        // this will create the outlined triangle
        // now we must call the sierpinksi triangle to actually fill it so 
        // we use 
        sierpinski(n, 0.5, 0, length/2);
        // the x coordinates will be at the midpoint of the base therefore x is x/2 and y remains zero. 
        //length will also change because you are beginning the function from the middle of the triangle's base
	// WRITE YOUR CODE HERE 
    }
}
