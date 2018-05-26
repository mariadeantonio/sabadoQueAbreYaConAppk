package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.ClienteDTO;
import modelo.ConexionProfe;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public class VentaDAO implements IVentaDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
    VentaDTO vdto;
	String sql=null;
	
	@Override
	public List<VentaDTO> getListaVentas() {
		  List<VentaDTO> listaVentas=new ArrayList<>();
			String sql=" SELECT * FROM VENTAS ";
			//Creamos el objeto statement
		    try {
				Statement statement=conexion.createStatement();
			   //Creamos el objeto resultSet
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String dniCliente=resultSet.getString("DNI");
			        	String codigoProducto=resultSet.getString("CODIGO_PRODUCTO");
			        	int importe=resultSet.getInt("IMPORTE");
			            String fechaVenta=resultSet.getString("FECHA_VENTA");
			        	VentaDTO venta=new VentaDTO(dniCliente, codigoProducto, importe, fechaVenta);
			            listaVentas.add(venta);
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No lee getListaVentas");
			}
			
			return listaVentas;
	}

	@Override
	public boolean addVenta(ClienteDTO cliente, ProductoDTO producto) {
    boolean add = false;
		
		String sql = "INSERT INTO ventas(DNI, CODIGO_PRODUCTO, IMPORTE) VALUES (?, ?, ?);";
		try {
			System.out.println("add1");
		    preparedStatement = conexion.prepareStatement(sql);
		    System.out.println("add2");
			preparedStatement.setString(1, cliente.getDni());
			System.out.println("add3");
			preparedStatement.setString(2, producto.getCodigo_producto());
			System.out.println("add4");
			preparedStatement.setInt(3, producto.getPrecio());
			System.out.println("add5");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("No se pudo añadir la venta");

		}
		
		return add;
		
	}

	@Override
	public boolean deleteVenta(String dni, String  codigoProducto) {
		boolean delete= false;
		sql = "DELETE FROM ventas WHERE DNI = ? AND CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
		System.out.println(1);
			preparedStatement.setString(1, dni);
		System.out.println(2);
			preparedStatement.setString(2, codigoProducto);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
			System.out.println("Venta borrar perfectamente");
		} catch (SQLException e) {
			System.out.println("No se pudo borrar la venta");

		}
		
		return delete;
	}
	
	
	public static void main(String[] args) {
		VentaDAO vdao=new VentaDAO();
		ClienteDTO cd= new ClienteDTO("12345678A", " "," ","");
    	ProductoDTO pd=new ProductoDTO("C26", 467, 89, " ");
	    System.out.println(vdao.addVenta(cd, pd));
		//System.out.println(vdao.getListaVentas());
		//System.out.println(vdao.deleteVenta("22225678B", "A7"));
		System.out.println(vdao.getListaVentas());
	}

}
