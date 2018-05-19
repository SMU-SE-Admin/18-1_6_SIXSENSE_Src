package se.smu;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class Print_Show_Sorted_List_0514_v1_6_SIXSENSE extends JPanel{
	JPanelMain panel;
	JPanel panel_1 = new JPanel();	//클래서스설계서에 없는거
	JPanel panel_2 = new JPanel();	//클래스 설계서에 없는거 
	JLabel Unfinished_todo_Label = new JLabel("\uBBF8\uC644\uB8CC \uD56D\uBAA9");
	JLabel Finished_todo_Label = new JLabel("\uC644\uB8CC\uB41C \uD56D\uBAA9");
	String sortPolicy[] = {"정렬기준1", "정렬기준2", "정렬기준3"};	//내용에맞게 바꿔야됨
	JComboBox Sort_Standard_Combobox = new JComboBox(sortPolicy);
	Button Prev_Button = new Button("Prev");
	private Font ButtonFont = new Font("Arial Unicode MS", Font.PLAIN, 12);
	private Font LableFont = new Font("Arial Unicode MS", Font.PLAIN, 24);
	private Font TextFont = new Font("Arial Unicode MS", Font.PLAIN, 14);
	
	public Print_Show_Sorted_List_0514_v1_6_SIXSENSE(final JPanelMain panel) {
		setBackground(Color.WHITE);
		this.panel=panel;
		setLayout(null);		
		
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(2, 50, 356, 230);
		add(panel_1);
		panel_1.setLayout(null);
		
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(2, 338, 356, 202);
		add(panel_2);
		
		Unfinished_todo_Label.setFont(LableFont);
		Unfinished_todo_Label.setBounds(0, 0, 142, 38);
		add(Unfinished_todo_Label);
		
		Finished_todo_Label.setFont(LableFont);
		Finished_todo_Label.setBounds(0, 292, 142, 38);
		add(Finished_todo_Label);
		
		
		
		Sort_Standard_Combobox.setBounds(210, 7, 135, 38);
		add(Sort_Standard_Combobox);
		Sort_Standard_Combobox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		Prev_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.change("Print_Subject_List_0511_v1_6_SIXSENSE");	//prev 눌렀을때 이전화면으로 돌아가버튼
			}
		});
		Prev_Button.setFont(ButtonFont);
		Prev_Button.setForeground(SystemColor.textHighlightText);
		Prev_Button.setBackground(SystemColor.textHighlight);
		Prev_Button.setBounds(0, 560, 100, 40);
		add(Prev_Button);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 360, 640);

		
	}
}
