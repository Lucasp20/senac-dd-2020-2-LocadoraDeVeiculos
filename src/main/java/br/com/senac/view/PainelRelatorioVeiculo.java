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

public class PainelRelatorioVeiculo extends JPanel {
	private JTable tblRelatorioVeiculo;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioVeiculo() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 551, 223);
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
				"Placa", "Marca", "Modelo", "Status"
			}
		));
		scrollPane.setViewportView(tblRelatorioVeiculo);
		
		JPanel painelRelatorioVeiculo = new JPanel();
		painelRelatorioVeiculo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelRelatorioVeiculo.setBounds(10, 61, 551, 71);
		add(painelRelatorioVeiculo);
		painelRelatorioVeiculo.setLayout(null);
		
		JLabel lblRelatorioMarca = new JLabel("Marca: ");
		lblRelatorioMarca.setBounds(10, 30, 46, 14);
		painelRelatorioVeiculo.add(lblRelatorioMarca);
		
		JFormattedTextField txtRelatorioMarca = new JFormattedTextField();
		txtRelatorioMarca.setBounds(54, 27, 199, 20);
		painelRelatorioVeiculo.add(txtRelatorioMarca);
		
		JButton btnRelatorioPesquisa = new JButton("Pesquisar");
		btnRelatorioPesquisa.setBounds(417, 26, 112, 23);
		painelRelatorioVeiculo.add(btnRelatorioPesquisa);
		
		JLabel lblRelatorioVeiculo = new JLabel("Relatório de Veículos");
		lblRelatorioVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblRelatorioVeiculo.setBounds(10, 25, 175, 14);
		add(lblRelatorioVeiculo);

	}
}
