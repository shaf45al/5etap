package calc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class OsnF extends JFrame {
	public OsnF(){
		setTitle("Добро пожаловать!  Выберите пользователя: ");
		
		setSize(600,400);           

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //указывает что будет при нажатии крестика
		setLocationRelativeTo(null);                      //разместить по середине экрана форму 
		setLayout(new BorderLayout());
		
		////////////////////панель 1 содержит кнопки, с помощью которых можно выбрать вид пользователя
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(1,2));
	
		JButton StrakhovatelB=new JButton("Страхователь");   
		JButton StrakhovshikB=new JButton("Страховщик");  
 
		StrakhovatelB.setForeground(Color.BLUE);                  //цвет текста кнопки 
		StrakhovshikB.setForeground(Color.RED);                  //цвет текста кнопки 
		
		StrakhovatelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovatel myStrakhovatel= new Strakhovatel();
				myStrakhovatel.setVisible(true);                                 //отобразить форму
			}});
		
		StrakhovshikB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Strakhovshik strakh=new Strakhovshik();
				strakh.setVisible(true);  
			}});
		panel.add(StrakhovatelB);
		panel.add(StrakhovshikB);

		//////////////////////////панель 2 содержит копирайт и рисунок
		JPanel panel1=new JPanel();
		panel1.setLayout(new FlowLayout());
		panel1.setBackground(Color.WHITE);                  //цвет фона ранели 2
		
		JLabel kopiright= new JLabel("copyright © 2018");
		panel1.add(kopiright);

		add(panel,BorderLayout.CENTER);
		add(panel1,BorderLayout.PAGE_END);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OsnF myOsnF= new OsnF();
		myOsnF.setVisible(true);
	}
}