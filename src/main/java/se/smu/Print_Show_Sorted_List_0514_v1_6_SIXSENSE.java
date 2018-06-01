package se.smu;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class Print_Show_Sorted_List_0514_v1_6_SIXSENSE extends JPanel{
	JPanelMain panel;
	JLabel Unfinished_todo_Label = new JLabel("\uBBF8\uC644\uB8CC \uD56D\uBAA9");
	JLabel Finished_todo_Label = new JLabel("\uC644\uB8CC\uB41C \uD56D\uBAA9");
	String sortPolicy[] = {"과목 명", "마감 기한", "실제 마감일"};	
	JComboBox Sort_Standard_Combobox = new JComboBox(sortPolicy);
	Button Prev_Button = new Button("Prev");
	
	static DefaultListModel<String> UnfinishedModel = new DefaultListModel();
	static DefaultListModel<String> FinishedModel = new DefaultListModel();
	
	
	JList Unfinished_List = new JList(UnfinishedModel);
	JList Finished_List = new JList(FinishedModel);
	static String wholeTodo=""; //구분자 ;
	String[] Todos;
	String[] TodoComponents;
	 
	public Print_Show_Sorted_List_0514_v1_6_SIXSENSE(final JPanelMain panel) {
		setBackground(Color.WHITE);
		this.panel=panel;
		setLayout(null);		
		
		try {
			loadTodo();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		splitTodos();
		
		
		Unfinished_todo_Label.setBounds(0, 0, 142, 38);
		add(Unfinished_todo_Label);
		
		
		Finished_todo_Label.setBounds(0, 292, 142, 38);
		add(Finished_todo_Label);
		
		
		
		Sort_Standard_Combobox.setBounds(210, 7, 135, 38);
		add(Sort_Standard_Combobox);
	
		
		Prev_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					this.finalize();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel.change("Print_Subject_List_0511_v1_6_SIXSENSE");	//prev 눌렀을때 이전화면으로 돌아가버튼
				
				
			}
		});
		
		Prev_Button.setForeground(SystemColor.textHighlightText);
		Prev_Button.setBackground(SystemColor.textHighlight);
		Prev_Button.setBounds(0, 560, 100, 40);
		add(Prev_Button);
		
		JScrollPane Unfinished_scrollPane = new JScrollPane();
		Unfinished_scrollPane.setBounds(0, 50, 356, 214);
		add(Unfinished_scrollPane);
		Unfinished_scrollPane.setViewportView(Unfinished_List);
		Unfinished_List.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		JScrollPane Finished_scrollPane = new JScrollPane();
		Finished_scrollPane.setBounds(0, 328, 356, 214);
		add(Finished_scrollPane);
		Finished_scrollPane.setViewportView(Finished_List);
		Finished_List.setFont(new Font("Dialog", Font.PLAIN, 15));
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 360, 640);
		
		
		Sort_Standard_Combobox.addActionListener(new MyComboboxActionListener());
		
		
		
		
		
	}
	
	public class MyComboboxActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Sort_Standard_Combobox =  (JComboBox) e.getSource();
			int index = Sort_Standard_Combobox.getSelectedIndex();
			System.out.println(wholeTodo);
			splitTodos();
			for(int i=0; i<Todos.length; i++) {
			System.out.println(Todos[i] + "\n");
			}
			changeComponentsLocation(index);
			clearList();
			updateList();
		}
		
	}
	
	public void saveFile() throws IOException {
	
	}
	
	public static void loadTodo() throws IOException{ //txt에서 입력받기 main 시작할때 호출 개행단위로 읽어서 add+todo() 실행
		clearList();
		String PackagePath = Print_Show_Sorted_List_0514_v1_6_SIXSENSE.class.getResource("").getPath();	
		String TodoTextPath = PackagePath + "Todo.txt";
		
		 BufferedReader br = new BufferedReader(new FileReader(TodoTextPath));
		 String[] tempStr1;
		 String Status="";
		
	        while(true) {
	            String line = br.readLine();
	            if (line==null) break;
	            wholeTodo = wholeTodo + line + ";";
	            
	            tempStr1 = line.split("/");
	           
	           	Status = tempStr1[1];

	         	if(Status.equals("미완료")) {
	         			UnfinishedModel.addElement(line);
	         			
  	     
  	            }
  	           	else if(Status.equals("완료")) {
  	           		FinishedModel.addElement(line);
  	           		

	         	}
	        }
	        br.close();
	    }
	
	public void splitTodos() {
		System.out.println("wholeTodo : " + wholeTodo);
		Todos = wholeTodo.split(";");
	}
		
		
	
	public void changeComponentsLocation(int sortPolicy) {
		int len = Todos.length;
		
		for(int i=0; i<len; i++) {
			TodoComponents = Todos[i].split("/");
			String temp;
			switch(sortPolicy) {
			case 0 : 
				temp = TodoComponents[4];
				TodoComponents[4] = TodoComponents[0];
				TodoComponents[0] = temp;
				break;
			case 1 : 
				temp = TodoComponents[3];
				TodoComponents[3] = TodoComponents[0];
				TodoComponents[0] = temp;
				break;
			case 2 : 
				temp = TodoComponents[5];
				TodoComponents[5] = TodoComponents[0];
				TodoComponents[0] = temp;
			}
			
			Todos[i] = TodoComponents[0] + "/" + TodoComponents[1] + "/" + TodoComponents[2] + 
					"/" + TodoComponents[3] + "/" + TodoComponents[4] + "/" +TodoComponents[5];
		}
	}
	
	public static void clearList() {
		
		UnfinishedModel.removeAllElements();
		FinishedModel.removeAllElements();		
	}
	
	public void updateList() {
		 String[] tempStr1;
		 String Status="";
		 
		 System.out.println(Todos.length);
		 Arrays.sort(Todos);
		 
		 for(int i=0; i<Todos.length; i++) {
			 System.out.println(Todos[i]);
		 }
		 for(int i=0; i<Todos.length; i++) {
		
			 tempStr1 = Todos[i].split("/");
			 
			 Status = tempStr1[1];
			 
			 if(Status.equals("미완료")) {
      			UnfinishedModel.addElement(Todos[i]);
    
           }
          	else if(Status.equals("완료")) {
          		FinishedModel.addElement(Todos[i]);

      	}
			 
		 }
		
		 
		 
	}
}
