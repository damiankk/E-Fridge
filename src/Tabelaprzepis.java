import java.awt.BorderLayout;import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
/**
 * Klasa odpowiadajaca za wywolanie okna z tablic¹ (JTable) mozliwych przepisow do ugotowania.
 * To, czy przepis jest mozliwy do ugotowania okresla ilosc posiadanynych nieprzeterminowanych produktow.
 * @author Damian
 *
 */
public class Tabelaprzepis extends JFrame {
	JTable table;
	
	/**
	 * Konstruktor klasy Tabelaprzepis
	 * @param l		Parametrem konstruktora tablicy jest klasa Lodowka, poniewaz bedziemy odwolywac sie do kolekcji produktow.
	 */
	public Tabelaprzepis(AbstractTableModel dane){
		setLayout(new FlowLayout());
		Okno okno = new Okno("Wyswietlanie potraw");
		JPanel panel = new JPanel();
		okno.setSize(1000, 100);
		okno.setMinimumSize(new Dimension(1000,200));
		panel.setLayout(new BorderLayout());
		table = new JTable(dane);
		table.setPreferredScrollableViewportSize(new Dimension(400,50));	//zmieniam startowy rozmiar tabeli wyswietlajacej dane
		table.setFillsViewportHeight(true);

		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		JScrollPane scrollpanel = new JScrollPane(table);
		panel.add(scrollpanel,BorderLayout.CENTER);
		okno.getContentPane().add(panel);
		
	}
}
