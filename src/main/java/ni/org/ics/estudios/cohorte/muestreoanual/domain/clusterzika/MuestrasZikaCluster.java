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
@Table(name = "muestras_zika_cluster", catalog = "zika_cluster")
public class MuestrasZikaCluster implements Auditable{

	/**
	 * 
	 */
	private String id_Muestras;
	private Integer codigo;
	private String bhc;
	private String bhc_razonNo;
	private String bhc_otraRazonNo;
	private Date h_bhc;
	private String v_bhc;
	private String obs_bhc;
	private String otra_bhc;
	private String sero;
	private String sero_razonNo;
	private String sero_otraRazonNo;
	private Date h_sero;
	private String v_sero;
	private String obs_sero;
	private String otra_sero;
	private String orina;
	private String orina_razonNo;
	private String orina_otraRazonNo;
	private Date h_orina;
	private String v_orina;
	private String obs_orina;
	private String otra_orina;
	private String saliva;
	private String saliva_razonNo;
	private String saliva_otraRazonNo;
	private Date h_saliva;
	private String v_saliva;
	private String obs_saliva;
	private String otra_saliva;
	private String otrorecurso1;
	private String otrorecurso2;
	private MovilInfo movilInfo;

	

	
	@Id
	@Column(name = "id_Muestras", nullable = false, length = 50)
	public String getId_Muestras() {
		return id_Muestras;
	}


	public void setId_Muestras(String id_Muestras) {
		this.id_Muestras = id_Muestras;
	}


	
	@Column(name = "codigo", nullable = false, length = 11)
	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	
	@Column(name = "bhc", nullable = true, length = 2)
	public String getBhc() {
		return bhc;
	}


	public void setBhc(String bhc) {
		this.bhc = bhc;
	}

	
	@Column(name = "bhc_razonNo", nullable = true, length = 1)
	public String getBhc_razonNo() {
		return bhc_razonNo;
	}


	public void setBhc_razonNo(String bhc_razonNo) {
		this.bhc_razonNo = bhc_razonNo;
	}


	@Column(name = "bhc_otraRazonNo", nullable = true, length = 255)
	public String getBhc_otraRazonNo() {
		return bhc_otraRazonNo;
	}


	public void setBhc_otraRazonNo(String bhc_otraRazonNo) {
		this.bhc_otraRazonNo = bhc_otraRazonNo;
	}


	@Column(name = "h_bhc", nullable = true, length = 50)
	public Date getH_bhc() {
		return h_bhc;
	}


	public void setH_bhc(Date h_bhc) {
		this.h_bhc = h_bhc;
	}


	@Column(name = "v_bhc", nullable = true, length = 10)
	public String getV_bhc() {
		return v_bhc;
	}


	public void setV_bhc(String v_bhc) {
		this.v_bhc = v_bhc;
	}


	@Column(name = "obs_bhc", nullable = true, length = 1)
	public String getObs_bhc() {
		return obs_bhc;
	}


	public void setObs_bhc(String obs_bhc) {
		this.obs_bhc = obs_bhc;
	}


	@Column(name = "otra_bhc", nullable = true, length = 255)
	public String getOtra_bhc() {
		return otra_bhc;
	}


	public void setOtra_bhc(String otra_bhc) {
		this.otra_bhc = otra_bhc;
	}


	@Column(name = "sero", nullable = true, length = 1)
	public String getSero() {
		return sero;
	}


	public void setSero(String sero) {
		this.sero = sero;
	}


	@Column(name = "sero_razonNo", nullable = true, length = 1)
	public String getSero_razonNo() {
		return sero_razonNo;
	}


	public void setSero_razonNo(String sero_razonNo) {
		this.sero_razonNo = sero_razonNo;
	}


	@Column(name = "sero_otraRazonNo", nullable = true, length = 255)
	public String getSero_otraRazonNo() {
		return sero_otraRazonNo;
	}


	public void setSero_otraRazonNo(String sero_otraRazonNo) {
		this.sero_otraRazonNo = sero_otraRazonNo;
	}


	@Column(name = "h_sero", nullable = true, length = 50)
	public Date getH_sero() {
		return h_sero;
	}


	public void setH_sero(Date h_sero) {
		this.h_sero = h_sero;
	}


	@Column(name = "v_sero", nullable = true, length = 10)
	public String getV_sero() {
		return v_sero;
	}


	public void setV_sero(String v_sero) {
		this.v_sero = v_sero;
	}


	@Column(name = "obs_sero", nullable = true, length = 1)
	public String getObs_sero() {
		return obs_sero;
	}


	public void setObs_sero(String obs_sero) {
		this.obs_sero = obs_sero;
	}


	@Column(name = "otra_sero", nullable = true, length = 255)
	public String getOtra_sero() {
		return otra_sero;
	}


	public void setOtra_sero(String otra_sero) {
		this.otra_sero = otra_sero;
	}


	@Column(name = "orina", nullable = true, length = 1)
	public String getOrina() {
		return orina;
	}


	public void setOrina(String orina) {
		this.orina = orina;
	}


	@Column(name = "orina_razonNo", nullable = true, length = 1)
	public String getOrina_razonNo() {
		return orina_razonNo;
	}


	public void setOrina_razonNo(String orina_razonNo) {
		this.orina_razonNo = orina_razonNo;
	}


	@Column(name = "orina_otraRazonNo", nullable = true, length = 255)
	public String getOrina_otraRazonNo() {
		return orina_otraRazonNo;
	}


	public void setOrina_otraRazonNo(String orina_otraRazonNo) {
		this.orina_otraRazonNo = orina_otraRazonNo;
	}


	@Column(name = "h_orina", nullable = true, length = 50)
	public Date getH_orina() {
		return h_orina;
	}


	public void setH_orina(Date h_orina) {
		this.h_orina = h_orina;
	}


	@Column(name = "v_orina", nullable = true, length = 10)
	public String getV_orina() {
		return v_orina;
	}


	public void setV_orina(String v_orina) {
		this.v_orina = v_orina;
	}


	@Column(name = "obs_orina", nullable = true, length = 1)
	public String getObs_orina() {
		return obs_orina;
	}


	public void setObs_orina(String obs_orina) {
		this.obs_orina = obs_orina;
	}


	@Column(name = "otra_orina", nullable = true, length = 255)
	public String getOtra_orina() {
		return otra_orina;
	}


	public void setOtra_orina(String otra_orina) {
		this.otra_orina = otra_orina;
	}


	@Column(name = "saliva", nullable = true, length = 1)
	public String getSaliva() {
		return saliva;
	}


	public void setSaliva(String saliva) {
		this.saliva = saliva;
	}


	@Column(name = "saliva_razonNo", nullable = true, length = 1)
	public String getSaliva_razonNo() {
		return saliva_razonNo;
	}


	public void setSaliva_razonNo(String saliva_razonNo) {
		this.saliva_razonNo = saliva_razonNo;
	}


	@Column(name = "saliva_otraRazonNo", nullable = true, length = 255)
	public String getSaliva_otraRazonNo() {
		return saliva_otraRazonNo;
	}


	public void setSaliva_otraRazonNo(String saliva_otraRazonNo) {
		this.saliva_otraRazonNo = saliva_otraRazonNo;
	}


	@Column(name = "h_saliva", nullable = true, length = 50)
	public Date getH_saliva() {
		return h_saliva;
	}


	public void setH_saliva(Date h_saliva) {
		this.h_saliva = h_saliva;
	}


	@Column(name = "v_saliva", nullable = true, length = 10)
	public String getV_saliva() {
		return v_saliva;
	}


	public void setV_saliva(String v_saliva) {
		this.v_saliva = v_saliva;
	}


	@Column(name = "obs_saliva", nullable = true, length = 1)
	public String getObs_saliva() {
		return obs_saliva;
	}


	public void setObs_saliva(String obs_saliva) {
		this.obs_saliva = obs_saliva;
	}


	@Column(name = "otra_saliva", nullable = true, length = 255)
	public String getOtra_saliva() {
		return otra_saliva;
	}


	public void setOtra_saliva(String otra_saliva) {
		this.otra_saliva = otra_saliva;
	}


	@Column(name = "otrorecurso1", nullable = true, length = 50)
	public String getOtrorecurso1() {
		return otrorecurso1;
	}


	public void setOtrorecurso1(String otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}


	@Column(name = "otrorecurso2", nullable = true, length = 50)
	public String getOtrorecurso2() {
		return otrorecurso2;
	}


	public void setOtrorecurso2(String otrorecurso2) {
		this.otrorecurso2 = otrorecurso2;
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
