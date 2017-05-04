import java.io.*;
import java.net.*;
import java.security.Key;
import java.util.Base64;
import java.awt.*;
import java.awt.event.*;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.border.Border;

// SERVER/CLIENT INSTANT MESSAGING PROGRAM

public class MyServer extends JFrame {
	
	private JTextArea chat;
	private JTextField txtbox;
	
	// elements for server setup and connection
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ServerSocket server;
	private Socket socket;
	
	// key for encryption/decryption
	String KEY = "12345654321";
	
	// constructor for MyServer - sets up server window
	public MyServer() throws Exception {
		
		
		
		// create the form
		JFrame f = new JFrame("//anonymus instant messenger//");
		f.setSize(600, 600);
		f.setBackground(Color.GRAY);
		
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
				+ "To terminate the connection, type 'END' (all caps, no quotes) in the txt box. "
				+ "\n----------------------//------------------------------------\n");
		chat.setPreferredSize(new Dimension(600, 500));
		chat.setLineWrap(true);
		chat.setWrapStyleWord(true);
		chat.setAlignmentX(LEFT_ALIGNMENT);
		chat.setAlignmentY(TOP_ALIGNMENT);
		chat.setBackground(Color.BLACK);
		chat.setForeground(Color.WHITE);
		chat.setBorder(border);
		chat.scrollRectToVisible(getBounds());
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
		String input = JOptionPane.showInputDialog("Enter port number"); 
		int port = Integer.parseInt(input);
		try {
			server = new ServerSocket(port, 100);
			
			while(true) {
				try {
					// begin connection
					waitForConnection();
					establishConnection();
					// continually read messages
					continueProcessing();
				} catch(EOFException e) {
					showMessage("// The server host terminated the connection //");
				} finally {
					end();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			showMessage("\nError running program // now disabling connections and ports");
		}
		
		
	}
	
	// standby for client connection
	private void waitForConnection() throws IOException {
		showMessage("Setting up streams for connection...done\n");
		showMessage("Locating available ports...done\n");
		showMessage("Awaiting connection from possible client address...\n");
		socket = server.accept();
		showMessage("Connection established: This server is now connected to " + socket.getInetAddress().getHostName());
	}
	
	// connect ports and set up input and output streams
	private void establishConnection() throws IOException {
		outputStream = new ObjectOutputStream(socket.getOutputStream());
		outputStream.flush();
		inputStream = new ObjectInputStream(socket.getInputStream());
		showMessage("\n // connection established //");
	}
	
	// while the conversation is happening
	private void continueProcessing() throws IOException {
		String message = "You are now connected.";
		sendMessage(message);
		canType(true);
		
		do {
			//have a conversation
			// continually trying to read object from client
			try {
				message = (String) inputStream.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException e){
				showMessage("\n Error: Unintelligible data sent. Message cannot be shown.");
			}
		}while(!message.equals("$CLIENT > END"));
	}
	
	// close streams and sockets
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
	
	private void sendMessage(final String message) {
		try{
			outputStream.writeObject("#SERVER > " + message);
			outputStream.flush();
			showMessage("\n#SERVER > " + message);
		}catch(IOException e){
			chat.append("\n Error: unable to send message");
			e.printStackTrace();
		}
		
	}
	
	private void showMessage(final String message) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chat.append(message);
				}
			}
		);
	}
	
	// enable/disable setEditable
	private void canType(final boolean flag) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					txtbox.setEditable(flag);
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
	
	
	// DIFFIE-HELMAN KEY EXCHANGE
	private static int getFirstPrime() {
		boolean check;
		do {
			check = true;
			
			try {
				int num = Integer.parseInt(JOptionPane.showInputDialog("Enter first prime number"));
				if (isPrime(num))
					return num;
				else
					check = false;
				
			} catch (NumberFormatException e) {
				System.out.println("Error: two prime numbers are need to complete the key excange.");
				check = false;
			}
		} while (!check);
		return 0;
	}
	
	private static int getSecondPrime() {
		boolean check;
		do {
			check = true;
			
			try {
				int num = Integer.parseInt(JOptionPane.showInputDialog("Enter second prime number"));
				if (isPrime(num))
					return num;
				else
					check = false;
				
			} catch (NumberFormatException e) {
				System.out.println("Error: two prime numbers are need to complete the key excange.");
				check = false;
			}
		} while (!check);
		return 0;
	}
	
	private void sendNumbers() throws IOException {
		
	}
	
	private static boolean isPrime(int num) {
		if (num < 2) return false;
		if (num == 2) return false;
		if (num % 2 == 0) return false;
		for (int i = 3; i <= 0; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
}
	
	
	


