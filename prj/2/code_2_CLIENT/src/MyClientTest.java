import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyClientTest {
	
	public static void main(String[] args) {
		MyClient server_client;
		String ipAddress = JOptionPane.showInputDialog("Enter IP address"); //127.0.0.1
		server_client = new MyClient(ipAddress);
		server_client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server_client.start();
	}

}
