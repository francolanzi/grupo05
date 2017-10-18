package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaNewAlumno extends JFrame{
    private JLabel lTitulo;
    private JLabel lLegajo;
    private JLabel lNombre;
    private JLabel lApellido;
    private JLabel lCalle;
    private JLabel lNumero;
    private JLabel lEmail;
    private JTextField tLegajo;
    private JTextField tNombre;
    private JTextField tApellido;
    private JTextField tCalle;
    private JTextField tNumero;
    private JTextField tEmail;
    private JButton grabar;
    private JButton cancelar;
    
    
    public VentanaNewAlumno() {
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
        lEmail= new JLabel();
        tLegajo= new JTextField();
        tNombre= new JTextField();
        tApellido= new JTextField();
        tCalle= new JTextField();
        tNumero= new JTextField();
        tEmail= new JTextField();
        grabar= new JButton();
        cancelar=new JButton();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lTitulo.setText("Nuevo Alumno");
        lLegajo.setText("Legajo");
        lNombre.setText("Nombre");
        lApellido.setText("Apellido");
        lCalle.setText("Calle");
        lNumero.setText("Número");
        lEmail.setText("Email");
        grabar.setText("Grabar");
        cancelar.setText("Cancelar");

        
        lTitulo.setFont(new Font("Tahoma",0,28));
        lLegajo.setFont(new Font("Verdana",0,16));
        lNombre.setFont(new Font("Verdana",0,16));
        lApellido.setFont(new Font("Verdana",0,16));
        lCalle.setFont(new Font("Verdana",0,16));
        lNumero.setFont(new Font("Verdana",0,16));
        lEmail.setFont(new Font("Verdana",0,16));
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
        formulario.add(lEmail);
        formulario.add(tEmail);
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
        VentanaNewAlumno ven=new VentanaNewAlumno();
        ven.setVisible(true);
    }
    
}
