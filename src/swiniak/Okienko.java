package swiniak;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


import org.apache.poi.xwpf.usermodel.XWPFRun;
import java.awt.Font;
import javax.swing.JTextField;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.border.LineBorder;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;


public class Okienko {

	static JFrame frmZamwienia;
	private JTextField textField;
	public static JPanel panel;

	static int iloscKozakow=0;
	static int iloscPolbutow=0;
	static int iloscSandalow=0;
	static int iloscBotkow=0;
	
	static int nrKlienta;
	static int wyborOdbiorcy;
	static int iloscZamowien;
	static int  numerAdresuOdbiorcy;
	
	static String miesiac;
	static String rok;
	

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws InvalidFormatException 
	 */
	public static void main(String[] args) throws InvalidFormatException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Okienko window = new Okienko();
					window.frmZamwienia.setVisible(true);
                    //window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    window.frmZamwienia.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	

	}


	
	/**
	 * Create the application.
	 */
	public Okienko() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZamwienia = new JFrame();
		frmZamwienia.setTitle("Zamówienia");
		frmZamwienia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZamwienia.setSize(713, 612);
		frmZamwienia.getContentPane().setLayout(new CardLayout(0, 0));
		
		 panel = new JPanel();
		 panel.setBackground(SystemColor.text);
		 panel.setForeground(Color.WHITE);
		frmZamwienia.getContentPane().add(panel, "name_6144499937038");
		panel.setLayout(null);
		
		
		
		//pole z nr klienta
		textField = new JTextField();
		textField.setBounds(115, 66, 117, 29);
		panel.add(textField);
		textField.addActionListener(new ActionListener() {      //wybor nr klienta
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textField.getText();
				nrKlienta = Integer.parseInt(textFieldValue);
				
				
			}
		});
		textField.setColumns(10);
		
		JLabel lblAdresOdbiorcy = new JLabel("ADRES");
		lblAdresOdbiorcy.setBounds(407, 28, 169, 27);
		panel.add(lblAdresOdbiorcy);
		lblAdresOdbiorcy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAdresOdbiorcy.setHorizontalAlignment(SwingConstants.CENTER);
		

		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.textHighlightText);
		comboBox.setBounds(435, 66, 128, 29);
		panel.add(comboBox);
		
		//wybor adresu odbiorcy
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String polski="Ola\t";
			    String adresOdbiorcy = (String)comboBox.getSelectedItem();
			    
			     
			    if(polski==adresOdbiorcy){
			    	 numerAdresuOdbiorcy=1;
			     }
			     else
			    	 numerAdresuOdbiorcy=2;
			    
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kliknij mnie", "Ola\t", "Andrzej"}));
		comboBox.setMaximumRowCount(3);
		
		JLabel lblPoWpisaniuNacinij = new JLabel("Po wpisaniu naciśnij enter");
		lblPoWpisaniuNacinij.setBounds(104, 94, 169, 14);
		panel.add(lblPoWpisaniuNacinij);
		
		JLabel lblKozak = new JLabel("Kozak:");
		lblKozak.setBounds(63, 217, 86, 62);
		panel.add(lblKozak);
		lblKozak.setHorizontalAlignment(SwingConstants.CENTER);
		lblKozak.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblPodajIloButw = new JLabel("ILOŚĆ ZAMÓWIEŃ");
		lblPodajIloButw.setBounds(113, 153, 417, 39);
		panel.add(lblPodajIloButw);
		lblPodajIloButw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodajIloButw.setFont(new Font("Times New Roman", Font.BOLD, 33));
		
		JLabel lblPbut = new JLabel("Półbut:");
		lblPbut.setBounds(350, 217, 104, 62);
		panel.add(lblPbut);
		lblPbut.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBackground(SystemColor.textHighlightText);
		
		comboBox_1.setBounds(159, 238, 103, 27);
		panel.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			
			//wybor ilosci kozakow!!
			public void actionPerformed(ActionEvent e) {
				
			     iloscKozakow = Integer.parseInt((String)comboBox_1.getSelectedItem());
				
			}
		});
		//comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29","30" ,"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45" ,"46"}));
		comboBox_1.setMaximumRowCount(23);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBackground(SystemColor.textHighlightText);
		comboBox_2.setBounds(448, 238, 104, 27);
		panel.add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //wybor ilosci polbutow
				
			     iloscPolbutow = Integer.parseInt((String)comboBox_2.getSelectedItem());
				
			}
		});
		comboBox_2.setMaximumRowCount(23);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29","30" ,"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45" ,"46"}));
		
		JLabel lblSanda = new JLabel("Sandał:");
		lblSanda.setBounds(63, 290, 94, 27);
		panel.add(lblSanda);
		lblSanda.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(159, 293, 103, 27);
		panel.add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {  //wybor ilosci sandalow
			public void actionPerformed(ActionEvent e) {
				
			     iloscSandalow = Integer.parseInt((String)comboBox_3.getSelectedItem());
			    
			}
		});
		comboBox_3.setMaximumRowCount(16);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29","30" ,"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45" ,"46"}));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_4.setBackground(SystemColor.textHighlightText);
		comboBox_4.setBounds(448, 293, 104, 27);
		panel.add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {  //wybor ilosci botkow
			public void actionPerformed(ActionEvent e) {
				
				
			     iloscBotkow = Integer.parseInt((String)comboBox_4.getSelectedItem());
			     
			}
		});
		comboBox_4.setMaximumRowCount(16);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29","30" ,"31","32","33","34","35","36","37","38","39","40","41","42","43","44","45" ,"46"}));
		
		JLabel lblBotek = new JLabel("Botek:");
		lblBotek.setBounds(360, 290, 79, 27);
		panel.add(lblBotek);
		lblBotek.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		//przycisk dalej!!!
		
		JButton btnDalej = new JButton("DALEJ");
		btnDalej.setForeground(new Color(0, 0, 0));
		btnDalej.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnDalej.setBackground(SystemColor.control);
		btnDalej.setBounds(194, 420, 287, 104);
		panel.add(btnDalej);
		
		JLabel lblPodajNrKlienta = new JLabel("NUMER KLIENTA");
		lblPodajNrKlienta.setBounds(88, 33, 169, 22);
		panel.add(lblPodajNrKlienta);
		lblPodajNrKlienta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodajNrKlienta.setBackground(Color.WHITE);
		lblPodajNrKlienta.setForeground(Color.BLACK);
		lblPodajNrKlienta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		//panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{textField, lblPodajNrKlienta, lblAdresOdbiorcy, comboBox, lblPoWpisaniuNacinij, lblKozak, lblPodajIloButw, lblPbut, comboBox_1, comboBox_2, lblSanda, comboBox_3, comboBox_4, lblBotek, btnDalej}));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.textHighlightText);
		panel_1.setBounds(10, 11, 677, 551);
		panel.add(panel_1);
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iloscZamowien=iloscKozakow+iloscPolbutow+iloscSandalow+iloscBotkow;
				if(iloscKozakow==0){
					if(iloscPolbutow==0){
						if(iloscSandalow==0){
							BotekPanel bp=new BotekPanel();
							panel.setVisible(false);
							//BotekPanel.Botki.setVisible(true);
						}
						else{
							SandalPanel sp=new SandalPanel();
							panel.setVisible(false);
							SandalPanel.Sandaly.setVisible(true);
						}
	              
						
					}
					else{
						PolbutPanel pp=new PolbutPanel();
						panel.setVisible(false);
						PolbutPanel.Polbuty.setVisible(true);
					}
					
				}
				else{
					KozakPanel kp=new KozakPanel();
					
					panel.setVisible(false);
					KozakPanel.Kozaki.setVisible(true);
				}
				
			}
		});
		
		
		
		
	}
	
	static void drukujAdresOdbiorcy(XWPFRun adres,int wybor){
		if(wybor==1){
			adres.setText(Adres.Text1);
			adres.addBreak();
			adres.setText(Adres.Text2);
			adres.addBreak();
			adres.setText(Adres.Text3);
			adres.addBreak();
		}
		else{
			adres.setText(Adres.Text1);
			adres.addBreak();
			adres.setText(Adres.Text4);
			adres.addBreak();
			adres.setText(Adres.Text5);
			adres.addBreak();
		}
	}
	
	static void drukujAdresOdbiorcyZbiorowo(XWPFRun adres,int wybor){
		if(wybor==1){
			adres.setFontSize(10);
			adres.setText("Импортёр: : Dmitrij Anatoljewicz Bildiuk Adres prawny: ul. Kleckowa 32-17, 230-000");
			adres.addBreak();
			adres.setText("Grodno, Białoruś Nr UNN: 590693078");
			adres.addBreak();
		}
		else{
			adres.setFontSize(11);
			adres.setText("Импортёр: ");
			adres.setText("Сиднева Юлия Анатольевна индевидуальный предпринематель");
			adres.addBreak();
			adres.setText("230026 Гродно ул.Пестрака 48-14 УНП590687176");
			adres.addBreak();
		}
	}
	
	static void drukujAdresNadawcyZbiorowo(XWPFRun adres,XWPFRun adres2,XWPFRun adres3, int wyborOdbiorcy){
		
		
		
//		if(wyborOdbiorcy==1){
//			adres.setText("Nr UNN: 590693078");
//			adres.addBreak();
//		}
		
		adres.setFontSize(11);
        adres.setText("Дата выпуска: ");
        adres2.setFontSize(11);
		adres2.setText(miesiac+"."+rok+"     ");
		//adres.setBold(true);
		adres3.setFontSize(11);
		adres3.setText("                Изготовитель: FIRMA „EXCEL”");
		adres3.addBreak();
		adres3.setText("Товар серцифицирован                       Zenon Świniarski            ");
		adres3.addBreak();
		adres3.setText("ТПроизведено в  Польше                    Stary Kadłubek 45");
		adres3.addBreak();
		adres3.setText("                                                                    26-806 Stara Błotnica");
		adres3.addBreak();
		adres3.setText("                                                                  e-mail: excel69@wp.pl");
		
	}
	
static void drukujAdresNadawcy(XWPFRun adres,XWPFRun adres2,XWPFRun adres3, int wyborOdbiorcy){
		
		
		
	if(wyborOdbiorcy==1){
		adres.setText("Nr UNN: 590693078");
		adres.addBreak();
	}

        adres.setText("Дата выпуска: ");
        
		adres2.setText(miesiac+"."+rok+"     ");
		//adres.setBold(true);
		adres3.setText("   Изготовитель: Firma „EXCEL”");
		adres3.addBreak();
		adres3.setText("Товар серцифицирован               Zenon Świniarski            ");
		adres3.addBreak();
		adres3.setText("ТПроизведено в  Польше           Stary Kadłubek 45");
		adres3.addBreak();
		adres3.setText("                                                           26-806 Stara Błotnica");
		adres3.addBreak();
	}
	
	static void pobierzDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
		Calendar calendar = Calendar.getInstance();
		 miesiac=dateFormat.format(calendar.getTime());
		
		 SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
		 rok=dateFormat2.format(calendar.getTime());
	}
}
