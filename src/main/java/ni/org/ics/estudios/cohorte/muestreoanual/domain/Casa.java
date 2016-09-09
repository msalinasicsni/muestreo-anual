package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

/**
 * Simple objeto de dominio que representa los datos demograficos de la casa
 * donde habitan 1 o mas participantes de los
 * 
 * estudios
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "casas", catalog = "muestreoanual")
public class Casa {

	/**
	 * 
	 */
	private Integer codCasa;
	private Integer barrio;
	private Barrio barrioCasa;
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

	@Id
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

	@Column(name = "manzana", nullable = false, length = 2)
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

	@Column(name = "telefono1", nullable = false)
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

	@ManyToOne
	@JoinColumn(name="barrio", insertable = false, updatable = false)
	@ForeignKey(name = "FK_CASA_BARRIO")
	public Barrio getBarrioCasa() {
		return barrioCasa;
	}

	public void setBarrioCasa(Barrio barrioCasa) {
		this.barrioCasa = barrioCasa;
	}

	@Column(name = "en_casa", nullable = true)
	public String getEnCasa() {
		return enCasa;
	}

	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

	@Override
	public String toString(){
		return this.codCasa + " " + this.latitud+" "+this.longitud;
	}
}
