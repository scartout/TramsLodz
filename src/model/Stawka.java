package model;

public class Stawka {
	private int idStawki;
	private String nazwa;
	private float koszt;
	
	public int getIdStawki() {
		return idStawki;
	}
	
	public void setIdStawki(int idStawki) {
		this.idStawki = idStawki;
	}
	
	public String getNazwa() {
		return nazwa;
	}
	
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public float getKoszt() {
		return koszt;
	}
	
	public void setKoszt(float koszt) {
		this.koszt = koszt;
	}
	
	public Stawka(){};
	
	public Stawka(int idStawki, String nazwa, float koszt) {
		this.idStawki = idStawki;
		this.nazwa = nazwa;
		this.koszt = koszt;
	}
	
	public Stawka(float koszt) {
		this.koszt = koszt;
	}
	
	public String toString() {
		return nazwa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idStawki;
		result = prime * result + Float.floatToIntBits(koszt);
		result = prime * result + ((nazwa == null) ? 0 : nazwa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stawka other = (Stawka) obj;
		if (idStawki != other.idStawki)
			return false;
		if (Float.floatToIntBits(koszt) != Float.floatToIntBits(other.koszt))
			return false;
		if (nazwa == null) {
			if (other.nazwa != null)
				return false;
		} else if (!nazwa.equals(other.nazwa))
			return false;
		return true;
	}

}
