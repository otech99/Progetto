package progetto.task;


import progetto.classi.Server;
import progetto.classi.Zona;

public class task1 {
    public static void numTotale(){
        System.out.print(Server.getNumServerTotali()+" ");
        System.out.println(Zona.getNumZoneTotali());
    }
}
