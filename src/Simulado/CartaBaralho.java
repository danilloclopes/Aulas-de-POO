package Simulado;

import java.util.Random;

public class CartaBaralho {
    private String naipe;
    private int valor;

    public CartaBaralho(String naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public CartaBaralho(String naipe) {
        this.naipe = naipe;
        Random random = new Random();
        valor = random.nextInt(14) + 1;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static CartaBaralho pickCard() {

        Random random = new Random();
        String[] naipes = {"Copas", "Ouros", "Paus", "Espadas"};
        return new CartaBaralho(naipes[random.nextInt(4)]);

    }

    @Override
    public String toString() {

        String str = "";

        switch (valor) {
            case 1:
                str = "Ás de";
                break;

            case 11:
                str = "Valete de";
                break;

            case 12:
                str = "Dama de";
                break;

            case 13:
                str = "Rei de";
                break;

            default:
                str = String.valueOf(valor) + " de ";
                break;
        }

        str += naipe;
        return str;

    }

}
