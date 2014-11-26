package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseTableModelTest {
	
	private PurchaseInfoTableModel purchaseTable;
	private SoldItem sold1;
	private StockItem stock1;
	private SoldItem sold2;

	@Before
	public void setUp() {
		stock1 = new StockItem(0L, "Tere", "Piim", 10.5, 1);
		sold1 = new SoldItem(stock1, 2);
		sold2 = new SoldItem(stock1, 5);
		purchaseTable = new PurchaseInfoTableModel();
		
	  }
	

	@Test
    public void testAddSoldItem(){
    	purchaseTable.addItem(sold1);
    	assertEquals(purchaseTable.getTableRows().get(0), sold1);
    }
	
	@Test
    public void testGetSumWithNoItems(){
    	assertEquals(purchaseTable.getSum(), 0.0, 0.001);
    	
    }
	@Test
    public void testGetSumWithOneItem(){
		purchaseTable.addItem(sold1);
		assertEquals(purchaseTable.getSum(), sold1.getPrice()*sold1.getQuantity(), 0.001);
    	
    }
 	@Test
    public void testGetSumWithMultipleItems(){
    	purchaseTable.addItem(sold1);
    	purchaseTable.addItem(sold2);
    	double correct = sold1.getPrice()*sold1.getQuantity()+sold2.getPrice()*sold2.getQuantity();
    	assertEquals(purchaseTable.getSum(), correct, 0.001);
    	
    }
    

}
