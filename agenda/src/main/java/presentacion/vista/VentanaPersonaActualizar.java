package presentacion.vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.itextpdf.awt.geom.misc.RenderingHints.Key;

import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings({ "unchecked", "rawtypes"})
public class VentanaPersonaActualizar extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnActualizarPersona;
	private static VentanaPersonaActualizar INSTANCE;
	private JTextField txtEmail;
	private JTextField txtDomicilioCalle;
	private JTextField txtDomicilioAltura;
	private JTextField txtDomicilioPiso;
	private JTextField txtDomicilioDepto;
	private JComboBox comboBoxDomicilioLocalidad;
	private	JComboBox comboBoxTipoContacto;
	
	public static VentanaPersonaActualizar getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPersonaActualizar(); 	
			return new VentanaPersonaActualizar();
		}
		else
			return INSTANCE;
	}

	
	private VentanaPersonaActualizar() 
	{
		super();
		
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
		txtNombre.addKeyListener(new KeyAdapter() {//modificado para que solo se puedan ingrear letras
			@Override
			public void keyTyped(KeyEvent arg0) {
				char caracter = arg0.getKeyChar();
				if(!Character.isLetter(caracter) && caracter!=KeyEvent.VK_SPACE)
					arg0.consume();	
			}
		});
		txtNombre.setBounds(105, 8, 164, 20);
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
		});
		txtTelefono.setBounds(105, 36, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnActualizarPersona = new JButton("Actualizar");
		btnActualizarPersona.setBounds(315, 7, 89, 23);
		panel.add(btnActualizarPersona);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(105, 64, 164, 20);
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
		txtDomicilioCalle.setBounds(54, 111, 143, 20);
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
		txtDomicilioAltura.setBounds(301, 111, 86, 20);
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
		txtDomicilioPiso.setBounds(54, 147, 40, 20);
		panel.add(txtDomicilioPiso);
		txtDomicilioPiso.setColumns(10);
		
		txtDomicilioDepto = new JTextField();
		txtDomicilioDepto.setBounds(301, 147, 40, 20);
		panel.add(txtDomicilioDepto);
		txtDomicilioDepto.setColumns(10);
		
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
		return btnActualizarPersona;
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
	
	public void cerrar()//cierro la ventana actualizar y borro lo que escribi antes de agregar.
	{
		this.txtNombre.setText(null);
		this.txtTelefono.setText(null);
		this.txtEmail.setText(null);
		this.txtDomicilioCalle.setText(null);
		this.txtDomicilioAltura.setText(null);
		this.txtDomicilioPiso.setText(null);
		this.txtDomicilioDepto.setText(null);
		this.dispose();
	}
}