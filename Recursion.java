
public class Recursion {
 static double pi = 3.14;
	
	static double compArea(double radius){
	
		double area =  pi * radius * radius;
		return area;
	}
	
	static double compCircumference(double rad){
		
		double circumference = 2 * pi * rad;
		return circumference;
		
	}
	//computes and displays the area of a circle when passed a radius
	static void summariseCircle (double radius) {
		String summary = ""; 
		double result = compArea(radius);
		compCircumference(radius);
		System.out.println(summary + result);
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	double r = 5.6;
	double area = compArea(r);
	System.out.println(area);
	r = 1.2;
	area = compArea(r);
	System.out.println(area);
	summariseCircle(r);


	}

}
