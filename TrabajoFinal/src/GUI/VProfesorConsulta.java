
package GUI;

import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import trabajofinal.Alumno;
import trabajofinal.Asignatura;
import trabajofinal.Cursada;
import trabajofinal.Profesor;

public class VProfesorConsulta extends javax.swing.JFrame
{
    
    private static VProfesorConsulta ventanaProfesorConsulta = null;

    DefaultTableModel modelo = new DefaultTableModel();
    String[] col =
    {
        "Identificador", "Nombre"
    };

    /** Creates new form VProfesorConsulta */
    private VProfesorConsulta()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
    }

    public static VProfesorConsulta getInstance(Profesor profesor)
    {
        if (ventanaProfesorConsulta == null)
            ventanaProfesorConsulta = new VProfesorConsulta();
        ventanaProfesorConsulta.setComponentes(profesor);
        return ventanaProfesorConsulta;
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
        jLabelConsulta = new javax.swing.JLabel();
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
        jScrollPaneCompetencias = new javax.swing.JScrollPane();
        jTableCompetencias = new javax.swing.JTable();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profesor - Consulta");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelCabecera.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelProfesor.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelProfesor.setText("Profesor -");

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Imagenes/aa0c19c7-d3a7-43d8-8664-2f08e5d0ca90.png"))); // NOI18N

        jLabelConsulta.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabelConsulta.setForeground(new java.awt.Color(102, 102, 102));
        jLabelConsulta.setText("Consulta");

        javax.swing.GroupLayout jPanelCabeceraLayout = new javax.swing.GroupLayout(jPanelCabecera);
        jPanelCabecera.setLayout(jPanelCabeceraLayout);
        jPanelCabeceraLayout.setHorizontalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
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
                        .addComponent(jLabelConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jTextFieldNombre.setEditable(false);

        jTextFieldApellido.setEditable(false);

        jTextFieldCalle.setEditable(false);

        jTextFieldEmail.setEditable(false);

        jLabelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNumero.setText("Numero");

        jTextFieldNumero.setEditable(false);
        jTextFieldNumero.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldNumeroActionPerformed(evt);
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
        jScrollPaneCompetencias.setViewportView(jTableCompetencias);
        if (jTableCompetencias.getColumnModel().getColumnCount() > 0)
        {
            jTableCompetencias.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            jTableCompetencias.getColumnModel().getColumn(1).setHeaderValue("Nombre");
        }

        jLabelTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelTelefono.setText("Telefono");

        jTextFieldTelefono.setEditable(false);
        jTextFieldTelefono.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldTelefonoActionPerformed(evt);
            }
        });

        jButtonCancelar.setBackground(new java.awt.Color(0, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonCancelar.setText("SALIR");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGrillaLayout = new javax.swing.GroupLayout(jPanelGrilla);
        jPanelGrilla.setLayout(jPanelGrillaLayout);
        jPanelGrillaLayout.setHorizontalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
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
                    .addComponent(jScrollPaneCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButtonCancelar)
                .addContainerGap(42, Short.MAX_VALUE))
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
                    .addComponent(jLabelHistoria)
                    .addComponent(jScrollPaneCompetencias, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelGrilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        VentanaIndex.getInstancia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jTextFieldTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefonoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCalle;
    private javax.swing.JLabel jLabelConsulta;
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
    private javax.swing.JScrollPane jScrollPaneCompetencias;
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
