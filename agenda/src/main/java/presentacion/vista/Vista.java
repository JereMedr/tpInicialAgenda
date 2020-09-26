package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import dto.PersonaDTO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JButton;
import persistencia.conexion.Conexion;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class Vista extends JFrame
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"Nombre y apellido","Telefono","Email","Linkedin","Cumplea�os","Calle","Altura","Piso","Depto","CP"};
	private JButton btnActualizar;
	
	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Agenda 2020");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 724, 350);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 704, 269);
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
		btnAgregar.setBounds(73, 291, 89, 23);
		panel.add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(397, 291, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(559, 291, 89, 23);
		panel.add(btnReporte);
		
		btnActualizar = new JButton("actualizar");
		btnActualizar.setBounds(235, 291, 89, 23);
		panel.add(btnActualizar);
		
		JButton btnMiReporte = new JButton("mi reporte");
		btnMiReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Connection conexion = Conexion.getConexion().getSQLConexion();
//				JasperReport mireporte = null;
//				String path = "C:\\Users\\Marco\\Desktop\\TPACAROMPER\\agenda\\reportes\\prueba.jasper";
//				
//				mireporte = (JasperReport) JRLoader.loadObjectFromFile(path);
//				JasperPrint jprint = JasperFillManager.fillReport(mireporte,null,conexion);
//				
//				JasperViewer view = new JasperViewer(jprint,false);
//				
//				view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//				
//				view.setVisible(true);
				
				JasperReport reporte = null;
	              
				URL in = this.getClass().getResource("/reportes/prueba.jasper");
			   reporte= (JasperReport) JRLoader.loadObject(in);
               
               JasperPrint jprint = JasperFillManager.fillReport(reporte, null, conexion);
               
               JasperViewer view = new JasperViewer(jprint, false);
               
               view.setVisible(true);
				
				
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnMiReporte.setBounds(323, 325, 89, 23);
		panel.add(btnMiReporte);
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
			Object[] fila = {nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp};
			this.getModelPersonas().addRow(fila);
		}
	}
}
