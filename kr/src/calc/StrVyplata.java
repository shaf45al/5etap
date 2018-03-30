package calc;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StrVyplata extends JFrame{
	static String poluchD="0";
	
	public StrVyplata(){
		if(LichnyKab.isRun1==false){
			LichnyKab.isRun1=true;
			
			poluchD = JOptionPane.showInputDialog(null, "Введите полученный ущерб", null, JOptionPane.INFORMATION_MESSAGE);
			
			if (poluchD.equals("")) {
				LichnyKab.isRun1=false;
				setVisible(false);
			}
			else {
			
			setTitle("Страховая выплата");	
			setSize(600,400);  
			setLocationRelativeTo(null);                      //разместить по середине экрана форму 
			setLayout(new GridLayout());
		
			//создаем панель и компоненты,которые будут расположены на панели
			JPanel panel=new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

			JLabel label=new JLabel("Сумма страховой выплаты, руб:");
			JLabel strVyplataL=new JLabel(String.valueOf(Formuly.RaschitatSV()));
			JLabel pravila=new JLabel("Для получения страховой выплаты");
			JLabel pravila1=new JLabel("обратитесь в приемный отдел по адресу: ул.Гафури, д.76");

			//устанавливаем выравнивание компонентов (по середине)
			label.setAlignmentX(Component.CENTER_ALIGNMENT); 
			strVyplataL.setAlignmentX(Component.CENTER_ALIGNMENT); 
			pravila.setAlignmentX(Component.CENTER_ALIGNMENT); 
			pravila1.setAlignmentX(Component.CENTER_ALIGNMENT); 

			panel.add(Box.createVerticalGlue()); //вставляем верхнюю пружину в нулевую позицию.
			panel.add(label);
			panel.add(Box.createVerticalGlue()); //вставляем пружину.
			panel.add(strVyplataL);
			panel.add(Box.createVerticalGlue()); //вставляем пружину.
			panel.add(pravila);
			panel.add(pravila1);
			panel.add(Box.createVerticalGlue()); //вставляем пружину.

			add(panel);
		}
	  }
	}
}
