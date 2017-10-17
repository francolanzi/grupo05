package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaAsignaturas extends JFrame{
    private JLabel titulo;
    private JButton agregar;
    private JButton modificar;
    private JButton eliminar;
    private JButton consultar;

    
    public VentanaAsignaturas() {
        iniciaComponentes();
        this.setLocationRelativeTo(null);
    }
    
    private void iniciaComponentes(){
        titulo= new JLabel();
        agregar= new JButton();
        modificar=new JButton();
        eliminar=new JButton();
        consultar=new JButton();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo.setText("Asignaturas");
        agregar.setText("Agregar");
        modificar.setText("Modificar");
        eliminar.setText("Eliminar");
        consultar.setText("Consultar");
        
        titulo.setFont(new Font("Tahoma",0,28));
        
        JPanel principal= new JPanel();
        JPanel menu= new JPanel();
        Container contprincipal= this.getContentPane();
        contprincipal.setLayout(new BorderLayout());
        contprincipal.add(principal, BorderLayout.CENTER);
        contprincipal.add(menu,BorderLayout.EAST);
        
        menu.setLayout(new GridLayout(7,1));
        menu.add(agregar);
        menu.add(modificar);
        menu.add(eliminar);
        menu.add(consultar);
        principal.add(titulo);
        
        /*
        agregar.addActionListener(l);
        modificar.addActionListener(l);
        eliminar.addActionListener(l);
        consultar.addActionListener(l);
        */
    
    }

    /* Main Temporal para probar el diseño de la ventana.*/    
    public static void main(String[] args) {
        VentanaAsignaturas ven=new VentanaAsignaturas();
        ven.setVisible(true);
    }
}
