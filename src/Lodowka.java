import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Klasa przechowujaca liste produktów - obiektów klasy produkt
 * @author Damian
 *
 */
public class Lodowka {
	public List<Produkt> produkty = new LinkedList<Produkt>();
	public String part = ""; //zmienna odpowiadajaca za combobox w przypadku usuniecia produktu
	/**
	 * Dodawanie produktu do lodówki
	 * @param p1	Parametrem jest obiekt klasy Produkt
	 */
	public void addto(Produkt p1){
		produkty.add(p1);
		System.out.println("Do lodowki zostal dodany produkt " + p1.nazwa + ". Ilosc produktow w lodowce wynosi " + produkty.size());
	}
	/**
	 * Funkcja usuwa produkt z lodówki. Funkcja obsluguje kilka bledow m.in. posiadania niewystarczajacej ilosci produktu w lodowce
	 * @param name		Nazwa usuwanego produktu
	 * @param ilosc		Ilosc usuwanego produktu
	 * @return
	 */
	public boolean deletefrom(String name, double ilosc){
		int i=0; //zaczynamy sprawdzanie od pierwszego elementu tablicy, w razie duplikacji funkcja usunie produkt dodany najwczesniej czyli z najstarsz¹ dat¹ 
		while(i<produkty.size()){			//sprawdzamy czy iterator wyszedl poza zakres tablicy produktow w lodowce
		while(produkty.get(i).nazwa.equals(name)){
			if(ilosc == 0){					//usuwamy ca³y produkt jeœli podana w argumencie iloœæ = 0
			produkty.remove(i);		//usuwamy produkt ktorego nazwe podalismy
			return true;
			}
			if(ilosc>produkty.get(i).ilosc || ilosc<0){
				Okienko kom1 = new Okienko ("Nie masz takiej ilosci produktu w lodowce!");
				return false;
			}
			produkty.get(i).ilosc = produkty.get(i).ilosc - ilosc;
			return true;
		}
		i++;
		}
		Okienko kom2 = new Okienko("Nie ma takiego produktu w lodowce!");
		return false;
	}
	/**
	 * Funkcja sprawdzajaca czy w lodowce znajduja sie wszystkie potrzebne produkty o odpowiedniej ilosci (nieprzeterminowane) do wykonania potrawy
	 * @param p	pojedynczy przepis, ktory bedzie sprawdzany przez funkcjê
	 * @return
	 */
	public boolean sprawdzprzepis(Przepis p){
		
		int i=0;
		int j=0;
		while(j<p.produkty.size()){
			/**
			 * sprawdzamy czy dla kazdego produktu w przepisie nazwa produktu w lodowce jest taka jak nazwa produktu w przepisie i ilosc tego produktu w lodowce jest wieksza lub rowna od potrzebnej ilosci danego produktu
			 */
			/**
			 * dopoki nazwa produktu w lodowce nie jest rowna nazwie produktu w przepisie
			 */

			while(!this.produkty.get(i).nazwa.equals(p.produkty.get(j).nazwa)){
				i++;
				if(i>=this.produkty.size())return false; 		//jesli przekroczylismy rozmiar kolekcji produktow w lodowce
			}
			/**
			 * jesli ilosc produktu potrzebnego do wykonania przepisu jest mniejsza niz ilosc tego produktu w lodowce
			 */
			
			if(this.produkty.get(i).ilosc<p.produkty.get(j).ilosc)return false;
			i=0;
			j++;
			
		}
		
		return true;

	}
	
	public void setpart (String part){
		this.part = part;
	}
	
	
}
	
	
	
