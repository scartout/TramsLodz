package baza;

import java.sql.SQLException;

import okno.OknoGlowne;
import baza.Baza;

public class Main {

	
	public static void main(String[] args) throws SQLException {

		OknoGlowne okno = new OknoGlowne();
		okno.setVisible(true);
		
		Baza z=new Baza();
		
		z.closeConnection();
		
	}

}