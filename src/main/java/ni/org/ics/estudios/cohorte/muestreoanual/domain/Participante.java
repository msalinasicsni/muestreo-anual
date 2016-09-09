package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Simple objeto de dominio que representa un participante de los estudios
 * 
 * @author William Aviles
 **/

@Entity
@Table(name = "participantes", catalog = "muestreoanual", uniqueConstraints = { @UniqueConstraint(columnNames = "codigo") })
public class Participante {

	/**
	 * 
	 */
	private Integer codigo;
	private Integer codCasa;
	private Integer manzFicha1;
	private Integer barrioFicha1;
	private String barrioDesc;
	private String direcFicha1;
	private Double latitud;
	private Double longitud;
	private String conPto;
	private Date fecha;
	private Integer estPart;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String sexo;
	private Date fechaNac;
	private Integer edad;
	private String nombrePt1;
	private String nombrePt2;
	private String apellidoPt1;
	private String apellidoPt2;
	private Integer relacionFam;
	private String nombrePadre;
	private String nombreMadre;
	private String expediente;
	private Integer asiste;
	private String us;
	private Integer hiDeng;
	private Date cuanDeng;
	private Integer hospDeng;
	private Date cuanHospDeng;
	private String estudio;
	private String pbmc;
	private String consDeng;
	private String reConsDeng;
	private String zika;
	private String consFlu;
	private String consChik;
	private String conmx;
	private String conmxbhc;
	private String encLacMat;
	private String pesoTalla;
	private String encPart;
	private String enCasa;
	private String obsequio;
	private String convalesciente;
	private String infoVacuna;
	private String paxgene;
	private String adn;
	private String retoma;
	private Double volRetoma;
	private String telefono;
	private MovilInfo movilInfo;

	@Id
	@Column(name = "codigo", nullable = false, length = 6)
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Column(name = "cod_casa", nullable = false, length = 4)
	public Integer getCodCasa() {
		return codCasa;
	}

	public void setCodCasa(Integer codCasa) {
		this.codCasa = codCasa;
	}

	@Column(name = "est_part", nullable = false, length = 1)
	public Integer getEstPart() {
		return estPart;
	}

	public void setEstPart(Integer estado) {
		this.estPart = estado;
	}

	@Column(name = "nombre1", nullable = false)
	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	@Column(name = "nombre2", nullable = true)
	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	@Column(name = "apellido1", nullable = false)
	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	@Column(name = "apellido2", nullable = true)
	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Column(name = "sexo", nullable = false)
	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Column(name = "fechanac", nullable = false)
	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	@Column(name = "edad", nullable = false)
	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Column(name = "nombre_pt1", nullable = false)
	public String getNombrePt1() {
		return nombrePt1;
	}

	public void setNombrePt1(String nombrePt1) {
		this.nombrePt1 = nombrePt1;
	}

	@Column(name = "nombre_pt2", nullable = true)
	public String getNombrePt2() {
		return nombrePt2;
	}

	public void setNombrePt2(String nombrePt2) {
		this.nombrePt2 = nombrePt2;
	}

	@Column(name = "apellido_pt1", nullable = false)
	public String getApellidoPt1() {
		return apellidoPt1;
	}

	public void setApellidoPt1(String apellidoPt1) {
		this.apellidoPt1 = apellidoPt1;
	}

	@Column(name = "apellido_pt2", nullable = true)
	public String getApellidoPt2() {
		return apellidoPt2;
	}

	public void setApellidoPt2(String apellidoPt2) {
		this.apellidoPt2 = apellidoPt2;
	}

	@Column(name = "relacion_fam", nullable = false, length = 1)
	public Integer getRelacionFam() {
		return relacionFam;
	}

	public void setRelacionFam(Integer relacionFam) {
		this.relacionFam = relacionFam;
	}

	@Column(name = "nombre_padre", nullable = false)
	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	@Column(name = "nombre_madre", nullable = false)
	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	@Column(name = "expediente", nullable = true, length = 50)
	public String getExpediente() {
		return expediente;
	}

	public void setExpediente(String expediente) {
		this.expediente = expediente;
	}
	
	@Column(name = "asiste", nullable = false, length = 1)
	public Integer getAsiste() {
		return asiste;
	}

	public void setAsiste(Integer asiste) {
		this.asiste = asiste;
	}

	@Column(name = "us", nullable = true, length = 50)
	public String getUs() {
		return us;
	}

	public void setUs(String us) {
		this.us = us;
	}

	@Column(name = "hideng", nullable = false, length = 1)
	public Integer getHiDeng() {
		return hiDeng;
	}

	public void setHiDeng(Integer hiDeng) {
		this.hiDeng = hiDeng;
	}

	@Column(name = "hospdeng", nullable = true, length = 1)
	public Integer getHospDeng() {
		return hospDeng;
	}

	public void setHospDeng(Integer hospDeng) {
		this.hospDeng = hospDeng;
	}

	@Column(name = "cuandeng", nullable = true)
	public Date getCuanDeng() {
		return cuanDeng;
	}

	public void setCuanDeng(Date cuanDeng) {
		this.cuanDeng = cuanDeng;
	}

	@Column(name = "cuanhospdeng", nullable = true)
	public Date getCuanHospDeng() {
		return cuanHospDeng;
	}

	public void setCuanHospDeng(Date cuanHospDeng) {
		this.cuanHospDeng = cuanHospDeng;
	}

	@Column(name = "estudio", nullable = false)
	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	@Column(name = "pbmc", nullable = false, length = 2)
	public String getPbmc() {
		return pbmc;
	}

	public void setPbmc(String pbmc) {
		this.pbmc = pbmc;
	}

	@Column(name = "cons_deng", nullable = false, length = 2)
	public String getConsDeng() {
		return consDeng;
	}

	public void setConsDeng(String consDeng) {
		this.consDeng = consDeng;
	}

	@Column(name = "cons_flu", nullable = false, length = 2)
	public String getConsFlu() {
		return consFlu;
	}

	public void setConsFlu(String consFlu) {
		this.consFlu = consFlu;
	}
	
	@Column(name = "cons_chik", nullable = false, length = 2)
	public String getConsChik() {
		return consChik;
	}

	public void setConsChik(String consChik) {
		this.consChik = consChik;
	}

	@Column(name = "conmx", nullable = false, length = 2)
	public String getConmx() {
		return conmx;
	}

	public void setConmx(String conmx) {
		this.conmx = conmx;
	}

	@Column(name = "enc_lacmat", nullable = false, length = 2)
	public String getEncLacMat() {
		return encLacMat;
	}

	public void setEncLacMat(String encLacMat) {
		this.encLacMat = encLacMat;
	}

	@Column(name = "peso_talla", nullable = false, length = 2)
	public String getPesoTalla() {
		return pesoTalla;
	}

	public void setPesoTalla(String pesoTalla) {
		this.pesoTalla = pesoTalla;
	}

	@Column(name = "enc_part", nullable = false, length = 2)
	public String getEncPart() {
		return encPart;
	}

	public void setEncPart(String encPart) {
		this.encPart = encPart;
	}
	
	@Column(name = "enc_casa", nullable = false, length = 2)
	public String getEnCasa() {
		return enCasa;
	}

	public void setEnCasa(String enCasa) {
		this.enCasa = enCasa;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

	@Column(name = "fecha", nullable = false)
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "conmxbhc", nullable = false, length = 2)
	public String getConmxbhc() {
		return conmxbhc;
	}

	public void setConmxbhc(String conmxbhc) {
		this.conmxbhc = conmxbhc;
	}

	@Column(name = "obsequio", nullable = false, length = 2)
	public String getObsequio() {
		return obsequio;
	}

	public void setObsequio(String obsequio) {
		this.obsequio = obsequio;
	}

	@Column(name = "convalesciente", nullable = true, length = 2)
	public String getConvalesciente() {
		return convalesciente;
	}

	public void setConvalesciente(String convalesciente) {
		this.convalesciente = convalesciente;
	}

	@Column(name = "info_vacuna", nullable = true, length = 2)
	public String getInfoVacuna() {
		return infoVacuna;
	}

	public void setInfoVacuna(String infoVacuna) {
		this.infoVacuna = infoVacuna;
	}

	@Column(name = "paxgene", nullable = true, length = 2)
	public String getPaxgene() {
		return paxgene;
	}

	public void setPaxgene(String paxgene) {
		this.paxgene = paxgene;
	}

	@Column(name = "retoma", nullable = true, length = 2)
	public String getRetoma() {
		return retoma;
	}

	public void setRetoma(String retoma) {
		this.retoma = retoma;
	}

	@Column(name = "vol_retoma", nullable = true)
	public Double getVolRetoma() {
		return volRetoma;
	}

	public void setVolRetoma(Double volRetoma) {
		this.volRetoma = volRetoma;
	}

	@Column(name = "manz_ficha1", nullable = true)
	public Integer getManzFicha1() {
		return manzFicha1;
	}

	public void setManzFicha1(Integer manzFicha1) {
		this.manzFicha1 = manzFicha1;
	}

	@Column(name = "barrio", nullable = true)
	public Integer getBarrioFicha1() {
		return barrioFicha1;
	}

	public void setBarrioFicha1(Integer barrioFicha1) {
		this.barrioFicha1 = barrioFicha1;
	}

	@Column(name = "desc_barrio", nullable = true, length = 50)
	public String getBarrioDesc() {
		return barrioDesc;
	}

	public void setBarrioDesc(String barrioDesc) {
		this.barrioDesc = barrioDesc;
	}

	@Column(name = "direccion_ficha1", nullable = true, length = 500)
	public String getDirecFicha1() {
		return direcFicha1;
	}

	public void setDirecFicha1(String direcFicha1) {
		this.direcFicha1 = direcFicha1;
	}

	@Column(name = "recons_den", nullable = false, length = 2)
	public String getReConsDeng() {
		return reConsDeng;
	}

	public void setReConsDeng(String reConsDeng) {
		this.reConsDeng = reConsDeng;
	}
	
	
	@Column(name = "zika", nullable = false, length = 2)
	public String getZika() {
		return zika;
	}

	public void setZika(String zika) {
		this.zika = zika;
	}
	
	@Column(name = "adn", nullable = false, length = 2)
	public String getAdn() {
		return adn;
	}

	public void setAdn(String adn) {
		this.adn = adn;
	}

	@Column(name = "conpto", nullable = true, length = 2)
	public String getConPto() {
		return conPto;
	}

	public void setConPto(String conPto) {
		this.conPto = conPto;
	}
	
	@Column(name = "latitud", nullable = true)
	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", nullable = true)
	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	@Column(name = "sms_telefono", nullable = true, length = 50)
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
