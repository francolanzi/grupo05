
package GUI;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;

import trabajofinal.Asignatura;
import trabajofinal.Controlador;
import trabajofinal.IdInvalidoException;
import trabajofinal.ObserverTreeMap;

/**
 *
 * @author Usuario
 */
public class VAsignaturaModifica extends javax.swing.JFrame {
    private Controlador controlador;

    /** Creates new form VAsignaturaModifica */
    public VAsignaturaModifica(Asignatura asignatura) {
        initComponents();
        TLegajo.setText(asignatura.getId());
        TNombre.setText(asignatura.getNombre());
        // mostrar correlatividadestablaCorrelatividades.s
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        Cabecera = new javax.swing.JPanel();
        Asignatura = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Grilla = new javax.swing.JPanel();
        Legajo = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Correlatividades = new javax.swing.JLabel();
        TLegajo = new javax.swing.JTextField();
        TNombre = new javax.swing.JTextField();
        TCorrelatividades = new javax.swing.JScrollPane();
        tablaCorrelatividades = new javax.swing.JTable();
        Asignaturas = new javax.swing.JComboBox<>();
        AgregarCorrelativa = new javax.swing.JButton();
        Grabar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        quitarCorrelativa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignatura - Edici�n");
        setPreferredSize(new java.awt.Dimension(800, 600));

        Cabecera.setBackground(new java.awt.Color(204, 255, 255));
        Cabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        Asignatura.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Asignatura.setText("Asignatura -");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/aa0c19c7-d3a7-43d8-8664-2f08e5d0ca90.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Edici�n");

        javax.swing.GroupLayout CabeceraLayout = new javax.swing.GroupLayout(Cabecera);
        Cabecera.setLayout(CabeceraLayout);
        CabeceraLayout.setHorizontalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CabeceraLayout.setVerticalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Asignatura)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(Cabecera, java.awt.BorderLayout.PAGE_START);

        Grilla.setBackground(new java.awt.Color(105, 255, 204));

        Legajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Legajo.setText("Identificacion");

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nombre.setText("Nombre");

        Correlatividades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Correlatividades.setText("Correlativas");

        TLegajo.setEditable(false);
        TLegajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tablaCorrelatividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Identificador", "Nombre"
            }
        ));
        TCorrelatividades.setViewportView(tablaCorrelatividades);

        Asignaturas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Asignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignaturasActionPerformed(evt);
            }
        });

        AgregarCorrelativa.setText("Agregar");
        AgregarCorrelativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCorrelativaActionPerformed(evt);
            }
        });

        Grabar.setBackground(new java.awt.Color(0, 153, 153));
        Grabar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Grabar.setText("GRABAR");
        Grabar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GrabarActionPerformed(evt);
            }
        });

        Cancelar.setBackground(new java.awt.Color(0, 153, 153));
        Cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Cancelar.setText("CANCELAR");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });

        quitarCorrelativa.setText("Quitar");
        quitarCorrelativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarCorrelativaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GrillaLayout = new javax.swing.GroupLayout(Grilla);
        Grilla.setLayout(GrillaLayout);
        GrillaLayout.setHorizontalGroup(
            GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrillaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(Cancelar))
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Legajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Correlatividades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TCorrelatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TLegajo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Asignaturas, javax.swing.GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(AgregarCorrelativa)))))
                .addGap(18, 18, 18)
                .addComponent(quitarCorrelativa)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        GrillaLayout.setVerticalGroup(
            GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrillaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Legajo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(TNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarCorrelativa)
                    .addComponent(Asignaturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Correlatividades))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TCorrelatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitarCorrelativa))
                .addGap(52, 52, 52)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(Grilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void AsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignaturasActionPerformed
        TreeMap<String,Asignatura> asignaturas= controlador.getAsignaturas();
        Iterator itr= asignaturas.entrySet().iterator();
        while (itr.hasNext()){
            Asignatura e = (Asignatura)itr.next();
            Asignaturas.addItem(e.getNombre());
        }
    }//GEN-LAST:event_AsignaturasActionPerformed

    private void AgregarCorrelativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCorrelativaActionPerformed
        //String[] dato={controlador.ubicaAsignatura(nombre) ,Asignaturas.getSelectedItem().toString()};
        //agregar a la tabla
    }//GEN-LAST:event_AgregarCorrelativaActionPerformed

    private void GrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GrabarActionPerformed
        if (TNombre.getText().equals(""))
        JOptionPane.showMessageDialog(null,"Ingrese nombre de la Asignatura");
        try {
            controlador.modificaAsignatura(TLegajo.getText(), TNombre.getText());
        } catch (IdInvalidoException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_GrabarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
        VentanaIndex principal= new VentanaIndex();
        principal.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void quitarCorrelativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarCorrelativaActionPerformed
        try {
            controlador.removeCorrelativa(TLegajo.getText(),
                                          tablaCorrelatividades.getValueAt(tablaCorrelatividades.getSelectedRow(), 0)
                                          .toString());
        } catch (IdInvalidoException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_quitarCorrelativaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCorrelativa;
    private javax.swing.JLabel Asignatura;
    private javax.swing.JComboBox<String> Asignaturas;
    private javax.swing.JPanel Cabecera;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Correlatividades;
    private javax.swing.JButton Grabar;
    private javax.swing.JPanel Grilla;
    private javax.swing.JLabel Legajo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JScrollPane TCorrelatividades;
    private javax.swing.JTextField TLegajo;
    private javax.swing.JTextField TNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton quitarCorrelativa;
    private javax.swing.JTable tablaCorrelatividades;
    // End of variables declaration//GEN-END:variables

}
