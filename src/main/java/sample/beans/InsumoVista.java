package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class InsumoVista {

    private List<Nodo> lstNods;
    private List<Elemento> listElements;

    public InsumoVista(List<Nodo> lstNods, List<Elemento> listElements) {
        this.lstNods = lstNods;
        this.listElements = listElements;
    }
    public InsumoVista() {
        this.lstNods =  new ArrayList<>();
        this.listElements = new ArrayList<>();
    }

    public List<Nodo> getLstNods() {
        return lstNods;
    }

    public void setLstNods(List<Nodo> lstNods) {
        this.lstNods = lstNods;
    }

    public List<Elemento> getListElements() {
        return listElements;
    }

    public void setListElements(List<Elemento> listElements) {
        this.listElements = listElements;
    }

    @Override
    public String toString() {
        return "InusmoVista{" +
                "lstNods=" + lstNods +
                ", listElements=" + listElements +
                '}';
    }
}
