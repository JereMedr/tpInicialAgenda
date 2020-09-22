package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import dto.PersonaDTO;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personasEnTabla;
		private VentanaPersona ventanaPersona; 
		private Agenda agenda;
		private boolean modoEdicion;
		private PersonaDTO personaEditar;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(a->ventanaAgregarPersona(a));
			this.vista.getBtnBorrar().addActionListener(s->borrarPersona(s));
			this.vista.getBtnEditar().addActionListener(s->editarPersona(s));
			this.vista.getBtnReporte().addActionListener(r->mostrarReporte(r));
			this.ventanaPersona = VentanaPersona.getInstance();
			this.ventanaPersona.getBtnAgregarPersona().addActionListener(p->guardarPersona(p));
			this.agenda = agenda;
		}
		
		private void ventanaAgregarPersona(ActionEvent a) {
			this.ventanaPersona.mostrarVentana();
		}

		private void guardarPersona(ActionEvent p) {
			String nombre = this.ventanaPersona.getTxtNombre().getText();
			String tel = ventanaPersona.getTxtTelefono().getText();
			String email = ventanaPersona.getTxtEmail().getText();		//modificado
			String calle = ventanaPersona.getTxtCalle().getText();
			int altura = Integer.parseInt(ventanaPersona.getTxtDomicilioAltura().getText());
			int piso = Integer.parseInt(ventanaPersona.getTxtDomicilioPiso().getText());
			String depto = ventanaPersona.getTxtDomicilioDepto().getText();
			PersonaDTO nuevaPersona = new PersonaDTO(0, nombre, tel, email, calle, altura, piso, depto);	//modificado
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
			for (int fila : filasSeleccionadas)
			{
				this.agenda.borrarPersona(this.personasEnTabla.get(fila));
			}
			
			this.refrescarTabla();
		}
		
		public void editarPersona(ActionEvent s)
		{
			int[] filasSeleccionadas = this.vista.getTablaPersonas().getSelectedRows();
			for (int fila : filasSeleccionadas)
			{
				PersonaDTO persona_a_actualizar = this.personasEnTabla.get(fila);
//				persona_a_actualizar
				this.agenda.editarPersona(persona_a_actualizar);
			}
			
			this.refrescarTabla();
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

		public boolean isModoEdicion() {
			return modoEdicion;
		}

		public void setModoEdicion(boolean modoEdicion) {
			this.modoEdicion = modoEdicion;
		}

		public PersonaDTO getPersonaEditar() {
			return personaEditar;
		}

		public void setPersonaEditar(PersonaDTO personaEditar) {
			this.personaEditar = personaEditar;
		}

		
}
