package se.smu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;


public class JPanelMain<Print_Add_Subject_Screen_0515_v1_6_SIXSENSE> extends JFrame {
	public JPanelMain() {
		this.setSize(360, 640);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos=dim.width / 2 - this.getWidth()/2;
		int yPos=dim.height / 2 - this.getHeight()/2;
		this.setLocation(xPos,yPos);
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("To Do List by SIXSNESE");
	}

    public Print_Show_Sorted_List_0514_v1_6_SIXSENSE Pshowsortedlist = null;
    public Print_Login_0510_v1_6_SIXSENSE Printlogin = null;
    public Print_Subject_List_0511_v1_6_SIXSENSE PsubjectList = null;    
    
    public void change(String panelName) {
       if(panelName.equals("Print_Show_Sorted_List_0514_v1_6_SIXSENSE")) {
    	   getContentPane().removeAll();
           getContentPane().add(Pshowsortedlist);
           revalidate();
           repaint();
       }
       else if(panelName.equals("Print_Subject_List_0511_v1_6_SIXSENSE")){
    	   getContentPane().removeAll();
           getContentPane().add(PsubjectList);
           revalidate();
           repaint();
       }

       
    }
    

    public static void main(String[] args) {
       JPanelMain main= new JPanelMain();
       main.setTitle("To Do List_SIXSENSE");
     
       main.Printlogin = new Print_Login_0510_v1_6_SIXSENSE(main);
       main.Pshowsortedlist = new Print_Show_Sorted_List_0514_v1_6_SIXSENSE(main);
       main.PsubjectList = new Print_Subject_List_0511_v1_6_SIXSENSE(main);
       
       
       main.getContentPane().add(main.Printlogin);
       main.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       main.setSize(360,640);
       main.setVisible(true);
       
    }
	
}

