package GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class User extends JFrame implements ActionListener{
	
	static connection_to_database conn;
	String x[] = {"Book Name","Author","Launch Year"};
	String y[][] = new String[40][10];
	int i=0,j=0;
	JTable t1;
	
	User(){
		super("User");
		getContentPane().setBackground(Color.WHITE);
		setSize(1900,830);
	
		ImageIcon imgUser=new ImageIcon(getClass().getResource("/icon/bookstore.jpg"));		
		Image imgResize =imgUser.getImage().getScaledInstance(1900, 830, Image.SCALE_DEFAULT);
		ImageIcon imgUser2 = new ImageIcon(imgResize);
		JLabel lblImage =new JLabel(imgUser2);
		add(lblImage);
		
		JMenuBar mb=new JMenuBar();
		
		JMenu books=new JMenu("Aaailable");
		JMenuItem m1=new JMenuItem("Available Books");
		
		m1.addActionListener(this);
		
		
		books.add(m1);
		
		mb.add(books);
		
		JMenu upcom=new JMenu("Upcomming");
		JMenuItem m2_1=new JMenuItem("Upcomming Books");
		
		m2_1.addActionListener(this);
		
		upcom.add(m2_1);
		
		mb.add(upcom);
		
				
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
		if(status.equals("Available Books")) {
			
			new Available().setVisible(true);
			this.setVisible(false);
			
		}
		else if(status.equals("Exit")) {
			this.setVisible(false);
			new login().setVisible(true);
		}
		else if(status.equals("Upcomming Books")) {
			
			new Upcomming().setVisible(true);
			this.setVisible(false);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		

		
		new User().setVisible(true);
	}

	

}
