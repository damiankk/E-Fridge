import java.util.List;

import javax.swing.table.AbstractTableModel;

/**
 * Model danych tablicy wyswietlajacej dane na temat przepisow i mozliwosci ich przyrzadzenia
 * @author Damian
 *
 */
public class MyTableModelprzep extends AbstractTableModel{
	private List<Przepis> contents;
	String[] columns = {"Nazwa potrawy","Czy mozliwe przyrzadzenie?", "Przepis"};
	
	public MyTableModelprzep(List<Przepis> contents){
		this.contents = contents;
	}
	
	@Override
	public int getColumnCount() {
		
		return 3;
	}

	@Override
	public int getRowCount() {
		
		return this.contents.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Przepis przep = contents.get(row);
		
		switch (col) {		//zwracamy kolejne parametry w zaleznosci od numeru kolumny
        case 0:
            return przep.nazwaprzepisu;
        case 1:
            return przep.czymozliwy;
        case 2:
            return przep.opisprzepisu;
        default:
            return null;
        }
	}
	
}
