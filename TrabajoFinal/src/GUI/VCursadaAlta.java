
package GUI;

import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
 * @author Franco Lanzi
 */
public class VCursadaAlta extends javax.swing.JFrame
{

    /** Creates new form VCursadaAlta2 */
    public VCursadaAlta()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
        vaciaCampos();
        cargaAlumnos();
        cargaProfesores();
        cargaAsignaturas();
    }
    
    private void vaciaCampos()
    {
        TIdentificador.setText(Mascaras.genId(Cursada.getSigIdentificacion(), Cursada.prefijo));
        TPeriodo.setText("");
        THoraInicio.setText("");
        THoraFin.setText("");
        ((DefaultTableModel) tablaProfesores.getModel()).setRowCount(0);
        ((DefaultTableModel) tablaAlumnos.getModel()).setRowCount(0);
    }
    
    private void cargaProfesores()
    {
        Iterator<Profesor> profesores =Controlador.getInstance().getProfesoresIterator();
        while (profesores.hasNext())
        {
            Profesor profesor = profesores.next();
            ComboItem item = new ComboItem(profesor.getId(), profesor.getNombre() + " " + profesor.getApellido());
            CProfesores.addItem(item);
        }
    }
    
    private void cargaAlumnos()
    {
        Iterator<Alumno> alumnos =Controlador.getInstance().getAlumnosIterator();
        while (alumnos.hasNext())
        {
            Alumno alumno = alumnos.next();
            ComboItem item = new ComboItem(alumno.getId(), alumno.getNombre() + " " + alumno.getApellido());
            CAlumnos.addItem(item);
        }
    }
    
    private void cargaAsignaturas()
    {
        Iterator<Asignatura> asignaturas = Controlador.getInstance().getAsignaturasIterator();
        while (asignaturas.hasNext())
        {
            Asignatura asignatura = asignaturas.next();
            ComboItem item = new ComboItem(asignatura.getId(), asignatura.getNombre());
            CAsignatura.addItem(item);
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
        CAsignatura = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cabecera.setBackground(new java.awt.Color(204, 255, 255));

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

        Grilla.setBackground(new java.awt.Color(105, 255, 204));
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

        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Legajo", "Nombre", "Apellido"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
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
        TProfesores.setViewportView(tablaProfesores);
        if (tablaProfesores.getColumnModel().getColumnCount() > 0)
        {
            tablaProfesores.getColumnModel().getColumn(0).setHeaderValue("Legajo");
            tablaProfesores.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tablaProfesores.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        }

        CProfesores.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
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
        Grabar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        CDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        CDia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                CDiaActionPerformed(evt);
            }
        });

        Alumnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Alumnos.setText("Alumnos");

        CAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        CAlumnos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Legajo", "Nombre", "Apellido"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
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
        TAlumnos.setViewportView(tablaAlumnos);
        if (tablaAlumnos.getColumnModel().getColumnCount() > 0)
        {
            tablaAlumnos.getColumnModel().getColumn(0).setHeaderValue("Legajo");
            tablaAlumnos.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tablaAlumnos.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        }

        quitarProfesor.setText("Quitar");
        quitarProfesor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitarProfesorActionPerformed(evt);
            }
        });

        quitarAlumno.setText("Quitar");
        quitarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                quitarAlumnoActionPerformed(evt);
            }
        });

        CAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));

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
                                            .addComponent(CAsignatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(CAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 839, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Grilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(Grilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }//GEN-END:initComponents

    private void THoraFinActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_THoraFinActionPerformed
    {//GEN-HEADEREND:event_THoraFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_THoraFinActionPerformed

    private void CProfesoresActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CProfesoresActionPerformed
    {//GEN-HEADEREND:event_CProfesoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CProfesoresActionPerformed
    
    private boolean isInTable(String id, JTable table)
    {
        int i = 0;
        while (i < table.getRowCount() && !table.getValueAt(i, 0).equals(id))
            i++;
        return i < table.getRowCount();
    }
    
    private void AgregarProfesorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AgregarProfesorActionPerformed
    {//GEN-HEADEREND:event_AgregarProfesorActionPerformed
        if (CProfesores.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) tablaProfesores.getModel();
            ComboItem item = (ComboItem) CProfesores.getSelectedItem();
            if (!isInTable(item.getId(), tablaProfesores))
            {
                try
                {
                    Profesor profesor = Controlador.getInstance().consultaProfesor(item.getId());
                    model.addRow(new Object[] { profesor.getId(), profesor.getNombre(), profesor.getApellido() });
                }
                catch (IdInvalidoException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_AgregarProfesorActionPerformed

    private void GrabarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_GrabarActionPerformed
    {//GEN-HEADEREND:event_GrabarActionPerformed
        if (CAsignatura.getItemCount() == 0)
            JOptionPane.showMessageDialog(null,"Ingrese Asignatura");
        else if (TPeriodo.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Periodo");
        else if (CDia.getSelectedItem().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Dia");
        else if (THoraInicio.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Hora Inicio");
        else if (THoraFin.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Ingrese Hora Fin");
        else
        {
            try
            {
                ComboItem item = (ComboItem) CAsignatura.getSelectedItem();
                Controlador.getInstance().altaCursada(item.getId(),
                    TPeriodo.getText(), (String) CDia.getSelectedItem(),
                    THoraInicio.getText(), THoraFin.getText());
                addProfesores();
                addAlumnos();
                vaciaCampos();
                JOptionPane.showMessageDialog(null, "La cursada ha sido dada de alta exitosamente");
            }
            catch (HoraInvalidaException | IdInvalidoException | PeriodoInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_GrabarActionPerformed
    
    private void addProfesores()
    {
        DefaultTableModel model = (DefaultTableModel) tablaProfesores.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            try
            {
                Controlador.getInstance().addProfesorCursada((String) model.getValueAt(i, 0), TIdentificador.getText());
            }
            catch (EntidadInvalidaException | HorarioNoViableException | IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    private void addAlumnos()
    {
        DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
        for (int i = 0; i < model.getRowCount(); i++)
        {
            try
            {
                Controlador.getInstance().addAlumnoCursada((String) model.getValueAt(i, 0), TIdentificador.getText());
            }
            catch (EntidadInvalidaException | HorarioNoViableException | IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
    
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CancelarActionPerformed
    {//GEN-HEADEREND:event_CancelarActionPerformed
        this.dispose();
        VentanaIndex principal= new VentanaIndex();
        principal.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void CDiaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CDiaActionPerformed
    {//GEN-HEADEREND:event_CDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CDiaActionPerformed

    private void CAlumnosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_CAlumnosActionPerformed
    {//GEN-HEADEREND:event_CAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CAlumnosActionPerformed

    private void AgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_AgregarAlumnoActionPerformed
    {//GEN-HEADEREND:event_AgregarAlumnoActionPerformed
        if (CAlumnos.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
            ComboItem item = (ComboItem) CAlumnos.getSelectedItem();
            if (!isInTable(item.getId(), tablaAlumnos))
            {
                try
                {
                    Alumno alumno = Controlador.getInstance().consultaAlumno(item.getId());
                    model.addRow(new Object[] { alumno.getId(), alumno.getNombre(), alumno.getApellido() });
                }
                catch (IdInvalidoException e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_AgregarAlumnoActionPerformed

    private void quitarProfesorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitarProfesorActionPerformed
    {//GEN-HEADEREND:event_quitarProfesorActionPerformed
        if(tablaProfesores.getSelectedRows().length ==1)
        {
            DefaultTableModel model = (DefaultTableModel) tablaProfesores.getModel();
            model.removeRow(tablaProfesores.getSelectedRow());
        }
    }//GEN-LAST:event_quitarProfesorActionPerformed

    private void quitarAlumnoActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quitarAlumnoActionPerformed
    {//GEN-HEADEREND:event_quitarAlumnoActionPerformed
        if(tablaAlumnos.getSelectedRows().length ==1)
        {
            DefaultTableModel model = (DefaultTableModel) tablaAlumnos.getModel();
            model.removeRow(tablaAlumnos.getSelectedRow());
        }
    }//GEN-LAST:event_quitarAlumnoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing
                                                                  .UIManager
                                                                  .getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing
                         .UIManager
                         .setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util
                .logging
                .Logger
                .getLogger(VCursadaAlta.class.getName())
                .log(java.util
                         .logging
                         .Level
                         .SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
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
            .invokeLater(new Runnable()
            {
                public void run()
                {
                    new VCursadaAlta().setVisible(true);
                }
            });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarAlumno;
    private javax.swing.JButton AgregarProfesor;
    private javax.swing.JLabel Alumnos;
    private javax.swing.JComboBox<ComboItem> CAlumnos;
    private javax.swing.JComboBox<ComboItem> CAsignatura;
    private javax.swing.JComboBox<String> CDia;
    private javax.swing.JComboBox<ComboItem> CProfesores;
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
    // End of variables declaration//GEN-END:variables

}
