import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;

public class BaseDatos {
	private FichaPolicia ficha;
	Connection conexion = null; //maneja la conexi�n
	Statement instruccion = null;// instrucci�n de consulta
	ResultSet conjuntoResultados = null;// maneja los resultados
	private JComboBox<Delincuente> listadoDelincuentes;

	
	
	public BaseDatos(JComboBox listadoDelincuentes) {
		// TODO Auto-generated constructor stub
		crearconexion();
		this.listadoDelincuentes=listadoDelincuentes;
	}
	
	public void crearconexion (){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			// establece la conexi�n a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/fichadelincuentes","root","tonphp");
			
		}catch( SQLException excepcionSql ){
			excepcionSql.printStackTrace();
		}// fin de catch
		catch( ClassNotFoundException noEncontroClase )
		{
			noEncontroClase.printStackTrace();
		}
		// fin de catch
	}
	
	public void leerDelincuentes (){
		try{
		// crea objeto Statement para consultar la base de datos
					instruccion = (Statement) conexion.createStatement();
					// consulta la base de datos
					conjuntoResultados = instruccion.executeQuery("SELECT ID,NombreYapellidos,Edad,Altura,Crimen FROM delincuentes");
					//Mostrar por pantalla
					while (conjuntoResultados.next())
					{
					   System.out.println("id="+conjuntoResultados.getObject("ID")+
					      ", Nombre="+conjuntoResultados.getObject("NombreYapellidos"));
					   Delincuente del=new Delincuente((String)conjuntoResultados.getObject("NombreYapellidos"),
							   							(int)conjuntoResultados.getObject("Edad"),
							   							(int)conjuntoResultados.getObject("Altura"),
							   							(String)conjuntoResultados.getObject("Crimen"),
							   							(int)conjuntoResultados.getObject("ID"));
					   			
					   
					   listadoDelincuentes.addItem(del);
					}
					conjuntoResultados.close();	
					
			}
		catch( SQLException excepcionSql ){
		excepcionSql.printStackTrace();}
		}
	
	public int insertarDelincuentes (String NombreApellidos, int Edad, String crimen, int Altura){
		// crea objeto Statement para consultar la base de datos
		try {
			instruccion = (Statement) conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// insercion en base de datos
		try {
			String sql="INSERT INTO `fichadelincuentes`.`delincuentes` (`NombreYapellidos`, `Edad`, `Altura`, `Crimen`) VALUES ("
					+ 													"'"+NombreApellidos+"', '"+Edad+"', '"+Altura+"', '"+crimen+"');";
			instruccion.executeUpdate(sql);
			
			//PARA GUARDAR EL ID
			sql = "SELECT * FROM delincuentes ORDER BY ID DESC LIMIT 1";
			conjuntoResultados = instruccion.executeQuery(sql);
			int ID=-1;
			//Mostrar por pantalla
			while (conjuntoResultados.next())
			{
				ID=(int)conjuntoResultados.getObject("ID");
			}
			conjuntoResultados.close();	
			return ID;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
			}
		}
	
		public void modificaDelincuentes ( int ID, String NombreApellidos, int Edad, String crimen, int Altura){
			// crea objeto Statement para consultar la base de datos
			try {
				instruccion = (Statement) conexion.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// insercion en base de datos
			try {
				String sql="UPDATE  `fichadelincuentes`.`delincuentes` SET "
						+ "`NombreYapellidos` ='"+NombreApellidos+"',"
						+"`Edad` =  '"+Edad+"',"
						+"`Altura` =  '"+Altura+"',"
						+"`Crimen` =  '"+crimen+"'"+
						 " WHERE  `delincuentes`.`ID` ="+ID+"";
				instruccion.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			}
		public void remove (int ID){
			try {
				instruccion = (Statement) conexion.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// insercion en base de datos
			try {
				String sql="DELETE FROM `fichadelincuentes`.`delincuentes` WHERE  `delincuentes`.`ID` ="+ID+"";
				instruccion.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}


