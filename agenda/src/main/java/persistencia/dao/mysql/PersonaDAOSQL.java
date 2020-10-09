package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{																							//Modificado acaaa!!!!
	private static final String insert = "INSERT INTO personas(idPersona, Nombre, Telefono, Email, Linkedin, Fechacumple, Calle, Altura, Piso, Depto, CP, TipoContacto, Localidad) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
//	private static final String update = "UPDATE personas SET Nombre=?,Telefono=?,Email=?,Calle=?,Altura=?,Piso=?,Depto=? WHERE idPersona = ?";

	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail()); 
			statement.setString(5, persona.getLinkedin());

			Date date = persona.getFecha();
			long d = date.getTime();
			java.sql.Date fecha = new java.sql.Date(d);
			
			statement.setDate(6, fecha);
			statement.setString(7, persona.getCalle());
			statement.setInt(8, persona.getAltura());
			statement.setInt(9, persona.getPiso());
			statement.setString(10, persona.getDepto());
			statement.setInt(11, persona.getCp());
			statement.setString(12, persona.getTipoContacto());
			statement.setString(13, persona.getLocalidad());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return isInsertExitoso;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getPersonaDTO(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	
	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		Date fecha = resultSet.getDate("Fechacumple");
		String calle = resultSet.getString("Calle");
		int altura = resultSet.getInt("Altura");
		int piso = resultSet.getInt("Piso");
		String depto = resultSet.getString("Depto");
		String linkedin = resultSet.getString("Linkedin");
		int cp = resultSet.getInt("CP");
		String tipoContacto = resultSet.getString("TipoContacto");
		String localidad = resultSet.getString("Localidad");
		
		return new PersonaDTO(id, nombre, tel, email, linkedin, fecha, calle, altura, piso, depto, cp, tipoContacto, localidad);
	}
}
