import javax.swing.JFrame;

public class MyServerTest {

	public static void main(String[] args) throws Exception {
		MyServer server = new MyServer();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.start();

	}

}
