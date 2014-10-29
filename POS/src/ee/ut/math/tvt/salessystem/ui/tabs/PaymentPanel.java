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

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class PaymentPanel{

    private SalesSystemModel model;

public PaymentPanel(SalesSystemModel model) {
	
	  this.model = model;
	  
	  JFrame paymentFrame = new JFrame("Payment details");
	  JPanel[][] panelHolder = new JPanel[4][4];    
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
	  
	  JButton acceptButton = new JButton("Accept");  //this button should close the frame and return true for submitPurchaseButtonClicked()
	  acceptButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        acceptButtonClicked();
	      }

		private void acceptButtonClicked() {
			// TODO Auto-generated method stub
			
		}
	    });
	  JButton declineButton = new JButton("Decline"); //this button should close the frame and return false for submitPurchaseButtonClicked()
	  declineButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        declineButtonClicked();
	      }

		private void declineButtonClicked() {
			// TODO Auto-generated method stub
			
		}
	    });
	  JButton enterButton = new JButton("Enter payment");
	  declineButton.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        enterButtonClicked();
	      }
	      private void enterButtonClicked() {
				//String value = paymentField;
			}
	    });
	  
	  JTextField paymentField = new JTextField();
	  JLabel totalSum = new JLabel(Double.toString(getSum()));

	  
	  paymentField.setPreferredSize(genericSize);
	  acceptButton.setPreferredSize(genericSize);
	  declineButton.setPreferredSize(genericSize);
	  enterButton.setPreferredSize(genericSize);
	  
	  panelHolder[0][1].add(new JLabel("Total sum:"));
	  panelHolder[0][2].add(totalSum);
	  panelHolder[1][1].add(enterButton);
	  panelHolder[1][2].add(paymentField);
	  panelHolder[2][1].add(new JLabel("Return amount:"));
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
}