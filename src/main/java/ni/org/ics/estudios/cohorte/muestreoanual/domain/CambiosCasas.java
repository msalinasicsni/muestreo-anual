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
@Table(name = "cambios_casas", catalog = "muestreoanual")
public class CambiosCasas {

	/**
	 * 
	 */
	
	private Date fechaRegistro;
	private Integer codigo;
	private Integer codCasaAnterior;
	private Integer codCasaActual;
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
	
	
	@Column(name = "codigo", nullable = true)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	@Column(name = "cod_casa_anterior", nullable = true)
	public Integer getCodCasaAnterior() {
		return codCasaAnterior;
	}

	public void setCodCasaAnterior(Integer codCasaAnterior) {
		this.codCasaAnterior = codCasaAnterior;
	}

	@Column(name = "cod_casa_actual", nullable = true)
	public Integer getCodCasaActual() {
		return codCasaActual;
	}

	public void setCodCasaActual(Integer codCasaActual) {
		this.codCasaActual = codCasaActual;
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
