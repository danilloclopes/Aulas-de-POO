package listaExec3;

public class Ponto2D {
    private double coordX;
    private double coordY;

    public Ponto2D() {
        coordX = 0.0;
        coordY = 0.0;
    }

    public Ponto2D(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public double getCoordX(){
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY(){
        return coordY;
    }

    public void setCoordY(double coordX) {
        this.coordX = coordY;
    }
    
    public static double distancia(Ponto2D p1, Ponto2D p2) {
        double distancia = 0;
        distancia += Math.pow(p1.coordX - p2.coordX, 2);
        distancia += Math.pow(p1.coordY - p2.coordY, 2);
        return Math.sqrt(distancia);
    } 

    public String toString(){
        String str = "";
        str += "( " + coordX + " , " + coordY + " )";
        return str;
    }
}
