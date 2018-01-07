package swiniak;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;


public class KozakPanel {
	int i;
	boolean czy_usuwanie = false;
	// private int poczatkowa_ilosc_zamowien=Okienko.iloscBotkow;
	int poczatkowa_ilosc_2 = Okienko.iloscBotkow - 24;
	private static int y = 69;
	private static int k = 0;
	private static int sztuka = 1;
	public static JPanel Kozaki = new JPanel();
	public static JPanel Kozaki2 = new JPanel();

	public static String[] TabModelKozaka = new String[50];
	public static String[] TabModelKozaka2 = new String[50];
	public static String[] TabKolorKozaka = new String[50];
	public static String[] TabMaterialKozaka = new String[50];
	public static String[] TabMaterialPodszewkiKozaka = new String[50];
	public static int[] TabParyKozaka = new int[50];

	@SuppressWarnings("rawtypes")
	JComboBox[] model2 = new JComboBox[50];
	JComboBox[] model3 = new JComboBox[50];
	JComboBox[] materialCombo = new JComboBox[50];
	JComboBox[] materialPoszewki = new JComboBox[50];
	JComboBox[] iloscPar = new JComboBox[50];
	JComboBox[] kolor = new JComboBox[50];

	public void delete() {
		i = 0;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public KozakPanel() {

		Kozaki.setBackground(SystemColor.text);
		Kozaki2.setBackground(SystemColor.text);

		if (Okienko.iloscSandalow == 0 && Okienko.iloscPolbutow == 0 && Okienko.iloscBotkow == 0) {

			if (Okienko.iloscKozakow != 0) {
				;

			} else {
				JLabel lblModel2 = new JLabel("Podaj poprawną ilość zamówień. Uruchom jeszcze raz. ");
				lblModel2.setFont(new Font("Tahoma", Font.PLAIN, 22));
				lblModel2.setBounds(200, 100, 550, 100);
				Kozaki.add(lblModel2);
			}

		}

		if (Okienko.iloscKozakow < 24) {
			if (Okienko.iloscSandalow != 0 || Okienko.iloscPolbutow != 0 || Okienko.iloscBotkow != 0) {
				JButton btnDalej2 = new JButton("DALEJ");
				btnDalej2.setBounds(544, 0, 150, 53);
				btnDalej2.setFont(new Font("Tahoma", Font.PLAIN, 18));
				btnDalej2.setBackground(SystemColor.control);
				btnDalej2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						if (Okienko.iloscPolbutow == 0) {
							if (Okienko.iloscSandalow == 0) {
								BotekPanel bp = new BotekPanel();
								Kozaki.setVisible(false);
								// BotekPanel.Botki.setVisible(true);
							} else {
								SandalPanel sp = new SandalPanel();
								Kozaki.setVisible(false);
								SandalPanel.Sandaly.setVisible(true);
							}

						} else {
							PolbutPanel pp = new PolbutPanel();
							Kozaki.setVisible(false);
							PolbutPanel.Polbuty.setVisible(true);
						}

					}
				});

				Kozaki.add(btnDalej2);
			}
		}

		if (Okienko.iloscKozakow < 24) {
			JButton btnNewButton2 = new JButton("DODAJ");
			btnNewButton2.setBounds(100, 651, 140, 57);
			btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton2.setBackground(SystemColor.control);

			Kozaki.add(btnNewButton2);

			btnNewButton2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					System.out.println("ilosc kozakow: " + Okienko.iloscKozakow);
					if (Okienko.iloscKozakow < 23) {
						Okienko.iloscKozakow++;
						Okienko.iloscZamowien++;
						KozakPanel b = new KozakPanel(Okienko.iloscKozakow - 1, Kozaki);
						Okienko.panel.setVisible(false);
						Kozaki.setVisible(true);
					} else
						;

				}
			});

			JButton btnNewButton3 = new JButton("USUŃ"); /////// USUWANIEEEEEEEEEEEEEEE
															/////// NA
															/////// STRONIE
															/////// 1
			btnNewButton3.setBounds(241, 651, 140, 57);
			btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton3.setBackground(SystemColor.control);

			Kozaki.add(btnNewButton3);

			btnNewButton3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					czy_usuwanie = true;
					Okienko.iloscKozakow--;
					Okienko.iloscZamowien--;

					KozakPanel b4 = new KozakPanel(true, Kozaki);
					Okienko.panel.setVisible(false);
					Kozaki.setVisible(true);
				}
			});

		} else {

			JButton btnNewButton4 = new JButton("COFNIJ");
			btnNewButton4.setBounds(844, 651, 140, 57);
			btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton4.setBackground(SystemColor.control);

			Kozaki2.add(btnNewButton4);

			btnNewButton4.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					Kozaki.setVisible(true);

					Kozaki2.setVisible(false);

				}
			});

			// DODAWANIE NA STRONIE 2
			JButton btnNewButton2 = new JButton("DODAJ");
			btnNewButton2.setBounds(100, 651, 140, 57);
			btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton2.setBackground(SystemColor.control);

			Kozaki2.add(btnNewButton2);

			btnNewButton2.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					if (Okienko.iloscKozakow < 46) {
						Okienko.iloscKozakow++;
						Okienko.iloscZamowien++;
						KozakPanel b = new KozakPanel(Okienko.iloscKozakow - 1, Kozaki2);
						Okienko.panel.setVisible(false);
						Kozaki2.setVisible(true);
					} else
						;

				}
			});

			JButton btnNewButton3 = new JButton("USUN"); /////// USUWANIEEEEEEEEEEEEEEE
															/////// NA
															/////// STRONIE
															/////// 2
			btnNewButton3.setBounds(241, 651, 140, 57);
			btnNewButton3.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton3.setBackground(SystemColor.control);

			Kozaki2.add(btnNewButton3);

			btnNewButton3.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					czy_usuwanie = true;
					Okienko.iloscKozakow--;
					Okienko.iloscZamowien--;

					KozakPanel b4 = new KozakPanel(true, Kozaki2);
					Okienko.panel.setVisible(false);
					Kozaki2.setVisible(true);
				}
			});

		}

		if (Okienko.iloscKozakow < 24) {
			JButton btnNewButton = new JButton("DRUKUJ");
			btnNewButton.setBounds(544, 0, 150, 53);
			btnNewButton.setBackground(SystemColor.control);
			btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

			Kozaki.add(btnNewButton);

			btnNewButton.addActionListener(new ActionListener() { // PRZYCISK
																	// DRUKOWANIA

				public void actionPerformed(ActionEvent e) {
					Drukuj d1 = new Drukuj();
					try {
						Drukuj_Zbiorowe d2 = new Drukuj_Zbiorowe();
					} catch (InvalidFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					;
					JOptionPane.showMessageDialog(Kozaki,
							"Plik" + " etykieta-jednostkowa-" + Okienko.nrKlienta + ".doc został poprawnie utworzony.\n"
									+ "Plik" + " etykieta-zbiorowa-" + Okienko.nrKlienta
									+ ".doc został poprawnie utworzony.");
					System.exit(0);
				}
			});
		}

		if (Okienko.iloscKozakow > 23) {
			JButton btnNewButton4 = new JButton("DALEJ");
			btnNewButton4.setBounds(844, 651, 140, 57);
			btnNewButton4.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnNewButton4.setBackground(SystemColor.control);

			Kozaki.add(btnNewButton4);

			btnNewButton4.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					JLabel lblBotki = new JLabel("KOZAKI");
					lblBotki.setHorizontalAlignment(SwingConstants.CENTER);
					lblBotki.setFont(new Font("Times New Roman", Font.BOLD, 38));
					lblBotki.setBounds(360, 14, 186, 30);
					Kozaki2.add(lblBotki);

					y = 69 + ((Okienko.iloscKozakow - 23) * 25);

					Kozaki.setVisible(false);
					Kozaki2.setLayout(null);

					Okienko.frmZamwienia.getContentPane().add(Kozaki2, "name_6316592025561");
					Kozaki2.setVisible(true);

					if (Okienko.iloscSandalow != 0 || Okienko.iloscPolbutow != 0 || Okienko.iloscBotkow != 0) {
						JButton btnDalej2 = new JButton("DALEJ");
						btnDalej2.setBounds(544, 0, 150, 53);
						btnDalej2.setFont(new Font("Tahoma", Font.PLAIN, 18));
						btnDalej2.setBackground(SystemColor.control);
						btnDalej2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {

								if (Okienko.iloscPolbutow == 0) {
									if (Okienko.iloscSandalow == 0) {
										BotekPanel bp = new BotekPanel();
										Kozaki.setVisible(false);
										Kozaki2.setVisible(false);
										// BotekPanel.Botki.setVisible(true);
									} else {
										SandalPanel sp = new SandalPanel();
										Kozaki.setVisible(false);
										Kozaki2.setVisible(false);

										SandalPanel.Sandaly.setVisible(true);
									}

								} else {
									PolbutPanel pp = new PolbutPanel();
									Kozaki.setVisible(false);
									Kozaki2.setVisible(false);

									PolbutPanel.Polbuty.setVisible(true);
								}

							}
						});

						Kozaki2.add(btnDalej2);
					} else {
						JButton btnNewButton = new JButton("DRUKUJ");
						btnNewButton.setBounds(544, 0, 150, 53);
						btnNewButton.setBackground(SystemColor.control);
						btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));

						Kozaki2.add(btnNewButton);

						btnNewButton.addActionListener(new ActionListener() { // PRZYCISK
																				// DRUKOWANIA

							public void actionPerformed(ActionEvent e) {
								Drukuj d1 = new Drukuj();
								try {
									Drukuj_Zbiorowe d2 = new Drukuj_Zbiorowe();
								} catch (InvalidFormatException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								;
								JOptionPane.showMessageDialog(Kozaki2,
										"Plik" + " etykieta-jednostkowa-" + Okienko.nrKlienta
												+ ".doc został poprawnie utworzony.\n" + "Plik" + " etykieta-zbiorowa-"
												+ Okienko.nrKlienta + ".doc został poprawnie utworzony.");
								System.exit(0);
							}
						});
					}
				}
			});

		}

		Okienko.frmZamwienia.setBounds(0, 0, 1070, 760);
		Okienko.frmZamwienia.add(Kozaki);

		JLabel lblKozaki = new JLabel("KOZAKI");
		lblKozaki.setHorizontalAlignment(SwingConstants.CENTER);
		lblKozaki.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblKozaki.setBounds(360, 14, 186, 30);
		Kozaki.add(lblKozaki);

		Kozaki.setLayout(null);
		delete();

		for (int i = 0; i < 50; i++) {

			TabModelKozaka[i] = "null";
		}
		for (int i = 0; i < 50; i++) {
			TabModelKozaka2[i] = "null";
		}

		for (int i = 0; i < 50; i++) {
			TabKolorKozaka[i] = "czarny";
		}
		for (int i = 0; i < 50; i++) {
			TabMaterialKozaka[i] = "Welur\t";
		}
		for (int i = 0; i < 50; i++) {
			TabMaterialPodszewkiKozaka[i] = "Misiek";
		}
		for (int i = 0; i < 50; i++) {
			TabParyKozaka[i] = 8;
		}

		int sztuka = 1;

		i = 0;
		if (Okienko.iloscKozakow > 23) {
			for (; i < 23; i++, y += 25) {

				wypiszDane(i, y, Kozaki);

			}
			for (int i = 23, y = 69; i < Okienko.iloscKozakow; i++, y += 25) {
				wypiszDane(i, y, Kozaki2);
			}
		} else {
			for (; k < Okienko.iloscKozakow; k++, y += 25) {

				wypiszDane(k, y, Kozaki);
			}
		}

		for (int i = 0; i < Okienko.iloscKozakow; i++) {

			model2[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {
						String str = (String) model2[i].getSelectedItem();
						KozakPanel.TabModelKozaka[i] = str;
					}

				}

			});

			model3[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {
						String str2 = (String) model3[i].getSelectedItem();
						KozakPanel.TabModelKozaka2[i] = str2;
					}
				}

			});

			materialCombo[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {
						String str = (String) materialCombo[i].getSelectedItem();
						KozakPanel.TabMaterialKozaka[i] = str;
					}
				}
			});

			materialPoszewki[i].addActionListener(new ActionListener() {

				// wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {
						String str2 = (String) materialPoszewki[i].getSelectedItem();
						KozakPanel.TabMaterialPodszewkiKozaka[i] = str2;
					}

				}
			});

			iloscPar[i].addActionListener(new ActionListener() {

				// wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {

						int pary = Integer.parseInt((String) iloscPar[i].getSelectedItem());
						KozakPanel.TabParyKozaka[i] = pary;

					}

				}
			});

			kolor[i].addActionListener(new ActionListener() {

				// wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {

					for (int i = 0; i < Okienko.iloscKozakow; i++) {
						String str2 = (String) kolor[i].getSelectedItem();
						KozakPanel.TabKolorKozaka[i] = str2;

					}

				}
			});
		}

	}
	//kostruktor dodowania
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public KozakPanel(int i, JPanel Botki) {
	

		//wypiszDane(i,255,Botki);
		sztuka=Okienko.iloscKozakow;
		
		String dupa;
		dupa=Integer.toString(sztuka);
		dupa+=" - ";
		
		JLabel ilosc=new JLabel(dupa);
		ilosc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ilosc.setBounds(5, y, 66, 18);
		Botki.add(ilosc);
		sztuka++;
		
		JLabel lblModel = new JLabel("MODEL: ");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModel.setBounds(35, y, 66, 18);
		Botki.add(lblModel);
        
		model2[i] = new JComboBox();
		model2[i].setBounds(87, y, 64, 20);
		model2[i].setModel(new DefaultComboBoxModel(new String[] { "001", "002", "003", "004", "005", "006", "007",
				"008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022",
				"023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037",
				"038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052",
				"053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063", "064", "065", "066", "067",
				"068", "069", "070", "071", "072", "073", "074", "075", "076", "077", "078", "079", "080", "081", "082",
				"083", "084", "085", "086", "087", "088", "089", "091", "092", "093", "094", "095", "096", "097", "098",
				"099", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113",
				"114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128",
				"129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143",
				"144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158",
				"159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173",
				"174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188",
				"189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203",
				"204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218",
				"219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "234",
				"235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249",
				"250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264",
				"265", "266", "267", "268", "269", "270", "271", "272", "273", "273", "275", "276", "277", "278", "279",
				"280", "281", "282", "283", "283", "285", "286", "287", "288", "289", "290", "291", "291", "293", "294",
				"295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309",
				"310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324",
				"325", "326", "327", "328", "329", "330", "331", "332", "334", "335", "335", "336", "337", "338", "339",
				"340", "341", "342", "343", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "356",
				"357", "358", "359", "360", "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371",
				"372", "372", "374", "375", "376", "377", "378", "379", "380", "381", "382", "383", "384", "385", "386",
				"387", "388", "389", "390", "391", "392", "393", "394", "395", "396", "396", "397", "398", "399", "400",
				"401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415",
				"416", "417", "418", "419", "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430",
				"431", "432", "433", "434", "435", "436", "437", "438", "439", "440", "441", "442", "443", "444", "445",
				"446", "447", "448", "449", "450", "451", "452", "453", "454", "455", "456", "457", "458", "459", "460",
				"461", "462", "463", "464", "465", "466", "467", "468", "469", "470", "471", "472", "473", "474", "475",
				"476", "477", "478", "479", "480", "481", "482", "483", "484", "485", "486", "487", "488", "489", "491",
				"492", "493", "494", "495", "496", "497", "498", "499", "500", "501", "502", "503", "504", "504", "506",
				"507", "508", "509", "510", "511", "512", "513", "514", "515", "516", "517", "518", "519", "520", "521",
				"522", "523", "524", "525", "526", "527", "528", "529", "530", "531", "532", "533", "534", "535", "536",
				"537", "538", "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549", "550", "551",
				"552", "553", "554", "555", "556", "557", "558", "559", "560", "561", "562", "563", "564", "565", "566",
				"567", "568", "569", "570", "571", "572", "573", "574", "575", "576", "577", "578", "579", "580", "581",
				"582", "583", "584", "585", "586", "587", "588", "589", "591", "592", "593", "594", "595", "596", "597",
				"598", "599", "600", "601", "602", "603", "604", "605", "606", "607", "608", "609", "610", "611", "612",
				"613", "614", "615", "616", "617", "618", "619", "620", "621", "622", "623", "624", "625", "626", "627",
				"628", "629", "630", "631", "632", "633", "634", "635", "636", "637", "638", "639", "640", "641", "642",
				"643", "644", "645", "646", "647", "648", "649", "650", "651", "652", "653", "654", "655", "656", "657",
				"658", "659", "660", "661", "662", "663", "664", "665", "666", "667", "668", "669", "670", "671", "672",
				"673", "674", "675", "676", "677", "678", "679", "680", "681", "682", "683", "684", "685", "686", "687",
				"688", "689", "691", "692", "693", "694", "695", "696", "697", "698", "699", "700", "701", "702", "703",
				"704", "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715", "716", "717", "718",
				"719", "720", "721", "722", "723", "724", "725", "726", "727", "728", "729", "730", "731", "732", "733",
				"734", "735", "736", "737", "738", "739", "740", "741", "742", "743", "744", "745", "746", "747", "748",
				"749", "750", "751", "752", "753", "754", "755", "756", "757", "758", "759", "760", "761", "762", "763",
				"764", "765", "766", "767", "768", "769", "770", "771", "772", "773", "774", "775", "776", "777", "778",
				"779", "780", "781", "782", "783", "784", "785", "786", "787", "788", "789", "791", "792", "793", "794",
				"795", "796", "797", "798", "799", "800", "801", "802", "803", "804", "805", "806", "807", "808", "809",
				"810", "811", "812", "813", "814", "815", "816", "817", "818", "819", "820", "821", "822", "823", "824",
				"825", "826", "827", "828", "829", "830", "831", "832", "833", "834", "835", "836", "837", "838", "839",
				"840", "841", "842", "843", "844", "845", "846", "847", "848", "849", "850", "851", "852", "853", "854",
				"855", "856", "857", "858", "859", "860", "861", "862", "863", "864", "865", "866", "867", "868", "869",
				"870", "871", "872", "873", "874", "875", "876", "877", "878", "879", "880", "881", "882", "883", "884",
				"885", "886", "887", "888", "889", "891", "892", "893", "894", "895", "896", "897", "898", "899", "900",
				"901", "902", "903", "904", "905", "906", "907", "908", "909", "910", "911", "912", "913", "914", "915",
				"916", "917", "918", "919", "920", "921", "922", "923", "924", "925", "926", "927", "928", "929", "930",
				"931", "932", "933", "934", "935", "936", "937", "938", "939", "940", "941", "942", "943", "944", "945",
				"946", "947", "948", "949", "950", "951", "952", "953", "954", "955", "956", "957", "958", "959", "960",
				"961", "962", "963", "964", "965", "966", "967", "968", "969", "970", "971", "972", "973", "974", "975",
				"976", "977", "978", "979", "980", "981", "982", "983", "984", "985", "986", "987", "988", "989", "991",
				"992", "993", "994", "995", "996", "997", "998", "999" }));
		Botki.add(model2[i]);
		
		JLabel ukosnik = new JLabel(" | ");
		ukosnik.setFont(new Font("Tahoma", Font.BOLD, 13));
	      ukosnik.setBounds(150, y, 66, 18);
		Botki.add(ukosnik);

		model3[i] = new JComboBox();
		model3[i].setBounds(165, y, 64, 20);
		model3[i].setModel(new DefaultComboBoxModel(new String[] { "001", "002", "003", "004", "005", "006", "007",
				"008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022",
				"023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037",
				"038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052",
				"053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063", "064", "065", "066", "067",
				"068", "069", "070", "071", "072", "073", "074", "075", "076", "077", "078", "079", "080", "081", "082",
				"083", "084", "085", "086", "087", "088", "089", "091", "092", "093", "094", "095", "096", "097", "098",
				"099", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113",
				"114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128",
				"129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143",
				"144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158",
				"159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173",
				"174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188",
				"189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203",
				"204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218",
				"219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "234",
				"235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249",
				"250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264",
				"265", "266", "267", "268", "269", "270", "271", "272", "273", "273", "275", "276", "277", "278", "279",
				"280", "281", "282", "283", "283", "285", "286", "287", "288", "289", "290", "291", "291", "293", "294",
				"295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309",
				"310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324",
				"325", "326", "327", "328", "329", "330", "331", "332", "334", "335", "335", "336", "337", "338", "339",
				"340", "341", "342", "343", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "356",
				"357", "358", "359", "360", "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371",
				"372", "372", "374", "375", "376", "377", "378", "379", "380", "381", "382", "383", "384", "385", "386",
				"387", "388", "389", "390", "391", "392", "393", "394", "395", "396", "396", "397", "398", "399", "400",
				"401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415",
				"416", "417", "418", "419", "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430",
				"431", "432", "433", "434", "435", "436", "437", "438", "439", "440", "441", "442", "443", "444", "445",
				"446", "447", "448", "449", "450", "451", "452", "453", "454", "455", "456", "457", "458", "459", "460",
				"461", "462", "463", "464", "465", "466", "467", "468", "469", "470", "471", "472", "473", "474", "475",
				"476", "477", "478", "479", "480", "481", "482", "483", "484", "485", "486", "487", "488", "489", "491",
				"492", "493", "494", "495", "496", "497", "498", "499", "500", "501", "502", "503", "504", "504", "506",
				"507", "508", "509", "510", "511", "512", "513", "514", "515", "516", "517", "518", "519", "520", "521",
				"522", "523", "524", "525", "526", "527", "528", "529", "530", "531", "532", "533", "534", "535", "536",
				"537", "538", "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549", "550", "551",
				"552", "553", "554", "555", "556", "557", "558", "559", "560", "561", "562", "563", "564", "565", "566",
				"567", "568", "569", "570", "571", "572", "573", "574", "575", "576", "577", "578", "579", "580", "581",
				"582", "583", "584", "585", "586", "587", "588", "589", "591", "592", "593", "594", "595", "596", "597",
				"598", "599", "600", "601", "602", "603", "604", "605", "606", "607", "608", "609", "610", "611", "612",
				"613", "614", "615", "616", "617", "618", "619", "620", "621", "622", "623", "624", "625", "626", "627",
				"628", "629", "630", "631", "632", "633", "634", "635", "636", "637", "638", "639", "640", "641", "642",
				"643", "644", "645", "646", "647", "648", "649", "650", "651", "652", "653", "654", "655", "656", "657",
				"658", "659", "660", "661", "662", "663", "664", "665", "666", "667", "668", "669", "670", "671", "672",
				"673", "674", "675", "676", "677", "678", "679", "680", "681", "682", "683", "684", "685", "686", "687",
				"688", "689", "691", "692", "693", "694", "695", "696", "697", "698", "699", "700", "701", "702", "703",
				"704", "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715", "716", "717", "718",
				"719", "720", "721", "722", "723", "724", "725", "726", "727", "728", "729", "730", "731", "732", "733",
				"734", "735", "736", "737", "738", "739", "740", "741", "742", "743", "744", "745", "746", "747", "748",
				"749", "750", "751", "752", "753", "754", "755", "756", "757", "758", "759", "760", "761", "762", "763",
				"764", "765", "766", "767", "768", "769", "770", "771", "772", "773", "774", "775", "776", "777", "778",
				"779", "780", "781", "782", "783", "784", "785", "786", "787", "788", "789", "791", "792", "793", "794",
				"795", "796", "797", "798", "799", "800", "801", "802", "803", "804", "805", "806", "807", "808", "809",
				"810", "811", "812", "813", "814", "815", "816", "817", "818", "819", "820", "821", "822", "823", "824",
				"825", "826", "827", "828", "829", "830", "831", "832", "833", "834", "835", "836", "837", "838", "839",
				"840", "841", "842", "843", "844", "845", "846", "847", "848", "849", "850", "851", "852", "853", "854",
				"855", "856", "857", "858", "859", "860", "861", "862", "863", "864", "865", "866", "867", "868", "869",
				"870", "871", "872", "873", "874", "875", "876", "877", "878", "879", "880", "881", "882", "883", "884",
				"885", "886", "887", "888", "889", "891", "892", "893", "894", "895", "896", "897", "898", "899", "900",
				"901", "902", "903", "904", "905", "906", "907", "908", "909", "910", "911", "912", "913", "914", "915",
				"916", "917", "918", "919", "920", "921", "922", "923", "924", "925", "926", "927", "928", "929", "930",
				"931", "932", "933", "934", "935", "936", "937", "938", "939", "940", "941", "942", "943", "944", "945",
				"946", "947", "948", "949", "950", "951", "952", "953", "954", "955", "956", "957", "958", "959", "960",
				"961", "962", "963", "964", "965", "966", "967", "968", "969", "970", "971", "972", "973", "974", "975",
				"976", "977", "978", "979", "980", "981", "982", "983", "984", "985", "986", "987", "988", "989", "991",
				"992", "993", "994", "995", "996", "997", "998", "999" }));
		Botki.add(model3[i]);

		JLabel lblNewLabel_2 = new JLabel("KOLOR:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(260, y, 61, 14);
		Botki.add(lblNewLabel_2);

	
		kolor[i] = new JComboBox();
		kolor[i].setBounds(310, y, 90, 20);
		kolor[i].setMaximumRowCount(18);
		kolor[i].setModel(new DefaultComboBoxModel(
				new String[] { "czarny", "sliwka", "bordowy", "granatowy", "szary", "khaki", "brazowy", "bezowy","miedz","miętowy","żółty","multikolor","zielony","fioletowy","srebro","złoto","czerwony","pudrowy" }));
		Botki.add(kolor[i]);

		JLabel lblNewLabel_3 = new JLabel("Mat.wierzchu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(430, y, 118, 14);
		Botki.add(lblNewLabel_3);

		materialCombo[i] = new JComboBox();
		materialCombo[i].setBounds(520, y, 85, 20);
		materialCombo[i].setModel(
				new DefaultComboBoxModel(new String[] { "Welur", "Skora", "Tekstyl/текстиль", "Skora+Welur" }));
		Botki.add(materialCombo[i]);

		JLabel lblMateriaPodszewki = new JLabel("Materiał podszewki:");
		lblMateriaPodszewki.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriaPodszewki.setBounds(635, y, 118, 14);
		Botki.add(lblMateriaPodszewki);

		materialPoszewki[i] = new JComboBox();
		materialPoszewki[i].setBounds(755, y, 93, 20);
		materialPoszewki[i].setModel(new DefaultComboBoxModel(new String[] { "Misiek", "Filc", "Skora" }));
		Botki.add(materialPoszewki[i]);

		JLabel lblMateriaPodeszwy = new JLabel("Ilość par:");
		lblMateriaPodeszwy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriaPodeszwy.setBounds(873, y, 118, 14);
		Botki.add(lblMateriaPodeszwy);

		iloscPar[i] = new JComboBox();
		iloscPar[i].setBounds(931, y, 86, 20);
		iloscPar[i].setModel(new DefaultComboBoxModel(new String[] { "8", "5","6", "10", "12" }));
		Botki.add(iloscPar[i]);
		Okienko.frmZamwienia.getContentPane().add(Botki, "name_6316592025561");
		Botki.setLayout(null);

		y += 25;

		// for(int k=0;k<Okienko.iloscBotkow;k++){


		
		
		model2[i].addActionListener(new ActionListener() {
			
		public void actionPerformed(ActionEvent e) {
			
			
				String str=(String) model2[i].getSelectedItem();
				KozakPanel.TabModelKozaka[i]=str;
			
		}
		
		});
		
		model3[i].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

			
					String str2=(String) model3[i].getSelectedItem();
					KozakPanel.TabModelKozaka2[i]=str2;
				   
			}
			
			});
		
		 materialCombo[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
				
						String str=(String) materialCombo[i].getSelectedItem();
						KozakPanel.TabMaterialKozaka[i]=str;							
					
				}    						
			});
		 
		 
		 materialPoszewki[i].addActionListener(new ActionListener() {
				
				
				
				//wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {
					
					
						String str2=(String)  materialPoszewki[i].getSelectedItem();
						KozakPanel.TabMaterialPodszewkiKozaka[i]=str2;
				    
				}
			});
		 
		 iloscPar[i].addActionListener(new ActionListener() {
				
				
				
				//wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {
					
			
						
						int pary= Integer.parseInt((String) iloscPar[i].getSelectedItem());
						KozakPanel.TabParyKozaka[i]=pary;

				}
			});
		 
		 

			kolor[i].addActionListener(new ActionListener() {
				
				
				
				//wybor ilosci kozakow!!
				public void actionPerformed(ActionEvent e) {
					
					
	                    String str2=(String)  kolor[i].getSelectedItem();
						KozakPanel.TabKolorKozaka[i]=str2;

				}
			});
		

		// }
	}
	
void wypiszDane(int i,int y,JPanel Botki){
		
    	
    	String dupa;
		dupa=Integer.toString(sztuka);
		dupa+=" - ";
		
		JLabel ilosc=new JLabel(dupa);
		ilosc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		ilosc.setBounds(8, y, 66, 18);
		Botki.add(ilosc);
		sztuka++;
    	
    	
		JLabel lblModel = new JLabel("MODEL: ");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblModel.setBounds(35, y, 66, 18);
		Botki.add(lblModel);
		

	   
 		
	    model2[i] = new JComboBox();
		model2[i].setBounds(87, y, 64, 20);
		
      model2[i].setModel(new DefaultComboBoxModel(new String[] {"001", "002", "003", "004","005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037", "038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052", "053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063", "064", "065", "066", "067", "068", "069", "070", "071", "072", "073", "074", "075", "076", "077", "078", "079", "080", "081", "082", "083", "084", "085", "086", "087", "088", "089", "091", "092", "093", "094", "095", "096", "097", "098", "099", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "273", "275", "276", "277", "278", "279", "280", "281", "282", "283", "283", "285", "286", "287", "288", "289", "290", "291", "291", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "334", "335", "335", "336", "337", "338", "339", "340", "341", "342", "343", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "356", "357", "358", "359", "360", "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371", "372", "372", "374", "375", "376", "377", "378", "379", "380", "381", "382", "383", "384", "385", "386", "387", "388", "389", "390", "391", "392", "393", "394", "395", "396", "396", "397", "398", "399", "400", "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417", "418", "419", "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430", "431", "432", "433", "434", "435", "436", "437", "438", "439", "440", "441", "442", "443", "444", "445", "446", "447", "448", "449", "450", "451", "452", "453", "454", "455", "456", "457", "458", "459", "460", "461", "462", "463", "464", "465", "466", "467", "468", "469", "470", "471", "472", "473", "474", "475", "476", "477", "478", "479", "480", "481", "482", "483", "484", "485", "486", "487", "488", "489", "491", "492", "493", "494", "495", "496", "497", "498", "499", "500", "501", "502", "503", "504", "504", "506", "507", "508", "509", "510", "511", "512", "513", "514", "515", "516", "517", "518", "519", "520", "521", "522", "523", "524", "525", "526", "527", "528", "529", "530", "531", "532", "533", "534", "535", "536", "537", "538", "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549", "550", "551", "552", "553", "554", "555", "556", "557", "558", "559", "560", "561", "562", "563", "564", "565", "566", "567", "568", "569", "570", "571", "572", "573", "574", "575", "576", "577", "578", "579", "580", "581", "582", "583", "584", "585", "586", "587", "588", "589", "591", "592", "593", "594", "595", "596", "597", "598", "599", "600", "601", "602", "603", "604", "605", "606", "607", "608", "609", "610", "611", "612", "613", "614", "615", "616", "617", "618", "619", "620", "621", "622", "623", "624", "625", "626", "627", "628", "629", "630", "631", "632", "633", "634", "635", "636", "637", "638", "639", "640", "641", "642", "643", "644", "645", "646", "647", "648", "649", "650", "651", "652", "653", "654", "655", "656", "657", "658", "659", "660", "661", "662", "663", "664", "665", "666", "667", "668", "669", "670", "671", "672", "673", "674", "675", "676", "677", "678", "679", "680", "681", "682", "683", "684", "685", "686", "687", "688", "689", "691", "692", "693", "694", "695", "696", "697", "698", "699", "700", "701", "702", "703", "704", "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715", "716", "717", "718", "719", "720", "721", "722", "723", "724", "725", "726", "727", "728", "729", "730", "731", "732", "733", "734", "735", "736", "737", "738", "739", "740", "741", "742", "743", "744", "745", "746", "747", "748", "749", "750", "751", "752", "753", "754", "755", "756", "757", "758", "759", "760", "761", "762", "763", "764", "765", "766", "767", "768", "769", "770", "771", "772", "773", "774", "775", "776", "777", "778", "779", "780", "781", "782", "783", "784", "785", "786", "787", "788", "789", "791", "792", "793", "794", "795", "796", "797", "798", "799", "800", "801", "802", "803", "804", "805", "806", "807", "808", "809", "810", "811", "812", "813", "814", "815", "816", "817", "818", "819", "820", "821", "822", "823", "824", "825", "826", "827", "828", "829", "830", "831", "832", "833", "834", "835", "836", "837", "838", "839", "840", "841", "842", "843", "844", "845", "846", "847", "848", "849", "850", "851", "852", "853", "854", "855", "856", "857", "858", "859", "860", "861", "862", "863", "864", "865", "866", "867", "868", "869", "870", "871", "872", "873", "874", "875", "876", "877", "878", "879", "880", "881", "882", "883", "884", "885", "886", "887", "888", "889", "891", "892", "893", "894", "895", "896", "897", "898", "899", "900", "901", "902", "903", "904", "905", "906", "907", "908", "909", "910", "911", "912", "913", "914", "915", "916", "917", "918", "919", "920", "921", "922", "923", "924", "925", "926", "927", "928", "929", "930", "931", "932", "933", "934", "935", "936", "937", "938", "939", "940", "941", "942", "943", "944", "945", "946", "947", "948", "949", "950", "951", "952", "953", "954", "955", "956", "957", "958", "959", "960", "961", "962", "963", "964", "965", "966", "967", "968", "969", "970", "971", "972", "973", "974", "975", "976", "977", "978", "979", "980", "981", "982", "983", "984", "985", "986", "987", "988", "989", "991", "992", "993", "994", "995", "996", "997", "998", "999"}));
      Botki.add(model2[i]);
			
      JLabel ukosnik = new JLabel(" | ");
      ukosnik.setFont(new Font("Tahoma", Font.BOLD, 13));
      ukosnik.setBounds(150, y, 66, 18);
		Botki.add(ukosnik);
		
		model3[i] = new JComboBox();
		model3[i].setBounds(165, y, 64, 20);
      model3[i].setModel(new DefaultComboBoxModel(new String[] {"001", "002", "003", "004","005", "006", "007", "008", "009", "010", "011", "012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022", "023", "024", "025", "026", "027", "028", "029", "030", "031", "032", "033", "034", "035", "036", "037", "038", "039", "040", "041", "042", "043", "044", "045", "046", "047", "048", "049", "050", "051", "052", "053", "054", "055", "056", "057", "058", "059", "060", "061", "062", "063", "064", "065", "066", "067", "068", "069", "070", "071", "072", "073", "074", "075", "076", "077", "078", "079", "080", "081", "082", "083", "084", "085", "086", "087", "088", "089", "091", "092", "093", "094", "095", "096", "097", "098", "099", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118", "119", "120", "121", "122", "123", "124", "125", "126", "127", "128", "129", "130", "131", "132", "133", "134", "135", "136", "137", "138", "139", "140", "141", "142", "143", "144", "145", "146", "147", "148", "149", "150", "151", "152", "153", "154", "155", "156", "157", "158", "159", "160", "161", "162", "163", "164", "165", "166", "167", "168", "169", "170", "171", "172", "173", "174", "175", "176", "177", "178", "179", "180", "181", "182", "183", "184", "185", "186", "187", "188", "189", "190", "191", "192", "193", "194", "195", "196", "197", "198", "199", "200", "201", "202", "203", "204", "205", "206", "207", "208", "209", "210", "211", "212", "213", "214", "215", "216", "217", "218", "219", "220", "221", "222", "223", "224", "225", "226", "227", "228", "229", "230", "231", "232", "234", "235", "236", "237", "238", "239", "240", "241", "242", "243", "244", "245", "246", "247", "248", "249", "250", "251", "252", "253", "254", "255", "256", "257", "258", "259", "260", "261", "262", "263", "264", "265", "266", "267", "268", "269", "270", "271", "272", "273", "273", "275", "276", "277", "278", "279", "280", "281", "282", "283", "283", "285", "286", "287", "288", "289", "290", "291", "291", "293", "294", "295", "296", "297", "298", "299", "300", "301", "302", "303", "304", "305", "306", "307", "308", "309", "310", "311", "312", "313", "314", "315", "316", "317", "318", "319", "320", "321", "322", "323", "324", "325", "326", "327", "328", "329", "330", "331", "332", "334", "335", "335", "336", "337", "338", "339", "340", "341", "342", "343", "345", "346", "347", "348", "349", "350", "351", "352", "353", "354", "356", "357", "358", "359", "360", "361", "362", "363", "364", "365", "366", "367", "368", "369", "370", "371", "372", "372", "374", "375", "376", "377", "378", "379", "380", "381", "382", "383", "384", "385", "386", "387", "388", "389", "390", "391", "392", "393", "394", "395", "396", "396", "397", "398", "399", "400", "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417", "418", "419", "420", "421", "422", "423", "424", "425", "426", "427", "428", "429", "430", "431", "432", "433", "434", "435", "436", "437", "438", "439", "440", "441", "442", "443", "444", "445", "446", "447", "448", "449", "450", "451", "452", "453", "454", "455", "456", "457", "458", "459", "460", "461", "462", "463", "464", "465", "466", "467", "468", "469", "470", "471", "472", "473", "474", "475", "476", "477", "478", "479", "480", "481", "482", "483", "484", "485", "486", "487", "488", "489", "491", "492", "493", "494", "495", "496", "497", "498", "499", "500", "501", "502", "503", "504", "504", "506", "507", "508", "509", "510", "511", "512", "513", "514", "515", "516", "517", "518", "519", "520", "521", "522", "523", "524", "525", "526", "527", "528", "529", "530", "531", "532", "533", "534", "535", "536", "537", "538", "539", "540", "541", "542", "543", "544", "545", "546", "547", "548", "549", "550", "551", "552", "553", "554", "555", "556", "557", "558", "559", "560", "561", "562", "563", "564", "565", "566", "567", "568", "569", "570", "571", "572", "573", "574", "575", "576", "577", "578", "579", "580", "581", "582", "583", "584", "585", "586", "587", "588", "589", "591", "592", "593", "594", "595", "596", "597", "598", "599", "600", "601", "602", "603", "604", "605", "606", "607", "608", "609", "610", "611", "612", "613", "614", "615", "616", "617", "618", "619", "620", "621", "622", "623", "624", "625", "626", "627", "628", "629", "630", "631", "632", "633", "634", "635", "636", "637", "638", "639", "640", "641", "642", "643", "644", "645", "646", "647", "648", "649", "650", "651", "652", "653", "654", "655", "656", "657", "658", "659", "660", "661", "662", "663", "664", "665", "666", "667", "668", "669", "670", "671", "672", "673", "674", "675", "676", "677", "678", "679", "680", "681", "682", "683", "684", "685", "686", "687", "688", "689", "691", "692", "693", "694", "695", "696", "697", "698", "699", "700", "701", "702", "703", "704", "705", "706", "707", "708", "709", "710", "711", "712", "713", "714", "715", "716", "717", "718", "719", "720", "721", "722", "723", "724", "725", "726", "727", "728", "729", "730", "731", "732", "733", "734", "735", "736", "737", "738", "739", "740", "741", "742", "743", "744", "745", "746", "747", "748", "749", "750", "751", "752", "753", "754", "755", "756", "757", "758", "759", "760", "761", "762", "763", "764", "765", "766", "767", "768", "769", "770", "771", "772", "773", "774", "775", "776", "777", "778", "779", "780", "781", "782", "783", "784", "785", "786", "787", "788", "789", "791", "792", "793", "794", "795", "796", "797", "798", "799", "800", "801", "802", "803", "804", "805", "806", "807", "808", "809", "810", "811", "812", "813", "814", "815", "816", "817", "818", "819", "820", "821", "822", "823", "824", "825", "826", "827", "828", "829", "830", "831", "832", "833", "834", "835", "836", "837", "838", "839", "840", "841", "842", "843", "844", "845", "846", "847", "848", "849", "850", "851", "852", "853", "854", "855", "856", "857", "858", "859", "860", "861", "862", "863", "864", "865", "866", "867", "868", "869", "870", "871", "872", "873", "874", "875", "876", "877", "878", "879", "880", "881", "882", "883", "884", "885", "886", "887", "888", "889", "891", "892", "893", "894", "895", "896", "897", "898", "899", "900", "901", "902", "903", "904", "905", "906", "907", "908", "909", "910", "911", "912", "913", "914", "915", "916", "917", "918", "919", "920", "921", "922", "923", "924", "925", "926", "927", "928", "929", "930", "931", "932", "933", "934", "935", "936", "937", "938", "939", "940", "941", "942", "943", "944", "945", "946", "947", "948", "949", "950", "951", "952", "953", "954", "955", "956", "957", "958", "959", "960", "961", "962", "963", "964", "965", "966", "967", "968", "969", "970", "971", "972", "973", "974", "975", "976", "977", "978", "979", "980", "981", "982", "983", "984", "985", "986", "987", "988", "989", "991", "992", "993", "994", "995", "996", "997", "998", "999"}));
      Botki.add(model3[i]);
		
		
		JLabel lblNewLabel_2 = new JLabel("KOLOR:");
		lblNewLabel_2.setBackground(new Color(192, 192, 192));

		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(260, y, 61, 14);
		Botki.add(lblNewLabel_2);
		
		
	    
		
		kolor[i]=new JComboBox();		
		kolor[i].setBounds(310, y, 90, 20);
		kolor[i].setMaximumRowCount(18);
		kolor[i].setModel(new DefaultComboBoxModel(
				new String[] { "czarny", "sliwka", "bordowy", "granatowy", "szary", "khaki", "brazowy", "bezowy","miedz","miętowy","żółty","multikolor","zielony","fioletowy","srebro","złoto","czerwony","pudrowy" }));
		Botki.add(kolor[i]);
		
		
		JLabel lblNewLabel_3 = new JLabel("Mat.wierzchu:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(430, y, 118, 14);
		Botki.add(lblNewLabel_3);
		
		
		materialCombo[i] = new JComboBox();
		materialCombo[i].setBounds(520, y, 85, 20);
		materialCombo[i].setModel(new DefaultComboBoxModel(new String[] {"Welur","Skora", "Tekstyl/текстиль", "Skora+Welur"}));
		Botki.add(materialCombo[i]);
		
     
		JLabel lblMateriaPodszewki = new JLabel("Materiał podszewki:");
		lblMateriaPodszewki.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriaPodszewki.setBounds(635, y, 118, 14);
		Botki.add(lblMateriaPodszewki);
		
		 materialPoszewki[i]=new JComboBox();
		 materialPoszewki[i].setBounds(755, y, 93, 20);
		 materialPoszewki[i].setModel(new DefaultComboBoxModel(new String[] {"Misiek","Filc", "Skora"}));
		 Botki.add(materialPoszewki[i]);
		
			
		JLabel lblMateriaPodeszwy = new JLabel("Ilość par:");
		lblMateriaPodeszwy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMateriaPodeszwy.setBounds(873, y, 118, 14);
		Botki.add(lblMateriaPodeszwy);
		
		iloscPar[i]=new JComboBox();
		iloscPar[i].setBounds(931, y, 86, 20);
		iloscPar[i].setModel(new DefaultComboBoxModel(new String[] {"8", "5","6", "10", "12"}));
		Botki.add(iloscPar[i]);	
  }
public KozakPanel(boolean init,JPanel Botki){
    
	Okienko.frmZamwienia.getContentPane().add(Botki, "name_6316592025561");
		Botki.setLayout(null);
		delete();
		int pom;
	if(Okienko.iloscKozakow<24){
         pom=69+(25*Okienko.iloscKozakow);
	}else{
		 pom=69+((Okienko.iloscKozakow-23)*25);
	}
		i=Okienko.iloscKozakow-1;
		
		for(;i<Okienko.iloscKozakow;i++,pom-=25){
			
			
			JLabel lblModel = new JLabel("—————————— ");
			lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblModel.setBounds(5, pom, 66, 18);
			Botki.add(lblModel);
			


			
			JLabel lblNewLabel_2 = new JLabel("—————————");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(260, pom, 61, 14);
			Botki.add(lblNewLabel_2);
			
			
			
			JLabel lblNewLabel_3 = new JLabel("————————");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_3.setBounds(430,  pom, 118, 14);
			Botki.add(lblNewLabel_3);
			
			
			
			
          
			JLabel lblMateriaPodszewki = new JLabel("———————————————");
			lblMateriaPodszewki.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMateriaPodszewki.setBounds(637, pom, 118, 14);
			Botki.add(lblMateriaPodszewki);
			
				
			JLabel lblMateriaPodeszwy = new JLabel("——————");
			lblMateriaPodeszwy.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMateriaPodeszwy.setBounds(870,  pom, 118, 14);
			Botki.add(lblMateriaPodeszwy);
			
		
		
		}	
		
		
		
		
}
}



