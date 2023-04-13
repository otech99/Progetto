package progetto;

import progetto.TASK.Task1;
import progetto.TASK.Task2;
import progetto.TASK.Task3;
import progetto.entita.Categoria;
import progetto.entita.Server;
import progetto.entita.Servizio;
import progetto.entita.Zona;

import java.util.ArrayList;
import java.util.Scanner;


public class Progetto {


    //collega server
    public static void aggiungiServerCollegati(Server[] server, String[] ServerList) {
        for (int i = 0; i < server.length; i++) {
            String[] serverList = ServerList[i].split(",");
            for (String s : serverList)
                for (Server e : server)
                    if (e.getId().equals(s))
                        server[i].setServerList(e);
        }
    }

    //collega servizi
    public static void aggiungiServiziCollegati(Server[] server, Servizio[] servizi, String[] ServiziList) {
        for (int i = 0; i < server.length; i++) {
            String[] serviziList = ServiziList[i].split(",");
            for (String s : serviziList)
                for (Servizio e : servizi)
                    if (e.getNome().equals(s))
                        server[i].setServiziList(e);
        }
    }

    //Assegna zona
    public static Zona cercaZonaServer(Zona[] zone, String idZona) {
        for (Zona zona : zone)
            if (zona.getId().equals(idZona))
                return zona;
        return null;
    }

    //assegna categoria server
    public static void assegnaCategoria(Server[] server) {
        for (Server s : server) {
            ArrayList<Server> serverColl = new ArrayList<>(s.getServerList());
            int numServerColl = serverColl.size();
            int numServerZona = s.getZona().getServerZona().size();
            if (numServerColl == 0)
                s.setCatg(Categoria.singleton);
            else if ((numServerColl + 1) == numServerZona)
                s.setCatg(Categoria.honeypot);
            else if (numServerColl >= 5)
                s.setCatg(Categoria.zombie);
        }
    }

    //Creazione oggetti di tipo Servizio
    public static void creaServizi(Servizio[] servizi, Scanner scan, int numServizi) {
        for (int i = 0; i < numServizi; i++) {
            String nomeServizio = scan.next();
            int numPorte = scan.nextInt();
            int numVul = scan.nextInt();
            servizi[i] = new Servizio(nomeServizio, numPorte, numVul);
        }

    }

    //Creazione oggetti di tipo Zona
    public static void creaZone(Zona[] zone, Scanner scan, int numZone) {
        for (int i = 0; i < numZone; i++) {
            String IdZone = scan.next();
            zone[i] = new Zona(IdZone);
        }
    }

    //Creazione oggetti di tipo Server
    public static void creaServer(Server[] server, Zona[] zone, String[] ServerList, String[] ServiziList, Scanner scan, int numServer) {
        for (int i = 0; i < numServer; i++) {
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

            Zona zonaServer = cercaZonaServer(zone, idZonaS);
            server[i] = new Server(idServer, zonaServer, uptime, numPorte, numAtt, tempR);

            if (zonaServer != null)
                zonaServer.setServerZona(server[i]);

        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numServizi = scan.nextInt();
        int numZone = scan.nextInt();
        int numServer = scan.nextInt();
        Servizio[] servizi = new Servizio[numServizi];
        Zona[] zone = new Zona[numZone];
        Server[] server = new Server[numServer];

        String[] ServerList = new String[numServer];
        String[] ServiziList = new String[numServer];


        //Creazione oggetti di tipo Servizio
        creaServizi(servizi, scan, numServizi);
        //Creazione oggetti di tipo Zona
        creaZone(zone, scan, numZone);
        //Creazione oggetti di tipo Server
        creaServer(server, zone, ServerList, ServiziList, scan, numServer);
        //collega server
        aggiungiServerCollegati(server, ServerList);
        //collega servizi
        aggiungiServiziCollegati(server, servizi, ServiziList);
        //assegna categoria server
        assegnaCategoria(server);

        switch (scan.next()) {
            case "TASK1" -> {
                Task1 task1 = new Task1();
                task1.task1(server,zone);
            }
            case "TASK2" -> {
                Task2 task2 = new Task2();
                if (task2.task2(server, zone, servizi, scan))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            case "TASK3" -> {
                Task3 task3 = new Task3();
                if(task3.task3(server, zone,scan))
                    System.out.println("VALID");
                else
                    System.out.println("NOT VALID");
            }
        }
        scan.close();
    }
}


