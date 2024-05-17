package inscribir_materias.Ventanas;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lista_Materias extends javax.swing.JFrame {

    private JTextArea textAreaMaterias;

    public Lista_Materias() {
        initComponents();
        mostrarMaterias();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        LabelLista_Materias = new javax.swing.JLabel();
        JScrollPane scrollPane = new JScrollPane();
        textAreaMaterias = new JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        LabelLista_Materias.setText("LISTA DE MATERIAS");

        textAreaMaterias.setColumns(20);
        textAreaMaterias.setRows(5);
        scrollPane.setViewportView(textAreaMaterias);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(LabelLista_Materias)
                .addGap(155, 155, 155))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LabelLista_Materias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void mostrarMaterias() {
        String rutaArchivo = "datos_materias.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                textAreaMaterias.append(linea + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            textAreaMaterias.append("No se pudo leer el archivo de materias.\n");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Lista_Materias().setVisible(true);
        });
    }

    private javax.swing.JLabel LabelLista_Materias;
    private javax.swing.JPanel jPanel1;
}
