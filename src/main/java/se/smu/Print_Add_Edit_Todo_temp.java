package se.smu;

import java.awt.event.WindowAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import se.smu.isCreateNewNode;

public class Print_Add_Edit_Todo_temp extends JFrame{
	static public String[] Todo_Info=new String[2];
	 boolean addfile;
	
	
	public Print_Add_Edit_Todo_temp(int addOrEdit) {
		// TODO Auto-generated constructor stub
		JTextField Todo_Name_TextField = new JTextField();
		JTextField Todo_Deadline_TextField = new JTextField();
		//JTextField Todo_NickName_TextField = new JTextField();
		
		
		Object[] message = {
			    "항목명", Todo_Name_TextField,
			    "마감 기한", Todo_Deadline_TextField,
			   //"과목 별칭", Todo_NickName_TextField,
			};

		//1 : edit
				if(addOrEdit==1) {
					Todo_Name_TextField.setText(Todo_Info[0]);
					Todo_Deadline_TextField.setText(Todo_Info[1]);
					//Todo_NickName_TextField.setText(Todo_Info[2]);
				}
				else {
					Todo_Name_TextField.setText("");
					Todo_Deadline_TextField.setText("");
					//Todo_NickName_TextField.setText("");
				}
		String nameOftheWindow;
		if(addOrEdit == 0)
			nameOftheWindow = "할일 등록";
		else
			nameOftheWindow = "항목 편집";
		
		isCreateNewNode.isCreateNewNode=false;

		
		int option = JOptionPane.showConfirmDialog(null, message, nameOftheWindow, JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (option == JOptionPane.OK_OPTION) {
			Todo_Info[0] = Todo_Name_TextField.getText();
			Todo_Info[1] = Todo_Deadline_TextField.getText();
			//Todo_Info[2] = Todo_NickName_TextField.getText();
		
			for(int i=0;i<2;i++) {
				 if(Todo_Info[i].equals("")) {
					 JOptionPane.showMessageDialog(null, "모든항목을 입력하세요.");
					 isCreateNewNode.isCreateNewNode=false;
					 break;
				 }
				 isCreateNewNode.isCreateNewNode=true;
			}
		} else {
			isCreateNewNode.isCreateNewNode=false;
			dispose();
		}
			
	
		
	}
	
	
	
	
}

