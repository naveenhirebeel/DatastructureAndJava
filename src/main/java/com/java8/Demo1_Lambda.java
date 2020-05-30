package all;

interface MathOperation {
	int calc(int a, int b);
}

interface Greeting {
	String name = "Have Some Name";
	String welcome(String message);
}

class GreetingImpl implements Greeting {
	@Override
	public String welcome(String message) {
		// TODO Auto-generated method stub
		return name;
	}
}

public class Demo1_Lambda {
	public static void main(String[] args) {

		// With Type Declaration and return type
		MathOperation mo = (a, b) -> {
			return a + b;
		};
		System.out.println(mo.calc(1, 2));

		// Without Type Declaration
		mo = (a, b) -> {
			return a - b;
		};
		System.out.println(mo.calc(2, 1));

		// Without Type Declaration and return type
		mo = (a, b) -> a * b;

		System.out.println(mo.calc(2, 2));
		
		//--------------------------------------------------------
		String msg = "Hi, ";
		Greeting greeting = message -> msg + message + " XYZ";
		
		System.out.println(greeting.welcome("Welcome"));
		
	}
}
