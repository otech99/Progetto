package progetto;

import progetto.classi.Categoria;
import progetto.classi.Server;
import progetto.classi.Servizio;
import progetto.classi.Zona;

import java.util.Scanner;

public class Progetto {

    public static void aggiungiServerCollegati(Server[] server, String[] ServerList){
        for(int i = 0; i < server.length; i++){
            String[] serverList = ServerList[i].split(",");
            for(int j = 0; j < serverList.length; j++)
                for(Server e : server)
                    if(e.getId().equals(serverList[j]))
                        server[i].setServerList(e);
        }
    }
    public static void aggiungiServiziCollegati(Server[] server, Servizio[] servizi, String[] ServiziList){
        for(int i = 0; i < server.length; i++){
            String[] serviziList = ServiziList[i].split(",");
            for(int j = 0; j < serviziList.length; j++)
                for(Servizio e : servizi)
                    if(e.getNome().equals(serviziList[j]))
                        server[i].setServiziList(e);
        }
    }
    public static Zona cercaZonaServer(Zona[] zone, int i, String idZona){
        for(Zona e : zone)
            if (e.getId().equals(idZona))
                return e;
        return null;
    }

    /*public static ServerPerZona(){
        for(Server e : server)
            for (Zona a: zone)
                if(a.getZona().equals(a.getServerList()))


    }*/

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);

        int numServizi = scan.nextInt();
        int numZone = scan.nextInt();
        int numServer = scan.nextInt();

        Servizio[] servizi = new Servizio[numServizi];
        Zona[] zone = new Zona[numZone];
        Server[] server = new Server[numServer];

        String[] ServerList = new String[numServer];
        String[] ServiziList = new String[numServer];


        for (int i = 0; i < numServizi; i++) {    //itera per il numero di servizi immessi in input
            String nomeServizio = scan.next();
            int numPorte = scan.nextInt();
            int numVul = scan.nextInt();
            servizi[i] = new Servizio(nomeServizio, numPorte, numVul);//chiama il costruttore e carica l'Array List
        }
        for (int i = 0; i < numZone; i++) {   //Itera per il numero di zone immessi in input
            String IdZone = scan.next();
            zone[i] = new Zona(IdZone);
        }
        for (int i = 0; i < numServer; i++) {   //Itera per il numero di server immessi in input
            String idServer;
            String idZonaS;
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
            ServiziList[i] = scan.next();

            Zona zonaServer = cercaZonaServer(zone, i, idZonaS);

            server[i] = new Server(idServer, zonaServer, uptime, numPorte, numAtt, tempR);

            }

            //collega server
            aggiungiServerCollegati(server, ServerList);
            //collega servizi
            aggiungiServiziCollegati(server, servizi, ServiziList);

            String categ;
            for(int i=0; i<numServer; i++){
                if (ServerList.length > 5 && ServerList.length < numServer)
                    categ = "zombie";
                //se il server è in comunicazione con tutti i server della sua zona
                for(Server e : server) {
                    //if (server[i])
                        categ = "honeypot";
                }

                if (ServerList.length == 0) ;
                categ = "singlepot";
                Categoria categoria;
                switch (categ){
                    case "zombie":
                        categoria = Categoria.zombie;
                        break;
                    case "honeypot":
                        categoria = Categoria.honeypot;
                        break;
                    case "singlepot":
                        categoria = Categoria.singlepot;
                        break;
            }


        }


        /*for(Servizio e : servizi) {
            System.out.print(e.getNome()+" ");
            System.out.print(e.getPorte()+" ");
            System.out.print(e.getVul()+"\n");
        }

        for(Zona e : zone) {
            System.out.print(e.getZona()+"\n");
        }
        */
        for(Server e : server)
            e.getServerList();
            for (Server a : server)
                a.getServiziList();
    }
}
