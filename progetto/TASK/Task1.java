package progetto.TASK;


import progetto.entita.Categoria;
import progetto.entita.Server;
import progetto.entita.Zona;

import java.util.*;

public class Task1 {
    public void task1(Server[] server,Zona[] zona){
        info1(server,zona);

        info2(server);

        info3(server);

        info4(server);

        info5(server,zona);

        info6(server);

        info7(server);

        info8(zona,server);

    }
    private static void info1(Server[] server, Zona[] zona){
        System.out.print(server.length+" ");
        System.out.println(zona.length);
    }
    //STAMPA IL NUMERO DI SERVER PER OGNI CATEGORIA
    private static void info2(Server[] server){
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
    // Restituisci il nome del server a cui appartiene l'ArrayList più lunga tra le ArrayList di serverCollegati
    private static void info3(Server[] server) {
        //String servConPiuColl = null;
        int lunghezzaMax = 0;
        String nomeServerLessicografico = null;

        // Ordina l'array di server in base alla lunghezza delle ArrayList di serverCollegati
        Arrays.sort(server, Comparator.comparingInt(s -> s.getServerList().size()));
        // Itera l'array di server in ordine inverso (dall'ultimo al primo)
        for (int i = server.length - 1; i >= 0; i--) {
            if (server[i].getServerList().size() > lunghezzaMax) {
                lunghezzaMax = server[i].getServerList().size();
                //servConPiuColl = server[i].getId();
                nomeServerLessicografico = server[i].getId();
            } else if (server[i].getServerList().size() == lunghezzaMax && server[i].getId().compareTo(Objects.requireNonNull(nomeServerLessicografico)) < 0)
                nomeServerLessicografico = server[i].getId();
        }
        if (nomeServerLessicografico==null)
            System.out.println();
        System.out.println(nomeServerLessicografico);
    }
    //RITORNA IL NUMERO DI SERVER CON UPTIME ALMENO 98
    private static void info4(Server[] server){
        int a = 98;
        int numServUp=0;
        for (Server s: server){
            if (s.getUptime()>= a)
                numServUp++;
        }
        System.out.println(numServUp);
    }
    // STAMPA IL NUMERO DI SERVER PER OGNI ZONA
    private static void info5(Server[] server,Zona[] zona){
        Map<String,Integer>servPerZon =new HashMap<>();
        for (Zona z: zona) {
            String zon = z.getId();
            int i = 0;
            for (Server s:server) {
                String zn = s.getZona().getId();
                if (zn.equals(zon)) {
                    i++;
                }
            }
            servPerZon.put(zon,i);
        }
        for(Integer value :servPerZon.values()){
            System.out.print( value );
            System.out.print(' ');
        }
        System.out.println();
    }
    //numero di uptime piu alto ,piu basso
    private static void info6(Server[] server){
        int maxUptime= server[0].getUptime();
        int numMaxUptime = 0;
        int minUptime= server[0].getUptime();
        int numMinUptime = 0;
        for (Server s:server)
            if (s.getUptime() > maxUptime) {
                maxUptime = s.getUptime();
            }
        for (Server s: server)
            if (s.getUptime() == maxUptime)
                numMaxUptime++;
        for (Server s:server)
            if (s.getUptime() < minUptime) {
                minUptime = s.getUptime();
            }
        for (Server s: server)
            if (s.getUptime() == minUptime)
                numMinUptime++;
        System.out.print(numMinUptime);
        System.out.print(' ');
        System.out.println(numMaxUptime);

    }

    // Restituisce la categoria con il maggior numero di server
    private static void info7(Server[] server) {
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
        System.out.println(categoriaMax);
    }

    //Il numero di zone con il più alto numero di collegamenti
    private static void info8(Zona[] zona,Server[] server) {
        Map<String,Integer>collPerZon = new HashMap<>();
        for (Zona z: zona){
            String zon = z.getId();
            int i = 0;
            for (Server s:server) {
                String zn = s.getZona().getId();
                if (zn.equals(zon)) {
                    i= i+s.getServerList().size();
                }
            }
            collPerZon.put(zon,i);
        }
        List<Map.Entry<String, Integer>> listaZoneCollegamenti = new ArrayList<>(collPerZon.entrySet());
        // Ordinamento della lista in base ai valori (numero di collegamenti) in ordine decrescente
        listaZoneCollegamenti.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int maxColl= listaZoneCollegamenti.get(0).getValue();
        //calcolo di numero di zone con il numero di collegamenti piu alto
        int numZone= 1;
        for (int i=1;i<listaZoneCollegamenti.size();i++){
            if (listaZoneCollegamenti.get(i).getValue().equals(maxColl))
                numZone++;
        }
        System.out.println(numZone);


    }

}
