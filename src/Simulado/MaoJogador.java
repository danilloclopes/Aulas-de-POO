package Simulado;

public class MaoJogador {

    private String nome;
    private CartaBaralho[] cartas;

    public MaoJogador(String nome) {

        this.nome = nome;
        cartas = new CartaBaralho[7];
        int pos = 0;

        while (cartas[6] == null) {

            CartaBaralho carta = CartaBaralho.pickCard();
            boolean naoRepetida = true;

           for (int i = 0; i < pos; i++) {  
                if (cartas[i].equals(carta)) {  
                    naoRepetida = false;
                    break;
                }
            }

            if(naoRepetida) {
                cartas[pos] = carta;
                pos++;
            }

        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CartaBaralho[] getCartas() {
        return cartas;
    }

}
