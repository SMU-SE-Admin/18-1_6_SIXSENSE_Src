package se.smu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Print_Add_Edit_Todo_temp extends JFrame{
	static public String[] Todo_Info=new String[2];
	 boolean addfile;
	
	
	public Print_Add_Edit_Todo_temp(int addOrEdit) {
		// TODO Auto-generated constructor stub
		JTextField Todo_Name_TextField = new JTextField();
		JTextField Todo_Deadline_TextField = new JTextField();
		
		
		
		Object[] message = {
			    "항목명", Todo_Name_TextField,
			    "마감 기한", Todo_Deadline_TextField,
			};

		//1 : edit
				if(addOrEdit==1) {
					Todo_Name_TextField.setText(Todo_Info[0]);
					Todo_Deadline_TextField.setText(Todo_Info[1]);
					
				}
				else {
					Todo_Name_TextField.setText("");
					Todo_Deadline_TextField.setText("");
					
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
		
		
			for(int i=0;i<2;i++) {
				 if(Todo_Info[i].equals("") || Todo_Info[i].contains("/")) {
					 JOptionPane.showMessageDialog(null, "잘못된 입력입니다.(공백 및 '/' 금지)");
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

