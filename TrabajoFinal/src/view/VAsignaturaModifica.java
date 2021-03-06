
package view;

import java.util.Iterator;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import model.Asignatura;
import model.Controlador;
import model.EntidadInvalidaException;
import model.IdInvalidoException;

@SuppressWarnings("serial")
public class VAsignaturaModifica extends javax.swing.JFrame
{
    
    private static VAsignaturaModifica ventanaAsignaturaModifica = null;


    /** Creates new form VAsignaturaModifica */
    private VAsignaturaModifica()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
    }

    public static VAsignaturaModifica getInstance(Asignatura asignatura)
    {
        if (ventanaAsignaturaModifica == null)
            ventanaAsignaturaModifica = new VAsignaturaModifica();
        ventanaAsignaturaModifica.setComponentes(asignatura);
        return ventanaAsignaturaModifica;
    }

    public void setComponentes(Asignatura asignatura)
    {
        this.addWindowListener(WindowSerializador.getInstance());
        jTextFieldIdentificador.setText(asignatura.getId());
        jTextFieldNombre.setText(asignatura.getNombre());
        setTablaCorrelativas(asignatura);
        cargaCorrelativas();
    }

    private void setTablaCorrelativas(Asignatura asignatura)
    {
        DefaultTableModel model = (DefaultTableModel) jTableCorrelativas.getModel();
        model.setRowCount(0);
        Iterator<Asignatura> correlativas = asignatura.getCorrelativasIterator();
        while (correlativas.hasNext())
        {
            Asignatura correlativa = correlativas.next();
            model.addRow(new Object[] { correlativa.getId(), correlativa.getNombre() });
        }
    }

    private void cargaCorrelativas()
    {
        jComboCorrelativa.removeAllItems();
        Iterator<Asignatura> asignaturas = Controlador.getInstance().getAsignaturasIterator();
        while (asignaturas.hasNext())
        {
            Asignatura asignatura = asignaturas.next();
            ComboItem item = new ComboItem(asignatura.getId(), asignatura.getNombre());
            jComboCorrelativa.addItem(item);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelCabecera = new javax.swing.JPanel();
        jLabelAsignatura = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEdicion = new javax.swing.JLabel();
        jPanelGrilla = new javax.swing.JPanel();
        jLabelLegajo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelCorrelatividades = new javax.swing.JLabel();
        jTextFieldIdentificador = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jScrollPaneCorrelatividades = new javax.swing.JScrollPane();
        jTableCorrelativas = new javax.swing.JTable();
        jComboCorrelativa = new javax.swing.JComboBox<>();
        jButtonAgregarCorrelativa = new javax.swing.JButton();
        jButtonGrabar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonQuitarCorrelativa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Asignatura - Edici�n");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelCabecera.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelAsignatura.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelAsignatura.setText("Asignatura -");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/pga.png")));

        jLabelEdicion.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabelEdicion.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEdicion.setText("Edicion");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAsignatura)
                    .addComponent(jLabelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelCabecera, java.awt.BorderLayout.PAGE_START);

        jPanelGrilla.setBackground(new java.awt.Color(105, 255, 204));

        jLabelLegajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLegajo.setText("Identificacion");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelCorrelatividades.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCorrelatividades.setText("Correlativas");

        jTextFieldIdentificador.setEditable(false);
        jTextFieldIdentificador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldIdentificador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIdentificadorActionPerformed(evt);
            }
        });

        jTableCorrelativas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneCorrelatividades.setViewportView(jTableCorrelativas);
        if (jTableCorrelativas.getColumnModel().getColumnCount() > 0) {
            jTableCorrelativas.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            jTableCorrelativas.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        jComboCorrelativa.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        jComboCorrelativa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboCorrelativaMouseClicked(evt);
            }
        });
        jComboCorrelativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboCorrelativaActionPerformed(evt);
            }
        });

        jButtonAgregarCorrelativa.setText("Agregar");
        jButtonAgregarCorrelativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCorrelativaActionPerformed(evt);
            }
        });

        jButtonGrabar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGrabar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGrabar.setText("GRABAR");
        jButtonGrabar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGrabarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonQuitarCorrelativa.setText("Quitar");
        jButtonQuitarCorrelativa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarCorrelativaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGrillaLayout = new javax.swing.GroupLayout(jPanelGrilla);
        jPanelGrilla.setLayout(jPanelGrillaLayout);
        jPanelGrillaLayout.setHorizontalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                        .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonCancelar))
                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelLegajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelCorrelatividades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneCorrelatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboCorrelativa, javax.swing.GroupLayout.Alignment.LEADING, 0, 125, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregarCorrelativa)))))
                .addGap(18, 18, 18)
                .addComponent(jButtonQuitarCorrelativa)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelGrillaLayout.setVerticalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregarCorrelativa)
                    .addComponent(jComboCorrelativa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCorrelatividades))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneCorrelatividades, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuitarCorrelativa))
                .addGap(52, 52, 52)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGrilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jComboCorrelativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCorrelativaActionPerformed

    }//GEN-LAST:event_jComboCorrelativaActionPerformed

    private void jButtonAgregarCorrelativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCorrelativaActionPerformed
        if (jComboCorrelativa.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) jTableCorrelativas.getModel();
            ComboItem item = (ComboItem) jComboCorrelativa.getSelectedItem();
            try
            {
                Controlador.getInstance().addCorrelativa(jTextFieldIdentificador.getText(), item.getId());
                Asignatura correlativa = Controlador.getInstance().consultaAsignatura(item.getId());
                model.addRow(new Object[] { correlativa.getId(), correlativa.getNombre() });
            }
            catch (IdInvalidoException | EntidadInvalidaException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonAgregarCorrelativaActionPerformed

    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
        if (jTextFieldNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese nombre de la Asignatura");
        else
        {
            try
            {
                Controlador.getInstance()
                    .modificaAsignatura(jTextFieldIdentificador.getText(), jTextFieldNombre.getText());
                JOptionPane.showMessageDialog(null, "La asignatura ha sido modificada exitosamente");
                VentanaIndex.getInstancia().setVisible(true);
                this.setVisible(false);
            }
            catch (IdInvalidoException e)
            {
                e.getMessage();
            }
        }
    }//GEN-LAST:event_jButtonGrabarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        VentanaIndex.getInstancia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonQuitarCorrelativaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarCorrelativaActionPerformed
        if (jTableCorrelativas.getSelectedRows().length == 1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableCorrelativas.getModel();
            try
            {
                Controlador.getInstance()
                    .removeCorrelativa(jTextFieldIdentificador.getText(),
                                       (String) jTableCorrelativas.getValueAt(jTableCorrelativas.getSelectedRow(), 0));
                model.removeRow(jTableCorrelativas.getSelectedRow());
            }
            catch (IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonQuitarCorrelativaActionPerformed

    private void jComboCorrelativaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboCorrelativaMouseClicked
        
    }//GEN-LAST:event_jComboCorrelativaMouseClicked

    private void jTextFieldIdentificadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIdentificadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIdentificadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCorrelativa;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGrabar;
    private javax.swing.JButton jButtonQuitarCorrelativa;
    private javax.swing.JComboBox<ComboItem> jComboCorrelativa;
    private javax.swing.JLabel jLabelAsignatura;
    private javax.swing.JLabel jLabelCorrelatividades;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelLegajo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelGrilla;
    private javax.swing.JScrollPane jScrollPaneCorrelatividades;
    private javax.swing.JTable jTableCorrelativas;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables

}
