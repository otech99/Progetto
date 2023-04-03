package progetto;

import progetto.classi.Server;
import progetto.classi.Servizio;
import progetto.classi.Zona;
import java.util.*;

public class Progetto {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        int numServizi = scan.nextInt();
        int numZone = scan.nextInt();
        int numServer = scan.nextInt();

        Servizio[] servizi = new Servizio[numServizi];
        Zona[] zone = new Zona[numZone];
        Server[] server = new Server[numServer];

        String[] ServerList = new String[numServer];
        String[] ServerServizi = new String[numServizi];



        for(int i = 0; i < numServizi; i++){    //itera per il numero di servizi immessi in input
            String nomeServizio = scan.next();
            int numPorte = scan.nextInt();
            int numVul = scan.nextInt();
            servizi[i] = new Servizio(nomeServizio, numPorte, numVul);//chiama il costruttore e carica l'Array List
        }
        for(int i = 0; i < numZone; i++){   //Itera per il numero di zone immessi in input
            String IdZone = scan.next();
            zone[i] = new Zona(IdZone);
        }
        for(int i = 0; i < numServer; i++){   //Itera per il numero di server immessi in input
            String idServer;
            String  idZonaS;
            int uptime;
            int numPorte;
            int numAtt;
            int tempR;

            idServer = scan.next();
            idZonaS = scan.next();
            uptime = scan.nextInt();
            numPorte = scan.nextInt();
            numAtt = scan.nextInt();
            tempR = scan.nextInt();
            ServerList[i] = scan.next();
            ServerServizi[i] = scan.next();

            server[i] = new Server(idServer, uptime, numPorte, numAtt, tempR);


            //int numServerCollegati=0; //incremente ogni volta che viene aggiunto un server collegato

            /*
            while (true) {  //aggiungere i server collegati ffinche nn ci sta una virgola e contare il numero dei server collegati
                String serv=scan.next();
                if (serv.contains(","))
                numServerCollegati++;
                else
                    break;
                if (numServerCollegati==0)
                    System.out.println('-');


            }
            int numServ =0;
            while (true) {
                String serv=scan.next();
                if (serv.contains(","))
                    numServ++;
                else
                    break;
                if (numServ==0)
                    System.out.println('-');


            }
             */
            //String serverList = scan.next();
            //String serviceList = scan.next();

            //PROMEMORIA
            //trovare un modo per aggiungere lista comunicazione server e collegarla alla zona
            // e aggiungere lista servizi e collegarla ai server


            //server.add(new Server(idServer,new Zona(idZonaS), uptime, numPorte, numAtt, tempR, new Server(ListServer)));
        }

        //collega server
        for(int i = 0; i < ServerList.length; i++){
            String[] serverColl = ServerList[i].split(",");
            for(int j = 0; j < serverColl.length; j++)
                for(Server e : server)
                    if(e.getId() == serverColl[i])

        }


        /*
        for(Servizio e : servizi) {
            System.out.print(e.getNome()+" ");
            System.out.print(e.getPorte()+" ");
            System.out.print(e.getVul()+"\n");
        }

        for(Zona e : zone) {
            System.out.print(e.getZona()+"\n");
        }
        */

    }
}
