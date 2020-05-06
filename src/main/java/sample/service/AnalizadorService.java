package sample.service;

import sample.beans.Elemento;
import sample.beans.InsumoVista;
import sample.beans.Pilar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnalizadorService {

    private List<Pilar> pilaresLst;
    private InsumoVista insumosAnalisis;

    private Map<Integer, Integer> nodo1Map;
    private Map<Integer, Integer> nodo2Map;

    public void realizaAnalisis(InsumoVista insumoVista){
        this.insumosAnalisis = insumoVista;

        if(insumosAnalisis != null){
            vaciaNodos();
            encuentraRelacionNodos();
        }

    }

    public void vaciaNodos(){
        for (Elemento e :insumosAnalisis.getLstElements() ) {
            if(e.getNode1() != null && !e.getNode1().trim().equals("")){
                nodo1Map.put(Integer.parseInt(e.getNumElemento()),Integer.parseInt(e.getNode1()));
            }
            if(e.getNode2() != null && !e.getNode2().trim().equals("")){
                nodo2Map.put(Integer.parseInt(e.getNumElemento()),Integer.parseInt(e.getNode2()));
            }
        }
    }

    public void encuentraRelacionNodos(){

        int contadorNodos, auxiliarNodo = 0;
        List<Integer> nodosP = new ArrayList<>();
        pilaresLst = new ArrayList<>();


        contadorNodos = insumosAnalisis.getLstElements().size();




    }

}
