package sample.beans;

import java.util.List;

public class Pilar {

    private List<Integer> nodosP;
    private List<Float> alturaZ;
    private List<Float> alturaEntreNodos;

    public Pilar(List<Integer> nodosP, List<Float> alturaZ, List<Float> alturaEntreNodos) {
        this.nodosP = nodosP;
        this.alturaZ = alturaZ;
        this.alturaEntreNodos = alturaEntreNodos;
    }

    public Pilar() {
    }

    public List<Integer> getNodosP() {
        return nodosP;
    }

    public void setNodosP(List<Integer> nodosP) {
        this.nodosP = nodosP;
    }

    public List<Float> getAlturaZ() {
        return alturaZ;
    }

    public void setAlturaZ(List<Float> alturaZ) {
        this.alturaZ = alturaZ;
    }

    public List<Float> getAlturaEntreNodos() {
        return alturaEntreNodos;
    }

    public void setAlturaEntreNodos(List<Float> alturaEntreNodos) {
        this.alturaEntreNodos = alturaEntreNodos;
    }

    @Override
    public String toString() {
        return "Pilar{" +
                "nodosP=" + nodosP +
                ", alturaZ=" + alturaZ +
                ", alturaEntreNodos=" + alturaEntreNodos +
                '}';
    }
}
