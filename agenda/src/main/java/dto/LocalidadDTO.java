package dto;

public class LocalidadDTO {
<<<<<<< HEAD
	private int id;
	private String nombre;
	private ProvinciaDTO provincia;
	
}
=======
	private int idLocalidad;
	private String nombreLocalidad;
	private ProvinciaDTO provincia;
	
	public LocalidadDTO(int idLocalidad, String Localidad){
		this.idLocalidad = idLocalidad;
		this.nombreLocalidad = Localidad;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public String getNombreLocalidad() {
		return nombreLocalidad;
	}

	public void setLocalidad(String localidad) {
		nombreLocalidad = localidad;
	}


}
>>>>>>> 5f337e91eddb122c752e1df33a3a2b4b1e573cbd
