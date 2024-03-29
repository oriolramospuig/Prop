package main.domain.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa un Texto del tipo Palabras.
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class Palabras extends Texto implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de palabras que conforman el texto. */
    private String texto;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Crea una instancia de la clase Palabras e inicializa los atributos de esta clase con los valores correspondientes.
     * @param nombre nombre que adquiere el Texto de Tipo Palabras creada.
     * @param texto String que contiene las palabras que forman el texto creado.
     * @param frecuenciaLetras HashMap que contiene los pares de letras y sus respectivas frecuencias del Texto del Tipo Palabras creado.
     */
     public Palabras(String nombre, String texto, HashMap<String, Integer> frecuenciaLetras) {
        this.nombre = nombre;
        this.texto = texto;
        this.frecuenciaLetras = frecuenciaLetras;
        asociacionesVinculadas = new ArrayList<>();
     }


    // ---------- GETTERS ----------
    /**
     * Devuelve el contenido del Texto de Tipo Palabras.
     * @return String: Contenido del texto compuesto por palabras.
     */
    public String getTexto() {
        return texto;
    }


    // ---------- SETTERS ----------
    /**
     * Modifica el contenido del texto en formato palabras con una nueva entrada y actualiza la frecuencia de letras asociada.
     * @param entrada nueva cadena de texto que se utilizará como contenido del Texto.
     * @param frecLet nuevo HashMap que representa la frecuencia de letras asociada al contenido.
     */
    public void modificarPalabras(String entrada, HashMap<String, Integer> frecLet){
        texto = entrada;
        frecuenciaLetras = frecLet;
    }
}