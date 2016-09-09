package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa un opo
 * 
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "opos", catalog = "muestreoanual")
public class Opo {
	
	private Integer idOpo;
	private Date created;
	private Integer version;
    private String rx_id;
    private Integer failed_rx_count;
    private Integer ul_dt;
    private Integer m_time_confidence;
    private Long m_unixtime;
    private Long tx_unixtime;
    private Integer tx_time_confidence;
    private Integer ul_rf_dt;
    private Float range;
    private Integer range_dt;
    private String tx_id;
    
    @javax.persistence.Column(name = "id_opo")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    public Integer getIdOpo() {
		return idOpo;
	}
	public void setIdOpo(Integer idOpo) {
		this.idOpo = idOpo;
	}
	
	@Column(name = "fecha_creacion", nullable = false)
    public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	@Column(name = "rx_id", nullable = true, length =25)
	public String getRxId() {
		return rx_id;
	}
	public void setRxId(String rxId) {
		this.rx_id = rxId;
	}
	
	@Column(name = "version", nullable = true)
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Column(name = "failed_rx_count", nullable = true)
	public Integer getFailedRxCount() {
		return failed_rx_count;
	}
	public void setFailedRxCount(Integer failedRxCount) {
		this.failed_rx_count = failedRxCount;
	}
	
	@Column(name = "ul_dt", nullable = true)
	public Integer getUlDt() {
		return ul_dt;
	}
	public void setUlDt(Integer ulDt) {
		this.ul_dt = ulDt;
	}
	
	@Column(name = "m_time_confidence", nullable = true)
	public Integer getmTimeConfidence() {
		return m_time_confidence;
	}
	public void setmTimeConfidence(Integer mTimeConfidence) {
		this.m_time_confidence = mTimeConfidence;
	}
	
	@Column(name = "m_unixtime", nullable = true)
	public Long getmUnixTime() {
		return m_unixtime;
	}
	public void setmUnixTime(Long mUnixTime) {
		this.m_unixtime = mUnixTime;
	}
	
	@Column(name = "tx_unixtime", nullable = true)
	public Long getTxUnixTime() {
		return tx_unixtime;
	}
	public void setTxUnixTime(Long txUnixTime) {
		this.tx_unixtime = txUnixTime;
	}
	
	@Column(name = "tx_time_confidence", nullable = true)
	public Integer getTxTimeConfidence() {
		return tx_time_confidence;
	}
	public void setTxTimeConfidence(Integer txTimeConfidence) {
		this.tx_time_confidence = txTimeConfidence;
	}
	
	@Column(name = "ul_rf_dt", nullable = true)
	public Integer getUlRfDt() {
		return ul_rf_dt;
	}
	public void setUlRfDt(Integer ulRfDt) {
		this.ul_rf_dt = ulRfDt;
	}
	
	@Column(name = "range_dt", nullable = true)
	public Integer getRangeDt() {
		return range_dt;
	}
	public void setRangeDt(Integer rangeDt) {
		this.range_dt = rangeDt;
	}
	
	@Column(name = "tx_id", nullable = true, length =25)
	public String getTxId() {
		return tx_id;
	}
	public void setTxId(String txId) {
		this.tx_id = txId;
	}
	@Column(name = "range_t", nullable = true)
	public Float getRange() {
		return range;
	}
	public void setRange(Float range) {
		this.range = range;
	}
	
	
}
