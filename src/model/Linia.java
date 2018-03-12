package model;

public class Linia {
	private int idLinii;
	private String nrLinii;
	private String trasa;
	private String opis;
	private float dlugosc;
	private int czasPrzejazdu;
	private float koszt1;
	private float koszt2;
	private float koszt3;
	private float koszt4;
	
	
	public int getIdLinii() {
		return idLinii;
	}
	
	public void setIdLinii(int idLinii) {
		this.idLinii = idLinii;
	}
	
	public String getNrLinii() {
		return nrLinii;
	}
	
	public void setNrLinii(String nrLinii) {
		this.nrLinii = nrLinii;
	}
	
	public String getTrasa() {
		return trasa;
	}
	
	public void setTrasa(String trasa) {
		this.trasa = trasa;
	}
	
	public String getOpis() {
		return opis;
	}
	
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public float getDlugosc() {
		return dlugosc;
	}
	
	public void setDlugosc(float dlugosc) {
		this.dlugosc = dlugosc;
	}
	
	public int getCzasPrzejazdu() {
		return czasPrzejazdu;
	}
	
	public void setCzasPrzejazdu(int czasPrzejazdu) {
		this.czasPrzejazdu = czasPrzejazdu;
	}
	
	public float getKoszt1() {
		return koszt1;
	}
	
	public void setKoszt1(float koszt1) {
		this.koszt1 = koszt1;
	}
	
	public float getKoszt2() {
		return koszt2;
	}
	
	public void setKoszt2(float koszt2) {
		this.koszt2 = koszt2;
	}
	
	public float getKoszt3() {
		return koszt3;
	}
	
	public void setKoszt3(float koszt3) {
		this.koszt3 = koszt3;
	}
	
	public float getKoszt4() {
		return koszt4;
	}
	
	public void setKoszt4(float koszt4) {
		this.koszt4 = koszt4;
	}

	public Linia(){};
	
	public Linia(int idLinii, String nrLinii, String trasa, String opis, float dlugosc, int czasPrzejazdu, float koszt1, float koszt2, float koszt3, float koszt4){
		this.idLinii=idLinii;
		this.nrLinii=nrLinii;
		this.trasa=trasa;
		this.opis=opis;
		this.dlugosc=dlugosc;
		this.czasPrzejazdu=czasPrzejazdu;
		this.koszt1=koszt1;
		this.koszt2=koszt2;
		this.koszt3=koszt3;
		this.koszt4=koszt4;
	}
	
    public String toString() {
        return Integer.toString(idLinii);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + czasPrzejazdu;
		result = prime * result + Float.floatToIntBits(dlugosc);
		result = prime * result + idLinii;
		result = prime * result + Float.floatToIntBits(koszt1);
		result = prime * result + Float.floatToIntBits(koszt2);
		result = prime * result + Float.floatToIntBits(koszt3);
		result = prime * result + Float.floatToIntBits(koszt4);
		result = prime * result + ((nrLinii == null) ? 0 : nrLinii.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((trasa == null) ? 0 : trasa.hashCode());
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
		Linia other = (Linia) obj;
		if (czasPrzejazdu != other.czasPrzejazdu)
			return false;
		if (Float.floatToIntBits(dlugosc) != Float.floatToIntBits(other.dlugosc))
			return false;
		if (idLinii != other.idLinii)
			return false;
		if (Float.floatToIntBits(koszt1) != Float.floatToIntBits(other.koszt1))
			return false;
		if (Float.floatToIntBits(koszt2) != Float.floatToIntBits(other.koszt2))
			return false;
		if (Float.floatToIntBits(koszt3) != Float.floatToIntBits(other.koszt3))
			return false;
		if (Float.floatToIntBits(koszt4) != Float.floatToIntBits(other.koszt4))
			return false;
		if (nrLinii == null) {
			if (other.nrLinii != null)
				return false;
		} else if (!nrLinii.equals(other.nrLinii))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (trasa == null) {
			if (other.trasa != null)
				return false;
		} else if (!trasa.equals(other.trasa))
			return false;
		return true;
	}
		
}
