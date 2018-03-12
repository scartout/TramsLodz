package okno;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import okno.Zakladka1;

public class OknoGlowne extends JFrame {
	private static final long serialVersionUID = 1L;

	private JTabbedPane panel;
	
	private JPanel zakladka1;
	private JScrollPane scroll;

	public OknoGlowne() throws SQLException {
		
		setTitle("Tramwaje 2.4");
		setSize(new Dimension(1600, 900));
		setLocation(0, 0);
		
		panel = new JTabbedPane();
		
		zakladka1 = new Zakladka1();
		panel.add("MPK", zakladka1);		
		
		getContentPane().add(panel);
		
		scroll = new JScrollPane(panel);
	    scroll.setBounds(10, 100, 1450, 200);
	    add(scroll);

	}

}