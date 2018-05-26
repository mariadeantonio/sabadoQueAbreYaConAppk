package modeloDAO;

import java.util.List;

import modelo.ClienteDTO;
import modelo.ProductoDTO;
import modelo.VentaDTO;

public interface IVentaDAO {
	List<VentaDTO> getListaVentas();
	boolean addVenta(ClienteDTO  cliente, ProductoDTO producto);
	boolean deleteVenta(String dni,String  codigoProducto);
}
