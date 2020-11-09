package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DatePicker;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelRelatorioLocacao extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioLocacao() {
		setLayout(null);
		
		JLabel lblRelatrioDeLocao = new JLabel("Relatório de Locação");
		lblRelatrioDeLocao.setFont(new Font("Arial", Font.BOLD, 15));
		lblRelatrioDeLocao.setBounds(10, 11, 175, 14);
		add(lblRelatrioDeLocao);
		
		JPanel painelRelatorioLocacao = new JPanel();
		painelRelatorioLocacao.setLayout(null);
		painelRelatorioLocacao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelRelatorioLocacao.setBounds(10, 30, 676, 149);
		add(painelRelatorioLocacao);
		
		JLabel lblRelatorioLocacaoDataRetirada = new JLabel("Data do aluguel do veículo");
		lblRelatorioLocacaoDataRetirada.setBounds(10, 61, 165, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoDataRetirada);
		
		DatePicker DataAluguelVeiculo = new DatePicker();
		DataAluguelVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelRelatorioLocacao.class.getResource("/icons/Calendario16pix.png")));
		DataAluguelVeiculo.getComponentToggleCalendarButton().setText("");
		DataAluguelVeiculo.getComponentDateTextField().setEditable(false);
		DataAluguelVeiculo.setBounds(10, 74, 217, 25);
		painelRelatorioLocacao.add(DataAluguelVeiculo);
		
		JLabel lblRelatorioLocacaoDataDevolucao = new JLabel("Data da devolução do veículo");
		lblRelatorioLocacaoDataDevolucao.setBounds(306, 61, 165, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoDataDevolucao);
		
		DatePicker DataDevolucaoVeiculo = new DatePicker();
		DataDevolucaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelRelatorioLocacao.class.getResource("/icons/Calendario16pix.png")));
		DataDevolucaoVeiculo.getComponentToggleCalendarButton().setText("");
		DataDevolucaoVeiculo.getComponentDateTextField().setEditable(false);
		DataDevolucaoVeiculo.setBounds(306, 74, 217, 25);
		painelRelatorioLocacao.add(DataDevolucaoVeiculo);
		
		JLabel lblRelatorioLocacaoNomeCliente = new JLabel("Nome do cliente");
		lblRelatorioLocacaoNomeCliente.setBounds(10, 11, 100, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoNomeCliente);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 24, 188, 25);
		painelRelatorioLocacao.add(formattedTextField);
		
		JButton btnRelatorioLocacaoPesquisa = new JButton("Pesquisar");
		btnRelatorioLocacaoPesquisa.setBounds(358, 115, 112, 23);
		painelRelatorioLocacao.add(btnRelatorioLocacaoPesquisa);
		
		JButton btnRelatorioLocacaoGerarExcel = new JButton("Gerar Excel");
		btnRelatorioLocacaoGerarExcel.setBounds(485, 115, 105, 23);
		painelRelatorioLocacao.add(btnRelatorioLocacaoGerarExcel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 600, 186);
		add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Cliente", "Marca Ve\u00EDculo", "Data da loca\u00E7\u00E3o", "KM da loca\u00E7\u00E3o", "Data da devolu\u00E7\u00E3o", "KM da devolu\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setPreferredWidth(96);
		table.getColumnModel().getColumn(4).setPreferredWidth(114);
		table.getColumnModel().getColumn(5).setPreferredWidth(105);
		scrollPane.setViewportView(table);

	}
}
