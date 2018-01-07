package swiniak;


import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import javax.swing.border.MatteBorder;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTable.XWPFBorderType;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableCell.XWPFVertAlign;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblGrid;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;

public class Drukuj_Zbiorowe {

	
	public static But[] buty=new But[200];

	public Drukuj_Zbiorowe() throws InvalidFormatException{
		long start=System.currentTimeMillis();
				Okienko.pobierzDate();

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
						buty[l]=new Botek(BotekPanel.TabModelBotka[po],BotekPanel.TabModelBotka2[po],BotekPanel.TabMaterialBotka[po],BotekPanel.TabMaterialPodszewkiBotka[po],BotekPanel.TabkolorBotka[po],"полимерный материал",BotekPanel.TabParyBotka[po]);
					}
					
				}
				
				//zmiana jezyka tekstu z polskiego na rosyjski
				Tlumacz.tlumaczenieMaterialuZbiorowe();
				Tlumacz.tlumaczenieMaterialuPodszewkiZbiorowe();
				Tlumacz.tlumaczenieKoloruZbiorowe();
				
		
			//przyporzadkowywanie ilosci par do pojedynczego zamowienia buta
			Pary[] par=new Pary[Okienko.iloscZamowien];
			for(int j=0;j<Okienko.iloscZamowien;j++){
				par[j]=new Pary(buty[j].iloscPar);
			}
				
				try {
					
					
					FileOutputStream plik=new FileOutputStream("etykieta-zbiorowa-"+Okienko.nrKlienta+".doc");
					XWPFDocument doc=new XWPFDocument();
					
					
		             String imgFile=("obraz.jpg");
		             
		             for(int j=0;j<Okienko.iloscZamowien;j++){
		            	 XWPFParagraph para=doc.createParagraph();
		            	 XWPFRun paraRun=para.createRun();
		        			paraRun.setBold(true);
		        			paraRun.setFontSize(11);
		                	paraRun.setText("Модель: "+buty[j].model+"|"+buty[j].model2+"                                                          ");
		                	int format=XWPFDocument.PICTURE_TYPE_JPEG;
		                    paraRun.addPicture(new FileInputStream(imgFile), format, imgFile, Units.toEMU(28), Units.toEMU(13));
		        			paraRun.addBreak();
		                	XWPFRun paraRun2=para.createRun();
		        			paraRun2.setBold(true);
		        			paraRun2.setFontSize(11);
		        			paraRun2.setText("Вид:");
		        			paraRun2.setText(" "+buty[j].typObuwia); 	
		        			paraRun2.addBreak();
		        			
		                  
		        			XWPFRun paraRun3=para.createRun();
		        			paraRun3.setBold(true);
		        			
		        			paraRun3.setText("Цвет: ");
		        			
		        			
		        			XWPFRun paraRun33=para.createRun();
		        			paraRun33.setBold(true);
		        			paraRun33.setFontFamily("Arial");
		        			paraRun33.setText(buty[j].kolor);
		        			paraRun33.addBreak();

		        		
		        			XWPFRun paraRun4=para.createRun();
		        			paraRun4.setFontSize(11);
		        			paraRun4.setBold(true);
		        			paraRun4.setText("Мат. верха:");   
		        			XWPFRun paraRun5=para.createRun();
		        			paraRun5.setBold(false);
		        			paraRun5.setText(" "+buty[j].material);
		        			paraRun5.setFontSize(11);
		        			paraRun5.addBreak();
		        			XWPFRun paraRun6=para.createRun();
		        			paraRun6.setBold(true);
		        			paraRun6.setFontSize(11);
		        			paraRun6.setText("Мат. подкладки: ");
		        			XWPFRun paraRun7=para.createRun();
		        			paraRun7.setBold(false);
		        			paraRun7.setText(buty[j].materialPodszewki);
		        			paraRun7.setFontSize(11);
		        			paraRun7.addBreak();
		        			XWPFRun paraRun8=para.createRun();
		        			paraRun8.setBold(true);
		        			paraRun8.setText("Мат. подошвы: ");
		        			paraRun8.setFontSize(11);
		        			XWPFRun paraRun9=para.createRun();
		        			paraRun9.setBold(false);
		        			paraRun9.setText(buty[j].materialPodeszwy);
		        			paraRun9.setFontSize(11);
		        		
		        		
		        			
		        			 XWPFTable table3 = doc.createTable();
		        			
		        			
		        			
		        			table3.getCTTbl().getTblPr().getTblBorders().getTop().setSz(BigInteger.valueOf(12));
		        			table3.getCTTbl().getTblPr().getTblBorders().getLeft().setSz(BigInteger.valueOf(12));
		        			table3.getCTTbl().getTblPr().getTblBorders().getRight().setSz(BigInteger.valueOf(12));
		        			table3.getCTTbl().getTblPr().getTblBorders().getBottom().setSz(BigInteger.valueOf(12));
		        			table3.getCTTbl().getTblPr().getTblBorders().getInsideH().setSz(BigInteger.valueOf(12));
		        			table3.getCTTbl().getTblPr().getTblBorders().getInsideV().setSz(BigInteger.valueOf(12));

		        			
		        			
				            // XWPFParagraph para2=doc.createParagraph();
				             XWPFTableCell c;
				             
				             XWPFRun run2=para.createRun();
				          
				             
				             //create first row
				             XWPFTableRow tableRowOne2 = table3.getRow(0);
//				             CTTblPr tblpro = table3.getCTTbl().getTblPr();
//
//				             CTTblBorders borders = tblpro.addNewTblBorders();
//				             borders.addNewBottom().setVal(STBorder.BASIC_BLACK_DOTS); 
//				            
				            
				            // tableRowOne2.getCell(0).removeParagraph(0);
				            // XWPFParagraph paragraph = tableRowOne2.getCell(0).addParagraph();
				             //XWPFRun run6=paragraph.createRun();
				            // run6.setBold(true);
				             //run6.setText("   34  ");
				            // tableRowOne2.getCell(0);//.setText("         36");
				            
				              //tableRowOne2.addNewTableCell();
				            // tableRowOne2.getCell(1).removeParagraph(0);
				           // XWPFParagraph paragraph5 = tableRowOne2.getCell(1).addParagraph();
				            // XWPFRun run7=paragraph5.createRun();
				            // run7.setBold(true);
				            // run7.setText("   37  ");
				            
				             tableRowOne2.addNewTableCell();
				             tableRowOne2.addNewTableCell();
				             tableRowOne2.addNewTableCell();
				             tableRowOne2.addNewTableCell();
				             tableRowOne2.addNewTableCell();
				             
				            // tableRowOne2.setHeight((short)480);
				          
				             tableRowOne2.getCell(0).removeParagraph(0);
				             tableRowOne2.getCell(1).removeParagraph(0);
				             tableRowOne2.getCell(2).removeParagraph(0);
				             tableRowOne2.getCell(3).removeParagraph(0);
				             tableRowOne2.getCell(4).removeParagraph(0);
				             tableRowOne2.getCell(5).removeParagraph(0);
				             
				             XWPFRun run=para.createRun();
				             run= tableRowOne2.getCell(0).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("         36");
				             
				             run= tableRowOne2.getCell(1).addParagraph().createRun();
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("         37");
				             
				             run= tableRowOne2.getCell(2).addParagraph().createRun();
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("         38");
				             
				             run= tableRowOne2.getCell(3).addParagraph().createRun();
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("         39");
				             
				             run= tableRowOne2.getCell(4).addParagraph().createRun();
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("         40");
				             
				             run= tableRowOne2.getCell(5).addParagraph().createRun();
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("    Разом");
				             
				             //ustawianie szerokosci kolumny 
				             for(int i=0;i<6;i++){
				            	 c=tableRowOne2.getCell(i);
				            	 c.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1450));
				             }
				             

				             //create second row
				             XWPFTableRow tableRowTwo2 = table3.createRow();
//				             tableRowTwo2.addNewTableCell();
//				             tableRowTwo2.addNewTableCell();
//				             tableRowTwo2.addNewTableCell();
//				             tableRowTwo2.addNewTableCell();
//				             tableRowTwo2.addNewTableCell();
//				             tableRowTwo2.addNewTableCell();
				             
				            // tableRowOne2.setHeight((short)480);
				          
				             tableRowTwo2.getCell(0).removeParagraph(0);
				             tableRowTwo2.getCell(1).removeParagraph(0);
				             tableRowTwo2.getCell(2).removeParagraph(0);
				             tableRowTwo2.getCell(3).removeParagraph(0);
				             tableRowTwo2.getCell(4).removeParagraph(0);
				             tableRowTwo2.getCell(5).removeParagraph(0);
				             
				             run= tableRowTwo2.getCell(0).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          "+par[j].ilosc_par[0]);
				             
				             run= tableRowTwo2.getCell(1).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          "+par[j].ilosc_par[1]);
				             
				             run= tableRowTwo2.getCell(2).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          "+par[j].ilosc_par[2]);
				             
				             run= tableRowTwo2.getCell(3).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          "+par[j].ilosc_par[3]);
				             
				             run= tableRowTwo2.getCell(4).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          "+par[j].ilosc_par[4]);
				             
				             run= tableRowTwo2.getCell(5).addParagraph().createRun();				             
				             run.setFontSize(12);
				             run.setBold(true);
				             run.setText("          " +buty[j].iloscPar);
				             
//				             tableRowTwo2.getCell(0).setText("          "+par[j].ilosc_par[0]);
//				             tableRowTwo2.getCell(1).setText("          "+par[j].ilosc_par[1]);
//				             tableRowTwo2.getCell(2).setText("          "+par[j].ilosc_par[2]);
//				             tableRowTwo2.getCell(3).setText("          "+par[j].ilosc_par[3]);
//				             tableRowTwo2.getCell(4).setText("          "+par[j].ilosc_par[4]);
//				             tableRowTwo2.getCell(5).setText("          " +buty[j].iloscPar);
				           
				            // tableRowTwo2.setHeight(480);
				             
				             
				             //		        			//create table
//		             XWPFTable table = doc.createTable();
//		            // XWPFParagraph para2=doc.createParagraph();
//		           
//		             
//		             XWPFRun run=para.createRun();
//		          
//		                 //create first row
//		             XWPFTableRow tableRowOne = table.getRow(0);
//		             XWPFTableCell c;
//		             
//		             
//		             tableRowOne.getCell(0).setText("12");
//		             run= tableRowOne.getCell(0).addParagraph().createRun();
//		             tableRowOne.getCell(0).setVerticalAlignment(XWPFVertAlign.TOP);
//		             run.setBold(true);
//		            run.removeTab();
//		             run.setFontSize(12);
//		             run.setText("      36");
//		            
//		           
//		             run= tableRowOne.addNewTableCell().addParagraph().createRun();
//		             run.setBold(true);
//		             run.setFontSize(12);
//
//		             run.setText("      37   ");
//                     
//		             run= tableRowOne.addNewTableCell().addParagraph().createRun();
//		             run.setBold(true);
//		             run.setFontSize(12);
//
//		             run.setText("      38   ");
//		             
//		             run= tableRowOne.addNewTableCell().addParagraph().createRun();
//		             run.setFontSize(12);
//
//		             run.setBold(true);
//		             run.setText("      39      ");
//		             
//		             run= tableRowOne.addNewTableCell().addParagraph().createRun();
//		             run.setFontSize(12);
//
//		             run.setBold(true);
//		             run.setText("      40   ");
//		             
//		             run= tableRowOne.addNewTableCell().addParagraph().createRun();
//		             run.setFontSize(12);
//                     run.setBold(true);
//		             run.setText("    Разом  ");
//		             
//		           //ustawianie szerokosci kolumny 
//		             for(int i=0;i<6;i++){
//		            	 c=tableRowOne.getCell(i);
//		            	 c.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
//		             }
//		            
//		             tableRowOne.setHeight(2);
//		            
//		             //create second row
//		             XWPFTableRow tableRowTwo = table.createRow();
//		            
//		             //ustawianie szerokosci kolumny 
//		             for(int i=0;i<5;i++){
//		            	 c=tableRowTwo.getCell(i);
//		            	 c.getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(1000));
//		             }
//		             
//		             for(int i=0;i<5;i++){
//		            	 run= tableRowTwo.getCell(i).addParagraph().createRun();
//			             run.setBold(true);
//			             run.setFontSize(12);
//			             run.setText("       " +par[j].ilosc_par[i]+"      ");
//		             }
//		            
//		             run = tableRowTwo.getCell(5).addParagraph().createRun();
//		             run.setBold(true);
//		             run.setFontSize(12);
//		             run.setText("       " +buty[j].iloscPar);
//		             
//		           
		             XWPFParagraph para3=doc.createParagraph();
		             
		             XWPFRun paraRun10=para3.createRun();
	        			paraRun10.setBold(true);
	        			paraRun10.setFontSize(10);
	        			XWPFRun paraRun11=para3.createRun();
	        			paraRun11.setBold(true);
	        			paraRun11.setFontSize(10);
	        			XWPFRun paraRun12=para3.createRun();
	        			paraRun12.setBold(false);
	        			XWPFRun paraRun13=para3.createRun();
	        			paraRun13.setBold(true);
	        			paraRun13.setFontSize(10);
	        			
	        			Okienko.drukujAdresOdbiorcyZbiorowo(paraRun10,Okienko.numerAdresuOdbiorcy);     //  1 - adres polski  2- adres rosyjski!!!!
	        			
	        			Okienko.drukujAdresNadawcyZbiorowo(paraRun11,paraRun12,paraRun13,Okienko.numerAdresuOdbiorcy);      //  1 - adres polski  2- adres rosyjski!!!!
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
				} 
				
				long stop=System.currentTimeMillis();
				System.out.println("Czas wykonania:"+(stop-start));
				
			}
		
	
		

	
}