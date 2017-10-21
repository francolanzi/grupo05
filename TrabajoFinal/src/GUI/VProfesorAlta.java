
package GUI;

import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import trabajofinal.Alumno;
import trabajofinal.Asignatura;
import trabajofinal.Controlador;
import trabajofinal.EmailInvalidoException;
import trabajofinal.EntidadInvalidaException;
import trabajofinal.IdInvalidoException;
import trabajofinal.Mascaras;
import trabajofinal.Profesor;

/**
 *
 * @author Usuario
 */
public class VProfesorAlta extends javax.swing.JFrame {
    Controlador controlador;
    DefaultTableModel modelo= new DefaultTableModel();
    String[] col={"Identificador","Nombre"};
    DefaultComboBoxModel combo= new DefaultComboBoxModel();


    /** Creates new form Profesor */
    public VProfesorAlta() {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
        vaciaCampos();
    }
    
    private void vaciaCampos()
    {
        TLegajo.setText(Mascaras.genId(Profesor.getSigLegajo(), Profesor.prefijo));
        TNombre.setText("");
        TApellido.setText("");
        TCalle.setText("");
        TNumero.setText("");
        TTelefono.setText("");
        TEmail.setText("");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        Cabecera = new javax.swing.JPanel();
        lProfesor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Grilla = new javax.swing.JPanel();
        Legajo = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Apellido = new javax.swing.JLabel();
        Calle = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Historia = new javax.swing.JLabel();
        TLegajo = new javax.swing.JTextField();
        TNombre = new javax.swing.JTextField();
        TApellido = new javax.swing.JTextField();
        TCalle = new javax.swing.JTextField();
        TEmail = new javax.swing.JTextField();
        Numero = new javax.swing.JLabel();
        TNumero = new javax.swing.JTextField();
        THistoria = new javax.swing.JScrollPane();
        tablaCompetencias = new javax.swing.JTable();
        Asignatura = new javax.swing.JComboBox<>();
        AgregarCompetencia = new javax.swing.JButton();
        Telefono = new javax.swing.JLabel();
        TTelefono = new javax.swing.JTextField();
        Grabar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        quitarCompetencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profesor - Nuevo");

        Cabecera.setBackground(new java.awt.Color(204, 255, 255));
        Cabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        lProfesor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lProfesor.setText("Profesor -");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/aa0c19c7-d3a7-43d8-8664-2f08e5d0ca90.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nuevo");

        javax.swing.GroupLayout CabeceraLayout = new javax.swing.GroupLayout(Cabecera);
        Cabecera.setLayout(CabeceraLayout);
        CabeceraLayout.setHorizontalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CabeceraLayout.setVerticalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lProfesor)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(Cabecera, java.awt.BorderLayout.PAGE_START);

        Grilla.setBackground(new java.awt.Color(105, 255, 204));
        Grilla.setPreferredSize(new java.awt.Dimension(638, 618));
        Grilla.setVerifyInputWhenFocusTarget(false);

        Legajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Legajo.setText("Legajo");

        Nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Nombre.setText("Nombre");

        Apellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Apellido.setText("Apellido");

        Calle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Calle.setText("Calle");

        Email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Email.setText("Email");

        Historia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Historia.setText("Competencias");

        TLegajo.setEditable(false);
        TLegajo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TLegajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNombreKeyTyped(evt);
            }
        });

        TApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TApellidoKeyTyped(evt);
            }
        });

        Numero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Numero.setText("N�mero");

        TNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNumeroActionPerformed(evt);
            }
        });
        TNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TNumeroKeyTyped(evt);
            }
        });

        tablaCompetencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificador", "Nombre"
            }
        ));
        THistoria.setViewportView(tablaCompetencias);
        if (tablaCompetencias.getColumnModel().getColumnCount() > 0) {
            tablaCompetencias.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            tablaCompetencias.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        Asignatura.setModel(combo);
        Asignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsignaturaActionPerformed(evt);
            }
        });

        AgregarCompetencia.setText("Agregar");
        AgregarCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarCompetenciaActionPerformed(evt);
            }
        });

        Telefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Telefono.setText("Tel�fono");

        TTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TTelefonoKeyTyped(evt);
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

        quitarCompetencia.setText("Quitar");
        quitarCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarCompetenciaActionPerformed(evt);
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
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Calle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Legajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Nombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Telefono)
                            .addComponent(Historia))
                        .addGap(24, 24, 24)
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(THistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addComponent(Asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AgregarCompetencia))
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(TCalle)
                                    .addComponent(TNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TLegajo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(21, 21, 21)
                                .addComponent(Numero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cancelar)
                    .addComponent(quitarCompetencia))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addGap(13, 13, 13)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Apellido)
                    .addComponent(TApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Calle)
                    .addComponent(TCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Numero)
                    .addComponent(TNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Telefono)
                    .addComponent(TTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AgregarCompetencia)
                    .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Asignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Historia)))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addComponent(THistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(quitarCompetencia))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        getContentPane().add(Grilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void TNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNumeroActionPerformed

    private void AsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsignaturaActionPerformed
        Iterator it =controlador.getAsignaturas().values().iterator();
        while (it.hasNext()){
            Asignatura asi= (Asignatura)it.next();
            Asignatura.addItem(asi.getNombre());
        if (Asignatura.getItemCount() >1)
            Asignatura.setEditable(true);
        else
            Asignatura.setEditable(false);
        }
    }//GEN-LAST:event_AsignaturaActionPerformed

    private void AgregarCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarCompetenciaActionPerformed
        Asignatura asi;
        try {
            asi = (Asignatura) controlador.consultaAsignatura(Asignatura.getSelectedItem().toString());
            controlador.addCompetencia(TLegajo.getText().toString(), asi.getId());
            String []dato= {asi.getId(),asi.getNombre()};
            modelo.addRow(dato);
        } catch (IdInvalidoException e) {
            e.getMessage();
        } catch (EntidadInvalidaException e) {
            e.getMessage();
        }     
    }//GEN-LAST:event_AgregarCompetenciaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
        VentanaIndex principal= new VentanaIndex();
        principal.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void TNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNombreKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_TNombreKeyTyped

    private void TApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TApellidoKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_TApellidoKeyTyped

    private void TNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNumeroKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (!Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_TNumeroKeyTyped

    private void TTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TTelefonoKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (!Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_TTelefonoKeyTyped

    private void quitarCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarCompetenciaActionPerformed
        if(tablaCompetencias.getSelectedRows().length ==1){
            try {
                controlador.removeCompetencia(TLegajo.getText(),
                                              tablaCompetencias.getValueAt(tablaCompetencias.getSelectedRow(), 0)
                                              .toString());
                modelo.removeRow(tablaCompetencias.getSelectedRow());
            } catch (IdInvalidoException e) {
                e.getMessage();
            }
        }
    }//GEN-LAST:event_quitarCompetenciaActionPerformed

    private void GrabarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GrabarActionPerformed
    {//GEN-HEADEREND:event_GrabarActionPerformed
        if (TNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Nombre");
        else if (TApellido.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Apellido");
        else if (TCalle.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Calle");
        else if (TNumero.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Numero");
        else if (TTelefono.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Telefono");
        else if (TEmail.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Mail");
        else
        {
            try
            {
                Controlador.getInstance().altaProfesor(TApellido.getText(), TNombre.getText(), TCalle.getText(),
                    Integer.parseInt(TNumero.getText()), TTelefono.getText(), TEmail.getText());
                vaciaCampos();
                JOptionPane.showMessageDialog(null, "El profesor ha sido dado de alta exitosamente");
            }
            catch (EmailInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_GrabarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing
                                                                   .UIManager
                                                                   .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VProfesorAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VProfesorAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VProfesorAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VProfesorAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt
            .EventQueue
            .invokeLater(new Runnable() {
                public void run() {
                    new VProfesorAlta().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarCompetencia;
    private javax.swing.JLabel Apellido;
    private javax.swing.JComboBox<String> Asignatura;
    private javax.swing.JPanel Cabecera;
    private javax.swing.JLabel Calle;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Email;
    private javax.swing.JButton Grabar;
    private javax.swing.JPanel Grilla;
    private javax.swing.JLabel Historia;
    private javax.swing.JLabel Legajo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Numero;
    private javax.swing.JTextField TApellido;
    private javax.swing.JTextField TCalle;
    private javax.swing.JTextField TEmail;
    private javax.swing.JScrollPane THistoria;
    private javax.swing.JTextField TLegajo;
    private javax.swing.JTextField TNombre;
    private javax.swing.JTextField TNumero;
    private javax.swing.JTextField TTelefono;
    private javax.swing.JLabel Telefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lProfesor;
    private javax.swing.JButton quitarCompetencia;
    private javax.swing.JTable tablaCompetencias;
    // End of variables declaration//GEN-END:variables

}
