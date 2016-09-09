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
@Table(name = "cambioestudio", catalog = "muestreoanual")
public class CambioEstudio {

	/**
	 * 
	 */
	private CambioEstudioId cambioEstudioId;
	
	private Integer parteAFlu;
	private String rechazoFlu;
	private Integer parteADen;
	private String rechazoDen;
	private String incFlu;
	private String excFlu;
	private String incDen;
	private String excDen;
	
	private Integer enfCronSN;
	private Integer enfCronica;
	private String oEnfCronica;
	private Integer tomaTx;
	private String cualesTx;
	
	private Integer asentimiento;
	
	private Integer parteBFlu;
	private Integer parteCFlu;
	
	private Integer parteBDen;
	private Integer parteCDen;
	private Integer parteDDen;
	private Integer parteEDen;
	private Integer parteFDen;
	private Integer asentimientoesc;
	private String firmcarta;
	private Integer relacionFam;
	private MovilInfo movilInfo;	

	
	@EmbeddedId
	public CambioEstudioId getCambioEstudioId() {
		return cambioEstudioId;
	}

	public void setCambioEstudioId(CambioEstudioId cambioEstudioId) {
		this.cambioEstudioId = cambioEstudioId;
	}
	
	@Column(name = "parteaflu", nullable = true, length = 1)
	public Integer getParteAFlu() {
		return parteAFlu;
	}

	public void setParteAFlu(Integer parteAFlu) {
		this.parteAFlu = parteAFlu;
	}

	@Column(name = "rechazoflu", nullable = true)
	public String getRechazoFlu() {
		return rechazoFlu;
	}

	public void setRechazoFlu(String rechazoFlu) {
		this.rechazoFlu = rechazoFlu;
	}

	@Column(name = "parteaden", nullable = true, length = 1)
	public Integer getParteADen() {
		return parteADen;
	}

	public void setParteADen(Integer parteADen) {
		this.parteADen = parteADen;
	}

	@Column(name = "rechazoden", nullable = true)
	public String getRechazoDen() {
		return rechazoDen;
	}

	public void setRechazoDen(String rechazoDen) {
		this.rechazoDen = rechazoDen;
	}
	
	@Column(name = "incflu", nullable = true)
	public String getIncFlu() {
		return incFlu;
	}

	public void setIncFlu(String incFlu) {
		this.incFlu = incFlu;
	}
	@Column(name = "excflu", nullable = true)
	public String getExcFlu() {
		return excFlu;
	}

	public void setExcFlu(String excFlu) {
		this.excFlu = excFlu;
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

	
	@Column(name = "asentimiento", nullable = true, length = 1)
	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}
	
	@Column(name = "partebflu", nullable = true, length = 1)
	public Integer getParteBFlu() {
		return parteBFlu;
	}

	public void setParteBFlu(Integer parteBFlu) {
		this.parteBFlu = parteBFlu;
	}

	@Column(name = "partecflu", nullable = true, length = 1)
	public Integer getParteCFlu() {
		return parteCFlu;
	}

	public void setParteCFlu(Integer parteCFlu) {
		this.parteCFlu = parteCFlu;
	}
	
	@Column(name = "partebden", nullable = true, length = 1)
	public Integer getParteBDen() {
		return parteBDen;
	}

	public void setParteBDen(Integer parteBDen) {
		this.parteBDen = parteBDen;
	}

	@Column(name = "partecden", nullable = true, length = 1)
	public Integer getParteCDen() {
		return parteCDen;
	}

	public void setParteCDen(Integer parteCDen) {
		this.parteCDen = parteCDen;
	}

	@Column(name = "partedden", nullable = true, length = 1)
	public Integer getParteDDen() {
		return parteDDen;
	}

	public void setParteDDen(Integer parteDDen) {
		this.parteDDen = parteDDen;
	}

	@Column(name = "parteeden", nullable = true, length = 1)
	public Integer getParteEDen() {
		return parteEDen;
	}

	public void setParteEDen(Integer parteEDen) {
		this.parteEDen = parteEDen;
	}
	
	@Column(name = "partefden", nullable = true, length = 1)
	public Integer getParteFDen() {
		return parteFDen;
	}

	public void setParteFDen(Integer parteFDen) {
		this.parteFDen = parteFDen;
	}
	
	@Column(name = "asentimientoesc", nullable = true, length = 1)
	public Integer getAsentimientoesc() {
		return asentimientoesc;
	}

	public void setAsentimientoesc(Integer asentimientoesc) {
		this.asentimientoesc = asentimientoesc;
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

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

}
