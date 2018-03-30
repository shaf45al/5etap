package calc;

public class Formuly {
	float StrVznosu;
	static Float sum;
	static int SP;
	
	public static int RaschitatSP(){
		if(Strakhovshik.predprKoef==0) {
			Strakhovshik.predprKoef=Double.parseDouble(Strakhovshik.predprKoefTF.getText());
			System.out.println("страховщик не установил тариф"+Strakhovshik.predprKoef);
		}
		return SP =  (int)(Registracya.DPr*Strakhovshik.predprKoef);
	}
	
	public static int RaschitatY(){
		int y;
		System.out.println(StrVyplata.poluchD);

		int DPol = Integer.parseInt(StrVyplata.poluchD);
		if(DPol<Registracya.DPr)
		 y=Registracya.DPr-DPol;
		else {
			System.out.println("ущерба не было нанесено");
			y=0;
		}
		return y;
	}
	
	public static int RaschitatSV(){
		System.out.println("процент ответственности страховщика"+Registracya.a);
		
		return SP= Formuly.RaschitatY()*Registracya.a/100;
	}
}
