package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class PaymentWindow{
	
	private static final Logger log = Logger.getLogger(PaymentWindow.class);
    private SalesSystemModel model;
    private JFrame paymentFrame;

	private JPanel[][] panelHolder;
    private JButton acceptButton;
    private JButton declineButton;
    private JButton enterButton;
    private JTextField paymentField;
    private JLabel returnField;
    private boolean paymentAccepted;

public PaymentWindow(SalesSystemModel model) {
	
	  this.model = model;
	  
	  paymentFrame = new JFrame("Payment details");
	  panelHolder = new JPanel[4][4];    
	  paymentFrame.setLayout(new GridLayout(4,4));

	  for(int m = 0; m < 4; m++) {
	     for(int n = 0; n < 4; n++) {
	        panelHolder[m][n] = new JPanel();
	        paymentFrame.add(panelHolder[m][n]);
	     }
	  }

	  //http://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
	  Dimension panelSize = new Dimension(500,400);
	  Dimension genericSize = new Dimension(100,30);
	  
	  paymentFrame.setPreferredSize(panelSize);
	  panelHolder[0][1].setBorder(new EmptyBorder(30, 0, 0, 0));
	  panelHolder[0][2].setBorder(new EmptyBorder(30, 0, 0, 0));
	  
	  acceptButton = new JButton("Accept");  //this button should close the frame and return true for submitPurchaseButtonClicked()
	  acceptButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        acceptButtonClicked();
	      }
	      
	    });
	  declineButton = new JButton("Decline"); //this button should close the frame and return false for submitPurchaseButtonClicked()
	  declineButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        declineButtonClicked();
	      }

	    });
	  enterButton = new JButton("Enter payment");
	  enterButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        enterButtonClicked();
	      }
	      
	    });
	  
	  paymentField = new JTextField();
	  paymentField.setEditable(true);
	  JLabel totalSum = new JLabel(Double.toString(getSum()));
	  returnField = new JLabel("0.0");


	  
	  paymentField.setPreferredSize(genericSize);
	  acceptButton.setPreferredSize(genericSize);
	  declineButton.setPreferredSize(genericSize);
	  enterButton.setPreferredSize(genericSize);
	  
	  panelHolder[0][1].add(new JLabel("Total sum:"));
	  panelHolder[0][2].add(totalSum);
	  panelHolder[1][1].add(enterButton);
	  panelHolder[1][2].add(paymentField);
	  panelHolder[2][1].add(new JLabel("Return amount:"));
	  panelHolder[2][2].add(returnField);
	  panelHolder[3][1].add(acceptButton);
	  panelHolder[3][2].add(declineButton);

	  
    paymentFrame.pack();
    paymentFrame.setVisible(true);
    
}


private double getSum() {
	double sum = 0;
	PurchaseInfoTableModel current = model.getCurrentPurchaseTableModel();
	
	for (int i=0; i < current.getRowCount(); i++){
	sum = sum + (double) current.getValueAt(i, 4);
	}
	
	return sum;
	}

private void acceptButtonClicked() {
	System.out.println("Should save the payment to history");
    paymentAccepted = true;
    model.getCurrentPurchaseTableModel().clear();
    log.info("Sale complete");
    paymentFrame.dispose();
}


private void enterButtonClicked() {
	  try{
	  String paymentString = paymentField.getText();
	  double paid = Double.parseDouble(paymentString);
	  double sum = getSum();
	  returnField.setText(Double.toString(paid-sum));}
	  catch (NumberFormatException ex){
		  paymentField.setText("0.0");
	  }
	}

private void declineButtonClicked() {
	paymentFrame.setVisible(false);
}

public boolean isPaymentAccepted() {
	return paymentAccepted;
}

public void setPaymentFrame(JFrame paymentFrame) {
	this.paymentFrame = paymentFrame;
}

}

