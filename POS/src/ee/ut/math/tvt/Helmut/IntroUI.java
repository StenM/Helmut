package ee.ut.math.tvt.Helmut;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

public class IntroUI extends JFrame{
	
	private JLabel TeamName;
	private JLabel TeamLeader;
	private JLabel TeamLeaderMeil;
	private JLabel Members;
	private JLabel Member1;
	private JLabel Member2;
	private JLabel Member3;
	private ImageIcon Image;
	private JLabel Logo;
	private JLabel Version;
	
	private String appProp = "./application.properties";
	
	// http://docs.oracle.com/javase/tutorial/essential/environment/properties.html	
	protected String getValueFromProperties(String filename, String key) {
		String value = null;
		try {
			Properties props = new Properties();
			FileInputStream file = new FileInputStream(filename);
			
			// load all the properties from the file
			props.load(file);
			
			file.close();
			
			// get the value for the key
			value = props.getProperty(key);
			
		} catch (Exception e) {
		}
	
		return value;
	}
	
	// http://www.datadisk.co.uk/html_docs/java/layout_managers.htm
	// http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html	
	public IntroUI() {
		super("IntroUI"); // TODO: understand "super" better
		try {
		
			setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 1.0;
			c.weighty = 1.0;
			
			TeamName = new JLabel("Team name: " + this.getValueFromProperties(appProp, "Team name"));
			c.gridx = 0;
			c.gridy = 0;
			add(TeamName, c);
			
			TeamLeader = new JLabel("Team leader: " + this.getValueFromProperties(appProp, "Team leader"));
			c.gridx = 0;
			c.gridy = 1;
			add(TeamLeader, c);
			
			TeamLeaderMeil = new JLabel("Team leader email: " + this.getValueFromProperties(appProp, "Team leader email"));
			c.gridx = 0;
			c.gridy = 2;
			add(TeamLeaderMeil, c);
			
			Members = new JLabel("Team members: ");
			c.gridx = 0;
			c.gridy = 3;
			add(Members, c);
			
			Member1 = new JLabel(this.getValueFromProperties(appProp, "Member1"));
			c.gridx = 0;
			c.gridy = 4;
			add(Member1, c);
			
			Member2 = new JLabel(this.getValueFromProperties(appProp, "Member2"));
			c.gridx = 0;
			c.gridy = 5;
			add(Member2, c);
			
			Member3 = new JLabel(this.getValueFromProperties(appProp, "Member3"));
			c.gridx = 0;
			c.gridy = 6;
			add(Member3, c);
			
			// http://aviatstudios.com/wp-content/uploads/2013/01/vintageBeerAds36-540x394.jpg
			// TODO: Kas pilt väiksemaks?
			Image = new ImageIcon(this.getValueFromProperties(appProp, "Logo"));
			Logo = new JLabel(Image);
			c.gridx = 1;
			c.gridy = 0;
			c.gridheight = 8;
			add(Logo, c);			
			
			setSize(800, 500);
			setVisible(true);
		
		} catch (Exception e) {
			
		}
		
	}
	

}
