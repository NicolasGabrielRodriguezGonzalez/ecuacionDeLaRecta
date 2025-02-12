package interfaz;

import mundo.EcuacionDeLaRecta;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JButton btnAceptar;
    private JTextField textFieldX1, textFieldY1, textFieldX2, textFieldY2;
    private JLabel lblResultadoPendiente, lblResultadoEcuacion;
    private EcuacionDeLaRecta miEcuacionDeLaRecta;

    public VentanaPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 350);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Calcular Pendiente y Ecuación de la Recta");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(50, 10, 300, 20);
        contentPane.add(lblTitulo);

        // Campos de entrada
        JLabel lblX1 = new JLabel("Ingrese X1:");
        lblX1.setBounds(30, 50, 120, 20);
        contentPane.add(lblX1);

        textFieldX1 = new JTextField();
        textFieldX1.setBounds(150, 50, 150, 20);
        contentPane.add(textFieldX1);

        JLabel lblY1 = new JLabel("Ingrese Y1:");
        lblY1.setBounds(30, 80, 120, 20);
        contentPane.add(lblY1);

        textFieldY1 = new JTextField();
        textFieldY1.setBounds(150, 80, 150, 20);
        contentPane.add(textFieldY1);

        JLabel lblX2 = new JLabel("Ingrese X2:");
        lblX2.setBounds(30, 110, 120, 20);
        contentPane.add(lblX2);

        textFieldX2 = new JTextField();
        textFieldX2.setBounds(150, 110, 150, 20);
        contentPane.add(textFieldX2);

        JLabel lblY2 = new JLabel("Ingrese Y2:");
        lblY2.setBounds(30, 140, 120, 20);
        contentPane.add(lblY2);

        textFieldY2 = new JTextField();
        textFieldY2.setBounds(150, 140, 150, 20);
        contentPane.add(textFieldY2);

        // Botón de cálculo
        btnAceptar = new JButton("Calcular");
        btnAceptar.addActionListener(this);
        btnAceptar.setBounds(130, 180, 120, 30);
        contentPane.add(btnAceptar);

        // Etiquetas de resultado
        lblResultadoPendiente = new JLabel("Pendiente: ");
        lblResultadoPendiente.setBounds(50, 230, 300, 20);
        contentPane.add(lblResultadoPendiente);

        lblResultadoEcuacion = new JLabel("Ecuación de la recta:");
        lblResultadoEcuacion.setBounds(50, 260, 300, 20);
        contentPane.add(lblResultadoEcuacion);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAceptar) {
            try {
                double x1 = Double.parseDouble(textFieldX1.getText());
                double y1 = Double.parseDouble(textFieldY1.getText());
                double x2 = Double.parseDouble(textFieldX2.getText());
                double y2 = Double.parseDouble(textFieldY2.getText());

                miEcuacionDeLaRecta = new EcuacionDeLaRecta(x1, y1, x2, y2);
                double pendiente = miEcuacionDeLaRecta.calcularPendiente();
                String ecuacion = miEcuacionDeLaRecta.mostrarEcuacion();

                lblResultadoPendiente.setText("Pendiente: " + pendiente);
                lblResultadoEcuacion.setText("Ecuación: " + ecuacion);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese valores numéricos válidos", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "La pendiente no se puede calcular (división entre 0)", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
