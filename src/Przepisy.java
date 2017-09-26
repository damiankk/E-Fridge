import java.util.LinkedList;
import java.util.List;
/**
 * Zawiera kolekcjê przepisów
 * @author Damian
 *
 */
public class Przepisy {
	public List<Przepis> przepisy = new LinkedList<Przepis>();
	
	/**
	 * dodawanie przepisu do listy przepisow
	 * @param p1
	 */
	public void addto(Przepis p1){
		przepisy.add(p1);
		
	}
}
