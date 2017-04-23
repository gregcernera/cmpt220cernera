import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MyServer extends JFrame {
	
	private JTextArea chat;
	private JTextField txtbox;
	
	// elements for server setup and connection
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ServerSocket server;
	private Socket socket;
	
	// constructor for MyServer - sets up server window
	public MyServer() {
		
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
				+ "\n Warning: Use with descrition. The author is not responsible for the "
				+ "use of this program to participate in illegal activities. "
				+ "\n----------------------//------------------------------------");
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

	public void start() {
		String input = JOptionPane.showInputDialog("Enter port number"); // 6789 default
		int port = Integer.parseInt(input);
		try {
			server = new ServerSocket(port, 100);
			
			while(true) {
				try {
					// begin connection
					waitForConnection();
					establishConnection();
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
	
	// connect ports and set up streams
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
			try {
				message = (String) inputStream.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException e){
				showMessage("\n Error: Unintelligible data sent. Message cannot be shown.");
			}
		}while(!message.equals("$CLIENT > END"));
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
			outputStream.writeObject("#SERVER > " + msg);
			outputStream.flush();
			showMessage("\n#SERVER > " + msg);
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
	
	
	


