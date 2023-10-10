package GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Home extends JFrame implements ActionListener{

	
	Home(){
		super("Admin");
		getContentPane().setBackground(Color.WHITE);
		setSize(1900,850);
		ImageIcon imgUser=new ImageIcon(getClass().getResource("/icon/homebookstore.jpg"));		
		Image imgResize =imgUser.getImage().getScaledInstance(1700, 800, Image.SCALE_DEFAULT);
		ImageIcon imgUser2 = new ImageIcon(imgResize);
		JLabel lblImage =new JLabel(imgUser2);
		add(lblImage);
		
		JMenuBar mb=new JMenuBar();
		
		JMenu master=new JMenu("Master");
		JMenuItem m1=new JMenuItem("New Customer");
		JMenuItem m2=new JMenuItem("Customer Details");
		m1.addActionListener(this);
		m2.addActionListener(this);
		
		master.add(m1);
		master.add(m2);
		mb.add(master);
		
		JMenu user=new JMenu("User");
		JMenuItem m2_1=new JMenuItem("Update");
		
		m2_1.addActionListener(this);
		
		user.add(m2_1);
		
		mb.add(user);
		
		JMenu info=new JMenu("Information");
		JMenuItem m3_1=new JMenuItem("Search");
		m3_1.addActionListener(this);
		
		info.add(m3_1);
		mb.add(info);
		
		JMenu exit=new JMenu("Logout");
		JMenuItem m4_1=new JMenuItem("Exit");
		m4_1.addActionListener(this);
		exit.add(m4_1);
		mb.add(exit);
		
		setJMenuBar(mb);
		setLayout(new FlowLayout());
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String status=e.getActionCommand();
		System.out.println(status);
		if(status.equals("New Customer")) {
			this.setVisible(false);
			new Newcustomer().setVisible(true);
		}
		else if(status.equals("Exit")) {
			this.setVisible(false);
			new login().setVisible(true);
		}
		else if(status.equals("Search")) {
			this.setVisible(false);
			new Search().setVisible(true);
		}
		else if(status.equals("Update")) {
			new Updateinformation().setVisible(true);
	}
		else if(status.equals("Customer Details")) {
			this.setVisible(false);
			new Customerdetails().setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		

		new Home().setVisible(true);
	}

	

}
