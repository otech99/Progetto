package progetto.TASK;

import progetto.entita.Server;
import progetto.entita.Servizio;
import progetto.entita.Zona;

import java.util.Scanner;

public class Task3 {
    public static void task3(Server[] server, Zona[] zona, Servizio[] servizio, Scanner scan) {
        int numAttacchi = scan.nextInt();
        String[] IdServerAtt = new String[numAttacchi];
        for (int i = 0; i < numAttacchi; i++) {
            IdServerAtt[i] = scan.next();
        }
        for (Server s : server) {
            for (int i = 0; i < numAttacchi; i++) {
                if (IdServerAtt[i].equals(s.getId())) {
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
        condizione2(server, zona);

    }

    private boolean condizione1(Server[] server, Zona[] zona, int[] numAttI) {
        int c=0;
        for (Zona z:zona){
            c=0;
            for (int i=0; i<server.length; i++){
                if( (z.getId().equals(server[i].getZona().getId()) ) && ( server[i].getNumAttacchi()-numAttI[i])>=2 ){
                    c++;
                }
            }
        }
        return c>=1;
    }

    public static boolean condizione2(Server[] server, Zona[] zona) {
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
    }


}
