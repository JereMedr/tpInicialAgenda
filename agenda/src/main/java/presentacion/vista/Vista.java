package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dto.PersonaDTO;

import javax.swing.JButton;
import persistencia.conexion.Conexion;


@SuppressWarnings("serial")
public class Vista extends JFrame
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre y apellido","Telefono","Email","Linkedin","Cumplea�os","Calle","Altura","Piso","Depto","CP", "TipoContacto", "Localidad"};
	private JButton btnActualizar;
	private JButton btnAbmLocalidad;
	private JButton btnAbmTipoContacto;
	
	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Agenda 2020");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 824, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 804, 269);
		panel.add(spPersonas);
		
		modelPersonas = (new DefaultTableModel(null,nombreColumnas){//las celdas no se pueden editar

		       @Override
		       public boolean isCellEditable(int row, int column) {
		          return false;
		       }
		});
		
		tablaPersonas = new JTable(modelPersonas);
		tablaPersonas.getTableHeader().setReorderingAllowed(false) ;//NO MOVER COLUMNAS
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);//para que esta?
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(114, 291, 122, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(586, 291, 122, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(586, 325, 122, 23);
		panel.add(btnReporte);
		
		btnActualizar = new JButton("actualizar");
		btnActualizar.setBounds(350, 291, 122, 23);
		panel.add(btnActualizar);

		btnAbmLocalidad = new JButton("ABM Localidad");
		btnAbmLocalidad.setBounds(114, 325, 122, 23);
		panel.add(btnAbmLocalidad);
		
		btnAbmTipoContacto = new JButton("ABM Tipo contacto");
		btnAbmTipoContacto.setBounds(335, 325, 151, 23);
		panel.add(btnAbmTipoContacto);
	}
	
	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() 
		{
			@Override
		    public void windowClosing(WindowEvent e) {
		        int confirm = JOptionPane.showOptionDialog(
		             null, "¿Estás seguro que quieres salir de la Agenda?", 
		             "Confirmación", JOptionPane.YES_NO_OPTION,
		             JOptionPane.QUESTION_MESSAGE, null, null, null);
		        if (confirm == 0) {
		        	Conexion.getConexion().cerrarConexion();
		           System.exit(0);
		        }
		    }
		});
		this.frame.setVisible(true);
	}
	
	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}
	
	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	public JButton getBtnActualizar()
	{
		return btnActualizar;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
	
	public JButton getBtnABMLocalidad() {
		return btnAbmLocalidad;
	}
	
	public JButton getBtnABMTipoContacto() {
		return btnAbmTipoContacto;
	}

	
	public void llenarTabla(List<PersonaDTO> personasEnTabla) {
		this.getModelPersonas().setRowCount(0); //Para vaciar la tabla
		this.getModelPersonas().setColumnCount(0);
		this.getModelPersonas().setColumnIdentifiers(this.getNombreColumnas());

		for (PersonaDTO p : personasEnTabla)
		{
//			int id = p.getIdPersona();
			String nombre = p.getNombre();
			String tel = p.getTelefono();
			String email = p.getEmail();
			String linkedin = p.getLinkedin();
			String calle = p.getCalle();
			int altura = p.getAltura();
			int piso = p.getPiso();
			String depto = p.getDepto();
			Date fecha = p.getFecha();
			int cp = p.getCp();
			String tipoContacto = p.getTipoContacto();
			String localidad = p.getLocalidad();
			Object[] fila = {nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp, tipoContacto, localidad};
			this.getModelPersonas().addRow(fila);
		}
	}

}
