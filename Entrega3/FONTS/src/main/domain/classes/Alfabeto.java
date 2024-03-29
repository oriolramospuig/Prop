package main.domain.classes;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Clase que representa un alfabeto
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class Alfabeto implements Serializable
{
    // ---------- ATRIBUTOS ----------
    /** Nombre del alfabeto (clave única e identificador del objeto) */
    private String nombre;

    /** Contenido del afabeto */
    private ArrayList<Character> letras;

    /** Lista de nombres de teclados vinculados a ese alfabeto*/
    private ArrayList<String> tecladosVinculados;


    // ---------- CONSTRUCTORES ----------

    /** Constructora de alfabeto vacío */
    public Alfabeto() {
        this.nombre = new String();
        this.letras = new ArrayList<>();
        this.tecladosVinculados = new ArrayList<>();
    }

    /**
     * Constructora alfabeto con nombre y contenido asignados.
     * La lista de nombres de teclados vinculados esta vacía inicialmente.
     */
    public Alfabeto(String nombre, ArrayList<Character> letras) {
        this.nombre = nombre;
        this.letras = letras;
        tecladosVinculados = new ArrayList<>();
    }


    // ---------- GETTERS ----------
    /**
     * Devuelve el nombre del alfabeto (es el identificador)
     * @return String : Nombre alfabeto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el contenido del alfabeto
     * @return ArrayList: Lista de carácteres que forma el contenido del alfabeto
     */
    public ArrayList<Character> getLetras() {
        return letras;
    }

    /**
     * Devuelve la lista de nombres de los teclados vinculados al alfabeto
     * @return ArrayList: Lista de nombres de los teclados vinculados
     */
    public ArrayList<String> getTecladosVinculados() {
        return tecladosVinculados;
    }


    // ---------- SETTERS ----------
    /**
     * No devuelve nada.
     * @param nomT nombre del teclado a vincular
     * Añade a la lista de nombres de los teclados vinculados el nombre del nuevo teclado nomT
     */
    public void agregarTecladoVinculado (String nomT) {
        tecladosVinculados.add(nomT);
    }

    /**
     * No devuelve nada.
     * @param entradaCaracteres lista de los nuevos carácteres del alfabeto
     * Modifica la lista de carácteres que forma el contenido del alfabeto, cambia la antigua lista por la nueva que ha modificado el usuario
     */
    public void modificarContenido(ArrayList<Character> entradaCaracteres){
        letras = entradaCaracteres;
    }


    // ---------- AUXILIARES ----------
    /**
     * No devuelve nada.
     * @param nomT nombre del teclado a desvincular
     * Borra de la lista de nombres de los teclados vinculados el nombre del teclado nomT
     */
    public void borrarTecladoVinculado(String nomT) {
        tecladosVinculados.remove(nomT);
    }
}