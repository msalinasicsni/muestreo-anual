package ni.org.ics.estudios.cohorte.muestreoanual.domain.clusterzika;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import ni.org.ics.estudios.cohorte.muestreoanual.audit.Auditable;
import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "casa_zika_cluster", catalog = "zika_cluster")
public class CasaZikaCluster implements Auditable{

	/**
	 * 
	 */
	
	private Integer codigo_casa;
	private String barrio;
	private String jefenom;
	private String jefenom2;
	private String jefeap;
	private String jefeap2;
	private String direccion;
	private String telefono1;
	private String telefono2;
	private String georef;
	private String Manzana;
	private String georef_razon;
	private String georef_otraRazon;
	private String idTamizaje;
	private char encuesta='0';
	private char encuestaEnt='0';
	private MovilInfo movilInfo;
		
	@Id
	@Column(name = "codigo_casa", nullable = false)
	public Integer getCodigo_casa() {
		return codigo_casa;
	}
	
	public void setCodigo_casa(Integer codigo_casa) {
		this.codigo_casa = codigo_casa;
	}

	@Column(name = "barrio", nullable = true, length = 2)
	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	@Column(name = "jefenom", nullable = true, length = 50)
	public String getJefenom() {
		return jefenom;
	}

	public void setJefenom(String jefenom) {
		this.jefenom = jefenom;
	}

	@Column(name = "jefenom2", nullable = true, length = 50)
	public String getJefenom2() {
		return jefenom2;
	}

	public void setJefenom2(String jefenom2) {
		this.jefenom2 = jefenom2;
	}

	@Column(name = "jefeap", nullable = true, length = 50)
	public String getJefeap() {
		return jefeap;
	}

	public void setJefeap(String jefeap) {
		this.jefeap = jefeap;
	}

	@Column(name = "jefeap2", nullable = true, length = 50)
	public String getJefeap2() {
		return jefeap2;
	}

	public void setJefeap2(String jefeap2) {
		this.jefeap2 = jefeap2;
	}

	@Column(name = "direccion", nullable = true, length = 500)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono1", nullable = true, length = 12)
	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	@Column(name = "telefono2", nullable = true, length = 12)
	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	@Column(name = "georef", nullable = true, length = 100)
	public String getGeoref() {
		return georef;
	}

	public void setGeoref(String georef) {
		this.georef = georef;
	}

	@Column(name = "Manzana", nullable = true, length = 2)
	public String getManzana() {
		return Manzana;
	}

	public void setManzana(String manzana) {
		Manzana = manzana;
	}

	@Column(name = "georef_razon", nullable = true, length = 1)
	public String getGeoref_razon() {
		return georef_razon;
	}

	public void setGeoref_razon(String georef_razon) {
		this.georef_razon = georef_razon;
	}

	@Column(name = "georef_otraRazon", nullable = true, length = 100)
	public String getGeoref_otraRazon() {
		return georef_otraRazon;
	}

	public void setGeoref_otraRazon(String georef_otraRazon) {
		this.georef_otraRazon = georef_otraRazon;
	}

	@Column(name = "idTamizaje", nullable = true, length = 50)
	public String getIdTamizaje() {
		return idTamizaje;
	}

	public void setIdTamizaje(String idTamizaje) {
		this.idTamizaje = idTamizaje;
	}

	@Column(name = "encuesta", nullable = true, length = 1)
	public char getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(char encuesta) {
		this.encuesta = encuesta;
	}
	
	@Column(name = "encuestaEnt", nullable = true, length = 1)
	public char getEncuestaEnt() {
		return encuestaEnt;
	}

	public void setEncuestaEnt(char encuestaEnt) {
		this.encuestaEnt = encuestaEnt;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}
	
	public MovilInfo getMovilInfo() {
		return movilInfo;
	}


	@Override
	public boolean isFieldAuditable(String fieldname) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
