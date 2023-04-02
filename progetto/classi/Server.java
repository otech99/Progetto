package progetto.classi;

public class Server {
    String id;
    int uptime;
    int numPorte;
    int numAttacchi;
    int tempoRiparazione;
    public Server(String id,int uptime,int numPorte, int numAttacchi,int tempoRiparazione){
        this.id= id;
        this.uptime= uptime;
        this.numPorte = numPorte;
        this.numAttacchi= numAttacchi;
        this.tempoRiparazione= tempoRiparazione;
    }
}
