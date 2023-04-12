package progetto.TASK;

import progetto.entita.Server;
import progetto.entita.Zona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

    Scanner scan = new Scanner(System.in);
        int numAtt = scan.nextInt();
        String[] attacchi= new String[numAtt];

        public  boolean condizione1(Zona[]  zona, Server[] server,int numAtt,String[] attacchi) {
            Map<String, Integer> serverAttaccati = new HashMap<>();
            //Mette i server in una Mappa
            for (Server s : server) {
                serverAttaccati.put(s.getId(), 0);
            }

            int attachiPerZona=0;
            for (Zona z : zona) {
                int attacchiPerServer =0;
                for (Server s : server) {
                    if (z.getId().equals(s.getZona().getId())) {
                        ArrayList<Server> serv = new ArrayList<>(s.getServerList());
                        //agginge il numero degli attacchi diretti che riceve ogni server
                        for (int i = 0; i < numAtt; i++) {
                            if (s.getId().equals(attacchi[i])) {
                                serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                            }//agginge il numero degli attacchi indiretti che riceve ogni server
                            for (int a = 0; a < numAtt; a++) {
                                if (serv.contains(attacchi[i]))
                                    serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                            }
                        }
                        if (serverAttaccati.get(s.getId())>=2)
                            attacchiPerServer++;
                    }
                }
                if (attacchiPerServer>=1)
                    attachiPerZona++;
            }
            return attachiPerZona == zona.length;
        }
    public  boolean condizione2(Zona[]  zona, Server[] server,int numAtt,String[] attacchi) {
        Map<String, Integer> serverAttaccati = new HashMap<>();
        //Mette i server in una Mappa
        for (Server s : server) {
            serverAttaccati.put(s.getId(), 0);
        }

        int attachiPerZona=0;
        for (Zona z : zona) {
            int attacchiPerServer =0;
            for (Server s : server) {
                if (z.getId().equals(s.getZona().getId())) {
                    ArrayList<Server> serv = new ArrayList<>(s.getServerList());
                    //agginge il numero degli attacchi diretti che riceve ogni server
                    for (int i = 0; i < numAtt; i++) {
                        if (s.getId().equals(attacchi[i])) {
                            serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }//agginge il numero degli attacchi indiretti che riceve ogni server
                        for (int a = 0; a < numAtt; a++) {
                            if (serv.contains(attacchi[i]))
                                serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }
                    }
                    //incrementa se trova un server che non ha ricevuto un attaco diretto e indiretto
                    if (serverAttaccati.get(s.getId())>=0)
                        attacchiPerServer++;
                }
            }
            if (attacchiPerServer>=1)
                attachiPerZona++;
        }
        return attachiPerZona == zona.length;
    }
    public boolean condizione3(Zona[]  zona, Server[] server,int numAtt,String[] attacchi){
        Map<String, Integer> serverAttaccati = new HashMap<>();
        //Mette i server in una Mappa
        for (Server s : server) {
            serverAttaccati.put(s.getId(), 0);
        }

        int attachiPerZona=0;
        for (Zona z : zona) {
            int attacchiPerServer =0;
            for (Server s : server) {
                if (z.getId().equals(s.getZona().getId())) {
                    ArrayList<Server> serv = new ArrayList<>(s.getServerList());
                    //agginge il numero degli attacchi diretti che riceve ogni server
                    for (int i = 0; i < numAtt; i++) {
                        if (s.getId().equals(attacchi[i])) {
                            serverAttaccati.put(s.getId(), serverAttaccati.get(s.getId() + 1));
                        }
                    }
                    if (serverAttaccati.get(s.getId())>=2)
                        attacchiPerServer++;
                }
            }
            if (attacchiPerServer>=1)
                attachiPerZona++;
        }
        return attachiPerZona == zona.length;

    }

        /*for (int i = 0; i < numAtt; i++) {
            attacchi[i] = scan.nextInt();
        }*/



    }
    /*public static void task3(Server[] server, Zona[] zona, Servizio[] servizio, Scanner scan) {
        int numAttI[] = new int[server.length];  //numero di attachi iniziali
        for (int i = 0; i < server.length; i++) { //Per ogni server viene preso il numero di attachi e salvato vettore
            numAttI[i] = server[i].getNumAttacchi();  // chiamato numAttI che salva quindi lo stato iniziale degli attacchi
        }
        int numAttacchi = scan.nextInt();
        String[] attacchi = new String[numAttacchi];
        for (int i = 0; i < numAttacchi; i++) {
            attacchi[i] = scan.next();
        }

        for (Server s : server) {
            for (int i = 0; i < numAttacchi; i++) {
                if (attacchi[i].equals(s.getId())) {
                    //System.out.println(s.getId() + " " + s.getNumAttacchi());
                    s.setNumAttacchi(s.getNumAttacchi() + 1);
                    s.setAttDir(s.getAttDir()+1);
                    //System.out.println(s.getId() + " " + s.getNumAttacchi());
                    int serverListDim = s.getServerList().size(); //Preleva la dimensione della Server List
                    for (int j = 0; j < serverListDim; j++) {
                        for (Server e : server) { //Re-itero di nuovo per ogni server
                            if (e.getId().equals(s.getServerList().get(j).getId())) { // e se l' id del server è uguale all' id corrente della server list
                                //System.out.println(e.getId()+"    "+ e.getNumAttacchi());
                                e.setNumAttacchi(e.getNumAttacchi() + 1);
                                e.setAttIndir(e.getAttIndir()+1);
                                //System.out.println(e.getId()+"    "+ e.getNumAttacchi());
                            }
                        }
                    }
                }
            }
        }
        //return(condizione1(server, zona)&&condizione2(server, zona));
        //condizione1(server, zona, numAttI);
        //condizione2(server, zona);

    }
    public static void condizione1(Server[] server, Zona[] zona, int[] numAttI) {
        int c=0;
        for (Zona z:zona){
            c=0;
            for (int i=0; i<server.length; i++){
                if( (z.getId().equals(server[i].getZona().getId()) ) && ( server[i].getNumAttacchi()-numAttI[i])>=2 ){
                    c++;
                    System.out.println(server[i].getId()+c);
                }
            }
        }
        //return c>=1;
    }

    private boolean condizione2(Server[] server, Zona[] zona) {
        int c=0;
        for (Zona z:zona){
            c=0;
            for (Server s:server){
                if(z.getId().equals(s.getZona().getId()) && s.getAttDir() == 0 && s.getAttIndir() == 0){
                    c++;
                }
            }
        }
        return c>=1;
    }
    private boolean condizione3(Server[] server, Zona[] zona) {
        int c=0;
        for (Zona z:zona){
            c=0;
            for (Server s:server){
                if(z.getId().equals(s.getZona().getId()) && s.getAttDir() >= 2){
                    c++;
                }
            }
        }
        return c>=1;
    }*/