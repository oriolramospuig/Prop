package main.domain.controllers;


import main.domain.classes.*;
import main.domain.classes.types.PairInt;

import java.io.*;
import java.util.ArrayList;

/**
 * Este controlador se encarga de gestionar los métodos de añadir, modificar y borrar de conjunto teclados, teclado y el controlador del algoritmo
 * @author Júlia Tena (julia.tena.domingo@estudiantat.upc.edu)
 */
public class CtrlTeclado
{
    // ---------- PARÁMETROS ----------
    /** Crea una instancia del conjunto de teclados*/
    private static ConjuntoTeclados teclados;

    /** Crea una instancia del controlador del algoritmo*/
    private CtrlTecladoQAP ctrlAlgoritmo;


    // ---------- CONSTRUCTURAS ----------
    /** Inicialización de la instancia conjunto de teclados vacío.*/
    public CtrlTeclado(){
        teclados = new ConjuntoTeclados();
        ctrlAlgoritmo = new CtrlTecladoQAP();
    }


    // ---------- FUNCIONES TECLADO ----------
    public char[][] getContenido(String nomT){
        return teclados.getTeclado(nomT).getContenido();
    }

    public int getPuntuacion(String nomT){
        return teclados.getTeclado(nomT).getPuntuacion();
    }

    public String getAlfabeto(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    public String getAsociacion(String nomT){
        return teclados.getTeclado(nomT).getAsociacionTextosVinculado();
    }

    public PairInt getDimensiones(String nomT){
        return teclados.getTeclado(nomT).getDimensiones();
    }

    /**
     * No devuelve nada, manda a vincular un Alfabeto a un Teclado
     */
    public void agregarAlfabetoVinculado(String nomT, String nomA) {
        teclados.getTeclado(nomT).agregarAlfabetoVinculado(nomA);
    }

    /**
     * No devuelve nada, manda a vincular una Asociacion de Textos a un Teclado
     */
    public void agregarAsociacionTextosVinculado(String nomT, String nomAT) {
        teclados.getTeclado(nomT).agregarAsociacionTextosVinculado(nomAT);
    }

    public ArrayList<PairInt> getPosiblesDimensiones(int n) {
        ArrayList<PairInt> dim = new ArrayList<>();
        Integer x = 1;
        for (int filas = 1; filas <= n; filas++) {
            if (n % filas == 0) {
                int columnas = n / filas;
                //System.out.print(x + ": " + filas + "filas, " + columnas + "columnas");
                dim.add(new PairInt(filas, columnas));
                //if (n - filas * columnas == 1) System.out.println(" Falta una tecla");
                //else System.out.println();
                x++;
            }
        }
        if (esPrimo(n)) {
            int N = n+1;
            for (int filas = 1; filas <= N; filas++) {
                if (N % filas == 0) {
                    int columnas = N / filas;
                    // System.out.print(y + ": " + filas + "filas, " + columnas + "columnas");
                    dim.add(new PairInt(filas, columnas));
                    // System.out.println();
                    x++;
                }
            }
        }
        return dim;
    }

    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    // ---------- FUNCIONES CONJUNTOTECLADOS ----------
    /**
     * Devuelve el objecto cjt de Teclados pedido
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public ConjuntoTeclados getCjtTeclados() {
        return teclados;
    }

    /**
     * Devuelve booleano de si que existe el teclado pedido en el cjt de teclados
     * @return ConjuntoTeclados : Un objeto cjt de Teclados concreto
     */
    public boolean existeTeclado(String nomT){
        return teclados.existeTeclado(nomT);
    }

    /**
     * No devuelve nada.
     * Crea el nuevo objecto Teclado y añade este objeto a ConjuntoTeclados
     */
    public void CrearTeclado(String nomT, AsociacionTextos asociacionTextos, Alfabeto alfabeto, PairInt dim, boolean alg) {
        Teclado teclado = ctrlAlgoritmo.crearTeclado(nomT, asociacionTextos, alfabeto, dim, alg);
        teclados.agregarTeclado(nomT, teclado);
    }

    /**
     * Obtiene el nombre del alfabeto vinculado a un teclado específico.
     * @param nomT
     * @return Nombre del alfabeto vinculado a un teclado específico
     */
    public String TecladoTieneAlfabetoVinculado(String nomT){
        return teclados.getTeclado(nomT).getAlfabetoVinculado();
    }

    /**
     * Obtiene el nombre de la asociación de textos vinculada a un teclado específico.
     * @param nomT
     * @return Nombre de la asociación de textos vinculada a un teclado específico
     */
    public String TecladoTieneAsociacionVinculada(String nomT){
        return teclados.getTeclado(nomT).getAsociacionTextosVinculado();
    }

    /**
     * Borra Teclado con nombre nomT.
     * @param nomT
     */
    public void borrarTeclado(String nomT) {
        //String alfabetoVinculado = teclados.getTeclado(nomT).getAlfabetoVinculado();
        //if (!alfabetoVinculado.isEmpty()) alfabetos.borrarAlfabeto(alfabetoVinculado);
        teclados.borrarTeclado(nomT);

        //String asociacionTextosVinculado = teclados.getTeclado(nomT).getAsociacionTextosVinculado();
        //if (!asociacionTextosVinculado.isEmpty()) asociacionesTextos.borrarAsociacionTextos(asociacionTextosVinculado);
    }

    /**
     * Convierte un conjunto de teclados en ByteArray con el fin de almacenarlos.
     * @return Conjunto de teclados convertidos
     * @throws IOException
     */
    public byte[] tecladosToByteArray() throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(bs);
        os.writeObject(teclados);
        os.close();
        return bs.toByteArray();
    }

    /**
     * Transforma un conjunto de teclados almacenar en un array de bytes al formato original de Teclado.
     * @param bytes
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void byteArrayToTeclados(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
        ObjectInputStream is = new ObjectInputStream(bs);
        teclados = (ConjuntoTeclados) is.readObject();
        is.close();
    }
}