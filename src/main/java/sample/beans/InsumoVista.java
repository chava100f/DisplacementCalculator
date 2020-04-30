package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class InsumoVista {

    private List<Nodo> lstNods;
    private List<Elemento> lstElements;

    public InsumoVista() {
        this.lstNods =  new ArrayList<>();
        this.lstElements = new ArrayList<>();
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

    @Override
    public String toString() {
        return "InusmoVista{" +
                "lstNods=" + lstNods +
                ", lstElements=" + lstElements +
                '}';
    }
}
