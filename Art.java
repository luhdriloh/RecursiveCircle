/*--------------------------------------------------------------------
Name	: Samuel Moore
Description: This program creates a circle packed with 5 equal circle inside.

Argument takes i
---------------------------------------------------------------------*/
import java.awt.Color;

public class Art {
	
    public static void circle(int n, double x, double y, double radius) {
		if(n == 0) return;
		
		filledCircle(n, x, y, radius);
		
		double ratio, newRadius, hypotenuse,smallHypotenuse,
				h, a, side, down, rad;
		
		//Did an array because it is easier to keep track of things
		double[] xValues = new double[5]; 
		double[] yValues = new double[5];
		
		//ratio of inner circle to its parent circle
		ratio = 1 + Math.sqrt(2 * (1 + (1 / Math.sqrt(5)))); 
		//new radius
		newRadius = radius / ratio; 
		
		// new start point
		hypotenuse = radius - newRadius; 
		smallHypotenuse = Math.sqrt(Math.pow(hypotenuse, 2) + Math.pow(hypotenuse / 2, 2));
		// y distance of top 2 circles
		h = (1 - ((hypotenuse / 2) / smallHypotenuse)) / (hypotenuse / smallHypotenuse) * (hypotenuse / 2); 
		//x distance of top 2 circles
		a = Math.sqrt((Math.pow(hypotenuse, 2.0) - Math.pow(h, 2.0))); 
		//This is the length of one side of a pentagon, This tells me the distance 
		//that the 2 circles at the bottom must be seperated by
		side = (Math.sqrt(Math.pow(hypotenuse - h, 2) + Math.pow(a, 2))) / 2; 
		
		rad = Math.toRadians(54);
		down = Math.sqrt(Math.pow(hypotenuse, 2) + Math.pow(side, 2) - (2 * hypotenuse * side * Math.cos(rad)));
		//Above is the law of cosines to find the length needed to go down to draw the bottom 2 circles
		xValues[0] = x;
		yValues[0] = y + hypotenuse;
		
		xValues[1] = x + a;
		yValues[1] = y + h;
		
		xValues[2] = x - a;
		yValues[2] = y + h;
		
		xValues[3] = x + side;
		yValues[3] = y - down;
		
		xValues[4] = x - side;
		yValues[4] = y - down;
		
		circle(n -1, x, y, radius - newRadius * 2);
		circle(n -1, xValues[0], yValues[0], newRadius);
		circle(n -1, xValues[1], yValues[1], newRadius);
		circle(n -1, xValues[2], yValues[2], newRadius);
		circle(n -1, xValues[3], yValues[3], newRadius);
		circle(n -1, xValues[4], yValues[4], newRadius);	
		
    }
	
    public static void filledCircle(int n, double x, double y, double radius) {
		StdDraw.setPenColor(new Color((int) (Math.random() * 235), (int) (Math.random() * 235), (int) (Math.random() * 235)));  
		StdDraw.filledCircle(x, y, radius);
	}
	
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
		StdDraw.setXscale(-3, 3);
		StdDraw.setYscale(-3, 3);
		
		circle(n, 0, 0, 3);
    }
}
