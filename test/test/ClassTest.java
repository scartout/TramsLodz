package test;
import static org.junit.Assert.assertNotEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;

import baza.Baza;
import baza.Rekordy;
import junit.framework.TestCase;
import model.Linia;
import model.Odcinek;
import model.Stawka;
import okno.Zakladka1;

import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ClassTest extends TestCase{
	
	@Rule
    public TestName testName = new TestName();

	@Test
	void t1shouldDeleteStawki() throws SQLException {
		Baza z = new Baza();
		z.deleteStawka();
		List<Stawka> stawki = new LinkedList<Stawka>();
		assertTrue(stawki.isEmpty());
	}
	
	@Test
	void t2shouldDeleteOdcinki() throws SQLException {
		Baza z = new Baza();
		z.deleteOdcinek();
		List<Odcinek> odcinki = new LinkedList<Odcinek>();
		assertTrue(odcinki.isEmpty());
	}
	
	@Test
	void t3shouldAddData() {
		Rekordy.addData();
	}
	
	@Test
	void t4shouldCountLength() throws SQLException {
		Zakladka1 z = new Zakladka1();
		List <Integer> table0 = Arrays.asList(114, 1, 2, 3, 4, 12, 19, 23, 22, 21, 123);
		assertEquals(9.95, z.countLength(table0), 0.01);
	}
	
	@Test
	void t5shouldInsertLiniaAndDeleteLinia() throws SQLException {
		Baza z = new Baza();
		z.insertLinia("","", "", 0, 0, 0, 0, 0, 0);
		List<Linia> linie = new LinkedList<Linia>();
		linie = z.selectLinie();
		assertFalse(linie.isEmpty());
		String linia = linie.get(linie.size()-1).toString();
		z.deleteLinia(Integer.parseInt(linia));
		linie = z.selectLinie();
		String linia2 = linie.get(linie.size()-1).toString();
		assertNotEquals(linia, linia2);
	}
	
	@Test
	void t6shouldTrasaGoodAppended() throws SQLException {
		Zakladka1 n = new Zakladka1();
		List <String> table = new ArrayList<String>();
		table.add("RETKINIA");
		table.add("Bratys³awska");
		table.add("Bandurskiego");
		table.add("Mickiewicza");
		table.add("Pi³sudskiego");
		table.add("Pi³sudskiego");
		table.add("Rokiciñska");
		String trasa = new String("RETKINIA-Bratys³awska-Bandurskiego-Mickiewicza-Pi³sudskiego-Rokiciñska");
		assertEquals(trasa, n.trasaBuilder(table).toString());
	}

}