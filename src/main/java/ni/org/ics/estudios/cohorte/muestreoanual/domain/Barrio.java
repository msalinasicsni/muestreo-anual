package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa un barrio
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "barrios", catalog = "estudios_ics")

public class Barrio {
	
	private Integer barrio;
	private String nombreBarrio;
	
	@Id
	@Column(name = "codigo", nullable = false, length = 4)
	public Integer getBarrio() {
		return barrio;
	}
	public void setBarrio(Integer barrio) {
		this.barrio = barrio;
	}
	@Column(name = "nombre", nullable = false, length = 150)
	public String getNombreBarrio() {
		return nombreBarrio;
	}
	public void setNombreBarrio(String nombreBarrio) {
		this.nombreBarrio = nombreBarrio;
	}
	
	

}
