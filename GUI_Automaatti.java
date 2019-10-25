import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class GUI_Automaatti extends JFrame {

	// Luokkamuuttujat
	// Esitell‰‰n t‰‰ll‰ jotta komponentteihin voidaan viitata mist‰ tahansa luokan
	// sis‰lt‰

	JPanel contentPane;
	private JButton btnKahvi;
	private JLabel lblKahvi;
	private JButton btnTee;
	private JLabel lblTee;
	private JButton btnKaakao;
	private JLabel lblKaakao;
	private JLabel kahvij;
	private JLabel teej;
	private JLabel kaakaoj;
	private JMenuBar menuBar;
	private JMenu mnYllpito;
	private JMenuItem mntmAsetaKahvinMr;
	private JMenuItem mntmAsetaTeenMr;
	private JMenuItem mntmAsetaKaakaonMr;
	private JMenuItem mntmTallennaAutomaatti;
	private JMenuItem mntmLataaAutomaatti_1;
	private JMenuItem mntmLopeta;
	private JMenu mnTietoaOhjelmasta;
	private JMenuItem mntmVersiotiedot;
	private JMenuItem mntmOhje;

	/**
	 * Main-metodi, joka k‰ynnist‰‰ sovelluksen
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Luodaan ensmin uusi JuomaAutomaatti-olio
					JuomaAutomaatti ja = new JuomaAutomaatti();

					// K‰yttˆliittym‰ saa parametrina olion, jonka tiedot se n‰ytt‰‰
					GUI_Automaatti frame = new GUI_Automaatti(ja);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Konstruktorissa rakennetaan k‰yttˆliittym‰. Huomaa, ett‰ otetaan parametrina
	 * vastaan alussa luotu juoma-automaatti. T‰m‰ siksi, ett‰ voidaan n‰ytt‰‰ sen
	 * tiedot GUI:ssa
	 */
	public GUI_Automaatti(JuomaAutomaatti ja) {

		JuomaAutomaatti omaAutomaatti = new JuomaAutomaatti();
		int kahvi = omaAutomaatti.getKahvi();
		int tee = omaAutomaatti.getTee();
		int kaakao = omaAutomaatti.getKaakao();
		
		// Ikkunan otsikko ja koko

		setTitle("Kahviautomaatti GUI v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 259);

	 
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnKahvi = new JButton("Kahvi");
		btnKahvi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				omaAutomaatti.valmistaKahvi();
				kahvij.setText("J‰ljell‰: " + omaAutomaatti.getKahvi());
				if (omaAutomaatti.getKahvi() <= 20) {
					kahvij.setForeground(Color.RED); 
				}
			}
		});
		btnKahvi.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("coffee.jpg")));
		btnKahvi.setBounds(10, 31, 140, 134);
		contentPane.add(btnKahvi);
		
		lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		lblKahvi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKahvi.setBounds(10, 176, 140, 20);
		contentPane.add(lblKahvi);
		
		kahvij = new JLabel("J‰ljell‰: " + kahvi);
		kahvij.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 11));
		kahvij.setHorizontalAlignment(SwingConstants.CENTER);
		kahvij.setForeground(Color.DARK_GRAY);
		kahvij.setBounds(10, 195, 140, 14);
		contentPane.add(kahvij);
		
		btnTee = new JButton("Tee");
		btnTee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				omaAutomaatti.valmistaTee();
				teej.setText("J‰ljell‰: " + omaAutomaatti.getTee());
				if (omaAutomaatti.getTee() <= 20) {
					teej.setForeground(Color.RED); 
				}
			}
		});
		btnTee.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("tea.jpg")));
		btnTee.setBounds(160, 31, 140, 134);
		contentPane.add(btnTee);
		
		lblTee = new JLabel("Tee");
		lblTee.setHorizontalAlignment(SwingConstants.CENTER);
		lblTee.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		lblTee.setBounds(160, 177, 140, 18);
		contentPane.add(lblTee);
		
		teej = new JLabel("J‰ljell‰: " + tee);
		teej.setForeground(Color.DARK_GRAY);
		teej.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 11));
		teej.setHorizontalAlignment(SwingConstants.CENTER);
		teej.setBounds(160, 195, 140, 14);
		contentPane.add(teej);
		
		btnKaakao = new JButton("Kaakao");
		btnKaakao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				omaAutomaatti.valmistaKaakao();
				kaakaoj.setText("J‰ljell‰: " + omaAutomaatti.getKaakao());
				if (omaAutomaatti.getKaakao() <= 20) {
					kaakaoj.setForeground(Color.RED); 
					}
			}
		});
		btnKaakao.setIcon(new ImageIcon(GUI_Automaatti.class.getResource("cocoa.jpg")));
		btnKaakao.setBounds(310, 31, 140, 134);
		contentPane.add(btnKaakao);
		
		lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		lblKaakao.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaakao.setBounds(310, 176, 119, 20);
		contentPane.add(lblKaakao);
		
		kaakaoj = new JLabel("J‰ljell‰: " + kaakao);
		kaakaoj.setHorizontalAlignment(SwingConstants.CENTER);
		kaakaoj.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 11));
		kaakaoj.setForeground(Color.DARK_GRAY);
		kaakaoj.setBounds(310, 195, 140, 14);
		contentPane.add(kaakaoj);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 458, 21);
		contentPane.add(menuBar);
		
		mnYllpito = new JMenu("Yll\u00E4pito");
		mnYllpito.setMinimumSize(new Dimension(50, 4));
		menuBar.add(mnYllpito);
		
		mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m‰‰r‰");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKahvi = Integer.parseInt(uusiArvo);

				omaAutomaatti.setKahvi(uusiKahvi);
				kahvij.setText("J‰ljell‰: " + uusiKahvi);
			}
		});
		mnYllpito.add(mntmAsetaKahvinMr);
		
		mntmAsetaTeenMr = new JMenuItem("Aseta teen m‰‰r‰");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiTee = Integer.parseInt(uusiArvo);

				omaAutomaatti.setTee(uusiTee);
				teej.setText("J‰ljell‰: " + uusiTee);
			}
		});
		mnYllpito.add(mntmAsetaTeenMr);
		
		mntmAsetaKaakaonMr = new JMenuItem("Aseta kaakaon m‰‰r‰");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uusiArvo = JOptionPane.showInputDialog(null, "Anna uusi arvo: ");
				int uusiKaakao = Integer.parseInt(uusiArvo);

				omaAutomaatti.setKaakao(uusiKaakao);
				kaakaoj.setText("J‰ljell‰: " + uusiKaakao);
			}
		});
		mnYllpito.add(mntmAsetaKaakaonMr);
		
		mntmTallennaAutomaatti = new JMenuItem("Tallenna automaatti");
		mntmTallennaAutomaatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista.kirjoitaTiedostoon( omaAutomaatti );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmTallennaAutomaatti);
		
		mntmLataaAutomaatti_1 = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JuomaAutomaatti uusi = Sarjallistamista.lueTiedostosta();
					omaAutomaatti.setKaakao(uusi.getKaakao());
					omaAutomaatti.setKahvi(uusi.getKahvi());
					omaAutomaatti.setTee(uusi.getTee());
					kahvij.setText("J‰ljell‰: " + uusi.getKahvi());
					teej.setText("J‰ljell‰: "+ uusi.getTee());
					kaakaoj.setText("J‰ljell‰: " + uusi.getKaakao());
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnYllpito.add(mntmLataaAutomaatti_1);
		
		mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllpito.add(mntmLopeta);
		
		mnTietoaOhjelmasta = new JMenu("Tietoa ohjelmasta");
		mnTietoaOhjelmasta.setMinimumSize(new Dimension(80, 4));
		menuBar.add(mnTietoaOhjelmasta);
		
		mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Versiotiedot frame = new Versiotiedot();
				frame.setVisible(true);
			}
		});
		mnTietoaOhjelmasta.add(mntmVersiotiedot);
		
		mntmOhje = new JMenuItem("Ohje");
		mnTietoaOhjelmasta.add(mntmOhje);
	}
}
