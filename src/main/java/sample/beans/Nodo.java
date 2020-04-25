package sample.beans;

public class Nodo {

    private String numElemento;
    private String x; //en metros
    private String y; //en metros
    private String z; //en metros


    public Nodo(String numElemento, String x, String y, String z) {
        this.numElemento = numElemento;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String getNumElemento() {
        return numElemento;
    }

    public void setNumElemento(String numElemento) {
        this.numElemento = numElemento;
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
                "numElemento='" + numElemento + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", z='" + z + '\'' +
                '}';
    }
}
