package progetto.classi;

public class Server {
    private String id;
    private String idZonaS;
    private int uptime;
    private int numPorte;
    private int numAttacchi;
    private int tempoRiparazione;


    public Server(String id, String idZonaS, int uptime,int numPorte, int numAttacchi,int tempoRiparazione ){
        this.id= id;
        this.idZonaS = idZonaS;
        this.uptime= uptime;
        this.numPorte = numPorte;
        this.numAttacchi= numAttacchi;
        this.tempoRiparazione= tempoRiparazione;
    }
}
