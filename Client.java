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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Client extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final static JTextArea msgArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try{
			//Using a local IP address since the server and client are running
			//from the same computer. 
			s = new Socket("127.0.0.1",1201);
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			String msgin = "";
			while(!msgin.equals("exit")){
				msgin = input.readUTF();
				msgArea.setText(msgArea.getText().trim()+"\n Server:\t"+msgin);
			}
				
		}catch(Exception e) {
			
		}
	}
	
	static Socket s;
	static DataInputStream input;
	static DataOutputStream output;

	/**
	 * Create the frame.
	 */
	public Client() {
		setTitle("Client Chat Window");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnSend.setBounds(335, 208, 89, 42);
		contentPane.add(btnSend);
		
		textField = new JTextField();
		textField.setBounds(10, 208, 315, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 186);
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
	


		
