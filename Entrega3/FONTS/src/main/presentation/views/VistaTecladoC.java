package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Vista para consultar teclados existentes.
 * <p>
 * Esta vista permite al usuario seleccionar un teclado de una lista desplegable y visualizar su contenido y puntuación.
 * Proporciona una interfaz para la consulta de teclados, mostrando detalles relevantes como su composición y eficiencia.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 */
public class VistaTecladoC extends JFrame {

    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVistaTC = new JLabel("Consultar teclados");

    /** Etiqueta para el desplegable de nombres de teclados. */
    private final JLabel txtDesplegableTC = new JLabel("LISTA NOMBRES:");

    /** Desplegable que contiene los nombres de los teclados disponibles para consulta. */
    private JComboBox<String> nombresTC = new JComboBox<>();

    /** Botón para regresar al menú principal. */
    private final JButton bsalir = new JButton("Atrás");

    /** Etiqueta para el campo de nombre del teclado. */
    private final JLabel txtNombreTC = new JLabel("NOMBRE:");

    /** Area de texto que muestra el nombre del teclado seleccionado. */
    private final JTextArea areanomTC = new JTextArea();

    /** Etiqueta para el área de contenido del teclado. */
    private final JLabel txtContenidoTC = new JLabel("CONTENIDO:");

    /** Area de texto que muestra el contenido del teclado seleccionado. */
    private final JTextArea areacontenidoTC = new JTextArea();

    /** Etiqueta para mostrar la puntuación del teclado. */
    private final JLabel txtPuntuacionTC = new JLabel("PUNTUACIÓN:");

    /** Area de texto que muestra la puntuación del teclado seleccionado. */
    private final JTextArea areaPuntuacionTC = new JTextArea();

    /**
     * Constructor de la clase VistaTecladoC.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para seleccionar un teclado y visualizar sus detalles.
     */
    public VistaTecladoC() {
        setBounds(250, 150, 1000, 600);

        ArrayList<String> nombres = CtrlPresentacion.getListaTeclados();
        nombresTC = new JComboBox<>();
        nombresTC.addItem("");
        for (String nombre : nombres) {
            nombresTC.addItem(nombre);
        }

        // Título ventana superior
        tituloVistaTC.setBounds(10, 5, 120, 30);
        add(tituloVistaTC);

        txtDesplegableTC.setBounds(200, 120, 200, 20);
        add(txtDesplegableTC);

        nombresTC.setBounds(400, 120, 200, 20);
        add(nombresTC);

        //VENTANA SUPERIOR
        // Texto Nombre
        txtNombreTC.setBounds(200, 180, 200, 20);
        add(txtNombreTC);

        // Area texto Nombre
        areanomTC.setEditable(false);
        areanomTC.setBounds(400,180, 200,20);
        add(areanomTC);

        txtContenidoTC.setBounds(200, 220, 200, 20);
        add(txtContenidoTC);

        areacontenidoTC.setEditable(false); // Opcional, si no quieres que se pueda editar el contenido
        JScrollPane scrollPane = new JScrollPane(areacontenidoTC); // Para agregar scroll al área de texto
        scrollPane.setBounds(400, 220, 400, 150); // Ajusta las dimensiones según tus necesidades
        add(scrollPane);

        txtPuntuacionTC.setBounds(200, 400, 200, 20);
        add(txtPuntuacionTC);

        areaPuntuacionTC.setEditable(false);
        areaPuntuacionTC.setBounds(400,400, 200,20);
        add(areaPuntuacionTC);

        // Botón salir para ir a la pantalla principal
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener lElementoSeleccionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedName = (String) nombresTC.getSelectedItem();
                if (selectedName != null && !selectedName.isEmpty()) {
                    char[][] contenido = CtrlPresentacion.consultarContenidoTeclado(selectedName);
                    int puntuacion = CtrlPresentacion.consultarPuntuacionTeclado(selectedName);

                    areanomTC.setText(selectedName);
                    areacontenidoTC.setText(convertirContenidoAString(contenido));
                    areaPuntuacionTC.setText(String.valueOf(puntuacion));
                } else {
                    areanomTC.setText("");
                    areacontenidoTC.setText("");
                    areaPuntuacionTC.setText("");
                }
            }
        };

        ActionListener lSalir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.iniPresentacion();
                setVisible(false);
            }
        };

        nombresTC.addActionListener(lElementoSeleccionado);
        bsalir.addActionListener(lSalir);
    }

    /**
     * Convierte el contenido de un teclado (matriz de caracteres) en un string.
     * <p>
     * Utiliza un formato legible, colocando cada fila en una línea nueva.
     *
     * @param contenido Matriz de caracteres representando el contenido del teclado.
     * @return String representando el contenido del teclado.
     */
    private String convertirContenidoAString(char[][] contenido) {
        StringBuilder contenidoEnTexto = new StringBuilder();
        for (char[] fila : contenido) {
            for (char c : fila) {
                contenidoEnTexto.append(c).append(" ");
            }
            contenidoEnTexto.append("\n"); // Para una nueva línea después de cada fila
        }
        return contenidoEnTexto.toString();
    }
}
