import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Klasa przepis bedaca przepisem na potrawe
 * @author Damian
 *
 */
public class Przepis {
	String nazwaprzepisu;
	public List<Miniprodukt> produkty = new LinkedList<Miniprodukt>();
	String opisprzepisu;
	String czymozliwy;
	/**
	 * 
	 * @param filepath		Sciezka do pliku csv w ktorym znajduje sie przepis
	 */
	public Przepis(String filepath){
		String filetoparse = filepath;
		BufferedReader fileReader = null;
		/**
		 * Delimiter odpowiada za oddzielanie poszczegolnych pól od siebie
		 */
		final String DELIMITER = ";";
		try
		{
			
			fileReader = new BufferedReader(new FileReader(filetoparse));
			String line = "";
				while((line = fileReader.readLine())!=null){
				String[] tokens = line.split(DELIMITER);
				this.nazwaprzepisu = tokens[0];
				this.opisprzepisu = tokens[tokens.length-1];
				for(int i=1;i+1<tokens.length;i+=2){	//zwiekszamy iterator o 2
					//System.out.println(tokens[1] + tokens[2] + tokens[3] + tokens[4]);
					Miniprodukt p = new Miniprodukt(tokens[i],Double.parseDouble(tokens[i+1]));
					this.produkty.add(p);
				}
				//DO ZROBIENIA
				}
			
			
		}  catch (Exception e) {
            e.printStackTrace();
	}
		 finally
	        {
	            try {
	                fileReader.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	
	}
	/**
	 * ustawienie atrybutu (czy przepis jest mozliwy do wykonania?)
	 * @param s	tu bêdzie wprowadzana wartosc z funkcji "sprawdzprzepis" z klasy Lodowka
	 */
	public void setczymozliwy(boolean s){
		if(s==true)this.czymozliwy="TAK";
		else this.czymozliwy = "Brak odpowiednich skladnikow!";
		
	}
	
}
