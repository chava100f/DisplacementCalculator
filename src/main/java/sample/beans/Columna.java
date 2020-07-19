package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class Columna {

    private List<Nodo> lstNodos;
    private List<Float> alturaZ;
    private List<Float> alturaEntreNodos;

    public Columna(List<Nodo> lstNodos, List<Float> alturaZ, List<Float> alturaEntreNodos) {
        this.lstNodos = lstNodos;
        this.alturaZ = alturaZ;
        this.alturaEntreNodos = alturaEntreNodos;
    }

    public Columna() {
        lstNodos = new ArrayList<>();
    }

    public List<Nodo> getLstNodos() {
        return lstNodos;
    }

    public void setLstNodos(List<Nodo> lstNodos) {
        this.lstNodos = lstNodos;
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
        return "Columna{" +
                "lstNodos=" + imprimeListaNodos() +
                ", alturaZ=" + alturaZ +
                ", alturaEntreNodos=" + alturaEntreNodos +
                '}';
    }

    private String imprimeListaNodos(){

        String impresion = "";

        for(Nodo n : lstNodos){
            impresion += "{"+n.toString()+"} ";
        }
        return impresion;
    }
}
