package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.mysql.jdbc.PreparedStatement;

import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaPersonaActualizar;
import presentacion.vista.VentanaPruebaComboboxes;
import presentacion.vista.Vista;
import presentacion.vista.VistaABMLocalidad;
import presentacion.vista.VistaABMTipoContacto;
import dto.PersonaDTO;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Controlador implements ActionListener {
	
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private VentanaPersona ventanaPersona; 
	private VentanaPersonaActualizar ventanaPersonaActualizar;
	private Agenda agenda;
	private VistaABMTipoContacto ventanaTipoContacto;
	private VistaABMLocalidad ventanaLocalidad;
	private VentanaPruebaComboboxes ventanaDePrueba;
	
	public Controlador(Vista vista, Agenda agenda) {

		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
		this.vista.getBtnActualizar().addActionListener(a->ventanaActualizarPersona(a));
		this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
		
		this.ventanaTipoContacto = new VistaABMTipoContacto(this.vista,true);
		this.vista.getBtnABMTipoContacto().addActionListener(a->ventanaABMTipoContacto(a));//
//		this.ventanaTipoContacto.getBtnAgregar().addActionListener(a->agregarTipoContacto(a));
		
		this.ventanaLocalidad = new VistaABMLocalidad(this.vista,true);
		this.vista.getBtnABMLocalidad().addActionListener(a->ventanaABMLocalidad(a));//
		
		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
		this.ventanaPersona.getBtnCancelar().addActionListener(p->cancelarCarga(p));
		this.ventanaPersonaActualizar =  new VentanaPersonaActualizar (this.vista,true);
		this.ventanaPersonaActualizar.getBtnActualizarPersona().addActionListener(p->actualizarPersona(p));
		this.ventanaPersonaActualizar.getBtnCancelar().addActionListener(p->cancelarActualizacion(p));
		
		
		//vistaABMTipocontacto
//		this.ventanaTipoContacto = ventanaTipoContacto.getInstance();
	
//		this.ventanaTip
//		this.ventanaTipoContacto.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
//		this.ventanaTipoContacto.getBtnCancelar().addActionListener(p->cancelarCarga(p));
		this.ventanaDePrueba = VentanaPruebaComboboxes.getInstance();
		this.vista.getBtnPrueba().addActionListener(a->mostrarVentanaDePrueba(a));
		
		this.agenda = agenda;
	}
	

	private void mostrarVentanaDePrueba(ActionEvent a) {
		this.ventanaDePrueba.mostrarVentana();
	}


	private void lenarLocalidades(JComboBox comboboxLocalidad) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
		String sql = "SELECT * FROM Localidad";
		ps=conexion.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			comboboxLocalidad.addItem(rs.getString("Localidad"));
		}
		}catch(SQLException ex) {
			
		}
		
	}

	private void llenarContactos(JComboBox comboboxContacto) {
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try {
		String sql = "SELECT * FROM TipoContacto";
		ps=conexion.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()) {
			comboboxContacto.addItem(rs.getString("TipoContacto"));
		}
		}catch(SQLException ex) {
			
		}
	}

	private void cancelarCarga(ActionEvent p) {
		this.ventanaPersona.cerrar();
	}

	private void cancelarActualizacion(ActionEvent p) {
		this.ventanaPersonaActualizar.cerrar();
	}

	private void ventanaAgregarPersona(ActionEvent a) {
		this.ventanaPersona.setTitle("Agregar contacto");
		
		this.ventanaPersona.getComboboxContacto().removeAllItems();
//		this.ventanaPersona.getComboboxLocalidad().removeAllItems();
		lenarLocalidades(this.ventanaPersona.getComboboxLocalidad());
		llenarContactos(this.ventanaPersona.getComboboxContacto());
		
		this.ventanaPersona.mostrarVentana();
			
	}
	
	private void ventanaABMTipoContacto(ActionEvent a) {
		this.ventanaTipoContacto.setTitle("Tipo de contacto");	
		this.ventanaTipoContacto.mostrarVentana();
			
	}
	
	private void ventanaABMLocalidad(ActionEvent a) {
		this.ventanaLocalidad.setTitle("Localidad");	
		this.ventanaLocalidad.mostrarVentana();
		
	}
	
	
	private void ventanaActualizarPersona(ActionEvent a) {//solo se abre la ventana actualizar si seleccione 1 sola fila en el jtable
		
		this.ventanaPersonaActualizar.setTitle("Actualizar contacto");
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		if(filasSeleccionadas.length == 1) {
			ventanaPersonaActualizar.getTxtNombre().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getNombre());//copio los elementos de la tabla(jtable) a cada uno de los jtextfield
			ventanaPersonaActualizar.getTxtTelefono().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getTelefono());
			ventanaPersonaActualizar.getTxtEmail().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getEmail());
			ventanaPersonaActualizar.getTxtLinkedin().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getLinkedin());
			ventanaPersonaActualizar.getTxtCalle().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getCalle());
			ventanaPersonaActualizar.getTxtDomicilioAltura().setText(String.valueOf(this.personasEnTabla.get(filasSeleccionadas[0]).getAltura()));
			ventanaPersonaActualizar.getTxtDomicilioPiso().setText(String.valueOf(this.personasEnTabla.get(filasSeleccionadas[0]).getPiso()));
			ventanaPersonaActualizar.getTxtDomicilioDepto().setText(this.personasEnTabla.get(filasSeleccionadas[0]).getDepto());
			ventanaPersonaActualizar.getDateChooser().setDate(this.personasEnTabla.get(filasSeleccionadas[0]).getFecha());
			ventanaPersonaActualizar.getTxtCP().setText(String.valueOf(this.personasEnTabla.get(filasSeleccionadas[0]).getCp()));

			
			
			this.ventanaPersonaActualizar.getComboboxContacto().removeAllItems();
			this.ventanaPersonaActualizar.getComboboxLocalidad().removeAllItems();
			lenarLocalidades(this.ventanaPersonaActualizar.getComboboxLocalidad());
			llenarContactos(this.ventanaPersonaActualizar.getComboboxContacto());
			
			//selecciono el tipo de contacto de la base de datos y la selecciono
			this.ventanaPersonaActualizar.getComboboxContacto().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getTipoContacto());//bien!
			this.ventanaPersonaActualizar.getComboboxLocalidad().setSelectedItem(this.personasEnTabla.get(filasSeleccionadas[0]).getLocalidad());//bien!
			
			
			this.ventanaPersonaActualizar.mostrarVentana();
		}
	}
	
	
	private void guardarPersona(ActionEvent p) { 
//		if (this.ventanaPersona.getTxtNombre()!=null) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();

//		}
		String tel = ventanaPersona.getTxtTelefono().getText();
		String email = ventanaPersona.getTxtEmail().getText();		//modificado
		String calle = ventanaPersona.getTxtCalle().getText();
		int altura = Integer.parseInt(ventanaPersona.getTxtDomicilioAltura().getText());
		int piso = Integer.parseInt(ventanaPersona.getTxtDomicilioPiso().getText());
		String depto = ventanaPersona.getTxtDomicilioDepto().getText();
		String linkedin = ventanaPersona.getTxtLinkedin().getText();
//		Date fecha = ventanaPersona.getDateChooser().getDate();
		
		Date date = ventanaPersona.getDateChooser().getDate();
		long d = date.getTime();
		java.sql.Date fecha = new java.sql.Date(d);
		
		int cp = Integer.parseInt(ventanaPersona.getTxtCP().getText());
		String tipoContacto = (String) ventanaPersona.getComboboxContacto().getSelectedItem();
		String localidad = (String) ventanaPersona.getComboboxLocalidad().getSelectedItem();
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp, tipoContacto, localidad);	//modificado
//		System.out.println(ventanaPersona.getComboboxContacto().getSelectedItem());//obtengo el tipo de contacto seleccionado del combobox
//		System.out.println(ventanaPersona.getComboboxLocalidad().getSelectedItem());//obtengo la localidad seleccionada
		
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.ventanaPersona.cerrar();
		
		
	}

	
	private void mostrarReporte(ActionEvent r) {
		ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
		reporte.mostrar();	
	}

	
	public void borrarPersona(ActionEvent s)
	{
		int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
		
		for (int fila : filasSeleccionadas) {
			
			this.agenda.borrarPersona(this.personasEnTabla.get(fila));
		}
		
		this.refrescarTabla();
	}
	
	
	private void actualizarPersona(ActionEvent p) { //quiza usar flag para que no se borre la fila que seleccione del jtable
		int filaSeleccionada = this.vista.getTablaPersonas().getSelectedRows()[0];	
//		System.out.println(this.personasEnTabla.get(filaSeleccionada).toString());
		this.agenda.borrarPersona(this.personasEnTabla.get(filaSeleccionada));//borro a la persona seleccionada
		
		//aca "actualizo" 
		int id = this.personasEnTabla.get(filaSeleccionada).getIdPersona();//uso el mismo id para que no crear otro contacto al final			
		String nombre = this.ventanaPersonaActualizar.getTxtNombre().getText();
		String tel = ventanaPersonaActualizar.getTxtTelefono().getText();
		String email = ventanaPersonaActualizar.getTxtEmail().getText();		//modificado
		String calle = ventanaPersonaActualizar.getTxtCalle().getText();
		int altura = Integer.parseInt(ventanaPersonaActualizar.getTxtDomicilioAltura().getText());
		int piso = Integer.parseInt(ventanaPersonaActualizar.getTxtDomicilioPiso().getText());
		String depto = ventanaPersonaActualizar.getTxtDomicilioDepto().getText();
		String linkedin = ventanaPersonaActualizar.getTxtLinkedin().getText();
		
		Date date = ventanaPersonaActualizar.getDateChooser().getDate();//obtengo la fecha
		long d = date.getTime();
		java.sql.Date fecha = new java.sql.Date(d);
		int cp = Integer.parseInt(ventanaPersonaActualizar.getTxtCP().getText());
		String tipoContacto = (String) ventanaPersonaActualizar.getComboboxContacto().getSelectedItem();
		String localidad = (String) ventanaPersonaActualizar.getComboboxLocalidad().getSelectedItem();
		PersonaDTO nuevaPersona = new PersonaDTO(id, nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp, tipoContacto, localidad);	//modificado
//		System.out.println(ventanaPersonaActualizar.getComboboxContacto().getSelectedItem());//obtengo el tipo de contacto seleccionado del combobox
//		System.out.println(ventanaPersonaActualizar.getComboboxLocalidad().getSelectedItem());//obtengo la localidad seleccionada

		
		this.agenda.agregarPersona(nuevaPersona);
		this.refrescarTabla();
		this.ventanaPersonaActualizar.cerrar();
	}
	
	public void inicializar()
	{
		this.refrescarTabla();
		this.vista.show();
	}
	
	private void refrescarTabla()
	{
		this.personasEnTabla = agenda.obtenerPersonas();
		this.vista.llenarTabla(this.personasEnTabla);
	}
	


	@Override
	public void actionPerformed(ActionEvent e) { }
	
}
