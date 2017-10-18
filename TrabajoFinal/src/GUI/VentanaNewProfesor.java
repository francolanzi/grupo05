package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaNewProfesor extends JFrame{    
        private JLabel lTitulo;
        private JLabel lLegajo;
        private JLabel lNombre;
        private JLabel lApellido;
        private JLabel lCalle;
        private JLabel lNumero;
        private JLabel lTelefono;
        private JLabel lEmail;
        private JLabel lCompetencia;
        private JTextField tLegajo;
        private JTextField tNombre;
        private JTextField tApellido;
        private JTextField tCalle;
        private JTextField tNumero;
        private JTextField tTelefono;
        private JTextField tEmail;
        private JComboBox tCompetencia;
        private JButton grabar;
        private JButton cancelar;
        
        
        public VentanaNewProfesor() {
            iniciaComponentes();
            this.setLocationRelativeTo(null);
        }
        
        private void iniciaComponentes(){
            lTitulo= new JLabel();
            lLegajo= new JLabel();
            lNombre= new JLabel();
            lApellido= new JLabel();
            lCalle= new JLabel();
            lNumero= new JLabel();
            lTelefono= new JLabel();
            lEmail= new JLabel();
            lCompetencia= new JLabel();
            tLegajo= new JTextField();
            tNombre= new JTextField();
            tApellido= new JTextField();
            tCalle= new JTextField();
            tNumero= new JTextField();
            tTelefono= new JTextField();
            tEmail= new JTextField();
            tCompetencia= new JComboBox();
            grabar= new JButton();
            cancelar=new JButton();
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            lTitulo.setText("Nuevo Profesor");
            lLegajo.setText("Legajo");
            lNombre.setText("Nombre");
            lApellido.setText("Apellido");
            lCalle.setText("Calle");
            lNumero.setText("Número");
            lTelefono.setText("Telefono");
            lEmail.setText("Email");
            lCompetencia.setText("Competencia");
            grabar.setText("Grabar");
            cancelar.setText("Cancelar");

            
            lTitulo.setFont(new Font("Tahoma",0,28));
            lLegajo.setFont(new Font("Verdana",0,16));
            lNombre.setFont(new Font("Verdana",0,16));
            lApellido.setFont(new Font("Verdana",0,16));
            lCalle.setFont(new Font("Verdana",0,16));
            lNumero.setFont(new Font("Verdana",0,16));
            lTelefono.setFont(new Font("Verdana",0,16));
            lEmail.setFont(new Font("Verdana",0,16));
            lCompetencia.setFont(new Font("Verdana",0,16));
            grabar.setFont(new Font("Verdana",0,16));
            cancelar.setFont(new Font("Verdana",0,16));

            
            JPanel principal= new JPanel();
            JPanel formulario= new JPanel();
            JPanel botonera= new JPanel();
            Container contprincipal= this.getContentPane();
            contprincipal.setSize(800,600);
            contprincipal.setLayout(new BorderLayout());
            contprincipal.add(principal, BorderLayout.NORTH);
            contprincipal.add(formulario,BorderLayout.WEST);
            contprincipal.add(botonera,BorderLayout.SOUTH);
            
            tLegajo.setEnabled(false);
            tLegajo.setPreferredSize(new Dimension(200,20));       

           // tCompetencia.setModel(new DefaultComboBoxModel<>());

            formulario.setLayout(new GridLayout(6,1,5,5));
            formulario.add(lLegajo);
            formulario.add(tLegajo);
            formulario.add(lNombre);
            formulario.add(tNombre);
            formulario.add(lApellido);
            formulario.add(tApellido);
            formulario.add(lCalle);
            formulario.add(tCalle);
            formulario.add(lNumero);
            formulario.add(tNumero);
            formulario.add(lTelefono);
            formulario.add(tTelefono);
            formulario.add(lEmail);
            formulario.add(tEmail);
            formulario.add(lCompetencia);
            formulario.add(tCompetencia);
            principal.setLayout(new FlowLayout());
            principal.add(lTitulo);
            botonera.setLayout(new GridLayout(1,5,0,0));
            grabar.setPreferredSize(new Dimension(200,20));    
            cancelar.setPreferredSize(new Dimension(200,200)); 
            botonera.add(grabar);
            botonera.add(cancelar);
            
              
        }

        
        /* Main Temporal para probar el diseño de la ventana.*/    
        public static void main(String[] args) {
            VentanaNewProfesor ven=new VentanaNewProfesor();
            ven.setVisible(true);
        }
        
}
