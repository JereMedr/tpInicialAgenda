package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaPersonaActualizar;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener {
	
	private Vista vista;
	private List<PersonaDTO> personasEnTabla;
	private VentanaPersona ventanaPersona; 
	private VentanaPersonaActualizar ventanaPersonaActualizar;
	private Agenda agenda;

	
	
	public Controlador(Vista vista, Agenda agenda) {

		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
		this.vista.getBtnActualizar().addActionListener(a->ventanaActualizarPersona(a));
		this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
		this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
		this.ventanaPersona = VentanaPersona.getInstance();
		this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
		this.ventanaPersona.getBtnCancelar().addActionListener(p->cancelarCarga(p));
//		this.ventanaPersonaActualizar = VentanaPersonaActualizar.getInstance();
		this.ventanaPersonaActualizar =  new VentanaPersonaActualizar (this.vista,true);
		this.ventanaPersonaActualizar.getBtnAgregarPersona().addActionListener(p->actualizarPersona(p));
		this.ventanaPersonaActualizar.getBtnCancelar().addActionListener(p->cancelarActualizacion(p));
		this.agenda = agenda;
	}
	
	private void cancelarCarga(ActionEvent p) {
		this.ventanaPersona.cerrar();
	}

	private void cancelarActualizacion(ActionEvent p) {
		this.ventanaPersonaActualizar.cerrar();
	}

	private void ventanaAgregarPersona(ActionEvent a) {
		this.ventanaPersona.setTitle("Agregar contacto");	
		this.ventanaPersona.mostrarVentana();
			
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
		System.out.println(fecha);
		int cp = Integer.parseInt(ventanaPersona.getTxtCP().getText());
		PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp);	//modificado
		System.out.println(ventanaPersona.getComboboxContacto().getSelectedItem());//obtengo el tipo de contacto seleccionado del combobox
		System.out.println(ventanaPersona.getComboboxLocalidad().getSelectedItem());//obtengo la localidad seleccionada
		
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
//		System.out.println(fecha);
		int cp = Integer.parseInt(ventanaPersonaActualizar.getTxtCP().getText());
		
		PersonaDTO nuevaPersona = new PersonaDTO(id, nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp);	//modificado
		System.out.println(ventanaPersonaActualizar.getComboboxContacto().getSelectedItem());//obtengo el tipo de contacto seleccionado del combobox
		System.out.println(ventanaPersonaActualizar.getComboboxLocalidad().getSelectedItem());//obtengo la localidad seleccionada

		
		
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
