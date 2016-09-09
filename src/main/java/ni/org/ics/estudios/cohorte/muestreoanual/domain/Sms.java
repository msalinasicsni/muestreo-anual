package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa un rol
 * 
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "sms", catalog = "muestreoanual")
public class Sms {
	
	private Integer idSms;
	private Date created;
	private String toNumber;
    private String content;
    
    @javax.persistence.Column(name = "id_sms")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	public Integer getIdSms() {
		return idSms;
	}
	public void setIdSms(Integer idSms) {
		this.idSms = idSms;
	}
	
	@Column(name = "fecha_creacion", nullable = false)
    public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	@Column(name = "numero", nullable = true, length =50)
	public String getToNumber() {
		return toNumber;
	}
	public void setToNumber(String toNumber) {
		this.toNumber = toNumber;
	}
	
	@Column(name = "mensaje", nullable = true)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
