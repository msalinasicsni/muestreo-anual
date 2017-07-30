package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.IndexColumn;
import org.hibernate.validator.constraints.NotBlank;



/**
 * Simple objeto de dominio que representa un usuario
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "usuarios_sistema", catalog = "muestreoanual")
public class User {
	private String username;
	private Date created;
	private String password;
	private String completeName;
	private String email;
	private Boolean enabled=true;
	private Boolean muestra=false;
	private Boolean encuestaCasa=false;
	private Boolean encuestaParticipante=false;
	private Boolean encuestaLactancia=false;
	private Boolean encuestaSatisfaccion=false;
	private Boolean obsequio=false;
	private Boolean pesoTalla=false;
	private Boolean vacunas=false;
	private Boolean visitas=false;
	private Boolean recepcion=false;
	private Boolean consentimiento=false;
	private Boolean casazika=false;
	private Boolean tamizajezika=false;
	private Boolean datosparto=false;
	private String usuario;
	private Set<Authority> authorities;
	
	@Id
	@Column(name = "username", nullable = false, length =50)
	@Size(min = 5, max = 50, message = "Nombre de usuario debe contener minimo 5 caracteres.")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Solo alfanumerico sin espacios")
	@NotBlank(message = "No puede estar vacio.")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "fecha_modificacion", nullable = false)
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name = "password", nullable = false, length =150)
	@Size(min = 4, max = 150, message = "Contraseña debe contener minimo 8 caracteres.")
	@Pattern(regexp = "^[a-zA-Z0-9!@#$%^&*()?/]+$", message = "Solo alfanumerico y caracteres especiales (!@#$%^&*()?/). No espacios")
	@NotBlank(message = "No puede estar vacio.")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "descripcion", nullable = false, length =250)
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
	
	@Column(name = "muestra", nullable = false)
	public Boolean getMuestra() {
		return muestra;
	}
	public void setMuestra(Boolean muestra) {
		this.muestra = muestra;
	}
	@Column(name = "ecasa", nullable = false)
	public Boolean getEncuestaCasa() {
		return encuestaCasa;
	}
	public void setEncuestaCasa(Boolean encuestaCasa) {
		this.encuestaCasa = encuestaCasa;
	}
	@Column(name = "eparticipante", nullable = false)
	public Boolean getEncuestaParticipante() {
		return encuestaParticipante;
	}
	public void setEncuestaParticipante(Boolean encuestaParticipante) {
		this.encuestaParticipante = encuestaParticipante;
	}
	@Column(name = "elactancia", nullable = false)
	public Boolean getEncuestaLactancia() {
		return encuestaLactancia;
	}
	public void setEncuestaLactancia(Boolean encuestaLactancia) {
		this.encuestaLactancia = encuestaLactancia;
	}
	@Column(name = "esatisfaccion", nullable = false)
	public Boolean getEncuestaSatisfaccion() {
		return encuestaSatisfaccion;
	}
	public void setEncuestaSatisfaccion(Boolean encuestaSatisfaccion) {
		this.encuestaSatisfaccion = encuestaSatisfaccion;
	}
	@Column(name = "obsequio", nullable = false)
	public Boolean getObsequio() {
		return obsequio;
	}
	public void setObsequio(Boolean obsequio) {
		this.obsequio = obsequio;
	}
	@Column(name = "pesotalla", nullable = false)
	public Boolean getPesoTalla() {
		return pesoTalla;
	}
	public void setPesoTalla(Boolean pesoTalla) {
		this.pesoTalla = pesoTalla;
	}
	@Column(name = "vacunas", nullable = false)
	public Boolean getVacunas() {
		return vacunas;
	}
	public void setVacunas(Boolean vacunas) {
		this.vacunas = vacunas;
	}
	@Column(name = "visitas", nullable = false)
	public Boolean getVisitas() {
		return visitas;
	}
	public void setVisitas(Boolean visitas) {
		this.visitas = visitas;
	}
	@Column(name = "recepcion", nullable = false)
	public Boolean getRecepcion() {
		return recepcion;
	}
	public void setRecepcion(Boolean recepcion) {
		this.recepcion = recepcion;
	}
	@Column(name = "consentimiento", nullable = false)
	public Boolean getConsentimiento() {
		return consentimiento;
	}
	public void setConsentimiento(Boolean consentimiento) {
		this.consentimiento = consentimiento;
	}
	@Column(name = "casazika", nullable = false)
	public Boolean getCasazika() {
		return casazika;
	}
	public void setCasazika(Boolean casazika) {
		this.casazika = casazika;
	}
	@Column(name = "tamizajezika", nullable = false)
	public Boolean getTamizajezika() {
		return tamizajezika;
	}
	public void setTamizajezika(Boolean tamizajezika) {
		this.tamizajezika = tamizajezika;
	}
	
	@Column(name = "datosparto", nullable = false)
	public Boolean getDatosparto() {
		return datosparto;
	}
	public void setDatosparto(Boolean datosparto) {
		this.datosparto = datosparto;
	}
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	@IndexColumn(name = "username", base=0)
	public Set<Authority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
	@Column(name = "usuario", nullable = false, length =50)
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
