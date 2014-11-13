package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

/**
 * History table model.
 */
public class HistoryTableModel extends SalesSystemTableModel<StockItem> {
	

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(HistoryTableModel.class);

	
	public HistoryTableModel() {
		super(new String[] { "Date", "Time", "Sum" });
	}

	
	@Override
	protected Object getColumnValue(StockItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	public void addItem(SoldItem s) {
		System.out.println("Add item @ HistoryTableModel");
	}

	
	/**
	 * Add new stock item to table. If there already is a stock item with same
	 * id, then existing item's quantity will be increased.
	 * 
	 * @param stockItem
	 */
	
	


	
	}

