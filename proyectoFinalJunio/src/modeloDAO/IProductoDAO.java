package modeloDAO;

import java.util.List;

import modelo.ClienteDTO;
import modelo.ProductoDTO;

public interface IProductoDAO {
	List<ProductoDTO> getListaProductos();
	List<ProductoDTO> getListaProductosDisponibles();
	boolean deleteProducto(String codigoProducto);
	boolean addProducto(ProductoDTO producto);
	boolean addListaProducto(List<ProductoDTO> listaProductos);
	boolean updatePrecioProducto(ProductoDTO dto, int precioProducto);
}
