package presentacion.vista;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import presentacion.controlador.Controlador;

public class VentanaConexion extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField txtServidor;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JTextField txtContraseña;
	private JTextField txtBaseDatos;
	private JButton btnActualizar;
	private Controlador controlador;
	private JPanel panel;

	public VentanaConexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
