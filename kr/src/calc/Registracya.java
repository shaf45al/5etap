package calc;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registracya extends JFrame {
	static String login="hahaha";
	static String parol="hahaha";
	
	static int DPr;
	static int a;
	
	public Registracya(){
		
//форма для ввода необходимых данных для дальнейших расчетов
		
		//проверяет открыта ли эта форма, если открыта, то нельзя создавать новую пока старую не закроешь
		if(Strakhovatel.isRun1==false){
			
			//сообщение о потере предыдущих данных.
			int opcion=JOptionPane.showConfirmDialog(null, "При подаче новой заявки, старая будет недействительна. Продолжить?", null, JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	
			if(opcion==JOptionPane.YES_OPTION){
				System.out.println("ну и хорошо :)");
					
				LichnyKab.isRun1=false;
				Strakhovatel.isRun1=true;
				
				setTitle("Создание новой учетной записи");
				setSize(600,400);           
				setUndecorated(false);					//будет ли показан заголовок формы "шапочку"(если true не будет кнопок закрыть,развернуть,свернуть)
				setLocationRelativeTo(null);            //разместить по середине экрана форму 
				setLayout(new FlowLayout());
				//создание основной панели
				JPanel panel=new JPanel();
				panel.setLayout(new GridBagLayout());
				
				//создаем основные компоненты.
				JButton vykhod=new JButton("Выход"); 
				JButton prodolj=new JButton("Продолжить"); 
				JTextField FIO=new JTextField();
				JTextField parolTF=new JTextField(9);
				JTextField loginTF=new JTextField(9);
				String[] vidStr = {                         //варианты для combobox
					    "страхование предпринимательких рисков"
					};
				JComboBox comboBoxVidStr = new JComboBox(vidStr);  //combobox для выбора вида страхования
				JButton PodatZayavky=new JButton("Завершить регистрацию"); 
				
				JLabel FIOL= new JLabel("Введите ФИО: ");
				JLabel parolL= new JLabel("Придумайте пароль: ");
				JLabel loginL= new JLabel("Придумайте логин: ");
				JLabel VidStrL= new JLabel("Выберите вид страхования: ");


				//добавляем компоненты на панель
				panel.add(FIOL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(parolL,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(VidStrL,new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
		
				panel.add(parolTF,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(loginTF,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(FIO,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(comboBoxVidStr,new GridBagConstraints(1,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(prodolj,new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
				panel.add(vykhod,new GridBagConstraints(1,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

				//добавляем панель на форму
				add(panel);
								
				//создаем компоненты для страхования предпринимательских рисков.		
				JTextField PrognozirDoh=new JTextField("0");
				JTextField proczOtvetStrahovshikaP=new JTextField("0");
				JLabel PrognozirDohL= new JLabel("Прогнозируемый доход, руб: ");
				JLabel proczOtvetStrahovshikaPL= new JLabel("Процент ответственности страховщика,%: ");

				//слушатель на кнопку выхода
				vykhod.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Strakhovatel.isRun1=false;
						setVisible(false);
					}
				});
				//слушатель на кнопку продолжения
				prodolj.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						parol=parolTF.getText();
						login=loginTF.getText();

								panel.remove(parolTF);
								panel.remove(loginTF);
								panel.remove(FIO);
								panel.remove(comboBoxVidStr);
								panel.remove(parolL);
								panel.remove(loginL);
								panel.remove(FIOL);
								panel.remove(VidStrL);
								panel.remove(prodolj);
								
								panel.add(PrognozirDoh,new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaP,new GridBagConstraints(1,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));

								panel.add(PrognozirDohL,new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(proczOtvetStrahovshikaPL,new GridBagConstraints(0,1,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(PodatZayavky,new GridBagConstraints(0,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								panel.add(vykhod,new GridBagConstraints(1,2,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(1,1,1,1),0,0));
								
								panel.revalidate();//сообщает менеджеру компоновки пересчитать макет (что необходимо при добавлении компонентов)
						}
					});
				
				PodatZayavky.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 DPr=Integer.parseInt(PrognozirDoh.getText());
						 a=Integer.parseInt(proczOtvetStrahovshikaP.getText());
						 LichnyKab.ostatokPoVznosam.setText("");
						 System.out.println("процент ответственности страховщика "+a);
						 System.out.println("прогнозируемый доход "+ DPr);
					}
				});
			
			}  //завершение if(opcion==JOptionPane.YES_OPTION)
		}else
			System.out.println("Вы уже открыли форму");
	}
}