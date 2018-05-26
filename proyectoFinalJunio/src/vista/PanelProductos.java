package vista;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import controlador.ModeloTablaClientes;
import controlador.ModeloTablaProductos;
import modelo.ClienteDTO;
import modelo.ProductoDTO;
import modeloDAO.ClienteDAO;
import modeloDAO.ProductoDAO;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import modeloDAO.ClienteDAO;
import modelo.ClienteDTO;
public class PanelProductos extends JPanel {
private JTable tablap;
private JTextField textCantidad;
private JTextField textFecha;
private boolean cargado=false;
private List<ProductoDTO> listaProductos;
private JTextField textCodigo;
private JTextField textPrecio;
private JButton btnBorrar ;
private JButton btnInsertar ;
private JButton btnModificar ;
private JButton btnBuscar ;
private JButton btnInsertarCliente ;
private JButton btnCargar ;
	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		cargado=false;
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnBorrar = new JButton("BORRAR");
		
		
		JButton btnInsertar = new JButton("INSERTAR LISTA");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnModificar = new JButton("MODIFICAR");
		
		JButton btnBuscar = new JButton("BUSCAR");
		
		JLabel lblCodigo_producto = new JLabel("Codigo");
		lblCodigo_producto.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo_producto.setForeground(Color.WHITE);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setForeground(Color.WHITE);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(5);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(5);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(5);
		
		textFecha = new JTextField();
		textFecha.setColumns(5);
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setForeground(Color.WHITE);
		lblProducto.setFont(new Font("Verdana", Font.BOLD, 16));
		
		JButton btnInsertarCliente = new JButton("INSERTAR PRODUCTO");
		
		
		JButton btnCargar = new JButton("CARGAR");
		
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblProductos.setForeground(new Color(255, 255, 255));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblCantidad, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPrecio)
										.addComponent(lblCodigo_producto)
										.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textPrecio, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addComponent(textCantidad, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addComponent(textFecha, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textCodigo, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(87))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBuscar)
									.addGap(14)
									.addComponent(btnInsertarCliente)
									.addGap(47))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblProducto)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(100)
							.addComponent(btnCargar)
							.addGap(40)
							.addComponent(btnModificar)
							.addGap(31)
							.addComponent(btnInsertar)
							.addGap(18)
							.addComponent(btnBorrar))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 657, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(538, Short.MAX_VALUE)
					.addComponent(lblProductos)
					.addGap(303))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(221)
							.addComponent(lblProducto)
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCodigo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCodigo_producto))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textPrecio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPrecio))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textCantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantidad))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblProductos)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBuscar)
							.addComponent(btnInsertarCliente))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnBorrar)
							.addComponent(btnInsertar)
							.addComponent(btnModificar))
						.addComponent(btnCargar))
					.addGap(94))
		);
		
		
		
		
		
	
		DefaultTableModel modelop= new DefaultTableModel();
		JTable tablep=new JTable();
		
		tablep.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CODIGO_PRODUCTO", "PRECIO", "CANTIDAD"
			}
		));
		
		scrollPane.setViewportView(tablep);
		setLayout(groupLayout);
		
	
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		
		tablap = new JTable(new ModeloTablaProductos());
		scrollPane.setViewportView(tablap);
		tablap.setAutoCreateRowSorter(true);//ro
		tablap.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //ro-----
		
	}
		
/*
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int numCols=tablep.getModel().getColumnCount();
			if(cargado==false) {	
				 listaProductos=new ProductoDAO().getListaProductos();
			     ProductoDTO p;
			     for (int i = 0; i < listaProductos.size(); i++) {
			    	 Object[]  fila= new Object[3];
			    	 p=listaProductos.get(i);
			         fila[0]=p.getCodigo_producto();
			         fila[1]=p.getPrecio();
			         fila[2]=p.getCantidad();
			        cargado=true;   
			     
			
			        ((DefaultTableModel) tablep.getModel()).addRow(fila)	;
		         } 
			}
		  }
		 });
			
			
			

	}
	
	*/
		
	/**
	 * @return the tabla
	 */
	public JTable getTabla() {
		return tablap;
	}
	/**
	 * @return the textCantidad
	 */
	public JTextField getTextCantidad() {
		return textCantidad;
	}
	/**
	 * @return the textFecha
	 */
	public JTextField getTextFecha() {
		return textFecha;
	}
	/**
	 * @return the cargado
	 */
	public boolean isCargado() {
		return cargado;
	}
	/**
	 * @return the listaProductos
	 */
	public List<ProductoDTO> getListaProductos() {
		return listaProductos;
	}
	/**
	 * @return the textCodigo
	 */
	public JTextField getTextCodigo() {
		return textCodigo;
	}
	/**
	 * @return the textPrecio
	 */
	public JTextField getTextPrecio() {
		return textPrecio;
	}
	/**
	 * @return the btnBorrar
	 */
	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	/**
	 * @return the btnInsertar
	 */
	public JButton getBtnInsertar() {
		return btnInsertar;
	}
	/**
	 * @return the btnModificar
	 */
	public JButton getBtnModificar() {
		return btnModificar;
	}
	/**
	 * @return the btnBuscar
	 */
	public JButton getBtnBuscar() {
		return btnBuscar;
	}
	/**
	 * @return the btnInsertarCliente
	 */
	public JButton getBtnInsertarCliente() {
		return btnInsertarCliente;
	}
	/**
	 * @return the btnCargar
	 */
	public JButton getBtnCargar() {
		return btnCargar;
	}
}	
				











































/* 
				     listaProductos=new ProductoDAO().getListaProductos();
				     ProductoDTO p;
				     for (int i = 0; i < listaProductos.size(); i++) {
				    	 Object[]  fila= new Object[5];
				    	 p=listaProductos.get(i);
				         fila[0]=p.getCodigo_producto();
				         fila[1]=p.getPrecio();
				         fila[2]=p.getCantidad();
				         fila[3]=p.getFecha();
				       
				        cargado=true;
				
				        ((DefaultTableModel) table.getModel()).addRow(fila)	;
			         } 
				}
			  }
			 });
				
				*/
				
