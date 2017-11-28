
package view;

import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.Alumno;
import model.Controlador;
import model.Cursada;
import model.EntidadInvalidaException;
import model.HoraInvalidaException;
import model.HorarioNoViableException;
import model.IdInvalidoException;
import model.PeriodoInvalidoException;
import model.Profesor;

@SuppressWarnings("serial")
public class VCursadaModifica extends javax.swing.JFrame
{
    
    private static VCursadaModifica ventanaCursadaModifica = null;

    /** Creates new form VCursadaModifica */
    private VCursadaModifica()
    {
        initComponents();
        this.addWindowListener(WindowSerializador.getInstance());
    }


    public static VCursadaModifica getInstance(Cursada cursada)
    {
        if (ventanaCursadaModifica == null)
            ventanaCursadaModifica = new VCursadaModifica();
        ventanaCursadaModifica.setComponentes(cursada);
        return ventanaCursadaModifica;
    }

    public void setComponentes(Cursada cursada)
    {
        jTextFieldIdentificador.setText(cursada.getId());
        jTextFieldAsignatura.setText(cursada.getAsignatura().getNombre());
        jTextFieldPeriodo.setText(cursada.getPeriodo());
        jTextFieldHoraInicio.setText(cursada.getHoraInicio());
        jTextFieldHoraFin.setText(cursada.getHoraFin());
        jComboDia.setSelectedItem(cursada.getDia());
        setTablaProfesores(cursada);
        setTablaAlumnos(cursada);
        cargaAlumnos();
        cargaProfesores();
    }

    private void setTablaProfesores(Cursada cursada)
    {
        DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
        model.setRowCount(0);
        Iterator<Profesor> profesores = cursada.getProfesoresIterator();
        while (profesores.hasNext())
        {
            Profesor profesor = profesores.next();
            model.addRow(new Object[] { profesor.getId(), profesor.getNombre(), profesor.getApellido() });
        }
    }

    private void setTablaAlumnos(Cursada cursada)
    {
        DefaultTableModel model = (DefaultTableModel) jTableAlumnos.getModel();
        model.setRowCount(0);
        Iterator<Alumno> alumnos = cursada.getAlumnosIterator();
        while (alumnos.hasNext())
        {
            Alumno alumno = alumnos.next();
            model.addRow(new Object[] { alumno.getId(), alumno.getNombre(), alumno.getApellido() });
        }
    }

    private void cargaProfesores()
    {
        jComboProfesores.removeAllItems();
        Iterator<Profesor> profesores = Controlador.getInstance().getProfesoresIterator();
        while (profesores.hasNext())
        {
            Profesor profesor = profesores.next();
            ComboItem item = new ComboItem(profesor.getId(), profesor.getNombre() + " " + profesor.getApellido());
            jComboProfesores.addItem(item);
        }
    }

    private void cargaAlumnos()
    {
        jComboAlumnos.removeAllItems();
        Iterator<Alumno> alumnos = Controlador.getInstance().getAlumnosIterator();
        while (alumnos.hasNext())
        {
            Alumno alumno = alumnos.next();
            ComboItem item = new ComboItem(alumno.getId(), alumno.getNombre() + " " + alumno.getApellido());
            jComboAlumnos.addItem(item);
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
        jLabelCursada = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelEdicion = new javax.swing.JLabel();
        jPanelGrilla = new javax.swing.JPanel();
        jLabelIdentificador = new javax.swing.JLabel();
        jLabelNAsignatura = new javax.swing.JLabel();
        jLabelPeriodo = new javax.swing.JLabel();
        jLabelDia = new javax.swing.JLabel();
        jLabelProfesores = new javax.swing.JLabel();
        jTextFieldIdentificador = new javax.swing.JTextField();
        jTextFieldPeriodo = new javax.swing.JTextField();
        jLabelHoraFin = new javax.swing.JLabel();
        jTextFieldHoraFin = new javax.swing.JTextField();
        jScrollPaneProfesores = new javax.swing.JScrollPane();
        jTableProfesores = new javax.swing.JTable();
        jComboProfesores = new javax.swing.JComboBox<>();
        jButtonAgregarProfesor = new javax.swing.JButton();
        jLabelHoraInicio = new javax.swing.JLabel();
        jTextFieldHoraInicio = new javax.swing.JTextField();
        jButtonGrabar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jComboDia = new javax.swing.JComboBox<>();
        jLabelAlumnos = new javax.swing.JLabel();
        jComboAlumnos = new javax.swing.JComboBox<>();
        jButtonAgregarAlumno = new javax.swing.JButton();
        jScrollPaneAlumnos = new javax.swing.JScrollPane();
        jTableAlumnos = new javax.swing.JTable();
        jButtonQuitarAlumno = new javax.swing.JButton();
        jButtonQuitarProfesor = new javax.swing.JButton();
        jTextFieldAsignatura = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cursada - Edición");
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelCabecera.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCabecera.setPreferredSize(new java.awt.Dimension(400, 50));

        jLabelCursada.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelCursada.setText("Cursada -");

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
                .addComponent(jLabelCursada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelCabeceraLayout.setVerticalGroup(
            jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCursada)
                    .addComponent(jLabelEdicion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelCabecera, java.awt.BorderLayout.PAGE_START);

        jPanelGrilla.setBackground(new java.awt.Color(105, 255, 204));
        jPanelGrilla.setPreferredSize(new java.awt.Dimension(638, 618));
        jPanelGrilla.setVerifyInputWhenFocusTarget(false);

        jLabelIdentificador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelIdentificador.setText("Identificador");

        jLabelNAsignatura.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNAsignatura.setText("Asignatura");

        jLabelPeriodo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPeriodo.setText("Periodo");

        jLabelDia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDia.setText("Dia");

        jLabelProfesores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelProfesores.setText("Profesores");

        jTextFieldIdentificador.setEditable(false);
        jTextFieldIdentificador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelHoraFin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraFin.setText("Hora Fin");

        jTextFieldHoraFin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldHoraFinActionPerformed(evt);
            }
        });

        jTableProfesores.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPaneProfesores.setViewportView(jTableProfesores);
        if (jTableProfesores.getColumnModel().getColumnCount() > 0)
        {
            jTableProfesores.getColumnModel().getColumn(0).setHeaderValue("Legajo");
            jTableProfesores.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            jTableProfesores.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        }

        jComboProfesores.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        jComboProfesores.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboProfesoresActionPerformed(evt);
            }
        });

        jButtonAgregarProfesor.setText("Agregar");
        jButtonAgregarProfesor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAgregarProfesorActionPerformed(evt);
            }
        });

        jLabelHoraInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelHoraInicio.setText("Hora Inicio");

        jTextFieldHoraInicio.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldHoraInicioActionPerformed(evt);
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

        jComboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" }));
        jComboDia.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboDiaActionPerformed(evt);
            }
        });

        jLabelAlumnos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelAlumnos.setText("Alumnos");

        jComboAlumnos.setModel(new javax.swing.DefaultComboBoxModel<>(new ComboItem[] {}));
        jComboAlumnos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboAlumnosActionPerformed(evt);
            }
        });

        jButtonAgregarAlumno.setText("Agregar");
        jButtonAgregarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAgregarAlumnoActionPerformed(evt);
            }
        });

        jTableAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Identificador", "Nombre", "Apellido"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPaneAlumnos.setViewportView(jTableAlumnos);
        if (jTableAlumnos.getColumnModel().getColumnCount() > 0)
        {
            jTableAlumnos.getColumnModel().getColumn(0).setHeaderValue("Identificador");
            jTableAlumnos.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            jTableAlumnos.getColumnModel().getColumn(2).setHeaderValue("Apellido");
        }

        jButtonQuitarAlumno.setText("Quitar");
        jButtonQuitarAlumno.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonQuitarAlumnoActionPerformed(evt);
            }
        });

        jButtonQuitarProfesor.setText("Quitar");
        jButtonQuitarProfesor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonQuitarProfesorActionPerformed(evt);
            }
        });

        jTextFieldAsignatura.setEditable(false);

        javax.swing.GroupLayout jPanelGrillaLayout = new javax.swing.GroupLayout(jPanelGrilla);
        jPanelGrilla.setLayout(jPanelGrillaLayout);
        jPanelGrillaLayout.setHorizontalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelIdentificador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelPeriodo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabelHoraInicio)
                    .addComponent(jLabelProfesores)
                    .addComponent(jLabelAlumnos))
                .addGap(41, 41, 41)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGrillaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancelar)
                        .addGap(160, 160, 160))
                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                        .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jScrollPaneAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonQuitarAlumno))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jScrollPaneProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonQuitarProfesor))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldPeriodo, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jTextFieldHoraInicio)
                                    .addComponent(jTextFieldIdentificador))
                                .addGap(30, 30, 30)
                                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                        .addComponent(jLabelDia)
                                        .addGap(74, 74, 74)
                                        .addComponent(jComboDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                        .addComponent(jLabelNAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAsignatura))
                                    .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                        .addComponent(jLabelHoraFin)
                                        .addGap(43, 43, 43)
                                        .addComponent(jTextFieldHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jComboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregarProfesor))
                            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                                .addComponent(jComboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregarAlumno)))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanelGrillaLayout.setVerticalGroup(
            jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrillaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNAsignatura)
                    .addComponent(jTextFieldAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeriodo)
                    .addComponent(jTextFieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDia)
                    .addComponent(jComboDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHoraInicio)
                    .addComponent(jTextFieldHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHoraFin)
                    .addComponent(jTextFieldHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProfesores)
                    .addComponent(jComboProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarProfesor))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuitarProfesor))
                .addGap(28, 28, 28)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarAlumno)
                    .addComponent(jLabelAlumnos))
                .addGap(18, 18, 18)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonQuitarAlumno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelGrillaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        getContentPane().add(jPanelGrilla, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jTextFieldHoraFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoraFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoraFinActionPerformed

    private void jComboProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboProfesoresActionPerformed
        
    }//GEN-LAST:event_jComboProfesoresActionPerformed

    private void jButtonAgregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProfesorActionPerformed
        if (jComboProfesores.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
            ComboItem item = (ComboItem) jComboProfesores.getSelectedItem();
            try
            {
                Controlador.getInstance().addProfesorCursada(item.getId(), jTextFieldIdentificador.getText());
                Profesor profesor = Controlador.getInstance().consultaProfesor(item.getId());
                model.addRow(new Object[] { profesor.getId(), profesor.getNombre(), profesor.getApellido() });
            }
            catch (IdInvalidoException | EntidadInvalidaException | HorarioNoViableException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonAgregarProfesorActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        VentanaIndex.getInstancia().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonAgregarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarAlumnoActionPerformed
        if (jComboAlumnos.getItemCount() > 0)
        {
            DefaultTableModel model = (DefaultTableModel) jTableAlumnos.getModel();
            ComboItem item = (ComboItem) jComboAlumnos.getSelectedItem();
            try
            {
                Controlador.getInstance().addAlumnoCursada(item.getId(), jTextFieldIdentificador.getText());
                Alumno alumno = Controlador.getInstance().consultaAlumno(item.getId());
                model.addRow(new Object[] { alumno.getId(), alumno.getNombre(), alumno.getApellido() });
            }
            catch (IdInvalidoException | EntidadInvalidaException | HorarioNoViableException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonAgregarAlumnoActionPerformed

    private void jButtonQuitarAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarAlumnoActionPerformed
        if (jTableAlumnos.getSelectedRows().length == 1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableAlumnos.getModel();
            try
            {
                Controlador.getInstance()
                    .removeAlumnoCursada((String) jTableAlumnos.getValueAt(jTableAlumnos.getSelectedRow(), 0),
                                         jTextFieldIdentificador.getText());
                model.removeRow(jTableAlumnos.getSelectedRow());
            }
            catch (IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonQuitarAlumnoActionPerformed

    private void jButtonQuitarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonQuitarProfesorActionPerformed
        if (jTableProfesores.getSelectedRows().length == 1)
        {
            DefaultTableModel model = (DefaultTableModel) jTableProfesores.getModel();
            try
            {
                Controlador.getInstance()
                    .removeProfesorCursada((String) jTableProfesores.getValueAt(jTableProfesores.getSelectedRow(), 0),
                                           jTextFieldIdentificador.getText());
                model.removeRow(jTableProfesores.getSelectedRow());
            }
            catch (IdInvalidoException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButtonQuitarProfesorActionPerformed

    private void jComboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDiaActionPerformed

    private void jButtonGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGrabarActionPerformed
        if (jTextFieldPeriodo.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Periodo");
        else if (jComboDia.getSelectedItem().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Dia");
        else if (jTextFieldHoraInicio.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Hora Inicio");
        else if (jTextFieldHoraFin.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Ingrese Hora Fin");
        else
        {
            try
            {
                Controlador.getInstance()
                    .modificaCursada(jTextFieldIdentificador.getText(), jTextFieldPeriodo.getText(),
                                     (String) jComboDia.getSelectedItem(), jTextFieldHoraInicio.getText(),
                                     jTextFieldHoraFin.getText());
                JOptionPane.showMessageDialog(null, "La cursada ha sido modificada exitosamente");
                VentanaIndex.getInstancia().setVisible(true);
                this.setVisible(false);
            }
            catch (HoraInvalidaException | IdInvalidoException | PeriodoInvalidoException | HorarioNoViableException e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } 
    }//GEN-LAST:event_jButtonGrabarActionPerformed
    
    private void jComboAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboAlumnosActionPerformed
        
    }//GEN-LAST:event_jComboAlumnosActionPerformed

    private void jTextFieldHoraInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHoraInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHoraInicioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarAlumno;
    private javax.swing.JButton jButtonAgregarProfesor;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGrabar;
    private javax.swing.JButton jButtonQuitarAlumno;
    private javax.swing.JButton jButtonQuitarProfesor;
    private javax.swing.JComboBox<ComboItem> jComboAlumnos;
    private javax.swing.JComboBox<String> jComboDia;
    private javax.swing.JComboBox<ComboItem> jComboProfesores;
    private javax.swing.JLabel jLabelAlumnos;
    private javax.swing.JLabel jLabelCursada;
    private javax.swing.JLabel jLabelDia;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelHoraFin;
    private javax.swing.JLabel jLabelHoraInicio;
    private javax.swing.JLabel jLabelIdentificador;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNAsignatura;
    private javax.swing.JLabel jLabelPeriodo;
    private javax.swing.JLabel jLabelProfesores;
    private javax.swing.JPanel jPanelCabecera;
    private javax.swing.JPanel jPanelGrilla;
    private javax.swing.JScrollPane jScrollPaneAlumnos;
    private javax.swing.JScrollPane jScrollPaneProfesores;
    private javax.swing.JTable jTableAlumnos;
    private javax.swing.JTable jTableProfesores;
    private javax.swing.JTextField jTextFieldAsignatura;
    private javax.swing.JTextField jTextFieldHoraFin;
    private javax.swing.JTextField jTextFieldHoraInicio;
    private javax.swing.JTextField jTextFieldIdentificador;
    private javax.swing.JTextField jTextFieldPeriodo;
    // End of variables declaration//GEN-END:variables

}
