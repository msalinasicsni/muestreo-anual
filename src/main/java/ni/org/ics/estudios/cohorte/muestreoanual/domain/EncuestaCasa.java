package ni.org.ics.estudios.cohorte.muestreoanual.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Simple objeto de dominio que representa una encuesta de casa que se le
 * realiza a cada participante de los
 * 
 * estudios
 * 
 * @author Brenda Lopez
 **/

@Entity
@Table(name = "encuestas_casas", catalog = "muestreoanual")
public class EncuestaCasa {

	/**
	 * 
	 */
	private EncuestaCasaId encCasaId;
	private Integer cvivencasa1;
	private Integer cvivencasa2;
	private Integer cvivencasa3;
	private Integer cvivencasa4;
	private Integer cvivencasa5;
	private Integer cvivencasa6;
	private Integer ccuartos;
	private Integer grifo;
	private Integer grifoComSN;
	private Integer horasagua;
	private String mcasa;
	private String ocasa;
	private Integer piso;
	private String opiso;
	private Integer techo;
	private String otecho;
	private Integer cpropia;
	private Integer cabanicos;
	private Integer ctelevisores;
	private Integer crefrigeradores;
	private Integer moto;
	private Integer carro;
	private Integer cocinalena;
	private Integer animalesSN;
	private Integer pollos;
	private Integer polloscasa;
	private Integer patos;
	private Integer patoscasa;
	private Integer perros;
	private Integer perroscasa;
	private Integer gatos;
	private Integer gatoscasa;
	private Integer cerdos;
	private Integer cerdoscasa;
	private MovilInfo movilInfo;


	@EmbeddedId
	public EncuestaCasaId getEncCasaId() {
		return encCasaId;
	}

	public void setEncCasaId(EncuestaCasaId encCasaId) {
		this.encCasaId = encCasaId;
	}

	@Column(name = "cvivencasa1", nullable = false, length = 2)
	public Integer getCvivencasa1() {
		return cvivencasa1;
	}

	public void setCvivencasa1(Integer cvivencasa1) {
		this.cvivencasa1 = cvivencasa1;
	}

	@Column(name = "cvivencasa2", nullable = false, length = 2)
	public Integer getCvivencasa2() {
		return cvivencasa2;
	}

	public void setCvivencasa2(Integer cvivencasa2) {
		this.cvivencasa2 = cvivencasa2;
	}

	@Column(name = "cvivencasa3", nullable = false, length = 2)
	public Integer getCvivencasa3() {
		return cvivencasa3;
	}

	public void setCvivencasa3(Integer cvivencasa3) {
		this.cvivencasa3 = cvivencasa3;
	}

	@Column(name = "cvivencasa4", nullable = false, length = 2)
	public Integer getCvivencasa4() {
		return cvivencasa4;
	}

	public void setCvivencasa4(Integer cvivencasa4) {
		this.cvivencasa4 = cvivencasa4;
	}

	@Column(name = "cvivencasa5", nullable = false, length = 2)
	public Integer getCvivencasa5() {
		return cvivencasa5;
	}

	public void setCvivencasa5(Integer cvivencasa5) {
		this.cvivencasa5 = cvivencasa5;
	}

	@Column(name = "cvivencasa6", nullable = false, length = 2)
	public Integer getCvivencasa6() {
		return cvivencasa6;
	}

	public void setCvivencasa6(Integer cvivencasa6) {
		this.cvivencasa6 = cvivencasa6;
	}

	@Column(name = "ccuartos", nullable = false, length = 2)
	public Integer getCcuartos() {
		return ccuartos;
	}

	public void setCcuartos(Integer ccuartos) {
		this.ccuartos = ccuartos;
	}

	@Column(name = "grifo", nullable = true, length = 1)
	public Integer getGrifo() {
		return grifo;
	}

	public void setGrifo(Integer grifo) {
		this.grifo = grifo;
	}

	@Column(name = "grifocomsn", nullable = true, length = 1)
	public Integer getGrifoComSN() {
		return grifoComSN;
	}

	public void setGrifoComSN(Integer grifoComSN) {
		this.grifoComSN = grifoComSN;

	}

	@Column(name = "horasagua", nullable = true, length = 2)
	public Integer gethorasagua() {
		return horasagua;
	}

	public void sethorasagua(Integer horasagua) {
		this.horasagua = horasagua;

	}

	@Column(name = "mcasa", nullable = true, length = 20)
	public String getMcasa() {
		return mcasa;
	}

	public void setMcasa(String mcasa) {
		this.mcasa = mcasa;
	}

	@Column(name = "ocasa", nullable = true, length = 20)
	public String getOcasa() {
		return ocasa;
	}

	public void setOcasa(String ocasa) {
		this.ocasa = ocasa;
	}

	@Column(name = "piso", nullable = true, length = 1)
	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	@Column(name = "opiso", nullable = true, length = 20)
	public String getOpiso() {
		return opiso;
	}

	public void setOpiso(String opiso) {
		this.opiso = opiso;
	}

	@Column(name = "techo", nullable = true, length = 1)
	public Integer getTecho() {
		return techo;
	}

	public void setTecho(Integer techo) {
		this.techo = techo;
	}

	@Column(name = "otecho", nullable = true, length = 20)
	public String getOtecho() {
		return otecho;
	}

	public void setOtecho(String otecho) {
		this.otecho = otecho;
	}

	@Column(name = "cpropia", nullable = true, length = 1)
	public Integer getCpropia() {
		return cpropia;
	}

	public void setCpropia(Integer cpropia) {
		this.cpropia = cpropia;
	}

	@Column(name = "cabanicos", nullable = true, length = 1)
	public Integer getCabanicos() {
		return cabanicos;
	}

	public void setCabanicos(Integer cabanicos) {
		this.cabanicos = cabanicos;
	}

	@Column(name = "ctelevisores", nullable = true, length = 1)
	public Integer getCtelevisores() {
		return ctelevisores;
	}

	public void setCtelevisores(Integer ctelevisores) {
		this.ctelevisores = ctelevisores;
	}

	@Column(name = "crefrigeradores", nullable = true, length = 1)
	public Integer getCrefrigeradores() {
		return crefrigeradores;
	}

	public void setCrefrigeradores(Integer crefrigeradores) {
		this.crefrigeradores = crefrigeradores;
	}

	@Column(name = "moto", nullable = true, length = 1)
	public Integer getMoto() {
		return moto;
	}

	public void setMoto(Integer moto) {
		this.moto = moto;
	}

	@Column(name = "carro", nullable = true, length = 1)
	public Integer getCarro() {
		return carro;
	}

	public void setCarro(Integer carro) {
		this.carro = carro;
	}

	@Column(name = "cocinalena", nullable = true, length = 1)
	public Integer getCocinalena() {
		return cocinalena;
	}

	public void setCocinalena(Integer cocinalena) {
		this.cocinalena = cocinalena;
	}

	@Column(name = "animalessn", nullable = true, length = 1)
	public Integer getAnimalesSN() {
		return animalesSN;
	}

	public void setAnimalesSN(Integer animalesSN) {
		this.animalesSN = animalesSN;
	}

	@Column(name = "pollos", nullable = true, length = 2)
	public Integer getPollos() {
		return pollos;
	}

	public void setPollos(Integer pollos) {
		this.pollos = pollos;
	}

	@Column(name = "polloscasa", nullable = true, length = 1)
	public Integer getPolloscasa() {
		return polloscasa;
	}

	public void setPolloscasa(Integer polloscasa) {
		this.polloscasa = polloscasa;
	}

	@Column(name = "patos", nullable = true, length = 2)
	public Integer getPatos() {
		return patos;
	}

	public void setPatos(Integer patos) {
		this.patos = patos;
	}

	@Column(name = "patoscasa", nullable = true, length = 1)
	public Integer getPatoscasa() {
		return patoscasa;
	}

	public void setPatoscasa(Integer patoscasa) {
		this.patoscasa = patoscasa;
	}

	@Column(name = "perros", nullable = true, length = 2)
	public Integer getPerros() {
		return perros;
	}

	public void setPerros(Integer perros) {
		this.perros = perros;
	}

	@Column(name = "perroscasa", nullable = true, length = 1)
	public Integer getPerroscasa() {
		return perroscasa;
	}

	public void setPerroscasa(Integer perroscasa) {
		this.perroscasa = perroscasa;
	}

	@Column(name = "gatos", nullable = true, length = 2)
	public Integer getGatos() {
		return gatos;
	}

	public void setGatos(Integer gatos) {
		this.gatos = gatos;
	}

	@Column(name = "gatoscasa", nullable = true, length = 1)
	public Integer getGatoscasa() {
		return gatoscasa;
	}

	public void setGatoscasa(Integer gatoscasa) {
		this.gatoscasa = gatoscasa;
	}

	@Column(name = "cerdos", nullable = true, length = 2)
	public Integer getCerdos() {
		return cerdos;
	}

	public void setCerdos(Integer cerdos) {
		this.cerdos = cerdos;
	}

	@Column(name = "cerdoscasa", nullable = true, length = 1)
	public Integer getCerdoscasa() {
		return cerdoscasa;
	}

	public void setCerdoscasa(Integer cerdoscasa) {
		this.cerdoscasa = cerdoscasa;
	}

	public MovilInfo getMovilInfo() {
		return movilInfo;
	}

	public void setMovilInfo(MovilInfo movilInfo) {
		this.movilInfo = movilInfo;
	}

}
