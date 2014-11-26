package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;



import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {
	
	private StockTableModel model1;
	private StockItem item1;
	private StockItem item2;
	private StockTableModel model0;
	
	@Before
	public void setUp() {
		model0 = new StockTableModel();
	    model1 = new StockTableModel(); 
	    item1 = new StockItem(0L, "Tere", "Piim", 10.5, 1);
	    item2 = new StockItem(0L, "Tere", "Vesi", 10.5, 1);
	  }
	

    
    @Test
    public void testValidateNameUniqueness(){
    	//tests if an item with the same name already exists it is not added on a new row
    	assertEquals(0, model0.getRowCount(), 0.001);
    	model1.addItem(item1);
    	model1.addItem(item2);
    	assertEquals(1, model1.getRowCount(), 0.001);
    }
    
    @Test
    public void testHasEnoughInStock(){
    	model0.addItem(item1);
    	assertEquals(false, model0.hasEnoughInStock(item1, 5));
    	assertEquals(true, model0.hasEnoughInStock(item1, 1));   	
    }
    
    @Test
    public void testGetItemByIdWhenItemExists(){
    	model0.addItem(item1);
    	assertEquals(model0.getItemById(0), item1);	
    }
    
    
    @Test(expected=NoSuchElementException.class)
    public void testGetItemByIdWhenThrowsException(){
    	model0.getItemById(999);
    }
}
