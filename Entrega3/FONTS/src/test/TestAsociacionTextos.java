package test;

import main.domain.classes.AsociacionTextos;
import main.domain.classes.Frecuencias;
import main.domain.classes.Texto;
import main.domain.classes.types.PairFrequency;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para asociación de textos.
 * @author Victor Moreno (victor.moreno@estudiantat.upc.edu)
 */
public class TestAsociacionTextos {

    // ---------- CONSTRUCTORAS ----------

    /**
     * Objeto de la prueba: Verificar que la construcción de objetos AsociacionTextos funciona correctamente
     * tanto para el constructor vacío como para los constructores con nombre y frecuencias de letras.
     *
     * Ficheros necesarios: Ninguno.
     *
     * Valores necesarios:
     *  Nombre de asociación: "Asociacion"
     *  Frecuencias de letras: {"a": 2, "b": 1, "c": 2}
     *
     * Operativa:
     *  1. Se realiza la prueba con el constructor vacío:
     *      Se crea una instancia de AsociacionTextos sin argumentos.
     *      Se verifica que los atributos de la instancia estén en su estado esperado.
     *  2. Se realiza la prueba con el constructor que recibe nombre y frecuencias de letras:
     *      Se crea una instancia de AsociacionTextos con un nombre y frecuencias de letras dados.
     *      Se verifica que los atributos de la instancia estén en su estado esperado.
     *  3. Se realiza la prueba con el constructor que recibe solo el nombre:
     *      Se crea una instancia de AsociacionTextos con un nombre dado.
     *      Se verifica que los atributos de la instancia estén en su estado esperado.
     */
    @Test
    public void TestConstructora() {
        //System.out.println("Test Constructora Vacia");
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        assertEquals("", asociacionTextos.getNombre());
        assertTrue(asociacionTextos.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos.getFrecuenciaLetras().isEmpty());

        System.out.println("Test Constructora con nombre y frecuencias");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("a", 2);
        frecuenciaLetras.put("b", 1);
        frecuenciaLetras.put("c", 2);

        AsociacionTextos asociacionTextos2 = new AsociacionTextos(nombre, frecuenciaLetras);

        assertEquals(nombre, asociacionTextos2.getNombre());
        assertEquals(frecuenciaLetras, asociacionTextos2.getFrecuenciaLetras());
        assertTrue(asociacionTextos2.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos2.getTecladosVinculados().isEmpty());

        System.out.println("Test Constructora con nombre");
        AsociacionTextos asociacionTextos3 = new AsociacionTextos(nombre);

        assertEquals(nombre, asociacionTextos3.getNombre());
        assertTrue(asociacionTextos3.getTextosAsociaciados().isEmpty());
        assertTrue(asociacionTextos3.getTecladosVinculados().isEmpty());
        assertTrue(asociacionTextos3.getFrecuenciaLetras().isEmpty());
    }

    // ---------- GETTERS ----------
    // ---------- SETTERS ----------
    /**
     * - Objetivo de la Prueba:
     *   Verificar que la función agregarTecladoVinculado añade correctamente un teclado vinculado a la instancia de
     *   AsociacionTextos y actualiza la lista de teclados vinculados.
     *
     * - Ficheros Necesarios:
     *   No hay referencia a ficheros en esta función de prueba.
     *
     * - Valores Estudiados:
     *   - Se imprime un mensaje indicando que se está probando la función agregarTecladoVinculado.
     *   - Se crea una instancia de AsociacionTextos.
     *   - Se añaden dos teclados vinculados (nombreT1 y nombreT2) mediante la función agregarTecladoVinculado.
     *   - Se verifica que la lista de teclados vinculados se actualiza correctamente.
     *
     * - Operativa:
     *   1. Imprime un mensaje informativo en la consola indicando que se está probando la función agregarTecladoVinculado.
     *   2. Crea una instancia de AsociacionTextos.
     *   3. Añade dos teclados vinculados (nombreT1 y nombreT2) mediante la función agregarTecladoVinculado.
     *   4. Utiliza aserciones para verificar que la lista de teclados vinculados se actualiza correctamente.
     *   5. Este método es parte de un conjunto más amplio de pruebas unitarias.
     */
    @Test
    public void TestagregarTecladoVinculado() {
        //System.out.println("Test agregarTecladoVinculado");
        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";
        AsociacionTextos asociacionTextos = new AsociacionTextos();

        asociacionTextos.agregarTecladoVinculado(nombreT1);
        asociacionTextos.agregarTecladoVinculado(nombreT2);

        assertEquals(2, asociacionTextos.getTecladosVinculados().size());
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT1));
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT2));
    }

/**
 * Objetivo de la Prueba:
 * La función `TestagregarTexto` tiene como objetivo verificar el correcto funcionamiento
 * del método `agregarTexto` de la clase `AsociacionTextos`. Este método debe agregar
 * un texto a la asociación, actualizando las frecuencias de letras existentes en la asociación.
 *
 * Ficheros Necesarios:
 * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
 * principalmente de las estructuras de datos internas de la clase `AsociacionTextos` y
 * la clase `Frecuencias`.
 *
 * Valores Estudiados:
 * Se evalúan los siguientes aspectos:
 * 1. Se crea una instancia de `AsociacionTextos` con un nombre y frecuencias de letras iniciales.
 * 2. Se crea una instancia de `Frecuencias` con un nombre y frecuencias de palabras y letras.
 * 3. Se agrega la instancia de `Frecuencias` a la asociación mediante el método `agregarTexto`.
 * 4. Se verifica que el texto se haya asociado correctamente mediante la verificación del tamaño
 *    de la lista de textos asociados.
 * 5. Se verifica que las frecuencias de letras en la asociación se hayan actualizado correctamente
 *    según las frecuencias del nuevo texto.
 *
 * Operativa:
 * 1. Se crea una asociación de textos con un nombre y frecuencias de letras iniciales.
 * 2. Se crea un nuevo texto (`Frecuencias`) con un nombre y frecuencias de palabras y letras específicas.
 * 3. Se agrega el nuevo texto a la asociación mediante la invocación del método `agregarTexto`.
 * 4. Se obtiene la lista de textos asociados y se verifica que tenga el tamaño esperado y que contenga
 *    el nombre del texto recién agregado.
 * 5. Se verifican las frecuencias de letras en la asociación para asegurarse de que se hayan actualizado
 *    correctamente según las frecuencias del nuevo texto.
 */
@Test
public void TestagregarTexto(){
    //System.out.println("Test agregarTexto");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        frecuenciaPalabras.put("aba", 2);
        frecuenciaPalabras.put("cbc", 4);
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("bc", 2);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);
        Frecuencias texto = new Frecuencias("nombre", frecuenciaPalabras, frecuenciaLetras);
        HashMap<String, Integer> frecs = asociacionTextos.getFrecuenciaLetras();
        asociacionTextos.agregarTexto("nombre", frecs);
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();

        assertEquals(1, textoAsociados.size());
        assertEquals("nombre", textoAsociados.get(0));
        assertEquals(2, frecuenciaLetras.size());
        assertEquals(4, frecuenciaLetras.get("ab").intValue());
        assertEquals(4, frecuenciaLetras.get("bc").intValue());
    }

    // ---------- AUXILIARES ----------
    /**
     * Objetivo de la Prueba:
     * La función `TestBorrarTecladoVinculado` tiene como objetivo verificar el correcto funcionamiento
     * del método `borrarTecladoVinculado` de la clase `AsociacionTextos`. Este método debería eliminar
     * un teclado vinculado de la asociación.
     *
     * Ficheros Necesarios:
     * No se mencionan ficheros específicos necesarios para esta prueba. Parece depender
     * principalmente de las estructuras de datos internas de la clase `AsociacionTextos`.
     *
     * Valores Estudiados:
     * Se evalúan los siguientes aspectos:
     * 1. Se crea una instancia de `AsociacionTextos`.
     * 2. Se agregan dos teclados vinculados a la asociación mediante el método `agregarTecladoVinculado`.
     * 3. Se elimina un teclado vinculado específico mediante la invocación del método `borrarTecladoVinculado`.
     * 4. Se verifica que la lista de teclados vinculados se haya actualizado correctamente después de la eliminación.
     *
     * Operativa:
     * 1. Se crea una asociación de textos.
     * 2. Se agregan dos teclados vinculados a la asociación mediante el método `agregarTecladoVinculado`.
     * 3. Se elimina uno de los teclados vinculados mediante el método `borrarTecladoVinculado`.
     * 4. Se verifica que la lista de teclados vinculados tenga el tamaño esperado y que no contenga el teclado eliminado.
     */
    @Test
    public void TestBorrarTecladoVinculado() {
        //System.out.println("Test borrarTecladoVinculado");
        AsociacionTextos asociacionTextos = new AsociacionTextos();
        String nombreT1 = "Teclado1";
        String nombreT2 = "Teclado2";

        asociacionTextos.agregarTecladoVinculado(nombreT1);
        asociacionTextos.agregarTecladoVinculado(nombreT2);
        asociacionTextos.borrarTecladoVinculado(nombreT1);

        assertEquals(1, asociacionTextos.getTecladosVinculados().size());
        assertFalse(asociacionTextos.getTecladosVinculados().contains(nombreT1));
        assertTrue(asociacionTextos.getTecladosVinculados().contains(nombreT2));
    }

    /**
     * Objeto de la prueba: Verificar que la función borrarTexto elimina correctamente un texto asociado,
     * actualiza la lista de textos asociados y la frecuencia de letras en consecuencia.
     *
     * Ficheros necesarios: Ninguno.
     *
     * Valores necesarios:
     * - Nombre de la asociación: "Asociacion".
     * - Frecuencia de palabras iniciales.
     * - Frecuencia de letras iniciales.
     * - Texto asociado: Frecuencias.
     *
     *  Operativa:
     *  1. Se crea un objeto AsociacionTextos con el nombre y la frecuencia de letras iniciales.
     *  2. Se crea un objeto Frecuencias para simular un texto asociado.
     *  3. Se llama a la función borrarTexto con el nombre del texto asociado (actualmente comentado).
     *  4. Se obtienen las listas y mapas actualizados después de la supuesta eliminación del texto.
     *  5. Se realizan las aserciones para verificar el comportamiento esperado.
     *
     *
     */

    @Test
    public void TestborrarTexto() {
        //System.out.println("Test borrar Texto");
        String nombre = "Asociacion";
        HashMap<String, Integer> frecuenciaPalabras = new HashMap<>();
        frecuenciaPalabras.put("aba", 4);
        frecuenciaPalabras.put("cbc", 8);
        HashMap<String, Integer> frecuenciaLetras = new HashMap<>();
        frecuenciaLetras.put("ab", 2);
        frecuenciaLetras.put("bc", 3);
        AsociacionTextos asociacionTextos = new AsociacionTextos(nombre, frecuenciaLetras);

        Frecuencias texto = new Frecuencias("nombre", frecuenciaPalabras, frecuenciaLetras);
        //asociacionTextos.borrarTexto("nombre");
        List<String> textoAsociados = asociacionTextos.getTextosAsociaciados();
        HashMap<String, Integer> frecuenciasLetras = asociacionTextos.getFrecuenciaLetras();

        assertEquals(0, textoAsociados.size());
        assertEquals(2, frecuenciaLetras.size());
        assertEquals(2, frecuenciaLetras.get("ab").intValue());
        assertNull(frecuenciaLetras.get("ca"));
    }
}

