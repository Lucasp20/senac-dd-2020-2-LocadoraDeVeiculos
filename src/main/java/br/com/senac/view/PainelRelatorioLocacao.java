package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import com.github.lgooddatepicker.components.DatePicker;

import br.com.senac.controller.LocacaoController;
import br.com.senac.controller.VeiculoController;
import br.com.senac.model.dao.LocacaoDAO;
import br.com.senac.model.seletores.LocacaoSeletor;
import br.com.senac.model.seletores.VeiculoSeletor;
import br.com.senac.model.vo.LocacaoVO;
import br.com.senac.model.vo.VeiculoVO;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelRelatorioLocacao extends JPanel {
	private JTable table;

	private JFormattedTextField txtNomeCliente;
	private DatePicker DataAluguelVeiculo;
	private DatePicker DataDevolucaoVeiculo;
	private JLabel lblRelatrioDeLocao;
	private List<br.com.senac.model.vo.LocacaoVO> dadosConsultados;
	/**
	 * Create the panel.
	 */
	public PainelRelatorioLocacao() {
		setLayout(null);
		
		lblRelatrioDeLocao = new JLabel("Relatório de Locação");
		lblRelatrioDeLocao.setFont(new Font("Arial", Font.BOLD, 15));
		lblRelatrioDeLocao.setBounds(10, 11, 175, 14);
		add(lblRelatrioDeLocao);
		
		JPanel painelRelatorioLocacao = new JPanel();
		painelRelatorioLocacao.setLayout(null);
		painelRelatorioLocacao.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		painelRelatorioLocacao.setBounds(10, 30, 600, 149);
		add(painelRelatorioLocacao);
		
		JLabel lblRelatorioLocacaoDataRetirada = new JLabel("Data do aluguel do veículo");
		lblRelatorioLocacaoDataRetirada.setBounds(10, 61, 165, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoDataRetirada);
		
		DataAluguelVeiculo = new DatePicker();
		DataAluguelVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelRelatorioLocacao.class.getResource("/icons/Calendario16pix.png")));
		DataAluguelVeiculo.getComponentToggleCalendarButton().setText("");
		DataAluguelVeiculo.getComponentDateTextField().setEditable(false);
		DataAluguelVeiculo.setBounds(10, 74, 217, 25);
		painelRelatorioLocacao.add(DataAluguelVeiculo);
		
		JLabel lblRelatorioLocacaoDataDevolucao = new JLabel("Data da devolução do veículo");
		lblRelatorioLocacaoDataDevolucao.setBounds(306, 61, 165, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoDataDevolucao);
		
		DataDevolucaoVeiculo = new DatePicker();
		DataDevolucaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelRelatorioLocacao.class.getResource("/icons/Calendario16pix.png")));
		DataDevolucaoVeiculo.getComponentToggleCalendarButton().setText("");
		DataDevolucaoVeiculo.getComponentDateTextField().setEditable(false);
		DataDevolucaoVeiculo.setBounds(306, 74, 217, 25);
		painelRelatorioLocacao.add(DataDevolucaoVeiculo);
		
		JLabel lblRelatorioLocacaoNomeCliente = new JLabel("Nome do cliente");
		lblRelatorioLocacaoNomeCliente.setBounds(10, 11, 100, 14);
		painelRelatorioLocacao.add(lblRelatorioLocacaoNomeCliente);
		
		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(10, 24, 188, 25);
		painelRelatorioLocacao.add(txtNomeCliente);
		
		JButton btnRelatorioLocacaoPesquisa = new JButton("Pesquisar");
		btnRelatorioLocacaoPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				consultarLocacao();
			}

		});
		btnRelatorioLocacaoPesquisa.setBounds(358, 110, 112, 28);
		painelRelatorioLocacao.add(btnRelatorioLocacaoPesquisa);
		
		JButton btnRelatorioLocacaoGerarExcel = new JButton("Gerar Excel");
		btnRelatorioLocacaoGerarExcel.setBounds(485, 110, 105, 28);
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
	
	private void consultarLocacao() {
		LocacaoController controller = new LocacaoController();
		LocacaoSeletor seletor = new LocacaoSeletor();
			seletor.setNomeClienteFiltro(txtNomeCliente.getText());
			
			List<LocacaoVO> locacoes = controller.listarLocacaoFiltro(seletor);
			atualizarTabelaLocacao(locacoes);		
	}

	private void atualizarTabelaLocacao(List<LocacaoVO> locacoes) {
		dadosConsultados = locacoes;
		this.limparTabela();
		DefaultTableModel modelo = (DefaultTableModel) lblRelatrioDeLocao.getModel();
		for (LocacaoVO locacao : locacoes) {

			String[] novaLinha = new String[] { locacao.getCliente() + "", locacao.getVeiculo().toString(), locacao.getDataLocacao().toString(),
					locacao.getKmLocacao() + "", locacao.getDataEntrega() + "", locacao.getKmEntrega() + "" };
			modelo.addRow(novaLinha);
		}
		
	}

	private void limparTabela() {
		lblRelatrioDeLocao.setModel(
				new DefaultTableModel(new String[][] { { "Cliente", "Veiculo", "Data_Locacao", "KMLocacao", "Data_Entrega", "KMLocacao" }, },
						new String[] { "Cliente", "Veiculo", "Data_Locacao", "KMLocacao", "Data_Entrega", "KMLocacao"}));
	}
}
