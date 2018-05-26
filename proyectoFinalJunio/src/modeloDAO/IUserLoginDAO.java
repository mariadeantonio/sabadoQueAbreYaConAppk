package modeloDAO;

import java.util.List;

import modelo.UserLoginDTO;

public interface IUserLoginDAO {
	List<UserLoginDTO> getListaUserLogin();
	boolean addUserLogin(UserLoginDTO userDTO);
	boolean deleteUserLogin(String  login);
	boolean updateContrasenaUser(String login, String contrasena);
	boolean comprobarUserLogin(String login, String pass);
}
