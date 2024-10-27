package org.vista;


import org.data.GestorDatos;
import org.model.Cafeteria;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUIEditarInformacion extends JFrame {

    private final Cafeteria cafeteria;;
    private JTextField campoNombre;
    private JTextField campoDireccion;
    private JTextField campoRedesSociales;
    private JButton bEditarInformacion;
    private JButton bGuardar;
    private JButton bVolver;
    private JPanel panelPrincipal;

    public GUIEditarInformacion(Cafeteria cafeteria){
        this.cafeteria = cafeteria;
    }
    public void mostrarInterfaz() {
        panelPrincipal = crearPanelPrincipal();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel labelTitulo = crearLabelTitulo();
        panelPrincipal.add(labelTitulo);
        configurarDimensionesCampos();
        crearPanelesCampos(panelPrincipal);
        establecerBotones(panelPrincipal);

        campoNombre.setText(cafeteria.getNombre());
        campoDireccion.setText(cafeteria.getDireccion());
        campoRedesSociales.setText(cafeteria.getRedesSociales());
        deshabilitarCampos();
        bGuardar.setEnabled(false);

        bEditarInformacion.addActionListener(e -> {
            bEditarInformacion.setEnabled(false);
            habilitarCampos();
            bGuardar.setEnabled(true);
        });

        bGuardar.addActionListener(e -> {
            cafeteria.setNombre(campoNombre.getText());
            cafeteria.setDireccion(campoDireccion.getText());
            cafeteria.setRedesSociales(campoRedesSociales.getText());
            bGuardar.setEnabled(false);
            bEditarInformacion.setEnabled(true);
            deshabilitarCampos();
            GestorDatos file = new GestorDatos();
            boolean guardadoConExito = file.reescribirDatosCafeteria(cafeteria, "C:/Users/Lenovo/Desktop/cafeteria.txt");
            if (guardadoConExito) {
                JOptionPane.showMessageDialog(this, "La información ha sido actualizada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al actualizar la información.", "Error", JOptionPane.ERROR_MESSAGE);
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
        JPanel panelNombre= crearPanelCampo("Nombre:", campoNombre);
        panelPrincipal.add(panelNombre);
        JPanel panelDireccion = crearPanelCampo("Dirección:", campoDireccion);
        panelPrincipal.add(panelDireccion);
        JPanel panelRedesSociales= crearPanelCampo("Redes Sociales:", campoRedesSociales);
        panelPrincipal.add(panelRedesSociales);
    }

    private void configurarDimensionesCampos() {
        campoNombre = new JTextField(20);
        campoDireccion = new JTextField(20);
        campoRedesSociales = new JTextField(20);
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
        bEditarInformacion = crearBoton("Editar información", new Color(0, 150, 0));
        bGuardar = crearBoton("Guardar", new Color(255, 165, 0));
        bVolver = crearBoton("Volver al Inicio", new Color(250, 50, 50));
        JPanel panelBotones = crearPanelBotones(bEditarInformacion, bGuardar, bVolver);
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
        campoNombre.setEnabled(false);
        campoDireccion.setEnabled(false);
        campoRedesSociales.setEnabled(false);
    }

    private void habilitarCampos() {
        campoNombre.setEnabled(true);
        campoDireccion.setEnabled(true);
        campoRedesSociales.setEnabled(true);
    }

    private void limpiarCampos() {
        campoNombre.setText("");
        campoDireccion.setText("");
        campoRedesSociales.setText("");
    }

    private String[] obtenerDatosCafe() {
        String gramos = campoNombre.getText();
        String mililitros = campoDireccion.getText();
        String tamano = campoRedesSociales.getText();
        return new String[]{gramos, mililitros, tamano};
    }
}