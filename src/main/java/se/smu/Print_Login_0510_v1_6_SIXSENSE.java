package se.smu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import com.sun.javafx.scene.input.InputEventUtils;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



public class Print_Login_0510_v1_6_SIXSENSE extends JPanel {
	JPanelMain panel;
	private JPasswordField passwordField;
	private JFormattedTextField frmtdtxtfldUsernaem;
	private String username = "sixsense";
	private String inputUsername;
	private String inputPasswd;
	private char[] passwd = new char[] {'6', '6', '6', '6'};
	
	JLabel lblNewLabel = new JLabel("New label");
	JLabel label = new JLabel("New label");
	JLabel lblToDoList = new JLabel("To Do List");
	JLabel lblSixsense = new JLabel("SIXSENSE");
	JButton btnLogin = new JButton("Login");
	
	public Print_Login_0510_v1_6_SIXSENSE(final JPanelMain panel) {
		setBackground(SystemColor.window);
		this.panel=panel;
		setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(104, 295, 212, 42);
		add(passwordField);
		 
		final char[] inputPassword = passwordField.getPassword();
		if (Arrays.equals(passwd, inputPassword)) {
		    Logincase.passwd_eq=1;
		} else {
		    Logincase.passwd_eq=0;
		}
		
		frmtdtxtfldUsernaem = new JFormattedTextField();
		frmtdtxtfldUsernaem.setText("username");
		frmtdtxtfldUsernaem.setBounds(104, 241, 212, 42);
		
		System.out.println();
		add(frmtdtxtfldUsernaem);
		
		
		
		
		//lblNewLabel.setIcon(new ImageIcon(Print_Login_0510_v1_6_SIXSENSE.class.getResource("username_icon.png")));
		lblNewLabel.setBounds(58, 241, 42, 42);
		add(lblNewLabel);
		
		
		//label.setIcon(new ImageIcon(Print_Login_0510_v1_6_SIXSENSE.class.getResource("passwd_icon.png")));
		label.setBounds(58, 295, 42, 42);
		add(label);
		
		
		lblToDoList.setFont(new Font("Arial", Font.PLAIN, 40));
		lblToDoList.setBounds(104, 111, 190, 66);
		add(lblToDoList);
		
		
		lblSixsense.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSixsense.setBounds(241, 175, 105, 27);
		add(lblSixsense);
		
		
		
		
		
		

		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputUsername = frmtdtxtfldUsernaem.getText();
				boolean logincase;
				boolean isEqualPasswd = Arrays.equals(passwd, passwordField.getPassword());
				System.out.println(inputUsername);
				if(username.equals(inputUsername) && isEqualPasswd)
					logincase = true;
				else 
					logincase = false;
	
				if(logincase == true) {
					panel.change("Print_Subject_List_0511_v1_6_SIXSENSE");
				}
				else {
					JOptionPane.showMessageDialog(null, "Username/Passwd 를 확인하세요");
				}
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		btnLogin.setBounds(241, 349, 105, 27);
		add(btnLogin);
	}


	
}
class Logincase{
	public static int username_eq;
	public static int passwd_eq;
}