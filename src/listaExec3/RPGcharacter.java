package listaExec3;

public class RPGcharacter {
    private String nome;
    private String classe;

    // Sequencia de pontos: inteligencia, forca fisica, defesa fisica, ataque magico, defesa magica, agilidade e carisma
    private int[] pontos;

    private double hp;

    public RPGcharacter(String nome, String classe, int[] pontos) {
        this.nome = nome;
        this.classe = classe;

        // Atribui o valor de hp de acordo com a classe
        // Se a classe não for uma das opções, atribui 0.0 e imprime "Classe inválida"
        
        switch (classe) {
            case "mago":
                hp = 370.0;
                break;            
            case "ladino,":
                hp = 280.0;
                break;
            case "espadachim":
                hp = 310.0;
                break;
            case "tanque":
                hp = 400.0;
                break;
            default:
                System.out.println("Classe inválida");
                hp = 0.0;
                break;
        }

        // Verifica se a soma dos pontos é igual a 300
        // Se a soma for diferente de 300 imprime "erro"

        int cont = 0;
        for (int pts : pontos){
            cont += pts;
        }

        if (cont != 300){
            System.out.println("erro");
        } else {
            this.pontos = pontos;
        }
    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int[] getPontos() {
        return pontos;
    }

    public void setPontos(int[] pontos) {
        this.pontos = pontos;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    // Método para calcular o dano recebido
    // Se o ataque físico for maior que a defesa física, o dano físico é igual ao ataque físico menos a defesa física dividido por 5
    // Se o ataque mágico for maior que a defesa mágica, o dano mágico é igual ao ataque mágico menos a defesa mágica dividido por 3
    // O dano total é a soma do dano físico e do dano mágico

    public int calcularDano(int ataqueFisico, int ataqueMagico) {
        
        int danoFisico = 0;
        if (ataqueFisico > this.pontos[2]) {
            danoFisico = (ataqueFisico - this.pontos[2]) / 5;
        }
        
        int danoMagico = 0;
        if (ataqueMagico > this.pontos[4]) {
            danoMagico = (ataqueMagico - this.pontos[4]) / 3;
        }
        
        int danoTotal = danoFisico + danoMagico;
        
        this.hp = Math.max(0, this.hp - danoTotal);
        
        return danoTotal;
    }

}
