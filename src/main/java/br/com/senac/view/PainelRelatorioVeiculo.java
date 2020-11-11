package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;

public class PainelRelatorioVeiculo extends JPanel {
	private JTable tblRelatorioVeiculo;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioVeiculo() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 599, 223);
		add(scrollPane);
		
		tblRelatorioVeiculo = new JTable();
		tblRelatorioVeiculo.setEnabled(false);
		tblRelatorioVeiculo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Placa", "Marca", "Modelo", "Situa\u00E7\u00E3o"
			}
		));
		tblRelatorioVeiculo.getColumnModel().getColumn(0).setPreferredWidth(97);
		tblRelatorioVeiculo.getColumnModel().getColumn(1).setPreferredWidth(99);
		tblRelatorioVeiculo.getColumnModel().getColumn(2).setPreferredWidth(102);
		tblRelatorioVeiculo.getColumnModel().getColumn(3).setPreferredWidth(119);
		scrollPane.setViewportView(tblRelatorioVeiculo);
		
		JPanel painelRelatorioVeiculo = new JPanel();
		painelRelatorioVeiculo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelRelatorioVeiculo.setBounds(10, 43, 599, 104);
		add(painelRelatorioVeiculo);
		painelRelatorioVeiculo.setLayout(null);
		
		JLabel lblRelatorioMarca = new JLabel("Marca:");
		lblRelatorioMarca.setVerticalAlignment(SwingConstants.TOP);
		lblRelatorioMarca.setBounds(10, 17, 46, 14);
		painelRelatorioVeiculo.add(lblRelatorioMarca);
		
		JFormattedTextField txtRelatorioMarca = new JFormattedTextField();
		txtRelatorioMarca.setBounds(54, 11, 98, 27);
		painelRelatorioVeiculo.add(txtRelatorioMarca);
		
		JButton btnRelatorioPesquisa = new JButton("Pesquisar");
		btnRelatorioPesquisa.setBounds(344, 62, 112, 31);
		painelRelatorioVeiculo.add(btnRelatorioPesquisa);
		
		JButton btnRelatorioVeiculoGerarExcel = new JButton("Gerar Excel");
		btnRelatorioVeiculoGerarExcel.setBounds(466, 62, 105, 31);
		painelRelatorioVeiculo.add(btnRelatorioVeiculoGerarExcel);
		
		JLabel lblRelatorioVeiculoAno = new JLabel("Ano:");
		lblRelatorioVeiculoAno.setBounds(10, 50, 46, 14);
		painelRelatorioVeiculo.add(lblRelatorioVeiculoAno);
		
		JFormattedTextField txtAno = new JFormattedTextField();
		txtAno.setBounds(54, 42, 76, 27);
		painelRelatorioVeiculo.add(txtAno);
		
		JLabel lblRelatorioVeiculoCor = new JLabel("Cor:");
		lblRelatorioVeiculoCor.setBounds(10, 79, 46, 14);
		painelRelatorioVeiculo.add(lblRelatorioVeiculoCor);
		
		JFormattedTextField txtCor = new JFormattedTextField();
		txtCor.setBounds(54, 73, 64, 27);
		painelRelatorioVeiculo.add(txtCor);
		
		JLabel lblRelatorioVeiculo = new JLabel("Relatório de Veículos");
		lblRelatorioVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblRelatorioVeiculo.setBounds(10, 25, 175, 14);
		add(lblRelatorioVeiculo);

	}
}
