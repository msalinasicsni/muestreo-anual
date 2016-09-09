package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EncuestaCasaId implements Serializable {
	/**
	 * Objeto que representa la clave unica de una encuesta de casa
	 * 
	 * @author Brenda Lopez
	 **/

	private static final long serialVersionUID = 1L;
	private Integer codCasa;
	private Date fechaEncCasa;

	public EncuestaCasaId() {

	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EncuestaCasaId))
			return false;
		EncuestaCasaId castOther = (EncuestaCasaId) other;
		return (this.getCodCasa() == castOther.getCodCasa())
				&& (this.getFechaEncCasa() == castOther.getFechaEncCasa());
	}

	public int hashCode() {
		int result = 17;
		result = 37 * 3 + this.getCodCasa();
		result = 37 * result + Integer.valueOf(this.getFechaEncCasa().toString());
		return result;
	}

	@Column(name = "cod_casa", nullable = false, length = 4)
	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	@Column(name = "fecha_encuesta", nullable = false)
	public Date getFechaEncCasa() {
		return fechaEncCasa;
	}

	public void setFechaEncCasa(Date fechaEncCasa) {
		this.fechaEncCasa = fechaEncCasa;
	}

}