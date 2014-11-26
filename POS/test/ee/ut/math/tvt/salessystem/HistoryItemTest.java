package ee.ut.math.tvt.salessystem;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryItemTest {
	private HistoryItem history1;
	private StockItem stock1;

	@Before
	public void setUp() {
		history1 = new HistoryItem(1, "26.11.2014", "19.12", 2.50);
	}
	@Test
	public void testGetColumn() {		
		assertEquals(history1.getColumn(1), "26.11.2014");
		assertEquals(history1.getColumn(2), "19.12");
		assertEquals(history1.getColumn(3), 2.50);

	}
	@Test
	public void testToString() {
		assertEquals(history1.toString(),"1 26.11.2014 19.12 2.5");
	}
}