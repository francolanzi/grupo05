
package GUI;

import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import trabajofinal.Alumno;
import trabajofinal.Asignatura;
import trabajofinal.Controlador;
import trabajofinal.Cursada;
import trabajofinal.EntidadInvalidaException;
import trabajofinal.HoraInvalidaException;
import trabajofinal.HorarioNoViableException;
import trabajofinal.IdInvalidoException;
import trabajofinal.Mascaras;
import trabajofinal.PeriodoInvalidoException;
import trabajofinal.Profesor;

/**
 *
 * @author Usuario
 */
public class VCursadaAlta extends javax.swing.JFrame {
    private Controlador controlador;
    DefaultTableModel modelo1= new DefaultTableModel();
    String[] col1={"Identificador","Nombre","Apellido"};
    DefaultTableModel modelo2= new DefaultTableModel();
    String[] col2={"Identificador","Nombre","Apellido"};
    DefaultComboBoxModel combo1= new DefaultComboBoxModel();
    DefaultComboBoxModel combo2= new DefaultComboBoxModel();


    /** Creates new form Cursadas */
    public VCursadaAlta() {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
        TIdentificador.setText(Mascaras.genId(Cursada.getSigIdentificacion(), Cursada.prefijo));
        CDia.setModel(new DefaultComboBoxModel<>(new String[] { "Lunes", "Martes","Miercoles","Jueves","Viernes" }));; 
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents()//GEN-BEGIN:initComponents
    {

        Cabecera = new javax.swing.JPanel();
        lCursada = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Grilla = new javax.swing.JPanel();
        Identificador = new javax.swing.JLabel();
        NAsignatura = new javax.swing.JLabel();
        Periodo = new javax.swing.JLabel();
        Dia = new javax.swing.JLabel();
        Profesores = new javax.swing.JLabel();
        TIdentificador = new javax.swing.JTextField();
        TAsignatura = new javax.swing.JTextField();
        TPeriodo = new javax.swing.JTextField();
        HoraFin = new javax.swing.JLabel();
        THoraFin = new javax.swing.JTextField();
        TProfesores = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        CProfesores = new javax.swing.JComboBox<>();
        AgregarProfesor = new javax.swing.JButton();
        HoraInicio = new javax.swing.JLabel();
        THoraInicio = new javax.swing.JTextField();
        Grabar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        CDia = new javax.swing.JComboBox<>();
        Alumnos = new javax.swing.JLabel();
        CAlumnos = new javax.swing.JComboBox<>();
        AgregarAlumno = new javax.swing.JButton();
        TAlumnos = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        quitarProfesor = new javax.swing.JButton();
        quitarAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cursada - Nuevo");
        setPreferredSize(new java.awt.Dimension(800, 600));

        Cabecera.setBackground(new java.awt.Color(204, 255, 255));
        Cabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        lCursada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lCursada.setText("Cursada -");

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
                .addComponent(lCursada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 409, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        CabeceraLayout.setVerticalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lCursada)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(Cabecera, java.awt.BorderLayout.PAGE_START);

        Grilla.setBackground(new java.awt.Color(105, 255, 204));
        Grilla.setPreferredSize(new java.awt.Dimension(638, 618));
        Grilla.setVerifyInputWhenFocusTarget(false);

        Identificador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Identificador.setText("Identificador");

        NAsignatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NAsignatura.setText("Asignatura");

        Periodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Periodo.setText("Per�odo");

        Dia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Dia.setText("D�a");

        Profesores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Profesores.setText("Profesores");

        TIdentificador.setEditable(false);
        TIdentificador.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        TIdentificador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        HoraFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HoraFin.setText("Hora Fin");

        THoraFin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                THoraFinActionPerformed(evt);
            }
        });

        tablaProfesores.setModel(modelo1);
        TProfesores.setViewportView(tablaProfesores);
        if (tablaProfesores.getColumnModel().getColumnCount() > 0) {
            tablaProfesores.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            tablaProfesores.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tablaProfesores.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        }

        CProfesores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CProfesores.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CProfesoresActionPerformed(evt);
            }
        });

        AgregarProfesor.setText("Agregar");
        AgregarProfesor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AgregarProfesorActionPerformed(evt);
            }
        });

        HoraInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        HoraInicio.setText("Hora Inicio");

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
        Cancelar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CancelarActionPerformed(evt);
            }
        });

        CDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CDia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CDiaActionPerformed(evt);
            }
        });

        Alumnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Alumnos.setText("Alumnos");

        CAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CAlumnosActionPerformed(evt);
            }
        });

        AgregarAlumno.setText("Agregar");
        AgregarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AgregarAlumnoActionPerformed(evt);
            }
        });

        tablaAlumnos.setModel(modelo2);
        TAlumnos.setViewportView(tablaAlumnos);

        quitarProfesor.setText("Quitar");
        quitarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarProfesorActionPerformed(evt);
            }
        });

        quitarAlumno.setText("Quitar");
        quitarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarAlumnoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GrillaLayout = new javax.swing.GroupLayout(Grilla);
        Grilla.setLayout(GrillaLayout);
        GrillaLayout.setHorizontalGroup(
            GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrillaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(Identificador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Periodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(HoraInicio)
                    .addComponent(Profesores)
                    .addComponent(Alumnos))
                .addGap(41, 41, 41)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GrillaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Cancelar)
                        .addGap(160, 160, 160))
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addComponent(TAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(quitarAlumno))
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addComponent(TProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(quitarProfesor))
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CProfesores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                        .addComponent(THoraInicio)
                                        .addComponent(TIdentificador)))
                                .addGap(27, 27, 27)
                                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(GrillaLayout.createSequentialGroup()
                                            .addComponent(Dia)
                                            .addGap(74, 74, 74)
                                            .addComponent(CDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GrillaLayout.createSequentialGroup()
                                            .addComponent(NAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(TAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GrillaLayout.createSequentialGroup()
                                            .addComponent(HoraFin)
                                            .addGap(43, 43, 43)
                                            .addComponent(THoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GrillaLayout.createSequentialGroup()
                                        .addComponent(AgregarProfesor)
                                        .addGap(168, 168, 168))))
                            .addGroup(GrillaLayout.createSequentialGroup()
                                .addComponent(CAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(AgregarAlumno)))
                        .addContainerGap(257, Short.MAX_VALUE))))
        );
        GrillaLayout.setVerticalGroup(
            GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GrillaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Identificador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NAsignatura)
                    .addComponent(TAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Periodo)
                    .addComponent(TPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dia)
                    .addComponent(CDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HoraInicio)
                    .addComponent(THoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HoraFin)
                    .addComponent(THoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Profesores)
                    .addComponent(CProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarProfesor))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitarProfesor))
                .addGap(29, 29, 29)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AgregarAlumno)
                    .addComponent(Alumnos))
                .addGap(18, 18, 18)
                .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addComponent(TAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(GrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Grabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(GrillaLayout.createSequentialGroup()
                        .addComponent(quitarAlumno)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(Grilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void THoraFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_THoraFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_THoraFinActionPerformed

    private void CProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CProfesoresActionPerformed
        Iterator it =controlador.getProfesores().values().iterator();
        while (it.hasNext()){
            Profesor profesor= (Profesor)it.next();
            CProfesores.addItem(profesor.getNombre());
        }
    }//GEN-LAST:event_CProfesoresActionPerformed

    private void AgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarProfesorActionPerformed
        Profesor profesor;
        try {
            profesor = (Profesor) controlador.consultaProfesor(CProfesores.getSelectedItem().toString());
            controlador.addProfesorCursada(profesor.getLegajo(), TIdentificador.getText().toString());
            String []dato= {profesor.getId(),profesor.getNombre(),profesor.getApellido()};
            modelo1.addRow(dato);
        } catch (IdInvalidoException e) {
            e.getMessage();
        } catch (EntidadInvalidaException e) {
            e.getMessage();
        } catch (HorarioNoViableException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_AgregarProfesorActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
        VentanaIndex principal= new VentanaIndex();
        principal.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void CDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDiaActionPerformed

    private void AgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarAlumnoActionPerformed
        Alumno alumno;
        try {
            alumno = (Alumno) controlador.consultaAlumno(CAlumnos.getSelectedItem().toString());
            controlador.addAlumnoCursada(alumno.getLegajo(), TIdentificador.getText().toString());
            String []dato= {alumno.getId(),alumno.getNombre(),alumno.getApellido()};
            modelo2.addRow(dato);
        } catch (IdInvalidoException e) {
            e.getMessage();
        } catch (EntidadInvalidaException e) {
            e.getMessage();
        } catch (HorarioNoViableException e) {
            e.getMessage();
        }     
    }//GEN-LAST:event_AgregarAlumnoActionPerformed

    private void GrabarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GrabarActionPerformed
    {//GEN-HEADEREND:event_GrabarActionPerformed
        if (TAsignatura.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Nomnbre");
        if (TPeriodo.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Periodo");
        if (CDia.getSelectedItem().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Dia");
        if (THoraInicio.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Hora Inicio");
        if (THoraFin.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Hora Fin");
        try {
            controlador.altaCursada(TAsignatura.getText().toString(),
                                       TPeriodo.getText().toString(), CDia.getSelectedItem().toString(),
                                       THoraInicio.getText().toString(), THoraFin.getText().toString());
        } catch (HoraInvalidaException | IdInvalidoException | PeriodoInvalidoException e) {
            e.getMessage();
        }
    }//GEN-LAST:event_GrabarActionPerformed

    private void quitarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarAlumnoActionPerformed
        if(tablaAlumnos.getSelectedRows().length ==1){
            try {
                controlador.removeAlumnoCursada(TIdentificador.getText(),
                                              tablaAlumnos.getValueAt(tablaAlumnos.getSelectedRow(), 0)
                                              .toString());
                modelo2.removeRow(tablaAlumnos.getSelectedRow());
            } catch (IdInvalidoException e) {
                e.getMessage();
            }
        }            
    }//GEN-LAST:event_quitarAlumnoActionPerformed

    private void quitarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarProfesorActionPerformed
        if(tablaProfesores.getSelectedRows().length ==1){
            try {
                controlador.removeProfesorCursada(TIdentificador.getText(),
                                              tablaProfesores.getValueAt(tablaProfesores.getSelectedRow(), 0)
                                              .toString());
                modelo1.removeRow(tablaProfesores.getSelectedRow());
            } catch (IdInvalidoException e) {
                e.getMessage();
            }
        }
    }//GEN-LAST:event_quitarProfesorActionPerformed

    private void CAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CAlumnosActionPerformed
        Iterator it =controlador.getAlumnos().values().iterator();
        while (it.hasNext()){
            Alumno alumno= (Alumno)it.next();
            CAlumnos.addItem(alumno.getNombre());
        }
    }//GEN-LAST:event_CAlumnosActionPerformed

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
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
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
                    new VCursadaAlta().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarAlumno;
    private javax.swing.JButton AgregarProfesor;
    private javax.swing.JLabel Alumnos;
    private javax.swing.JComboBox<String> CAlumnos;
    private javax.swing.JComboBox<String> CDia;
    private javax.swing.JComboBox<String> CProfesores;
    private javax.swing.JPanel Cabecera;
    private javax.swing.JButton Cancelar;
    private javax.swing.JLabel Dia;
    private javax.swing.JButton Grabar;
    private javax.swing.JPanel Grilla;
    private javax.swing.JLabel HoraFin;
    private javax.swing.JLabel HoraInicio;
    private javax.swing.JLabel Identificador;
    private javax.swing.JLabel NAsignatura;
    private javax.swing.JLabel Periodo;
    private javax.swing.JLabel Profesores;
    private javax.swing.JScrollPane TAlumnos;
    private javax.swing.JTextField TAsignatura;
    private javax.swing.JTextField THoraFin;
    private javax.swing.JTextField THoraInicio;
    private javax.swing.JTextField TIdentificador;
    private javax.swing.JTextField TPeriodo;
    private javax.swing.JScrollPane TProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lCursada;
    private javax.swing.JButton quitarAlumno;
    private javax.swing.JButton quitarProfesor;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTable tablaProfesores;

}
