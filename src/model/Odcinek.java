package model;

public class Odcinek {
	private int idOdcinka;
	private String nazwaUlicy;
	private String nazwaOdcinka;
	private float dlugoscOdcinka;
	private int czasPrzejazdu;
	
	public int getIdOdcinka() {
		return idOdcinka;
	}
	
	public void setIdOdcinka(int idOdcinka) {
		this.idOdcinka = idOdcinka;
	}
	
	public String getNazwaUlicy() {
		return nazwaUlicy;
	}
	
	public void setNazwaUlicy(String nazwaUlicy) {
		this.nazwaUlicy = nazwaUlicy;
	}
	
	public String getNazwaOdcinka() {
		return nazwaOdcinka;
	}
	
	public void setNazwaOdcinka(String nazwaOdcinka) {
		this.nazwaOdcinka = nazwaOdcinka;
	}
	
	public float getDlugoscOdcinka() {
		return dlugoscOdcinka;
	}
	
	public void setDlugoscOdcinka(float dlugoscOdcinka) {
		this.dlugoscOdcinka = dlugoscOdcinka;
	}
	
	public int getCzasPrzejazdu() {
		return czasPrzejazdu;
	}
	
	public void setCzasPrzejazdu(int czasPrzejazdu) {
		this.czasPrzejazdu = czasPrzejazdu;
	}

	public Odcinek(){};
	
	public Odcinek(int idOdcinka, String nazwaUlicy, String nazwaOdcinka, float dlugoscOdcinka, int czasPrzejazdu) {
		this.idOdcinka = idOdcinka;
		this.nazwaUlicy = nazwaUlicy;
		this.nazwaOdcinka = nazwaOdcinka;
		this.dlugoscOdcinka = dlugoscOdcinka;
		this.czasPrzejazdu = czasPrzejazdu;
	}
	
	public Odcinek(float dlugoscOdcinka) {
		this.dlugoscOdcinka = dlugoscOdcinka;
	}
	
	public Odcinek(String nazwaUlicy) {
		this.nazwaUlicy = nazwaUlicy;
	}
	
	public String toString() {
		return Integer.toString(idOdcinka);
	}
	public String toString(String nazwaUlicy) {
		return nazwaUlicy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + czasPrzejazdu;
		result = prime * result + Float.floatToIntBits(dlugoscOdcinka);
		result = prime * result + idOdcinka;
		result = prime * result + ((nazwaOdcinka == null) ? 0 : nazwaOdcinka.hashCode());
		result = prime * result + ((nazwaUlicy == null) ? 0 : nazwaUlicy.hashCode());
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
		Odcinek other = (Odcinek) obj;
		if (czasPrzejazdu != other.czasPrzejazdu)
			return false;
		if (Float.floatToIntBits(dlugoscOdcinka) != Float.floatToIntBits(other.dlugoscOdcinka))
			return false;
		if (idOdcinka != other.idOdcinka)
			return false;
		if (nazwaOdcinka == null) {
			if (other.nazwaOdcinka != null)
				return false;
		} else if (!nazwaOdcinka.equals(other.nazwaOdcinka))
			return false;
		if (nazwaUlicy == null) {
			if (other.nazwaUlicy != null)
				return false;
		} else if (!nazwaUlicy.equals(other.nazwaUlicy))
			return false;
		return true;
	}
	
}
