package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de reconsentimiento de Dengue
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "consentimientochik", catalog = "muestreoanual")
public class ConsentimientoChik {


	/**
	 * 
	 */
	private ConsentimientoChikId consChikId;
	private Integer autsup;
	private Integer parteFDen;
	private String rechazoDen;
	private String otroRechazoDen;
	private String incDen;
	private Integer autsup2;
	private String excDen;
	private Integer enfCronSN;
	private Integer enfCronica;
	private String oEnfCronica;
	private Integer tomaTx;
	private String cualesTx;
	private Integer autsup3;
	private Integer cmDomicilio;
	private Integer barrio;
	private Integer autsup4;
	private String dire;
	private Integer manzana;
	private Integer telefono;	
	private Integer asentimiento;
	private String firmcarta;
	private Integer relacionFam;
	private String coordenadas;
	private MovilInfo movilInfo;	

	
	@EmbeddedId
	public ConsentimientoChikId getConsChikId() {
		return consChikId;
	}

	public void setConsChikId(ConsentimientoChikId consChikId) {
		this.consChikId = consChikId;
	}

	@Column(name = "autsup", nullable = true, length = 1)
	public Integer getAutsup() {
		return autsup;
	}

	public void setAutsup(Integer autsup) {
		this.autsup = autsup;
	}

	@Column(name = "incden", nullable = true)
	public String getIncDen() {
		return incDen;
	}

	public void setIncDen(String incDen) {
		this.incDen = incDen;
	}
	@Column(name = "excden", nullable = true)
	public String getExcDen() {
		return excDen;
	}

	public void setExcDen(String excDen) {
		this.excDen = excDen;
	}

	@Column(name = "enfcronsn", nullable = true, length = 1)
	public Integer getEnfCronSN() {
		return enfCronSN;
	}

	public void setEnfCronSN(Integer enfCronSN) {
		this.enfCronSN = enfCronSN;
	}
	
	@Column(name = "enfCronica", nullable = true, length = 2)
	public Integer getEnfCronica() {
		return enfCronica;
	}
	
	public void setEnfCronica(Integer enfCronica) {
		this.enfCronica = enfCronica;
	}
	
	@Column(name = "oEnfCronica", nullable = true)
	public String getoEnfCronica() {
		return oEnfCronica;
	}

	public void setoEnfCronica(String oEnfCronica) {
		this.oEnfCronica = oEnfCronica;
	}
	
	@Column(name = "tomatx", nullable = true, length = 1)
	public Integer getTomaTx() {
		return tomaTx;
	}

	public void setTomaTx(Integer tomaTx) {
		this.tomaTx = tomaTx;
	}

	@Column(name = "cualestx", nullable = true)
	public String getCualesTx() {
		return cualesTx;
	}

	public void setCualesTx(String cualesTx) {
		this.cualesTx = cualesTx;
	}

	@Column(name = "cmdomicilio", nullable = true, length = 1)
	public Integer getCmDomicilio() {
		return cmDomicilio;
	}

	public void setCmDomicilio(Integer cmDomicilio) {
		this.cmDomicilio = cmDomicilio;
	}

	@Column(name = "barrio", nullable = true, length = 1)
	public Integer getBarrio() {
		return barrio;
	}

	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}

	@Column(name = "manzana", nullable = true, length = 2)
	public Integer getManzana() {
		return manzana;
	}
	
	public void setManzana(Integer manzana) {
		this.manzana = manzana;
	}

	@Column(name = "telefono", nullable = true, length = 8)
	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	@Column(name = "autsup2", nullable = true, length = 1)
	public Integer getAutsup2() {
		return autsup2;
	}

	public void setAutsup2(Integer autsup2) {
		this.autsup2 = autsup2;
	}
	
	@Column(name = "autsup3", nullable = true, length = 1)
	public Integer getAutsup3() {
		return autsup3;
	}

	public void setAutsup3(Integer autsup3) {
		this.autsup3 = autsup3;
	}
	
	@Column(name = "autsup4", nullable = true, length = 1)
	public Integer getAutsup4() {
		return autsup4;
	}

	public void setAutsup4(Integer autsup4) {
		this.autsup4 = autsup4;
	}

	@Column(name = "asentimiento", nullable = true, length = 1)
	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	@Column(name = "partefden", nullable = true, length = 1)
	public Integer getParteFDen() {
		return parteFDen;
	}

	public void setParteFDen(Integer parteFDen) {
		this.parteFDen = parteFDen;
	}

	@Column(name = "rechazoden", nullable = true)
	public String getRechazoDen() {
		return rechazoDen;
	}

	public void setRechazoDen(String rechazoDen) {
		this.rechazoDen = rechazoDen;
	}
	
	@Column(name = "otrorechazoden", nullable = true)
	public String getOtroRechazoDen() {
		return otroRechazoDen;
	}

	public void setOtroRechazoDen(String otroRechazoDen) {
		this.otroRechazoDen = otroRechazoDen;
	}

	@Column(name = "firmcarta", nullable = true)
	public String getFirmcarta() {
		return firmcarta;
	}

	public void setFirmcarta(String firmcarta) {
		this.firmcarta = firmcarta;
	}

	@Column(name = "relacionfam", nullable = true, length = 1)
	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
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

	@Column(name = "dire", nullable = true)
	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
	}

}
