package progetto.TASK;

import progetto.entita.Server;

import java.util.Scanner;

public class Task3 {

    public static void input(Server[] server){
        Scanner scan = new Scanner(System.in);
        int numAttacchi = scan.nextInt();
        String[] IdServerAtt = new String[numAttacchi];
        for(int i=0; i<numAttacchi; i++){
            IdServerAtt[i] = scan.next();
        }
        for(Server s: server){
            for(int i=0; i<numAttacchi; i++){
                if(s.getId().equals(IdServerAtt[i])){
                    s.setNumAttacchi(s.getNumAttacchi()+1); //
                    int serverListDim = s.getServerList().size(); //Preleva la dimensione della Server List
                    for (int j=0; j<serverListDim; j++) {
                        for (Server e : server) { //Re-itero di nuovo per ogni server
                            if(e.getId().equals(s.getServerList().get(j).getId())) { // e se l' id del server è uguale all' id corrente della server list
                                e.setNumAttacchi(e.getNumAttacchi()+1);
                                System.out.println();
                            }
                        }
                    }
                    }
                }
            }
        }
}
