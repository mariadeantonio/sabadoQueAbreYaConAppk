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
import modelo.ClienteDTO;
import modeloDAO.ClienteDAO;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
public class PanelClientes extends JPanel {
	private JTable tabla;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private boolean cargado=false;
	private List<ClienteDTO> listaClientes;
	private JButton btnBorrar;
	private JButton btnInsertar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private JButton btnCargar;
	private JButton btnInsertarCliente;
  
	/**
	 * Create the panel.
	 */
	public PanelClientes() {
		cargado=false;
		JScrollPane scrollPane = new JScrollPane();
		
		 btnBorrar = new JButton("BORRAR");
		 btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
		 
		
	    btnInsertar = new JButton("INSERTAR LISTA");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	    btnModificar = new JButton("MODIFICAR");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setForeground(Color.WHITE);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setColumns(5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(5);
		
		textField_2 = new JTextField();
		textField_2.setColumns(5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(5);
		
		JLabel lblClienteSeleccionado = new JLabel("Cliente Seleccionado");
		lblClienteSeleccionado.setForeground(Color.WHITE);
		lblClienteSeleccionado.setFont(new Font("Verdana", Font.BOLD, 16));
		
		btnInsertarCliente = new JButton("INSERTAR CLIENTE");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
	    btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
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
										.addComponent(lblApellidos, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel)
										.addComponent(lblDni)
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(textField, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGap(87))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnBuscar)
									.addGap(14)
									.addComponent(btnInsertarCliente)
									.addGap(47))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblClienteSeleccionado)))
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
					.addComponent(lblNewLabel_1)
					.addGap(303))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(221)
							.addComponent(lblClienteSeleccionado)
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDni))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblApellidos))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmail))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFecha)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(lblNewLabel_1)
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
		
		DefaultTableModel modelo= new DefaultTableModel();
		JTable table=new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "NOMBRE", "APELLIDOS", "EMAIL", "FECHA"
			}
		));
		scrollPane.setViewportView(table);
		setLayout(groupLayout);
		
		
		
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		
		table = new JTable(new ModeloTablaClientes());
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);//ro
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//ro-----
		
		
		
		/*
		
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int numCols=table.getModel().getColumnCount();
			if(cargado==false) {	
			    
			     listaClientes=new ClienteDAO().getListaClientes();
			     ClienteDTO d;
			     for (int i = 0; i < listaClientes.size(); i++) {
			    	 Object[]  fila= new Object[5];
			    	 d=listaClientes.get(i);
			         fila[0]=d.getDni();
			         fila[1]=d.getNombre();
			         fila[2]=d.getApellidos();
			         fila[3]=d.getEmail();
			         fila[4]=d.getFecha();
			        cargado=true;
			
			        ((DefaultTableModel) table.getModel()).addRow(fila)	;
		         } 
			}
		  }
		 });
			
			
		*/	

	}
	
	

	/**
	 * @return the tabla
	 */
	public JTable getTabla() {
		return tabla;
	}

	/**
	 * @return the textField
	 */
	public JTextField getTextField() {
		return textField;
	}

	/**
	 * @return the textField_1
	 */
	public JTextField getTextField_1() {
		return textField_1;
	}

	/**
	 * @return the textField_2
	 */
	public JTextField getTextField_2() {
		return textField_2;
	}

	/**
	 * @return the textField_4
	 */
	public JTextField getTextField_4() {
		return textField_4;
	}

	/**
	 * @return the textField_5
	 */
	public JTextField getTextField_5() {
		return textField_5;
	}

	/**
	 * @return the cargado
	 */
	public boolean isCargado() {
		return cargado;
	}

	/**
	 * @return the listaClientes
	 */
	public List<ClienteDTO> getListaClientes() {
		return listaClientes;
	}
	
	
}
