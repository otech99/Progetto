package progetto.TASK;

import progetto.entita.Server;
import progetto.entita.Zona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {
    public boolean task3(Server[] server, Zona[] zona, Scanner scan) {

        int numAtt = scan.nextInt();
        String[] attacchi = new String[numAtt];
        for (int i = 0; i < numAtt; i++) {
            attacchi[i] = scan.next();
        }
        return (condizione1(zona, server, numAtt, attacchi) && condizione2(zona, server, numAtt, attacchi) && condizione3(zona, server, numAtt, attacchi));
    }

    public boolean condizione1(Zona[] zona, Server[] server, int numAtt, String[] attacchi) {
        Map<String, Integer> serverAttaccati = new HashMap<>();
        //Mette i server in una Mappa
        for (Server s : server) {
            serverAttaccati.put(s.getId(), 0);
        }

        int attachiPerZona = 0;
        for (Zona z : zona) {
            int attacchiPerServer = 0;
            for (Server s : server) {
                if (z.getId().equals(s.getZona().getId())) {
                    ArrayList<Server> serv = new ArrayList<>(s.getServerList());
                    //agginge il numero degli attacchi diretti che riceve ogni server
                    for (int i = 0; i < numAtt; i++) {
                        if (s.getId().equals(attacchi[i])) {
                            serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }//agginge il numero degli attacchi indiretti che riceve ogni server
                        for (int a = 0; a < numAtt; a++) {
                            if (serv.contains(attacchi[a]))
                                serverAttaccati.put(attacchi[a], serverAttaccati.get(attacchi[a] + 1));
                        }
                    }
                    if (serverAttaccati.get(s.getId()) >= 2)
                        attacchiPerServer++;
                }
            }
            if (attacchiPerServer >= 1)
                attachiPerZona++;
        }
        return attachiPerZona == zona.length;
    }

    public boolean condizione2(Zona[] zona, Server[] server, int numAtt, String[] attacchi) {
        Map<String, Integer> serverAttaccati = new HashMap<>();
        //Mette i server in una Mappa
        for (Server s : server) {
            serverAttaccati.put(s.getId(), 0);
        }

        int attachiPerZona = 0;
        for (Zona z : zona) {
            int attacchiPerServer = 0;
            for (Server s : server) {
                if (z.getId().equals(s.getZona().getId())) {
                    ArrayList<Server> serv = new ArrayList<>(s.getServerList());
                    //agginge il numero degli attacchi diretti che riceve ogni server
                    for (int i = 0; i < numAtt; i++) {
                        if (s.getId().equals(attacchi[i])) {
                            serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }//agginge il numero degli attacchi indiretti che riceve ogni server
                        for (int a = 0; a < numAtt; a++) {
                            if (serv.contains(attacchi[a]))
                                serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }
                    }
                    //incrementa se trova un server che non ha ricevuto un attaco diretto e indiretto
                    if (serverAttaccati.get(s.getId()) >= 0)
                        attacchiPerServer++;
                }
            }
            if (attacchiPerServer >= 1)
                attachiPerZona++;
        }
        return attachiPerZona == zona.length;
    }

    public boolean condizione3(Zona[] zona, Server[] server, int numAtt, String[] attacchi) {
        Map<String, Integer> serverAttaccati = new HashMap<>();
        //Mette i server in una Mappa
        for (Server s : server) {
            serverAttaccati.put(s.getId(), 0);
        }

        int attachiPerZona = 0;
        for (Zona z : zona) {
            int attacchiPerServer = 0;
            for (Server s : server) {
                if (z.getId().equals(s.getZona().getId())) {
                    //agginge il numero degli attacchi diretti che riceve ogni server
                    for (int i = 0; i < numAtt; i++) {
                        if (s.getId().equals(attacchi[i])) {
                            serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }
                    }
                    if (serverAttaccati.get(s.getId()) >= 2)
                        attacchiPerServer++;
                }
            }
            if (attacchiPerServer >= 1)
                attachiPerZona++;
        }
        return attachiPerZona == zona.length;

    }
}