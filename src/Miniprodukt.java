
public class Miniprodukt{
	String nazwa;
	double ilosc;
	/**
	 * Klasa miniprodukt odpowiada za tworzenie abstrakcyjnych obiektow umieszczonych w przepisach.
	 * Kazdy z obiektow klasy miniprodukt posiada nazwe oraz ilosc produktu w kilogramach.
	 * @param nazwa		Nazwa produktu
	 * @param ilosc		Ilosc produktu w kilogramach
	 */
	Miniprodukt(String nazwa, double ilosc){
		this.nazwa = nazwa;
		this.ilosc = ilosc;
		
	}
}