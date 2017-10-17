package GUI;

import java.awt.BorderLayout;

import java.awt.Container;

import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaIndex extends JFrame{
    private JLabel titulo;
    private JButton alumnos;
    private JButton profesores;
    private JButton asignaturas;
    private JButton cursadas;

    
    public VentanaIndex() {
        iniciaComponentes();
        this.setLocationRelativeTo(null);
    }
    
    private void iniciaComponentes(){
        titulo= new JLabel();
        alumnos= new JButton();
        profesores=new JButton();
        asignaturas=new JButton();
        cursadas=new JButton();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo.setText("Programa de Gestión de Asignaturas");
        alumnos.setText("Alumnos");
        profesores.setText("Profesores");
        asignaturas.setText("Asignaturas");
        cursadas.setText("Cursadas");
        
        titulo.setFont(new Font("Tahoma",0,28));
        
        JPanel principal= new JPanel();
        JPanel menu= new JPanel();
        Container contprincipal= this.getContentPane();
        contprincipal.setLayout(new BorderLayout());
        contprincipal.add(principal, BorderLayout.CENTER);
        contprincipal.add(menu,BorderLayout.WEST);
        
        menu.setLayout(new GridLayout(7,1));
        menu.add(alumnos);
        menu.add(profesores);
        menu.add(asignaturas);
        menu.add(cursadas);
        principal.add(titulo);
        
        /*
        alumnos.addActionListener(l);
        profesores.addActionListener(l);
        asignaturas.addActionListener(l);
        cursadas.addActionListener(l);
    
        public void alumnosActionPerformed(ActionEvent evento){
            VentanaAlumnos ventAlumnos = new VentanaAlumnos();
            ventAlumnos.setVisible(true);
            this.setVisible(false);
        }        
                    
        public void profesoresActionPerformed(ActionEvent evento){
            VentanaProfesores ventProfesores = new VentanaProfesores();
            ventProfesores.setVisible(true);
            this.setVisible(false);
        }
                    
        public void asignaturasActionPerformed(ActionEvent evento){
            VentanaAsignaturas ventAsignaturas = new VentanaAsignaturas();
            ventAsignaturas.setVisible(true);
            this.setVisible(false);
        }
                    
        public void cursadasActionPerformed(ActionEvent evento){
            VentanaCursadas ventCursadas = new VentanaCursadas();
            ventCursadas.setVisible(true);
            this.setVisible(false);
        }          
        */   
    
    }

    /* Main Temporal para probar el diseño de la ventana.*/    
    public static void main(String[] args) {
        VentanaIndex ven=new VentanaIndex();
        ven.setVisible(true);
    }
}