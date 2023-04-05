package progetto.classi;

public class Zona {
    private String id;
    int servPerZona;
    public Zona(String id){
        this.id= id;
        this.servPerZona=servPerZona;
    }
    public int getServPerZona(){
        return this.servPerZona;
    }

    public void setServPerZona(int servPerZona) {
        this.servPerZona = servPerZona;
    }

    public String getZona(){
        return this.id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Zona{" +
                "id='" + id + '\'' +
                '}';
    }


}
