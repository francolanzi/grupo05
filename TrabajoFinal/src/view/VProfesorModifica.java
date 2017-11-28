
package view;

import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Asignatura;
import model.Controlador;
import model.EmailInvalidoException;
import model.EntidadInvalidaException;
import model.IdInvalidoException;
import model.Profesor;

@SuppressWarnings("serial")
public class VProfesorModifica extends javax.swing.JFrame
{
    
    private static VProfesorModifica ventanaProfesorModifica = null;

    /** Creates new form VProfesorModifica */
    private VProfesorModifica()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
    }

    public static VProfesorModifica getInstance(Profesor profesor)
    {
        if (ventanaProfesorModifica == null)
            ventanaProfesorModifica = new VProfesorModifica();
        ventanaProfesorModifica.setComponentes(profesor);
        return ventanaProfesorModifica;
    }

    public void setComponentes(Profesor profesor)
    {
        this.addWindowListener(WindowSerializador.getInstance());
        jTextFieldLegajo.setText(profesor.getId());
        jTextFieldNombre.setText(profesor.getNombre());
        jTextFieldApellido.setText(profesor.getApellido());
        jTextFieldCalle.setText(profesor.getDomicilio().getCalle());
        jTextFieldNumero.setText(Integer.toString(profesor.getDomicilio().getNumero()));
        jTextFieldTelefono.setText(profesor.getTelefono());
        jTextFieldEmail.setText(profesor.getEmail());
        setTablaCompetencias(profesor);
        cargaCompetencias();
    }

    private void setTablaCompetencias(Profesor profesor)
    {
        DefaultTableModel model = (DefaultTableModel) jTableCompetencias.getModel();
        model.setRowCount(0);
        Iterator<Asignatura> competencias = profesor.getCompetenciasIterator();
        while (competencias.hasNext())
        {
            Asignatura competencia = competencias.next();
            model.addRow(new Object[] { competencia.getId(), competencia.getNombre() });
        }
    }

    private void cargaCompetencias()
    {
        jComboCompetencia.removeAllItems();
        Iterator<Asignatura> asignaturas = Controlador.getInstance().getAsignaturasIterator();
        while (asignaturas.hasNext())
        {
            Asignatura asignatura = asignaturas.next();
            ComboItem item = new ComboItem(asignatura.getId(), asignatura.getNombre());
            jComboCompetencia.addItem(item);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        jPanelCabecera = new javax.swing.JPanel();
        jLabelProfesor = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEdicion = new javax.swing.JLabel();
        jPanelGrilla = new javax.swing.JPanel();
        jLabelLegajo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellido = new javax.swing.JLabel();
        jLabelCalle = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelHistoria = new javax.swing.JLabel();
        jTextFieldLegajo = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldCalle = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelNumero = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jScrollPaneHistoria = new javax.swing.JScrollPane();
        jTableCompetencias = new javax.swing.JTable();
        jComboCompetencia = new javax.swing.JComboBox<>();
        jButtonAgregarCompetencia = new javax.swing.JButton();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonGrabar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonQuitarCompetencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profesor - Edición");

        jPanelCabecera.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelProfesor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelProfesor.setText("Profesor -");

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
                .addComponent(jLabelProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(jLabelProfesor, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCabecera, java.awt.BorderLayout.PAGE_START);

        jPanelGrilla.setBackground(new java.awt.Color(105, 255, 204));
        jPanelGrilla.setPreferredSize(new java.awt.Dimension(638, 618));
        jPanelGrilla.setVerifyInputWhenFocusTarget(false);

        jLabelLegajo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelLegajo.setText("Legajo");

        jLabelNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre");

        jLabelApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelApellido.setText("Apellido");

        jLabelCalle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelCalle.setText("Calle");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelEmail.setText("Email");

        jLabelHistoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHistoria.setText("Competencias");

        jTextFieldLegajo.setEditable(false);
        jTextFieldLegajo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextFieldNombre.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldNombreKeyTyped(evt);
            }
        });

        jTextFieldApellido.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldApellidoKeyTyped(evt);
            }
        });

        jLabelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumero.setText("Numero");

        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldNumeroActionPerformed(evt);
            }
        });
        jTextFieldNumero.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldNumeroKeyTyped(evt);
            }
        });

        jTableCompetencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Identificador", "Nombre"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneHistoria.setViewportView(jTableCompetencias);
        if (jTableCompetencias.getColumnModel().getColumnCount() > 0)
        {
            jTableCompetencias.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            jTableCompetencias.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        jComboCompetencia.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        jComboCompetencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboCompetenciaActionPerformed(evt);
            }
        });

        jButtonAgregarCompetencia.setText("Agregar");
        jButtonAgregarCompetencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAgregarCompetenciaActionPerformed(evt);
            }
        });

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jTextFieldTelefono.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTextFieldTelefonoKeyTyped(evt);
            }
        });

        jButtonGrabar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonGrabar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGrabar.setText("GRABAR");
        jButtonGrabar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonGrabar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonGrabarActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setText("CANCELAR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonQuitarCompetencia.setText("Quitar");
        jButtonQuitarCompetencia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonQuitarCompetenciaActionPerformed(evt);
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
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelCalle, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelLegajo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelHistoria))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jComboCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregarCompetencia))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCalle)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldLegajo, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(21, 21, 21)
                                .addComponent(jLabelNumero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonQuitarCompetencia))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        jPanelGrillaLayout.setVerticalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
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
                    .addComponent(jLabelNumero)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefono)
                    .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAgregarCompetencia)
                    .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboCompetencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHistoria)))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                        .addComponent(jScrollPaneHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonQuitarCompetencia))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGrilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void jComboCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboCompetenciaActionPerformed
        
    }//GEN-LAST:event_jComboCompetenciaActionPerformed

    private void jButtonAgregarCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCompetenciaActionPerformed
        if (jComboCompetencia.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) jTableCompetencias.getModel();
            ComboItem item = (ComboItem) jComboCompetencia.getSelectedItem();
            try
            {
                Controlador.getInstance().addCompetencia(jTextFieldLegajo.getText(), item.getId());
                Asignatura competencia = Controlador.getInstance().consultaAsignatura(item.getId());
                model.addRow(new Object[] { competencia.getId(), competencia.getNombre() });
            }
            catch (IdInvalidoException | EntidadInvalidaException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }  
    }//GEN-LAST:event_jButtonAgregarCompetenciaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        VentanaIndex.getInstancia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

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

    private void jTextFieldTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoKeyTyped
        char TipoDeTecla = evt.getKeyChar();
        if (!Character.isDigit(TipoDeTecla))
            evt.consume();
    }//GEN-LAST:event_jTextFieldTelefonoKeyTyped

    private void jButtonQuitarCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarCompetenciaActionPerformed
        if (jTableCompetencias.getSelectedRows().length == 1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableCompetencias.getModel();
            try
            {
                Controlador.getInstance()
                    .removeCompetencia(jTextFieldLegajo.getText(),
                                       (String) jTableCompetencias.getValueAt(jTableCompetencias.getSelectedRow(), 0));
                model.removeRow(jTableCompetencias.getSelectedRow());
            }
            catch (IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonQuitarCompetenciaActionPerformed

    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
        if (jTextFieldNombre.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Nomnbre");
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
                    .modificaProfesor(jTextFieldLegajo.getText().toString(), jTextFieldApellido.getText().toString(),
                                      jTextFieldNombre.getText().toString(), jTextFieldCalle.getText().toString(),
                                      Integer.parseInt(jTextFieldNumero.getText()),
                                      jTextFieldNumero.getText().toString(), jTextFieldEmail.getText().toString());
                JOptionPane.showMessageDialog(null, "El profesor ha sido modificado exitosamente");
                VentanaIndex.getInstancia().setVisible(true);
                this.setVisible(false);
            }
            catch (EmailInvalidoException | IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonGrabarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCompetencia;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGrabar;
    private javax.swing.JButton jButtonQuitarCompetencia;
    private javax.swing.JComboBox<ComboItem> jComboCompetencia;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCalle;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelHistoria;
    private javax.swing.JLabel jLabelLegajo;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelProfesor;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelGrilla;
    private javax.swing.JScrollPane jScrollPaneHistoria;
    private javax.swing.JTable jTableCompetencias;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldCalle;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLegajo;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldTelefono;
    // End of variables declaration//GEN-END:variables

}
