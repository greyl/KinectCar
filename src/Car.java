
import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class Car {
	
	// create gpio controller instance
	//final private GpioController gpio;
	private GpioPinDigitalOutput forwardPin;
	private GpioPinDigitalOutput backwardPin;
	private GpioPinDigitalOutput leftPin;
	private GpioPinDigitalOutput rightPin;
	
	public Car() {
		
		/*gpio = GpioFactory.getInstance();
		
		// provision gpio pins as output pins and make sure is is set to LOW at startup
		forwardPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, PinState.LOW);
		backwardPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, PinState.LOW);
		leftPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, PinState.LOW);
		rightPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, PinState.LOW);
		*/
	}
	
	// 3 = off, 4 = left, 5 = right
	public void Steer(int direction) {
		
		switch (direction) {
		case 3:
			System.out.println("idle");
			//leftPin.low();
			//rightPin.low();
			
			break;
		case 4:
			System.out.println("left");
			//leftPin.low();
			//rightPin.high();
			
			break;
		case 5:
			System.out.println("right");
			//leftPin.low();
			//rightPin.high();
			
			break;
		}
		
	}
	
	// 0 = idle, 1 = forward, 2 = backward
	public void Thrust(int direction) {
			
		switch (direction) {
		case 0:
			System.out.println("idle");
			//forwardPin.low();
			//backwardPin.low();
				
			break;
		case 1:
			System.out.println("forward");
			//backwardPin.low();
			//forwardPin.high();
				
			break;
		case 2:
			System.out.println("backward");
			//forwardPin.low();
			//backwardPin.high();
				
			break;
		}
			
	}
	
	public void Shutdown() {
		System.out.println("shutdown");
		forwardPin.low();
		backwardPin.low();
		leftPin.low();
		rightPin.low();
		//gpio.shutdown();
	}

}
