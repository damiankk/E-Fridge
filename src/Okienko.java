import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Male okienko pozwalajace na wyswietlanie komunikatow dla uzytkownika.
 * Sa to komunikatu sukcesu i komunikaty bledow.
 * @author Damian
 *
 */
public class Okienko extends JFrame {
	Okienko(String label){
		super();
		this.setTitle("Komunikat");
		this.setVisible(true);
		this.setSize(350, 100);
		this.setLocation(50, 50);
		this.setAlwaysOnTop(true);
		JPanel panel = new JPanel();
		/*try{
		this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("res/blad.JPG")))));
		}catch(IOException e){
			System.out.println("Image doesn't exist");
		}*/
		panel.setBackground(Color.GREEN);
		JLabel label1 = new JLabel(label,JLabel.CENTER);
		label1.setAlignmentX(0);
		label1.setAlignmentY(0);
		panel.add(label1);
		this.add(panel);
	}
}