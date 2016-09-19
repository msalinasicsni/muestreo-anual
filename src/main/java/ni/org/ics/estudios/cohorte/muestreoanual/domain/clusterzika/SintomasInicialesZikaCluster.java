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
@Table(name = "sintomasiniciales_zika_cluster", catalog = "zika_cluster")
public class SintomasInicialesZikaCluster implements Auditable{

	/**
	 * 
	 */
	
	private String idSintomasiniciales;
	private Integer codigo;
	private Date fis;
	private Date fif;
	private String sintInicial1;
	private String sintInicial2;
	private String sintInicial3;
	private String sintInicial4;
	private String otrorecurso1;
	private String otrorecurso2;
	private MovilInfo movilInfo;

	
	
	@Id
	
	@Column(name = "idSintomasiniciales", nullable = false, length = 50)
	public String getIdSintomasiniciales() {
		return idSintomasiniciales;
	}

	public void setIdSintomasiniciales(String idSintomasiniciales) {
		this.idSintomasiniciales = idSintomasiniciales;
	}
	
	
	@Column(name = "codigo", nullable = false, length = 11)
	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	@Column(name = "fis", nullable = false, length = 50)
	public Date getFis() {
		return fis;
	}


	public void setFis(Date fis) {
		this.fis = fis;
	}


	@Column(name = "fif", nullable = false, length = 50)
	public Date getFif() {
		return fif;
	}


	public void setFif(Date fif) {
		this.fif = fif;
	}


	@Column(name = "sintInicial1", nullable = false, length = 2)
	public String getSintInicial1() {
		return sintInicial1;
	}


	public void setSintInicial1(String sintInicial1) {
		this.sintInicial1 = sintInicial1;
	}


	@Column(name = "sintInicial2", nullable = false, length = 2)
	public String getSintInicial2() {
		return sintInicial2;
	}


	public void setSintInicial2(String sintInicial2) {
		this.sintInicial2 = sintInicial2;
	}


	@Column(name = "sintInicial3", nullable = false, length = 2)
	public String getSintInicial3() {
		return sintInicial3;
	}


	public void setSintInicial3(String sintInicial3) {
		this.sintInicial3 = sintInicial3;
	}


	@Column(name = "sintInicial4", nullable = false, length = 2)
	public String getSintInicial4() {
		return sintInicial4;
	}


	public void setSintInicial4(String sintInicial4) {
		this.sintInicial4 = sintInicial4;
	}


	@Column(name = "otrorecurso1", nullable = false, length = 50)
	public String getOtrorecurso1() {
		return otrorecurso1;
	}


	public void setOtrorecurso1(String otrorecurso1) {
		this.otrorecurso1 = otrorecurso1;
	}


	@Column(name = "otrorecurso2", nullable = false, length = 50)
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
