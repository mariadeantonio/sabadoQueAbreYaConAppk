package modeloDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.ConexionProfe;
import modelo.UserLoginDTO;

public class UserLoginDAO implements IUserLoginDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
	Statement statement;
	String sql;
	@Override
	public List<UserLoginDTO> getListaUserLogin() {
		List<UserLoginDTO> listLogin=new ArrayList<>();
		System.out.println("entra en 01");
		sql = " SELECT * FROM user ;";
		System.out.println("entra en 02");
		try {
			 statement=conexion.createStatement();
			System.out.println("entra en 03");
		    ResultSet resultset = statement.executeQuery(sql);
		 System.out.println("entra en 1");
			while (resultset.next()){
				System.out.println("entra en 2");
				String login = resultset.getString("LOGIN");
				String pass = resultset.getString("PASS");
				String fecha=resultset.getString("FECHA");
				UserLoginDTO user = new UserLoginDTO(login, pass, fecha);
				listLogin.add(user);
			}
				
		} catch (SQLException e2) {
			System.out.println("No se pudo leer getListaUserLogin");
		}
		return listLogin;
	}

	@Override
	public boolean addUserLogin(UserLoginDTO userDTO) {
		  boolean add = false;
			
			String sql = "INSERT INTO USER (LOGIN , PASS) VALUES (?, ?);";
			try {
				System.out.println("Entra en tr11y");
			    preparedStatement = conexion.prepareStatement(sql);
			    System.out.println("Entra en tr12y");
				preparedStatement.setString(1, userDTO.getLogin());
				System.out.println("Entra en tr13y");
				preparedStatement.setString(2, userDTO.getPass());
				int rows = preparedStatement.executeUpdate();
				if (rows != 0)
					add = true;
			} catch (SQLException e) {
				System.out.println("No se pudo añadir el user");

			}
			
			return add;	
	}

	@Override
	public boolean deleteUserLogin(String login) {
		boolean delete= false;
		sql = "DELETE FROM user WHERE LOGIN = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, login);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			System.out.println("No se pudo borrar el usuario");

		}
		
		return delete;
	}

	@Override
	public boolean updateContrasenaUser(String login, String contrasena) {
		boolean update = false;
		
		String sql = "UPDATE user SET PASS=?   WHERE LOGIN = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("1");
			preparedStatement.setString(1, contrasena);
			System.out.println("3");
			preparedStatement.setString(2, login);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = true;
		} catch (SQLException e) {
			System.out.println("No se pudo modificar la contrasena");

		}
		
		return update;
	}

	@Override
	public boolean comprobarUserLogin(String login, String pass) {
		boolean existe =false;
		sql = "Select * FROM user WHERE LOGIN=? AND  PASS=?;";
	
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("Hace consulta");
			preparedStatement.setString(1, login);
			System.out.println("login entra");
			preparedStatement.setString(2, pass);
			System.out.println("pass entra");
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println("Ejecuta sql");
		
		    if (resultSet.next()==true)
			existe = true;
			
			/*while(resultSet.next()) {
			existe=true;	
			}*/
			
		} catch (SQLException e) {
			
			System.out.println("No se pudo comprobar");
			
		}		
		
		return existe;
	}
	
	public static void main(String[] args) {
		UserLoginDAO u1=new UserLoginDAO();
		System.out.println(u1.getListaUserLogin());
		UserLoginDTO ut1=new UserLoginDTO("rosa5", "rosa5");
		System.out.println(u1.getListaUserLogin());
		//System.out.println(u1.addUserLogin(ut1));
		//System.out.println(u1.deleteUserLogin("rosa5"));
		//System.out.println (u1.updateContrasenaUser("rosa5", "12345"));
		System.out.println(u1.comprobarUserLogin("rosa5", "12345"));
	}
	
	

}
