package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de la visita al terreno
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "visitasterreno", catalog = "muestreoanual")
public class VisitaTerreno {

	/**
	 * 
	 */
	private VisitaTerrenoId visitaId;
	private Integer visitaSN;
	private Integer motNoVisita;
	private String acomp;
	private Integer relacionFam;
	private Integer asentimiento;
	private Integer cDom;
	private Integer barrio;
	private Integer manzana;
	private String direccion;
	private String coordenadas;
	private Double latitud;
	private Double longitud;
	private MovilInfo movilInfo;


	@EmbeddedId
	public VisitaTerrenoId getVisitaId() {
		return visitaId;
	}

	public void setVisitaId(VisitaTerrenoId visitaId) {
		this.visitaId = visitaId;
	}

	@Column(name = "visitasn", nullable = false, length = 1)
	public Integer getVisitaSN() {
		return visitaSN;
	}

	public void setVisitaSN(Integer visitaSN) {
		this.visitaSN = visitaSN;
	}

	@Column(name = "motnovisita", nullable = true)
	public Integer getMotNoVisita() {
		return motNoVisita;
	}

	public void setMotNoVisita(Integer motNoVisita) {
		this.motNoVisita = motNoVisita;
	}

	@Column(name = "acomp", nullable = true)
	public String getAcomp() {
		return acomp;
	}

	public void setAcomp(String acomp) {
		this.acomp = acomp;
	}

	@Column(name = "relacion_fam", nullable = true)
	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
	}
	
	
	@Column(name = "asentimiento", nullable = true)
	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	@Column(name = "cdom", nullable = true)
	public Integer getcDom() {
		return cDom;
	}

	public void setcDom(Integer cDom) {
		this.cDom = cDom;
	}

	@Column(name = "barrio", nullable = true)
	public Integer getBarrio() {
		return barrio;
	}

	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}

	@Column(name = "direccion", nullable = true)
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "manzana", nullable = true)
	public Integer getManzana() {
		return manzana;
	}

	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	@Column(name = "coordenadas", nullable = true)
	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
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
}
