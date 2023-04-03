package progetto.classi;

public class Server {
    private String id;
    private Zona zona;
    private int uptime;
    private int numPorte;
    private int numAttacchi;
    private int tempoRiparazione;

    public Server(String id, Zona zona, int uptime, int numPorte, int numAttacchi, int tempoRiparazione) {
        this.id = id;
        this.zona = zona;
        this.uptime = uptime;
        this.numPorte = numPorte;
        this.numAttacchi = numAttacchi;
        this.tempoRiparazione = tempoRiparazione;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public int getUptime() {
        return uptime;
    }

    public void setUptime(int uptime) {
        this.uptime = uptime;
    }

    public int getNumPorte() {
        return numPorte;
    }

    public void setNumPorte(int numPorte) {
        this.numPorte = numPorte;
    }

    public int getNumAttacchi() {
        return numAttacchi;
    }

    public void setNumAttacchi(int numAttacchi) {
        this.numAttacchi = numAttacchi;
    }

    public int getTempoRiparazione() {
        return tempoRiparazione;
    }

    public void setTempoRiparazione(int tempoRiparazione) {
        this.tempoRiparazione = tempoRiparazione;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id='" + id + '\'' +
                ", zona=" + zona +
                ", uptime=" + uptime +
                ", numPorte=" + numPorte +
                ", numAttacchi=" + numAttacchi +
                ", tempoRiparazione=" + tempoRiparazione +
                '}';
    }
}
