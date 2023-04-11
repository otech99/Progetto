package progetto.entita;

import java.util.ArrayList;

public class Zona {
    private final String id;
    private static int numZoneTotali;
    ArrayList<Server> serverZona = new ArrayList<>();
    public Zona(String id){
        this.id= id;
        numZoneTotali++;
    }
    public String getId() {
        return id;
    }
    public void setServerZona(Server server){
        this.serverZona.add(server);
    }
    public ArrayList<Server> getServerZona(){
        return this.serverZona;
    }

    public static int getNumZoneTotali() {
        return numZoneTotali;
    }
    @Override
    public String toString() {
        return "Zona{" +
                "id='" + id + '\'' +
                '}';
    }


}
