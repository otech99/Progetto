package progetto.TASK;

import progetto.entita.Categoria;
import progetto.entita.Server;
import progetto.entita.Zona;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Task3_Alternativa {

        public static void task3(Server[] server, Zona[] zona, Scanner scan) {

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
                        s.setNumAttacchi(s.getNumAttacchi() + 1);
                        s.setAttDir(s.getAttDir()+1);
                        int serverListDim = s.getServerList().size(); //Preleva la dimensione della Server List
                        for (int j = 0; j < serverListDim; j++) {
                            for (Server e : server) { //Re-itero di nuovo per ogni server
                                if (e.getId().equals(s.getServerList().get(j).getId())) { // e se l' id del server è uguale all' id corrente della server list
                                    e.setNumAttacchi(e.getNumAttacchi() + 1);
                                    e.setAttIndir(e.getAttIndir()+1);
                                }
                            }
                        }
                    }
                }
            }
            condizione1(server, zona,numAttI);
            //condizione1(server, zona, numAttI);
            //condizione4(server, zona);

        }
        public static void condizione1(Server[] server, Zona[] zona, int[] numAttI){
            ArrayList<String> zoneAtt = new ArrayList<>();
            for (Zona z:zona){
                for (int i=0; i<server.length; i++){
                    if( (z.getId().equals(server[i].getZona().getId()) ) && ( server[i].getNumAttacchi()-numAttI[i])>=2) { //Verifico la condizione uno
                        if(zoneAtt.size()==0) {
                            zoneAtt.add(z.getId());
                        }else{
                            for(int j=0; j<zoneAtt.size(); j++) { //Itero per gli elementi dell' array list
                                if (!(z.getId().equals(zoneAtt.get(j)))) { //verifico che la zona da inserire è diversa dalle zone gia presenti
                                    zoneAtt.add(z.getId());
                                }
                            }
                        }
                    }
                }
            }
            //return zoneAtt.size() == zona.length; //Confrontiamo il numero di zone totali con il numero di zone
            // che hanno un server i cui attacchi sono aumentati di 2
        }

        private static void condizione2(Server[] server, Zona[] zona) {
            ArrayList<String> zoneAtt = new ArrayList<>();
            for (Zona z:zona){
                for (int i=0; i<server.length; i++){
                    if( (z.getId().equals(server[i].getZona().getId()) ) && (server[i].getAttDir()==0) && (server[i].getAttIndir()==0)) { //Verifico la condizione due
                        if(zoneAtt.size()==0) {
                            zoneAtt.add(z.getId());
                        }else{
                            for(int j=0; j<zoneAtt.size(); j++) {
                                if (!(z.getId().equals(zoneAtt.get(j)))) {
                                    zoneAtt.add(z.getId());
                                }
                            }
                        }
                    }
                }
            }
            //return zoneAtt.size() == zona.length; //Confrontiamo il numero di zone totali con il numero di zone
            // che hanno un server che non ha mai ricevuto attacchi diretti o indiretti

        }

    /*
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
    }
     */

        private static void condizione4(Server[] server, Zona[] zona) {
            int numZonAtt = 0;
            for (Zona z : zona) {
                System.out.println(z.getId());
                int attCat = 0;
                Map<Categoria,Integer>categAtt = new HashMap<>();
                for (Server s1 : server) {
                    if (z.getId().equals(s1.getZona().getId())) {
                        categAtt.put(s1.getCatg(), 0);
                    }
                }
                for (Server s: server) {
                    if (z.getId().equals(s.getZona().getId())) {
                        int atTot = s.getAttDir() + s.getAttIndir();
                        System.out.println(s.getId() + " attacchi totali " + atTot);
                        int atc = 0;
                        if (!(categAtt.get(s.getCatg()) == null)) {
                            atc = categAtt.get(s.getCatg());
                            if ((s.getAttDir() > 0) || (s.getAttIndir() > 0)) {
                                categAtt.put(s.getCatg(), atc + atTot);
                                System.out.println("grandezza mappa " + categAtt.size());
                                for (Map.Entry<Categoria, Integer> entry : categAtt.entrySet()) {
                                    System.out.println(": Key = " + entry.getKey() + ", Value = " + entry.getValue());
                                    if (entry.getValue() >= 1)
                                        attCat++;
                                    System.out.println("numero categorie attacate " + attCat);
                                    if (attCat == categAtt.size())
                                        numZonAtt++;
                                    System.out.println("numero zone atta " + numZonAtt);
                                }
                            }
                        }
                    }
                }
                }
            }
        }
