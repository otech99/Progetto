package progetto.TASK;


import progetto.classi.Categoria;
import progetto.classi.Server;
import progetto.classi.Zona;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void numTotale(){
        System.out.print(Server.getNumServerTotali()+" ");
        System.out.println(Zona.getNumZoneTotali());
    }

    // FUNZIONE ALTERNATIVA PER STAMAPRE IL NUMERO DI SERVER PER OGNI CATEGORIA
    public static void serverPerCateg(Server[] server){
        int zombie=0, honeypot=0, singleton=0;
        for(Server s:server){
            Categoria categoria = s.getCatg();
            switch (categoria){
                case zombie ->
                    zombie++;
                case honeypot ->
                    honeypot++;
                case singleton ->
                    singleton++;
            }
        }
        System.out.print(zombie+" ");
        System.out.print(honeypot+" ");
        System.out.println(singleton);
    }
    // Funzione per ottenere la categoria con il maggior numero di server
    public static Categoria getCategoriaConPiuServer(Server[] server) {
        Map<Categoria, Integer> conteggioCategorie = new HashMap<>();
        // Itera sulla lista dei server e aggiorna il conteggio delle categorie
        for (Server s : server) {
            Categoria categoria = s.getCatg();
            if (categoria != null) {
                if (conteggioCategorie.containsKey(categoria)) {
                    conteggioCategorie.put(categoria, conteggioCategorie.get(categoria) + 1);
                } else
                    conteggioCategorie.put(categoria, 1);
            }
        }
        Categoria categoriaMax = null;
        int maxServer = 0;
        // Trova la categoria con il maggior numero di server
        for (Categoria categoria : Categoria.values()) {
            if (conteggioCategorie.containsKey(categoria)) {
                int numeroServer = conteggioCategorie.get(categoria);
                if (numeroServer > maxServer) {
                    maxServer = numeroServer;
                    categoriaMax = categoria;
                }
            }
        }
        // Restituisci la categoria con il maggior numero di server
        return categoriaMax;
    }
    // Restituisci il nome del server a cui appartiene l'ArrayList più lunga tra le ArrayList di serverCollegati
    public static String getServerConPiuColleg(Server[] server) {
        String servConPiuColl = null;
        int lunghezzaMax = 0;
        String nomeServerLessicografico = null;

        // Ordina l'array di server in base alla lunghezza delle ArrayList di serverCollegati
        Arrays.sort(server, Comparator.comparingInt(s -> s.getServerList().size()));
        // Itera l'array di server in ordine inverso (dall'ultimo al primo)
        for (int i = server.length - 1; i >= 0; i--) {
            if (server[i].getServerList().size() > lunghezzaMax) {
                lunghezzaMax = server[i].getServerList().size();
                servConPiuColl = server[i].getId();
                nomeServerLessicografico = server[i].getId();
            } else if (server[i].getServerList().size() == lunghezzaMax && server[i].getId().compareTo(nomeServerLessicografico) < 0) {
                nomeServerLessicografico = server[i].getId();
            }
        }
        return nomeServerLessicografico;
    }
    //RITORNA IL NUMERO DI SERVER CON UPTIME ALMENO 98
    public static int numServUptime(Server[] server){
        int a = 98;
        int numServUp=0;
        for (Server s: server){
            if (s.getUptime()>= a)
                numServUp++;
        }
        return numServUp;
    }
    // ancora da controllare perche non va bene
    public static void serverPerZona(Server[] server,Zona[] zona){
        Map<String,Integer>servPerZon =new HashMap<>();
        for (Zona z: zona) {
            String zon = z.getId();
            int i = 0;
            for (Server s:server)
                if (s.getZona().equals(zon)){
                    i++;
                servPerZon.put(zon,i);}
            System.out.println(servPerZon.get(zon)+' ');
        }

    }

}
