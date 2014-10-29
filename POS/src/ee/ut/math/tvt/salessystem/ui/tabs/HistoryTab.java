package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;
import java.sql.Time;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {

	private SalesSystemModel model;
	private JPanel panel;
	private Date DateOfOrder;
	private Time TimeOfOrder;
	private float TotalOrderPrice;
	
	public HistoryTab(){
		
	}
	
	public HistoryTab(SalesSystemModel model) {
	    this.model = model;
	  }
    
    public Component draw() {
        panel = new JPanel();
        //panel.add(drawHistoryPane());
        return panel;
    }
    

	public Component drawHistoryPane() {
	    panel = new JPanel();

	    JTable table = new JTable(model.getCurrentPurchaseTableModel());

	    JTableHeader header = table.getTableHeader();
	    header.setReorderingAllowed(false);

	    JScrollPane scrollPane = new JScrollPane(table);
	    
		return panel;
	}
}