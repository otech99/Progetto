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
    // Funzione per stampare il numero di server per ogni categoria
    public static void serverPerCategoria(Server[] server) {
        Map<Categoria, Integer> conteggioCategorie = new HashMap<>();

        // Itera sulla lista dei server e aggiorna il conteggio delle categorie
        for (Server s : server) {
            Categoria categoria = s.getCatg();
            if (categoria != null) {
                if (conteggioCategorie.containsKey(categoria)) {
                    conteggioCategorie.put(categoria, conteggioCategorie.get(categoria) + 1);
                } else {
                    conteggioCategorie.put(categoria, 1);
                }
            }
        }

        // Stampa il numero di server per ogni categoria
        for (Map.Entry<Categoria, Integer> entry : conteggioCategorie.entrySet()) {
            Categoria categoria = entry.getKey();
            int numeroServer = entry.getValue();
            System.out.println(categoria + " " + numeroServer);
        }
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

}
