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
@Table(name = "reconsentimientoflu2015", catalog = "muestreoanual")
public class ReConsentimientoFlu2015 {

	
	/**
	 * 
	 */
	private ReConsentimientoFlu2015Id reconsfluId;
	private String visExit;
	private String noexitosa;
	private String nombrept;
	private String nombrept2;
	private String apellidopt;
	private String apellidopt2;
	private Integer relacionFam;
	private String otraRelacionFam;
	private Integer alfabetoTutor;
	private Integer testigoSN;
	private String nombretest1;
	private String nombretest2;
	private String apellidotest1;
	private String apellidotest2;
	private Integer cmDomicilio;
	private Integer barrio;
	private String otrobarrio;
	private String dire;
	private Integer telefContact;
	private Integer	telefonoConv1;
	private Integer	telefonoCel1;
	private Integer	telefonoCel2;
	private Integer asentimiento;
	private Integer parteAFlu;
	private Integer contacto_futuro;
	private Integer porqueno;
	private Integer parteBFlu;
	private Integer parteCFlu;
	private Integer local;
	
	private MovilInfo movilInfo;	
	private Integer otrorecurso1;
	private Integer otrorecurso2;
	
	
	

	
	@EmbeddedId
	public ReConsentimientoFlu2015Id getReconsfluId() {
		return reconsfluId;
	}

	public void setReconsfluId(ReConsentimientoFlu2015Id reconsfluId) {
		this.reconsfluId = reconsfluId;
	}
	
	@Column(name = "noexitosa", nullable = true, length = 1)
	public String getNoexitosa() {
		return noexitosa;
	}

	public void setNoexitosa(String noexitosa) {
		this.noexitosa = noexitosa;
	}

	@Column(name = "nombrept", nullable = true)
	public String getNombrept() {
		return nombrept;
	}

	public void setNombrept(String nombrept) {
		this.nombrept = nombrept;
	}

	@Column(name = "nombrept2", nullable = true)
	public String getNombrept2() {
		return nombrept2;
	}

	public void setNombrept2(String nombrept2) {
		this.nombrept2 = nombrept2;
	}

	@Column(name = "apellidopt", nullable = true)
	public String getApellidopt() {
		return apellidopt;
	}

	public void setApellidopt(String apellidopt) {
		this.apellidopt = apellidopt;
	}

	@Column(name = "apellidopt2", nullable = true)
	public String getApellidopt2() {
		return apellidopt2;
	}

	public void setApellidopt2(String apellidopt2) {
		this.apellidopt2 = apellidopt2;
	}
	
	@Column(name = "alfabetoTutor", nullable = true)
	public Integer getAlfabetoTutor() {
		return alfabetoTutor;
	}

	public void setAlfabetoTutor(Integer alfabetoTutor) {
		this.alfabetoTutor = alfabetoTutor;
	}

	@Column(name = "testigoSN", nullable = true)
	public Integer getTestigoSN() {
		return testigoSN;
	}

	public void setTestigoSN(Integer testigoSN) {
		this.testigoSN = testigoSN;
	}
	
	@Column(name = "nombretest1", nullable = true)
	public String getNombretest1() {
		return nombretest1;
	}

	public void setNombretest1(String nombretest1) {
		this.nombretest1 = nombretest1;
	}
	
	@Column(name = "nombretest2", nullable = true)
	public String getNombretest2() {
		return nombretest2;
	}

	public void setNombretest2(String nombretest2) {
		this.nombretest2 = nombretest2;
	}

	@Column(name = "apellidotest1", nullable = true)
	public String getApellidotest1() {
		return apellidotest1;
	}

	public void setApellidotest1(String apellidotest1) {
		this.apellidotest1 = apellidotest1;
	}

	@Column(name = "apellidotest2", nullable = true)
	public String getApellidotest2() {
		return apellidotest2;
	}

	public void setApellidotest2(String apellidotest2) {
		this.apellidotest2 = apellidotest2;
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
	
	@Column(name = "otrobarrio", nullable = true)
	public String getOtrobarrio() {
		return otrobarrio;
	}

	public void setOtrobarrio(String otrobarrio) {
		this.otrobarrio = otrobarrio;
	}
	
	@Column(name = "dire", nullable = true)
	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
	}
	
	@Column(name = "tiene_telef", nullable = true, length = 1)
	public Integer getTelefContact() {
		return telefContact;
	}

	public void setTelefContact(Integer telefContact) {
		this.telefContact = telefContact;
	}
	
	@Column(name = "telefonoConv1", nullable = true)
	public Integer getTelefonoConv1() {
		return telefonoConv1;
	}

	public void setTelefonoConv1(Integer telefonoConv1) {
		this.telefonoConv1 = telefonoConv1;
	}

	@Column(name = "telefonoCel1", nullable = true)
	public Integer getTelefonoCel1() {
		return telefonoCel1;
	}

	public void setTelefonoCel1(Integer telefonoCel1) {
		this.telefonoCel1 = telefonoCel1;
	}

	@Column(name = "telefonoCel2", nullable = true)
	public Integer getTelefonoCel2() {
		return telefonoCel2;
	}

	public void setTelefonoCel2(Integer telefonoCel2) {
		this.telefonoCel2 = telefonoCel2;
	}
	@Column(name = "parteaflu", nullable = true, length = 1)
	public Integer getParteAFlu() {
		return parteAFlu;
	}

	public void setParteAFlu(Integer parteAFlu) {
		this.parteAFlu = parteAFlu;
	}
	
	@Column(name = "contacto_futuro", nullable = true, length = 1)
	public Integer getContacto_futuro() {
		return contacto_futuro;
	}

	public void setContacto_futuro(Integer contacto_futuro) {
		this.contacto_futuro = contacto_futuro;
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

	@Column(name = "porqueno", nullable = true, length = 1)
	public Integer getPorqueno() {
		return porqueno;
	}

	public void setPorqueno(Integer porqueno) {
		this.porqueno = porqueno;
	}
	

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	@Column(name = "otrorecurso1", nullable = true)
	public Integer getOtrorecurso1() {
		return otrorecurso1;
	}

	public void setOtrorecurso1(Integer otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}

	@Column(name = "exitosa", nullable = true, length = 1)
	public String getVisExit() {
		return visExit;
	}

	public void setVisExit(String visExit) {
		this.visExit = visExit;
	}

	@Column(name = "relacionfam", nullable = true, length = 1)
	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
	}

	@Column(name = "otrarelacionfam", nullable = true, length = 100)
	public String getOtraRelacionFam() {
		return otraRelacionFam;
	}

	public void setOtraRelacionFam(String otraRelacionFam) {
		this.otraRelacionFam = otraRelacionFam;
	}

	@Column(name = "asentimiento", nullable = true, length = 1)
	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	@Column(name = "otrorecurso2", nullable = true)
	public Integer getOtrorecurso2() {
		return otrorecurso2;
	}

	public void setOtrorecurso2(Integer otrorecurso2) {
		this.otrorecurso2 = otrorecurso2;
	}

	@Column(name = "local", nullable = true, length = 1)
	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}
	
	

}
