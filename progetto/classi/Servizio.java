package progetto.classi;

public class Servizio {
    private String nome; //nome del un servizio
    private int Nporte; //numero di porte
    private int Nvul; //numero di vulnerabilitàll

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

}
