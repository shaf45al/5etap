package calc;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Strakhovshik extends JFrame {
	static JTextField predprKoefTF=new JTextField("0");
	static double predprKoef=0.5;
	public Strakhovshik(){
		setTitle("Страховщик");
		
		setSize(600,400);           

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);   //указывает что будет при нажатии крестика
		setLocationRelativeTo(null);                      //разместить по середине экрана форму 
		setLayout(new FlowLayout());
		
		//главная панель на которой будет расположено все остальное(панель для вида страхования, метка и кнопка "сохранить")
		JPanel panel=new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		//создание панели для вида страхования, метки, уточняющей смысл данной формы, и копки сохранения данных
		JPanel panelStrPredpRisk=new JPanel();
		JLabel label=new JLabel("Введите страховые тарифы!");
		label.setForeground(Color.RED);           //цвет текста метки
		JButton VnestiKoef=new JButton("Сохранить");   
		
		//устанавливаем выравнивание компонентов (по середине)
		panelStrPredpRisk.setAlignmentX(Component.CENTER_ALIGNMENT); 
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		VnestiKoef.setAlignmentX(Component.CENTER_ALIGNMENT);

		 //добавляем панель вида страхования, метку и кнопку сохранения на главную панель
		panel.add(label);
		panel.add(panelStrPredpRisk);
		panel.add(VnestiKoef);	
		
		add(panel);  //добавляем главную панель на форму
	
		//устанавливаем вид менеджера для размещения компонентов 
		panelStrPredpRisk.setLayout(new GridBagLayout());

		//////////////////////////////////////////////////////////////////////
		//создаем компоненты для панели panelStrPredpRisk
		JLabel predprKoefL=new JLabel("Коэффициент для расчета страховых взносов: ");
		predprKoefTF.setText("0.5");                    //устанавливает текст в поле
		System.out.println("первый раз установил "+predprKoef);
		
		//добавляем компоненты на панель panelStrPredpRisk
		panelStrPredpRisk.add(predprKoefL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(predprKoefTF,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		panelStrPredpRisk.add(VnestiKoef,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
		//добавление слушателя на кнопку VnestiKoef
		VnestiKoef.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				predprKoef=Double.parseDouble(Strakhovshik.predprKoefTF.getText());
				System.out.println("коеффициент сохранен");
			}
		});
	}
}
