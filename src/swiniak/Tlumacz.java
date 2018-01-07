package swiniak;

public class Tlumacz {

	public Tlumacz(){
		
	}
	
	public static void tlumaczenieMaterialu(){
		
		
		for(int i=0;i<Okienko.iloscZamowien;i++){
			
			if(Drukuj.buty[i].material=="Welur"||Drukuj.buty[i].material=="Welur\t"){
				Drukuj.buty[i].material="натуральный велюр";
				continue;
			}
			
				
		    if(Drukuj.buty[i].material=="Skora"){
		    	Drukuj.buty[i].material="нат.кожа";
		    	continue;
		    }
				
			
				
			if(Drukuj.buty[i].material=="Tekstyl/текстиль"){
				Drukuj.buty[i].material="Tekstyl/текстиль";
				continue;
				
			}
				
			if(Drukuj.buty[i].material=="Skora+Welur"){
				Drukuj.buty[i].material="нат.кожа/натуральный велюр";
				continue;
			}
			
		
			
		}
	}
	
public static void tlumaczenieMaterialuZbiorowe(){
		
		
		for(int i=0;i<Okienko.iloscZamowien;i++){
			
			if(Drukuj_Zbiorowe.buty[i].material=="Welur"||Drukuj_Zbiorowe.buty[i].material=="Welur\t"){
				Drukuj_Zbiorowe.buty[i].material="натуральный велюр";
				continue;
			}
			
				
		    if(Drukuj_Zbiorowe.buty[i].material=="Skora"){
		    	Drukuj_Zbiorowe.buty[i].material="нат.кожа";
		    	continue;
		    }
				
			
				
			if(Drukuj_Zbiorowe.buty[i].material=="Tekstyl/текстиль"){
				Drukuj_Zbiorowe.buty[i].material="Tekstyl/текстиль";
				continue;
				
			}
				
			if(Drukuj_Zbiorowe.buty[i].material=="Skora+Welur"){
				Drukuj_Zbiorowe.buty[i].material="нат.кожа/натуральный велюр";
				continue;
			}
			
		
			
		}
	}
		
		
		public static void tlumaczenieMaterialuPodszewki(){
			
			
			for(int i=0;i<Okienko.iloscZamowien;i++){
				
				if(Drukuj.buty[i].materialPodszewki=="Misiek")
					Drukuj.buty[i].materialPodszewki="шерстяной мех";
				if(Drukuj.buty[i].materialPodszewki=="Filc")
					Drukuj.buty[i].materialPodszewki="байка";
				if(Drukuj.buty[i].materialPodszewki=="Euro")
					Drukuj.buty[i].materialPodszewki="евро";
				if(Drukuj.buty[i].materialPodszewki=="Skora")
					Drukuj.buty[i].materialPodszewki="нат.кожа";
				if(Drukuj.buty[i].materialPodszewki=="Tekstyl/текстиль")
					Drukuj.buty[i].materialPodszewki="Tekstyl/текстиль";
				
					
			
				
			}

	}
		
public static void tlumaczenieMaterialuPodszewkiZbiorowe(){
			
			
			for(int i=0;i<Okienko.iloscZamowien;i++){
				
				if(Drukuj_Zbiorowe.buty[i].materialPodszewki=="Misiek")
					Drukuj_Zbiorowe.buty[i].materialPodszewki="шерстяной мех";
				if(Drukuj_Zbiorowe.buty[i].materialPodszewki=="Filc")
					Drukuj_Zbiorowe.buty[i].materialPodszewki="байка";
				if(Drukuj_Zbiorowe.buty[i].materialPodszewki=="Euro")
					Drukuj_Zbiorowe.buty[i].materialPodszewki="евро";
				if(Drukuj_Zbiorowe.buty[i].materialPodszewki=="Skora")
					Drukuj_Zbiorowe.buty[i].materialPodszewki="нат.кожа";
				if(Drukuj_Zbiorowe.buty[i].materialPodszewki=="Tekstyl/текстиль")
					Drukuj_Zbiorowe.buty[i].materialPodszewki="Tekstyl/текстиль";
				
					
			
				
			}

	}
		
public static void tlumaczenieKoloru(){
			
			
			for(int i=0;i<Okienko.iloscZamowien;i++){
				
				if(Drukuj.buty[i].kolor=="czarny")
					Drukuj.buty[i].kolor="черный";
				if(Drukuj.buty[i].kolor=="sliwka")
					Drukuj.buty[i].kolor="бордо";
				if(Drukuj.buty[i].kolor=="bordowy")
					Drukuj.buty[i].kolor="бордо";
				if(Drukuj.buty[i].kolor=="granatowy")
					Drukuj.buty[i].kolor="СИНИЙ";
				if(Drukuj.buty[i].kolor=="szary")
					Drukuj.buty[i].kolor="серый";	
				if(Drukuj.buty[i].kolor=="khaki")
					Drukuj.buty[i].kolor="хаки";
				if(Drukuj.buty[i].kolor=="brazowy")
					Drukuj.buty[i].kolor="коричневый";
				if(Drukuj.buty[i].kolor=="bezowy")
					Drukuj.buty[i].kolor="бежевый";
				
				
				if(Drukuj.buty[i].kolor=="miedz")
					Drukuj.buty[i].kolor="медь";
				if(Drukuj.buty[i].kolor=="miętowy")
					Drukuj.buty[i].kolor="мята";
				if(Drukuj.buty[i].kolor=="żółty")
					Drukuj.buty[i].kolor="желтый";
				if(Drukuj.buty[i].kolor=="multikolor")
					Drukuj.buty[i].kolor="многокрасочный";	
				if(Drukuj.buty[i].kolor=="zielony")
					Drukuj.buty[i].kolor="зеленый";
				if(Drukuj.buty[i].kolor=="fioletowy")
					Drukuj.buty[i].kolor="фиолетовый";
				if(Drukuj.buty[i].kolor=="srebro")
					Drukuj.buty[i].kolor="серебро";
				if(Drukuj.buty[i].kolor=="złoto")
					Drukuj.buty[i].kolor="золото"; 
				if(Drukuj.buty[i].kolor=="czerwony")
					Drukuj.buty[i].kolor="красный";
					if(Drukuj.buty[i].kolor=="pudrowy")
						Drukuj.buty[i].kolor="порошок";
				
			}

	}

public static void tlumaczenieKoloruZbiorowe(){
	
	
	for(int i=0;i<Okienko.iloscZamowien;i++){
		
		if(Drukuj_Zbiorowe.buty[i].kolor=="czarny")
			Drukuj_Zbiorowe.buty[i].kolor="черный";
		if(Drukuj_Zbiorowe.buty[i].kolor=="sliwka")
			Drukuj_Zbiorowe.buty[i].kolor="бордо";
		if(Drukuj_Zbiorowe.buty[i].kolor=="bordowy")
			Drukuj_Zbiorowe.buty[i].kolor="бордо";
		if(Drukuj_Zbiorowe.buty[i].kolor=="granatowy")
			Drukuj_Zbiorowe.buty[i].kolor="СИНИЙ";
		if(Drukuj_Zbiorowe.buty[i].kolor=="szary")
			Drukuj_Zbiorowe.buty[i].kolor="серый";	
		if(Drukuj_Zbiorowe.buty[i].kolor=="khaki")
			Drukuj_Zbiorowe.buty[i].kolor="хаки";
		if(Drukuj_Zbiorowe.buty[i].kolor=="brazowy")
			Drukuj_Zbiorowe.buty[i].kolor="коричневый";
		if(Drukuj_Zbiorowe.buty[i].kolor=="bezowy")
			Drukuj_Zbiorowe.buty[i].kolor="бежевый";
		
		if(Drukuj_Zbiorowe.buty[i].kolor=="miedz")
			Drukuj_Zbiorowe.buty[i].kolor="медь";
		if(Drukuj_Zbiorowe.buty[i].kolor=="miętowy")
			Drukuj_Zbiorowe.buty[i].kolor="мята";
		if(Drukuj_Zbiorowe.buty[i].kolor=="żółty")
			Drukuj_Zbiorowe.buty[i].kolor="желтый";
		if(Drukuj_Zbiorowe.buty[i].kolor=="multikolor")
			Drukuj_Zbiorowe.buty[i].kolor="многокрасочный";	
		if(Drukuj_Zbiorowe.buty[i].kolor=="zielony")
			Drukuj_Zbiorowe.buty[i].kolor="зеленый";
		if(Drukuj_Zbiorowe.buty[i].kolor=="fioletowy")
			Drukuj_Zbiorowe.buty[i].kolor="фиолетовый";
		if(Drukuj_Zbiorowe.buty[i].kolor=="srebro")
			Drukuj_Zbiorowe.buty[i].kolor="серебро";
		if(Drukuj_Zbiorowe.buty[i].kolor=="złoto")
			Drukuj_Zbiorowe.buty[i].kolor="золото";
		if(Drukuj_Zbiorowe.buty[i].kolor=="czerwony")
			Drukuj_Zbiorowe.buty[i].kolor="красный";
		if(Drukuj_Zbiorowe.buty[i].kolor=="pudrowy")
			Drukuj_Zbiorowe.buty[i].kolor="порошок";
		
	}

}
		
}
