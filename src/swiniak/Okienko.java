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


public class Okienko {

	static JFrame frmZamwienia;
	private JTextField textField;
	private JTextField textField_1;
	public static JPanel panel;
	//private JPanel Kozaki;
	static int iloscKozakow;
	static int iloscPolbutow;
	static int iloscSandalow;
	static int iloscBotkow;
	
	static int nrKlienta;
	static int wyborOdbiorcy;
	//static int iloscPar=10;
	static int iloscZamowien;
	static int  numerAdresuOdbiorcy;
	static String miesiac;
	static String rok;
	
	//private JTextField textField_2;
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
		frmZamwienia.setSize(1023, 748);
		frmZamwienia.getContentPane().setLayout(new CardLayout(0, 0));
		
		 panel = new JPanel();
		frmZamwienia.getContentPane().add(panel, "name_6144499937038");
		panel.setLayout(null);
		
		
		//pole z nr klienta
		textField = new JTextField();
		textField.setBounds(290, 82, 86, 20);
		panel.add(textField);
		textField.addActionListener(new ActionListener() {      //wybor nr klienta
			public void actionPerformed(ActionEvent e) {
				String textFieldValue = textField.getText();
				nrKlienta = Integer.parseInt(textFieldValue);
				System.out.println(nrKlienta);
				
			}
		});
		textField.setColumns(10);
		
		JLabel lblPodajNrKlienta = new JLabel("nr. Klienta:");
		lblPodajNrKlienta.setBounds(168, 44, 149, 92);
		panel.add(lblPodajNrKlienta);
		lblPodajNrKlienta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodajNrKlienta.setBackground(Color.WHITE);
		lblPodajNrKlienta.setForeground(Color.BLACK);
		lblPodajNrKlienta.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JLabel lblPodajIloZamwie = new JLabel("Ilość zamówień:");
		lblPodajIloZamwie.setBounds(458, 59, 190, 62);
		panel.add(lblPodajIloZamwie);
		lblPodajIloZamwie.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPodajIloZamwie.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblAdresOdbiorcy = new JLabel("Adres odbiorcy:");
		lblAdresOdbiorcy.setBounds(301, 172, 169, 42);
		panel.add(lblAdresOdbiorcy);
		lblAdresOdbiorcy.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblAdresOdbiorcy.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		//pole z iloscia zamowien
		
        JComboBox Ilezamowien = new JComboBox();
		
        Ilezamowien.setBounds(623, 82, 86, 20);
		panel.add(Ilezamowien);
		Ilezamowien.addActionListener(new ActionListener() {
			
			//wybor ilosci kozakow!!
			public void actionPerformed(ActionEvent e) {
				
			     iloscZamowien = Integer.parseInt((String)Ilezamowien.getSelectedItem());
				
			}
		});
		Ilezamowien.setFont(new Font("Times New Roman", Font.BOLD, 12));
		Ilezamowien.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"}));
		Ilezamowien.setMaximumRowCount(30);
		
//		
//		textField_1 = new JTextField();
//		textField_1.setBounds(623, 82, 86, 20);
//		panel.add(textField_1);
//		textField_1.addActionListener(new ActionListener() {      //wybor ilosci zamowien
//			public void actionPerformed(ActionEvent e) {
//				String textFieldValue = textField_1.getText();
//				iloscZamowien = Integer.parseInt(textFieldValue);
//				System.out.println(iloscZamowien);
//			}
//		});
//		textField_1.setColumns(10);
		
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(470, 185, 106, 20);
		panel.add(comboBox);
		
		//wybor adresu odbiorcy
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String polski="Polski\t";
				String rosyjski="Rosyjski";
				
				 JComboBox cb = (JComboBox)e.getSource();
			     String adresOdbiorcy = (String)cb.getSelectedItem();
			    System.out.println(adresOdbiorcy);
			     if(polski==adresOdbiorcy){
			    	 numerAdresuOdbiorcy=1;
			     }
			     else
			    	 numerAdresuOdbiorcy=2;
			     for(int i=0;i<50;i++){
			    	 System.out.println(i);
			     }
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kliknij mnie", "Polski\t", "Rosyjski"}));
		comboBox.setMaximumRowCount(3);
		
		JLabel lblPoWpisaniuNacinij = new JLabel("Po wpisaniu naciśnij enter");
		lblPoWpisaniuNacinij.setBounds(277, 107, 169, 14);
		panel.add(lblPoWpisaniuNacinij);
		
		JLabel lblKozak = new JLabel("Kozak:");
		lblKozak.setBounds(221, 296, 86, 62);
		panel.add(lblKozak);
		lblKozak.setHorizontalAlignment(SwingConstants.CENTER);
		lblKozak.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JLabel lblPodajIloButw = new JLabel("Podaj ilość butów:");
		lblPodajIloButw.setBounds(366, 258, 210, 27);
		panel.add(lblPodajIloButw);
		lblPodajIloButw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPodajIloButw.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JLabel lblPbut = new JLabel("Półbut:");
		lblPbut.setBounds(540, 296, 104, 62);
		panel.add(lblPbut);
		lblPbut.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setBounds(317, 320, 79, 27);
		panel.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			
			//wybor ilosci kozakow!!
			public void actionPerformed(ActionEvent e) {
				 JComboBox cb = (JComboBox)e.getSource();
			     iloscKozakow = Integer.parseInt((String)cb.getSelectedItem());
				
			}
		});
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		comboBox_1.setMaximumRowCount(23);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(630, 319, 79, 27);
		panel.add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //wybor ilosci polbutow
				
			     iloscPolbutow = Integer.parseInt((String)comboBox_2.getSelectedItem());
				
			}
		});
		comboBox_2.setMaximumRowCount(23);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		
		JLabel lblSanda = new JLabel("Sandał:");
		lblSanda.setBounds(221, 390, 96, 27);
		panel.add(lblSanda);
		lblSanda.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(317, 395, 79, 27);
		panel.add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {  //wybor ilosci sandalow
			public void actionPerformed(ActionEvent e) {
				
			     iloscSandalow = Integer.parseInt((String)comboBox_3.getSelectedItem());
			    
			}
		});
		comboBox_3.setMaximumRowCount(16);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(630, 395, 79, 27);
		panel.add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {  //wybor ilosci botkow
			public void actionPerformed(ActionEvent e) {
				
				
			     iloscBotkow = Integer.parseInt((String)comboBox_4.getSelectedItem());
			     
			}
		});
		comboBox_4.setMaximumRowCount(16);
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"}));
		
		JLabel lblBotek = new JLabel("Botek:");
		lblBotek.setBounds(540, 395, 79, 27);
		panel.add(lblBotek);
		lblBotek.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		//przycisk dalej!!!
		
		JButton btnDalej = new JButton("DALEJ");
		btnDalej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KozakPanel kp=new KozakPanel();
				
				
				panel.setVisible(false);
				KozakPanel.Kozaki.setVisible(true);
			}
		});
		btnDalej.setBounds(342, 512, 287, 104);
		panel.add(btnDalej);
		
		
		
		
		//tu wklej konstruktor kozakPanel!!!
		
	 // KozakPanel kp=new KozakPanel();
		
		JPanel Botki = new JPanel();
		frmZamwienia.getContentPane().add(Botki, "name_9045229721348");
		
	
		
		JPanel panel_1 = new JPanel();
		Botki.add(panel_1);
		
		
		JPanel Sandały = new JPanel();
		frmZamwienia.getContentPane().add(Sandały, "name_9047311224519");
		Sandały.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 1013, 682);
		Sandały.add(panel_3);
		
		JPanel Półbuty = new JPanel();
		frmZamwienia.getContentPane().add(Półbuty, "name_9048742887032");
		Półbuty.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1013, 682);
		Półbuty.add(panel_2);
		//panel_1.add(scrollPane);
		
		
		
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
	
	static void drukujAdresNadawcy(XWPFRun adres,XWPFRun adres2,XWPFRun adres3, int wyborOdbiorcy){
		
		
		
		if(wyborOdbiorcy==1){
			adres.setText("Nr UNN: 590693078");
			adres.addBreak();
		}
		
		
        adres.setText("Дата выпуска: ");
        
		adres2.setText(miesiac+"."+rok+"     ");
		//adres.setBold(true);
		adres3.setText("Изготовитель: Firma „EXCEL”");
		adres3.addBreak();
		adres3.setText("Товар серцифицирован          Zenon Świniarski            ");
		adres3.addBreak();
		adres3.setText("ТПроизведено в  Польше          Stary Kadłubek 45");
		adres3.addBreak();
		adres3.setText("                                                     26-806 Stara Błotnica");
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
