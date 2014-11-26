package ee.ut.math.tvt.salessystem.ui.model;

//import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.table.AbstractTableModel;

import ee.ut.math.tvt.salessystem.domain.data.DisplayableItem;

/**
 * Generic table model implementation suitable for extending.
 */
public abstract class SalesSystemTableModel<T extends DisplayableItem> extends
        AbstractTableModel {

    private static final long serialVersionUID = 1L;

    //protected List<T> rows; // Task 2. Refactoring: remove this line
    protected final String[] headers;

    public SalesSystemTableModel(final String[] headers) {
        this.headers = headers;
        //rows = new ArrayList<T>();
    }

    /**
     * @param item
     *            item describing selected row
     * @param columnIndex
     *            selected column index
     * @return value displayed in column with specified index
     */
    protected abstract Object getColumnValue(T item, int columnIndex);

    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public String getColumnName(final int columnIndex) {
        return headers[columnIndex];
    }

    public int getRowCount() {
        //return rows.size();
    	return this.getTableRows().size();
    }

    public Object getValueAt(final int rowIndex, final int columnIndex) {
        //return getColumnValue(rows.get(rowIndex), columnIndex);
    	return getColumnValue(this.getTableRows().get(rowIndex), columnIndex);
    }

    // search for item with the specified id
    public T getItemById(final long id) {
        //for (final T item : rows) {
    	for (final T item : this.getTableRows()) {
            if (item.getId() == id)
                return item;
        }
        throw new NoSuchElementException();
    }

//    public List<T> getTableRows() {
//        return rows;
//    }
    public abstract List<T> getTableRows();
    //public abstract void clear();

    public void clear() {
        this.getTableRows().clear(); //rows = new ArrayList<T>();
        fireTableDataChanged();
    }

    public void populateWithData(final List<T> data) {
        this.getTableRows().clear(); //rows.clear();
        //rows.addAll(data);
    	this.getTableRows().addAll(data);
    }
    
    public void addRow(T row) {
        //rows.add(row);
    	this.getTableRows().add(row);
        fireTableDataChanged();
    }
    
    public T getRow(int index) {
        //return rows.get(index);
    	return this.getTableRows().get(index);
    }
    
    public List<T> getRows() {
        //return rows;
        return this.getTableRows();
    }
    
}
