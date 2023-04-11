package progetto.entita;

public class Servizio {
    private final String nome; //nome del un servizio
    private final int Nporte; //numero di porte
    private final int Nvul; //numero di vulnerabilità

    public Servizio(String nome, int Nporte, int Nvul){
        this.nome= nome;
        this.Nporte= Nporte;
        this.Nvul=Nvul;
    }

    public String getNome(){
        return this.nome;
    }
    public int getVul(){
        return this.Nvul;
    }

    @Override
    public String toString() {
        return "Servizio{" +
                "nome='" + nome + '\'' +
                ", Nporte=" + Nporte +
                ", Nvul=" + Nvul +
                ", ServiziList=" +
                '}';
    }
}
