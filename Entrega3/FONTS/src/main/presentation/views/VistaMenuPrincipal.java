package main.presentation.views;

import main.presentation.controllers.CtrlPresentacion;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Vista principal del generador de teclados PROP.
 * <p>
 * Esta vista sirve como menú principal de la aplicación y ofrece opciones para gestionar alfabetos, textos,
 * asociaciones de textos y teclados. Proporciona accesos directos a las funcionalidades de agregar, eliminar,
 * consultar y modificar cada uno de estos elementos.
 * Además, incluye un botón para acceder al manual de usuario y otro para salir de la aplicación.
 * @author Oriol Ramos Puig (oriol.ramos.puig@estudiantat.upc.edu)
 * @author Alexia Mayor (alexia.mayor@estudiantat.upc.edu)
 */
public class VistaMenuPrincipal extends JFrame {

    /** Panel principal que contiene todos los componentes de la interfaz. */
    private final JPanel lamina = new JPanel();

    /** Título de la ventana. */
    private final JLabel tituloVista = new JLabel("Generador de teclados PROP");

    // Menús emergentes para las opciones de cada categoría
    private JPopupMenu popupMenuA = new JPopupMenu();
    private JPopupMenu popupMenuTxt = new JPopupMenu();
    private JPopupMenu popupMenuAT = new JPopupMenu();
    private JPopupMenu popupMenuT = new JPopupMenu();

    // Opciones para el menú de Alfabeto
    private JMenuItem agregarA = new JMenuItem("Agrega");
    private JMenuItem borrarA = new JMenuItem("Elimina");
    private JMenuItem consultarA = new JMenuItem("Consulta");
    private JMenuItem modificarA = new JMenuItem("Modifica");

    // Opciones para el menú de Texto
    private JMenuItem agregarTxt = new JMenuItem("Agrega");
    private JMenuItem borrarTxt = new JMenuItem("Elimina");
    private JMenuItem consultarTxt = new JMenuItem("Consulta");
    private JMenuItem modificarTxt = new JMenuItem("Modifica");

    // Opciones para el menú de Asociación
    private JMenuItem agregarAT = new JMenuItem("Agrega");
    private JMenuItem borrarAT = new JMenuItem("Elimina");
    private JMenuItem consultarAT = new JMenuItem("Consulta");
    private JMenuItem modificarAT = new JMenuItem("Modifica");

    // Opciones para el menú de Teclado
    private JMenuItem agregarT = new JMenuItem("Agrega");
    private JMenuItem borrarT = new JMenuItem("Elimina");
    private JMenuItem consultarT = new JMenuItem("Consulta");
    private JMenuItem modificarT = new JMenuItem("Modifica");

    /** Botón para salir de la aplicación. */
    private JButton bsalir = new JButton("Salir");

    // Botones para mostrar los menús de cada categoría
    private JButton bAlfabeto = new JButton("Alfabeto");
    private JButton bTexto = new JButton("Texto");
    private JButton bAsociacion = new JButton("Asociación de Textos");
    private JButton bTeclado = new JButton("Teclado");

    /** Botón para acceder al manual de usuario. */
    private JButton manual = new JButton("Manual de usuario");

    /**
     * Constructor de la clase VistaMenuPrincipal.
     * <p>
     * Inicializa los componentes de la interfaz de usuario y configura los oyentes de eventos
     * para la navegación entre las diferentes vistas de la aplicación.
     * Ofrece una interfaz clara y fácil de usar para acceder a las principales funcionalidades del generador de teclados.
     */
    public VistaMenuPrincipal() {
        setBounds(250, 150, 1000, 600);
        setResizable(true);
        setTitle("Generador de teclados PROP");

        popupMenuA.add(agregarA);
        popupMenuA.add(borrarA);
        popupMenuA.add(consultarA);
        popupMenuA.add(modificarA);

        popupMenuTxt.add(agregarTxt);
        popupMenuTxt.add(borrarTxt);
        popupMenuTxt.add(consultarTxt);
        popupMenuTxt.add(modificarTxt);

        popupMenuAT.add(agregarAT);
        popupMenuAT.add(borrarAT);
        popupMenuAT.add(consultarAT);
        popupMenuAT.add(modificarAT);

        popupMenuT.add(agregarT);
        popupMenuT.add(borrarT);
        popupMenuT.add(consultarT);
        popupMenuT.add(modificarT);

        // Configurar botones y sus posiciones
        bAlfabeto.setBounds(400, 50, 200, 20);
        bTexto.setBounds(400, 150, 200, 20);
        bAsociacion.setBounds(400, 250, 200, 20);
        bTeclado.setBounds(400, 350, 200, 20);
        manual.setBounds(400, 450, 200, 20);

        // Añadir botones a la ventana
        add(bAlfabeto);
        add(bTexto);
        add(bAsociacion);
        add(bTeclado);
        add(manual);

        // Título de la ventana
        tituloVista.setBounds(40, 20, 200, 30);
        add(tituloVista);

        // Botón salir
        bsalir.setBounds(800, 500, 100, 20);
        add(bsalir);

        add(lamina);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //FUNCIONES AGREGAR
        ActionListener lAgregarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoA();
                setVisible(false);
            }
        };

        ActionListener lAgregarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoA();
                setVisible(false);
            }
        };

        ActionListener lAgregarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosA();
                setVisible(false);
            }
        };

        ActionListener lAgregarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoA();
                setVisible(false);
            }
        };

        //FUNCIONES ELIMINAR
        ActionListener lEliminarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoB();
                setVisible(false);
            }
        };
        ActionListener lEliminarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoB();
                setVisible(false);
            }
        };

        ActionListener lEliminarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosB();
                setVisible(false);
            }
        };

        ActionListener lEliminarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoB();
                setVisible(false);
            }
        };

        //FUNCIONES CONSULTAR
        ActionListener lConsultarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoC();
                setVisible(false);
            }
        };
        ActionListener lConsultarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoC();
                setVisible(false);
            }
        };
        ActionListener lConsultarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosC();
                setVisible(false);
            }
        };
        ActionListener lConsultarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoC();
                setVisible(false);
            }
        };

        //FUNCIONES MODIFICAR
        ActionListener lModificarA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAlfabetoM();
                setVisible(false);
            }
        };

        ActionListener lModificarTxt = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTextoM();
                setVisible(false);
            }
        };

        ActionListener lModificarAT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaAsociacionTextosM();
                setVisible(false);
            }
        };

        ActionListener lModificarT = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CtrlPresentacion.vistaTecladoM();
                setVisible(false);
            }
        };

        ActionListener lManual = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    if (desktop.isSupported(Desktop.Action.BROWSE)) {
                        try {
                            desktop.browse(new URI("https://drive.google.com/file/d/1PRl1br-yj1iCE6h0-hjQ_RdVbkDyFDH-/view?usp=sharing"));
                        } catch (IOException | URISyntaxException ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(null, "No se pudo abrir el manual de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La función de navegación no es compatible con esta plataforma.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El soporte de escritorio no está disponible en esta plataforma.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        };


        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        bAlfabeto.addActionListener(e -> popupMenuA.show(bAlfabeto, 0, bAlfabeto.getHeight()));
        bTexto.addActionListener(e -> popupMenuTxt.show(bTexto, 0, bTexto.getHeight()));
        bAsociacion.addActionListener(e -> popupMenuAT.show(bAsociacion, 0, bAsociacion.getHeight()));
        bTeclado.addActionListener(e -> popupMenuT.show(bTeclado, 0, bTeclado.getHeight()));

        bsalir.addActionListener(salir);
        manual.addActionListener(lManual);

        agregarA.addActionListener(lAgregarA);
        borrarA.addActionListener(lEliminarA);
        consultarA.addActionListener(lConsultarA);
        modificarA.addActionListener(lModificarA);

        agregarTxt.addActionListener(lAgregarTxt);
        borrarTxt.addActionListener(lEliminarTxt);
        consultarTxt.addActionListener(lConsultarTxt);
        modificarTxt.addActionListener(lModificarTxt);

        agregarAT.addActionListener(lAgregarAT);
        borrarAT.addActionListener(lEliminarAT);
        consultarAT.addActionListener(lConsultarAT);
        modificarAT.addActionListener(lModificarAT);

        agregarT.addActionListener(lAgregarT);
        borrarT.addActionListener(lEliminarT);
        consultarT.addActionListener(lConsultarT);
        modificarT.addActionListener(lModificarT);
    }


}
