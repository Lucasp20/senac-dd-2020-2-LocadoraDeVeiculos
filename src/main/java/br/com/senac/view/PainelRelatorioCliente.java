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

import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class PainelRelatorioCliente extends JPanel {
	private JTable tblRelatorioCliente;

	private List<br.com.senac.model.vo.ClienteVO> DadosConsultados;

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
				String salvouPlanilha = controller.gerarPlanilha(DadosConsultados, caminho);
			}}
			});
		btnRelatorioClienteGerarExcel.setBounds(484, 44, 105, 31);
		painelRelatorioCliente.add(btnRelatorioClienteGerarExcel);
		
		JLabel lblCidadeCliente = new JLabel("Cidade:");
		lblCidadeCliente.setBounds(10, 14, 61, 14);
		painelRelatorioCliente.add(lblCidadeCliente);
		
		JFormattedTextField txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(63, 9, 96, 25);
		painelRelatorioCliente.add(txtCidadeCliente);
		
		JLabel lblEstadoCliente = new JLabel("Estado:");
		lblEstadoCliente.setBounds(10, 52, 46, 14);
		painelRelatorioCliente.add(lblEstadoCliente);
		
		JComboBox cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cbEstadoCliente.setBounds(63, 44, 52, 25);
		painelRelatorioCliente.add(cbEstadoCliente);
		
		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setBounds(210, 14, 61, 14);
		painelRelatorioCliente.add(lblNomeCliente);
		
		JFormattedTextField txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(264, 9, 112, 25);
		painelRelatorioCliente.add(txtNomeCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 144, 600, 215);
		add(scrollPane);
		
		tblRelatorioCliente = new JTable();
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
		tblRelatorioCliente.getColumnModel().getColumn(0).setPreferredWidth(89);
		tblRelatorioCliente.getColumnModel().getColumn(1).setPreferredWidth(88);
		tblRelatorioCliente.getColumnModel().getColumn(2).setPreferredWidth(79);
		tblRelatorioCliente.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblRelatorioCliente.getColumnModel().getColumn(4).setPreferredWidth(96);
		tblRelatorioCliente.getColumnModel().getColumn(5).setPreferredWidth(91);
		scrollPane.setViewportView(tblRelatorioCliente);

	}
}
