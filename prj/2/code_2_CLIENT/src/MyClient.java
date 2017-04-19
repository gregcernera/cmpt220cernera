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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	
	// constructor for MyServer - sets up server window
	public MyClient(String host) {
		// MAY HAVE TO ALTER THE CONSTRUCTOR FROM THE MYSERVER CLASS
		
		IP = host;
		
		// create the form
		JFrame f = new JFrame("//anonymus instant messenger//");
		f.setSize(400, 360);
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
				+ "\n Warning: Use with descrition. The author is not responsible for the "
				+ "use of this program to participate in illegal activities. "
				+ "\n----------------------//------------------------------------");
		chat.setPreferredSize(new Dimension(200, 300));
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

	public void start() {
		try{
			connect();
			establishConnection();
			continueProcessing();
		}catch(EOFException e) {
			showMessage("\n Connection ended by: CLIENT");
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			end();
		}
	}
	
	// standby for client connection
	private void connect() throws IOException {
		showMessage("Connecting... \n");
		socket = new Socket(InetAddress.getByName(IP), 6789);
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
	
	private void end() {
		showMessage("\n Closing connections... \n");
		canType(false);
		try{
			outputStream.close();
			inputStream.close();
			socket.close();
		}catch(IOException e){
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
	
	private void canType(final boolean tof) {
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					txtbox.setEditable(tof);
				}
			}
		);
	}
	
	private String encrypt(String message) {
		return "";
	}
	
	private String decrypt(String message) {
		return "";
	}
}
