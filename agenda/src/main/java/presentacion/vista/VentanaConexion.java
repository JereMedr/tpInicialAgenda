package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VentanaConexion extends JFrame {
	
	private JPanel contentPane;
	private JTextField textIP;
	private JTextField textPuerto;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JButton btnConectar;
	private JLabel labelNotificarConexion;

	public VentanaConexion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setTitle("Conectar a base de dato");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textIP = new JTextField();
		textIP.setBounds(178, 66, 86, 20);
		contentPane.add(textIP);
		textIP.setColumns(10);
		
		textPuerto = new JTextField();
		textPuerto.setBounds(178, 97, 86, 20);
		contentPane.add(textPuerto);
		textPuerto.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(178, 128, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(178, 159, 86, 20);
		contentPane.add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel lblIp = new JLabel("Ip");
		lblIp.setBounds(100, 69, 68, 14);
		contentPane.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setBounds(100, 100, 68, 14);
		contentPane.add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(100, 131, 68, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(100, 162, 68, 14);
		contentPane.add(lblContrasea);
		
		btnConectar = new JButton("Conectar");
		btnConectar.setBounds(175, 208, 89, 23);
		contentPane.add(btnConectar);
		
		labelNotificarConexion = new JLabel("");
		labelNotificarConexion.setBounds(34, 10, 339, 48);
		contentPane.add(labelNotificarConexion);
		
		
	}
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JButton getBtnConectar() {
		return btnConectar;
	}
	
	public JTextField getTextIP() {
		return textIP;
	}
	public JTextField getTextPuerto() {
		return textPuerto;
	}
	public JTextField getTextUsuario() {
		return textUsuario;
	}
	public JTextField getTextContrasena() {
		return textContrasena;
	}
	public JLabel getLabelNotificar () {
		return labelNotificarConexion;
	}
	public void cerrar() {
		this.dispose();
	}
	
}
