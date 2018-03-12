package model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LiniaTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	
	private final static Object[] nazwyKolumn = {"L.p", "Linia", "Trasa", "Opis", "D³ugoœæ [km]", "Czas [min]", "2x805Na", "1x805Na", "Niskopod³.", "Helmut"};
	private List<Linia>  mojeLinie = null;
	
	@Override
	public int getColumnCount() {
		
		return nazwyKolumn.length;
	}

	@Override
	public int getRowCount() {
		if(mojeLinie == null)return 0;
		
		return mojeLinie.size();
	}

	@Override
	public Object getValueAt(int wierszIndex, int kolumnaIndex) {
		if(mojeLinie ==null) return null;
		Linia p = (Linia) mojeLinie.get(wierszIndex);
		
		switch(kolumnaIndex) {
		case 0:
		return p.getIdLinii();
		case 1:
		return p.getNrLinii();
		case 2 :
		return p.getTrasa();
		case 3 :
		return p.getOpis();	
		case 4 :	
		return Math.round(p.getDlugosc()*100.00)/100.00;
		case 5 :
		return p.getCzasPrzejazdu();
		case 6 :
		return Math.round(p.getKoszt1()*100.00)/100.00;
		case 7 :
		return Math.round(p.getKoszt2()*100.00)/100.00;
		case 8 :
		return Math.round(p.getKoszt3()*100.00)/100.00;
		case 9 :
		return Math.round(p.getKoszt4()*100.00)/100.00;
		default:
		return p;
		}
	}

	public void setModelData(List<Linia>mojeLinie){
		this.mojeLinie = mojeLinie;
	}
	
	 @Override
	public String getColumnName(int kol){
		return nazwyKolumn[kol].toString();
	}

}
