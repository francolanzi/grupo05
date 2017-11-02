
package GUI;

import java.util.Iterator;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

import trabajofinal.Alumno;
import trabajofinal.Asignatura;
import trabajofinal.Controlador;
import trabajofinal.Cursada;
import trabajofinal.EmailInvalidoException;
import trabajofinal.EntidadInvalidaException;
import trabajofinal.HorarioNoViableException;
import trabajofinal.IdInvalidoException;
import trabajofinal.IdInvalidoException;
import trabajofinal.Profesor;

public class VAlumnoModifica extends javax.swing.JFrame
{
    
    private static VAlumnoModifica ventanaAlumnoModifica = null;

    /** Creates new form AltaAlumno */
    private VAlumnoModifica()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
    }

    public static VAlumnoModifica getInstance(Alumno alumno)
    {
        if (ventanaAlumnoModifica == null)
            ventanaAlumnoModifica = new VAlumnoModifica();
        ventanaAlumnoModifica.setComponentes(alumno);
        return ventanaAlumnoModifica;
    }

    public void setComponentes(Alumno alumno)
    {
        this.addWindowListener(WindowSerializador.getInstance());
        jTextFieldLegajo.setText(alumno.getId());
        jTextFieldNombre.setText(alumno.getNombre());
        jTextFieldApellido.setText(alumno.getApellido());
        jTextFieldCalle.setText(alumno.getDomicilio().getCalle());
        jTextFieldNumero.setText(Integer.toString(alumno.getDomicilio().getNumero()));
        jTextFieldTelefono.setText(alumno.getTelefono());
        jTextFieldEmail.setText(alumno.getEmail());
        setTablaHistoria(alumno);
        cargaHistoria();
    }

    private void setTablaHistoria(Alumno alumno)
    {
        DefaultTableModel model = (DefaultTableModel) jTableHistoria.getModel();
        model.setRowCount(0);
        Iterator<Asignatura> historia = alumno.getHistoriaIterator();
        while (historia.hasNext())
        {
            Asignatura asignatura = historia.next();
            model.addRow(new Object[] { asignatura.getId(), asignatura.getNombre() });
        }
    }

    private void cargaHistoria()
    {
        jComboHistoria.removeAllItems();
        Iterator<Cursada> cursadas = Controlador.getInstance().getCursadasIterator();
        while (cursadas.hasNext())
        {
            Cursada cursada = cursadas.next();
            ComboItem item = new ComboItem(cursada.getId(), cursada.getAsignatura().getNombre());
            jComboHistoria.addItem(item);
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
        jLabelAlumno = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEdicion = new javax.swing.JLabel();
        jPanelGrilla = new javax.swing.JPanel();
        jLabelLegajo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelCalle = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelHistoria = new javax.swing.JLabel();
        jTextFieldLegajo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldCalle = new javax.swing.JTextField();
        jTextFieldTelefono = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jScrollPaneHistoria = new javax.swing.JScrollPane();
        jTableHistoria = new javax.swing.JTable();
        jComboHistoria = new javax.swing.JComboBox<>();
        jButtonAprobar = new javax.swing.JButton();
        jButtonGrabar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jButtonQuitarAsignatura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alumno - Edici�n");
        setResizable(false);

        jPanelCabecera.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelAlumno.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelAlumno.setText("Alumno - ");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/aa0c19c7-d3a7-43d8-8664-2f08e5d0ca90.png"))); // NOI18N

        jLabelEdicion.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabelEdicion.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEdicion.setText("Edicion");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelAlumno)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 421, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                        .addComponent(jLabelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
                    .addComponent(jLabelAlumno, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCabecera, java.awt.BorderLayout.PAGE_START);

        jPanelGrilla.setBackground(new java.awt.Color(105, 255, 204));

        jLabelLegajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLegajo.setText("Legajo");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelApellido.setText("Apellido");

        jLabelCalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCalle.setText("Calle");

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jLabelHistoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHistoria.setText("Historia");

        jTextFieldLegajo.setEditable(false);
        jTextFieldLegajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextFieldLegajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLegajoActionPerformed(evt);
            }
        });

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jTextFieldApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldApellidoKeyTyped(evt);
            }
        });

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jLabelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumero.setText("Numero");

        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroActionPerformed(evt);
            }
        });
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldNumeroKeyTyped(evt);
            }
        });

        jTableHistoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneHistoria.setViewportView(jTableHistoria);
        if (jTableHistoria.getColumnModel().getColumnCount() > 0) {
            jTableHistoria.getColumnModel().getColumn(0).setHeaderValue("Identificacion");
            jTableHistoria.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        jComboHistoria.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        jComboHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboHistoriaActionPerformed(evt);
            }
        });

        jButtonAprobar.setText("Aprobar");
        jButtonAprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAprobarActionPerformed(evt);
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

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email");

        jButtonQuitarAsignatura.setText("Quitar");
        jButtonQuitarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonQuitarAsignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGrillaLayout = new javax.swing.GroupLayout(jPanelGrilla);
        jPanelGrilla.setLayout(jPanelGrillaLayout);
        jPanelGrillaLayout.setHorizontalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addContainerGap(316, Short.MAX_VALUE)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGrillaLayout.createSequentialGroup()
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelCalle)
                            .addComponent(jLabelLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelHistoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jComboHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAprobar))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldEmail)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCalle)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jScrollPaneHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonQuitarAsignatura)))
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGrillaLayout.createSequentialGroup()
                        .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)
                        .addContainerGap())))
        );
        jPanelGrillaLayout.setVerticalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellido)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCalle)
                    .addComponent(jTextFieldCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHistoria)
                    .addComponent(jComboHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAprobar))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                        .addComponent(jScrollPaneHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonQuitarAsignatura))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGrilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents
    
    

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void jComboHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboHistoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboHistoriaActionPerformed

    private void jButtonAprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAprobarActionPerformed
        if (jComboHistoria.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) jTableHistoria.getModel();
            ComboItem item = (ComboItem) jComboHistoria.getSelectedItem();
            try
            {
                Controlador.getInstance().aprobarAlumno(jTextFieldLegajo.getText(), item.getId());
                Asignatura asignatura = Controlador.getInstance()
                                                   .consultaCursada(item.getId())
                                                   .getAsignatura();
                model.addRow(new Object[] { asignatura.getId(), asignatura.getNombre() });
            }
            catch (IdInvalidoException | EntidadInvalidaException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonAprobarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        VentanaIndex.getInstancia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldLegajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLegajoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLegajoActionPerformed

    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
        if (jTextFieldNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Nombre");
        else if (jTextFieldApellido.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Apellido");
        else if (jTextFieldCalle.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Calle");
        else if (jTextFieldNumero.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Numero");
        else if (jTextFieldTelefono.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Telefono");
        else if (jTextFieldEmail.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Mail");
        else
        {
            try
            {
                Controlador.getInstance()
                    .modificaAlumno(jTextFieldLegajo.getText().toString(), jTextFieldApellido.getText().toString(),
                                    jTextFieldNombre.getText().toString(), jTextFieldCalle.getText().toString(),
                                    Integer.parseInt(jTextFieldNumero.getText()),
                                    jTextFieldTelefono.getText().toString(), jTextFieldEmail.getText());
                JOptionPane.showMessageDialog(null, "El alumno ha sido modificado exitosamente");
                VentanaIndex.getInstancia().setVisible(true);
                this.setVisible(false);
            }
            catch (EmailInvalidoException | IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonGrabarActionPerformed

    private void jTextFieldNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNombreKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_jTextFieldNombreKeyTyped

    private void jTextFieldApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldApellidoKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_jTextFieldApellidoKeyTyped

    private void jTextFieldNumeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumeroKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (!Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_jTextFieldNumeroKeyTyped

    private void jButtonQuitarAsignaturaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonQuitarAsignaturaActionPerformed
    {//GEN-HEADEREND:event_jButtonQuitarAsignaturaActionPerformed
        if (jTableHistoria.getSelectedRows().length == 1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableHistoria.getModel();
            try
            {
                Controlador.getInstance()
                .removeAsignaturaAlumno(jTextFieldLegajo.getText(),
                    (String) jTableHistoria.getValueAt(jTableHistoria.getSelectedRow(), 0));
                model.removeRow(jTableHistoria.getSelectedRow());
            }
            catch (IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonQuitarAsignaturaActionPerformed

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (!Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAprobar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGrabar;
    private javax.swing.JButton jButtonQuitarAsignatura;
    private javax.swing.JComboBox<ComboItem> jComboHistoria;
    private javax.swing.JLabel jLabelAlumno;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCalle;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelHistoria;
    private javax.swing.JLabel jLabelLegajo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelGrilla;
    private javax.swing.JScrollPane jScrollPaneHistoria;
    private javax.swing.JTable jTableHistoria;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLegajo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

}
