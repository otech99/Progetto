package progetto.TASK;

import progetto.entita.Categoria;
import progetto.entita.Server;
import progetto.entita.Zona;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

    public boolean task3(Server[] server, Zona[] zona, Scanner scan) {

        int numAttacchi = scan.nextInt();
        String[] attacchi = new String[numAttacchi];
        for (int i = 0; i < numAttacchi; i++) {
            attacchi[i] = scan.next();
        }
        for (Server s : server) {
            for (int i = 0; i < numAttacchi; i++)
                if (attacchi[i].equals(s.getId())) {
                    s.setNumAttacchi(s.getNumAttacchi() + 1);
                    s.setAttDir(s.getAttDir()+1);
                    for (int j = 0; j < s.getServerList().size(); j++)
                        for (Server e : server)
                            if (e.getId().equals(s.getServerList().get(j).getId())) {
                                e.setNumAttacchi(e.getNumAttacchi() + 1);
                                e.setAttIndir(e.getAttIndir()+1);
                            }
                }
        }
        return(condizione1(zona)&&condizione2(zona)&&condizione3(zona)&&condizione4(zona));
    }
    public boolean condizione1( Zona[] zona){
        int numAttacchiServerZona = 0;

        for (Zona z:zona)
            for (Server e : z.getServerZona()) {
                if ((e.getAttDir() + e.getAttIndir()) >= 2) {
                    numAttacchiServerZona++;
                    break;
                }
            }
        return numAttacchiServerZona == zona.length;
    }

    private boolean condizione2(Zona[] zona) {

        int numAttacchiServerZona = 0;
        for (Zona z : zona)
            for (Server e : z.getServerZona()) {
                if ((e.getAttDir() + e.getAttIndir()) == 0) {
                    numAttacchiServerZona++;
                    break;
                }
            }
        return numAttacchiServerZona == zona.length;
    }
    private boolean condizione3(Zona[] zona){

        int numAttacchiServerZona = 0;

        for (Zona z:zona)
            for (Server e : z.getServerZona()) {
                if ((e.getAttDir()) >= 2) {
                    numAttacchiServerZona++;
                    break;
                }
            }
        return numAttacchiServerZona == zona.length;
    }

    private boolean condizione4( Zona[] zona) {
        int numZonAtt = 0;
        for (Zona z : zona) {
            int attCat = 0;
            Map<Categoria, Integer> categAtt = new HashMap<>();
            //METTE LE CATEGORIE NELLA MAPPA
            for (Server s1 : z.getServerZona()) {
                categAtt.put(s1.getCatg(), 0);
            }
            //METTE GLI ATTACCHI PER OGNI CATEGORIA NELLA MAPPA
            for (Server s : z.getServerZona()) {
                int atTot = s.getAttDir() + s.getAttIndir();
                int atc = 0;
                if (!(categAtt.get(s.getCatg()) == null)) {
                    atc = categAtt.get(s.getCatg());
                    if ((s.getAttDir() > 0) || (s.getAttIndir() > 0)) {
                        categAtt.put(s.getCatg(), atc + atTot);
                        for (Map.Entry<Categoria, Integer> entry : categAtt.entrySet()) {
                            if (entry.getValue() >= 1)
                                attCat++;
                            if (attCat == categAtt.size())
                                numZonAtt++;
                        }
                    }
                }
            }
        }
        return numZonAtt==zona.length;
    }
}
