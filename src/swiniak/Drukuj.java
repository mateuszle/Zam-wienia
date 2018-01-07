package swiniak;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Drukuj {

	
	public static But[] buty=new But[Okienko.iloscZamowien];

	public Drukuj(){
		long start=System.currentTimeMillis();
				Okienko.pobierzDate();

				
				
				
				//Okno o= new Okno();
			//	But[] buty=new But[Okienko.iloscZamowien];
				int l=0;
				
				
				
					if(Okienko.iloscKozakow>0){
						
						for(;l<Okienko.iloscKozakow;l++){
						
							buty[l]=new Kozak(KozakPanel.TabModelKozaka[l],KozakPanel.TabModelKozaka2[l],KozakPanel.TabMaterialKozaka[l],KozakPanel.TabMaterialPodszewkiKozaka[l],KozakPanel.TabKolorKozaka[l],"полимерный материал",KozakPanel.TabParyKozaka[l]);
							
						}
						
					}
					
					if(Okienko.iloscPolbutow>0){
						for(int po=0;po<Okienko.iloscPolbutow;po++,l++){
							buty[l]=new Polbut(PolbutPanel.TabModelPolbuta[po],PolbutPanel.TabModelPolbuta2[po],PolbutPanel.TabMaterialPolbuta[po],PolbutPanel.TabMaterialPodszewkiPolbuta[po],PolbutPanel.TabKolorPolbuta[po],"полимерный материал",PolbutPanel.TabParyPolbuta[po]);
						}
						
					}
					
					
					if(Okienko.iloscSandalow>0){
						for(int po=0;po<Okienko.iloscSandalow;po++,l++){
							buty[l]=new Sandal(SandalPanel.TabModelSandala[po],SandalPanel.TabModelSandala2[po],SandalPanel.TabMaterialSandala[po],SandalPanel.TabMaterialPodszewkiSandala[po],SandalPanel.TabkolorSandala[po],"полимерный материал",SandalPanel.TabParySandala[po]);
						}
						
					}
					
					if(Okienko.iloscBotkow>0){
						for(int po=0;po<Okienko.iloscBotkow;po++,l++){
							System.out.println(BotekPanel.TabModelBotka[po]); //dodalem tu narazie dynamiczna liste 
							buty[l]=new Botek(BotekPanel.TabModelBotka[po],BotekPanel.TabModelBotka2[po],BotekPanel.TabMaterialBotka[po],BotekPanel.TabMaterialPodszewkiBotka[po],BotekPanel.TabkolorBotka[po],"полимерный материал",BotekPanel.TabParyBotka[po]);
							System.out.println("dupa2" +Okienko.iloscBotkow);
						}
						
					}
					
					//zmiana jezyka tekstu z polskiego na rosyjski
					Tlumacz.tlumaczenieMaterialu();
					Tlumacz.tlumaczenieMaterialuPodszewki();
					Tlumacz.tlumaczenieKoloru();
					
			
				//przyporzadkowywanie ilosci par do pojedynczego zamowienia buta
				Pary[] par=new Pary[Okienko.iloscZamowien];
				for(int j=0;j<Okienko.iloscZamowien;j++){
					par[j]=new Pary(buty[j].iloscPar);
				}
				
				
				
				
				try {
					
					
					FileOutputStream plik=new FileOutputStream("etykieta-jednostkowa-"+Okienko.nrKlienta+".doc");
					XWPFDocument doc=new XWPFDocument();
					XWPFParagraph para=doc.createParagraph();
					
		             String imgFile=("obraz.jpg");
		          
		           
		                for(int j=0;j<Okienko.iloscZamowien;j++){
		                	for(int i=0;i<buty[j].iloscPar;i++){
			
		                	XWPFRun paraRun=para.createRun();
		        			paraRun.setBold(true);
		        			paraRun.setFontSize(12);
		                	paraRun.setText("Модель: "+buty[j].model+"|"+buty[j].model2+"            ");
		                    int format=XWPFDocument.PICTURE_TYPE_JPEG;
		                    paraRun.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(28), Units.toEMU(13));
		        			paraRun.addBreak();
		        			paraRun.setText("Размер: "+par[j].tablica[i]+"             Цвет: "+buty[j].kolor);
		        			paraRun.addBreak();
		        			
		        			

		        			
		        			
		        			XWPFRun paraRun2=para.createRun();
		        			paraRun2.setBold(true);
		        			paraRun2.setFontSize(10);
		        			paraRun2.setText("Вид:");
		        			XWPFRun paraRun3=para.createRun();
		        			paraRun3.setBold(false);
		        			paraRun3.setText(" "+buty[j].typObuwia); 
		        			paraRun3.setFontSize(10);
		        			paraRun3.addBreak();
		        			XWPFRun paraRun4=para.createRun();
		        			paraRun4.setFontSize(10);
		        			paraRun4.setBold(true);
		        			paraRun4.setText("Мат. верха:");   
		        			XWPFRun paraRun5=para.createRun();
		        			paraRun5.setBold(false);
		        			paraRun5.setText(" "+buty[j].material);
		        			paraRun5.setFontSize(10);
		        			paraRun5.addBreak();
		        			XWPFRun paraRun6=para.createRun();
		        			paraRun6.setBold(true);
		        			paraRun6.setFontSize(10);
		        			paraRun6.setText("Мат. подкладки: ");
		        			XWPFRun paraRun7=para.createRun();
		        			paraRun7.setBold(false);
		        			paraRun7.setText(buty[j].materialPodszewki);
		        			paraRun7.setFontSize(10);
		        			paraRun7.addBreak();
		        			XWPFRun paraRun8=para.createRun();
		        			paraRun8.setBold(true);
		        			paraRun8.setText("Мат. подошвы: ");
		        			paraRun8.setFontSize(10);
		        			XWPFRun paraRun9=para.createRun();
		        			paraRun9.setBold(false);
		        			paraRun9.setText(buty[j].materialPodeszwy);
		        			paraRun9.setFontSize(10);
		        			paraRun9.addBreak();
		        			
		        			XWPFRun paraRun10=para.createRun();
		        			paraRun10.setBold(true);
		        			paraRun10.setFontSize(10);
		        			XWPFRun paraRun11=para.createRun();
		        			paraRun11.setBold(true);
		        			paraRun11.setFontSize(10);
		        			XWPFRun paraRun12=para.createRun();
		        			paraRun12.setBold(false);
		        			XWPFRun paraRun13=para.createRun();
		        			paraRun13.setBold(true);
		        			paraRun13.setFontSize(10);
		        			Okienko.drukujAdresOdbiorcy(paraRun10,Okienko.numerAdresuOdbiorcy);     //  1 - adres polski  2- adres rosyjski!!!!
		        			
		        			Okienko.drukujAdresNadawcy(paraRun11,paraRun12,paraRun13,Okienko.numerAdresuOdbiorcy);      //  1 - adres polski  2- adres rosyjski!!!!
		        			
		        				
		                
		                }	
		                	
		                	
		                }
		                
					
				//XWPFRun paragraphTenRunOne = para.createRun();
			       // paragraphTenRunOne.setText("this text must be in the first column");
			       // paragraphTenRunOne.addBreak(BreakType.COLUMN);
			       // paragraphTenRunOne.setText("this text must be in the second column");
			        doc.write(plik);
			        doc.close();
			        plik.close();
			        
				} catch (FileNotFoundException f) {
					// TODO Auto-generated catch block
					f.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InvalidFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				long stop=System.currentTimeMillis();
				System.out.println("Czas wykonania:"+(stop-start));
				
			}
		
	
		
		
		
	
}
