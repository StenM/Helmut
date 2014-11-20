package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BillRowTest {

  private SaleItem item1;
  
  /**
   * Methods with @Before annotations will be invoked before each test is run.
   */
  @Before
  public void setUp() {
    item1 = new SaleItem("Lauaviin", 3.50); 
  }

  @Test
  public void testRowSumWithZeroQuantity() {
    BillRow r = new BillRow(item1, 0);
    
    assertEquals(r.getRowPrice(), 0.0, 0.0001);
  }
  
  // TODO
  public void testRowSumWithoutDiscount() {}

  // TODO
  public void testRowSumWithDiscount() {}
  
  // TODO
  public void testRowSumWithInvalidDiscount() {}
  
  // TODO
  public void testRowSumWithNegativeQuantity() {}

  // TODO
  public void testRowSumWithNegativePrice() {}
  
}
