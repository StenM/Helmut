package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	
	private StockItem stock1;
	private SoldItem sold1;
	
	@Before
	public void setUp() {
		stock1 = new StockItem(0L, "Tere", "Piim", 10.5, 3);
		sold1 = new SoldItem(stock1, 2);
	  }

	
	@Test
    public void testGetSum(){
		assertEquals(sold1.getSum(), 21.00, 0.00001);
    	
    }
    
    // TODO
    public void testGetSumWithZeroQuantity(){
    	
    }
	
}
