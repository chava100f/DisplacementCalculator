package sample.service;

import sample.beans.Elemento;
import sample.beans.InsumoVista;
import sample.beans.Columna;
import sample.beans.Nodo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizadorService {

    private List<Columna> listColunmas;
    private InsumoVista insumosAnalisis;
    private Map<Float, Float> nodos1y2;
    private Map<Float, Nodo> mapaNodos;
    private Columna columnaConstruyendo;

    public void realizaAnalisis(InsumoVista insumoVista){
        this.insumosAnalisis = insumoVista;
        if(insumosAnalisis != null){

            obtieneMapaNodos1y2();
            mapeaNodos();
            encuentraRelacionNodos();
        }
    }

    public void obtieneMapaNodos1y2(){
        if(insumosAnalisis.getLstElements() != null) {
            nodos1y2 = new HashMap<>();
            for (Elemento e : insumosAnalisis.getLstElements())
                if(e.getNode1() != null && e.getNode2() != null)
                    try{
                        nodos1y2.put(Float.parseFloat(e.getNode1()), Float.parseFloat(e.getNode2()));
                    }catch (NumberFormatException except){
                        System.out.println("Existio un error al querer convertir numeros de nodos a enteros los nodos son ["
                                + e.getNode1() + ", " + e.getNode2() + "]" );
                    }
        }
    }

    public void mapeaNodos(){
        if(insumosAnalisis.getLstNods() != null) {
            mapaNodos = new HashMap<>();
            for(Nodo n : insumosAnalisis.getLstNods()){
                if(n != null && n.getNumNodo() != null && !n.getNumNodo().trim().equals("")){
                    mapaNodos.put(Float.parseFloat(n.getNumNodo()),n);
                }
            }
        }
    }

    public void encuentraRelacionNodos() {
        if (nodos1y2 != null && mapaNodos != null) {
            listColunmas = new ArrayList<>();

            int limite =  Integer.valueOf(nodos1y2.get(1f) != null ? nodos1y2.get(1f).toString().split("\\.")[0] : "1") - 1;
            float auxN = 1f;
            for(int i=0; i<limite; i++){
                Nodo nodoAux;
                columnaConstruyendo = new Columna();

                //Va construyendo recursivamente las columnas
                nodoAux = mapaNodos.get(auxN);
                columnaConstruyendo.getLstNodos().add(nodoAux);
                construyeColumnas(nodos1y2.get(auxN));

                auxN++;
                listColunmas.add(columnaConstruyendo);
            }

        } else {
            System.out.println("Hubo un problema al relacionar los nodos para determinar columnas...");
        }
    }

    public void construyeColumnas(Float nodo2){
        if(nodos1y2.get(nodo2) != null){
            Nodo n = mapaNodos.get(nodo2);
            columnaConstruyendo.getLstNodos().add(n);
            construyeColumnas(nodos1y2.get(nodo2));
        }else{
            Nodo n = mapaNodos.get(nodo2);
            columnaConstruyendo.getLstNodos().add(n);
        }
    }


    public void imprimeListaNodos() {
        if (nodos1y2 != null) {
            System.out.println("----------------IMPRIMIENDO LISTA NODOS---------------");
            for (Float name : nodos1y2.keySet()) {
                String key = name.toString();
                String value = nodos1y2.get(name).toString();
                System.out.println(key + " " + value);
            }
            System.out.println("--------------------FIN LISTA NODOS-------------------");
        }
    }
}
