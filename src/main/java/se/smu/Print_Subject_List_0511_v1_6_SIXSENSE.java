package se.smu;

import javax.swing.JFrame;
import javax.swing.JPanel;



import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.JScrollPane;


import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import java.awt.Dimension;


import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import javax.swing.tree.TreePath;







import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridLayout;



















import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Date;


public class Print_Subject_List_0511_v1_6_SIXSENSE extends JPanel implements ActionListener {
	static JPanelMain panel;
	
	 
	 static String ADD_COMMAND1 = "addSubject";
	 static String ADD_COMMAND2 = "addTodo";
	 static String REMOVE_COMMAND = "remove";
	 static String CLEAR_COMMAND = "clear";
	 static String MARK_COMMAND = "mark";
	 static String EDIT_COMMAND = "edit";
	 static String SAVE_COMMAND = "save";
	 static String CHANGE_STATUS_COMMAND = "statusChange";
	 
	 private DynamicTree subjectList;
	 
	Button Add_Subject_Button = new Button("+Subject");
	Button Save_Button = new Button("\uC800\uC7A5");
	Button Show_Sorted_List_Button = new Button("정렬 보기");
	Button Add_todo_Button = new Button("+To Do");
	Button button = new Button("Mark");

	
	
	private Font ButtonFont = new Font("Arial Unicode MS", Font.PLAIN, 12);
	
	
	private final Button Edit_Button = new Button("Edit");
	
	static String command;
	static public String temp_ParentName;
	
	public Print_Subject_List_0511_v1_6_SIXSENSE(final JPanelMain panel) {
		
		
		setBackground(Color.WHITE);
		this.panel=panel;
		setLayout(null);
		
		subjectList = new DynamicTree();
		
		
		Add_Subject_Button.setFont(ButtonFont);
		Add_Subject_Button.setForeground(new Color(255, 255, 255));
		Add_Subject_Button.setBackground(SystemColor.desktop);
		Add_Subject_Button.setBounds(287, 10, 65, 25);
		Add_Subject_Button.setActionCommand(ADD_COMMAND1);
		Add_Subject_Button.addActionListener(this);
		add(Add_Subject_Button);
		
		
		Save_Button.setForeground(Color.WHITE);
		Save_Button.setFont(ButtonFont);
		Save_Button.setBackground(SystemColor.textHighlight);
		Save_Button.setBounds(20, 560, 80, 40);
		add(Save_Button);
		Save_Button.setActionCommand(SAVE_COMMAND);
		Save_Button.addActionListener(this);
		
		Show_Sorted_List_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Print_Show_Sorted_List_0514_v1_6_SIXSENSE.wholeTodo = "";
				Print_Show_Sorted_List_0514_v1_6_SIXSENSE.clearList();
				
					
				try {
					subjectList.saveFile();
					Print_Show_Sorted_List_0514_v1_6_SIXSENSE.loadTodo();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				panel.change("Print_Show_Sorted_List_0514_v1_6_SIXSENSE");
			}
		});
		
		
		Show_Sorted_List_Button.setForeground(Color.WHITE);
		Show_Sorted_List_Button.setFont(ButtonFont);
		Show_Sorted_List_Button.setBackground(SystemColor.textHighlight);
		Show_Sorted_List_Button.setBounds(144, 560, 80, 40);
		add(Show_Sorted_List_Button);
		
		Add_todo_Button.setForeground(Color.WHITE);
		Add_todo_Button.setFont(ButtonFont);
		Add_todo_Button.setBackground(SystemColor.textHighlight);
		Add_todo_Button.setBounds(270, 560, 80, 40);
		Add_todo_Button.setActionCommand(ADD_COMMAND2);
		Add_todo_Button.addActionListener(this);
		add(Add_todo_Button);
		
		subjectList.setPreferredSize(new Dimension(300, 150));
		subjectList.setBounds(10, 10, 270, 550);
		
		
		add(subjectList);
		
		button.setFont(ButtonFont);
		button.setForeground(Color.BLACK);
		button.setBackground(Color.YELLOW);
		button.setBounds(287, 41, 65, 25);
		button.setActionCommand(MARK_COMMAND);
		button.addActionListener(this);
		add(button);
		
		Button Delete_Button = new Button("Delete");
		Delete_Button.setActionCommand(REMOVE_COMMAND);
		Delete_Button.addActionListener(this);
		Delete_Button.setFont(new Font("Dialog", Font.PLAIN, 12));
		Delete_Button.setForeground(Color.WHITE);
		Delete_Button.setBackground(Color.RED);
		Delete_Button.setBounds(287, 72, 65, 25);
		add(Delete_Button);
		
		
		Edit_Button.setFont(new Font("Dialog", Font.PLAIN, 12));
		Edit_Button.setActionCommand(EDIT_COMMAND);
		Edit_Button.addActionListener(this);
		Edit_Button.setForeground(Color.WHITE);
		Edit_Button.setBackground(Color.BLUE);
		Edit_Button.setBounds(287, 103, 65, 25);
		add(Edit_Button);
		
		Button Status_Button = new Button("\uC0C1\uD0DC \uBCC0\uACBD");
		Status_Button.setBackground(Color.GREEN);
		Status_Button.setFont(new Font("Dialog", Font.PLAIN, 12));
		Status_Button.setBounds(287, 134, 67, 25);
		Status_Button.setActionCommand(CHANGE_STATUS_COMMAND);
		Status_Button.addActionListener(this);
		add(Status_Button);
		}


  	  public void actionPerformed(ActionEvent e) {
  	    command = e.getActionCommand();
  	    
  	    if (ADD_COMMAND1.equals(command) ) {
  	      // Add subject button clicked
  	    	
  	    	Print_Add_Subject_Screen_temp asstemp = new Print_Add_Subject_Screen_temp();
  	    	
  	    	
  	    	if(isCreateNewNode.isCreateNewNode==true ) {
  	    		
  	    		subjectList.addObject(""+Print_Add_Subject_Screen_temp.Subject_Info[0]+"/"+Print_Add_Subject_Screen_temp.Subject_Info[1]+"/"+
  	    				Print_Add_Subject_Screen_temp.Subject_Info[2]+"/"+Print_Add_Subject_Screen_temp.Subject_Info[3]+"/"+
  	    				Print_Add_Subject_Screen_temp.Subject_Info[4] );
  	    		
  	    	}
  	    	isCreateNewNode.isCreateNewNode=false;
  	    	
  	    	for(int i=0; i<5; i++) {
  	    		Print_Add_Subject_Screen_temp.Subject_Info[i] = "";
  	    	}
  	    	
  	    }
  	    else if (ADD_COMMAND2.equals(command)) {
  	   // Add todo button clicked
  	    	int currentNodeLevel = subjectList.getCurrentNodeLevel();
  	    	if(currentNodeLevel == 2) {
	  	    	Print_Add_Edit_Todo_temp attemp = new Print_Add_Edit_Todo_temp(0);
	  	    	
	  	    	
	  	    	if(isCreateNewNode.isCreateNewNode==true ) {
	  	
	  	    		subjectList.getParentName();
	  	    		String[] tempStrArr = temp_ParentName.split("/");
	  	    		temp_ParentName = tempStrArr[0];
	  	  	    	
	  	    		subjectList.addObject("☆/"+"미완료/" + Print_Add_Edit_Todo_temp.Todo_Info[0]+"/"+Print_Add_Edit_Todo_temp.Todo_Info[1]+"/"+
	  	    				temp_ParentName+ "/" + "-" );
	  	    		 
	  	    	
	  	    	}
	  	    	isCreateNewNode.isCreateNewNode=false;
	  	    	for(int i=0; i<3; i++) {
	  	    		Print_Add_Edit_Todo_temp.Todo_Info[0]="";
	  	    	}
  	    	
  	    	}
  	    	
  	    } else if (REMOVE_COMMAND.equals(command)) {
  	      // Remove button clicked
  	    	subjectList.removeCurrentNode(0);
  	    } else if (CLEAR_COMMAND.equals(command)) {
  	      // Clear button clicked.
  	    	subjectList.clear();
  	    }
  	    else if(MARK_COMMAND.equals(command)) {	//중요도 표시
  	    	//Mark to do list
  	    	//subjectList.firePropertyChange("★", oldValue, newValue);
  	    	subjectList.mark();
  	    	repaint();
  	    }
  	    else if(EDIT_COMMAND.equals(command)) {
  	    	subjectList.edit();
  	    	Print_Add_Edit_Todo_temp.Todo_Info[0]="";
  	    	Print_Add_Edit_Todo_temp.Todo_Info[1]="";
  	    	//Print_Add_Edit_Todo_temp.Todo_Info[2]="";
  	    }
  	    else if(SAVE_COMMAND.equals(command)) {
  	    	
  	    	try {
				subjectList.saveFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  	    }
  	    else if(CHANGE_STATUS_COMMAND.equals(command)) {
  	    	subjectList.StatusChange();
  	    }
  	 
  	  }

  	  /**
  	   GUI 생성
  	   */
  	  private static void createAndShowGUI() {
  	    // Create and set up the window.
  	    JFrame frame = new JFrame("Main");
  	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  	    // Create and set up the content pane.
  	  Print_Subject_List_0511_v1_6_SIXSENSE newContentPane = new Print_Subject_List_0511_v1_6_SIXSENSE(panel);
  	    newContentPane.setOpaque(true); // content panes must be opaque
  	    frame.setContentPane(newContentPane);

  	    // Display the window.
  	    frame.pack();
  	    frame.setVisible(true);
  	  }

  	  public static void main(String[] args) {
  	    // Schedule a job for the event-dispatching thread:
  	    // creating and showing this application's GUI.
  		  
  	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
  	      public void run() {
  	        createAndShowGUI();
  	      }
  	    });
  	  }
  	} //생성자


  	// package components;
  	/*
  	 * This code is based on an example provided by Richard Stanford, a tutorial
  	 * reader.
  	 */
  	class DynamicTree extends JPanel {
  	  protected DefaultMutableTreeNode rootNode;
  	  protected DefaultTreeModel treeModel;
  	  protected JTree tree;
  	  private Toolkit toolkit = Toolkit.getDefaultToolkit();

  	  public DynamicTree() {
  	    super(new GridLayout(1, 0));

  	    rootNode = new DefaultMutableTreeNode("TO DO LIST");
  	    treeModel = new DefaultTreeModel(rootNode);
  	    
  	    //tree
  	    tree = new JTree(treeModel);

  	  tree.setEditable(false);	
  	  DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) tree.getCellRenderer();
  	  render.setClosedIcon(null);
      render.setOpenIcon(null);
      render.setLeafIcon(null);
      
      DefaultMutableTreeNode basicNode1 = new DefaultMutableTreeNode("미완료 항목");
      DefaultMutableTreeNode basicNode2 = new DefaultMutableTreeNode("완료 항목");
      DefaultMutableTreeNode basicNode3 = new DefaultMutableTreeNode("과목 없음");
      rootNode.add(basicNode1);
      rootNode.add(basicNode2);
      basicNode1.add(basicNode3);
      
      tree.scrollPathToVisible(new TreePath(basicNode1.getPath()));
      tree.scrollPathToVisible(new TreePath(basicNode3.getPath()));
      
      try {
		loadSubject();
		loadTodo();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
  	  JScrollPane scrollPane = new JScrollPane(tree);
  	  add(scrollPane);
  	
  	    

  	  }

  	  /** Remove all nodes except the root node. **/
  	  public void clear() {
  	    rootNode.removeAllChildren();
  	    treeModel.reload();
  	  }

  	  public void mark() {
  		
  		DefaultMutableTreeNode node; 
		node =  (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		String nodeName = node.getUserObject().toString();
		if(nodeName.charAt(0)=='☆') {
			String newName = nodeName.replaceFirst("☆", "★");
			node.setUserObject(newName);
		}
		else if(nodeName.charAt(0)=='★') {
			String newName = nodeName.replaceFirst("★", "☆");
			node.setUserObject(newName);
		}
  		if(node.getLevel() == 3)
  			JOptionPane.showMessageDialog(null, "Successfully Marked.", "Mark", JOptionPane.INFORMATION_MESSAGE);
  	  }
  	  
  	  
  	  //edit 기능 보류. String 읽기
  	  public void edit() {
  		DefaultMutableTreeNode node; 
		node =  (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
		String nodeName = node.getUserObject().toString();
		
		String[] editedName = nodeName.split("/");
		for(int i=0; i<editedName.length; i++)
		System.out.println(editedName[i]);
		
		
		
		if( node.getLevel() == 3 ) {
			for(int i=0; i<2; i++) {
				Print_Add_Edit_Todo_temp.Todo_Info[i] = editedName[i+2];
			}
			Print_Add_Edit_Todo_temp attemp = new Print_Add_Edit_Todo_temp(1);
			
			
	  	  
			node.setUserObject(editedName[0] + "/" + editedName[1]  + "/" + Print_Add_Edit_Todo_temp.Todo_Info[0]+"/"+Print_Add_Edit_Todo_temp.Todo_Info[1]+"/"+
	  	    				editedName[4] + "/" + editedName[5]);
			treeModel.nodeChanged(node);
			
			//node.setUserObject("");
	  	  }
  	  }
  	  

  	  /** Remove the currently selected node. */
  	  public void removeCurrentNode(int removeOption) {
  		  boolean isdeleted=false;
  	    TreePath currentSelection = tree.getSelectionPath();
  	    if (currentSelection != null) {
  	      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
  	          .getLastPathComponent());
  	    	
  	      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
  	      if(removeOption != 1  && currentNode.getLevel() > 1){
  	      int deleteOption = JOptionPane.showConfirmDialog(null,"정말로 삭제하시겠습니까?", "항목 삭제", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
  	      if(deleteOption == JOptionPane.YES_OPTION)
  	    		  isdeleted=true;
  	      }
  	      else if(removeOption == 1)
	    		  isdeleted=true;

  	      
  	      if (parent != null && isdeleted == true) {
  	        treeModel.removeNodeFromParent(currentNode);
  	        return;
  	      }
  	    }

  	    // Either there was no selection, or the root was selected.
  	    toolkit.beep();
  	  }
  	  
  	
  	  
  	  

  	  /** Add child to the currently selected node. */
  	  public DefaultMutableTreeNode addObject(Object child) {
  		  
  	    DefaultMutableTreeNode parentNode = null;
  	    TreePath parentPath = tree.getSelectionPath();

  	    
		
		
  	    if (parentPath == null) {
  	      parentNode = rootNode;
  	    } else {
  	      parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
  	    }
  	
  	    return addObject(parentNode, child, true);
  	  }

  	  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
  	      Object child) {
  		  	
  		 
  			  return addObject(parent, child, false);		
  	  }

  	  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
  	      Object child, boolean shouldBeVisible) {
  
  		  DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
  	  
  	    if (parent == null ) {
  	      
  	    	
  	    	parent = rootNode;
  	    }
		
  	  
  	    if( (parent.getLevel() == 1 && rootNode.getIndex(parent) == 0 && parent.getChildCount() < 15 && Print_Subject_List_0511_v1_6_SIXSENSE.command.equals(Print_Subject_List_0511_v1_6_SIXSENSE.ADD_COMMAND1))
  	    		|| (parent.getLevel() == 2 && parent.getChildCount() < 10 &&Print_Subject_List_0511_v1_6_SIXSENSE.command.equals(Print_Subject_List_0511_v1_6_SIXSENSE.ADD_COMMAND2)) )
  	    	
  	
  	    	
  	    	treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

  
  	    if (shouldBeVisible) {
  	      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
  	    }
  	    
  	    
  	    
  	  

  	    return childNode;
  	    
  	  }

  	  class MyTreeModelListener implements TreeModelListener {
  	    public void treeNodesChanged(TreeModelEvent e) {
  	      DefaultMutableTreeNode node;
  	      node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

  	      /*
  	       * If the event lists children, then the changed node is the child of the
  	       * node we've already gotten. Otherwise, the changed node and the
  	       * specified node are the same.
  	       */

  	      int index = e.getChildIndices()[0];
  	      node = (DefaultMutableTreeNode) (node.getChildAt(index));

  	      System.out.println("The user has finished editing the node.");
  	      System.out.println("New value: " + node.getUserObject());
  	    }

  	    public void treeNodesInserted(TreeModelEvent e) {
  	    }

  	    public void treeNodesRemoved(TreeModelEvent e) {
  	    }

  	    public void treeStructureChanged(TreeModelEvent e) {
  	    }
  	  }
  	  
  	  
  	  String getTime() {
  		  long time = System.currentTimeMillis();
  		  SimpleDateFormat dayTime = new SimpleDateFormat("MM-dd");
  		  String str = dayTime.format(new Date(time));
  		  
  		  return str;
  	  }
  	  //상태 변경 함수  (ex. 미완료 --> 완료)
  	  public void StatusChange() {
  		  String finishedTime= getTime();
  		  String nodeName="";
  		  TreePath currentSelection = tree.getSelectionPath();
    	    if (currentSelection != null) {
    	      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
    	          .getLastPathComponent());
    	      nodeName = currentNode.getUserObject().toString();
    	    }
    	    
    	    
    	    String[] nodeNameStr = nodeName.split("/");
   
    	
    	    if(nodeNameStr[1].equals("미완료")) {
    	    	//미완료 -> 완료
   	
    	    	nodeNameStr[1] = "완료";
    	    	
    	    	nodeName = "";
    	    	for(int i=0; i<5; i++) {
    	    		nodeName = nodeName + nodeNameStr[i] + "/"; 
    	    	}
    	    	nodeName = nodeName +  finishedTime;
    	    	removeCurrentNode(1);
    	    	
    	    	
    	    	DefaultMutableTreeNode FinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(1);
    	    	DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
    	    	
    	    	treeModel.insertNodeInto(newNode, FinishedNode, FinishedNode.getChildCount());
    			
    			
    	    }
    	    else {
    	    	//완료 -> 미완료
    	    	boolean iscompleted=false;
    	    	nodeNameStr[1] = "미완료";
    	    	nodeName = "";
    	    	
    	    	for(int i=0; i<5; i++) {
    	    		nodeName = nodeName +  nodeNameStr[i] + "/"; 
    	    	}
    	    	nodeName = nodeName +  "-";
    	    	
    	    	removeCurrentNode(1);
    	    	
    	    	
    	    	DefaultMutableTreeNode UnfinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(0);
    	    	DefaultMutableTreeNode SubjectNode;
    	    	DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeName);
    	    	String SubjectName="";
    	    	String ParentName=nodeNameStr[4];
    	    	
    	    	int subjectCount = UnfinishedNode.getChildCount();
    	    	
    	    	for(int i=0; i<subjectCount; i++) {
    	    		SubjectNode = (DefaultMutableTreeNode) UnfinishedNode.getChildAt(i);
    	    		String temp = SubjectNode.getUserObject().toString();
    	    		String[] tempStr = temp.split("/");
    	    		SubjectName = tempStr[0]; 
    	    		  	    		
    	    		
    	    		if(SubjectName.equals(ParentName)) {
    	    			
    	    			treeModel.insertNodeInto(newNode, SubjectNode, SubjectNode.getChildCount());
    	    			tree.scrollPathToVisible(new TreePath(newNode.getPath()));
    	    			iscompleted = true;
    	    			break;
    	    		}    	    		
    	    	}
    	    	if(iscompleted == false) {
    	    		SubjectNode = (DefaultMutableTreeNode) UnfinishedNode.getChildAt(0);
    	    		treeModel.insertNodeInto(newNode, SubjectNode, SubjectNode.getChildCount());
	    			tree.scrollPathToVisible(new TreePath(newNode.getPath()));
    	    	}
    	    	
    	    }
 
    	    
    	   
  		  
  	  }
  	  
  	  
  	 public void getParentName() {
  		 TreePath currentSelection = tree.getSelectionPath();
   	    if (currentSelection != null) {
   	      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
   	          .getLastPathComponent());
   	      Print_Subject_List_0511_v1_6_SIXSENSE.temp_ParentName = currentNode.getUserObject().toString();
   	    }
   	    System.out.println(Print_Subject_List_0511_v1_6_SIXSENSE.temp_ParentName);
   	 
  	 }
  	 
  	public int getCurrentNodeLevel() {
  		DefaultMutableTreeNode node =  
  				(DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
  		return node.getLevel();
  	}
  	 
  	  
  	public void saveFile() throws IOException {
  		
  		DefaultMutableTreeNode UnfinishedNode; 
		UnfinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(0);
  	
		
		DefaultMutableTreeNode FinishedNode; 
		FinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(1);
		
		DefaultMutableTreeNode SubjectNode; 
		DefaultMutableTreeNode TodoNode; 
		
	
		
		
		String SubjectText = "";
		String TodoText = "";
		
		
		String PackagePath = Print_Show_Sorted_List_0514_v1_6_SIXSENSE.class.getResource("").getPath();
		
		String SubjectTextPath = PackagePath + "Subject.txt";
		String TodoTextPath = PackagePath + "Todo.txt";
		System.out.println(SubjectTextPath);
		System.out.println(TodoTextPath);
		
		
		
		
		int subjectCount = UnfinishedNode.getChildCount();
		
		for(int i=0; i<subjectCount; i++) {
			SubjectNode = (DefaultMutableTreeNode) UnfinishedNode.getChildAt(i);
			int todoCount = SubjectNode.getChildCount();
			
			
				String tempStr1 = "";
				if(i != 0) {
					tempStr1 = tempStr1 + SubjectNode.getUserObject().toString();
					SubjectText = SubjectText + tempStr1 + "\r\n";
				}
			
			for(int j=0; j<todoCount; j++) {
				TodoNode = (DefaultMutableTreeNode) SubjectNode.getChildAt(j);
				String tempStr2 = "" + TodoNode.getUserObject().toString();
				TodoText = TodoText + tempStr2 + "\r\n";	
			}
		}
		
		int FinishedTodoCount = FinishedNode.getChildCount();
		for(int i=0; i<FinishedTodoCount; i++) {
			TodoNode = (DefaultMutableTreeNode) FinishedNode.getChildAt(i);
			String tempStr2 = "" + TodoNode.getUserObject().toString();
			TodoText = TodoText + tempStr2 + "\r\n";
		}
		
		FileWriter fw = new FileWriter(SubjectTextPath);
  		
  	     fw.write(SubjectText);
  	     fw.close();
  	     
  	    fw = new FileWriter(TodoTextPath);
	     fw.write(TodoText);
	     fw.close();
  	} 
    	
  	
    	public void loadSubject() throws IOException{ //txt에서 입력받기 main 시작할때 호출 개행단위로 읽어서 add+todo() 실행
    		
    		String PackagePath = Print_Show_Sorted_List_0514_v1_6_SIXSENSE.class.getResource("").getPath();	
    		String SubjectTextPath = PackagePath + "Subject.txt";
    	
  		 BufferedReader br = new BufferedReader(new FileReader(SubjectTextPath));
  	        while(true) {
  	            String line = br.readLine();
  	            if (line==null) break;
  	            
  	            DefaultMutableTreeNode UnfinishedNode; 
  	            UnfinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(0);
  	  		
  	            DefaultMutableTreeNode SubjectNode = addObject(line); 
  	            
  	          treeModel.insertNodeInto(SubjectNode, UnfinishedNode, UnfinishedNode.getChildCount());
  	          tree.scrollPathToVisible(new TreePath(SubjectNode.getPath()));   
  	        }
  	        br.close();
  	    }
    	
    	
    	public void loadTodo() throws IOException{ //txt에서 입력받기 main 시작할때 호출 개행단위로 읽어서 add+todo() 실행
    		
    		String PackagePath = Print_Show_Sorted_List_0514_v1_6_SIXSENSE.class.getResource("").getPath();	
    		String TodoTextPath = PackagePath + "Todo.txt";
    		DefaultMutableTreeNode UnfinishedNode; 
	        UnfinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(0);
	        int SubjectCount = UnfinishedNode.getChildCount();
	        
	        DefaultMutableTreeNode FinishedNode; 
	        FinishedNode = (DefaultMutableTreeNode) rootNode.getChildAt(1);
	        
	        
  		 BufferedReader br = new BufferedReader(new FileReader(TodoTextPath));
  		 String[] tempStr1;
  		 String ParentName="";
  		 String SubjectName="";
  		 String Status="";
  		 int temp = 0;
  	        while(true) {
  	        	System.out.println(temp);
  	        	temp++;
  	            String line = br.readLine();
  	            if (line==null) break;
  	          
  	            tempStr1 = line.split("/");
  	            System.out.println(tempStr1.length);
  	           	Status = tempStr1[1];
  	            SubjectName = tempStr1[4];
  	         	boolean isCompleted = false;
  	            
  	         	if(Status.equals("미완료")) {
  	 
	  	            for(int i=0; i<SubjectCount; i++) {
	  	            	DefaultMutableTreeNode SubjectNode = (DefaultMutableTreeNode) UnfinishedNode.getChildAt(i);
	  	            	ParentName = SubjectNode.getUserObject().toString();
	  	            	
	  	            	String[] tempStr2 = ParentName.split("/");
	  	            	ParentName = tempStr2[0];
	  	            	
	  	            	
	  	            	if(SubjectName.equals(ParentName)) {
	  	            		DefaultMutableTreeNode TodotNode = addObject(line); 
	  	            		treeModel.insertNodeInto(TodotNode, SubjectNode, SubjectNode.getChildCount());
	  	            		tree.scrollPathToVisible(new TreePath(TodotNode.getPath()));
	  	            		isCompleted = true;
	  	            		break;
	  	            	}
	  	            }
  	         	}
  	         	else if(Status.equals("완료")) {
  	         		DefaultMutableTreeNode TodotNode = addObject(line); 
  	         		treeModel.insertNodeInto(TodotNode, FinishedNode, FinishedNode.getChildCount());
  	         		isCompleted = true;
  	         	}
  	         
  	       if(isCompleted == false) {
  	            DefaultMutableTreeNode SubjectNode = (DefaultMutableTreeNode) UnfinishedNode.getChildAt(0);
  	            DefaultMutableTreeNode TodotNode = addObject(line); 
	           	treeModel.insertNodeInto(TodotNode, SubjectNode, SubjectNode.getChildCount());
	            tree.scrollPathToVisible(new TreePath(TodotNode.getPath()));
  	       }
	            			
  	            
  	  		
  	  
  	        }
  	        br.close();
  	    }
    	
    	
    	
    	
  	}
  	  

  	
  	

	

