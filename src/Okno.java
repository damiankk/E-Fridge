import java.awt.Dimension;

import javax.swing.JFrame;
/**
 * Okno uruchamiane w przypadku uruchomienia dwoch pierwszych opcji
 * @author Damian
 *
 */
public class Okno extends JFrame {
	Okno(String nazwa){
		super();
		this.setTitle(nazwa);
		this.setVisible(true);
		this.setSize(640, 480);
		this.setLocation(50, 50);
		this.setResizable(false);
	}
}
