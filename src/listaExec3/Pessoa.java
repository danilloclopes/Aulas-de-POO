package listaExec3;

public class Pessoa {
    String nome;
    int idade;
    Pessoa pai;
    Pessoa mae;

    // Listas para armazenar os filhos e irmãos
    // Se a pessoa não tiver filhos ou irmãos, o valor será null
    // O numero máximo de filhos e irmãos por pessoa é indeterminado

    Pessoa[] filhos;
    Pessoa[] irmaos;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        pai = null;
        mae = null;
        filhos = null;
        irmaos = null;
    }

    public Pessoa(String nome, int idade, Pessoa pai, Pessoa mae, Pessoa[] filhos, Pessoa[] irmaos) {
        this.nome = nome;
        this.idade = idade;
        this.pai = pai;
        this.mae = mae;
        this.filhos = filhos;
        this.irmaos = irmaos;
    }

    public void avos() {

        if (this.mae.mae != null){
            System.out.println("Avó materna: " + this.mae.mae.nome);
        }
        if (this.mae.pai != null){
            System.out.println("Avô materno: " + this.mae.pai.nome);
        }
        if (this.pai.mae != null){
            System.out.println("Avó paterna: " + this.pai.mae.nome);
        }
        if (this.pai.pai != null){
            System.out.println("Avô paterno: " + this.pai.pai.nome);
        }

    }

    public boolean tios() {

        boolean irmaosMae = false;
        boolean irmaosPai = false;

        if (this.mae.irmaos != null) irmaosMae = true;
        if (this.pai.irmaos != null) irmaosPai = true;

        return irmaosMae||irmaosPai ;

    }

    public boolean primos() {

        boolean sobrinhosMae = false;
        boolean sobrinhosPai = false;

        if (this.tios()) {
            
            for (Pessoa p : this.mae.irmaos){
                if (p.filhos != null) sobrinhosMae = true;
            }
            
            for (Pessoa p : this.pai.irmaos){
                if (p.filhos != null) sobrinhosPai = true;
            }

        }

        return sobrinhosMae||sobrinhosPai;
        
    }
}
