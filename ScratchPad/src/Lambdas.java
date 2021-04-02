
public class Lambdas {
	public static void main(String[] args) {
		Greeting myLambdaFunction = () -> System.out.println("Hello, world!");
		
		myLambdaFunction.perform();
	}
}

interface Greeting {
	public void perform();
}
