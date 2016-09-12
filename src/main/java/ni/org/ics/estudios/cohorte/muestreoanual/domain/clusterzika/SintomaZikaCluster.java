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
public class SintomaZikaCluster implements Auditable{

	/**
	 * 
	 */
	private String idSintoma;
	private String fiebre;
	private String astenia;
	private String malestado;
	private String escalosfrios;
	private MovilInfo movilInfo;

	

	
	@Id
	@Column(name = "id_sintoma", nullable = false, length = 50)
	public String getIdSintoma() {
		return idSintoma;
	}

	public void setIdSintoma(String idSintoma) {
		this.idSintoma = idSintoma;
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

	@Column(name = "malestado", nullable = true, length = 1)
	public String getMalestado() {
		return malestado;
	}

	public void setMalestado(String malestado) {
		this.malestado = malestado;
	}
	
	
	@Column(name = "escalosfrios", nullable = true, length = 1)
	public String getEscalosfrios() {
		return escalosfrios;
	}

	public void setEscalosfrios(String escalosfrios) {
		this.escalosfrios = escalosfrios;
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
