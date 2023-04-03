package progetto.classi;

public class Server {
    private String id;
    private String idZonaS;
    private int uptime;
    private int numPorte;
    private int numAttacchi;
    private int tempoRiparazione;
    private int numServerCollegati;


    public Server(String id, String idZonaS, int uptime,int numPorte, int numAttacchi,int tempoRiparazione,int numServerCollegati ){
        this.id= id;
        this.idZonaS = idZonaS;
        this.uptime= uptime;
        this.numPorte = numPorte;
        this.numAttacchi= numAttacchi;
        this.tempoRiparazione= tempoRiparazione;
        this.numServerCollegati= numServerCollegati;
    }
}
