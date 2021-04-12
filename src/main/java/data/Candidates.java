package data;

public class Candidates {

	private int ehdokas_id;
	private String sukunimi;
	private String etunimi;
	private String puolue;
	private String kotipaikkakunta;
	private int ika;
	private String miksi_eduskuntaan;
	private String mita_asioita_haluat_edistaa;
	private String ammatti;
	
	public Candidates(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika, String miksi_eduskuntaan, String mita_asioita_haluat_edistaa, String ammatti) {

		this.sukunimi=sukunimi;
		this.etunimi=etunimi;
		this.puolue=puolue;
		this.kotipaikkakunta=kotipaikkakunta;
		this.ika=ika;
		this.miksi_eduskuntaan=miksi_eduskuntaan;
		this.mita_asioita_haluat_edistaa=mita_asioita_haluat_edistaa;
		this.ammatti=ammatti;
	}

	public Candidates() {

	}

	public int getEhdokas_id() {
		return ehdokas_id;
	}

	public void setEhdokas_id(int ehdokas_id) {
		this.ehdokas_id = ehdokas_id;
	}

	public String getPuolue() {
		return puolue;
	}

	public void setPuolue(String puolue) {
		this.puolue = puolue;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getKotipaikkakunta() {
		return kotipaikkakunta;
	}

	public void setKotipaikkakunta(String kotipaikkakunta) {
		this.kotipaikkakunta = kotipaikkakunta;
	}

	public int getIka() {
		return ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public String getMiksi_eduskuntaan() {
		return miksi_eduskuntaan;
	}

	public void setMiksi_eduskuntaan(String miksi_eduskuntaan) {
		this.miksi_eduskuntaan = miksi_eduskuntaan;
	}

	public String getMita_asioita_haluat_edistaa() {
		return mita_asioita_haluat_edistaa;
	}

	public void setMita_asioita_haluat_edistaa(String mita_asioita_haluat_edistaa) {
		this.mita_asioita_haluat_edistaa = mita_asioita_haluat_edistaa;
	}

	public String getAmmatti() {
		return ammatti;
	}

	public void setAmmatti(String ammatti) {
		this.ammatti = ammatti;
	}

	
	
	

}