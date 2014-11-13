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
public class HistoryTableModel extends SalesSystemTableModel<HistoryItem> {
	

	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(HistoryTableModel.class);

	
	public HistoryTableModel() {
		super(new String[] { "Id", "Date", "Time", "Sum" });
	}

	
	@Override
	protected Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getDate();
		case 2:
			return item.getTime();
		case 3:
			return item.getTotal();
		}
		throw new IllegalArgumentException("Column index out of range");
	}
	
	public void addItem(final HistoryItem historyItem) {
		/*try {
			StockItem item = getItemById(stockItem.getId());
			item.setQuantity(item.getQuantity() + stockItem.getQuantity());
			log.debug("Found existing item " + stockItem.getName()
					+ " increased quantity by " + stockItem.getQuantity());
		} catch (NoSuchElementException e) {
		*/
		rows.add(historyItem);
		log.debug("Added " + historyItem.getId() + " sum of "
					+ historyItem.getTotal());
		fireTableDataChanged();
	}

	
	/**
	 * Add new stock item to table. If there already is a stock item with same
	 * id, then existing item's quantity will be increased.
	 * 
	 * @param stockItem
	 */
	
	


	
	}

