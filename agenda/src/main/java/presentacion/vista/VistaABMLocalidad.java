package presentacion.vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import persistencia.conexion.Conexion;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VistaABMLocalidad extends JDialog {

	private JPanel contentPane;
	private JTable tablaLocalidad;
	DefaultTableModel modelTipoContacto;
	private String[] nombreColumnas = {"Localidad"};
//	private static VistaABMTipoContacto INSTANCE;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnModificar;
	private JTextField textTipoLocalidadNueva;
	private JTextField textTipoLocalidadModificada;
	private JButton btnSeleccionarLocalidad;
	private String localidadSeleccionada;//es el tipo que seleccione en la tabla
	
	public VistaABMLocalidad(java.awt.Frame vista, boolean b) 
	{
		super(vista,b);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 464, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//agregar el tipo a la base
				String nuevaLocalidad = textTipoLocalidadNueva.getText();
				
				agregarTipoContacto(nuevaLocalidad);
				refrescarTabla();
				textTipoLocalidadNueva.setText(null);
				habilitarbtnAgregar();
			}

		});
		btnAgregar.setBounds(10, 265, 168, 23);
		panel.add(btnAgregar);
		btnAgregar.setEnabled(false);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//aca borro el tipo a la base
				int[] filasSeleccionadas = tablaLocalidad.getSelectedRows();
				
				for (int fila : filasSeleccionadas) {
					PreparedStatement statement;
					Connection conexion = Conexion.getConexion().getSQLConexion();
					
					try 
					{
						statement = conexion.prepareStatement("DELETE FROM localidad WHERE Localidad = ?");
						statement.setString(1,(String) tablaLocalidad.getValueAt(fila, 0));
						if(statement.executeUpdate() > 0)
						{
							conexion.commit();
						}
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}
				}
				refrescarTabla();				
			}
		});
		btnBorrar.setBounds(203, 234, 89, 38);
		panel.add(btnBorrar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//aca modifico el tipo a la base
//				localidadSeleccionada es la que borro
				PreparedStatement statement;//borro el tipo
				Connection conexion = Conexion.getConexion().getSQLConexion();
				
				try 
				{
					statement = conexion.prepareStatement("DELETE FROM localidad WHERE Localidad = ?");
					statement.setString(1,localidadSeleccionada);
					if(statement.executeUpdate() > 0)
					{
						conexion.commit();
					}
				} 
				catch (SQLException e1) 
				{
					e1.printStackTrace();
				}
				
				String modificarTipoContacto = textTipoLocalidadModificada.getText();//agrego	
				agregarTipoContacto(modificarTipoContacto);
				
				refrescarTabla();
				textTipoLocalidadModificada.setText(null);
				textTipoLocalidadModificada.setEditable(false);
				btnModificar.setEnabled(false);
			}
		});
		btnModificar.setBounds(325, 276, 89, 23);
		panel.add(btnModificar);
		btnModificar.setEnabled(false);
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 444, 188);
		panel.add(spLocalidades);
		
		modelTipoContacto = (new DefaultTableModel(null,nombreColumnas){//las celdas no se pueden editar

		       @Override
		       public boolean isCellEditable(int row, int column) {
		          return false;
		       }
		});
		tablaLocalidad = new JTable(modelTipoContacto);

		tablaLocalidad.getTableHeader().setReorderingAllowed(false) ;//NO MOVER COLUMNAS
		spLocalidades.setViewportView(tablaLocalidad);
		
		textTipoLocalidadNueva = new JTextField();
		
		textTipoLocalidadNueva.addKeyListener(new KeyAdapter() {//modificado para que solo se puedan ingresar letras
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				char caracter = arg0.getKeyChar();
//				if(!Character.isLetter(caracter) && caracter!=KeyEvent.VK_SPACE)
//					arg0.consume();	
//			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				habilitarbtnAgregar();
			}
		});
		
		textTipoLocalidadNueva.setBounds(10, 234, 168, 20);
		panel.add(textTipoLocalidadNueva);
		textTipoLocalidadNueva.setColumns(10);
		
		textTipoLocalidadModificada = new JTextField();
		
		textTipoLocalidadModificada.addKeyListener(new KeyAdapter() {//modificado para que solo se puedan ingresar letras
//			@Override
//			public void keyTyped(KeyEvent arg0) {
//				char caracter = arg0.getKeyChar();
//				if(!Character.isLetter(caracter) && caracter!=KeyEvent.VK_SPACE)
//					arg0.consume();	
//			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				habilitarbtnModificar();
			}
		});
		
		textTipoLocalidadModificada.setBounds(305, 249, 159, 20);
		panel.add(textTipoLocalidadModificada);
		textTipoLocalidadModificada.setColumns(10);

		textTipoLocalidadModificada.setEditable(false);
		
		btnSeleccionarLocalidad = new JButton("habilitar modificacion");
		btnSeleccionarLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaLocalidad.getSelectedRowCount()==1) {
					int[] filasSeleccionadas = tablaLocalidad.getSelectedRows();
					btnModificar.setEnabled(true);
					textTipoLocalidadModificada.setText((String) tablaLocalidad.getValueAt(filasSeleccionadas[0], 0));
					localidadSeleccionada = (String) tablaLocalidad.getValueAt(filasSeleccionadas[0], 0);

					textTipoLocalidadModificada.setEditable(true);
					System.out.println(localidadSeleccionada);
				}
			}
		});
		btnSeleccionarLocalidad.setBounds(305, 210, 159, 23);
		panel.add(btnSeleccionarLocalidad);
		
		JLabel lblIngresarNuevoTipo = new JLabel("Ingresar nueva localidad:");
		lblIngresarNuevoTipo.setBounds(10, 210, 183, 34);
		panel.add(lblIngresarNuevoTipo);
		
		llenarTabla();//
	}
	
	public JTable getTablaTipoContacto()
	{
		return tablaLocalidad;
	}
	
	public DefaultTableModel getModel() {
		return modelTipoContacto;
	}
	
	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public void mostrarVentana()
	{
		this.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	public JButton getBtnModificar() 
	{
		return btnModificar;
	}
	
	private void refrescarTabla()
	{
		llenarTabla();
	}
	
	
	@SuppressWarnings("rawtypes")
	public void llenarTabla() {
		
			java.sql.PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conexion = Conexion.getConexion().getSQLConexion();
			
			ArrayList<String> localidades = new ArrayList<String>();
			
			try {
			String sql = "SELECT * FROM localidad";
			ps=conexion.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
//				comboboxLocalidad.addItem(rs.getString("Localidad"));
				localidades.add(rs.getString("Localidad"));
			}
			}catch(SQLException ex) {
				
			}
			
			this.getModel().setRowCount(0); //Para vaciar la tabla
			this.getModel().setColumnCount(0);
			this.getModel().setColumnIdentifiers(this.getNombreColumnas());

			
			Iterator it = localidades.iterator();
			while(it.hasNext()) {
				String localidad = (String) it.next();
				Object[] fila = {localidad};
				this.getModel().addRow(fila);
			}
				
	}
	
	
	protected void habilitarbtnAgregar() {
		if(!textTipoLocalidadNueva.getText().isEmpty()) {
			btnAgregar.setEnabled(true);
		}
		else {
			btnAgregar.setEnabled(false);
		}
	}
	
	private void agregarTipoContacto(String nuevoTipoContacto) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		try
		{
			statement = conexion.prepareStatement("INSERT INTO localidad (Localidad) values(?)");
			statement.setString(1, nuevoTipoContacto);
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
			}
		} 
		catch (SQLException es) 
		{
			es.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	protected void habilitarbtnModificar() {
		if(!textTipoLocalidadModificada.getText().isEmpty()) {
			btnModificar.setEnabled(true);
		}
		else {
			btnModificar.setEnabled(false);
		}
	}
}
