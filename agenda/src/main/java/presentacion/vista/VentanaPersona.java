package presentacion.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;


@SuppressWarnings({ "unchecked", "rawtypes"})
public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField textEmail;
	private JTextField textDomicilioCalle;
	private JTextField textDomicilioAltura;
	private JTextField textDomicilioPiso;
	private JTextField textDomicilioDepto;
	private JComboBox comboBoxDomicilioLocalidad;
	private	JComboBox comboBoxTipoContacto;
	
	public static VentanaPersona getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersona(); 	
			return new VentanaPersona();
		}
		else
			return INSTANCE;
	}
	private VentanaPersona() 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 342);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 460, 281);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 39, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 67, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(162, 95, 46, 14);
		panel.add(lblDomicilio);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 114, 46, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(245, 114, 46, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 150, 46, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto.");
		lblDepto.setBounds(245, 150, 46, 14);
		panel.add(lblDepto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 183, 46, 14);
		panel.add(lblLocalidad);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(10, 228, 84, 14);
		panel.add(lblTipoDeContacto);
		
		JLabel lblFechaDeCumpleaos = new JLabel("Fecha de cumplea\u00F1os");
		lblFechaDeCumpleaos.setBounds(10, 253, 113, 14);
		panel.add(lblFechaDeCumpleaos);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(105, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(105, 36, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(315, 7, 89, 23);
		panel.add(btnAgregarPersona);
		
		textEmail = new JTextField();
		textEmail.setBounds(105, 64, 164, 20);
		panel.add(textEmail);
		textEmail.setColumns(10);
		
		textDomicilioCalle = new JTextField();
		textDomicilioCalle.setBounds(54, 111, 143, 20);
		panel.add(textDomicilioCalle);
		textDomicilioCalle.setColumns(10);
		
		textDomicilioAltura = new JTextField();
		textDomicilioAltura.setBounds(301, 111, 86, 20);
		panel.add(textDomicilioAltura);
		textDomicilioAltura.setColumns(10);
		
		textDomicilioPiso = new JTextField();
		textDomicilioPiso.setBounds(54, 147, 40, 20);
		panel.add(textDomicilioPiso);
		textDomicilioPiso.setColumns(10);
		
		textDomicilioDepto = new JTextField();
		textDomicilioDepto.setBounds(301, 147, 40, 20);
		panel.add(textDomicilioDepto);
		textDomicilioDepto.setColumns(10);
		
		comboBoxDomicilioLocalidad = new JComboBox();
		comboBoxDomicilioLocalidad.setBounds(64, 180, 205, 20);
		panel.add(comboBoxDomicilioLocalidad);
		
		String[] Localidades = {"Avellaneda","San Miguel","Prueba"};//feo pero es lo que hay(?		
		comboBoxDomicilioLocalidad.setModel(new DefaultComboBoxModel(Localidades));
		
		comboBoxTipoContacto = new JComboBox();
		comboBoxTipoContacto.setBounds(104, 225, 135, 20);
		panel.add(comboBoxTipoContacto);
		String[] TipoContacto = {"Trabajo","Familia","Amigos"};//agregar alguno mas	
		comboBoxTipoContacto.setModel(new DefaultComboBoxModel(TipoContacto));
		
		

		
		this.setVisible(false);
	}

	public JTextField getTextEmail() {
		return textEmail;
	}


	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}


	public JTextField getTextDomicilioCalle() {
		return textDomicilioCalle;
	}

	
	public void setTextDomicilioCalle(JTextField textDomicilioCalle) {
		this.textDomicilioCalle = textDomicilioCalle;
	}


	public JTextField getTextDomicilioAltura() {
		return textDomicilioAltura;
	}


	public void setTextDomicilioAltura(JTextField textDomicilioAltura) {
		this.textDomicilioAltura = textDomicilioAltura;
	}


	public JTextField getTextDomicilioPiso() {
		return textDomicilioPiso;
	}


	public void setTextDomicilioPiso(JTextField textDomicilioPiso) {
		this.textDomicilioPiso = textDomicilioPiso;
	}


	public JTextField getTextDomicilioDepto() {
		return textDomicilioDepto;
	}


	public void setTextDomicilioDepto(JTextField textDomicilioDepto) {
		this.textDomicilioDepto = textDomicilioDepto;
	}


	public JComboBox getComboBoxDomicilioLocalidad() {
		return comboBoxDomicilioLocalidad;
	}


	public void setComboBoxDomicilioLocalidad(JComboBox comboBoxDomicilioLocalidad) {
		this.comboBoxDomicilioLocalidad = comboBoxDomicilioLocalidad;
	}


	public JComboBox getComboBoxTipoContacto() {
		return comboBoxTipoContacto;
	}


	public void setComboBoxTipoContacto(JComboBox comboBoxTipoContacto) {
		this.comboBoxTipoContacto = comboBoxTipoContacto;
	}


	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}


	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}


	public void setBtnAgregarPersona(JButton btnAgregarPersona) {
		this.btnAgregarPersona = btnAgregarPersona;
	}


	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}

	public void cerrar()
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.textDomicilioCalle.setText(null);
		this.dispose();
	}
}
