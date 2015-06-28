import java.util.Scanner;

public class Controller {
	
	private static Car car = new Car();

	public static void main(String[] args) {
		
		System.out.print("Enter input: ");
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.next();
    	
    	while(Integer.parseInt(input) != -1) {
    		if (Integer.parseInt(input) == 0 || Integer.parseInt(input) == 1 || Integer.parseInt(input) == 2) {
        		car.Thrust(Integer.parseInt(input));
        		System.out.print("Enter input: ");
        		input = scanner.next();
        	}
    		else if (Integer.parseInt(input) == 3 || Integer.parseInt(input) == 4 || Integer.parseInt(input) == 5) {
        		car.Steer(Integer.parseInt(input));
        		System.out.print("Enter input: ");
        		input = scanner.next();
        	}
    	}

	}

}
