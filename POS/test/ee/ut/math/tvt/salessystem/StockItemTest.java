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
	public void testGetColumn() {
		assertEquals(stock1.getColumn(0), 0L);
		assertEquals(stock1.getColumn(1), "Tere");
		assertEquals(stock1.getColumn(2), "Piim");
		assertEquals(stock1.getColumn(3), 10.5);
		assertEquals(stock1.getColumn(4), 1);
	}

	@Test
	public void testClone() {
		assertEquals(stock1.clone().getName(), stock1.getName());
		assertEquals(stock1.clone().getId(), stock1.getId());
		assertEquals(stock1.clone().getDescription(), stock1.getDescription());
		assertEquals(stock1.clone().getName(), stock1.getName());
		assertEquals(stock1.clone().getPrice(), stock1.getPrice(), 0.001);
		assertEquals(stock1.clone().getQuantity(), stock1.getQuantity());
	}
	
	@Test
	public void testStockItemToString() {
		assertEquals(stock1.toString(), "0 Tere Piim 10.5");
	}
	
}
