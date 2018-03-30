package calc;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LichnyKab extends JFrame{
	static boolean isRun1=false;
	String loginProverka="";
	String parolProverka="";
	static JLabel ostatokPoVznosam=new JLabel("");   

	public LichnyKab(){
		//ввод логина
		loginProverka=JOptionPane.showInputDialog(null, "Введите логин", null, JOptionPane.INFORMATION_MESSAGE);
		//ввод пароля
		parolProverka=JOptionPane.showInputDialog(null, "Введите пароль", null, JOptionPane.INFORMATION_MESSAGE);
		
		if(Registracya.parol.equals(parolProverka) & Registracya.login.equals(loginProverka)){
				System.out.println("Вы правы");	
				setSize(600,400);           
				setTitle("Личный кабинет");
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указывает что будет при нажатии крестика
				setLocationRelativeTo(null);                      //разместить по середине экрана форму 
				setLayout(new GridLayout(2,20,1,20));
		
				JPanel panel=new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

				JButton vykhod=new JButton("Выход");
				JButton vnestiVznos=new JButton("Внести взнос");  
				JLabel ostatokPoVznosamL= new JLabel("Остаток по страховым взносам,руб: ");
				JButton polychitVyplaty=new JButton("Получить страховую выплату");
				
				if(ostatokPoVznosam.getText().equals("0"))
					System.out.println("Остаток по взносам 0");
				else 
				ostatokPoVznosam.setText(String.valueOf(Formuly.RaschitatSP()));   //оно будет браться из функции кот расчитывает по введенным страхователем данным
				
					//устанавливаем выравнивание компонентов (по середине)
					ostatokPoVznosamL.setAlignmentX(Component.CENTER_ALIGNMENT); 
					ostatokPoVznosam.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vnestiVznos.setAlignmentX(Component.CENTER_ALIGNMENT); 
					vykhod.setAlignmentX(Component.CENTER_ALIGNMENT); 
					polychitVyplaty.setAlignmentX(Component.CENTER_ALIGNMENT); 

					panel.add(Box.createVerticalGlue()); //вставляем пружину.
					panel.add(ostatokPoVznosamL);			
					panel.add(Box.createVerticalGlue()); //вставляем пружину.
					panel.add(ostatokPoVznosam);			
					panel.add(Box.createVerticalGlue()); //вставляем пружину.		
					panel.add(vnestiVznos);
					panel.add(Box.createVerticalGlue()); //вставляем пружину.
					panel.add(polychitVyplaty);
					panel.add(Box.createVerticalGlue()); //вставляем пружину.
					panel.add(vykhod);
					panel.add(Box.createVerticalGlue()); //вставляем пружину.

					vykhod.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							setVisible(false);
						}
					});
					
					vnestiVznos.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							LichnyKab.VnestiStrVznos();
						}
					});
					
					polychitVyplaty.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(ostatokPoVznosam.getText().equals("0")) {
								StrVyplata myVyplata=new StrVyplata();
								myVyplata.setVisible(true);
							}else
								System.out.println("остаток по страховой премии не 0");
						}
					});
					
					add(panel);
       
		}
	}
	
	public static void VnestiStrVznos(){
			ostatokPoVznosam.setText("0");
	}
}


