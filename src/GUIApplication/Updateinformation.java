package GUIApplication;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Updateinformation extends JFrame implements ActionListener {
	static connection_to_database conn;
	JTextField t1, t2 ,t3, t4;
	JButton b1, b2;
	JLabel lblImg;
	Updateinformation() {
		super("Update Information");
		setBounds(300, 200, 700, 400);
		setLayout(null);
		
		getContentPane().setBackground(new Color(255,255,204));
		ImageIcon imgUser=new ImageIcon(getClass().getResource("/icon/updated.png"));		
		Image imgResize =imgUser.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT);
		imgUser = new ImageIcon(imgResize);
		lblImg =new JLabel(imgUser);
		lblImg.setBounds(55, 70, 150, 200);
		add(lblImg);
		JLabel title = new JLabel("Update Customer Information");
		title.setFont(new Font("verdana", Font.PLAIN, 20));
		title.setBounds(200,10, 350, 30);
		add(title);
		
		JLabel l1 = new JLabel("Name");
		l1.setBounds(300, 70, 100, 20);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(370, 70, 200, 20);
		add(t1);
		
		JLabel l2 = new JLabel("Address");
		l2.setBounds(300, 110, 100, 20);
		add(l2);
		
		t2 = new JTextField();
		t2.setBounds(370, 110, 200, 20);
		add(t2);
		
		JLabel l3 = new JLabel("Phone");
		l3.setBounds(300, 150, 100, 20);
		add(l3);
		
		t3 = new JTextField();
		t3.setBounds(370, 150, 200, 20);
		add(t3);
		
		JLabel l4 = new JLabel("Book");
		l4.setBounds(300, 190, 100, 20);
		add(l4);
		
		t4 = new JTextField();
		t4.setBounds(370, 190, 200, 20);
		add(t4);
		
		b1 = new JButton("Update");
		b1.setBounds(300, 260, 100, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(430, 260, 100, 30);
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
				String sql = "update customer set Name=?, Address=?, Phone=? where Book=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, s1);
				ps.setString(2, s2);
				ps.setString(3, s3);
				ps.setString(4, s4);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Customer updated successfully");
				this.setVisible(false);
			} catch(Exception ex) {}
			
		} else if(e.getSource() == b2) {
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {
		conn = new connection_to_database();
		new Updateinformation().setVisible(true);
		
	}



}
