package finalproject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.io.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.net.ServerSocket;
import java.net.Socket;


public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final static JTextArea msgArea = new JTextArea();

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		String msgin = "";
		try{
			
			ss = new ServerSocket(1201); //The Server starts at 1201 port number. 
			s = ss.accept();//Allows the new server to accept the connections. 
			
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			
			while(!msgin.equals("exit")){
				msgin = input.readUTF();
				
				//Displays the message from the client. 
				msgArea.setText(msgArea.getText().trim()+"\n"+msgin); 
			}
		}catch(Exception e){
			
		}
	}
		static ServerSocket ss;
		static Socket s;
		static DataInputStream input;
		static DataOutputStream output;

	/**
	 * Create the frame.
	 */
	public Server() {
		setTitle("Server Chat Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnSend.setBounds(335, 204, 89, 46);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 12));
		textField.setBounds(10, 207, 315, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 182);
		contentPane.add(textArea);
	}{
	
		try{
			String msgout = "";
			msgout = textField.getText().trim();
			output.writeUTF(msgout);//Sends the server message to the client.
			}catch(Exception e){
			//Handle the exception here.
	}

	}
	}
	
	

