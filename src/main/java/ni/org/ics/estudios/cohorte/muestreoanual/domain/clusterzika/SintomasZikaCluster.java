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
 * @author William Aviles
 **/

@Entity
@Table(name = "sintomas_zika_cluster", catalog = "zika_cluster")
public class SintomasZikaCluster implements Auditable{

	/**
	 * 
	 */
	
	private String idSintoma;
	private Integer codigo;
	private Date fechaSint;
	private Integer diaSint;
	private String fiebre;
	private String astenia;
	private String malestadog;
	private String escalosfrios;
	private String convulsi;
	private String cefalea;
	private String rigidez;
	private String dolretro;
	private String papetito;
	private String nauseas;
	private String vomito;
	private String diarrea;
	private String dolabcont;
	private String artproximal;
	private String artdistal;
	private String mialgia;
	private String conjuntivitisnp;
	private String edemaartproxms;
	private String edemaartdistms;
	private String edemaartproxmi;
	private String edemaartdistmi;
	private String edemaperiauric;
	private String adenocervant;
	private String adenocervpost;
	private String adenoretroauric;
	private String rash;
	private String equimosis;
	private String torniqpos;
	private String epistaxis;
	private String gingivo;
	private String peteq;
	private String hemateme;
	private String melena;
	private String oftalmoplejia;
	private String dificultadresp;
	private String devilmuscms;
	private String devilmuscmi;
	private String parestesiams;
	private String parestesiami;
	private String paralmuscms;
	private String paralmuscmi;
	private String tos;
	private String rinorrea;
	private String garganta;
	private String prurito;
	private String recurso;
	private MovilInfo movilInfo;

	

	
	@Id
	@Column(name = "id_sintoma", nullable = false, length = 50)
	public String getIdSintoma() {
		return idSintoma;
	}

	public void setIdSintoma(String idSintoma) {
		this.idSintoma = idSintoma;
	}
	
	
	@Column(name = "codigo", nullable = false, length = 50)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	
	@Column(name = "fecha_sint", nullable = true)	
	public Date getFechaSint() {
		return fechaSint;
	}

	public void setFechaSint(Date fechaSint) {
		this.fechaSint = fechaSint;
	}

	@Column(name = "dia_sint", nullable = true, length = 2)
	public Integer getDiaSint() {
		return diaSint;
	}

	public void setDiaSint(Integer diaSint) {
		this.diaSint = diaSint;
	}

	@Column(name = "fiebre", nullable = true, length = 1)
	public String getFiebre() {
		return fiebre;
	}

	public void setFiebre(String fiebre) {
		this.fiebre = fiebre;
	}

	@Column(name = "astenia", nullable = true, length = 1)
	public String getAstenia() {
		return astenia;
	}

	public void setAstenia(String astenia) {
		this.astenia = astenia;
	}

		
	@Column(name = "escalosfrios", nullable = true, length = 1)
	public String getEscalosfrios() {
		return escalosfrios;
	}

	public void setEscalosfrios(String escalosfrios) {
		this.escalosfrios = escalosfrios;
	}

	@Column(name = "convulsi", nullable = true, length = 1)
	public String getConvulsi() {
		return convulsi;
	}

	public void setConvulsi(String convulsi) {
		this.convulsi = convulsi;
	}

	@Column(name = "cefalea", nullable = true, length = 1)
	public String getCefalea() {
		return cefalea;
	}

	public void setCefalea(String cefalea) {
		this.cefalea = cefalea;
	}

	
	@Column(name = "malestadog", nullable = true, length = 1)
	public String getMalestadog() {
		return malestadog;
	}

	public void setMalestadog(String malestadog) {
		this.malestadog = malestadog;
	}

	
	@Column(name = "rigidez", nullable = true, length = 1)
	public String getRigidez() {
		return rigidez;
	}

	public void setRigidez(String rigidez) {
		this.rigidez = rigidez;
	}

	
	@Column(name = "dolretro", nullable = true, length = 1)
	public String getDolretro() {
		return dolretro;
	}

	public void setDolretro(String dolretro) {
		this.dolretro = dolretro;
	}

	
	@Column(name = "papetito", nullable = true, length = 1)
	public String getPapetito() {
		return papetito;
	}

	public void setPapetito(String papetito) {
		this.papetito = papetito;
	}

	
	@Column(name = "nauseas", nullable = true, length = 1)
	public String getNauseas() {
		return nauseas;
	}

	public void setNauseas(String nauseas) {
		this.nauseas = nauseas;
	}

	
	@Column(name = "vomito", nullable = true, length = 1)
	public String getVomito() {
		return vomito;
	}

	public void setVomito(String vomito) {
		this.vomito = vomito;
	}

	
	@Column(name = "diarrea", nullable = true, length = 1)
	public String getDiarrea() {
		return diarrea;
	}

	public void setDiarrea(String diarrea) {
		this.diarrea = diarrea;
	}

	
	@Column(name = "dolabcont", nullable = true, length = 1)
	public String getDolabcont() {
		return dolabcont;
	}

	public void setDolabcont(String dolabcont) {
		this.dolabcont = dolabcont;
	}

	
	@Column(name = "artproximal", nullable = true, length = 1)
	public String getArtproximal() {
		return artproximal;
	}

	public void setArtproximal(String artproximal) {
		this.artproximal = artproximal;
	}

	
	@Column(name = "artdistal", nullable = true, length = 1)
	public String getArtdistal() {
		return artdistal;
	}

	public void setArtdistal(String artdistal) {
		this.artdistal = artdistal;
	}

	
	@Column(name = "mialgia", nullable = true, length = 1)
	public String getMialgia() {
		return mialgia;
	}

	public void setMialgia(String mialgia) {
		this.mialgia = mialgia;
	}

	
	@Column(name = "conjuntivitisnp", nullable = true, length = 1)
	public String getConjuntivitisnp() {
		return conjuntivitisnp;
	}

	public void setConjuntivitisnp(String conjuntivitisnp) {
		this.conjuntivitisnp = conjuntivitisnp;
	}

	
	@Column(name = "edemaartproxms", nullable = true, length = 1)
	public String getEdemaartproxms() {
		return edemaartproxms;
	}

	public void setEdemaartproxms(String edemaartproxms) {
		this.edemaartproxms = edemaartproxms;
	}

	
	@Column(name = "edemaartdistms", nullable = true, length = 1)
	public String getEdemaartdistms() {
		return edemaartdistms;
	}

	public void setEdemaartdistms(String edemaartdistms) {
		this.edemaartdistms = edemaartdistms;
	}

	
	@Column(name = "edemaartproxmi", nullable = true, length = 1)
	public String getEdemaartproxmi() {
		return edemaartproxmi;
	}

	public void setEdemaartproxmi(String edemaartproxmi) {
		this.edemaartproxmi = edemaartproxmi;
	}

	
	@Column(name = "edemaartdistmi", nullable = true, length = 1)
	public String getEdemaartdistmi() {
		return edemaartdistmi;
	}

	public void setEdemaartdistmi(String edemaartdistmi) {
		this.edemaartdistmi = edemaartdistmi;
	}

	
	@Column(name = "edemaperiauric", nullable = true, length = 1)
	public String getEdemaperiauric() {
		return edemaperiauric;
	}

	public void setEdemaperiauric(String edemaperiauric) {
		this.edemaperiauric = edemaperiauric;
	}

	
	@Column(name = "adenocervant", nullable = true, length = 1)
	public String getAdenocervant() {
		return adenocervant;
	}

	public void setAdenocervant(String adenocervant) {
		this.adenocervant = adenocervant;
	}

	
	@Column(name = "adenocervpost", nullable = true, length = 1)
	public String getAdenocervpost() {
		return adenocervpost;
	}

	public void setAdenocervpost(String adenocervpost) {
		this.adenocervpost = adenocervpost;
	}

	
	@Column(name = "adenoretroauric", nullable = true, length = 1)
	public String getAdenoretroauric() {
		return adenoretroauric;
	}

	public void setAdenoretroauric(String adenoretroauric) {
		this.adenoretroauric = adenoretroauric;
	}

	
	@Column(name = "rash", nullable = true, length = 1)
	public String getRash() {
		return rash;
	}

	public void setRash(String rash) {
		this.rash = rash;
	}

	
	@Column(name = "equimosis", nullable = true, length = 1)
	public String getEquimosis() {
		return equimosis;
	}

	public void setEquimosis(String equimosis) {
		this.equimosis = equimosis;
	}

	
	@Column(name = "torniqpos", nullable = true, length = 1)
	public String getTorniqpos() {
		return torniqpos;
	}

	public void setTorniqpos(String torniqpos) {
		this.torniqpos = torniqpos;
	}

	
	@Column(name = "epistaxis", nullable = true, length = 1)
	public String getEpistaxis() {
		return epistaxis;
	}

	public void setEpistaxis(String epistaxis) {
		this.epistaxis = epistaxis;
	}

	
	@Column(name = "gingivo", nullable = true, length = 1)
	public String getGingivo() {
		return gingivo;
	}

	public void setGingivo(String gingivo) {
		this.gingivo = gingivo;
	}

	
	@Column(name = "peteq", nullable = true, length = 1)
	public String getPeteq() {
		return peteq;
	}

	public void setPeteq(String peteq) {
		this.peteq = peteq;
	}

	
	@Column(name = "hemateme", nullable = true, length = 1)
	public String getHemateme() {
		return hemateme;
	}

	public void setHemateme(String hemateme) {
		this.hemateme = hemateme;
	}

	
	@Column(name = "melena", nullable = true, length = 1)
	public String getMelena() {
		return melena;
	}

	public void setMelena(String melena) {
		this.melena = melena;
	}

	
	@Column(name = "oftalmoplejia", nullable = true, length = 1)
	public String getOftalmoplejia() {
		return oftalmoplejia;
	}

	public void setOftalmoplejia(String oftalmoplejia) {
		this.oftalmoplejia = oftalmoplejia;
	}

	
	@Column(name = "dificultadresp", nullable = true, length = 1)
	public String getDificultadresp() {
		return dificultadresp;
	}

	public void setDificultadresp(String dificultadresp) {
		this.dificultadresp = dificultadresp;
	}

	
	@Column(name = "devilmuscms", nullable = true, length = 1)
	public String getDevilmuscms() {
		return devilmuscms;
	}

	public void setDevilmuscms(String devilmuscms) {
		this.devilmuscms = devilmuscms;
	}

	
	@Column(name = "devilmuscmi", nullable = true, length = 1)
	public String getDevilmuscmi() {
		return devilmuscmi;
	}

	public void setDevilmuscmi(String devilmuscmi) {
		this.devilmuscmi = devilmuscmi;
	}

	
	@Column(name = "parestesiams", nullable = true, length = 1)
	public String getParestesiams() {
		return parestesiams;
	}

	public void setParestesiams(String parestesiams) {
		this.parestesiams = parestesiams;
	}

	
	@Column(name = "parestesiami", nullable = true, length = 1)
	public String getParestesiami() {
		return parestesiami;
	}

	public void setParestesiami(String parestesiami) {
		this.parestesiami = parestesiami;
	}

	
	@Column(name = "paralmuscms", nullable = true, length = 1)
	public String getParalmuscms() {
		return paralmuscms;
	}

	public void setParalmuscms(String paralmuscms) {
		this.paralmuscms = paralmuscms;
	}

	
	@Column(name = "paralmuscmi", nullable = true, length = 1)
	public String getParalmuscmi() {
		return paralmuscmi;
	}

	public void setParalmuscmi(String paralmuscmi) {
		this.paralmuscmi = paralmuscmi;
	}

	
	@Column(name = "tos", nullable = true, length = 1)
	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	
	@Column(name = "rinorrea", nullable = true, length = 1)
	public String getRinorrea() {
		return rinorrea;
	}

	public void setRinorrea(String rinorrea) {
		this.rinorrea = rinorrea;
	}

	
	@Column(name = "garganta", nullable = true, length = 1)
	public String getGarganta() {
		return garganta;
	}

	public void setGarganta(String garganta) {
		this.garganta = garganta;
	}

	
	@Column(name = "prurito", nullable = true, length = 1)
	public String getPrurito() {
		return prurito;
	}

	public void setPrurito(String prurito) {
		this.prurito = prurito;
	}

	
	@Column(name = "recurso", nullable = true, length = 3)
	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
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
