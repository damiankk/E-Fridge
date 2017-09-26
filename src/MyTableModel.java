import java.util.List;

import javax.swing.table.AbstractTableModel;
/**
 * model danych tablicy wyswietlajacej produkty z lodowki
 * @author Damian
 *
 */
class MyTableModel extends AbstractTableModel {
	
	private List<Produkt> contents;
	String [] columns = {"Nazwa produktu", "Data przydatnosci do spozycia", "Nieprzeterminowany?", "Ilosc produktu"};
	
	public MyTableModel(List<Produkt> contents){
		this.contents = contents;
	}
	
	
	
	
	@Override
	public int getRowCount(){
		return this.contents.size();
		
	}

	@Override
	public int getColumnCount() {
		
		return 4;
	}
	
	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		Produkt prod = contents.get(row);
			 
        switch (col) {		//zwracamy kolejne parametry w zaleznosci od numeru kolumny
        case 0:
            return prod.nazwa;
        case 1:
            return prod.dataprzyd;
        case 2:
            return prod.czyprzyd(prod);
        case 3:
        	return prod.ilosc;
        default:
            return null;
        }
		
	}
	
}