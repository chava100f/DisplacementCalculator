package sample.beans;

public class Desplazamiento {
    private String node;
    private String load;
    private String dx;
    private String dy;
    private String dz;
    private String rx;
    private String ry;
    private String rz;

    public Desplazamiento() {
    }

    public Desplazamiento(String node, String load, String dx, String dy, String dz, String rx, String ry, String rz) {
        this.node = node;
        this.load = load;
        this.dx = dx;
        this.dy = dy;
        this.dz = dz;
        this.rx = rx;
        this.ry = ry;
        this.rz = rz;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load;
    }

    public String getDx() {
        return dx;
    }

    public void setDx(String dx) {
        this.dx = dx;
    }

    public String getDy() {
        return dy;
    }

    public void setDy(String dy) {
        this.dy = dy;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getRx() {
        return rx;
    }

    public void setRx(String rx) {
        this.rx = rx;
    }

    public String getRy() {
        return ry;
    }

    public void setRy(String ry) {
        this.ry = ry;
    }

    public String getRz() {
        return rz;
    }

    public void setRz(String rz) {
        this.rz = rz;
    }
}

