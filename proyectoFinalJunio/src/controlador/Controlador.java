package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.event.AncestorListener;

import modelo.ClienteDTO;
import modeloDAO.ClienteDAO;
import modeloDAO.DevolucionDAO;
import modeloDAO.PerdidasDAO;
import modeloDAO.ProductoDAO;
import modeloDAO.VentaDAO;
import vista.PanelAdministracion;
import vista.PanelClientes;
import vista.PanelDevoluciones;
import vista.Vista;


public class Controlador implements ActionListener {
private Vista vista;
private ClienteDAO clienteDAO;
private ProductoDAO productoDAO;
private VentaDAO ventasDAO;
private DevolucionDAO devolucionesDAO;
private PerdidasDAO perdidas;



	public Controlador(Vista vista, ClienteDAO clienteDAO, ProductoDAO productoDAO, VentaDAO ventasDAO,
		DevolucionDAO devolucionesDAO, PerdidasDAO perdidas) {
	super();
	this.vista = vista;
	this.clienteDAO = clienteDAO;
	this.productoDAO = productoDAO;
	this.ventasDAO = ventasDAO;
	this.devolucionesDAO = devolucionesDAO;
	this.perdidas = perdidas;
}

	private void registrarComponentes() {
	
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {

		 JTabbedPane tabSource = (JTabbedPane) e.getSource();
		    String tab =vista.getPestanas().getTitleAt(tabSource.getSelectedIndex());
		    if (tab.equals("ADMINISTRACION")) {
		      vista.getPanelA().setBackground(Color.BLUE);
		    }
		    if (tab.equals("DEVOLUCIONES")) {
		      vista.getPanelD().setBackground(Color.RED);
		  }


	}
	
	private void actionListener(ActionListener escucha) {
		
	
	    
	}
	public static void main(String[] args) {
		Vista v=new Vista();
	}

}
