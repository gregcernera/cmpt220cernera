import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class MyClient extends JFrame{
	private JTextArea chat;
	private JTextField txtbox;
	
	// elements for server setup and connection
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ServerSocket server;
	private Socket socket;
	private String IP;
	private String message = "";
	
	// key for encryption/decryption
	String KEY = "12345654321";
	
	// constructor for MyServer - sets up server window
	public MyClient(String host) {
		// MAY HAVE TO ALTER THE CONSTRUCTOR FROM THE MYSERVER CLASS
		
		IP = host;
		
		// create the form
		JFrame f = new JFrame("//anonymus instant messenger//");
		f.setSize(600, 600);
		f.setBackground(Color.GRAY);
		f.setResizable(true);
		
		Border border = BorderFactory.createLineBorder(Color.CYAN, 2);
		
		// add the text box to the form
		txtbox = new JTextField("Sample text.");
		txtbox.setPreferredSize(new Dimension(200,25));
		txtbox.setBackground(Color.BLACK);
		txtbox.setForeground(Color.WHITE);
		txtbox.setBorder(border);
		txtbox.setEditable(false);
		f.add(txtbox, BorderLayout.SOUTH);
		
		// add the chat window
		chat = new JTextArea("//Welcome to AnonymousIM//. \n This is a program "
				+ "for sending instant messages from server to client anonymously. "
				+ "\n Warning: Use with discretion. The author is not responsible for the "
				+ "use of this program to participate in illegal activities. "
				+ "To end the connection, type 'END' (all caps, no quotes) in the txt box. "
				+ "\n----------------------//------------------------------------\n");
		chat.setPreferredSize(new Dimension(600, 500));
		chat.setLineWrap(true);
		chat.setWrapStyleWord(true);
		chat.setAlignmentX(LEFT_ALIGNMENT);
		chat.setAlignmentY(TOP_ALIGNMENT);
		chat.setBackground(Color.BLACK);
		chat.setForeground(Color.WHITE);
		chat.setBorder(border);
		f.add(chat, BorderLayout.NORTH);
		
		
		f.setVisible(true);
		
		
		txtbox.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						sendMessage(event.getActionCommand());
						txtbox.setText("");
					}
				}
			);
				
		
	}
	
	// ** IM functionality

	public void start() {
		try{
			// connect to server's open port
			connect();
			establishConnection();
			// continually read messages
			continueProcessing();
		}catch(EOFException e) {
			showMessage("\n Connection ended by: CLIENT");
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			end();
		}
	}
	
	// connect to server's port
	private void connect() throws IOException {
		String input = JOptionPane.showInputDialog("Enter port number");
		int port = Integer.parseInt(input);
		showMessage("Connecting... \n");
		socket = new Socket(InetAddress.getByName(IP), port);
		showMessage("Connected to: " + socket.getInetAddress().getHostName());
	}
	
	// connect ports and set up streams
	private void establishConnection() throws IOException {
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(socket.getInputStream());
		showMessage("\n // connection established //");
	}
	
	// while the conversation is happening
	private void continueProcessing() throws IOException {
		canType(true);
		do{
			try{
				message = (String) inputStream.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException e) {
				showMessage("\n Error: unintelligible data to send.");
			}
		}while(!message.equals("#SERVER > END"));
	}
	
	// close streams and detatch
	private void end() {
		showMessage("\n Closing connections... \n");
		canType(false);
		try{
			outputStream.close();
			inputStream.close();
			socket.close();
		}catch(IOException e){
			showMessage("\n Did not close correctly");
			e.printStackTrace();
		}
	}
	
	private void sendMessage(final String msg) {
		try{
			outputStream.writeObject("$CLIENT > " + msg);
			outputStream.flush();
			showMessage("\n$CLIENT > " + msg);
		}catch(IOException e){
			chat.append("\n Error: unable to send message");
			e.printStackTrace();
		}
		
	}
	
	private void showMessage(final String msg) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chat.append(msg);
				}
			}
		);
	}
	
	// enable/disable setEditable
	private void canType(final boolean tof) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					txtbox.setEditable(tof);
				}
			}
		);
	}
	
	// ** encryption (couldn't figure out)
	
	private static String encrypt(String plainText, String secretKey) {
		StringBuffer encryptedString = new StringBuffer();
		int encryptedInt;
		for (int i = 0; i < plainText.length(); i++) {
			int plainTextInt = (int) (plainText.charAt(i) - 'A');
			int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			encryptedInt = (plainTextInt + secretKeyInt) % 26;
			encryptedString.append((char) ((encryptedInt) + (int) 'A'));
		}
		return encryptedString.toString();
	}

	private static String decrypt(String decryptedText, String secretKey) {
		StringBuffer decryptedString = new StringBuffer();
		int decryptedInt;
		for (int i = 0; i < decryptedText.length(); i++) {
			int decryptedTextInt = (int) (decryptedText.charAt(i) - 'A');
			int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
			decryptedInt = decryptedTextInt - secretKeyInt;
			if (decryptedInt < 1)
				decryptedInt += 26;
			decryptedString.append((char) ((decryptedInt) + (int) 'A'));
		}
		return decryptedString.toString();
	}
	
}
