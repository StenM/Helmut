package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

public class PaymentWindow {

	private static final Logger log = Logger.getLogger(PaymentWindow.class);
	private SalesSystemModel model;
	private JFrame paymentFrame;

	private JPanel[][] panelHolder;
	private JButton acceptButton;
	private JButton declineButton;
	private JButton enterButton;
	private JTextField paymentField;
	private JLabel returnField;
	private boolean paymentAcceptable = false;

	public PaymentWindow(SalesSystemModel model) {

		this.model = model;

		paymentFrame = new JFrame("Payment details");
		panelHolder = new JPanel[4][4];
		paymentFrame.setLayout(new GridLayout(4, 4));

		for (int m = 0; m < 4; m++) {
			for (int n = 0; n < 4; n++) {
				panelHolder[m][n] = new JPanel();
				paymentFrame.add(panelHolder[m][n]);
			}
		}

		// http://stackoverflow.com/questions/2510159/can-i-add-a-component-to-a-specific-grid-cell-when-a-gridlayout-is-used
		Dimension panelSize = new Dimension(500, 400);
		Dimension genericSize = new Dimension(100, 30);

		paymentFrame.setPreferredSize(panelSize);
		panelHolder[0][1].setBorder(new EmptyBorder(30, 0, 0, 0));
		panelHolder[0][2].setBorder(new EmptyBorder(30, 0, 0, 0));

		acceptButton = new JButton("Accept"); // this button should close the
												// frame and return true for
												// submitPurchaseButtonClicked()
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					acceptButtonClicked();
				} catch (VerificationFailedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		declineButton = new JButton("Decline"); // this button should close the
												// frame and return false for
												// submitPurchaseButtonClicked()
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

		for (int i = 0; i < current.getRowCount(); i++) {
			sum = sum + (double) current.getValueAt(i, 4);
		}

		return sum;
	}

	private void acceptButtonClicked() throws VerificationFailedException {
		if (paymentAcceptable){
			model.getDomainController().submitCurrentPurchase(model.getCurrentPurchaseTableModel().getTableRows());
			List<SoldItem> sold = model.getCurrentPurchaseTableModel().getTableRows();
			double currentcost = 0;
			for (SoldItem s : sold){
				double cost = s.getSum();
				currentcost = currentcost + cost;			
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String currentdate = dateFormat.format(date);
			String currenttime = timeFormat.format(date);
			int saleId = model.getHistoryTableModel().getRowCount();
			HistoryItem history = new HistoryItem(saleId, currentdate, currenttime, currentcost);
			model.getHistoryTableModel().addItem(history);	
			model.getDomainController().addHistoryItemToDatabase(history);
			log.info("Sale complete");
			model.getCurrentPurchaseTableModel().clear();
			paymentFrame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(new Frame(), "Paid amount should not be smaller than total cost!");
			paymentField.setText("0.0");
		}
	}



	private void enterButtonClicked() {
		try {
			String paymentString = paymentField.getText();
			double paid = Double.parseDouble(paymentString);
			double sum = getSum();
			if (paid >= sum) {
			returnField.setText((new DecimalFormat("#.##").format(paid - sum)));
			paymentAcceptable = true;
			}
			else {
				JOptionPane.showMessageDialog(new Frame(), "Paid amount should not be smaller than total cost!");
				paymentField.setText("0.0");
				paymentAcceptable = false;
			}
		} catch (NumberFormatException ex) {
			paymentAcceptable = false;
			paymentField.setText("0.0");
		}
	}

	private void declineButtonClicked() {
		paymentFrame.setVisible(false);
	}

	public boolean isPaymentAccepted() {
		return paymentAcceptable;
	}

	public void setPaymentFrame(JFrame paymentFrame) {
		this.paymentFrame = paymentFrame;
	}
}
