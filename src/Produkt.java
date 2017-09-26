import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * Klasa tworzaca obiekty fizycznych produktów, ktore sa przechowywane w lodowce.
 * @author Damian
 *
 */
public class Produkt {
	
	String nazwa;
	String dataprzyd;
	int przydrok;
	int przydmies;
	int  przyddz;
	double ilosc;
	Produkt(String nazwa){
		this.nazwa = nazwa;
		
	}
	/**
	 * 
	 * @param nazwa		Nazwa produktu
	 * @param przydrok	Rok przydatnosci do spozycia
	 * @param przydmies	Miesiac przydatnosci do spozycia
	 * @param przyddz	Dzien przydatnosci do spozycia
	 * @param ilosc		Ilosc produktu w kilogramach
	 */
	Produkt(String nazwa, int przydrok, int przydmies, int przyddz, double ilosc){
		this.nazwa = nazwa;
		this.przydrok = przydrok;
		this.przydmies = przydmies;
		this.przyddz = przyddz;
		this.ilosc = ilosc;
		this.dataprzyd = przydrok + "-" + przydmies +"-" + przyddz;
		
	}
	
	/**
	 * sprawdzenie czy produkt jest zdatny do spozycia
	 * @param p
	 * @return
	 */
	public String czyprzyd(Produkt p){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		/**
		 * Pobranie aktualnego czasu wykorzystuj¹c Calendar
		 */
		Calendar calendar = Calendar.getInstance(); 
		int year = calendar.get(Calendar.YEAR);
		/**
		 * dodaje 1 poniewa¿ miesiace w java calendar sa indeksowane od 0 do 11
		 */
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
			
		
		if(p.przydrok>year){
			return "Smacznego!";
		}
		
		if(p.przydrok==year){
			if(p.przydmies>month)return "Smacznego!";
			else if(p.przydmies==month){
					if(p.przyddz>=day)return "Smacznego!";
				
			}
		}
		
		
		return "PRZETERMINOWANY!!";
	}
	
}








