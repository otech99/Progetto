package progetto.classi;

import java.util.ArrayList;

public class Servizio {
    private String nome; //nome del un servizio
    private int Nporte; //numero di porte
    private int Nvul; //numero di vulnerabilità
    private ArrayList<Servizio> ServiziList = new ArrayList<>();

    public Servizio(String nome, int Nporte, int Nvul){
        this.nome= nome;
        this.Nporte= Nporte;
        this.Nvul=Nvul;
    }

    public String getNome(){
        return this.nome;
    }
    public int getPorte(){
        return this.Nporte;
    }
    public int getVul(){
        return this.Nvul;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNporte(int nporte) {
        Nporte = nporte;
    }

    public void setNvul(int nvul) {
        Nvul = nvul;
    }
    public void setServiziList(Servizio servizi){
        ServiziList.add(servizi);
    }
    public void getServiziList(){
        for(Servizio e : ServiziList)
            System.out.println(e.getNome());
    }
}
