package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.Time;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

import java.util.Date;
import java.sql.Time;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {

	// TODO - implement!


	private JPanel panel;
	private Date DateOfOrder;
	private Time TimeOfOrder;
	private float TotalOrderPrice;
	private SalesSystemModel model;
	




	public HistoryTab() {

	}

	public HistoryTab(SalesDomainController controller, SalesSystemModel model) {
		this.model = model;
		
	}


	
	public Component draw() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		panel.setLayout(gb);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.weightx = 1.0d;
		gc.weighty = 0d;

		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.BOTH;
		panel.add(drawHistoryPane(), gc);
		return panel;
	}


	
	private Component drawHistoryPane() {
		JPanel panel = new JPanel();
		
		
		// Create some data
		
		JTable table = new JTable(model.getHistoryTableModel());

		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		panel.setLayout(gb);
		panel.add(scrollPane, gc);

		panel.setBorder(BorderFactory.createTitledBorder("History of sales"));
		return panel;
	}
}
