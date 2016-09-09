package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de la codigos en la casa
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "codigos_relacionados", catalog = "muestreoanual")
public class CodigosCasas {

	/**
	 * 
	 */
	
	private Date fechaRegistro;
	private Integer codCasa;
	private Integer codigoComun;
	private Integer codigoRelacionado;
	private String username;
	private String estado;

	
	@Id
	@Column(name = "fecha", nullable = false)
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	@Column(name = "cod_casa", nullable = true)
	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	@Column(name = "cod_comun", nullable = true)
	public Integer getCodigoComun() {
		return codigoComun;
	}

	public void setCodigoComun(Integer codigoComun) {
		this.codigoComun = codigoComun;
	}

	@Column(name = "cod_relacionado", nullable = true)
	public Integer getCodigoRelacionado() {
		return codigoRelacionado;
	}

	public void setCodigoRelacionado(Integer codigoRelacionado) {
		this.codigoRelacionado = codigoRelacionado;
	}

	@Column(name="username", nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="estado", nullable = true)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
