package sample.beans;

public class Nodo {

    private String numNodo;
    private String x; //en metros
    private String y; //en metros
    private String z; //en metros


    public Nodo(String numNodo, String x, String y, String z) {
        this.numNodo = numNodo;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Nodo() {
    }

    public String getNumNodo() {
        return numNodo;
    }

    public void setNumNodo(String numNodo) {
        this.numNodo = numNodo;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Nodo{" +
                "numNodo='" + numNodo + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                '}';
    }
}
