package main.domain.classes;

import main.domain.classes.types.PairFrequency;

import java.io.Serializable;
import java.util.*;

/** Clase que implementa un comparador de frecuencias
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
class FrequencyComparator implements Comparator<PairFrequency> {
    // override the compare() method

    /**
     * Compara dos objetos PairFrequency según sus frecuencias y, en caso de empate,
     * según el orden natural de los pares.
     * @param pf1 El primer objeto PairFrequency a comparar.
     * @param pf2 El segundo objeto PairFrequency a comparar.
     * @return Un entero negativo si la frecuencia de pf1 es mayor que la de pf2,
     *         un entero positivo si la frecuencia de pf1 es menor que la de pf2,
     *         o la comparación natural de los pares si las frecuencias son iguales.
     */
    public int compare(PairFrequency pf1, PairFrequency pf2)
    {
        if (pf1.getFrequency() > pf2.getFrequency())
            return -1;
        if (pf1.getFrequency() < pf2.getFrequency())
            return 1;
        else if(pf1.getPair().compareTo(pf2.getPair()) < 0) return -1;
        return 1;
    }
}

/** Clase que implementa una asociación de textos.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class AsociacionTextos implements Serializable
{
    //private static final long serialVersionUID = 2062931267658986574L;
    // ---------- ATRIBUTOS ----------
    /** Guarda el nombre introducido por el usuario. */
    private String nombre;

    /** Guarda la lista de textos de los que está compuesta la asociación. */
    private ArrayList<String> textosAsociaciados;

    /** Guarda la lista de teclados que se han creado a partir de la asociacion. */
    private ArrayList<String> tecladosVinculados;

    /** Guarda el map que asocia pares de letras ("ab") con sus frecuencias ("20"). */
    private HashMap<String, Integer> frecuenciaLetras;


    // ---------- CONSTRUCTORES ----------
    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías. */
    public AsociacionTextos() {
        nombre = new String();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
        frecuenciaLetras = new HashMap<>();
    }

    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías, excepto nombre y frecuenciaLetras que se les asignan valores.
     * @param nombre nombre que adquiere la AsociacionTextos creada.
     * @param frecuenciaLetras HashMap que contiene los pares de letras y sus respectivas frecuencias de la AsociacionTextos creada.
     */
    public AsociacionTextos(String nombre, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.frecuenciaLetras = frecuenciaLetras;
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }

    /** Crea una instancia de la clase AsociacionTextos e inicializa las variables como vacías, excepto nombre que se le asigna un valor específico.
     * @param nombre nombre que adquiere la AsociacionTextos creada.
     */
    public AsociacionTextos(String nombre) {
        this.nombre = nombre;
        frecuenciaLetras = new HashMap<>();
        textosAsociaciados = new ArrayList<>();
        tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el nombre introducido por el usuario.
     * @return String: Nombre introducido por el usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el nombre de los textos asociados.
     * @return ArrayList: Lista de nombres de los textos asociados.
     */
    public ArrayList<String> getTextosAsociaciados() {
        return textosAsociaciados;
    }

    /**
     * Devuelve el nombre de los teclados vinculados a la asocciación de textos.
     * @return ArrayList: Lista de nombres de los teclados vinculados.
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }

    /**
     * Devuelve el map de pares de letras con sus frecuencias.
     * @return HashMap de String,Integer: Map de frecuenciaLetras.
     */
    public HashMap<String,Integer> getFrecuenciaLetras() {
        return frecuenciaLetras;
    }

    /**
     * Devuelve los pares String, Integer de los pares de letras con sus frecuencias ordenados.
     * @return ArrayList PairFrequency: Lista de pares de letras y frecuencias ordenados.
     */
    public ArrayList<PairFrequency> getFrecuenciaLetrasArray() {
        ArrayList<PairFrequency> freq = new ArrayList<>();
        for(HashMap.Entry<String, Integer> e : frecuenciaLetras.entrySet()){
            PairFrequency pf = new PairFrequency(e.getKey(),e.getValue());
            freq.add(pf);
        }
        Collections.sort(freq,new FrequencyComparator());
        return freq;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada. Añade a la lista de nombres de los teclados vinculados el nombre del nuevo teclado nomT.
     * @param nomT nombre del teclado a vincular.
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    /**
     * No devuelve nada. Añade a la lista de nombres de los textos asociados el nombre del nuevo texto.
     * @param nomTxt nombre texto a agregar a la asociación.
     * @param freqTexto map de frecuencias de las palabras del texto a agregar a la asociación.
     */
    public void agregarTexto (String nomTxt, HashMap<String,Integer> freqTexto) {
        textosAsociaciados.add(nomTxt);

        for(Map.Entry<String,Integer> e : freqTexto.entrySet()){
            Integer frec = e.getValue();
            if(frecuenciaLetras.containsKey(e.getKey())) {
                frec = frecuenciaLetras.get(e.getKey()) + e.getValue();
            }
            frecuenciaLetras.put(e.getKey(),frec);
        }
    }


    // ---------- AUXILIARES -----------
    /**
     * No devuelve nada. Borra de la lista de nombres de los teclados vinculados el nombre del teclado nomT.
     * @param nomT nombre del teclado a desvincular.
     */
    public void borrarTecladoVinculado (String nomT) {
        tecladosVinculados.remove(nomT);
    }

    /**
     * No devuelve nada. Borra de la lista de nombres de los textos asociados el nombre del texto nomT.
     * @param nomT nombre del texto a quitar de la asociación.
     * @param frecLetras HashMap de unas letras y sus frecuencias.
     */
    public boolean borrarTexto (String nomT, HashMap<String, Integer> frecLetras) {

        for (Map.Entry<String, Integer> entry : frecLetras.entrySet()) {
            String clave = entry.getKey();

            if (frecuenciaLetras.containsKey(clave)) {
                Integer valor1 = frecuenciaLetras.get(clave);
                Integer valor2 = frecLetras.get(clave);
                if (valor1 != null && valor2 != null) {
                    int resultado = Math.max(valor1 - valor2, 0);  // Garantizar que el resultado sea 0 o mayor
                    frecuenciaLetras.put(clave, resultado);
                }
            }
        }
        /*if (textosAsociaciados.size() == 1){
            //textosAsociaciados.remove(nomT);
            return true;
        }
        else return false;*/
        textosAsociaciados.remove(nomT);
        return textosAsociaciados.isEmpty();
    }
}