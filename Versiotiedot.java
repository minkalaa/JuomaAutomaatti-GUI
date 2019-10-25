import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;

public class Versiotiedot extends JFrame {
	private JLabel nimi;
	private JLabel tekij;
	private JLabel versio;
	
	public Versiotiedot() {
		setMinimumSize(new Dimension(330, 145));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		nimi = new JLabel("Juoma-Automaatti");
		nimi.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 25));
		nimi.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(nimi, BorderLayout.NORTH);
		
		tekij = new JLabel("Tekijä: Minka Laasonen");
		tekij.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 12));
		tekij.setHorizontalAlignment(SwingConstants.RIGHT);
		getContentPane().add(tekij, BorderLayout.SOUTH);
		
		versio = new JLabel("Versio 1.0");
		versio.setHorizontalAlignment(SwingConstants.CENTER);
		versio.setFont(new Font("Franklin Gothic Medium Cond", Font.PLAIN, 15));
		getContentPane().add(versio, BorderLayout.CENTER);
	}

}
