import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/**
 * Klasa wyswietlajaca tabele produktow z lodowki
 * @author Damian
 *
 */
public class Tabela extends JFrame {
	
	JTable table;
	
	public Tabela(Lodowka l){
		setLayout(new FlowLayout());
		Okno okno = new Okno("Wyswietlanie produktow z lodówki");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());			//ustawiam layout JPanela
		AbstractTableModel dane = new MyTableModel(l.produkty);
		
		table = new JTable(dane);
		table.setPreferredScrollableViewportSize(new Dimension(400,50));	//zmieniam startowy rozmiar tabeli wyswietlajacej dane
		table.setFillsViewportHeight(true);
		JScrollPane scrollpanel = new JScrollPane(table);
		panel.add(scrollpanel,BorderLayout.CENTER);
		okno.getContentPane().add(panel);
	}
	
	
	
	
}
