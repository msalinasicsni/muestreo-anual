package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa los datos de vacunas recibidas
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "vacunas", catalog = "muestreoanual")
public class Vacuna {

	/**
	 * 
	 */
	private VacunaId vacunaId;
	private Integer vacuna;
	private Date fechaVac;
	private String tipovacuna;
	private Integer tarjetaSN;
	private Integer ndosis;
	private Date fechaInf1;
	private Date fechaInf2;
	private Date fechaInf3;
	private Date fechaInf4;
	private Date fechaInf5;
	private Date fechaInf6;
	private Date fechaInf7;
	private Date fechaInf8;
	private Date fechaInf9;
	private Date fechaInf10;
	private MovilInfo movilInfo;

	@Id
	public VacunaId getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(VacunaId vacunaId) {
		this.vacunaId = vacunaId;
	}

	@Column(name = "vacuna", nullable = false, length = 1)
	public Integer getVacuna() {
		return vacuna;
	}

	public void setVacuna(Integer vacuna) {
		this.vacuna = vacuna;
	}

	@Column(name = "fechaVacunado", nullable = true)
	public Date getFechaVac() {
		return fechaVac;
	}

	public void setFechaVac(Date fechaVac) {
		this.fechaVac = fechaVac;
	}

	@Column(name = "tipovacuna", nullable = true)
	public String getTipovacuna() {
		return tipovacuna;
	}

	public void setTipovacuna(String tipovacuna) {
		this.tipovacuna = tipovacuna;
	}

	@Column(name = "tarjetaSN", nullable = true)
	public Integer getTarjetaSN() {
		return tarjetaSN;
	}

	public void setTarjetaSN(Integer tarjetaSN) {
		this.tarjetaSN = tarjetaSN;
	}

	@Column(name = "ndosis", nullable = true)
	public Integer getNdosis() {
		return ndosis;
	}

	public void setNdosis(Integer ndosis) {
		this.ndosis = ndosis;
	}

	@Column(name = "fechaInf1", nullable = true)
	public Date getFechaInf1() {
		return fechaInf1;
	}

	public void setFechaInf1(Date fechaInf1) {
		this.fechaInf1 = fechaInf1;
	}

	@Column(name = "fechaInf2", nullable = true)
	public Date getFechaInf2() {
		return fechaInf2;
	}

	public void setFechaInf2(Date fechaInf2) {
		this.fechaInf2 = fechaInf2;
	}

	@Column(name = "fechaInf3", nullable = true)
	public Date getFechaInf3() {
		return fechaInf3;
	}

	public void setFechaInf3(Date fechaInf3) {
		this.fechaInf3 = fechaInf3;
	}

	@Column(name = "fechaInf4", nullable = true)
	public Date getFechaInf4() {
		return fechaInf4;
	}

	public void setFechaInf4(Date fechaInf4) {
		this.fechaInf4 = fechaInf4;
	}

	@Column(name = "fechaInf5", nullable = true)
	public Date getFechaInf5() {
		return fechaInf5;
	}

	public void setFechaInf5(Date fechaInf5) {
		this.fechaInf5 = fechaInf5;
	}

	@Column(name = "fechaInf6", nullable = true)
	public Date getFechaInf6() {
		return fechaInf6;
	}

	public void setFechaInf6(Date fechaInf6) {
		this.fechaInf6 = fechaInf6;
	}

	@Column(name = "fechaInf7", nullable = true)
	public Date getFechaInf7() {
		return fechaInf7;
	}

	public void setFechaInf7(Date fechaInf7) {
		this.fechaInf7 = fechaInf7;
	}

	@Column(name = "fechaInf8", nullable = true)
	public Date getFechaInf8() {
		return fechaInf8;
	}

	public void setFechaInf8(Date fechaInf8) {
		this.fechaInf8 = fechaInf8;
	}

	@Column(name = "fechaInf9", nullable = true)
	public Date getFechaInf9() {
		return fechaInf9;
	}

	public void setFechaInf9(Date fechaInf9) {
		this.fechaInf9 = fechaInf9;
	}

	@Column(name = "fechaInf10", nullable = true)
	public Date getFechaInf10() {
		return fechaInf10;
	}

	public void setFechaInf10(Date fechaInf10) {
		this.fechaInf10 = fechaInf10;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

}
