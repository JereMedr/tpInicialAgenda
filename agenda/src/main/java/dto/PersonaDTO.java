package dto;

import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String linkedin;
	private String email;//modificado aca
	private String calle;
	private int altura;
	private int piso;
	private String depto;
	private Date fecha;
	private int cp;
	private String tipoContacto;
	private String localidad ;


	public PersonaDTO(int idPersona, String nombre, String telefono, String email, String linkedin, Date fecha, String calle,int altura,int piso, String depto, int cp, String tipoContacto, String localidad)//modificado
	{
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;	//modificado
		this.calle = calle;
		this.setAltura(altura);
		this.setPiso(piso);
		this.setDepto(depto);
		this.setLinkedin(linkedin);
		this.setFecha(fecha);
		this.setCp(cp);
		this.setTipoContacto(tipoContacto);
		this.setLocalidad(localidad);
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public String getEmail() {	//agregado
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "PersonaDTO [" + idPersona + "," + nombre + "," + telefono + ","+ email + ","+ linkedin +","+ calle + "," + altura + "," + piso + "," + depto + "]";
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public String getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(String tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
}
