package ee.ut.math.tvt.salessystem.domain.data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Stock item. Corresponds to the Data Transfer Object design pattern.
 */
@Entity
@Table(name = "HISTORYITEM")
public class HistoryItem implements DisplayableItem{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(name = "DATE")
    private String date;
	@Column(name = "TIME")
    private String time;
    
	@Column(name = "TOTAL")
    private double total;


	/**
	 * Constucts new <code>StockItem</code> with the specified values.
	 * 
	 * @param id
	 *            barcode id
	 * @param name
	 *            name of the product
	 * @param desc
	 *            description of the product
	 * @param price
	 *            price of the product
	 */
	



	/**
	 * Constructs new <code>StockItem</code>.
	 */
	

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String toString() {
		return id + " " + date + " " + time + " " + total;
	}

	/**
	 * Method for querying the value of a certain column when StockItems are
	 * shown as table rows in the SalesSstemTableModel. The order of the columns
	 * is: id, name, price, quantity.
	 */
	public Object getColumn(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return id;
		case 1:
			return date;
		case 2:
			return time;
		case 3:
			return new Double(total);
		default:
			throw new RuntimeException("invalid column!");
		}
	}
/*
	public Object clone() {
		StockItem item = new StockItem(getId(), getName(), getDescription(),
				getPrice(), getQuantity());
		return item;
	}*/

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}



}
