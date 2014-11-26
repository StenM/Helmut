package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	
	private StockItem stock1;

	
	@Before
	public void setUp() {
		stock1 = new StockItem(0L, "Tere", "Piim", 10.5, 1);
	  }

	@Test
    public void testGetColumn(){
		assertEquals(stock1.getColumn(1), "Tere"); 
    }
	
	// TODO
    public void testClone(){
    	
    }
    
    
	

}
