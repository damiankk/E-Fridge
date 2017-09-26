import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
/**
 * Glowne okno programu
 * @author Damian
 *
 */
public class MainWindow extends JFrame {
	private JButton dodprod, usunprod, wyswietl, pokazprzepisy;
	private JTextField jt, jd, jm, jr, ji, jk;
	private JLabel jl, jl2, jl3;
	private static JComboBox<String> comboBox;
	public Lodowka l = new Lodowka();
	private Przepisy p = new Przepisy();
	private String part ="";
	
	/**
	 * Konstruktor klasy MainWindow.
	 * To tutaj odbywa sie wyswietlanie okien, paneli i komponentów oraz wywolywanie funkcji odpowiedzialnych za poszczególne funkcjonalnoœci aplikacji.
	 */
	public MainWindow(){
		
		
		super();		//utworzenie glownego okna programu
		setWindowValues("~~ E-Kuchnia ~~");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		/**
		 * Uzupelniam lodowke i liste przepisow przykladowymi danymi
		 */
		Przepis p1 = new Przepis("res/kanapka.csv");
		p.addto(p1);
		Przepis p2 = new Przepis("res/rolada.csv");
		p.addto(p2);
		Przepis p3 = new Przepis("res/spaghetti.csv");
		p.addto(p3);
		
		l.addto(new Produkt("maslo",1994,12,11,0.4));
		l.addto(new Produkt("mleko",2017,11,05,1));
		l.addto(new Produkt("banan",2022,10,02,1));
		l.addto(new Produkt("kurczak",2017,05,04,2.0));
		l.addto(new Produkt("owies",2016,06,10,0.5));
		l.addto(new Produkt("chleb",2016,06,05,1));
		l.addto(new Produkt("szynka",2016,06,10,1.5));
		
		
		c.insets = new Insets(10,5,20,5);
		
		
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 10;
		c.fill = GridBagConstraints.BOTH;
		dodprod = new JButton("Dodaj produkt do lodówki");
		panel.add(dodprod,c);
		
		
		c.gridx = 2;
		c.gridy = 2;
		usunprod = new JButton("Usun produkt z lodówki");
		panel.add(usunprod,c);
		
		
		c.gridx = 2;
		c.gridy = 3;
		wyswietl = new JButton("Wyswietl produkty z lodówki");
		panel.add(wyswietl,c);
		
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.CENTER;
		pokazprzepisy = new JButton("Pokaz potrawy jakie mozesz przyrzadzic");
		panel.add(pokazprzepisy,c);
		
		
		
		
		dodprod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Okno hel = new Okno("Dodawanie produktu do lodówki");
				
				JPanel panel1 = new JPanel(new GridBagLayout()); //tworze nowy panel na ktorym znajdzie sie formularz dodawania produktu
				panel1.setBackground(Color.PINK);
				GridBagConstraints c = new GridBagConstraints(); //uzywam tego do rozmieszczania komponentow w panelu
				//panel1.setLayout(new GridLayout())
				c.gridx = 0;
				c.gridy = 1;
				jl = new JLabel("Wpisz nazwe produktu:  ");
				panel1.add(jl,c);		//dodajemy label do wpisania nazwy produktu
				c.gridx = 1;
				c.gridy = 1;
				jt = new JTextField(20);
				panel1.add(jt,c); //dodajemy miejsce do wpisania nazwy produktu
				
				c.gridx = 0;
				c.gridy = 2;
				jl2 = new JLabel("Podaj date do spozycia produktu:");
				panel1.add(jl2,c);
				
				c.gridx = 1;
				c.gridy = 3;
				jr = new JTextField("RRRR",20);
				panel1.add(jr,c); //dodajemy miejsce do wpisania daty do spozycia produktu
				
				c.gridx = 1;
				c.gridy = 4;
				jm = new JTextField("MM",20);
				panel1.add(jm,c);
				
				c.gridx = 1;
				c.gridy = 5;
				jd = new JTextField("DD",20);
				panel1.add(jd,c);
				
				c.gridx = 0;
				c.gridy = 6;
				jl3 = new JLabel("Podaj ilosc kupowanego produktu:");
				panel1.add(jl3,c);
				
				c.gridx = 1;
				c.gridy = 7;
				ji = new JTextField("ilosc[kg]",20);
				panel1.add(ji,c);
				
				JButton jb = new JButton("Dodaj produkt");
				c.gridx = 0;
				c.gridy = 9;
				
				jb.addActionListener(new ActionListener(){ //nacisniecie przycisku dodanie produktu
					public void actionPerformed(ActionEvent e){
						if(!(jt.getText().equals("") || jd.getText().equals("") || jr.getText().equals("") || jm.getText().equals("") || ji.getText().equals(""))  )	//sprawdzenie czy podany produkt posiada nazwê i date przydatnosci
						{
						Produkt p = new Produkt(jt.getText());
						try{
						p.przydrok = Integer.parseInt(jr.getText());
						p.przydmies = Integer.parseInt(jm.getText());
						p.przyddz = Integer.parseInt(jd.getText());
						p.ilosc = Double.parseDouble(ji.getText());
						
						p.dataprzyd = p.przydrok + "-" + p.przydmies +"-" + p.przyddz;
						l.addto(p);
						Okienko kom1 = new Okienko("Do lodowki zostal dodany produkt " + jt.getText());
						}catch (NumberFormatException ee){									//WYJATEK: jesli zostanie podana data przydatnosci w zlym formacie
							Okienko kom2 = new Okienko("Zly format daty! Data musi byc liczb¹!");
						}
						
						}
						else {
							Okienko kom3 = new Okienko("Nie mozna dodac produktu bez nazwy/daty przydatnosci!");
						}
					}
				});
				
				panel1.add(jb,c);
				
				hel.add(panel1);
			}
		});
		
		
		
		
		usunprod.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		//nacisniecie przycisku usuwanie produktu
				Okno hel = new Okno("Usuwanie produktu z lodówki");
				
				JPanel panel1 = new JPanel(new GridBagLayout()); //tworze nowy panel na ktorym znajdzie sie formularz dodawania produktu
				panel1.setBackground(Color.PINK);
				GridBagConstraints c = new GridBagConstraints(); //uzywam tego do rozmieszczania komponentow w panelu
				c.gridx = 0;
				c.gridy = 1;
				/*jl = new JLabel("Wpisz nazwe produktu:  ");
				panel1.add(jl,c);		//dodajemy label do wpisania nazwy produktu
				c.gridx = 1;
				c.gridy = 1;
				jt = new JTextField(20);
				panel1.add(jt,c); //dodajemy miejsce do wpisania nazwy produktu
				*/
				//JLabel labelCombo = new JLabel("Wybierz produkt");
				//String[] options = { "Option1", "Option2", "Option3", "Option4", "Option15" };
				
				JLabel labelCombo = new JLabel("Wybierz produkt z lodowki ktory chcesz usunac");
						
				c.gridx = 1;
				c.gridy = 1;
				comboBox = new JComboBox<String>(); 
				for(int z=0;z<l.produkty.size();z++){
					comboBox.addItem(l.produkty.get(z).nazwa + "-" + l.produkty.get(z).ilosc+"[kg]");
				}
				

		        comboBox.addActionListener(new ActionListener(){ //wybranie opcji z comboboxa
					public void actionPerformed(ActionEvent e){
						String []parts = comboBox.getSelectedItem().toString().split("-");
						String part = parts[0];
						l.setpart(part);
						System.out.println(part);
					}
				});
		        
		        panel1.add(labelCombo);
		        panel1.add(comboBox);
		        
				c.gridx = 0;
				c.gridy = 2;
				JLabel jkg = new JLabel("Podaj ilosc produktu[kg]: ");
				panel1.add(jkg,c);
				
				c.gridx = 1;
				c.gridy = 2;
				jk = new JTextField(20);
				panel1.add(jk,c);
				
				JButton jb = new JButton("Usun produkt");
				c.gridx = 0;
				c.gridy = 3;
				
				jb.addActionListener(new ActionListener(){ //nacisniecie przycisku usuniecie produktu
					public void actionPerformed(ActionEvent e){
						if(!l.part.equals(""))	//sprawdzenie czy podany produkt posiada nazwê
						{
							try{
							System.out.println(l.part);
							boolean czy = l.deletefrom(l.part,Double.parseDouble(jk.getText()));
							if(czy==true){
								Okienko kom1 = new Okienko("Produkt " + l.part +" zostal usuniety!");
							}
							}catch (NumberFormatException ee){
								Okienko kom2 = new Okienko ("Zly format ilosci! Ilosc musi byc liczba zmiennoprzecinkowa");
							}
							
						}
						else {
							Okienko kom3 = new Okienko("Nie mozna usunac produktu bez nazwy!");
						}
					}
				});
				
				panel1.add(jb,c);
				
				
				hel.add(panel1);
				
			}
		});		
		
		

		wyswietl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Tabela tab = new Tabela(l);					//w konstruktorze tablicy wyswietlajacej dane podajemy jako parametr obiekt lodowki utworzony na poczatku klasy

				
			}
		});
		
		
		pokazprzepisy.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<p.przepisy.size();i++){
					boolean m1 = l.sprawdzprzepis(p.przepisy.get(i));
					System.out.println("Boolean" +m1);
					p.przepisy.get(i).setczymozliwy(m1);
				}
				AbstractTableModel dane = new MyTableModelprzep(p.przepisy);
				Tabelaprzepis tab = new Tabelaprzepis(dane);
				
				
			}
			
			
		});
		
		
		
		
		
		
		//getContentPane().add(new JButton("click me!"));


		getContentPane().add(panel);
	}
	
	public void setWindowValues(String nazwa){
		this.setTitle(nazwa);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setMinimumSize(new Dimension(640, 480));
	}
	


	
}




