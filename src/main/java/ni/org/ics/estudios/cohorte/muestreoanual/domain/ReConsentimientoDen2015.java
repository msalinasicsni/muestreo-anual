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
@Table(name = "reconsentimientoden2015", catalog = "muestreoanual")
public class ReConsentimientoDen2015 {

	/**
	 * 
	 */
	private ReConsentimientoDen2015Id reconsdenId;
	
	private String visExit;
	private String razonVisNoExit;
	private String personaDejoCarta;
	private String personaCasa;
	private String relacionFamPersonaCasa;
	private String otraRelacionPersonaCasa;
	private Integer telefonoPersonaCasa;
	private String emancipado;
	private String descEmancipado;
	private String incDen;
	private String excDen;
	private Integer enfCronSN;
	private Integer enfCronica;
	private String oEnfCronica;
	private Integer tomaTx;
	private String cualesTx;
	private Integer assite;
	private Integer centrosalud;
	private String ocentrosalud;
	private Integer puestosalud;
	private Integer asentimiento;
	private Integer parteADen;
	private Integer parteBDen;
	private Integer parteCDen;
	private Integer parteDDen;
	private String rechDen;
	private String nombrept;
	private String nombrept2;
	private String apellidopt;
	private String apellidopt2;
	private Integer relacionFam;
	private String otraRelacionFam;
	private Integer mismoTutorSN;
	private Integer motivoDifTutor;
	private String otroMotivoDifTutor;
	private String quePaisTutor;
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
	private Integer autsup;
	private Integer telefonoClasif1;
	private Integer	telefonoConv1;
	private Integer	telefonoCel1;
	private Integer telefono2SN;
	private Integer telefonoClasif2;
	private Integer	telefonoConv2;
	private Integer	telefonoCel2;
	private Integer telefono3SN;
	private Integer telefonoClasif3;
	private Integer	telefonoConv3;
	private Integer	telefonoCel3;
	private String jefenom;
	private String jefenom2;
	private String jefeap;
	private String jefeap2;
	private String nomContacto;
	private Integer	barrioContacto;
	private String otrobarrioContacto;
	private String direContacto;
	private Integer telContacto1;
	private Integer	telContactoConv1;
	private Integer	telContactoCel1;
	private Integer telContacto2SN;
	private Integer telContactoClasif2;
	private Integer	telContactoConv2;
	private Integer	telContactoCel2;
	private String nombrepadre;
	private String nombrepadre2;
	private String apellidopadre;
	private String apellidopadre2;
	private String nombremadre;
	private String nombremadre2;
	private String apellidomadre;
	private String apellidomadre2;
	private Integer copiaFormato;
	private Integer firmo_cartcons;
	private Integer fecho_cartcons;
	private Integer huella_dig;
	private Integer fech_firm_testigo;
	private Integer entiende;
	private String georef;
	private Integer Manzana;
	private String georef_razon;
	private String georef_otraRazon;
	private Integer local;
	private MovilInfo movilInfo;	
	private Integer otrorecurso1;
	private Integer otrorecurso2;

	
	@EmbeddedId
	public ReConsentimientoDen2015Id getReconsdenId() {
		return reconsdenId;
	}

	public void setReconsdenId(ReConsentimientoDen2015Id reconsdenId) {
		this.reconsdenId = reconsdenId;
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


	@Column(name = "asentimiento", nullable = true, length = 1)
	public Integer getAsentimiento() {
		return asentimiento;
	}

	public void setAsentimiento(Integer asentimiento) {
		this.asentimiento = asentimiento;
	}

	@Column(name = "parteaden", nullable = true, length = 1)
	public Integer getParteADen() {
		return parteADen;
	}

	public void setParteADen(Integer parteADen) {
		this.parteADen = parteADen;
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

	@Column(name = "dire", nullable = true)
	public String getDire() {
		return dire;
	}

	public void setDire(String dire) {
		this.dire = dire;
	}

	@Column(name = "visExit", nullable = true)
	public String getVisExit() {
		return visExit;
	}

	public void setVisExit(String visExit) {
		this.visExit = visExit;
	}

	@Column(name = "razonVisNoExit", nullable = true)
	public String getRazonVisNoExit() {
		return razonVisNoExit;
	}

	public void setRazonVisNoExit(String razonVisNoExit) {
		this.razonVisNoExit = razonVisNoExit;
	}

	@Column(name = "personaDejoCarta", nullable = true)
	public String getPersonaDejoCarta() {
		return personaDejoCarta;
	}

	public void setPersonaDejoCarta(String personaDejoCarta) {
		this.personaDejoCarta = personaDejoCarta;
	}

	@Column(name = "personaCasa", nullable = true)
	public String getPersonaCasa() {
		return personaCasa;
	}

	public void setPersonaCasa(String personaCasa) {
		this.personaCasa = personaCasa;
	}

	@Column(name = "relacionFamPersonaCasa", nullable = true)
	public String getRelacionFamPersonaCasa() {
		return relacionFamPersonaCasa;
	}

	public void setRelacionFamPersonaCasa(String relacionFamPersonaCasa) {
		this.relacionFamPersonaCasa = relacionFamPersonaCasa;
	}

	@Column(name = "otraRelacionPersonaCasa", nullable = true)
	public String getOtraRelacionPersonaCasa() {
		return otraRelacionPersonaCasa;
	}

	public void setOtraRelacionPersonaCasa(String otraRelacionPersonaCasa) {
		this.otraRelacionPersonaCasa = otraRelacionPersonaCasa;
	}

	@Column(name = "telefonoPersonaCasa", nullable = true)
	public Integer getTelefonoPersonaCasa() {
		return telefonoPersonaCasa;
	}

	public void setTelefonoPersonaCasa(Integer telefonoPersonaCasa) {
		this.telefonoPersonaCasa = telefonoPersonaCasa;
	}

	@Column(name = "emancipado", nullable = true)
	public String getEmancipado() {
		return emancipado;
	}

	public void setEmancipado(String emancipado) {
		this.emancipado = emancipado;
	}

	@Column(name = "descEmancipado", nullable = true)
	public String getDescEmancipado() {
		return descEmancipado;
	}

	public void setDescEmancipado(String descEmancipado) {
		this.descEmancipado = descEmancipado;
	}

	@Column(name = "assite", nullable = true)
	public Integer getAssite() {
		return assite;
	}

	public void setAssite(Integer assite) {
		this.assite = assite;
	}

	@Column(name = "centrosalud", nullable = true)
	public Integer getCentrosalud() {
		return centrosalud;
	}

	public void setCentrosalud(Integer centrosalud) {
		this.centrosalud = centrosalud;
	}

	@Column(name = "ocentrosalud", nullable = true)
	public String getOcentrosalud() {
		return ocentrosalud;
	}

	public void setOcentrosalud(String ocentrosalud) {
		this.ocentrosalud = ocentrosalud;
	}

	@Column(name = "puestosalud", nullable = true)
	public Integer getPuestosalud() {
		return puestosalud;
	}

	public void setPuestosalud(Integer puestosalud) {
		this.puestosalud = puestosalud;
	}

	@Column(name = "rechDen", nullable = true)
	public String getRechDen() {
		return rechDen;
	}

	public void setRechDen(String rechDen) {
		this.rechDen = rechDen;
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

	@Column(name = "otraRelacionFam", nullable = true)
	public String getOtraRelacionFam() {
		return otraRelacionFam;
	}

	public void setOtraRelacionFam(String otraRelacionFam) {
		this.otraRelacionFam = otraRelacionFam;
	}

	@Column(name = "mismoTutorSN", nullable = true)
	public Integer getMismoTutorSN() {
		return mismoTutorSN;
	}

	public void setMismoTutorSN(Integer mismoTutorSN) {
		this.mismoTutorSN = mismoTutorSN;
	}

	@Column(name = "motivoDifTutor", nullable = true)
	public Integer getMotivoDifTutor() {
		return motivoDifTutor;
	}

	public void setMotivoDifTutor(Integer motivoDifTutor) {
		this.motivoDifTutor = motivoDifTutor;
	}

	@Column(name = "otroMotivoDifTutor", nullable = true)
	public String getOtroMotivoDifTutor() {
		return otroMotivoDifTutor;
	}

	public void setOtroMotivoDifTutor(String otroMotivoDifTutor) {
		this.otroMotivoDifTutor = otroMotivoDifTutor;
	}

	@Column(name = "quePaisTutor", nullable = true)
	public String getQuePaisTutor() {
		return quePaisTutor;
	}

	public void setQuePaisTutor(String quePaisTutor) {
		this.quePaisTutor = quePaisTutor;
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

	@Column(name = "otrobarrio", nullable = true)
	public String getOtrobarrio() {
		return otrobarrio;
	}

	public void setOtrobarrio(String otrobarrio) {
		this.otrobarrio = otrobarrio;
	}

	@Column(name = "telefonoClasif1", nullable = true)
	public Integer getTelefonoClasif1() {
		return telefonoClasif1;
	}

	public void setTelefonoClasif1(Integer telefonoClasif1) {
		this.telefonoClasif1 = telefonoClasif1;
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

	@Column(name = "telefono2SN", nullable = true)
	public Integer getTelefono2SN() {
		return telefono2SN;
	}

	public void setTelefono2SN(Integer telefono2sn) {
		telefono2SN = telefono2sn;
	}

	@Column(name = "telefonoClasif2", nullable = true)
	public Integer getTelefonoClasif2() {
		return telefonoClasif2;
	}

	public void setTelefonoClasif2(Integer telefonoClasif2) {
		this.telefonoClasif2 = telefonoClasif2;
	}

	@Column(name = "telefonoConv2", nullable = true)
	public Integer getTelefonoConv2() {
		return telefonoConv2;
	}

	public void setTelefonoConv2(Integer telefonoConv2) {
		this.telefonoConv2 = telefonoConv2;
	}

	@Column(name = "telefonoCel2", nullable = true)
	public Integer getTelefonoCel2() {
		return telefonoCel2;
	}

	public void setTelefonoCel2(Integer telefonoCel2) {
		this.telefonoCel2 = telefonoCel2;
	}

	@Column(name = "telefono3SN", nullable = true)
	public Integer getTelefono3SN() {
		return telefono3SN;
	}

	public void setTelefono3SN(Integer telefono3sn) {
		telefono3SN = telefono3sn;
	}

	@Column(name = "telefonoClasif3", nullable = true)
	public Integer getTelefonoClasif3() {
		return telefonoClasif3;
	}

	public void setTelefonoClasif3(Integer telefonoClasif3) {
		this.telefonoClasif3 = telefonoClasif3;
	}

	@Column(name = "telefonoConv3", nullable = true)
	public Integer getTelefonoConv3() {
		return telefonoConv3;
	}

	public void setTelefonoConv3(Integer telefonoConv3) {
		this.telefonoConv3 = telefonoConv3;
	}

	@Column(name = "telefonoCel3", nullable = true)
	public Integer getTelefonoCel3() {
		return telefonoCel3;
	}

	public void setTelefonoCel3(Integer telefonoCel3) {
		this.telefonoCel3 = telefonoCel3;
	}

	@Column(name = "jefenom", nullable = true)
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

	@Column(name = "jefeap", nullable = true)
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

	@Column(name = "nomContacto", nullable = true)
	public String getNomContacto() {
		return nomContacto;
	}

	public void setNomContacto(String nomContacto) {
		this.nomContacto = nomContacto;
	}

	@Column(name = "barrioContacto", nullable = true)
	public Integer getBarrioContacto() {
		return barrioContacto;
	}

	public void setBarrioContacto(Integer barrioContacto) {
		this.barrioContacto = barrioContacto;
	}

	@Column(name = "otrobarrioContacto", nullable = true)
	public String getOtrobarrioContacto() {
		return otrobarrioContacto;
	}

	public void setOtrobarrioContacto(String otrobarrioContacto) {
		this.otrobarrioContacto = otrobarrioContacto;
	}

	@Column(name = "direContacto", nullable = true)
	public String getDireContacto() {
		return direContacto;
	}

	public void setDireContacto(String direContacto) {
		this.direContacto = direContacto;
	}

	@Column(name = "telContacto1", nullable = true)
	public Integer getTelContacto1() {
		return telContacto1;
	}

	public void setTelContacto1(Integer telContacto1) {
		this.telContacto1 = telContacto1;
	}

	@Column(name = "telContactoConv1", nullable = true)
	public Integer getTelContactoConv1() {
		return telContactoConv1;
	}

	public void setTelContactoConv1(Integer telContactoConv1) {
		this.telContactoConv1 = telContactoConv1;
	}

	@Column(name = "telContactoCel1", nullable = true)
	public Integer getTelContactoCel1() {
		return telContactoCel1;
	}

	public void setTelContactoCel1(Integer telContactoCel1) {
		this.telContactoCel1 = telContactoCel1;
	}

	@Column(name = "telContacto2SN", nullable = true)
	public Integer getTelContacto2SN() {
		return telContacto2SN;
	}

	public void setTelContacto2SN(Integer telContacto2SN) {
		this.telContacto2SN = telContacto2SN;
	}

	@Column(name = "telContactoClasif2", nullable = true)
	public Integer getTelContactoClasif2() {
		return telContactoClasif2;
	}

	public void setTelContactoClasif2(Integer telContactoClasif2) {
		this.telContactoClasif2 = telContactoClasif2;
	}

	@Column(name = "telContactoConv2", nullable = true)
	public Integer getTelContactoConv2() {
		return telContactoConv2;
	}

	public void setTelContactoConv2(Integer telContactoConv2) {
		this.telContactoConv2 = telContactoConv2;
	}

	@Column(name = "telContactoCel2", nullable = true)
	public Integer getTelContactoCel2() {
		return telContactoCel2;
	}

	public void setTelContactoCel2(Integer telContactoCel2) {
		this.telContactoCel2 = telContactoCel2;
	}

	@Column(name = "nombrepadre", nullable = true)
	public String getNombrepadre() {
		return nombrepadre;
	}

	public void setNombrepadre(String nombrepadre) {
		this.nombrepadre = nombrepadre;
	}

	@Column(name = "nombrepadre2", nullable = true)
	public String getNombrepadre2() {
		return nombrepadre2;
	}

	public void setNombrepadre2(String nombrepadre2) {
		this.nombrepadre2 = nombrepadre2;
	}

	@Column(name = "apellidopadre", nullable = true)
	public String getApellidopadre() {
		return apellidopadre;
	}

	public void setApellidopadre(String apellidopadre) {
		this.apellidopadre = apellidopadre;
	}

	@Column(name = "apellidopadre2", nullable = true)
	public String getApellidopadre2() {
		return apellidopadre2;
	}

	public void setApellidopadre2(String apellidopadre2) {
		this.apellidopadre2 = apellidopadre2;
	}

	@Column(name = "nombremadre", nullable = true)
	public String getNombremadre() {
		return nombremadre;
	}

	public void setNombremadre(String nombremadre) {
		this.nombremadre = nombremadre;
	}

	@Column(name = "nombremadre2", nullable = true)
	public String getNombremadre2() {
		return nombremadre2;
	}

	public void setNombremadre2(String nombremadre2) {
		this.nombremadre2 = nombremadre2;
	}

	@Column(name = "apellidomadre", nullable = true)
	public String getApellidomadre() {
		return apellidomadre;
	}

	public void setApellidomadre(String apellidomadre) {
		this.apellidomadre = apellidomadre;
	}

	@Column(name = "apellidomadre2", nullable = true)
	public String getApellidomadre2() {
		return apellidomadre2;
	}

	public void setApellidomadre2(String apellidomadre2) {
		this.apellidomadre2 = apellidomadre2;
	}

	@Column(name = "copiaFormato", nullable = true)
	public Integer getCopiaFormato() {
		return copiaFormato;
	}

	public void setCopiaFormato(Integer copiaFormato) {
		this.copiaFormato = copiaFormato;
	}

	@Column(name = "firmo_cartcons", nullable = true)
	public Integer getFirmo_cartcons() {
		return firmo_cartcons;
	}

	public void setFirmo_cartcons(Integer firmo_cartcons) {
		this.firmo_cartcons = firmo_cartcons;
	}

	@Column(name = "fecho_cartcons", nullable = true)
	public Integer getFecho_cartcons() {
		return fecho_cartcons;
	}

	public void setFecho_cartcons(Integer fecho_cartcons) {
		this.fecho_cartcons = fecho_cartcons;
	}

	@Column(name = "huella_dig", nullable = true)
	public Integer getHuella_dig() {
		return huella_dig;
	}

	public void setHuella_dig(Integer huella_dig) {
		this.huella_dig = huella_dig;
	}

	@Column(name = "fech_firm_testigo", nullable = true)
	public Integer getFech_firm_testigo() {
		return fech_firm_testigo;
	}

	public void setFech_firm_testigo(Integer fech_firm_testigo) {
		this.fech_firm_testigo = fech_firm_testigo;
	}

	@Column(name = "entiende", nullable = true)
	public Integer getEntiende() {
		return entiende;
	}

	public void setEntiende(Integer entiende) {
		this.entiende = entiende;
	}
	
	@Column(name = "georef", nullable = true)
	public String getGeoref() {
		return georef;
	}

	public void setGeoref(String georef) {
		this.georef = georef;
	}

	@Column(name = "Manzana", nullable = true)
	public Integer getManzana() {
		return Manzana;
	}

	public void setManzana(Integer manzana) {
		Manzana = manzana;
	}

	@Column(name = "georef_razon", nullable = true)
	public String getGeoref_razon() {
		return georef_razon;
	}

	public void setGeoref_razon(String georef_razon) {
		this.georef_razon = georef_razon;
	}

	@Column(name = "georef_otraRazon", nullable = true)
	public String getGeoref_otraRazon() {
		return georef_otraRazon;
	}

	public void setGeoref_otraRazon(String georef_otraRazon) {
		this.georef_otraRazon = georef_otraRazon;
	}

	@Column(name = "local", nullable = true)
	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}
	
	@Column(name = "otrorecurso1", nullable = true)
	public Integer getOtrorecurso1() {
		return otrorecurso1;
	}

	public void setOtrorecurso1(Integer otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}

	@Column(name = "otrorecurso2", nullable = true)
	public Integer getOtrorecurso2() {
		return otrorecurso2;
	}

	public void setOtrorecurso2(Integer otrorecurso2) {
		this.otrorecurso2 = otrorecurso2;
	}

}
