package GUIApplication;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Newcustomer extends JFrame implements ActionListener  {

	JLabel l1,l2,l21,l3,l4,l5,lblImg,l6;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2;
	static connection_to_database conn;
	PreparedStatement ps=null;
	
	public void initWidget() {
		
	}
	 Newcustomer() {
	super("Create New Customer");
	
	initWidget();
	setLayout(new BorderLayout());
	setSize(640,400 );
	setLocation(400, 150);
	
	
	JPanel panel=new JPanel();
	panel.setLayout(null);
	panel.setBackground(Color.WHITE);
	panel.setBackground(new Color(255,255,204));
	
	JLabel title=new JLabel("New Customer");
	title.setBounds(180,10,200,26);
	title.setFont(new Font("Verdana",Font.BOLD,20));
	panel.add(title);
	
	
	setLayout(new BorderLayout());
	add(panel,"Center");
	
	l1=new JLabel("Name");
	l1.setBounds(100, 80, 100, 20);
	panel.add(l1);
	
	t1=new JTextField(15);
	t1.setBounds(170, 80, 200, 20);
	panel.add(t1);
	
	l2=new JLabel("Bill No.");
	l2.setBounds(100, 120, 100, 20);
	panel.add(l2);
	
	l21=new JLabel();
	l21.setBounds(170, 120, 200, 20);
	panel.add(l21);
	Random ran=new Random();
	long first=(ran.nextLong()%1000000);
	l21.setText(""+Math.abs(first));
	
	l3=new JLabel("Address");
	l3.setBounds(100, 160, 100, 20);
	panel.add(l3);
	
	t3=new JTextField(15);
	t3.setBounds(170, 160, 200, 20);
	panel.add(t3);
	
	l4=new JLabel("Phone No.");
	l4.setBounds(100, 200, 100, 20);
	panel.add(l4);
	
	t4=new JTextField(15);
	t4.setBounds(170, 200, 200, 20);
	panel.add(t4);
	
	l5=new JLabel("Book");
	l5.setBounds(100, 240, 100, 20);
	panel.add(l5);
	
	t5=new JTextField(15);
	t5.setBounds(170, 240, 200, 20);
	panel.add(t5);
	
	
	
	b1 = new JButton("Save");
	b1.setBounds(130,300,80,20);
	panel.add(b1);
	
	b2 = new JButton("Cancel");
	b2.setBounds(250,300,80,20);
	panel.add(b2);
	b1.addActionListener(this);
	b2.addActionListener(this);
	
	ImageIcon ic1=new ImageIcon(getClass().getResource("/icon/newcustomer image.jpg"));		
	Image i1 =ic1.getImage().getScaledInstance(150, 600, Image.SCALE_DEFAULT);
	ImageIcon ic2 = new ImageIcon(i1);
	lblImg =new JLabel(ic2);
	add(lblImg,"West");
	getContentPane().setBackground(Color.WHITE);
	setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String Name=t1.getText();
			String Bill=l21.getText();
			String Address=t3.getText();
			String Phone=t4.getText();
			String Book=t5.getText();
			
			String sql="insert into customer(Name,Bill,Address,Phone,Book) values(?,?,?,?,?)";
			try {
				conn = new connection_to_database()	;
				Connection con=conn.getConnect();
				ps=con.prepareStatement(sql);
				ps.setString(1, Name);
				ps.setString(2, Bill);
				ps.setString(3, Address);
				ps.setString(4, Phone);
				ps.setString(5, Book);
				ps.execute();
				JOptionPane.showMessageDialog(null, "Customer created successfully");
				t1.setText("");
				l21.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
			new Home().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		conn = new connection_to_database()	;
		new Newcustomer().setVisible(true);

	}

	
}
