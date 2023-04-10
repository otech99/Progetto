package progetto.TASK;

import progetto.classi.Server;
import progetto.classi.Servizio;
import progetto.classi.Zona;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Task2 {
    private int p;
    private int q;

    public void task2(Server[] server, Zona[] zona, Servizio[] servizio, Scanner scan){
        p = scan.nextInt();
        q= scan.nextInt();

        if(condizione1(server)&&condizione2(zona,server)&&condizione3(server)&&condizione4(zona, servizio, server))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    private boolean condizione1(Server[] server) {
        int a = 0;
        for (Server s : server) {
            if (q == s.getServiziList().size())
                a++;
        }
        return a == p;
    }

    private boolean condizione2(Zona[] zona, Server[] server) {
        int a = 0;
        int b = 0;
        for (Zona z : zona) {
            for (Server s : server) {
                if ((z.getId().equals(s.getZona().getId())) && (s.getNumAttacchi() == 100))
                    a++;
            }
            if (a == p)
                b++;
        }
        return b == q;
    }
    private boolean condizione3(Server[] server) {
        int a = 10;
        int b= 25;
        int c= 0;
        for (Server s1: server){
            for (Server s2 : server){
                if(!(s1.getId().equals(s2.getId())))
                    if (s1.getZona().getId().equals(s2.getZona().getId())){
                //copia i servizi in due liste
                ArrayList<Servizio>lista1 = new ArrayList<>(s1.getServiziList());
                ArrayList<Servizio>lista2 = new ArrayList<>(s2.getServiziList());
                if (lista1.size()==lista2.size()) {
                    //ordina le liste in ordine alfabetico
                    lista1.sort(Comparator.comparing(Servizio::getNome));
                    lista2.sort(Comparator.comparing(Servizio::getNome));
                    //confronta i servizi in base al nome
                    for (int i = 0; i < lista1.size(); i++) {
                        Servizio servizio1 = lista1.get(i);
                        Servizio servizio2 = lista2.get(i);
                        if (servizio1.getNome().equals(servizio2.getNome()))
                            if ((servizio1.getVul() > a) && (servizio1.getVul() < b))
                                c++;
                    }
                }
                }
            }
        }
        //al massimo un altro server
        return c <= 2; //perche due server saranno paragonati due volte
    }
    private boolean condizione4(Zona[] zona,Servizio[] servizio,Server[] server){
        int b=0;
        for (Zona z: zona){
            System.out.println(z.getId());
            int a =0;
            for (Server s1: server){
                System.out.println(s1.getId());
                if (z.getId().equals(s1.getZona().getId())){
                    ArrayList<Servizio> servz = new ArrayList<>(s1.getServiziList());
                    ArrayList<String> servizi= new ArrayList<>();
                    for (Servizio sz: servizio){
                        servizi.add(sz.getNome());
                    }
                    Collections.sort(servizi);
                    for (Server s2: server){
                        if (!s1.getId().equals(s2.getId()))
                            if (s1.getZona().equals(s2.getZona()))
                                servz.addAll(s2.getServiziList());
                    }
                    System.out.println(servz);
                    servz.sort(Comparator.comparing(Servizio::getNome));

                    if (servz.size()==servizi.size()) {
                        for (int i = 0; i < servz.size(); i++) {
                            if(servz.get(i).getNome().equals(servizi.get(i))){
                                a++;
                            }
                            if(a==servz.size())
                                b++;
                        }
                    }
                }
            }
        }
        return b>=1;
    }
}