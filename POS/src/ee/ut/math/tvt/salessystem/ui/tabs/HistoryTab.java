package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Component;

import javax.swing.JPanel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
    
    // TODO - implement!
	
	private Date DateOfOrder;
	private Time TimeOfOrder;
	private float TotalOrderPrice;

    public HistoryTab() {} 
    
    public Component draw() {
        JPanel panel = new JPanel();
        // TODO - Sales history tabel
        return panel;
    }
}