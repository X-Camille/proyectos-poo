package org.vista;


import org.controller.CafeteriaController;
import org.model.Cafeteria;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIAgregarCafe extends JFrame {

    private final Cafeteria cafeteria;;
    private JTextField campoGramos;
    private JTextField campoMililitros;
    private JTextField campoTamano;
    private JTextField campoIngredientes;
    private JButton bNuevoCafe;
    private JButton bAgregarCafe;
    private JButton bVolver;
    private JPanel panelPrincipal;

    public GUIAgregarCafe(Cafeteria cafeteria){
        this.cafeteria = cafeteria;
    }
    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        configurarDimensionesCampos();
        crearPanelesCampos(panelPrincipal);
        deshabilitarCampos();
        establecerBotones(panelPrincipal);

        bNuevoCafe.addActionListener(e -> {
            limpiarCampos();
            habilitarCampos();
            bAgregarCafe.setEnabled(true);
        });

        bAgregarCafe.addActionListener(e -> {
            CafeteriaController controller = new CafeteriaController(this.cafeteria);
            boolean cafeAgregado = controller.recibirDatosCafe(obtenerDatosCafe());
            if (cafeAgregado) {
                limpiarCampos();
                deshabilitarCampos();
                bAgregarCafe.setEnabled(false);
                JOptionPane.showMessageDialog(this, "El café ha sido agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al agregar el café.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        bVolver.addActionListener(e -> {
            dispose();
            new GUICafeteria().mostrarInterfaz();
        });

        add(panelPrincipal);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void crearPanelesCampos(JPanel panelPrincipal) {
        JPanel panelGramosCafe = crearPanelCampo("Gramos de café:", campoGramos);
        panelPrincipal.add(panelGramosCafe);
        JPanel panelMililitrosAgua = crearPanelCampo("Mililitros de agua:", campoMililitros);
        panelPrincipal.add(panelMililitrosAgua);
        JPanel panelTamanoCafe = crearPanelCampo("Tamaño:", campoTamano);
        panelPrincipal.add(panelTamanoCafe);
        JPanel panelIngredientesCafe = crearPanelCampo("Ingredientes:", campoIngredientes);
        panelPrincipal.add(panelIngredientesCafe);
    }

    private void configurarDimensionesCampos() {
        campoGramos = new JTextField(20);
        campoMililitros = new JTextField(20);
        campoTamano = new JTextField(20);
        campoIngredientes = new JTextField(20);
    }

    private JPanel crearPanelPrincipal() {
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
        return panelPrincipal;
    }

    private JLabel crearLabelTitulo() {
        JLabel labelTitulo = new JLabel("AGREGAR CAFÉ");
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 14));
        labelTitulo.setBorder(new EmptyBorder(20, 0, 10, 0));
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        return labelTitulo;
    }

    private JPanel crearPanelCampo(String labelText, JTextField textField) {
        JPanel panelCampo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelCampo = new JLabel(labelText);
        panelCampo.add(labelCampo);
        panelCampo.add(textField);
        return panelCampo;
    }

    private void establecerBotones(JPanel panelPrincipal) {
        bNuevoCafe = crearBoton("Nuevo Café", new Color(0, 150, 0));
        bAgregarCafe = crearBoton("Agregar Café", new Color(255, 165, 0));
        bVolver = crearBoton("Volver al Inicio", new Color(250, 50, 50));
        JPanel panelBotones = crearPanelBotones(bNuevoCafe, bAgregarCafe, bVolver);
        bAgregarCafe.setEnabled(false);
        panelPrincipal.add(panelBotones);
    }


    private JButton crearBoton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(150, 40));
        return button;
    }

    private JPanel crearPanelBotones(JButton agregarButton, JButton editarButton, JButton bVolver) {
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotones.add(agregarButton);
        panelBotones.add(editarButton);
        panelBotones.add(bVolver);
        return panelBotones;
    }

    private void deshabilitarCampos() {
        campoGramos.setEnabled(false);
        campoMililitros.setEnabled(false);
        campoTamano.setEnabled(false);
        campoIngredientes.setEnabled(false);
    }

    private void habilitarCampos() {
        campoGramos.setEnabled(true);
        campoMililitros.setEnabled(true);
        campoTamano.setEnabled(true);
        campoIngredientes.setEnabled(true);
    }

    private void limpiarCampos() {
        campoGramos.setText("");
        campoMililitros.setText("");
        campoTamano.setText("");
        campoIngredientes.setText("");
    }

    private String[] obtenerDatosCafe() {
        String gramos = campoGramos.getText();
        String mililitros = campoMililitros.getText();
        String tamano = campoTamano.getText();
        String ingredientes = campoIngredientes.getText();
        return new String[]{gramos, mililitros, tamano, ingredientes};
    }

}