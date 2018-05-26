package modeloDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.ClienteDTO;
import modelo.ConexionProfe;
import modelo.ProductoDTO;


public class ProductoDAO implements IProductoDAO {
	private static Connection conexion= ConexionProfe.getConexion();
	PreparedStatement preparedStatement;
	ProductoDTO pdto;
	String sql=null;
	
	
	@Override
	public List<ProductoDTO> getListaProductos() {
	   List<ProductoDTO> listaProductos=new ArrayList<>();
		String sql=" SELECT * FROM PRODUCTOS ";
		//Creamos el objeto statement
	    try {
			Statement statement=conexion.createStatement();
		   //Creamos el objeto resultSet
		    ResultSet resultSet=statement.executeQuery(sql);
		    while(resultSet.next()) {
		        	String codigo=resultSet.getString("CODIGO_PRODUCTO");
		        	int precio=resultSet.getInt("PRECIO");
		        	int cantidad=resultSet.getInt("CANTIDAD");
		           // LocalDate fecha=resultSet.getDate("FECHA").toLocalDate();
		        	ProductoDTO producto=new ProductoDTO(codigo, precio, cantidad);
		            listaProductos.add(producto);
		    }       
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No lee getListaProductos");
		}
		
		return listaProductos;
	}
	
	

	@Override
	public List<ProductoDTO> getListaProductosDisponibles() {
		
		   List<ProductoDTO> listaProductosDisponibles=new ArrayList<>();
			 sql=" SELECT * FROM PRODUCTOS WHERE CANTIDAD>0";
			//Creamos el objeto statement
		    try {
				Statement statement=conexion.createStatement();
			   //Creamos el objeto resultSet
			    ResultSet resultSet=statement.executeQuery(sql);
			    while(resultSet.next()) {
			        	String codigo=resultSet.getString("CODIGO_PRODUCTO");
			        	int precio=resultSet.getInt("PRECIO");
			        	int cantidad=resultSet.getInt("CANTIDAD");
			        	String fecha=resultSet.getString("FECHA");
			        	//Date fecha=resultSet.getDate("FECHA");
			           // LocalDate fecha=resultSet.getDate("FECHA").toLocalDate();
			        	ProductoDTO producto=new ProductoDTO(codigo, precio, cantidad, fecha);
			            listaProductosDisponibles.add(producto);
			    }       
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("No lee getListaProductosDisponibles");
			}
		
		
		
		// TODO Auto-generated method stub
		return listaProductosDisponibles;
	}

	@Override
	public boolean deleteProducto(String codigoProducto) {
		boolean delete= false;
		sql = "DELETE FROM productos WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, codigoProducto);
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				delete = true;
		} catch (SQLException e) {
			System.out.println("No se pudo borrar el producto");

		}
		
		return delete;
	}
    
	@Override
	public boolean updatePrecioProducto(ProductoDTO producto, int precioProducto) {
		// TODO Auto-generated method stub
		boolean update = false;
		// UPDATE productos SET PRECIO="" WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET PRECIO=?   WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			System.out.println("1");
			preparedStatement.setInt(1, precioProducto);
			System.out.println("2");
			preparedStatement.setString(2, producto.getCodigo_producto());
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = true;
		} catch (SQLException e) {
			System.out.println("No se pudo modificar el precio");

		}
		
		return update;
	}

	@Override
	public boolean addProducto(ProductoDTO producto) {
		boolean add = false;
		
		String sql = "INSERT INTO productos VALUES (?, ? , ?, ?)";
		try {
		    preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, producto.getCodigo_producto());
			preparedStatement.setInt(2, producto.getPrecio());
			preparedStatement.setInt(3, producto.getCantidad());
			preparedStatement.setString(4, producto.getFecha());
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				add = true;
		} catch (SQLException e) {
			System.out.println("No se pudo a�adir el producto");

		}
		
		return add;
	}

	@Override
	public boolean addListaProducto(List<ProductoDTO> listaProductos) {
		// TODO Auto-generated method stub
		boolean addLista = false;
		int contador=0;
		for( ProductoDTO po: listaProductos) {
			if(addProducto(po))
			 addLista=true;
			
		}
		
		return addLista;
	}
	
	public String  productoCantidadMenosUno(ProductoDTO producto) {
		String update = "null";
		// UPDATE productos SET CANTIDAD=CANTIDAD-1  WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET CANTIDAD=CANTIDAD-1   WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, producto.getCodigo_producto());
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = "Se ha modificado La cantidad correctamente";	
		} catch (SQLException e) {
		
			update = "No se pudo modificar La cantidad";
		}
		
			
	return update;	
		
	}
	
	public String  productoCantidadMasUno(ProductoDTO producto) {
		String update = "null";
		// UPDATE productos SET CANTIDAD=CANTIDAD+1  WHERE CODIGO_PRODUCTO = "";
		sql = "UPDATE productos SET CANTIDAD=CANTIDAD+1   WHERE CODIGO_PRODUCTO = ?";
		try {
			preparedStatement = conexion.prepareStatement(sql);
			preparedStatement.setString(1, producto.getCodigo_producto());
			System.out.println("3");
			int rows = preparedStatement.executeUpdate();
			if (rows != 0)
				update = "Se ha modificado La cantidad correctamente";	
		} catch (SQLException e) {
		
			update = "No se pudo modificar La cantidad";
		}
		
			
	return update;	
		
	}
	
	public static Object [][] listaData (List<ProductoDTO> lista){
		Object [][] matriz = new Object [lista.size()][5];
			
			for (int i=0 ; i < lista.size() ;i++){
			matriz[i][0] = lista.get(i).getCodigo_producto();
			matriz[i][1] = lista.get(i).getPrecio();
			matriz[i][2] = lista.get(i).getCantidad();
			matriz[i][3] = lista.get(i).getFecha();
			}
		
		return matriz;	
		}
	
	
	
	

	public static void main(String[] args) {
		ProductoDAO p =new ProductoDAO();
	//	System.out.println("Lista Productos Todos");
		System.out.println(p.getListaProductos());
	//  System.out.println("Lista Productos Disponibles");
	//  System.out.println(p.getListaProductosDisponibles());
	//	ProductoDTO p2 =new ProductoDTO("C0",186 ,100, null);
    //	System.out.println(p.addProducto(p2));
	//	System.out.println(p.deleteProducto("B26"));
	 // ProductoDTO pdt=new ProductoDTO("A1", 186, 100);
	 // System.out.println(p.updatePrecioProducto(pdt, 9800));
	  //  System.out.println(p.productoCantidadMenosUno(pdt));
	    System.out.println(p.getListaProductosDisponibles());
		// System.out.println(p.productoCantidadMasUno(pdt));
		
	/*	List<ProductoDTO> lp=new ArrayList<>();
		ProductoDTO pt1=new ProductoDTO("C23",334,100, "2018-23-02");
		ProductoDTO pt2=new ProductoDTO("C24",364,100, "2018-23-02");
		ProductoDTO pt3=new ProductoDTO("C25",384,100, "2018-23-02");
		ProductoDTO pt4=new ProductoDTO("C26",394,100, "2018-23-02");
		lp.add(pt4);
		lp.add(pt3);
		lp.add(pt2);
		lp.add(pt1);
		System.out.println(p.addListaProducto(lp));
		*/
	}
}
