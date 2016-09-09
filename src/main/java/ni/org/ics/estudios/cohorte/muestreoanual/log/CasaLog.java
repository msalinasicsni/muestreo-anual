package ni.org.ics.estudios.cohorte.muestreoanual.log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ni.org.ics.estudios.cohorte.muestreoanual.domain.MovilInfo;


/**
 * Simple objeto de dominio que representa los datos demograficos de la casa
 * donde habitan 1 o mas participantes de los
 * 
 * estudios
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "casas_log", catalog = "muestreoanual")
public class CasaLog {

	/**
	 * 
	 */
	private Integer idCasa;
	private Date created;
	private Integer codCasa;
	private Integer barrio;
	private String direccion;
	private Integer manzana;
	private Double latitud;
	private Double longitud;
	private Integer telCasa;
	private String coordenadas;
	private String jefenom;
	private String jefenom2;
	private String jefeap;
	private String jefeap2;
	private Integer telefono1;
	private Integer telefono2;
	private String nomContacto;
	private String direContacto;
	private Integer barrioContacto;
	private String otrobarrioContacto;
	private Integer telContacto1;
	private Integer telContacto2;
	private Integer vivienda;
	private Integer resd;
	private Integer inten;
	private String enCasa;
	private MovilInfo movilInfo;
	
	public CasaLog(){
		
	}
	
	
	public CasaLog(Date created, Integer codCasa,
			Integer barrio, String direccion, Integer manzana, Double latitud,
			Double longitud, Integer telCasa, String coordenadas,
			String jefenom, String jefenom2, String jefeap, String jefeap2,
			Integer telefono1, Integer telefono2, String nomContacto,
			String direContacto, Integer barrioContacto,
			String otrobarrioContacto, Integer telContacto1,
			Integer telContacto2, Integer vivienda, Integer resd,
			Integer inten, String enCasa, MovilInfo movilInfo) {
		super();
		this.created = created;
		this.codCasa = codCasa;
		this.barrio = barrio;
		this.direccion = direccion;
		this.manzana = manzana;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telCasa = telCasa;
		this.coordenadas = coordenadas;
		this.jefenom = jefenom;
		this.jefenom2 = jefenom2;
		this.jefeap = jefeap;
		this.jefeap2 = jefeap2;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.nomContacto = nomContacto;
		this.direContacto = direContacto;
		this.barrioContacto = barrioContacto;
		this.otrobarrioContacto = otrobarrioContacto;
		this.telContacto1 = telContacto1;
		this.telContacto2 = telContacto2;
		this.vivienda = vivienda;
		this.resd = resd;
		this.inten = inten;
		this.enCasa = enCasa;
		this.movilInfo = movilInfo;
	}

	@javax.persistence.Column(name = "id_casa")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer getIdCasa() {
		return idCasa;
	}
	
	public void setIdCasa(Integer idCasa) {
		this.idCasa = idCasa;
	}

	@Column(name = "fecha_creacion", nullable = false)
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Column(name = "cod_casa", nullable = false, length = 4)
	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	@Column(name = "barrio", nullable = false, length = 2)
	public Integer getBarrio() {
		return barrio;
	}

	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}

	@Column(name = "direccion", nullable = false)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "manzana", nullable = true, length = 2)
	public Integer getManzana() {
		return manzana;
	}

	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	@Column(name = "latitud", nullable = true)
	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", nullable = true)
	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	@Column(name = "tel_casa", nullable = true)
	public Integer getTelCasa() {
		return telCasa;
	}

	public void setTelCasa(Integer telCasa) {
		this.telCasa = telCasa;
	}

	@Column(name = "coordenadas", nullable = true)
	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	@Column(name = "jefenom", nullable = false)
	public String getJefenom() {
		return jefenom;
	}

	public void setJefenom(String jefenom) {
		this.jefenom = jefenom;
	}

	@Column(name = "jefenom2", nullable = true)
	public String getJefenom2() {
		return jefenom2;
	}

	public void setJefenom2(String jefenom2) {
		this.jefenom2 = jefenom2;
	}

	@Column(name = "jefeap", nullable = false)
	public String getJefeap() {
		return jefeap;
	}

	public void setJefeap(String jefeap) {
		this.jefeap = jefeap;
	}

	@Column(name = "jefeap2", nullable = true)
	public String getJefeap2() {
		return jefeap2;
	}

	public void setJefeap2(String jefeap2) {
		this.jefeap2 = jefeap2;
	}

	@Column(name = "telefono1", nullable = true)
	public Integer getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1 = telefono1;
	}

	@Column(name = "telefono2", nullable = true)
	public Integer getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2 = telefono2;
	}

	@Column(name = "nom_contacto", nullable = false)
	public String getNomContacto() {
		return nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	@Column(name = "dire_contacto", nullable = false)
	public String getDireContacto() {
		return direContacto;
	}

	public void setDireContacto(String direContacto) {
		this.direContacto = direContacto;
	}

	@Column(name = "barrio_contacto", nullable = false, length = 2)
	public Integer getBarrioContacto() {
		return barrioContacto;
	}

	public void setBarrioContacto(Integer barrioContacto) {
		this.barrioContacto = barrioContacto;
	}

	@Column(name = "otrobarriocontacto", nullable = true)
	public String getOtrobarrioContacto() {
		return otrobarrioContacto;
	}

	public void setOtrobarrioContacto(String otrobarrioContacto) {
		this.otrobarrioContacto = otrobarrioContacto;
	}

	@Column(name = "tel_contacto1", nullable = true)
	public Integer getTelContacto1() {
		return telContacto1;
	}

	public void setTelContacto1(Integer telContacto1) {
		this.telContacto1 = telContacto1;
	}

	@Column(name = "tel_contacto2", nullable = true)
	public Integer getTelContacto2() {
		return telContacto2;
	}

	public void setTelContacto2(Integer telContacto2) {
		this.telContacto2 = telContacto2;
	}

	@Column(name = "vivienda", nullable = false, length = 1)
	public Integer getVivienda() {
		return vivienda;
	}

	public void setVivienda(Integer vivienda) {
		this.vivienda = vivienda;
	}

	@Column(name = "resd", nullable = false, length = 1)
	public Integer getResd() {
		return resd;
	}

	public void setResd(Integer resd) {
		this.resd = resd;
	}

	@Column(name = "inten", nullable = false, length = 1)
	public Integer getInten() {
		return inten;
	}

	public void setInten(Integer inten) {
		this.inten = inten;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}


	@Column(name = "en_casa", nullable = true)
	public String getEnCasa() {
		return enCasa;
	}


	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

}
