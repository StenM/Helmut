package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

public class StockTab {
	
  private static final Logger log = Logger.getLogger(PurchaseTab.class);

  private JButton addItem;

  private SalesSystemModel model;
  private final SalesDomainController domainController;

  public StockTab(SalesDomainController controller, SalesSystemModel model) {
	  this.domainController = controller;
    this.model = model;
  }

  // warehouse stock tab - consists of a menu and a table
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

    panel.add(drawStockMenuPane(), gc);

    gc.weighty = 1.0;
    gc.fill = GridBagConstraints.BOTH;
    panel.add(drawStockMainPane(), gc);
    return panel;
  }

  // warehouse menu
  private Component drawStockMenuPane() {
    JPanel panel = new JPanel();

    GridBagConstraints gc = new GridBagConstraints();
    GridBagLayout gb = new GridBagLayout();

    panel.setLayout(gb);

    gc.anchor = GridBagConstraints.NORTHWEST;
    gc.weightx = 0;
    
    // Initialize the button
    addItem = createNewAddButton();

    gc.gridwidth = GridBagConstraints.RELATIVE;
    gc.weightx = 1.0;
    panel.add(addItem, gc);

    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return panel;
  }

  // Creates the button "Add"
  private JButton createNewAddButton() {
    JButton b = new JButton("Add");
    b.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addButtonClicked();
      }
    });

    return b;
  }
  
  /* === Event handlers for the menu buttons
   *     (get executed when the buttons are clicked)
   */

  /** Event handler for the <code>add</code> event. */
  protected void addButtonClicked() {
    log.info("Adding new item to stock started");
    try {
    	//startingStock = model.getWarehouseTableModel();
    	//domainController.startNewPurchase();
        //startNewSale();
    	System.out.println("addButton");
    	addNewItem();
    //} catch (VerificationFailedException e1) {
    } catch (Exception e1) {
      log.error(e1.getMessage());
    }
  }
  
  private void addNewItem() {
	  
	  StockItem item = new StockItem();
	  
	  JPanel panel = new JPanel();
	  panel.setLayout(new GridLayout(3, 2));
      panel.setBorder(BorderFactory.createTitledBorder("New product"));
      
      // Initialize the textfields
      JTextField nameField = new JTextField();
      JTextField amountField = new JTextField();
      JTextField priceField = new JTextField();

      // == Add components to the panel

      // - bar code
      panel.add(new JLabel("Name:"));
      panel.add(nameField);

      // - amount
      panel.add(new JLabel("Amount:"));
      panel.add(amountField);

      // - price
      panel.add(new JLabel("Price:"));
      panel.add(priceField);

	    int result = JOptionPane.showConfirmDialog(null, panel, "Add new product", JOptionPane.OK_CANCEL_OPTION);
	    System.out.println(result);
	    
	    if (result == JOptionPane.OK_OPTION) {
	    	item.setName(nameField.getText());
	    	item.setQuantity(Integer.parseInt(amountField.getText()));
	    	item.setPrice(Double.parseDouble(amountField.getText()));
	    }
	    
	        // get the number of rows, to find the new ID
	        int nrRows = model.getWarehouseTableModel().getRowCount();
	        Object newId = model.getWarehouseTableModel().getValueAt(nrRows - 1, 0);

	        item.setId(((long) newId) + 1);
	        //domainController.addItemToStock(item);


  }
  
  // table of the warehouse stock
  private Component drawStockMainPane() {
    JPanel panel = new JPanel();

    JTable table = new JTable(model.getWarehouseTableModel());

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

    panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
    return panel;
  }

}
