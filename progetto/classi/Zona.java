package progetto.classi;

public class Zona {
    private String id;
    public Zona(String id){
        this.id= id;
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
    /*
    @Override
    public String toString() {
        return "Zona{" +
                "id='" + id + '\'' +
                '}';
    }
     */

}
