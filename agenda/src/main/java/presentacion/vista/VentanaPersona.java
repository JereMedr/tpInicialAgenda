package presentacion.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;


@SuppressWarnings({ "unchecked", "rawtypes"})
public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private static VentanaPersona INSTANCE;
	private JTextField txtEmail;
	private JTextField txtDomicilioCalle;
	private JTextField txtDomicilioAltura;
	private JTextField txtDomicilioPiso;
	private JTextField txtDomicilioDepto;
	private JComboBox comboBoxDomicilioLocalidad;
	private	JComboBox comboBoxTipoContacto;
	private JButton btnCancelar;
	private JTextField txtLinkedin;
	private JDateChooser fechaCumple;
	private JTextField txtCP;
	private JButton btnNewButton;
	
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
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 614, 389);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 135, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Telefono");
		lblTelfono.setBounds(10, 39, 113, 14);
		panel.add(lblTelfono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(20, 67, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(177, 119, 64, 14);
		panel.add(lblDomicilio);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 147, 46, 14);
		panel.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(245, 147, 46, 14);
		panel.add(lblAltura);
		
		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 178, 46, 14);
		panel.add(lblPiso);
		
		JLabel lblDepto = new JLabel("Depto.");
		lblDepto.setBounds(155, 178, 46, 14);
		panel.add(lblDepto);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 218, 46, 14);
		panel.add(lblLocalidad);
		
		JLabel lblTipoDeContacto = new JLabel("Tipo de contacto");
		lblTipoDeContacto.setBounds(10, 254, 84, 14);
		panel.add(lblTipoDeContacto);
		
		JLabel lblFechaDeCumple = new JLabel("Fecha de cumplea\u00F1os");
		lblFechaDeCumple.setBounds(10, 296, 143, 14);
		panel.add(lblFechaDeCumple);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {//modificado para que solo se puedan ingrear letras
			@Override
			public void keyTyped(KeyEvent arg0) {
				char caracter = arg0.getKeyChar();
				if(!Character.isLetter(caracter) && caracter!=KeyEvent.VK_SPACE)
					arg0.consume();	
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				habilitarbtnAgregar();
			}
		});
		txtNombre.setBounds(127, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(new KeyAdapter() {//modificado para que solo se puedan ingresar numero
			@Override
			public void keyTyped(KeyEvent arg0) {
				char cadena = arg0.getKeyChar();
				if(cadena<'0'||cadena>'9')
					arg0.consume();
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				habilitarbtnAgregar();
			}
		});
		txtTelefono.setBounds(127, 36, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBounds(445, 7, 89, 23);
		btnAgregarPersona.setEnabled(false);	//para que no agregue hasta llenar los campos
		panel.add(btnAgregarPersona);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(127, 64, 164, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtDomicilioCalle = new JTextField();
		txtDomicilioCalle.addKeyListener(new KeyAdapter() {//modificado solo letras
			@Override
			public void keyTyped(KeyEvent e) {
				char caracter = e.getKeyChar();
				if(!Character.isLetter(caracter) && caracter!=KeyEvent.VK_SPACE)
					e.consume();	
			}
		});
		txtDomicilioCalle.setBounds(57, 144, 143, 20);
		panel.add(txtDomicilioCalle);
		txtDomicilioCalle.setColumns(10);
		
		txtDomicilioAltura = new JTextField();
		txtDomicilioAltura.addKeyListener(new KeyAdapter() {//solo numeros
			@Override
			public void keyTyped(KeyEvent e) {
				char cadena = e.getKeyChar();
				if(cadena<'0'||cadena>'9')
					e.consume();
			}
		});
		txtDomicilioAltura.setBounds(301, 144, 86, 20);
		panel.add(txtDomicilioAltura);
		txtDomicilioAltura.setColumns(10);
		
		txtDomicilioPiso = new JTextField();
		txtDomicilioPiso.addKeyListener(new KeyAdapter() {//solo numeros
			@Override
			public void keyTyped(KeyEvent e) {
				char cadena = e.getKeyChar();
				if(cadena<'0'||cadena>'9')
					e.consume();
			}
		});
		txtDomicilioPiso.setBounds(54, 175, 40, 20);
		panel.add(txtDomicilioPiso);
		txtDomicilioPiso.setColumns(10);
		
		txtDomicilioDepto = new JTextField();
		txtDomicilioDepto.setBounds(211, 175, 40, 20);
		panel.add(txtDomicilioDepto);
		txtDomicilioDepto.setColumns(10);
		
		comboBoxDomicilioLocalidad = new JComboBox();
		comboBoxDomicilioLocalidad.setBounds(106, 215, 158, 20);
		panel.add(comboBoxDomicilioLocalidad);
		
		String[] Localidades = {"Avellaneda","San Miguel","Prueba"};//feo pero es lo que hay(?		
		comboBoxDomicilioLocalidad.setModel(new DefaultComboBoxModel(Localidades));
		
		comboBoxTipoContacto = new JComboBox();
		comboBoxTipoContacto.setBounds(106, 251, 135, 20);
		panel.add(comboBoxTipoContacto);
		String[] TipoContacto = {"Trabajo","Familia","Amigos"};//agregar alguno mas	
		comboBoxTipoContacto.setModel(new DefaultComboBoxModel(TipoContacto));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(445, 35, 89, 23);
		panel.add(btnCancelar);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBounds(127, 95, 164, 20);
		panel.add(txtLinkedin);
		txtLinkedin.setColumns(10);
		
		JLabel lblLinkedin = new JLabel("Usuario linkedin");
		lblLinkedin.setBounds(10, 98, 84, 14);
		panel.add(lblLinkedin);
		
		fechaCumple = new JDateChooser();
		fechaCumple.setDateFormatString("dd/MM/yyyy");//cambiar el formato para guardalo en la base
		JTextFieldDateEditor editor = (JTextFieldDateEditor) fechaCumple.getDateEditor();
		editor.setEditable(false);
		fechaCumple.setBounds(183, 290, 108, 20);
		panel.add(fechaCumple);
		
		JLabel label = new JLabel("CP");
		label.setBounds(301, 178, 46, 14);
		panel.add(label);
		
		txtCP = new JTextField();
		txtCP.setBounds(322, 175, 86, 20);
		panel.add(txtCP);
		txtCP.setColumns(10);
		
		JButton btnNuevaLocalidad = new JButton("nueva localidad");
		btnNuevaLocalidad.setBounds(298, 214, 149, 23);
		panel.add(btnNuevaLocalidad);
		
		JButton btnNewButton = new JButton("nuevo tipo contacto");
		btnNewButton.setBounds(301, 248, 146, 23);
		panel.add(btnNewButton);
		
		this.setVisible(false);
	}
	
	protected void habilitarbtnAgregar() {
		if(!txtNombre.getText().isEmpty() && !txtTelefono.getText().isEmpty()) {
			btnAgregarPersona.setEnabled(true);
		}
		else {
			btnAgregarPersona.setEnabled(false);
		}
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
	
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
	
	public JTextField getTxtEmail() //agregado
	{
		return txtEmail;
	}
	
	public JTextField getTxtCalle() //agregado
	{
		return txtDomicilioCalle;
	}
	
	public JTextField getTxtDomicilioAltura() //agregado
	{
		return txtDomicilioAltura;
	}
	
	public JTextField getTxtDomicilioPiso() //agregado
	{
		return txtDomicilioPiso;
	}
	
	public JTextField getTxtDomicilioDepto() //agregado
	{
		return txtDomicilioDepto;
	}
	public JTextField getTxtLinkedin() {
		return txtLinkedin;
	}
	
	public JComboBox getComboboxContacto(){
		return comboBoxTipoContacto;
	}
	
	public JComboBox getComboboxLocalidad(){
		return comboBoxDomicilioLocalidad;
	}
	
	public JDateChooser	getDateChooser() {
		return fechaCumple;
	}
	
	public JTextField getTxtCP() {
		return txtCP;
	}
	
	public void cerrar()//cierro la ventana agregar y borro lo que escribi antes de agregar.
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtLinkedin.setText(null);
		this.txtDomicilioCalle.setText(null);
		this.txtDomicilioAltura.setText(null);
		this.txtDomicilioPiso.setText(null);
		this.txtDomicilioDepto.setText(null);
		this.fechaCumple.setDate(null);
		this.txtCP.setText(null);
		btnAgregarPersona.setEnabled(false);//agregado para que el boton no se habilite
		this.dispose();
	}
}

