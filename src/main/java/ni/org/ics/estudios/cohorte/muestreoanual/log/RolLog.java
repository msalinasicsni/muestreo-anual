package ni.org.ics.estudios.cohorte.muestreoanual.log;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * Simple objeto de dominio que representa un usuario
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "usuarios_roles_log", catalog = "muestreoanual")
public class RolLog {
	
	private Integer idRol;
	private Date created;
	private String username;
	private String authority;
	private String usuario;
	
	public RolLog(Date created, String username,
			String authority, String usuario) {
		super();
		this.created = created;
		this.username = username;
		this.authority = authority;
		this.usuario = usuario;
	}
	
	
	@javax.persistence.Column(name = "id_rol")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	@Column(name = "fecha_creacion", nullable = false)
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name = "username", nullable = false, length =50)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "authority", nullable = false, length =50)
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Column(name = "usuario", nullable = false, length =50)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
