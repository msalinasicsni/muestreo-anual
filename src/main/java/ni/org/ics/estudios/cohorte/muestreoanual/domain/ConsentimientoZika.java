package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de consentimiento de Zika
 * 
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "consentimientozika", catalog = "muestreoanual")
public class ConsentimientoZika {

	/**
	 * 
	 */
	private ConsentimientoZikaId consZikaId;
	
	private Integer parteDDen;
	private String rechDDen;
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
	private MovilInfo movilInfo;	
	private Integer otrorecurso1;
	private Integer otrorecurso2;

	
	@EmbeddedId
	public ConsentimientoZikaId getConsZikaId() {
		return consZikaId;
	}

	public void setConsZikaId(ConsentimientoZikaId consZikaId) {
		this.consZikaId = consZikaId;
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

	

	@Column(name = "rechDDen", nullable = true)
	public String getRechDDen() {
		return rechDDen;
	}

	public void setRechDDen(String rechDDen) {
		this.rechDDen = rechDDen;
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
