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

import br.com.senac.controller.ClienteController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.seletores.ClienteSeletor;
import br.com.senac.model.vo.ClienteVO;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelRelatorioCliente extends JPanel {
	private JTable tblRelatorioCliente;

	private List<br.com.senac.model.vo.ClienteVO> dadosConsultados;

	private JFormattedTextField txtCidadeCliente;
	private JFormattedTextField txtNomeCliente;
	private JComboBox cbEstadoCliente;

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
		painelRelatorioCliente.setBounds(10, 52, 599, 86);
		add(painelRelatorioCliente);

		JButton btnRelatorioClientePesquisa = new JButton("Pesquisar");
		btnRelatorioClientePesquisa.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
				consultarCliente();
			}

		});
		btnRelatorioClientePesquisa.setBounds(362, 44, 112, 31);
		painelRelatorioCliente.add(btnRelatorioClientePesquisa);

		JButton btnRelatorioClienteGerarExcel = new JButton("Gerar Excel");
		btnRelatorioClienteGerarExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JFileChooser janelaArquivos = new JFileChooser();

				int opcaoSelecionada = janelaArquivos.showSaveDialog(null);

				if (opcaoSelecionada == JFileChooser.APPROVE_OPTION) {
					String caminho = janelaArquivos.getSelectedFile().getAbsolutePath();
					ClienteController controller = new ClienteController();
					String salvouPlanilha = controller.gerarPlanilha(dadosConsultados, caminho);
				}
			}
		});
		btnRelatorioClienteGerarExcel.setBounds(484, 44, 105, 31);
		painelRelatorioCliente.add(btnRelatorioClienteGerarExcel);

		JLabel lblCidadeCliente = new JLabel("Cidade:");
		lblCidadeCliente.setBounds(10, 14, 61, 14);
		painelRelatorioCliente.add(lblCidadeCliente);

		txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(63, 9, 96, 25);
		painelRelatorioCliente.add(txtCidadeCliente);

		JLabel lblEstadoCliente = new JLabel("Estado:");
		lblEstadoCliente.setBounds(10, 52, 46, 14);
		painelRelatorioCliente.add(lblEstadoCliente);

		cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] { "", "RS", "RJ", "SP", "SC" }));
		cbEstadoCliente.setBounds(63, 44, 52, 25);
		painelRelatorioCliente.add(cbEstadoCliente);

		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setBounds(210, 14, 61, 14);
		painelRelatorioCliente.add(lblNomeCliente);

		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(264, 9, 112, 25);
		painelRelatorioCliente.add(txtNomeCliente);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 600, 215);
		add(scrollPane);

		tblRelatorioCliente = new JTable();
		tblRelatorioCliente.setColumnSelectionAllowed(true);
		tblRelatorioCliente.setCellSelectionEnabled(true);
		tblRelatorioCliente.setEnabled(false);
		tblRelatorioCliente.setModel(new DefaultTableModel(
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
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nome", "CPF", "CNH", "Telefone", "Cidade", "Estado"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblRelatorioCliente.getColumnModel().getColumn(0).setResizable(false);
		tblRelatorioCliente.getColumnModel().getColumn(0).setPreferredWidth(89);
		tblRelatorioCliente.getColumnModel().getColumn(1).setPreferredWidth(88);
		tblRelatorioCliente.getColumnModel().getColumn(2).setPreferredWidth(79);
		tblRelatorioCliente.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblRelatorioCliente.getColumnModel().getColumn(4).setPreferredWidth(96);
		tblRelatorioCliente.getColumnModel().getColumn(5).setPreferredWidth(91);
		scrollPane.setViewportView(tblRelatorioCliente);

	}

	private void consultarCliente() {
		ClienteController controlador = new ClienteController();
		ClienteSeletor seletor = new ClienteSeletor();
		seletor.setCidadeFiltro(txtCidadeCliente.getText());
		seletor.setEstadoFiltro((cbEstadoCliente.getSelectedItem().toString()));
		seletor.setNomeFiltro(txtNomeCliente.getText());
		
		List<ClienteVO> clientes = controlador.listarClientesFiltro(seletor);
		atualizarTabelaClientes(clientes);

	}

	private void atualizarTabelaClientes(List<ClienteVO> clientes) {
		dadosConsultados = clientes;
		this.limparTabela();
		DefaultTableModel modelo = (DefaultTableModel) tblRelatorioCliente.getModel();
		for (ClienteVO cliente : clientes) {

			String[] novaLinha = new String[] { cliente.getNome() + "", cliente.getCpf(), cliente.getCnh(),
					cliente.getTelefone() + "", cliente.getCidade(), cliente.getEstado() };
			modelo.addRow(novaLinha);
		}

	}

	private void limparTabela() {
		tblRelatorioCliente.setModel(
				new DefaultTableModel(new String[][] { { "Nome", "CPF", "CNH", "Telefone", "Cidade", "Estado" }, },
						new String[] { "Nome", "CPF", "CNH", "Telefone", "Cidade", "Estado" }));
	}

}