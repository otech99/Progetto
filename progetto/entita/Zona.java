package progetto.entita;

import java.util.ArrayList;

public class Zona {
    private final String id;

    ArrayList<Server> serverZona = new ArrayList<>();
    public Zona(String id){
        this.id= id;
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
    @Override
    public String toString() {
        return "Zona{" +
                "id='" + id + '\'' +
                '}';
    }


}
