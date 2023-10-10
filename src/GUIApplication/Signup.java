package GUIApplication;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Signup extends JFrame implements ActionListener {

	JLabel lblUsername , lblPassword , lblType , lblImage;
	JTextField txtUsername , txtPwd;
	Choice ch;
	JButton btnSignup , btnCancel;
	
	static connection_to_database conn;
	PreparedStatement ps=null;
	
	public void initWidget() {
		ImageIcon imgUser=new ImageIcon(getClass().getResource("/icon/bussiness-man.png"));		
		Image imgResize =imgUser.getImage().getScaledInstance(250, 200, Image.SCALE_DEFAULT);
		imgUser = new ImageIcon(imgResize);
		lblImage =new JLabel(imgUser);
		lblImage.setBounds(25, 20, 150, 200);
		add(lblImage);
		
		lblUsername=new JLabel("Username");
		lblUsername.setBounds(200, 20, 100, 20);
		add(lblUsername);
		txtUsername=new JTextField(15);
		txtUsername.setBounds(300, 20, 150, 20);
		add(txtUsername);
		
		lblPassword=new JLabel("Password");
		lblPassword.setBounds(200, 60, 100, 20);
		add(lblPassword);
		
		txtPwd=new JTextField(15);
		txtPwd.setBounds(300, 60, 150, 20);
		add(txtPwd);
		
		lblType=new JLabel("User Type");
		lblType.setBounds(200, 100, 100, 20);
		add(lblType);
		
		ch = new Choice();
		ch.add("User Type");
		ch.add("Admin");
		ch.add("User");
		ch.setBounds(300,100,150,20);
		add(ch);
		
		btnSignup = new JButton("Create User");
		btnSignup.setBounds(200,160,110,20);
		add(btnSignup);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(340,160,110,20);
		add(btnCancel);
		btnSignup.addActionListener(this);
		btnCancel.addActionListener(this);
		
	}
	
	 Signup(){
		super("Create new user");
		getContentPane().setBackground(Color.white);
		initWidget();
		
		setLayout(new BorderLayout());
		setSize(600, 280);
		setLocation(400, 300);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSignup) {
			String username=txtUsername.getText();
			String pwd=txtPwd.getText();
			String userType=ch.getSelectedItem();
			
			try {
				Connection con=conn.getConnect();
				String sql="insert into lpu(username,password,usertype) values (?,?,?)";
				ps = con.prepareStatement(sql);
			    ps.setString(1, username);
			    ps.setString(2, pwd);
			    ps.setString(3, userType);
			    ps.execute();
			}
			catch (SQLException sqe) {
				System.out.println("Error Message: "+ sqe.getMessage());
			}
			System.out.println(username +  pwd + userType);
		}
	}
	public static void main(String[] args) {
		conn=new connection_to_database();
		new Signup().setVisible(true);
		
		
		
	}

}
