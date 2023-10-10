package GUIApplication;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login extends JFrame implements ActionListener {
	static connection_to_database conn;
	JLabel l1 , l2,l3,lblImage;
	JTextField t1,t2;
	Choice c1;
	JButton b1 , b2;
	JPasswordField pf1;
	login(){
		super("User Login");
		getContentPane().setBackground(new Color(204,204,204));
		ImageIcon imgUser=new ImageIcon(getClass().getResource("/icon/key.png"));		
		Image imgResize =imgUser.getImage().getScaledInstance(150, 180, Image.SCALE_DEFAULT);
		imgUser = new ImageIcon(imgResize);
		lblImage =new JLabel(imgUser);
		lblImage.setBounds(25, 120, 150, 200);
		add(lblImage);
		
		JLabel title = new JLabel("Bright Ideas Bookstore");
		title.setFont(new Font("bradley hand ITC", Font.PLAIN, 30));
		title.setBounds(170,35, 450, 40);
		add(title);
		
		l1=new JLabel("Enter Username");
		l1.setBounds(200, 120, 100, 20);
		add(l1);
		
		t1=new JTextField(15);
		t1.setBounds(320, 120, 150, 20);
		add(t1);
		
		l2=new JLabel("Enter Password");
		l2.setBounds(200, 180, 100, 20);
		add(l2);
		
		/*t2=new JTextField(15);
		t2.setBounds(320, 80, 150, 20);
		add(t2);*/
		
		pf1=new JPasswordField(15);
		pf1.setBounds(320, 180, 150, 20);
		add(pf1);
		
		
		
		l3=new JLabel("Login as :");
		l3.setBounds(200, 240, 100, 20);
		add(l3);
		
		c1=new Choice();
		c1.add("Choose User Type");
		c1.add("Admin");
		c1.add("User");
		c1.setBounds(320, 240, 150,20 );
		add(c1);
		
		b1 = new JButton("Sign In");
		b1.setBounds(240, 300, 80, 20);
		add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("Cancel");
		b2.setBounds(340, 300, 80, 20);
		add(b2);
		b2.addActionListener(this);
		
		
		setLayout(new BorderLayout());
		setSize(640,400 );
		setLocation(600, 300);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			try {
				
				Connection con=conn.getConnect();
				String a=t1.getText();
				
				String b=pf1.getText();
				String c=c1.getSelectedItem();
				String sql="Select * from lpu where username='"+a+"' and password='"+b+"' and usertype='"+c+"'";
				Statement s=con.createStatement();
				ResultSet rs=s.executeQuery(sql);
				if(rs.next()) {
					JOptionPane.showMessageDialog(null, "Successful");
					
					switch(c) {
					  case "Admin":
						  new Home().setVisible(true);
						  break;
					  case "User":
						  new User().setVisible(true);
						  break;}
					
					this.setVisible(false);
				}
				
			} catch (SQLException sle) {
				System.out.println(sle);
			}
		}
		else if (e.getSource()==b2) {
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
	conn = new connection_to_database()	;
	new login().setVisible(true);

	}
	

}
