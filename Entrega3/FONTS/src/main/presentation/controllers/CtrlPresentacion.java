package main.presentation.controllers;

import drivers.InOut;
import main.domain.classes.Alfabeto;
import main.domain.classes.AsociacionTextos;
import main.domain.classes.types.PairInt;
import main.presentation.views.*;
import main.domain.controllers.CtrlDominio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * El CtrlPresentacion se encarga de hacer de comunicador entre las vistas de la capa de presentación.
 * También transmite a la capa de presentación los datos de las capas inferiores.
 * @author
 */
public class CtrlPresentacion {
    /** Instància del controlador de domini */
    private static final CtrlDominio cd = new CtrlDominio();

    // COMUNICACIÓN ENTRE VISTAS
    /** Muestra por pantalla la ventana del menú principal */
    public static void iniPresentacion() {
        VistaMenuPrincipal vMP = new VistaMenuPrincipal();
    }

    //VISTAS ALFABETO
    /** Muestra por pantalla la ventana de agregar alfabeto */
    public static void vistaAlfabetoA() {
        VistaAlfabetoA vA = new VistaAlfabetoA();
    }
    /** Muestra por pantalla la ventana de consultar alfabeto */
    public static void vistaAlfabetoC() {
        VistaAlfabetoC vA = new VistaAlfabetoC();
    }
    /** Muestra por pantalla la ventana de modificar de alfabeto */
    public static void vistaAlfabetoM() {
        VistaAlfabetoM vA = new VistaAlfabetoM();
    }
    /** Muestra por pantalla la ventana de borrar alfabeto */
    public static void vistaAlfabetoB() {
        VistaAlfabetoB vA = new VistaAlfabetoB();
    }

    //VISTAS TEXTO
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoA() {
        VistaTextoA vTxt = new VistaTextoA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoC() {
        VistaTextoC vTxt = new VistaTextoC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoM() {
        VistaTextoM vTxt = new VistaTextoM();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTextoB() {
        VistaTextoB vTxt = new VistaTextoB();
    }

    //VISTAS ASOCIACIONES DE TEXTOS
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosA() {
        VistaAsociacionTextosA vAT = new VistaAsociacionTextosA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosB() {
        VistaAsociacionTextosB vAT = new VistaAsociacionTextosB();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosC() {
        VistaAsociacionTextosC vAT = new VistaAsociacionTextosC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de asociación de textos */
    public static void vistaAsociacionTextosM() {
        VistaAsociacionTextosM vAT = new VistaAsociacionTextosM();
    }

    //VISTAS TECLADO
    /** Muestra por pantalla la ventana de las funcionalidades de teclado */
    public static void vistaTecladoA() {
        VistaTecladoA vTec = new VistaTecladoA();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de teclado */
    public static void vistaTecladoC() {
        VistaTecladoC vTec = new VistaTecladoC();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTecladoM() {
        VistaTecladoM vTec = new VistaTecladoM();
    }
    /** Muestra por pantalla la ventana de las funcionalidades de texto */
    public static void vistaTecladoB() {
        VistaTecladoB vTec= new VistaTecladoB();
    }


    //FUNCIONES DE CTRlDOMINIO DE ALFABETO
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param entrada la lista de caracteres que forman el contenido del alfabeto
     */
    public static boolean agregarAlfabetoManual(String nomA, ArrayList<Character> entrada) {
        return cd.agregarAlfabeto(nomA, entrada);
    }
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param path es la lista de caracteres que forman el contenido del alfabeto
     */
    public static boolean agregarAlfabetoPath(String nomA, String path) throws IOException {
        ArrayList<Character> entrada = InOut.leerCaracteresDeArchivo(path);
        return cd.agregarAlfabeto(nomA, entrada);
    }
    /** Llama a la función getNombresAlfabetos de CtrlDominio */
    public static ArrayList<String> getNombresAlfabetos() {
        ArrayList<String> listaAlfabetosNombres = cd.getNombresAlfabetos();
        return listaAlfabetosNombres;
    }
    /**
     * Llama a la función consultarContenidoAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a consultar
     */
    public static ArrayList<Character> consultarContenidoAlfabeto(String nomA) {
        ArrayList<Character> contenidoA = cd.consultarContenidoAlfabeto(nomA);
        return contenidoA;
    }
    /**
     * Llama a la función modificarContenidoAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a modificar
     */
    public static void modificarContenidoAlfabeto(String nomA, ArrayList<Character> entrada) {
        cd.modificarContenidoAlfabeto(nomA, entrada);
    }
    /**
     * Llama a la función borrarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a borrar
     */
    public static void borrarAlfabeto(String nomA) {
        cd.borrarAlfabeto(nomA);
    }
    /** Llama a la función guardaCnjtAlfabetos de CtrlDominio */
    public static void guardaAlfabetos(){
        cd.guardaCnjtAlfabetos();
    }


    //FUNCIONES DE CTRlDOMINIO DE TEXTO
    /**
     * Llama a la función esTextoPalabras de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     */
    public static boolean esTextoDePalabras(String nomTxt) {
        return cd.esTextoPalabras(nomTxt);
    }
    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param texto es la lista de caracteres que forman el contenido del texto
     */
    public static boolean agregarTextoPalabras(String nomTxt, String texto) {
        //ArrayList<Character> entrada = InOut.leerCaracteresDeTerminal(entradaCaracteres);
        return cd.agregarTextoPalabras(nomTxt, texto);
    }
    /**
     * Llama a la función agregarTextoPalabras de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param path es el path donde tenemos el texto del texto
     */
    public static boolean agregarTextoPalabrasPath(String nomTxt, String path) throws IOException {
        String texto = InOut.leerPalabrasDeArchivo(path);
        return cd.agregarTextoPalabras(nomTxt, texto);
    }
    /**
     * Llama a la función agregarTextoFrecuencias de CtrlDominio
     * @param nomTxt es el nombre del texto a agregar
     * @param frecuenciaPalabras es la map con las palabras y sus frecuencias que forman el contenido del texto
     */
    public static boolean agregarTextoFrecuencias(String nomTxt, HashMap<String, Integer> frecuenciaPalabras) {
        return cd.agregarTextoFrecuencias(nomTxt, frecuenciaPalabras);
    }
    /** Llama a la función getNombresTextos de CtrlDominio */
    public static ArrayList<String> getNombresTextos() {
        ArrayList<String> listaTextosNombres = cd.getNombresTextos();
        return listaTextosNombres;
    }
    /**
     * Llama a la función consultarContenidoTexto de CtrlDominio
     * @param nomTxt es el nombre del texto a consultar
     */
    public static String consultarContenidoTexto(String nomTxt) {
        String contenidoTxt = cd.consultarContenidoTexto(nomTxt);
        return contenidoTxt;
    }
    /**
     * Llama a la función modificarContenidoTexto de CtrlDominio
     * @param nomTxt es el nombre del texto a modificar
     */
    public static void modificarContenidoTexto(String nomTxt, String entrada) {
        cd.modificarContenidoTexto(nomTxt, entrada);
    }
    /**
     * Llama a la función modificarContenidoTexto de CtrlDominio
     * @param nomTxt es el nombre del texto a modificar
     */
    public static void modificarContenidoTextoFrecuencias(String nomTxt, HashMap<String, Integer> entrada) {
        cd.modificarContenidoTextoFrec(nomTxt, entrada);
    }
    /**
     * Llama a la función borrarTexto de CtrlDominio
     * @param nomTxt es el nombre del alfabeto a borrar
     */
    public static void borrarTexto(String nomTxt) {
        cd.borrarTexto(nomTxt);
    }

    public static void guardaTextos(){
        cd.guardaCnjtTextos();
    }

    public static void guardaAsociaciones(){
        cd.guardaCnjtAsociaciones();
    }

    public static void guardaTeclados(){
        cd.guardaCnjtTeclados();
    }


    //FUNCIONES DE CTRlDOMINIO DE ASOCIACION DE TEXTOS
    /**
     * Llama a la función agregarAlfabeto de CtrlDominio
     * @param nomA es el nombre del alfabeto a agregar
     * @param nomtx es el contenido del alfabeto
     */
    public static boolean agregarAsociacion1(String nomA, String nomtx) {
        //if(nomtx == null)
        //ArrayList<Character> entrada = InOut.leerCaracteresDeTerminal(entradaCaracteres);
        /*boolean agregado = cd.agregarAlfabeto(nomA, entrada);

        if (agregado) {
            try {
                File archivo = new File(path, nomA + ".txt");
                if (!archivo.exists()) {
                    archivo.createNewFile(); // Crea el archivo si no existe
                }
                try (PrintWriter writer = new PrintWriter(archivo)) {
                    for (Character c : entrada) {
                        writer.print(c);
                    }
                }
                return true; // El alfabeto se agregó correctamente y se guardó el archivo
            } catch (IOException e) {
                return false; // Retorna false si hubo un error al escribir el archivo
            }
        } else {
            return false; // El alfabeto no se pudo agregar
        }*/
        return false;
    }

    /**
     * Llama a la función agregarAsociacion de CtrlDominio
     * @param nomAT es el nombre de la asociación a agregar
     */
    public static boolean agregarAsociacion(String nomAT, ArrayList<String> textosagregar) {
        return cd.agregarAsociacion(nomAT, textosagregar);
    }
    /**
     * Llama a la función agregarAsociacion de CtrlDominio
     *
     * @param nomAT  es el nombre de la asociación a agregar
     * @param nomTxt es el nombre del texto a agregar en la asociación
     * @return
     */
    public static void agregarTextoAsociacion (String nomAT, String nomTxt) {
        cd.agregarTextoAsociacion(nomAT, nomTxt);
    }
    /**
     * Llama a la función getNombresAsociaciones de CtrlDominio
     *
     * @return
     */
    public static ArrayList<String> getNombresAsociaciones() {
        ArrayList<String> listaAsociacionesNombres = cd.getNombresAsociaciones();
        return listaAsociacionesNombres;
    }
    /**
     * Llama a la función consultarContenidoAsociacion de CtrlDominio
     * @param nomAT es el nombre de la asociación a consultar
     */
    public static ArrayList<String> consultarCjtTextosAsociacion(String nomAT) {
            ArrayList<String > cjtTextosAsociacion = cd.consultarCjtTextosAsociacion(nomAT);
            return cjtTextosAsociacion;
    }
    public static void borrarTextoAsociacion (String nomAT, String nomTxt) {
        cd.borrarTextoAsociacion(nomAT, nomTxt);
    }
    /**
     * Llama a la función borrarAsociacionTextos de CtrlDominio
     * @param nomAT es el nombre de la asociación a borrar
     */
    public static void borrarAsociacionTextos(String nomAT) {
        cd.borrarAsociacionTextos(nomAT);
    }


    //FUNCIONES DE CTRlDOMINIO DE TECLADO
    /**
     * Retorna si el alfabeto y la asociacion de textos tiene caracteres parecidos y por lo tanto son compatibles
     * @param alfabeto objeto alfabeto para comparar
     * @param asociacionTextos objeto asociacion de textos para comparar
     * @return Boolean: true si el alfabeto y la asociación de textos son comptibles, false si no lo son
     */
    public boolean compatibles(Alfabeto alfabeto, AsociacionTextos asociacionTextos){
        boolean comp = cd.compatibles(alfabeto,asociacionTextos);
        return comp;
    }
    /**
     * Llama a la función agregarTeclado de CtrlDominio
     * @param nomT nombre del teclado a agregar
     * @param nomA nombre del alfabeto a vincular con el teclado nomT
     * @param nomAT nombre de la asociación de textos a vincular con el teclado nomT
     */
    public static int agregarTeclado(String nomT, String nomA, String nomAT, PairInt dim, boolean alg){
        int acabado = cd.agregarTeclado(nomT,nomA,nomAT, dim, alg);
        return acabado;
    }
    /**
     * Llama a la función consultarContenidoTeclado de CtrlDominio
     * @param nomT nombre del teclado a consultar
     * @return char[][]: la matriz que representa el contenido del teclado nomT
     */
    public static char[][] consultarContenidoTeclado(String nomT){
        return cd.consultarContenidoTeclado(nomT);
    }
    /**
     * Llama a la función consultarContenidoTeclado de CtrlDominio
     * @param nomT nombre del teclado a consultar
     * @return char[][]: la matriz que representa el contenido del teclado nomT
     */
    public static int consultarPuntuacionTeclado(String nomT){
        return cd.consultarPuntuacionTeclado(nomT);
    }
    /**
     * Llama a la función consultarAlfabetoAsociadoTeclado de CtrlDominio
     * @param nomT nombre del teclado a consultar
     * @return String: nombre del alfabeto vinculado al teclado nomT
     */
    public static String consultarAlfabetoAsociadoTeclado(String nomT) {
        return cd.consultarAlfabetoAsociadoTeclado(nomT);
    }
    /**
     * Llama a la función consultarAsociacionAsociadoTeclado de CtrlDominio
     * @param nomT nombre del teclado a consultar
     * @return String: nombre de la asociación vinculada al teclado nomT
     */
    public static String consultarAsociacionAsociadoTeclado(String nomT) {
        return cd.consultarAsociacionAsociadoTeclado(nomT);
    }
    /**
     * Llama a la función consultarAsociacionAsociadoTeclado de CtrlDominio
     * @param nomT nombre del teclado a consultar
     * @return String: nombre de la asociación vinculada al teclado nomT
     */
    public static PairInt consultarDimensionesTeclado(String nomT) {
        return cd.consultarDimensionesTeclado(nomT);
    }
    /**
     * Llama a la función getListaTeclados de CtrlDominio
     * @return ArrayList<String>: lista de nombres de los teclados existentes
     */
    public static ArrayList<String> getListaTeclados(){
        ArrayList<String> listaTeclados = cd.getListaTeclados();
        return listaTeclados;
    }
    /**
     * Llama a la función borrarTeclado de CtrlDominio
     * @param nomT nombre del teclado a borrar
     */
    public static void borrarTeclado(String nomT) {
        cd.borrarTeclado(nomT);
    }

    public static ArrayList<PairInt> getPosiblesDimensiones(String nomA) {
        return cd.getPosiblesDimensiones(nomA);
    }

}