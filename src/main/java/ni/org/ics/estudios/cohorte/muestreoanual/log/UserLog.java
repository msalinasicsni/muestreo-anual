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
@Table(name = "usuarios_sistema_log", catalog = "muestreoanual")
public class UserLog {
	private Integer idUser;
	private Date created;
	private String username;
	private String password;
	private String completeName;
	private String email;
	private Boolean enabled;
	private String usuario;
	
	
	
	public UserLog(Date created, String username, String password,
			String completeName, String email, Boolean enabled, String usuario) {
		super();
		this.created = created;
		this.username = username;
		this.password = password;
		this.completeName = completeName;
		this.email = email;
		this.enabled = enabled;
		this.usuario = usuario;
	}
	@javax.persistence.Column(name = "id_user")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer getIdUser() {
		return idUser;
	}
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
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
	@Column(name = "password", nullable = false, length =150)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "descripcion", nullable = true, length =250)
	public String getCompleteName() {
		return completeName;
	}
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}
	@Column(name = "email", nullable = true, length =100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "enabled", nullable = false)
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	@Column(name = "usuario", nullable = false, length =50)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
