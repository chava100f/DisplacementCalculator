package sample.beans;

public class Elemento {
    private String numElemento;
    private String tipo;
    private String material;
    private String node1;
    private String node2;

    public Elemento(String numElemento, String tipo, String material, String node1, String node2) {
        this.numElemento = numElemento;
        this.tipo = tipo;
        this.material = material;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getNumElemento() {
        return numElemento;
    }

    public void setNumElemento(String numElemento) {
        this.numElemento = numElemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getNode1() {
        return node1;
    }

    public void setNode1(String node1) {
        this.node1 = node1;
    }

    public String getNode2() {
        return node2;
    }

    public void setNode2(String node2) {
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Elemento{" +
                "numElemento='" + numElemento + '\'' +
                ", tipo='" + tipo + '\'' +
                ", material=" + material +
                ", node1=" + node1 +
                ", node2=" + node2 +
                '}';
    }
}

