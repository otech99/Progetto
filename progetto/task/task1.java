package progetto.TASK;


import progetto.classi.Categoria;
import progetto.classi.Server;
import progetto.classi.Zona;

import java.util.HashMap;
import java.util.Map;

public class task1 {
    public static void numTotale(){
        System.out.print(Server.getNumServerTotali()+" ");
        System.out.println(Zona.getNumZoneTotali());
    }
    public static void servPerCat(Server[] server){
        Map<Categoria, Integer> numPerCategoria = new HashMap<>();
        numPerCategoria.put(Categoria.honeypot, 0);
        numPerCategoria.put(Categoria.singlepot, 0);
        numPerCategoria.put(Categoria.zombie, 0);
            for (Server s: server) {
                Categoria categoria = s.getCatg();
                numPerCategoria.putIfAbsent(categoria, 0);
            numPerCategoria.put(categoria,numPerCategoria.get(categoria)+1);
            }
        System.out.println("honeypot, Numero di server: " + numPerCategoria.get(Categoria.honeypot));
        System.out.println("singlepot, Numero di server: " + numPerCategoria.get(Categoria.singlepot));
        System.out.println("zombie, Numero di server: " + numPerCategoria.get(Categoria.zombie));

    }
    public Categoria categoriaConPiùServer(Map<Categoria, Integer> numPerCategoria) {
        Categoria categoriaConPiùServer = null;
        int maxNumeroServer = -1;

        for (Map.Entry<Categoria, Integer> entry : numPerCategoria.entrySet()) {
            Categoria categoria = entry.getKey();
            int numeroServer = entry.getValue();

            if (numeroServer > maxNumeroServer ||
                    (numeroServer == maxNumeroServer &&
                            categoria.ordinal() < categoriaConPiùServer.ordinal())) {
                categoriaConPiùServer = categoria;
                maxNumeroServer = numeroServer;
            }
        }

        return categoriaConPiùServer;
    }
}
