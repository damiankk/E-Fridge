import java.awt.EventQueue;
/**
 * Wyswietlanie glownego okna aplikacji
 * 
 * @author Damian
 *
 */
public class Main {
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow().setVisible(true);
			}
		});
		

	}
	
}
