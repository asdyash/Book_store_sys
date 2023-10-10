package GUIApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Search extends JFrame implements ActionListener {
	static connection_to_database conn;
	JTextField t1, t2 ,t3, t4;
	JButton b1, b2;
	
	Search() {
		super("Search");
		setBounds(300, 200, 500, 400);
		setLayout(null);
		getContentPane().setBackground(new Color(255,255,204));
		
		JLabel title = new JLabel("Search Customer");
		title.setFont(new Font("verdana", Font.PLAIN, 20));
		title.setBounds(100,10, 350, 30);
		add(title);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(50, 70, 100, 20);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(120, 70, 200, 20);
		add(t1);
		
		JLabel l2 = new JLabel("Address");
		l2.setBounds(50, 110, 100, 20);
		add(l2);
		
		t2 = new JTextField();
		t2.setBounds(120, 110, 200, 20);
		add(t2);
		
		JLabel l3 = new JLabel("Phone");
		l3.setBounds(50, 150, 100, 20);
		add(l3);
		
		t3 = new JTextField();
		t3.setBounds(120, 150, 200, 20);
		add(t3);
		
		JLabel l4 = new JLabel("Book");
		l4.setBounds(50, 190, 100, 20);
		add(l4);
		
		t4 = new JTextField();
		t4.setBounds(120, 190, 200, 20);
		add(t4);
		
		b1 = new JButton("Search");
		b1.setBounds(100, 260, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(230, 260, 100, 30);
		b2.addActionListener(this);
		add(b2);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String s1 = t1.getText();
			String s2 = t2.getText();
			String s3 = t3.getText();
			String s4 = t4.getText();
			
			
			try {
				conn = new connection_to_database();
				Connection con = conn.getConnect();
				
				String sql="Select * from customer where Name='"+s1+"' and Address='"+s2+"' and Phone='"+s3+"' and Book='"+s4+"'";
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sql);
				
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Record Found");
					this.setVisible(false);
					new Home().setVisible(true);
				}
			} catch(Exception ex) {}
			
		} else if(e.getSource() == b2) {
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
		conn = new connection_to_database();
		new Search().setVisible(true);
		
	}



}
