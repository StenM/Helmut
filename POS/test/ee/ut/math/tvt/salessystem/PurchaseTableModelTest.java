package ee.ut.math.tvt.salessystem;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseTableModelTest {
	
	private PurchaseInfoTableModel purchaseTable;
	private SoldItem sold1;
	private StockItem stock1;

	@Before
	public void setUp() {
		stock1 = new StockItem(0L, "Tere", "Piim", 10.5, 1);
		sold1 = new SoldItem(stock1, 2);
		purchaseTable = new PurchaseInfoTableModel();
		
	  }
	

	@Test
    public void testAddSoldItem(){
    	purchaseTable.addItem(sold1);
    	
    }
	// TODO
    public void testGetSumWithNoItems(){
    	
    }
 // TODO
    public void testGetSumWithOneItem(){
    	
    }
 // TODO
    public void testGetSumWithMultipleItems(){
    	
    }
    

}
