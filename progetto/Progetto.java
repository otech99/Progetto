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
            for (String s : serverList) // l ha consigliato intellij
                for (Server e : server)
                    if (e.getId().equals(s))
                        server[i].setServerList(e);
            /* for(int j = 0; j < serverList.length; j++)
                for(Server e : server)
                    if(e.getId().equals(serverList[j]))
                        server[i].setServerList(e);*/
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
    public static Zona cercaZonaServer(Zona[] zone, String idZona){
        for(Zona e : zone)
            if (e.getId().equals(idZona))
                return e;
        return null;
    }
    public static void assegnaCategoria(Server[] server,String [] ServerList ,Zona[] zona){
        for (Server s:server)
            for (Zona z : zona) {
                int MaxColg=0;
                if (z.getId().equals(s.getZona()))
                    if (z.getServPerZona() == ServerList.length + 1)
                        MaxColg = ServerList.length;

                String categ = new String();
                if (ServerList.length > 5 && ServerList.length < MaxColg)
                    categ = "zombie";
                if (ServerList.length == MaxColg)
                    categ = "honeypot";
                if (ServerList.length == 0)
                   categ = "singlepot";
                Categoria categoria;
                switch (categ) {
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

    }

    public static void ServerPerZona(Zona[] zona,Server[] server){
        for (Zona a :zona){
            int servPerZon =0;
            for (Server e:server) {
                if(a.getId().equals(e.getZona()))
                    servPerZon++;
            }
            a.setServPerZona(servPerZon);
            System.out.println(a.getServPerZona());
        }
    }

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

            Zona zonaServer = cercaZonaServer(zone,idZonaS);

            server[i] = new Server(idServer, zonaServer, uptime, numPorte, numAtt, tempR);

            }

            //collega server
            aggiungiServerCollegati(server, ServerList);
            //collega servizi
            aggiungiServiziCollegati(server, servizi, ServiziList);



        for(Zona e : zone) {
            System.out.print(e.getZona()+"\n");
        }

        for(Server e : server)
            e.getServerList();
            for (Server a : server)
                a.getServiziList();
        ServerPerZona(zone,server);
    }
}
