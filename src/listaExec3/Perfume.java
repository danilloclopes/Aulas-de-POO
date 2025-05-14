package listaExec3;

public class Perfume {
    private String nome;
    private String marca;
    private String familiaOlfativa;
    private String[] cabeca;
    private String[] corpo;
    private String[] coracao;

    public Perfume(String nome, String marca, String familiaOlfativa, String[] cabeca, String[] corpo, String[] coracao) {
        
        this.nome = nome;
        this.marca = marca;
        this.familiaOlfativa = familiaOlfativa;

        // Verifica se as notas de cabeça, corpo e coração não possuem elementos em comum
        // Se não houver elementos em comum, atribui os valores
        // Se houver elementos em comum, atribui null

        if (verificacao(corpo, coracao) && verificacao(cabeca, coracao) && verificacao(corpo, cabeca)){
            this.cabeca = cabeca;
            this.corpo = corpo;
            this.coracao = coracao;
        } else {
            this.cabeca = null;
            this.corpo = null;
            this.coracao = null;
        }

    }

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFamiliaOlfativa() {
        return familiaOlfativa;
    }

    public void setFamiliaOlfativa(String familiaOlfativa) {
        this.familiaOlfativa = familiaOlfativa;
    }

    public String[] getCabeca() {
        return cabeca;
    }

    public void setCabeca(String[] cabeca) {
        this.cabeca = cabeca;
    }

    public String[] getCorpo() {
        return corpo;
    }

    public void setCorpo(String[] corpo) {
        this.corpo = corpo;
    }

    public String[] getCoracao() {
        return coracao;
    }

    public void setCoracao(String[] coracao) {
        this.coracao = coracao;
    }

    // Método de verificação para checar se as notas de cabeça, corpo e coração não possuem elementos em comum
    // Se não houver elementos em comum, retorna true
    // Se houver elementos em comum, retorna false

    public boolean verificacao (String[] lista1, String[] lista2){
        boolean verify = true;
        for (String s1 : lista1){
            for (String s2 : lista2){
                if (s1.equals(s2)){
                    verify = false;
                }
            }
        }
        return verify;
    }

    // Método para contar os elementos comuns entre dois vetores
    // Retorna o número de elementos comuns entre os dois vetores
    // Se não houver elementos em comum, retorna 0

    public static int contarElementosComuns(String[] vetor1, String[] vetor2) {
        int contador = 0;
        for (int i = 0; i < vetor1.length; i++) {
            for (int j = 0; j < vetor2.length; j++) {
                if (vetor1[i].equals(vetor2[j])) {
                    contador++;
                }
            }
        }
        return contador;
    }


    // Método para calcular a similaridade entre dois perfumes
    // A similaridade é calculada como a média ponderada das notas em comum por cada categoria
    // A média ponderada é calculada como a soma dos elementos comuns entre os dois perfumes
    // dividido pelo maior número de ingredientes do nível no perfume.

    public static double similaridade (Perfume p1, Perfume p2){
        double valor_cabeca = (double) contarElementosComuns(p1.getCabeca(), p2.getCabeca());
        valor_cabeca = (p1.getCabeca().length > p2.getCabeca().length) ? valor_cabeca/p1.getCabeca().length : valor_cabeca/p2.getCabeca().length;
        double valor_corpo = (double) contarElementosComuns(p1.getCorpo(), p2.getCorpo());
        valor_corpo = (p1.getCabeca().length > p2.getCabeca().length) ? valor_corpo/p1.getCabeca().length : valor_corpo/p2.getCabeca().length;
        double valor_coracao = (double) contarElementosComuns(p1.getCoracao(), p2.getCoracao());
        valor_coracao = (p1.getCabeca().length > p2.getCabeca().length) ? valor_coracao/p1.getCabeca().length : valor_coracao/p2.getCabeca().length;
        return (valor_cabeca + valor_coracao + valor_corpo)/3;
    }
}
