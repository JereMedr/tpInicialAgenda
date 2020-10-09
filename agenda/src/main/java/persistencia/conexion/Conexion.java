package persistencia.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class Conexion 
{
	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	
	
	private Conexion()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver"); // comentario prueba branch no borrado
			
			String ip = ConfiguracionDB.getValue("dbIP");
			String puerto = ConfiguracionDB.getValue("dbPuerto");
			String nombreDB = ConfiguracionDB.getValue("dbName");
			String usuario = ConfiguracionDB.getValue("dbUsuario");
			String pass = ConfiguracionDB.getValue("dbContrasena");
			
			this.connection = DriverManager.getConnection("jdbc:mysql://"+ ip + ":" + puerto +"/" + nombreDB,usuario,pass);
			
//			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda?useSSL=false","root","root");
			this.connection.setAutoCommit(false);
			log.info("Conexión exitosa");
		}
		catch(Exception e)
		{
			log.error("Conexión fallida", e);
		}
	}
	
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return this.connection;
	}
	
	public void cerrarConexion()
	{
		try 
		{
			this.connection.close();
			log.info("Conexion cerrada");
		}
		catch (SQLException e) 
		{
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
}
