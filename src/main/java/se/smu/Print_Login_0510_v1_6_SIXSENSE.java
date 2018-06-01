package se.smu;

import javax.swing.*;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.Font;



public class Print_Login_0510_v1_6_SIXSENSE extends JPanel {
	JPanelMain panel;
	private JPasswordField password_TextField;
	private JFormattedTextField Id_TextField;
	private String username = "sixsense";
	private String inputUsername;
	private char[] passwd = new char[] {'6', '6', '6', '6'};
	
	JLabel ID_Label = new JLabel("ID");
	JLabel Passwd_Label = new JLabel("Password");
	JLabel Title = new JLabel("To Do List");
	JLabel Subtitle = new JLabel("SIXSENSE");
	JButton Login_Button = new JButton("Login");
	
	public Print_Login_0510_v1_6_SIXSENSE(final JPanelMain panel) {
		setBackground(SystemColor.window);
		this.panel=panel;
		setLayout(null);
		
		password_TextField = new JPasswordField();
		password_TextField.setBounds(104, 295, 212, 42);
		add(password_TextField);
		 
		final char[] inputPassword = password_TextField.getPassword();
		if (Arrays.equals(passwd, inputPassword)) {
		    Logincase.passwd_eq=1;
		} else {
		    Logincase.passwd_eq=0;
		}
		
		
		
		Id_TextField = new JFormattedTextField();
		Id_TextField.setText("username");
		Id_TextField.setBounds(104, 241, 212, 42);
		add(Id_TextField);
		ID_Label.setFont(new Font("Dialog", Font.BOLD, 15));
		
			
		ID_Label.setBounds(24, 241, 42, 42);
		add(ID_Label);
		Passwd_Label.setFont(new Font("Dialog", Font.BOLD, 15));
		
		
		Passwd_Label.setBounds(24, 295, 76, 42);
		add(Passwd_Label);
		Title.setFont(new Font("Arial", Font.PLAIN, 36));
		
		
		Title.setBounds(104, 117, 190, 66);
		add(Title);
		Subtitle.setFont(new Font("Arial", Font.PLAIN, 18));
		
		
		Subtitle.setBounds(241, 175, 105, 27);
		add(Subtitle);
		Login_Button.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		
		
		
		
		

		
		Login_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inputUsername = Id_TextField.getText();
				boolean logincase;
				boolean isEqualPasswd = Arrays.equals(passwd, password_TextField.getPassword());
				
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
		
		Login_Button.setBounds(241, 349, 105, 27);
		add(Login_Button);
	}


	
}
class Logincase{
	public static int username_eq;
	public static int passwd_eq;
}