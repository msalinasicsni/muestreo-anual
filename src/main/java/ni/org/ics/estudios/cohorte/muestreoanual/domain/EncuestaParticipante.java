package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de la encuesta de los
 * participantes en el estudio
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "encuestas_participantes", catalog = "muestreoanual")
public class EncuestaParticipante {

	/**
	 * 
	 */
	private EncuestaParticipanteId epId;
	private Integer fiebre;
	private Integer tiemFieb;
	private Integer lugarCons;
	private Integer noCs;
	private String automed;
	private Integer escuela;
	private Integer grado;
	private Integer turno;
	private Integer nEscuela;
	private String otraEscuela;
	private Integer cuidan;
	private Integer cuantosCuidan;
	private Integer cqVive;
	private Integer lugarPart;
	private Integer papaAlf;
	private Integer papaNivel;
	private Integer papaTra;
	private Integer papaTipoTra;
	private Integer mamaAlf;
	private Integer mamaNivel;
	private Integer mamaTra;
	private Integer mamaTipoTra;
	private Integer comparteHab;
	private Integer hab1;
	private Integer hab2;
	private Integer hab3;
	private Integer hab4;
	private Integer hab5;
	private Integer hab6;
	private Integer comparteCama;
	private Integer cama1;
	private Integer cama2;
	private Integer cama3;
	private Integer cama4;
	private Integer cama5;
	private Integer cama6;
	private Integer asma;
	private Integer silb12m;
	private Integer sitResf;
	private Integer sitEjer;
	private Integer silbMesPas;
	private Integer difHablar;
	private Integer vecHablar;
	private Integer difDormir;
	private Integer suenoPer;
	private Integer tos12m;
	private Integer vecesTos;
	private Integer tos3Dias;
	private Integer hosp12m;
	private Integer med12m;
	private Integer dep12m;
	private Integer crisis;
	private Integer frecAsma;
	private Integer FumaSN;
	private String quienFuma;
	private Integer cantCigarrosMadre;
	private Integer cantCigarrosPadre;
	private Integer cantCigarrosOtros;
	
	
	private Integer rash;
	private Integer mesActual;
	private Integer yearActual;
	private Integer rash_year;
	private Integer rash_mes;
	private Integer rash_mesact;
	private Integer rashCara;
	private Integer rashMiembrosSup;
	private Integer rashTorax;
	private Integer rashAbdomen;
	private Integer rashMiembrosInf;
	private Integer rashDias;
	private Integer ojoRojo;
	private Integer ojoRojo_year;
	private Integer ojoRojo_mes;
	private Integer ojoRojo_mesact;
	private Integer ojoRojo_Dias;
	private Integer hormigueo;
	private Integer hormigueo_year;
	private Integer hormigueo_mes;
	private Integer hormigueo_mesact;
	private Integer hormigueo_Dias;
	private Integer consultaRashHormigueo;
	private Integer uSaludRashHormigueo;
	private Integer cSaludRashHormigueo;
	private String oCSRashHormigueo;
	private Integer pSRashHormigueo;
	private String oPSRashHormigueo;
	private String diagRashHormigueo;
	private String chPapaMama;
	private Date fechana_papa;
	private Integer cal_edad_papa;
	private Integer cal_edad2_papa;
	private String nombpapa1;
	private String nombpapa2;
	private String apellipapa1;
	private String apellipapa2;
	private Date fechana_mama;
	private Integer cal_edad_mama;
	private Integer cal_edad2_mama;
	private String nombmama1;
	private String nombmama2;
	private String apellimama1;
	private String apellimama2;
	
	

	private MovilInfo movilInfo;

	@EmbeddedId
	public EncuestaParticipanteId getEpId() {
		return epId;
	}

	public void setEpId(EncuestaParticipanteId epId) {
		this.epId = epId;
	}

	@Column(name = "fiebre", nullable = true, length = 1)
	public Integer getFiebre() {
		return fiebre;
	}

	public void setFiebre(Integer fiebre) {
		this.fiebre = fiebre;
	}

	@Column(name = "tiemfieb", nullable = true, length = 1)
	public Integer getTiemFieb() {
		return tiemFieb;
	}

	public void setTiemFieb(Integer tiemFieb) {
		this.tiemFieb = tiemFieb;
	}

	@Column(name = "lugarcons", nullable = true, length = 1)
	public Integer getLugarCons() {
		return lugarCons;
	}

	public void setLugarCons(Integer lugarCons) {
		this.lugarCons = lugarCons;
	}

	@Column(name = "nocs", nullable = true)
	public Integer getNoCs() {
		return noCs;
	}

	public void setNoCs(Integer noCs) {
		this.noCs = noCs;
	}

	@Column(name = "automed", nullable = true)
	public String getAutomed() {
		return automed;
	}

	public void setAutomed(String automed) {
		this.automed = automed;
	}

	@Column(name = "escuela", nullable = true)
	public Integer getEscuela() {
		return escuela;
	}

	public void setEscuela(Integer escuela) {
		this.escuela = escuela;
	}

	@Column(name = "grado", nullable = true)
	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	@Column(name = "turno", nullable = true)
	public Integer getTurno() {
		return turno;
	}

	public void setTurno(Integer turno) {
		this.turno = turno;
	}

	@Column(name = "nescuela", nullable = true)
	public Integer getnEscuela() {
		return nEscuela;
	}

	public void setnEscuela(Integer nEscuela) {
		this.nEscuela = nEscuela;
	}

	@Column(name = "otraescuela", nullable = true, length = 50)
	public String getOtraEscuela() {
		return otraEscuela;
	}

	public void setOtraEscuela(String otraEscuela) {
		this.otraEscuela = otraEscuela;
	}

	@Column(name = "cuidan", nullable = true)
	public Integer getCuidan() {
		return cuidan;
	}

	public void setCuidan(Integer cuidan) {
		this.cuidan = cuidan;
	}

	@Column(name = "cuantoscuidan", nullable = true)
	public Integer getCuantosCuidan() {
		return cuantosCuidan;
	}

	public void setCuantosCuidan(Integer cuantosCuidan) {
		this.cuantosCuidan = cuantosCuidan;
	}

	@Column(name = "cqvive", nullable = true)
	public Integer getCqVive() {
		return cqVive;
	}

	public void setCqVive(Integer cqVive) {
		this.cqVive = cqVive;
	}

	@Column(name = "num_parto", nullable = true)
	public Integer getLugarPart() {
		return lugarPart;
	}

	public void setLugarPart(Integer lugarPart) {
		this.lugarPart = lugarPart;
	}

	@Column(name = "papaalf", nullable = true)
	public Integer getPapaAlf() {
		return papaAlf;
	}

	public void setPapaAlf(Integer papaAlf) {
		this.papaAlf = papaAlf;
	}

	@Column(name = "papanivel", nullable = true)
	public Integer getPapaNivel() {
		return papaNivel;
	}

	public void setPapaNivel(Integer papaNivel) {
		this.papaNivel = papaNivel;
	}

	@Column(name = "papatra", nullable = true)
	public Integer getPapaTra() {
		return papaTra;
	}

	public void setPapaTra(Integer papaTra) {
		this.papaTra = papaTra;
	}

	@Column(name = "papatipotra", nullable = true)
	public Integer getPapaTipoTra() {
		return papaTipoTra;
	}

	public void setPapaTipoTra(Integer papaTipoTra) {
		this.papaTipoTra = papaTipoTra;
	}

	@Column(name = "mamaalf", nullable = true)
	public Integer getMamaAlf() {
		return mamaAlf;
	}

	public void setMamaAlf(Integer mamaAlf) {
		this.mamaAlf = mamaAlf;
	}

	@Column(name = "mamanivel", nullable = true)
	public Integer getMamaNivel() {
		return mamaNivel;
	}

	public void setMamaNivel(Integer mamaNivel) {
		this.mamaNivel = mamaNivel;
	}

	@Column(name = "mamatra", nullable = true)
	public Integer getMamaTra() {
		return mamaTra;
	}

	public void setMamaTra(Integer mamaTra) {
		this.mamaTra = mamaTra;
	}

	@Column(name = "mamatipotra", nullable = true)
	public Integer getMamaTipoTra() {
		return mamaTipoTra;
	}

	public void setMamaTipoTra(Integer mamaTipoTra) {
		this.mamaTipoTra = mamaTipoTra;
	}

	@Column(name = "compartehab", nullable = true)
	public Integer getComparteHab() {
		return comparteHab;
	}

	public void setComparteHab(Integer comparteHab) {
		this.comparteHab = comparteHab;
	}

	@Column(name = "hab1", nullable = true, length = 2)
	public Integer getHab1() {
		return hab1;
	}

	public void setHab1(Integer hab1) {
		this.hab1 = hab1;
	}

	@Column(name = "hab2", nullable = true, length = 2)
	public Integer getHab2() {
		return hab2;
	}

	public void setHab2(Integer hab2) {
		this.hab2 = hab2;
	}

	@Column(name = "hab3", nullable = true, length = 2)
	public Integer getHab3() {
		return hab3;
	}

	public void setHab3(Integer hab3) {
		this.hab3 = hab3;
	}

	@Column(name = "hab4", nullable = true, length = 2)
	public Integer getHab4() {
		return hab4;
	}

	public void setHab4(Integer hab4) {
		this.hab4 = hab4;
	}

	@Column(name = "hab5", nullable = true, length = 2)
	public Integer getHab5() {
		return hab5;
	}

	public void setHab5(Integer hab5) {
		this.hab5 = hab5;
	}

	@Column(name = "hab6", nullable = true, length = 2)
	public Integer getHab6() {
		return hab6;
	}

	public void setHab6(Integer hab6) {
		this.hab6 = hab6;
	}

	@Column(name = "compartecama", nullable = true)
	public Integer getComparteCama() {
		return comparteCama;
	}

	public void setComparteCama(Integer comparteCama) {
		this.comparteCama = comparteCama;
	}

	@Column(name = "cama1", nullable = true, length = 2)
	public Integer getCama1() {
		return cama1;
	}

	public void setCama1(Integer cama1) {
		this.cama1 = cama1;
	}

	@Column(name = "cama2", nullable = true, length = 2)
	public Integer getCama2() {
		return cama2;
	}

	public void setCama2(Integer cama2) {
		this.cama2 = cama2;
	}

	@Column(name = "cama3", nullable = true, length = 2)
	public Integer getCama3() {
		return cama3;
	}

	public void setCama3(Integer cama3) {
		this.cama3 = cama3;
	}

	@Column(name = "cama4", nullable = true, length = 2)
	public Integer getCama4() {
		return cama4;
	}

	public void setCama4(Integer cama4) {
		this.cama4 = cama4;
	}

	@Column(name = "cama5", nullable = true, length = 2)
	public Integer getCama5() {
		return cama5;
	}

	public void setCama5(Integer cama5) {
		this.cama5 = cama5;
	}

	@Column(name = "cama6", nullable = true, length = 2)
	public Integer getCama6() {
		return cama6;
	}

	public void setCama6(Integer cama6) {
		this.cama6 = cama6;
	}

	@Column(name = "asma", nullable = true)
	public Integer getAsma() {
		return asma;
	}

	public void setAsma(Integer asma) {
		this.asma = asma;
	}

	@Column(name = "silb12m", nullable = true)
	public Integer getSilb12m() {
		return silb12m;
	}

	public void setSilb12m(Integer silb12m) {
		this.silb12m = silb12m;
	}

	@Column(name = "sitresf", nullable = true)
	public Integer getSitResf() {
		return sitResf;
	}

	public void setSitResf(Integer sitResf) {
		this.sitResf = sitResf;
	}

	@Column(name = "sitejer", nullable = true)
	public Integer getSitEjer() {
		return sitEjer;
	}

	public void setSitEjer(Integer sitEjer) {
		this.sitEjer = sitEjer;
	}

	@Column(name = "silbmespas", nullable = true)
	public Integer getSilbMesPas() {
		return silbMesPas;
	}

	public void setSilbMesPas(Integer silbMesPas) {
		this.silbMesPas = silbMesPas;
	}

	@Column(name = "difhablar", nullable = true)
	public Integer getDifHablar() {
		return difHablar;
	}

	public void setDifHablar(Integer difHablar) {
		this.difHablar = difHablar;
	}

	@Column(name = "vechablar", nullable = true)
	public Integer getVecHablar() {
		return vecHablar;
	}

	public void setVecHablar(Integer vecHablar) {
		this.vecHablar = vecHablar;
	}

	@Column(name = "difdormir", nullable = true)
	public Integer getDifDormir() {
		return difDormir;
	}

	public void setDifDormir(Integer difDormir) {
		this.difDormir = difDormir;
	}

	@Column(name = "suenoper", nullable = true)
	public Integer getSuenoPer() {
		return suenoPer;
	}

	public void setSuenoPer(Integer suenoPer) {
		this.suenoPer = suenoPer;
	}

	@Column(name = "tos12m", nullable = true)
	public Integer getTos12m() {
		return tos12m;
	}

	public void setTos12m(Integer tos12m) {
		this.tos12m = tos12m;
	}

	@Column(name = "vecestos", nullable = true)
	public Integer getVecesTos() {
		return vecesTos;
	}

	public void setVecesTos(Integer vecesTos) {
		this.vecesTos = vecesTos;
	}

	@Column(name = "tos3dias", nullable = true)
	public Integer getTos3Dias() {
		return tos3Dias;
	}

	public void setTos3Dias(Integer tos3Dias) {
		this.tos3Dias = tos3Dias;
	}

	@Column(name = "hosp12m", nullable = true)
	public Integer getHosp12m() {
		return hosp12m;
	}

	public void setHosp12m(Integer hosp12m) {
		this.hosp12m = hosp12m;
	}

	@Column(name = "med12m", nullable = true)
	public Integer getMed12m() {
		return med12m;
	}

	public void setMed12m(Integer med12m) {
		this.med12m = med12m;
	}

	@Column(name = "dep12m", nullable = true)
	public Integer getDep12m() {
		return dep12m;
	}

	public void setDep12m(Integer dep12m) {
		this.dep12m = dep12m;
	}

	@Column(name = "crisis", nullable = true)
	public Integer getCrisis() {
		return crisis;
	}

	public void setCrisis(Integer crisis) {
		this.crisis = crisis;
	}

	@Column(name = "frecasma", nullable = true)
	public Integer getFrecAsma() {
		return frecAsma;
	}

	public void setFrecAsma(Integer frecAsma) {
		this.frecAsma = frecAsma;
	}

	@Column(name = "Fumasn", nullable = true)
	public Integer getFumaSN() {
		return FumaSN;
	}

	public void setFumaSN(Integer fumaSN) {
		FumaSN = fumaSN;
	}

	@Column(name = "quienfuma", nullable = true)
	public String getQuienFuma() {
		return quienFuma;
	}

	public void setQuienFuma(String quienFuma) {
		this.quienFuma = quienFuma;
	}
	
	@Column(name = "cant_cigarros_madre", nullable = true)
	public Integer getCantCigarrosMadre() {
		return cantCigarrosMadre;
	}

	public void setCantCigarrosMadre(Integer cantCigarrosMadre) {
		this.cantCigarrosMadre = cantCigarrosMadre;
	}

	@Column(name = "cant_cigarros_padre", nullable = true)
	public Integer getCantCigarrosPadre() {
		return cantCigarrosPadre;
	}

	public void setCantCigarrosPadre(Integer cantCigarrosPadre) {
		this.cantCigarrosPadre = cantCigarrosPadre;
	}

	@Column(name = "cant_cigarros_otros", nullable = true)
	public Integer getCantCigarrosOtros() {
		return cantCigarrosOtros;
	}

	public void setCantCigarrosOtros(Integer cantCigarrosOtros) {
		this.cantCigarrosOtros = cantCigarrosOtros;
	}
	
	

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	@Column(name = "rash", nullable = true)
	public Integer getRash() {
		return rash;
	}

	public void setRash(Integer rash) {
		this.rash = rash;
	}

	@Column(name = "mesActual", nullable = true)
	public Integer getMesActual() {
		return mesActual;
	}

	public void setMesActual(Integer mesActual) {
		this.mesActual = mesActual;
	}

	@Column(name = "yearActual", nullable = true)
	public Integer getYearActual() {
		return yearActual;
	}

	public void setYearActual(Integer yearActual) {
		this.yearActual = yearActual;
	}

	@Column(name = "rash_year", nullable = true)
	public Integer getRash_year() {
		return rash_year;
	}

	public void setRash_year(Integer rash_year) {
		this.rash_year = rash_year;
	}

	@Column(name = "rash_mes", nullable = true)
	public Integer getRash_mes() {
		return rash_mes;
	}

	public void setRash_mes(Integer rash_mes) {
		this.rash_mes = rash_mes;
	}

	@Column(name = "rash_mesact", nullable = true)
	public Integer getRash_mesact() {
		return rash_mesact;
	}

	public void setRash_mesact(Integer rash_mesact) {
		this.rash_mesact = rash_mesact;
	}

	@Column(name = "rashCara", nullable = true)
	public Integer getRashCara() {
		return rashCara;
	}

	public void setRashCara(Integer rashCara) {
		this.rashCara = rashCara;
	}

	@Column(name = "rashMiembrosSup", nullable = true)
	public Integer getRashMiembrosSup() {
		return rashMiembrosSup;
	}

	public void setRashMiembrosSup(Integer rashMiembrosSup) {
		this.rashMiembrosSup = rashMiembrosSup;
	}

	@Column(name = "rashTorax", nullable = true)
	public Integer getRashTorax() {
		return rashTorax;
	}

	public void setRashTorax(Integer rashTorax) {
		this.rashTorax = rashTorax;
	}

	@Column(name = "rashAbdomen", nullable = true)
	public Integer getRashAbdomen() {
		return rashAbdomen;
	}

	public void setRashAbdomen(Integer rashAbdomen) {
		this.rashAbdomen = rashAbdomen;
	}

	@Column(name = "rashMiembrosInf", nullable = true)
	public Integer getRashMiembrosInf() {
		return rashMiembrosInf;
	}

	public void setRashMiembrosInf(Integer rashMiembrosInf) {
		this.rashMiembrosInf = rashMiembrosInf;
	}

	@Column(name = "rashDias", nullable = true)
	public Integer getRashDias() {
		return rashDias;
	}

	public void setRashDias(Integer rashDias) {
		this.rashDias = rashDias;
	}

	@Column(name = "ojoRojo", nullable = true)
	public Integer getOjoRojo() {
		return ojoRojo;
	}

	public void setOjoRojo(Integer ojoRojo) {
		this.ojoRojo = ojoRojo;
	}

	@Column(name = "ojoRojo_year", nullable = true)
	public Integer getOjoRojo_year() {
		return ojoRojo_year;
	}

	public void setOjoRojo_year(Integer ojoRojo_year) {
		this.ojoRojo_year = ojoRojo_year;
	}

	@Column(name = "ojoRojo_mes", nullable = true)
	public Integer getOjoRojo_mes() {
		return ojoRojo_mes;
	}

	public void setOjoRojo_mes(Integer ojoRojo_mes) {
		this.ojoRojo_mes = ojoRojo_mes;
	}

	@Column(name = "ojoRojo_mesact", nullable = true)
	public Integer getOjoRojo_mesact() {
		return ojoRojo_mesact;
	}

	public void setOjoRojo_mesact(Integer ojoRojo_mesact) {
		this.ojoRojo_mesact = ojoRojo_mesact;
	}

	@Column(name = "ojoRojo_Dias", nullable = true)
	public Integer getOjoRojo_Dias() {
		return ojoRojo_Dias;
	}

	public void setOjoRojo_Dias(Integer ojoRojo_Dias) {
		this.ojoRojo_Dias = ojoRojo_Dias;
	}

	@Column(name = "hormigueo", nullable = true)
	public Integer getHormigueo() {
		return hormigueo;
	}

	public void setHormigueo(Integer hormigueo) {
		this.hormigueo = hormigueo;
	}

	@Column(name = "hormigueo_year", nullable = true)
	public Integer getHormigueo_year() {
		return hormigueo_year;
	}

	public void setHormigueo_year(Integer hormigueo_year) {
		this.hormigueo_year = hormigueo_year;
	}

	@Column(name = "hormigueo_mes", nullable = true)
	public Integer getHormigueo_mes() {
		return hormigueo_mes;
	}

	public void setHormigueo_mes(Integer hormigueo_mes) {
		this.hormigueo_mes = hormigueo_mes;
	}

	@Column(name = "hormigueo_mesact", nullable = true)
	public Integer getHormigueo_mesact() {
		return hormigueo_mesact;
	}

	public void setHormigueo_mesact(Integer hormigueo_mesact) {
		this.hormigueo_mesact = hormigueo_mesact;
	}

	@Column(name = "hormigueo_Dias", nullable = true)
	public Integer getHormigueo_Dias() {
		return hormigueo_Dias;
	}

	public void setHormigueo_Dias(Integer hormigueo_Dias) {
		this.hormigueo_Dias = hormigueo_Dias;
	}

	@Column(name = "consultaRashHormigueo", nullable = true)
	public Integer getConsultaRashHormigueo() {
		return consultaRashHormigueo;
	}

	public void setConsultaRashHormigueo(Integer consultaRashHormigueo) {
		this.consultaRashHormigueo = consultaRashHormigueo;
	}

	@Column(name = "uSaludRashHormigueo", nullable = true)
	public Integer getuSaludRashHormigueo() {
		return uSaludRashHormigueo;
	}

	public void setuSaludRashHormigueo(Integer uSaludRashHormigueo) {
		this.uSaludRashHormigueo = uSaludRashHormigueo;
	}

	@Column(name = "cSaludRashHormigueo", nullable = true)
	public Integer getcSaludRashHormigueo() {
		return cSaludRashHormigueo;
	}

	public void setcSaludRashHormigueo(Integer cSaludRashHormigueo) {
		this.cSaludRashHormigueo = cSaludRashHormigueo;
	}

	@Column(name = "oCSRashHormigueo", nullable = true)
	public String getoCSRashHormigueo() {
		return oCSRashHormigueo;
	}

	public void setoCSRashHormigueo(String oCSRashHormigueo) {
		this.oCSRashHormigueo = oCSRashHormigueo;
	}

	@Column(name = "pSRashHormigueo", nullable = true)
	public Integer getpSRashHormigueo() {
		return pSRashHormigueo;
	}

	public void setpSRashHormigueo(Integer pSRashHormigueo) {
		this.pSRashHormigueo = pSRashHormigueo;
	}

	@Column(name = "oPSRashHormigueo", nullable = true)
	public String getoPSRashHormigueo() {
		return oPSRashHormigueo;
	}

	public void setoPSRashHormigueo(String oPSRashHormigueo) {
		this.oPSRashHormigueo = oPSRashHormigueo;
	}

	@Column(name = "diagRashHormigueo", nullable = true)
	public String getDiagRashHormigueo() {
		return diagRashHormigueo;
	}

	public void setDiagRashHormigueo(String diagRashHormigueo) {
		this.diagRashHormigueo = diagRashHormigueo;
	}

	@Column(name = "chPapaMama", nullable = true)
	public String getChPapaMama() {
		return chPapaMama;
	}

	public void setChPapaMama(String chPapaMama) {
		this.chPapaMama = chPapaMama;
	}

	@Column(name = "fechana_papa", nullable = true)
	public Date getFechana_papa() {
		return fechana_papa;
	}

	public void setFechana_papa(Date fechana_papa) {
		this.fechana_papa = fechana_papa;
	}

	@Column(name = "cal_edad_papa", nullable = true)
	public Integer getCal_edad_papa() {
		return cal_edad_papa;
	}

	public void setCal_edad_papa(Integer cal_edad_papa) {
		this.cal_edad_papa = cal_edad_papa;
	}

	@Column(name = "cal_edad2_papa", nullable = true)
	public Integer getCal_edad2_papa() {
		return cal_edad2_papa;
	}

	public void setCal_edad2_papa(Integer cal_edad2_papa) {
		this.cal_edad2_papa = cal_edad2_papa;
	}

	@Column(name = "nombpapa1", nullable = true)
	public String getNombpapa1() {
		return nombpapa1;
	}

	public void setNombpapa1(String nombpapa1) {
		this.nombpapa1 = nombpapa1;
	}

	@Column(name = "nombpapa2", nullable = true)
	public String getNombpapa2() {
		return nombpapa2;
	}

	public void setNombpapa2(String nombpapa2) {
		this.nombpapa2 = nombpapa2;
	}

	@Column(name = "apellipapa1", nullable = true)
	public String getApellipapa1() {
		return apellipapa1;
	}

	public void setApellipapa1(String apellipapa1) {
		this.apellipapa1 = apellipapa1;
	}

	@Column(name = "apellipapa2", nullable = true)
	public String getApellipapa2() {
		return apellipapa2;
	}

	public void setApellipapa2(String apellipapa2) {
		this.apellipapa2 = apellipapa2;
	}

	@Column(name = "fechana_mama", nullable = true)
	public Date getFechana_mama() {
		return fechana_mama;
	}

	public void setFechana_mama(Date fechana_mama) {
		this.fechana_mama = fechana_mama;
	}

	@Column(name = "cal_edad_mama", nullable = true)
	public Integer getCal_edad_mama() {
		return cal_edad_mama;
	}

	public void setCal_edad_mama(Integer cal_edad_mama) {
		this.cal_edad_mama = cal_edad_mama;
	}

	@Column(name = "cal_edad2_mama", nullable = true)
	public Integer getCal_edad2_mama() {
		return cal_edad2_mama;
	}

	public void setCal_edad2_mama(Integer cal_edad2_mama) {
		this.cal_edad2_mama = cal_edad2_mama;
	}

	@Column(name = "nombmama1", nullable = true)
	public String getNombmama1() {
		return nombmama1;
	}

	public void setNombmama1(String nombmama1) {
		this.nombmama1 = nombmama1;
	}

	@Column(name = "nombmama2", nullable = true)
	public String getNombmama2() {
		return nombmama2;
	}

	public void setNombmama2(String nombmama2) {
		this.nombmama2 = nombmama2;
	}

	@Column(name = "apellimama1", nullable = true)
	public String getApellimama1() {
		return apellimama1;
	}

	public void setApellimama1(String apellimama1) {
		this.apellimama1 = apellimama1;
	}

	@Column(name = "apellimama2", nullable = true)
	public String getApellimama2() {
		return apellimama2;
	}

	public void setApellimama2(String apellimama2) {
		this.apellimama2 = apellimama2;
	}
	
	
	

}
