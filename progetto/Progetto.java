package progetto;

import progetto.classi.Server;
import progetto.classi.Servizio;
import progetto.classi.Zona;

import java.util.ArrayList;
import java.util.Scanner;

public class Progetto {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        ArrayList<Servizio> servizi = new ArrayList<Servizio>();    //Array List di oggetti di tipo servizio
        ArrayList<Zona> zone = new ArrayList<Zona>();   //Array List di oggetti di tipo zona
        ArrayList<Server> server = new ArrayList<Server>();   //Array List di oggetti di tipo server

        int numServizi = scan.nextInt();
        int numZone = scan.nextInt();
        int numServer = scan.nextInt();

        for(int i = 0; i < numServizi; i++){    //itera per il numero di servizi immessi in input
            String nomeServizio = scan.next();
            int numPorte = scan.nextInt();
            int numVul = scan.nextInt();
            servizi.add(new Servizio(nomeServizio, numPorte, numVul));  //chiama il costruttore e carica l'Array List
        }
        for(int i = 0; i < numZone; i++){   //Itera per il numero di zone immessi in input
            String IdZone = scan.next();
            zone.add(new Zona(IdZone));
        }
        for(int i = 0; i < numServer; i++){   //Itera per il numero di server immessi in input
            String IdServer = scan.next();
            String IdZonaS = scan.next();
            int Uptime = scan.nextInt();
            int numPorte = scan.nextInt();
            int numAtt = scan.nextInt();
            int TempR = scan.nextInt();
            //trovare un modo per aggiungere lista comunicazione
            // e aggiungere lista servizi

            server.add(new Server(IdServer, IdZonaS, Uptime, numPorte, numAtt, TempR));
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
