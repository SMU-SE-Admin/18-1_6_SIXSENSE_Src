package se.smu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import se.smu.isCreateNewNode;

public class Print_Add_Subject_Screen_temp extends JFrame{
	static public String[] Subject_Info=new String[5];
	 boolean addfile;
	
	
	public Print_Add_Subject_Screen_temp() {
		// TODO Auto-generated constructor stub
		JTextField Subject_Name_TextField = new JTextField();
		JTextField Professor_Name_TextField = new JTextField();
		JTextField Time_TextField = new JTextField();
		JTextField Year_TextField = new JTextField();
		JTextField Semester_TextField = new JTextField();
		
		Object[] message = {
			    "����� :", Subject_Name_TextField,
			    "������:", Professor_Name_TextField,
			    "���� �ð�", Time_TextField,
			    "���� �⵵", Year_TextField,
			    "���� �б�", Semester_TextField
			};

		int option = JOptionPane.showConfirmDialog(null, message, "���� ���", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (option == JOptionPane.OK_OPTION) {
			Subject_Info[0] = Subject_Name_TextField.getText();
			Subject_Info[1] = Professor_Name_TextField.getText();
			Subject_Info[2] = Time_TextField.getText();
			Subject_Info[3] = Year_TextField.getText();
			Subject_Info[4] = Semester_TextField.getText();
			 
			for(int i=0;i<5;i++) {
				 if(Subject_Info[i].equals("")) {
					 JOptionPane.showMessageDialog(null, "����׸��� �Է��ϼ���.");
					 isCreateNewNode.isCreateNewNode=false;
					 break;
				 }
				 isCreateNewNode.isCreateNewNode=true;
			}
			
				
			
		}
	
		
	}
	
	
	
	
}

