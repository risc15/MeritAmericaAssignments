
public class QuadraticSolver extends Exception{
	public static void main(String[] args) throws Exception {
		double a = 3.0;
		double b = 2.0;
		double c = 3.0;
		
		double disc = b * b - 4.0 * a * c;
		if (disc < 0) throw new Exception();
		double sqrtDisc = Math.sqrt(disc);
		double x1 = -b + sqrtDisc;
		double x2 = -b - sqrtDisc;
		System.out.println(x1 + " " + x2);
	}
}
