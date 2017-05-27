package ConexionOracle;

import java.awt.event.*;
import javax.swing.*;

public class AplicacionNueva extends JFrame implements ActionListener {

    JLabel LMensaje;
    JButton Insertar, Modificar, Eliminar, Finalizar;

    public AplicacionNueva() {
        setLayout(null);
        Etiquetas();
        Botones();

    }

    public void Etiquetas() {
        LMensaje = new JLabel("SELECCIONE LA OPCION QUE DESEA EJECUTAR EN LOS REGISTROS");
        LMensaje.setBounds(50, 20, 500, 20);
        add(LMensaje);

    }

    public void Botones() {
        Insertar = new JButton("Insertar");
        Insertar.setBounds(10, 80, 100, 20);
        Insertar.addActionListener(this);
        add(Insertar);
        Modificar = new JButton("Modificar");
        Modificar.setBounds(120, 80, 100, 20);
        Modificar.addActionListener(this);
        add(Modificar);
        Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(10, 140, 100, 20);
        Eliminar.addActionListener(this);
        add(Eliminar);
        Finalizar = new JButton("Finalizar");
        Finalizar.setBounds(120, 140, 100, 20);
        Finalizar.addActionListener(this);
        add(Finalizar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Insertar) {
            InsertarOracle a = new InsertarOracle();
            a.setLocation(200, 200);
            a.setSize(500, 500);
            a.setVisible(true);

        }
        if (e.getSource() == Eliminar) {
            BorrarOracle b = new BorrarOracle();
            b.setLocation(200, 200);
            b.setSize(500, 500);
            b.setVisible(true);

        }
        if (e.getSource() == Modificar) {

        }
        if (e.getSource() == Finalizar) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        JFrame aplicacion = new AplicacionNueva();
        aplicacion.setSize(500, 500);
        aplicacion.setVisible(true);
        aplicacion.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
