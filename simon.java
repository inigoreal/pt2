import java.io.*;
import java.util.Random;

public class simon {
	public static void main (String[] args) throws Exception {
		String linea;
		int rondes=0;
		int rps=-1;
		int resultat[];
		int puntuacio[];
		int num=-1;
		resultat=new int [300];
		String color[];
		color=new String [4];
		String colorr[];
		colorr=new String [300];
		color[0]="Verd";
		color[1]="Taronja";
		color[2]="Groc";
		color[3]="Blau";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Random rand=new Random();
		System.out.println("SIMON EL JOC");
		System.out.println("Verd      [V]");
		System.out.println("Taronja   [T]");
		System.out.println("Groc      [G]");
		System.out.println("Blau      [B]");
		System.out.print("Introdueix Temps en segons: ");
		linea=reader.readLine();
		System.out.print("\033[H\033[2J");
		System.out.flush();
		int seg1=Integer.parseInt(linea);
		int seg=seg1*1000;
		
		while(true){
			//asignar els valors randoms a array resultat i també a array color resultat
			for(int i=rondes;i<rondes+1;i++){
				int random=rand.nextInt(4);
				resultat[i]=random;
				if (random==0){
					colorr[i]="Verd";
				}
				if (random==1){
					colorr[i]="Taronja";	
				}
				if (random==2){
					colorr[i]="Groc";	
				}
				if (random==3){
					colorr[i]="Blau";	
				}
			}		
			//mostra els colors a recordar i posa un temps (el que s'ha escollit)
			for(int i=0;i<rondes+1;i++){
				System.out.println("Identificador: "+colorr[i]);
			}
			System.out.print("Espera "+seg1+" segons");
			
				Thread.sleep(seg);
			
    		System.out.print("\033[H\033[2J");
			System.out.flush();
			//demana els colors corresponent a les respostes
			for(int i=0;i<rondes+1;i++){
				num=-1;
				System.out.print("Introdueix color:");
				String letra=reader.readLine();
				String lletra=letra.toUpperCase();
				//converteix els colors a numero
				if (lletra.equals("V")){
					num=0;
				}
				if (lletra.equals("T")){
					num=1;
				}
				if (lletra.equals("G")){
					num=2;
				}
				if (lletra.equals("B")){
					num=3;
				}
				//contador de rondes
				rps=rps+1;
				//sortida per veure si coincideix
				if (num==resultat[i]){
					if (rps==rondes){
						rondes=rondes+1;
						rps=-1;
						System.out.print("\033[H\033[2J");
						System.out.flush();
						break;
					}
					
					continue;
				}
				//error
				if (num!=resultat[i]){
					System.out.println("ERROR");
					System.out.print("Rondes guanyades: "+rondes);
					return;	
				}
			}
	
		} 
	}
}


