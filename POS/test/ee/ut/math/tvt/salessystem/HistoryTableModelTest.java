package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;

public class HistoryTableModelTest {
	
	private HistoryTableModel historyTable;
	private HistoryItem historyItem;
	
	@Before
	public void setUp() {
		historyItem = new HistoryItem(1, "2014-10-11", "19:30", 2.50);
		historyTable = new HistoryTableModel();
	  }
	
	@Test
    public void testAddItem(){
    	historyTable.addItem(historyItem);
    	assertEquals(historyTable.getTableRows().contains(historyItem), true);
    }
	
	@Test
    public void testGetItemById(){
    	historyTable.addItem(historyItem);
    	assertEquals(historyTable.getItemById(1L), historyItem);    	 	
    }

}
