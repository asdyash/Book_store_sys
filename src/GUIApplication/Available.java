
package GUIApplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Available  extends JFrame implements ActionListener {
	static connection_to_database conn;
	JTable t1;
	String x[] = {"Book Name","Author.","Launch Year"};
	String y[][] = new String[40][10];
	int i=0,j=0;
	
	Available() {
		super("Available Books");
		setSize(700, 350);
		setLocation(250, 150);
		
		conn = new connection_to_database();
		try {
			Connection con = conn.getConnect();
			String s1 = "select * from available";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(s1);
			while(rs.next()) {
				y[i][j++] = rs.getString("Book Name");
				y[i][j++] = rs.getString("Author");
				y[i][j++] = rs.getString("Launch Year");
				i++;
				j=0;
			}
			
			
			
		} catch(Exception e) {
			
		}
		t1 = new JTable(y,x);
		JScrollPane sp = new JScrollPane(t1); 
		add(sp);
	}
	
 	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {
		conn = new connection_to_database();
		new Available().setVisible(true);
	}

}
