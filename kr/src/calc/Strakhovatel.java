package calc;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Strakhovatel extends JFrame{
	static boolean isRun1=false;

	public Strakhovatel(){
		
		setTitle("Страхователь");
		
		setSize(500,400);           

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указывает что будет при нажатии крестика
		setLocationRelativeTo(null);                      //разместить по середине экрана форму 
		setLayout(new GridLayout());
		
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton zaregat=new JButton("Регистрация");
		zaregat.setForeground(Color.BLUE);
		JButton lichKab=new JButton("Войти в личный кабнет"); 
		JLabel podatZayavL=new JLabel("Еще не зарегистрированы?");
		
		//устанавливаем выравнивание компонентов (по середине)
		zaregat.setAlignmentX(Component.CENTER_ALIGNMENT); 
		lichKab.setAlignmentX(Component.CENTER_ALIGNMENT); 
		podatZayavL.setAlignmentX(Component.CENTER_ALIGNMENT); 
		
		panel.add(Box.createVerticalGlue(),0); //вставляем верхнюю пружину в нулевую позицию.
		panel.add(lichKab);
		panel.add(Box.createVerticalGlue()); //вставляем пружину.
		panel.add(podatZayavL);
		panel.add(zaregat);
		panel.add(Box.createVerticalGlue()); //вставляем пружину.

		//добавляем слушателя на кнопку регистрации
		zaregat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registracya p=new Registracya();
				p.setVisible(true); //делаем форму видимой
			}
		});
		
		//добавляем слушателя на кнопку для входа в личный кабинет
		lichKab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LichnyKab l=new LichnyKab();
				l.setVisible(true); 
			}
		});
		
		add(panel);

	}		
}
