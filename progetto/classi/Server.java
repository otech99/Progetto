package progetto.classi;

import java.util.ArrayList;

public class Server {
    private String id;
    private Zona zona;
    private int uptime;
    private int numPorte;
    private int numAttacchi;
    private int tempoRiparazione;
    private Categoria catg;
    private static int numServerTotali;

    private ArrayList<Server> ServerList = new ArrayList<>();
    private ArrayList<Servizio> ServiziList = new ArrayList<>();


    public Server(String id, Zona zona, int uptime, int numPorte, int numAttacchi, int tempoRiparazione) {
        this.id = id;
        this.zona = zona;
        this.uptime = uptime;
        this.numPorte = numPorte;
        this.numAttacchi = numAttacchi;
        this.tempoRiparazione = tempoRiparazione;
        this.catg =catg;
        numServerTotali++;
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

    public void setServerList(Server server){
        ServerList.add(server);
    }

    public ArrayList<Server> getServerList(){
        return this.ServerList;
    }
    public ArrayList<Servizio>getServiziList(){
        return this.ServiziList;
    }

    public ArrayList<String> getServerCollegati(){
        ArrayList<String> serverColl = new ArrayList<>();
        for(Server e : ServerList)
            serverColl.add(e.getId());

        return serverColl;
    }
    public ArrayList<String> getServiziServer(){
        ArrayList<String> serviziServer = new ArrayList<>();
        for(Servizio e : ServiziList)
            serviziServer.add(e.getNome());

        return serviziServer;
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
    public static int getNumServerTotali() {
        return numServerTotali;
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
