package se.smu;


import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.UIManager;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.tree.TreeCellEditor;

import javafx.scene.control.cell.CheckBoxTreeCell;

//import dynamicadd.DynamicTree;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.GridLayout;

//import org.scijava.swing.checkboxtree.CheckBoxNodeData;
//import org.scijava.swing.checkboxtree.CheckBoxNodeEditor;
//import org.scijava.swing.checkboxtree.CheckBoxNodeRenderer;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellEditor;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;




public class Print_Subject_List_0511_v1_6_SIXSENSE extends JPanel implements ActionListener  {
	static JPanelMain panel;
	
	 private int newNodeSuffix = 1;
	 private static String ADD_COMMAND1 = "addSubject";
	 private static String ADD_COMMAND2 = "addTodo";
	 private static String REMOVE_COMMAND = "remove";
	 private static String CLEAR_COMMAND = "clear";
	 private static String MARK_COMMAND = "mark";
	 
	 private DynamicTree subjectList;

	Button Add_Subject_Button = new Button("+Subject");
	Button Subject_List_Button = new Button("과목 목록");
	Button Show_Sorted_List_Button = new Button("정렬 보기");
	Button Add_todo_Button = new Button("+To Do");
	Button button = new Button("Mark");

	private String SubjectInfo[];
	
	private Font ButtonFont = new Font("Arial Unicode MS", Font.PLAIN, 12);
	private Font LableFont = new Font("Arial Unicode MS", Font.PLAIN, 24);
	private Font TextFont = new Font("Arial Unicode MS", Font.PLAIN, 14);
	
	
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
		
		Subject_List_Button.setForeground(Color.WHITE);
		Subject_List_Button.setFont(ButtonFont);
		Subject_List_Button.setBackground(SystemColor.textHighlight);
		Subject_List_Button.setBounds(20, 560, 80, 40);
		add(Subject_List_Button);
		
		Show_Sorted_List_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
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
		}


  	  public void actionPerformed(ActionEvent e) {
  	    String command = e.getActionCommand();

  	    if (ADD_COMMAND1.equals(command)) {
  	      // Add subject button clicked
  	    	
  	    	Print_Add_Subject_Screen_temp asstemp = new Print_Add_Subject_Screen_temp();
  	    	
  	    	//
  	    	for(int i=0; i<5; i++) {
  	    		System.out.println(Print_Add_Subject_Screen_temp.Subject_Info[i]);
  	    	}
  	    	if(isCreateNewNode.isCreateNewNode==true) {
  	    		
  	    		subjectList.addObject(""+Print_Add_Subject_Screen_temp.Subject_Info[0]+" "+Print_Add_Subject_Screen_temp.Subject_Info[1]+" "+
  	    				Print_Add_Subject_Screen_temp.Subject_Info[2]+" "+Print_Add_Subject_Screen_temp.Subject_Info[3]+" "+
  	    				Print_Add_Subject_Screen_temp.Subject_Info[4] );
  	    		//subjectList.addObject("New Node " + newNodeSuffix++);
  	    	}
  	    	
  	    }
  	    else if (ADD_COMMAND2.equals(command)) {
  	   // Add todo button clicked
  	    	subjectList.addObject("☆ " + newNodeSuffix++);
  	    } else if (REMOVE_COMMAND.equals(command)) {
  	      // Remove button clicked
  	    	subjectList.removeCurrentNode();
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
  	}


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
  	    

  	    tree = new JTree(treeModel);

  	  ///checkbox tree
  	    
      ///
  	  tree.setEditable(true);
  	  DefaultTreeCellRenderer render = (DefaultTreeCellRenderer) tree.getCellRenderer();
  	  render.setClosedIcon(null);
      render.setOpenIcon(null);
      render.setLeafIcon(null);
  	    
  	    
  	    JScrollPane scrollPane = new JScrollPane(tree);
  	    add(scrollPane);
  	  }

  	  /** Remove all nodes except the root node. */
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
  		
		
  	  }

  	  /** Remove the currently selected node. */
  	  public void removeCurrentNode() {
  	    TreePath currentSelection = tree.getSelectionPath();
  	    if (currentSelection != null) {
  	      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
  	          .getLastPathComponent());
  	      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
  	      if (parent != null) {
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

  	    if (parent == null) {
  	      parent = rootNode;
  	    }

  	    // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
  	    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

  	    // Make sure the user can see the lovely new node.
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

  	

      
  	
	
	}
  	
  	

	

