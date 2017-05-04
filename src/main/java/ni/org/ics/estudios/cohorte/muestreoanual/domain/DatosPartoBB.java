package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de parto de los
 * participantes en el estudio
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "partobb", catalog = "muestreoanual")
public class DatosPartoBB {

	/**
	 * 
	 */
	
	private DatosPartoBBId datosPartoId;
	private String tipoParto;
	private String tiempoEmb_sndr;
	private Integer tiempoEmbSemana;
	private String docMedTiempoEmb_sn;
	private String docMedTiempoEmb;
	private String otroDocMedTiempoEmb;
	private Date fum;
	private Integer sg;
	private String fumFueraRango_sn;
	private String fumFueraRango_razon;
	private Integer edadGest;
	private String docMedEdadGest_sn;
	private String docMedEdadGest;
	private String OtroDocMedEdadGest;
	private String prematuro_sndr;
	private String pesoBB_sndr;
	private String pesoBB;
	private String docMedPesoBB_sn;
	private String docMedPesoBB;
	private String otroDocMedPesoBB;
	private MovilInfo movilInfo;
	private Integer otrorecurso1;
	private Integer otrorecurso2;


	
	@Column(name = "tipoParto", nullable = true, length = 1)
	public String getTipoParto() {
		return tipoParto;
	}

	public void setTipoParto(String tipoParto) {
		this.tipoParto = tipoParto;
	}

	@Column(name = "tiempoEmb_sndr", nullable = true, length = 1)
	public String getTiempoEmb_sndr() {
		return tiempoEmb_sndr;
	}

	public void setTiempoEmb_sndr(String tiempoEmb_sndr) {
		this.tiempoEmb_sndr = tiempoEmb_sndr;
	}

	@Column(name = "tiempoEmbSemana", nullable = true, length = 2)
	public Integer getTiempoEmbSemana() {
		return tiempoEmbSemana;
	}

	public void setTiempoEmbSemana(Integer tiempoEmbSemana) {
		this.tiempoEmbSemana = tiempoEmbSemana;
	}

	@Column(name = "docMedTiempoEmb_sn", nullable = true, length = 1)
	public String getDocMedTiempoEmb_sn() {
		return docMedTiempoEmb_sn;
	}

	public void setDocMedTiempoEmb_sn(String docMedTiempoEmb_sn) {
		this.docMedTiempoEmb_sn = docMedTiempoEmb_sn;
	}

	@Column(name = "docMedTiempoEmb", nullable = true, length = 1)
	public String getDocMedTiempoEmb() {
		return docMedTiempoEmb;
	}

	public void setDocMedTiempoEmb(String docMedTiempoEmb) {
		this.docMedTiempoEmb = docMedTiempoEmb;
	}

	@Column(name = "otroDocMedTiempoEmb", nullable = true, length = 500)
	public String getOtroDocMedTiempoEmb() {
		return otroDocMedTiempoEmb;
	}

	public void setOtroDocMedTiempoEmb(String otroDocMedTiempoEmb) {
		this.otroDocMedTiempoEmb = otroDocMedTiempoEmb;
	}

	@Column(name = "fum", nullable = true)
	public Date getFum() {
		return fum;
	}

	public void setFum(Date fum) {
		this.fum = fum;
	}

	@Column(name = "sg", nullable = true, length = 2)
	public Integer getSg() {
		return sg;
	}

	public void setSg(Integer sg) {
		this.sg = sg;
	}

	@Column(name = "edadGest", nullable = true, length = 2)
	public Integer getEdadGest() {
		return edadGest;
	}

	public void setEdadGest(Integer edadGest) {
		this.edadGest = edadGest;
	}

	@Column(name = "docMedEdadGest_sn", nullable = true, length = 1)
	public String getDocMedEdadGest_sn() {
		return docMedEdadGest_sn;
	}

	public void setDocMedEdadGest_sn(String docMedEdadGest_sn) {
		this.docMedEdadGest_sn = docMedEdadGest_sn;
	}

	@Column(name = "docMedEdadGest", nullable = true, length = 1)
	public String getDocMedEdadGest() {
		return docMedEdadGest;
	}

	public void setDocMedEdadGest(String docMedEdadGest) {
		this.docMedEdadGest = docMedEdadGest;
	}

	@Column(name = "OtroDocMedEdadGest", nullable = true, length = 500)
	public String getOtroDocMedEdadGest() {
		return OtroDocMedEdadGest;
	}

	public void setOtroDocMedEdadGest(String otroDocMedEdadGest) {
		OtroDocMedEdadGest = otroDocMedEdadGest;
	}

	@Column(name = "prematuro_sndr", nullable = true, length = 1)
	public String getPrematuro_sndr() {
		return prematuro_sndr;
	}

	public void setPrematuro_sndr(String prematuro_sndr) {
		this.prematuro_sndr = prematuro_sndr;
	}

	@Column(name = "pesoBB_sndr", nullable = true, length = 1)
	public String getPesoBB_sndr() {
		return pesoBB_sndr;
	}

	public void setPesoBB_sndr(String pesoBB_sndr) {
		this.pesoBB_sndr = pesoBB_sndr;
	}

	@Column(name = "pesoBB", nullable = true, length = 5)
	public String getPesoBB() {
		return pesoBB;
	}

	public void setPesoBB(String pesoBB) {
		this.pesoBB = pesoBB;
	}

	@Column(name = "docMedPesoBB_sn", nullable = true, length = 1)
	public String getDocMedPesoBB_sn() {
		return docMedPesoBB_sn;
	}

	public void setDocMedPesoBB_sn(String docMedPesoBB_sn) {
		this.docMedPesoBB_sn = docMedPesoBB_sn;
	}

	@Column(name = "docMedPesoBB", nullable = true, length = 1)
	public String getDocMedPesoBB() {
		return docMedPesoBB;
	}

	public void setDocMedPesoBB(String docMedPesoBB) {
		this.docMedPesoBB = docMedPesoBB;
	}

	@Column(name = "otroDocMedPesoBB", nullable = true, length = 500)
	public String getOtroDocMedPesoBB() {
		return otroDocMedPesoBB;
	}

	public void setOtroDocMedPesoBB(String otroDocMedPesoBB) {
		this.otroDocMedPesoBB = otroDocMedPesoBB;
	}

	@Column(name = "otrorecurso1", nullable = true, length = 10)
	public Integer getOtrorecurso1() {
		return otrorecurso1;
	}

	public void setOtrorecurso1(Integer otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}

	@Column(name = "otrorecurso2", nullable = true, length = 10)
	public Integer getOtrorecurso2() {
		return otrorecurso2;
	}

	public void setOtrorecurso2(Integer otrorecurso2) {
		this.otrorecurso2 = otrorecurso2;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	@EmbeddedId
	public DatosPartoBBId getDatosPartoId() {
		return datosPartoId;
	}

	public void setDatosPartoId(DatosPartoBBId datosPartoId) {
		this.datosPartoId = datosPartoId;
	}

	@Column(name = "fumFueraRango_sn", nullable = true, length = 2)
	public String getFumFueraRango_sn() {
		return fumFueraRango_sn;
	}

	public void setFumFueraRango_sn(String fumFueraRango_sn) {
		this.fumFueraRango_sn = fumFueraRango_sn;
	}

	@Column(name = "fumFueraRango_razon", nullable = true, length = 750)
	public String getFumFueraRango_razon() {
		return fumFueraRango_razon;
	}

	public void setFumFueraRango_razon(String fumFueraRango_razon) {
		this.fumFueraRango_razon = fumFueraRango_razon;
	}
	
	

}
