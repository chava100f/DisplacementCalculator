package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class InsumoVista {

    private List<Nodo> lstNods;
    private List<Elemento> lstElements;
    private List<Desplazamiento> lstDesplazamientos;

    public InsumoVista() {
        this.lstNods =  new ArrayList<>();
        this.lstElements = new ArrayList<>();
        this.lstDesplazamientos = new ArrayList<>();
    }

    public List<Nodo> getLstNods() {
        return lstNods;
    }

    public void setLstNods(List<Nodo> lstNods) {
        this.lstNods = lstNods;
    }

    public List<Elemento> getLstElements() {
        return lstElements;
    }

    public void setLstElements(List<Elemento> lstElements) {
        this.lstElements = lstElements;
    }

    public List<Desplazamiento> getLstDesplazamientos() {
        return lstDesplazamientos;
    }

    public void setLstDesplazamientos(List<Desplazamiento> lstDesplazamientos) {
        this.lstDesplazamientos = lstDesplazamientos;
    }

    @Override
    public String toString() {
        return "InsumoVista{" +
                "lstNods=" + lstNods +
                ", lstElements=" + lstElements +
                ", lstDesplazamientos=" + lstDesplazamientos +
                '}';
    }
}
