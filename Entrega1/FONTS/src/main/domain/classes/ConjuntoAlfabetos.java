package main.domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa el conjunto de alfabetos
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class ConjuntoAlfabetos
{
    // ---------- ATRIBUTOS ----------
    /** Guarda el conjunto de alfabetos introducidos por el usuario */
    private HashMap<String, Alfabeto> alfabetos;


    // ---------- CONSTRUCTORAS ----------
    /**
     * Constructora conjunto de alfabetos.
     * Inicialmente el conjunto de alfabetos existentes está vacío.
     */
    public ConjuntoAlfabetos() {
        alfabetos = new HashMap<>();
    }


    // ---------- GETTERS ----------
    /**
     * Retorna el alfabeto con clave primaria introducida
     * @param nomA clave primaria con la que buscar un alfabeto
     * @return Alfabeto : Alfabeto con el nombre introducido
     */
    public Alfabeto getAlfabeto(String nomA) {
        if (alfabetos.containsKey(nomA)) return alfabetos.get(nomA);
        else return null;
    }

    /**
     * Retorna el conjunto de alfabetos existentes
     * @return HashMap<String, Alfabeto>: Conjunto de alfabetos
     */
    public HashMap<String, Alfabeto> getAlfabetos () {
        return alfabetos;
    }

    /**
     * Retorna el nombre de los alfabetos del conjunto
     * @return ArrayList<String>: Lista de nombres de los alfabetos del conjunto
     */
    public ArrayList<String> getNombresAlfabetos() {
        ArrayList<String> listaNombresA = new ArrayList<>();
        for (String clave : alfabetos.keySet()) {
            listaNombresA.add(clave);
        }
        return listaNombresA;
    }


    // ---------- SETTERS ----------
    /**
     * No retorna nada.
     * @param alfabeto alfabeto a agregar
     * @param nomA nombre del alfabeto a agregar
     * Añade un alfabeto al conjunto de alfabetos
     */
    public void agregarAlfabeto(String nomA, Alfabeto alfabeto) {
        alfabetos.put(nomA, alfabeto);
    }


    // ---------- AUXILIARES ----------
    /**
     * Retorna si existe el alfabeto con nombre dado
     * @param nomA nombre del alfabeto a comprobar
     * @return boolean : True si el alfabeto con nombre nomA existe, false si no existe
     */
    public boolean existeAlfabeto(String nomA){
        return alfabetos.containsKey(nomA);
    }

    /**
     * No retorna nada.
     * @param nomA nombre del alfabeto a borrar
     * Borra el alfabeto con nombre nomA del conjunto de alfabetos.
     */
    public void borrarAlfabeto(String nomA) {
        alfabetos.remove(nomA);
    }
}