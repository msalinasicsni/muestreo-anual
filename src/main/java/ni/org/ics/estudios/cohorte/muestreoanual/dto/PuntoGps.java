package ni.org.ics.estudios.cohorte.muestreoanual.dto;

public class PuntoGps {
    private int codigo;
    private Double latitud;
    private Double longitud;
    private Integer tuboleu;
    private String pbmc;
    private String paxgene;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Integer getTuboleu() {
        return tuboleu;
    }

    public void setTuboleu(Integer tuboleu) {
        this.tuboleu = tuboleu;
    }

    public String getPbmc() {
        return pbmc;
    }

    public void setPbmc(String pbmc) {
        this.pbmc = pbmc;
    }

    public String getPaxgene() {
        return paxgene;
    }

    public void setPaxgene(String paxgene) {
        this.paxgene = paxgene;
    }
}
