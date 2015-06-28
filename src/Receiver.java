
import java.net.URI;
import java.util.Scanner;

import com.kaazing.gateway.client.html5.WebSocket;
import com.kaazing.gateway.client.html5.WebSocketEvent;
import com.kaazing.gateway.client.html5.WebSocketListener;

public class Receiver {
	
	private static Car car = new Car();

	public static void main(String[] args) {
		
		WebSocket mySocket;
		
		try {
			mySocket = new WebSocket();
			mySocket.addWebSocketListener(new WebSocketListener() {
				
            @Override
            public void onOpen(WebSocketEvent arg0) {
            	System.out.print("Enter input: ");
            	Scanner scanner = new Scanner(System.in);
            	String input = scanner.next();
            	System.out.println("Message sent ");
            try {
            	mySocket.send(input);
                } catch (Exception e) {
                	System.out.println(e.toString());
                	}
            }
            @Override
            public void onMessage(WebSocketEvent event) {
            	System.out.println("Message received... " + "WebSocket with data: " + event.getData());
            	if (Integer.parseInt(event.getData().toString()) == 0 || Integer.parseInt(event.getData().toString()) == 1 || Integer.parseInt(event.getData().toString()) == 2) {
            		car.Thrust(Integer.parseInt(event.getData().toString()));
            	}
            	else if (Integer.parseInt(event.getData().toString()) == 3 || Integer.parseInt(event.getData().toString()) == 4 || Integer.parseInt(event.getData().toString()) == 5) {
            		car.Steer(Integer.parseInt(event.getData().toString()));
            	}
            }
                
            @Override
            public void onClose(WebSocketEvent arg0) {
            	System.out.println("Websocket Closed");
            	}
            });
			
			mySocket.connect(new URI("ws://localhost:8001/echo"));
            Thread.sleep(10000);
            
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
