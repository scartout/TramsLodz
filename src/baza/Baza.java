package baza;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Linia;
import model.Odcinek;
import model.Stawka;
 
public class Baza {
 
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:elements/Baza.db";
 
    private Connection conn;
    private Statement stat;
 
    public Baza() {
    	setUpDriver();
    	connectToDatabase();
        createTables();
    }
 
    public void setUpDriver() {
	    try {
	        Class.forName(Baza.DRIVER);
	    } catch (ClassNotFoundException e) {
	        System.err.println("Brak sterownika JDBC");
	        e.printStackTrace();
	    }
    }
	    
    public void connectToDatabase(){
        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
    }
    
    
    public boolean createTables()  {
        String createLinie = "CREATE TABLE IF NOT EXISTS linie (idLinii INTEGER PRIMARY KEY AUTOINCREMENT, nrLinii varchar(255), trasa varchar(1000), opis varchar(255), dlugosc float, czasPrzejazdu int, koszt1 float, koszt2 float, koszt3 float, koszt4 float)";
        String createOdcinki = "CREATE TABLE IF NOT EXISTS odcinki (idOdcinka INTEGER PRIMARY KEY, nazwaUlicy varchar(255), nazwaOdcinka varchar(255), dlugoscOdcinka float, czasPrzejazdu int)";
        String createStawki = "CREATE TABLE IF NOT EXISTS stawki (idStawki INTEGER PRIMARY KEY, nazwa varchar(255), koszt float)";
        try {
            stat.execute(createLinie);
            stat.execute(createOdcinki);
            stat.execute(createStawki);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
 
    public boolean insertLinia(String nrLinii, String trasa, String opis, double dlugosc, int czasPrzejazdu, double koszt1, double koszt2, double koszt3, double koszt4) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into linie values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, nrLinii);
            prepStmt.setString(2, trasa);
            prepStmt.setString(3, opis);
            prepStmt.setDouble(4, dlugosc);
            prepStmt.setInt(5, czasPrzejazdu);
            prepStmt.setDouble(6, koszt1);
            prepStmt.setDouble(7, koszt2);
            prepStmt.setDouble(8, koszt3);
            prepStmt.setDouble(9, koszt4);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu linii");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean insertOdcinek(String nazwaUlicy, String nazwaOdcinka, double dlugoscOdcinka, int czasPrzejazdu) {
	    try {
	        PreparedStatement prepStmt = conn.prepareStatement(
	                "insert into odcinki values (NULL, ?, ?, ?, ?);");
	        prepStmt.setString(1, nazwaUlicy);
	        prepStmt.setString(2, nazwaOdcinka);
	        prepStmt.setDouble(3, dlugoscOdcinka);
	        prepStmt.setInt(4, czasPrzejazdu);
	        prepStmt.execute();
	    } catch (SQLException e) {
	        System.err.println("Blad przy wstawianiu odcinka");
	        e.printStackTrace();
	        return false;
	    }
	    return true;
}        
 
   public boolean insertStawka(String nazwa, double d) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into stawki values (NULL, ?, ?);");
            prepStmt.setString(1, nazwa);
            prepStmt.setFloat(2, (float) d);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy dodawaniu stawki");
            return false;
        }
        return true;
    }

 
    public List<Linia> selectLinie() {
        List<Linia> linie = new LinkedList<Linia>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM linie");
        	int idLinii;
        	String nrLinii;
        	String trasa;
        	String opis;
        	float dlugosc;
        	int czasPrzejazdu;
        	float koszt1;
        	float koszt2;
        	float koszt3;
        	float koszt4;
            while(result.next()) {
            	idLinii = result.getInt("idLinii");
            	nrLinii = result.getString("nrLinii");
            	trasa = result.getString("trasa");
            	opis = result.getString("opis");
            	dlugosc = result.getFloat("dlugosc");
            	czasPrzejazdu = result.getInt("czasPrzejazdu");
            	koszt1 = result.getFloat("koszt1");
            	koszt2 = result.getFloat("koszt2");
            	koszt3 = result.getFloat("koszt3");
            	koszt4 = result.getFloat("koszt4");
                linie.add(new Linia(idLinii, nrLinii, trasa, opis, dlugosc, czasPrzejazdu, koszt1, koszt2, koszt3, koszt4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return linie;
    }
    
    public List<Odcinek> selectOdcinki(){
        List<Odcinek> odcinki = new LinkedList<Odcinek>();
        try {
        	ResultSet result = stat.executeQuery("SELECT * FROM odcinki");
        	int idOdcinka;
        	String nazwaUlicy;
        	String nazwaOdcinka;
        	float dlugoscOdcinka;
        	int czasPrzejazdu;
            while(result.next()) {
            	idOdcinka = result.getInt("idOdcinka");
            	nazwaUlicy = result.getString("nazwaUlicy");
            	nazwaOdcinka = result.getString("nazwaOdcinka");
            	dlugoscOdcinka = result.getFloat("dlugoscOdcinka");
            	czasPrzejazdu = result.getInt("czasPrzejazdu");
                odcinki.add(new Odcinek(idOdcinka, nazwaUlicy, nazwaOdcinka, dlugoscOdcinka, czasPrzejazdu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return odcinki;
    }

    public List<Stawka> selectStawki() {
        List<Stawka> stawki = new LinkedList<Stawka>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM stawki");
        	int idStawki;
        	String nazwa;
        	float koszt;
            while(result.next()) {
            	idStawki = result.getInt("idStawki");
            	nazwa = result.getString("nazwa");
            	koszt = result.getFloat("koszt");
                stawki.add(new Stawka(idStawki, nazwa, koszt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return stawki;
    }
       
    float dlugoscOdcinka;
    public float selectOdcinkiDlugosc(Object i) throws SQLException {
    	String selectSQL = "SELECT dlugoscOdcinka FROM odcinki WHERE idOdcinka=?";
    	PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
    	preparedStatement.setObject(1, i);
    	ResultSet rs = preparedStatement.executeQuery();
    	while (rs.next()) {
    		dlugoscOdcinka = rs.getFloat("dlugoscOdcinka");}
    	return dlugoscOdcinka;}
    
    int czasPrzejazdu;
    public int selectOdcinkiCzas(Object i) throws SQLException {
    	String selectSQL = "SELECT czasPrzejazdu FROM odcinki WHERE idOdcinka=?";
    	PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
    	preparedStatement.setObject(1, i);
    	ResultSet rs = preparedStatement.executeQuery();
    	while (rs.next()) {
    		czasPrzejazdu = rs.getInt("czasPrzejazdu");}
    	return czasPrzejazdu;}

    String nazwaUlicy;
    public String selectOdcinkiNazwa(Object i) throws SQLException {
    	String selectSQL = "SELECT nazwaUlicy FROM odcinki WHERE idOdcinka=?";
    	PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
    	preparedStatement.setObject(1, i);
    	ResultSet rs = preparedStatement.executeQuery();
    	while (rs.next()) {
    		nazwaUlicy = rs.getString("nazwaUlicy");}
    	return nazwaUlicy;}
    
    float koszt;
    public float selectStawkaKoszt(float i) throws SQLException {
    	String selectSQL = "SELECT koszt FROM stawki WHERE idStawki=?";
    	PreparedStatement preparedStatement = conn.prepareStatement(selectSQL);
    	preparedStatement.setFloat(1, i);
    	ResultSet rs = preparedStatement.executeQuery();
    	while (rs.next()) {
    		koszt = rs.getFloat("koszt");}
    	return koszt;} 
    
    public boolean deleteLinia(int idLinii) {
    	try {
    		PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM linie WHERE idLinii=?;");
    		prepStmt.setInt(1, idLinii);
    		prepStmt.execute();
    	} catch (SQLException e) {
    		System.err.println("Blad przy usuwaniu linii");
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean deleteOdcinek() {
    	try {
    		PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM odcinki");
    		prepStmt.execute();
    	} catch (SQLException e) {
    		System.err.println("Blad przy usuwaniu odcinków");
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public boolean deleteStawka() {
    	try {
    		PreparedStatement prepStmt = conn.prepareStatement("DELETE FROM stawki");
    		prepStmt.execute();
    	} catch (SQLException e) {
    		System.err.println("Blad przy usuwaniu stawek");
    		e.printStackTrace();
    		return false;
    	}
    	return true;
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }

}