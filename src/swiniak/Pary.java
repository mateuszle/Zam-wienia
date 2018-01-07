package swiniak;

public class Pary {

	int[] tablica=new int[20];
	int[] ilosc_par=new int[6];
	public Pary(int i){
		if(i==8){
			tablica[0]=36;
			ilosc_par[0]=1;
			tablica[1]=37;
			tablica[2]=37;
			ilosc_par[1]=2;
			tablica[3]=38;
			tablica[4]=38;
			ilosc_par[2]=2;
			tablica[5]=39;
			tablica[6]=39;
			ilosc_par[3]=2;
			tablica[7]=40;
			ilosc_par[4]=1;
		}
		if(i==5){
			tablica[0]=36;
			ilosc_par[0]=1;
			tablica[1]=37;
			ilosc_par[1]=1;
			tablica[2]=38;
			ilosc_par[2]=1;
			tablica[3]=39;
			ilosc_par[3]=1;
			tablica[4]=40;
			ilosc_par[4]=1;
		}
		if(i==6){
			tablica[0]=36;
			ilosc_par[0]=1;
			tablica[1]=37;
			ilosc_par[1]=1;
			tablica[2]=38;
			tablica[3]=38;
			ilosc_par[2]=2;
			tablica[4]=39;
			ilosc_par[3]=1;
			tablica[5]=40;
			ilosc_par[4]=1;
		}
		if(i==10){
			tablica[0]=36;
			tablica[1]=36;
			ilosc_par[0]=2;
			tablica[2]=37;
			tablica[3]=37;
			ilosc_par[1]=2;
			tablica[4]=38;
			tablica[5]=38;
			ilosc_par[2]=2;
			tablica[6]=39;
			tablica[7]=39;
			ilosc_par[3]=2;
			tablica[8]=40;
			tablica[9]=40;
			ilosc_par[4]=2;
		}
		if(i==12){
			tablica[0]=36;
			ilosc_par[0]=1;
			tablica[1]=37;
			tablica[2]=37;
			ilosc_par[1]=2;
			tablica[3]=38;
			tablica[4]=38;
			tablica[5]=38;
			tablica[6]=38;
			ilosc_par[2]=4;
			tablica[7]=39;
			tablica[8]=39;
			tablica[9]=39;
			ilosc_par[3]=3;
			tablica[10]=40;
			tablica[11]=40;
			ilosc_par[4]=2;
		}
	}
	
}
