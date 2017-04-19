import javax.swing.JFrame;

public class MyClientTest {
	
	public static void main(String[] args) {
		MyClient server_client;
		server_client = new MyClient("127.0.0.1");
		server_client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server_client.start();
	}

}
