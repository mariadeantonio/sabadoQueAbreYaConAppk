package vista;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controlador.ModeloTablaClientes;
import modelo.DevolucionDTO;
import modeloDAO.DevolucionDAO;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PanelDevoluciones extends JPanel {
	private JTable table;
	private List<DevolucionDTO> listaDevoluciones;
	

	/**
	 * Create the panel.
	 */
	public PanelDevoluciones() {
	
		JPanel panel = new JPanel();
		
		JButton btnCargar = new JButton("CARGAR");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnAPerdidas = new JButton("A PERDIDAS");
		
		JButton btnAVentas = new JButton("A VENTAS");
		
		JLabel lblNewLabel = new JLabel("Devoluciones");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(108, Short.MAX_VALUE)
					.addComponent(btnCargar)
					.addGap(42)
					.addComponent(btnAPerdidas)
					.addGap(49)
					.addComponent(btnAVentas)
					.addGap(231))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
					.addGap(28))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(299)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
					.addGap(231))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel)
					.addGap(39)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 268, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAVentas)
						.addComponent(btnCargar)
						.addComponent(btnAPerdidas))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI CLIENTE", "CODIGO PRODUCTO", "IMPORTE", "ESTADO", "FECHA DEVOLUCIOM"
			}
		));
		scrollPane.setViewportView(table);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		
		
		
		
		

		table = new JTable(new ModeloTablaClientes());
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);//ro
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//ro-----
		

	
/*

       btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int numCols=table.getModel().getColumnCount();
			if(cargado==false) {	
				 listaDevoluciones=new DevolucionDAO().getListaDevolucionPendienteRevision();
			     DevolucionDTO d;
			     for (int i = 0; i < listaDevoluciones.size(); i++) {
			    	 Object[]  fila= new Object[5];
			    	 d=listaDevoluciones.get(i);
			         fila[0]=d.getDniDC();
			         fila[1]=d.getCodigoProductoDC();
			         fila[2]=d.getImporteDC();
			         fila[3]=d.getEstado();
			         fila[4]=d.getFechaDevolucion();
			         cargado=true;   
			     
			
			        ((DefaultTableModel) table.getModel()).addRow(fila);
		         } 
			}
		  }
		 });
	*/		
}

}
