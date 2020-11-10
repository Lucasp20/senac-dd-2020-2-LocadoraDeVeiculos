package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class PainelRelatorioCliente extends JPanel {
	private JTable tblRelatorioCliente;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioCliente() {
		setLayout(null);
		
		JLabel lblRelatorioClientes = new JLabel("Relatório de Clientes");
		lblRelatorioClientes.setFont(new Font("Arial", Font.BOLD, 15));
		lblRelatorioClientes.setBounds(27, 27, 175, 14);
		add(lblRelatorioClientes);
		
		JPanel painelRelatorioCliente = new JPanel();
		painelRelatorioCliente.setLayout(null);
		painelRelatorioCliente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelRelatorioCliente.setBounds(10, 60, 599, 78);
		add(painelRelatorioCliente);
		
		JButton btnRelatorioClientePesquisa = new JButton("Pesquisar");
		btnRelatorioClientePesquisa.setBounds(362, 31, 112, 23);
		painelRelatorioCliente.add(btnRelatorioClientePesquisa);
		
		JButton btnRelatorioClienteGerarExcel = new JButton("Gerar Excel");
		btnRelatorioClienteGerarExcel.setBounds(484, 31, 105, 23);
		painelRelatorioCliente.add(btnRelatorioClienteGerarExcel);
		
		JLabel lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(20, 14, 61, 14);
		painelRelatorioCliente.add(lblCidadeCliente);
		
		JFormattedTextField txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(20, 29, 72, 25);
		painelRelatorioCliente.add(txtCidadeCliente);
		
		JLabel lblEstadoCliente = new JLabel("Estado");
		lblEstadoCliente.setBounds(125, 14, 46, 14);
		painelRelatorioCliente.add(lblEstadoCliente);
		
		JComboBox cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setBounds(125, 29, 46, 25);
		painelRelatorioCliente.add(cbEstadoCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 600, 215);
		add(scrollPane);
		
		tblRelatorioCliente = new JTable();
		tblRelatorioCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Nome", "CPF", "CNH", "Telefone", "Endere\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblRelatorioCliente.getColumnModel().getColumn(0).setPreferredWidth(116);
		tblRelatorioCliente.getColumnModel().getColumn(1).setPreferredWidth(116);
		tblRelatorioCliente.getColumnModel().getColumn(2).setPreferredWidth(118);
		tblRelatorioCliente.getColumnModel().getColumn(3).setPreferredWidth(122);
		tblRelatorioCliente.getColumnModel().getColumn(4).setPreferredWidth(113);
		scrollPane.setViewportView(tblRelatorioCliente);

	}
}
