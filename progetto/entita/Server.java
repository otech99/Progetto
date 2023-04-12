package progetto.entita;

import java.util.ArrayList;

public class Server {
    private final String id;
    private final Zona zona;
    private final int uptime;
    private final int numPorte;
    private int numAttacchi;
    private final int tempoRiparazione;
    private Categoria catg;
    private int attDir=0;

    private int attIndir=0;


    private final ArrayList<Server> ServerList = new ArrayList<>();
    private final ArrayList<Servizio> ServiziList = new ArrayList<>();


    public void setNumAttacchi(int numAttacchi) {
        this.numAttacchi = numAttacchi;
    }

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


    public Zona getZona() {
        return zona;
    }

    public int getUptime() {
        return uptime;
    }

    public int getNumAttacchi() {
        return numAttacchi;
    }

    public void setServerList(Server server){
        ServerList.add(server);
    }

    public ArrayList<Server> getServerList(){
        return this.ServerList;
    }
    public ArrayList<Servizio>getServiziList(){
        return this.ServiziList;
    }

    public void setServiziList(Servizio servizio){
        ServiziList.add(servizio);
    }
    public Categoria getCatg(){
        return catg;
    }
    public void setCatg(Categoria catg){
        this.catg= catg;
    }
    public int getAttDir() {
        return attDir;
    }

    public void setAttDir(int attDir) {
        this.attDir = attDir;
    }

    public int getAttIndir() {
        return attIndir;
    }

    public void setAttIndir(int attIndir) {
        this.attIndir = attIndir;
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
