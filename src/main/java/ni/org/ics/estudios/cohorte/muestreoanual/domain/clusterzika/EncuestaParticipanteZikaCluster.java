package ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import ni.org.ics.estudios.cohorte.muestreoanual.audit.Auditable;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "encuestaparticipante_zika_cluster", catalog = "zika_cluster") 
public class EncuestaParticipanteZikaCluster implements Auditable{

	/**
	 * 
	 */
	private Integer codigo;
	private Integer edad; 
	private String alfabeto;
	private String educ_adult;
	private String trabaja_sn;
	private String trabajo;
	private String jefecasa;
	private String ojefecasa;
	private String edadjefecasa;
	private String escuela;
	private String grado;
	private String turno;
	private String nEscuela;
	private String otraEscuela;
	private String cuidan;
	private String cuantosCuidan;
	private String cqVive;
	private String papaest_sn;
	private String codigo_p;
	private String mamaest_sn;
	private String codigo_m;
	private String genero;
	private String embarazada;
	private String menstrual;
	private Date fum;
	private String calSG;
	private String inmunodef;
	private String tinmunodef;
	private String diabetes;
	private String mesActual;
	private String yearActual;
	private String diabetes_year;
	private String diabetes_mes;
	private String diabetes_mesact;
	private String diag_ecronica;
	private String cardiopatias;
	private String hipertensionArterial;
	private String artritisRematoidea;
	private String artritis;
	private String asma;
	private String epilepsia;
	private String tuberculosis;
	private String leucemia;
	private String cirugArtic;
	private String artrosis;
	private String otraEnfCronica;
	private String cualEnfCronica;
	private String zika;
	private String zika_year;
	private String zika_mes;
	private String zika_mesact;
	private String dengue;
	private String dengue_year;
	private String dengue_mes;
	private String dengue_mesact;	
	private MovilInfo movilInfo;

	@Id
	@Column(name = "codigo", nullable = false )
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "edad", nullable = true, length = 3)
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Column(name = "alfabeto", nullable = true, length = 1)
	public String getAlfabeto() {
		return alfabeto;
	}

	public void setAlfabeto(String alfabeto) {
		this.alfabeto = alfabeto;
	}

	@Column(name = "educ_adult", nullable = true, length = 1)
	public String getEduc_adult() {
		return educ_adult;
	}

	public void setEduc_adult(String educ_adult) {
		this.educ_adult = educ_adult;
	}

	@Column(name = "trabaja_sn", nullable = true, length = 1)
	public String getTrabaja_sn() {
		return trabaja_sn;
	}

	public void setTrabaja_sn(String trabaja_sn) {
		this.trabaja_sn = trabaja_sn;
	}

	@Column(name = "trabajo", nullable = true, length = 1)
	public String getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(String trabajo) {
		this.trabajo = trabajo;
	}

	@Column(name = "jefecasa", nullable = true, length = 1)
	public String getJefecasa() {
		return jefecasa;
	}

	public void setJefecasa(String jefecasa) {
		this.jefecasa = jefecasa;
	}

	@Column(name = "ojefecasa", nullable = true, length = 255)
	public String getOjefecasa() {
		return ojefecasa;
	}

	public void setOjefecasa(String ojefecasa) {
		this.ojefecasa = ojefecasa;
	}

	@Column(name = "edadjefecasa", nullable = true, length = 3)
	public String getEdadjefecasa() {
		return edadjefecasa;
	}

	public void setEdadjefecasa(String edadjefecasa) {
		this.edadjefecasa = edadjefecasa;
	}

	@Column(name = "escuela", nullable = true, length = 1)
	public String getEscuela() {
		return escuela;
	}

	public void setEscuela(String escuela) {
		this.escuela = escuela;
	}

	@Column(name = "grado", nullable = true, length = 1)
	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	@Column(name = "turno", nullable = true, length = 1)
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Column(name = "nEscuela", nullable = true, length = 3)
	public String getnEscuela() {
		return nEscuela;
	}

	public void setnEscuela(String nEscuela) {
		this.nEscuela = nEscuela;
	}

	@Column(name = "otraEscuela", nullable = true, length = 255)
	public String getOtraEscuela() {
		return otraEscuela;
	}

	public void setOtraEscuela(String otraEscuela) {
		this.otraEscuela = otraEscuela;
	}

	@Column(name = "cuidan", nullable = true, length = 1)
	public String getCuidan() {
		return cuidan;
	}

	public void setCuidan(String cuidan) {
		this.cuidan = cuidan;
	}

	@Column(name = "cuantosCuidan", nullable = true, length = 3)
	public String getCuantosCuidan() {
		return cuantosCuidan;
	}

	public void setCuantosCuidan(String cuantosCuidan) {
		this.cuantosCuidan = cuantosCuidan;
	}

	@Column(name = "cqVive", nullable = true, length = 1)
	public String getCqVive() {
		return cqVive;
	}

	public void setCqVive(String cqVive) {
		this.cqVive = cqVive;
	}

	@Column(name = "papaest_sn", nullable = true, length = 1)
	public String getPapaest_sn() {
		return papaest_sn;
	}

	public void setPapaest_sn(String papaest_sn) {
		this.papaest_sn = papaest_sn;
	}

	@Column(name = "codigo_p", nullable = true, length = 6)
	public String getCodigo_p() {
		return codigo_p;
	}

	public void setCodigo_p(String codigo_p) {
		this.codigo_p = codigo_p;
	}

	@Column(name = "mamaest_sn", nullable = true, length = 1)
	public String getMamaest_sn() {
		return mamaest_sn;
	}

	public void setMamaest_sn(String mamaest_sn) {
		this.mamaest_sn = mamaest_sn;
	}

	@Column(name = "codigo_m", nullable = true, length = 6)
	public String getCodigo_m() {
		return codigo_m;
	}

	public void setCodigo_m(String codigo_m) {
		this.codigo_m = codigo_m;
	}

	@Column(name = "genero", nullable = true, length = 1)
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Column(name = "embarazada", nullable = true, length = 1)
	public String getEmbarazada() {
		return embarazada;
	}

	public void setEmbarazada(String embarazada) {
		this.embarazada = embarazada;
	}

	@Column(name = "menstrual", nullable = true, length = 1)
	public String getMenstrual() {
		return menstrual;
	}

	public void setMenstrual(String menstrual) {
		this.menstrual = menstrual;
	}

	@Column(name = "fum", nullable = true)
	public Date getFum() {
		return fum;
	}

	public void setFum(Date fum) {
		this.fum = fum;
	}

	@Column(name = "calSG", nullable = true, length = 6)
	public String getCalSG() {
		return calSG;
	}

	public void setCalSG(String calSG) {
		this.calSG = calSG;
	}

	@Column(name = "inmunodef", nullable = true, length = 1)
	public String getInmunodef() {
		return inmunodef;
	}

	public void setInmunodef(String inmunodef) {
		this.inmunodef = inmunodef;
	}

	@Column(name = "tinmunodef", nullable = true, length = 255)
	public String getTinmunodef() {
		return tinmunodef;
	}

	public void setTinmunodef(String tinmunodef) {
		this.tinmunodef = tinmunodef;
	}

	@Column(name = "diabetes", nullable = true, length = 1)
	public String getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}

	@Column(name = "mesActual", nullable = true, length = 20)
	public String getMesActual() {
		return mesActual;
	}

	public void setMesActual(String mesActual) {
		this.mesActual = mesActual;
	}

	@Column(name = "yearActual", nullable = true, length = 20)
	public String getYearActual() {
		return yearActual;
	}

	public void setYearActual(String yearActual) {
		this.yearActual = yearActual;
	}

	@Column(name = "diabetes_year", nullable = true, length = 20)
	public String getDiabetes_year() {
		return diabetes_year;
	}

	public void setDiabetes_year(String diabetes_year) {
		this.diabetes_year = diabetes_year;
	}

	@Column(name = "diabetes_mes", nullable = true, length = 20)
	public String getDiabetes_mes() {
		return diabetes_mes;
	}

	public void setDiabetes_mes(String diabetes_mes) {
		this.diabetes_mes = diabetes_mes;
	}

	@Column(name = "diabetes_mesact", nullable = true, length = 20)
	public String getDiabetes_mesact() {
		return diabetes_mesact;
	}

	public void setDiabetes_mesact(String diabetes_mesact) {
		this.diabetes_mesact = diabetes_mesact;
	}

	@Column(name = "diag_ecronica", nullable = true, length = 1)
	public String getDiag_ecronica() {
		return diag_ecronica;
	}

	public void setDiag_ecronica(String diag_ecronica) {
		this.diag_ecronica = diag_ecronica;
	}

	@Column(name = "cardiopatias", nullable = true, length = 1)
	public String getCardiopatias() {
		return cardiopatias;
	}

	public void setCardiopatias(String cardiopatias) {
		this.cardiopatias = cardiopatias;
	}

	@Column(name = "hipertensionArterial", nullable = true, length = 1)
	public String getHipertensionArterial() {
		return hipertensionArterial;
	}

	public void setHipertensionArterial(String hipertensionArterial) {
		this.hipertensionArterial = hipertensionArterial;
	}

	@Column(name = "artritisRematoidea", nullable = true, length = 1)
	public String getArtritisRematoidea() {
		return artritisRematoidea;
	}

	public void setArtritisRematoidea(String artritisRematoidea) {
		this.artritisRematoidea = artritisRematoidea;
	}
	
	@Column(name = "artritis", nullable = true, length = 1)
	public String getArtritis() {
		return artritis;
	}

	public void setArtritis(String artritis) {
		this.artritis = artritis;
	}

	@Column(name = "asma", nullable = true, length = 1)
	public String getAsma() {
		return asma;
	}

	public void setAsma(String asma) {
		this.asma = asma;
	}

	@Column(name = "epilepsia", nullable = true, length = 1)
	public String getEpilepsia() {
		return epilepsia;
	}

	public void setEpilepsia(String epilepsia) {
		this.epilepsia = epilepsia;
	}

	@Column(name = "tuberculosis", nullable = true, length = 1)
	public String getTuberculosis() {
		return tuberculosis;
	}

	public void setTuberculosis(String tuberculosis) {
		this.tuberculosis = tuberculosis;
	}

	@Column(name = "leucemia", nullable = true, length = 1)
	public String getLeucemia() {
		return leucemia;
	}

	public void setLeucemia(String leucemia) {
		this.leucemia = leucemia;
	}

	@Column(name = "cirugArtic", nullable = true, length = 1)
	public String getCirugArtic() {
		return cirugArtic;
	}

	public void setCirugArtic(String cirugArtic) {
		this.cirugArtic = cirugArtic;
	}

	@Column(name = "artrosis", nullable = true, length = 1)
	public String getArtrosis() {
		return artrosis;
	}

	public void setArtrosis(String artrosis) {
		this.artrosis = artrosis;
	}

	@Column(name = "otraEnfCronica", nullable = true, length = 1)
	public String getOtraEnfCronica() {
		return otraEnfCronica;
	}

	public void setOtraEnfCronica(String otraEnfCronica) {
		this.otraEnfCronica = otraEnfCronica;
	}

	@Column(name = "cualEnfCronica", nullable = true, length = 255)
	public String getCualEnfCronica() {
		return cualEnfCronica;
	}

	public void setCualEnfCronica(String cualEnfCronica) {
		this.cualEnfCronica = cualEnfCronica;
	}

	@Column(name = "zika", nullable = true, length = 1)
	public String getZika() {
		return zika;
	}

	public void setZika(String zika) {
		this.zika = zika;
	}

	@Column(name = "zika_year", nullable = true, length = 20)
	public String getZika_year() {
		return zika_year;
	}

	public void setZika_year(String zika_year) {
		this.zika_year = zika_year;
	}

	@Column(name = "zika_mes", nullable = true, length = 20)
	public String getZika_mes() {
		return zika_mes;
	}

	public void setZika_mes(String zika_mes) {
		this.zika_mes = zika_mes;
	}

	@Column(name = "zika_mesact", nullable = true, length = 20)
	public String getZika_mesact() {
		return zika_mesact;
	}

	public void setZika_mesact(String zika_mesact) {
		this.zika_mesact = zika_mesact;
	}

	@Column(name = "dengue", nullable = true, length = 1)
	public String getDengue() {
		return dengue;
	}

	public void setDengue(String dengue) {
		this.dengue = dengue;
	}

	@Column(name = "dengue_year", nullable = true, length = 20)
	public String getDengue_year() {
		return dengue_year;
	}

	public void setDengue_year(String dengue_year) {
		this.dengue_year = dengue_year;
	}

	@Column(name = "dengue_mes", nullable = true, length = 20)
	public String getDengue_mes() {
		return dengue_mes;
	}

	public void setDengue_mes(String dengue_mes) {
		this.dengue_mes = dengue_mes;
	}

	@Column(name = "dengue_mesact", nullable = true, length = 20)
	public String getDengue_mesact() {
		return dengue_mesact;
	}

	public void setDengue_mesact(String dengue_mesact) {
		this.dengue_mesact = dengue_mesact;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	@Override
	public boolean isFieldAuditable(String fieldname) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
