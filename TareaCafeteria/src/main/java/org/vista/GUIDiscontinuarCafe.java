package org.vista;

import org.model.Cafe;
import org.model.Cafeteria;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUIDiscontinuarCafe extends JFrame {

    private Cafeteria cafeteria;
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField campoBusqueda;

    public GUIDiscontinuarCafe(Cafeteria cafeteria) {
        this.cafeteria = cafeteria;
        setTitle("Seleccione el café a discontinuar (búsqueda por tamaño):");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel labelBuscador = new JLabel("Buscador:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelBuscador, gbc);

        campoBusqueda = new JTextField();
        campoBusqueda.setPreferredSize(new Dimension(200, campoBusqueda.getPreferredSize().height)); // Establecer un ancho prefijado
        campoBusqueda.setMinimumSize(new Dimension(200, campoBusqueda.getPreferredSize().height)); // Establecer un tamaño mínimo
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(campoBusqueda, gbc);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String busqueda = campoBusqueda.getText();
                ArrayList<Cafe> cafes = cafeteria.buscarCafesPorTamano(busqueda);
                llenarTablaConDatos(cafes);
            }
        });
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botonBuscar, gbc);

        // Configuración de la tabla para mostrar resultados
        JButton botonDiscontinuar = new JButton("Discontinuar Café");
        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(scrollPane, gbc);

        // Botón para volver al menú de inicio
        JButton botonVolver = new JButton("Volver al menú de inicio");
        botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra esta ventana
                new GUICafeteria().mostrarInterfaz();
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    boolean filaSeleccionada = table.getSelectedRow() != -1;
                    botonDiscontinuar.setEnabled(filaSeleccionada);
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botonVolver, gbc);

        getContentPane().add(panel);
        setLocationRelativeTo(null);
        setVisible(true);

        botonDiscontinuar.setEnabled(false); // Inicialmente deshabilitado
        botonDiscontinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = table.getSelectedRow();
                if (filaSeleccionada != -1) {
                    Cafe cafeSeleccionado = cafeteria.getCafes().get(filaSeleccionada);

                    // Llamar al método discontinuarCafe de Cafeteria para eliminar el café seleccionado
                    cafeteria.discontinuarCafe(cafeSeleccionado);

                    // Refrescar la tabla después de eliminar el café
                    llenarTablaConDatos(cafeteria.getCafes());
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(botonDiscontinuar, gbc);
    }

    private void llenarTablaConDatos(ArrayList<Cafe> cafes) {
        String[] columnas = {"Gramos", "Mililitros", "Tamaño", "Ingredientes"};
        Object[][] datos = new Object[cafes.size()][columnas.length];

        for (int i = 0; i < cafes.size(); i++) {
            Cafe cafe = cafes.get(i);
            datos[i][0] = cafe.getGramosCafe();
            datos[i][1] = cafe.getMililitrosAgua();
            datos[i][2] = cafe.getTamano();
            datos[i][3] = cafe.getIngredientes();
        }

        tableModel.setDataVector(datos, columnas);
    }

}