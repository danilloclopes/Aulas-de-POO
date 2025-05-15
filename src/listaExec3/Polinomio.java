package listaExec3;

public class Polinomio {
    private int grauMax;

    //Admita-se que número real na posição i da lista
    //corresponda ao termo que multiplica x^i no polinomio

    private double[] coeficientes = new double[grauMax + 1];

    public Polinomio(int grauMax, double[] coeficientes) {
        if (grauMax >= 0 && coeficientes.length == grauMax + 1){
            this.grauMax = grauMax;
            this.coeficientes = coeficientes;
        } else {
            System.out.println("erro");
        }
    }

    public int getGrauMax() {
        return grauMax;
    }

    public void setGrauMax(int grauMax) {
        if (getGrauMax() >= 0){
            this.grauMax = grauMax;
        } else {
            System.out.println("erro");
        }
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] coeficientes) {
        if (coeficientes.length == grauMax + 1){
            this.coeficientes = coeficientes;
        } else {
            System.out.println("erro");
        }
    }

    public double calculaX0 (double x){
        int pot = 0;
        double sum = 0.0;
        for (double coeficiente : coeficientes){
            sum += coeficiente*Math.pow(x, pot);
            pot++;
        }
        return sum;
    }

    public static Polinomio somaPolinomio (Polinomio p1, Polinomio p2){
        if (p1.grauMax <= p2.grauMax){

            double[] coefP3 = p2.coeficientes;
            for (int i = 0; i < p1.coeficientes.length; i++){
                coefP3[i] += p1.coeficientes[i];
            }
            return new Polinomio(p2.grauMax, coefP3);

        } else {

            double[] coefP3 = p1.coeficientes;
            for (int i = 0; i < p2.coeficientes.length; i++){
                coefP3[i] += p2.coeficientes[i];
            }
            return new Polinomio(p1.grauMax, coefP3);

        }

    }

    public static Polinomio subtraiPolinomio (Polinomio p1, Polinomio p2){
        if (p1.grauMax >= p2.grauMax){

            int grauPol = 0;
            double[] temp = p1.coeficientes;

            for (int i = 0; i < p1.coeficientes.length; i++) {
                temp[i] -= p2.coeficientes[i];
                if (temp[i] != 0) grauPol = i;
            }

            double[] coefP3 = new double[grauPol + 1];

            for (int i = 0; i < grauPol + 1; i++){
                coefP3[i] = temp[i];
            }

            if (grauPol != 0) return new Polinomio(grauPol, coefP3);
            return null;

        } else {

            double[] temp = new double[p2.coeficientes.length];
            int grauPol = 0;

            for (int i = 0; i < p1.coeficientes.length; i++) {
                temp[i] = p1.coeficientes[i];
            }

            
            for (int i = p1.coeficientes.length; i < p2.coeficientes.length; i++) {
                temp[i] = 0.0;
            }

            for (int i = 0; i < p2.coeficientes.length; i++) {
                temp[i] -= p2.coeficientes[i];
                if (temp[i] != 0) grauPol = i;
            }

            double[] coefP3 = new double[grauPol + 1];

            for (int i = 0; i < grauPol + 1; i++){
                coefP3[i] = temp[i];
            }

            if (grauPol != 0) return new Polinomio(grauPol, coefP3);
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < this.coeficientes.length; i++) {
            if (coeficientes[i] != 0) { // Ignorar termos com coeficiente 0
                if (str.length() > 0) {
                    str.append(" + "); // Adicionar o sinal de soma entre os termos
                }
                str.append(coeficientes[i]).append("x^").append(i);
            }
        }

        return str.toString();
    }

}