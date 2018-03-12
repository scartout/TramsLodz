package okno;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Linia;
import model.LiniaTableModel;
import model.Odcinek;
import baza.Baza;
import baza.Rekordy;

public class Zakladka1 extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;

	Baza z = new Baza();
	JComboBox[] tableJCB = new JComboBox[30];
	
	Connection con;
	ResultSet rs, rs1;
	java.sql.Statement st;

	Statement st1;
	PreparedStatement pst;
	String ids;
	
	private BufferedImage mapa;
	private JLabel LiniaLabel;
	private JTextField LiniaJTF;
	private JLabel OpisLabel;
	private JTextField OpisJTF;
	private JLabel UsunLabel;
	private JComboBox <Linia> DeleteJCB;
	private JButton DeleteButton;
	private JButton DodajButton;
	private JButton RefreshDatabaseButton;
	private JTable table;
	private JScrollPane scroll;
	private JButton wyswietlButton;
	
	public void refreshDeleteJCB() {
		List<Linia> linie = z.selectLinie();
		DeleteJCB.removeAllItems();
		for (Linia i : linie){
			DeleteJCB.addItem(i);
		}
	}
	
	public void generateComboboxes(){
		for (int i=0; i<30; i++) {
			tableJCB[i] = new JComboBox<Linia>();
			if (i<15) tableJCB[i].setBounds(600+i*50, 70, 50, 20);
			else tableJCB[i].setBounds(600+(i-15)*50, 110, 50, 20);
			add(tableJCB[i]);
		}
	}
	
	public void refreshComboboxes() {
		List<Odcinek> odcinki = z.selectOdcinki();	
		for (int j=0; j<30; j++) {
				tableJCB[j].removeAllItems();
				tableJCB[j].addItem(0);
				for (int i=0; i< odcinki.size(); i++){
					tableJCB[j].addItem(odcinki.get(i));
				}
			}
	}
	
	public StringBuilder trasaBuilder(List<String> table1) {
		StringBuilder trasa = new StringBuilder();
		for(int i=0; i<table1.size() && table1.get(i)!=null; i++){
			if (i==0) trasa.append(table1.get(i));
			if (i>0 && table1.get(i).startsWith(table1.get(i-1))) {
				trasa.append(table1.get(i).replace(table1.get(i-1),""));
			}
			else if (i>0 && !table1.get(i-1).contains(table1.get(i))) {
			trasa.append("-"+table1.get(i));
			}
		}
		return trasa;
	}
	
	public List <Integer> readOdcinki() {
		
		List<Integer> table0 = new ArrayList<Integer>();
		
		for (int i=0; i<30; i++) {
			table0.add(Integer.parseInt(tableJCB[i].getSelectedItem().toString()));
		}
		
		return table0;
	}

	public List <String> readOdcinkiNazwa(List <Integer> table0){
		List<String> table1 = new ArrayList<String>();
		
		for(int i=0; i<table0.size(); i++){
			try {
				if(table0.get(i)!=0) table1.add(z.selectOdcinkiNazwa(table0.get(i)));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return table1;
	}

	public double countLength(List <Integer> table0) {
		double dlugosc=0;
		for(int i=0; i<table0.size(); i++){
			if (table0.get(i)==0) break;
			try {
				if (table0.get(i)!=0) dlugosc+=z.selectOdcinkiDlugosc(table0.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dlugosc;
	}

	public int countTime(List <Integer> table0) {

		int czas=0;
		
		for(int i=0; i<table0.size(); i++){
			try {
				if (table0.get(i)==0) break;
				if (table0.get(i)!=0) czas+=z.selectOdcinkiCzas(table0.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return czas;
	}

	public List<Double> countCosts(List <Integer> table0, double dlugosc) {
		List <Double> cost = new ArrayList<Double>();
		try {
			cost.add(dlugosc*z.selectStawkaKoszt(1));
			cost.add(dlugosc*z.selectStawkaKoszt(2));
			cost.add(dlugosc*z.selectStawkaKoszt(3));
			cost.add(dlugosc*z.selectStawkaKoszt(4));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cost;
	}
	
	public void mapaLoad() {
		File imageFile = new File("elements/Mapa.jpg");
		try {
			mapa = ImageIO.read(imageFile);
		} catch (IOException e) {
			System.err.println("Blad odczytu mapy");
			e.printStackTrace();
		}
	}
	
	public void setScreenDimension() {
		Dimension dimension = new Dimension(900, 1050);
		setPreferredSize(dimension);
	}
	

	public Zakladka1() throws SQLException {
		
		setLayout(null);
		
		setScreenDimension();
		mapaLoad();
		
		generateComboboxes();	
		refreshComboboxes();
		
		RefreshDatabaseButton = new JButton("Odœwie¿ bazê");
		RefreshDatabaseButton.setBounds(850, 10, 120, 20);
		RefreshDatabaseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Czy odœwie¿yæ bazê?","Ostrze¿enie",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					z.deleteOdcinek();
					z.deleteStawka();
					Rekordy.addData();
					refreshDeleteJCB();
					refreshComboboxes();
				}						
			}
		});
		add(RefreshDatabaseButton);
			
		wyswietlButton = new JButton("Wyœwietl");
		wyswietlButton.setBounds(600, 720, 150, 50);
		wyswietlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				List<Linia> linie = z.selectLinie();
		        
		        LiniaTableModel liniaTM = new LiniaTableModel();
		        liniaTM.setModelData(linie);
		        
		        table = new JTable(liniaTM);
		        table.setLocation(100,100);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		        table.getColumnModel().getColumn(0).setPreferredWidth(30);
		        table.getColumnModel().getColumn(1).setPreferredWidth(40);
		        table.getColumnModel().getColumn(2).setPreferredWidth(940);
		        table.getColumnModel().getColumn(3).setPreferredWidth(140);
		        table.getColumnModel().getColumn(4).setPreferredWidth(80);
		        table.getColumnModel().getColumn(5).setPreferredWidth(65);
		        table.getColumnModel().getColumn(6).setPreferredWidth(60);
		        table.getColumnModel().getColumn(7).setPreferredWidth(60);
		        table.getColumnModel().getColumn(8).setPreferredWidth(70);
		        table.getColumnModel().getColumn(9).setPreferredWidth(60);
		        
		        scroll = new JScrollPane(table);
		        scroll.setBounds(0, 820, 1550, 200);
		        add(scroll);
   
			}
			
		});
		add(wyswietlButton);
	
		LiniaLabel = new JLabel("Nr linii");
		LiniaLabel.setBounds(600, 40, 240, 20);
		add(LiniaLabel);
        
        LiniaJTF = new JTextField(4);
		LiniaJTF.setBounds(640, 40, 50, 20);
		add(LiniaJTF);
		
		OpisLabel = new JLabel("Opis");
		OpisLabel.setBounds(700, 40, 240, 20);
		add(OpisLabel);
		
		OpisJTF = new JTextField(4);
		OpisJTF.setBounds(730, 40, 800, 20);
		add(OpisJTF);
		
		UsunLabel = new JLabel("Usuwanie linii");
		UsunLabel.setBounds(600, 10, 240, 20);
		add(UsunLabel);
		
		DeleteJCB = new JComboBox<Linia>();
		DeleteJCB.setBounds(700, 10, 50, 20);
		
		refreshDeleteJCB();
		add(DeleteJCB);
		
		DeleteButton = new JButton("Usuñ");
		DeleteButton.setBounds(750, 10, 70, 20);
		DeleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Czy usun¹æ?","Ostrze¿enie",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){				
					try {
					String liniaDelete=DeleteJCB.getSelectedItem().toString();	
					int liniaDelete1=Integer.parseInt(liniaDelete);
					z.deleteLinia(liniaDelete1);
					refreshDeleteJCB();
					}catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "Nie wybrano ¿adnego rekordu!", "B³¹d", JOptionPane.ERROR_MESSAGE);
					}	
				}						
			}
		});
		add(DeleteButton);
		
		DodajButton = new JButton("Dodaj");
		DodajButton.setBounds(600, 650, 150, 50);
		DodajButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				List<Integer> table0 = readOdcinki();
				List<String> table1 = readOdcinkiNazwa(table0);
				double length = countLength(table0);
				List<Double> tableCosts = countCosts(table0, length);
				z.insertLinia(LiniaJTF.getText(), trasaBuilder(table1).toString(), OpisJTF.getText(), length, countTime(table0), tableCosts.get(0), tableCosts.get(1), tableCosts.get(2), tableCosts.get(3));

				refreshDeleteJCB();
			}
			
		});
		add(DodajButton);
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(mapa, 0, 0, this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
