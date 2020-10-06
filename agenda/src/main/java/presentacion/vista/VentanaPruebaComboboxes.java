package presentacion.vista;



import javax.swing.JFrame;
import javax.swing.JLabel;

import persistencia.conexion.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

@SuppressWarnings("serial")
public class VentanaPruebaComboboxes extends JFrame {

	private static VentanaPruebaComboboxes INSTANCE;
	
	public static VentanaPruebaComboboxes getInstance()
	{
		if(INSTANCE == null)
		{
			INSTANCE = new VentanaPruebaComboboxes();
			return new VentanaPruebaComboboxes();
		}
		else
			return INSTANCE;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public VentanaPruebaComboboxes() {
		super();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 350);
		getContentPane().setLayout(null);
		
		JLabel lblPais = new JLabel("pais");
		lblPais.setBounds(92, 124, 46, 14);
		getContentPane().add(lblPais);
		
		JLabel lblPrivincia = new JLabel("provincia");
		lblPrivincia.setBounds(244, 124, 80, 14);
		getContentPane().add(lblPrivincia);
		
		JLabel lblLocalidad = new JLabel("localidad");
		lblLocalidad.setBounds(414, 124, 70, 14);
		getContentPane().add(lblLocalidad);
		
		
		
		JComboBox comboBoxPais = new JComboBox();
		comboBoxPais.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar Pais"}));
		comboBoxPais.setBounds(56, 151, 120, 20);
		getContentPane().add(comboBoxPais);
		
		
		llenarComboPais(comboBoxPais);
		
		
		JComboBox comboBoxProvincia = new JComboBox();
//		comboBoxProvincia.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar provincia"}));
		comboBoxProvincia.setBounds(215, 151, 131, 20);
		getContentPane().add(comboBoxProvincia);
		
		
		JComboBox comboBoxLocalidad = new JComboBox();
//		comboBoxLocalidad.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar localidad"}));
		comboBoxLocalidad.setBounds(394, 149, 151, 20);
		getContentPane().add(comboBoxLocalidad);
		
		comboBoxPais.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(arg0.getStateChange() == ItemEvent.SELECTED) {
				
					if(comboBoxPais.getSelectedIndex()>0) {
						String pais = (String) comboBoxPais.getSelectedItem();
						llenarComboProvincia(comboBoxProvincia, pais);
					}else {
						comboBoxProvincia.removeAllItems();
						comboBoxLocalidad.removeAllItems();
					}
				}
			}
		});
		
		comboBoxProvincia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String pais = (String) comboBoxPais.getSelectedItem();
					String provincia = (String) comboBoxProvincia.getSelectedItem();
					llenarComboLocalidad(comboBoxLocalidad,pais,provincia);
				}
			}
		});
		
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void llenarComboPais(JComboBox comboBoxPais) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
//		vaciarCombo(comboBoxPais);
		
		try {
		String sql = "SELECT DISTINCT Pais FROM Ubicacion";
		ps=conexion.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			comboBoxPais.addItem(rs.getString("Pais"));
		}
		}catch(SQLException ex) {
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void vaciarCombo(JComboBox combo) {
		combo.removeAllItems();
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void llenarComboLocalidad(JComboBox comboBox, String pais, String provincia) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		vaciarCombo(comboBox);
		
		try {
		String sql = "SELECT distinct localidad FROM Ubicacion where pais = '"+pais+"' and provincia = '"+provincia+"'";//SELECT distinct localidad FROM Ubicacion where pais = 'Argentina' and provincia = 'Buenos Aires';
//		System.out.println(sql);
		ps=conexion.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			comboBox.addItem(rs.getString("localidad"));
		}
		}catch(SQLException ex) {
			
		}
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected void llenarComboProvincia (JComboBox comboBox, String pais) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		vaciarCombo(comboBox);
		
		try {
		String sql = "SELECT distinct provincia FROM Ubicacion where pais = '"+pais+"'";//SELECT distinct provincia FROM Ubicacion where pais = 'Argentina';
		
		ps=conexion.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			comboBox.addItem(rs.getString("provincia"));
		}
		}catch(SQLException ex) {
			
		}
		
	}

	public void mostrarVentana()
	{

		this.setVisible(true);
	}
}
