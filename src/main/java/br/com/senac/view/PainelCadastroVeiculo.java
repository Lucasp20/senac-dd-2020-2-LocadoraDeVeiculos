package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senac.constante.Mensagens;
import br.com.senac.controller.ClienteController;
import br.com.senac.controller.VeiculoController;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.VeiculoVO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelCadastroVeiculo extends JPanel {

	private JLabel lblPlaca;
	private JFormattedTextField txtPlaca;
	private JLabel lblRenavam;
	private JFormattedTextField txtRenavam;
	private JLabel lblChassi;
	private JFormattedTextField txtChassi;
	private JLabel lblDadosVeiculo;
	private JLabel lblMarca;
	private JFormattedTextField txtModelo;
	private JLabel lblModelo;
	private JLabel lblAno;
	private JLabel lblCor;
	private JButton btnConsultarPlacaVeiculo;
	private JComboBox cbDadosVeiculoMotor;
	private JComboBox cbDadosVeiculoTransmissao;
	private JComboBox cbMarcaVeiculo;
	private JComboBox cbAnoVeiculo;
	private JComboBox cbCorVeiculo;
	private JButton btnEditarVeiculo;
	private JButton btnVeiculoExcluir;

	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	private VeiculoVO veiculoVO = new VeiculoVO();
	
	public PainelCadastroVeiculo() throws ParseException {
		setBounds(100, 100, 595, 410);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);

		MaskFormatter mascaraPlaca = new MaskFormatter("UUU-#*##");

		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(75, 86, 46, 14);
		this.add(lblPlaca);

		txtPlaca = new JFormattedTextField(mascaraPlaca);
		txtPlaca.setBounds(75, 101, 111, 27);
		this.add(txtPlaca);

		lblRenavam = new JLabel("Renavam");
		lblRenavam.setBounds(242, 86, 59, 14);
		this.add(lblRenavam);

		MaskFormatter mascaraRenavam = new MaskFormatter("###########");

		txtRenavam = new JFormattedTextField(mascaraRenavam);
		txtRenavam.setEnabled(false);
		txtRenavam.setBounds(242, 101, 146, 27);
		this.add(txtRenavam);

		MaskFormatter mascaraChassi = new MaskFormatter("#UU###UU#*U######");

		lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(406, 86, 59, 14);
		this.add(lblChassi);

		txtChassi = new JFormattedTextField(mascaraChassi);
		txtChassi.setEnabled(false);
		txtChassi.setBounds(407, 101, 146, 27);
		this.add(txtChassi);

		lblDadosVeiculo = new JLabel("Dados do Ve\u00EDculo");
		lblDadosVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosVeiculo.setBounds(21, 31, 146, 14);
		this.add(lblDadosVeiculo);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(75, 145, 46, 14);
		this.add(lblMarca);

		txtModelo = new JFormattedTextField();
		txtModelo.setEnabled(false);
		txtModelo.setBounds(242, 160, 146, 27);
		this.add(txtModelo);

		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(242, 145, 46, 14);
		this.add(lblModelo);

		lblAno = new JLabel("Ano");
		lblAno.setBounds(407, 145, 46, 14);
		this.add(lblAno);

		lblCor = new JLabel("Cor");
		lblCor.setBounds(489, 145, 46, 14);
		this.add(lblCor);

		JSeparator separator = new JSeparator();
		separator.setBounds(71, 263, 482, 2);
		this.add(separator);

		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(75, 199, 76, 14);
		this.add(lblMotor);

		JLabel lblTransmissao = new JLabel("Transmiss\u00E3o");
		lblTransmissao.setBounds(242, 199, 88, 14);
		this.add(lblTransmissao);

		cbDadosVeiculoTransmissao = new JComboBox();
		cbDadosVeiculoTransmissao.setEnabled(false);
		cbDadosVeiculoTransmissao.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbDadosVeiculoTransmissao.setToolTipText("");
		cbDadosVeiculoTransmissao.setModel(new DefaultComboBoxModel(new String[] { "", "Automática", "Manual" }));
		cbDadosVeiculoTransmissao.setBounds(242, 214, 146, 27);
		this.add(cbDadosVeiculoTransmissao);

		cbDadosVeiculoMotor = new JComboBox();
		cbDadosVeiculoMotor.setEnabled(false);
		cbDadosVeiculoMotor.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbDadosVeiculoMotor.setModel(new DefaultComboBoxModel(new String[] { "", "1.0", "1.4", "1.6", "2.0" }));
		cbDadosVeiculoMotor.setBounds(75, 214, 146, 27);
		this.add(cbDadosVeiculoMotor);

		cbMarcaVeiculo = new JComboBox();
		cbMarcaVeiculo.setEnabled(false);
		cbMarcaVeiculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbMarcaVeiculo.setModel(new DefaultComboBoxModel(new String[] { "", Mensagens.MARCA_AUDI, Mensagens.MARCA_BMW,
				Mensagens.MARCA_CHEVROLET, Mensagens.MARCA_CITROEN, Mensagens.MARCA_FIAT, Mensagens.MARCA_FORD,
				Mensagens.MARCA_HONDA, Mensagens.MARCA_HYNDAI, Mensagens.MARCA_KIA, Mensagens.MARCA_NISSAN,
				Mensagens.MARCA_PEUGEOT, Mensagens.MARCA_RENAULT, Mensagens.MARCA_TOYOTA }));
		cbMarcaVeiculo.setBounds(73, 160, 151, 27);
		this.add(cbMarcaVeiculo);

		cbAnoVeiculo = new JComboBox();
		cbAnoVeiculo.setEnabled(false);
		cbAnoVeiculo.setModel(new DefaultComboBoxModel(new String[] { Mensagens.ANO_2010, Mensagens.ANO_2011,
				Mensagens.ANO_2012, Mensagens.ANO_2013, Mensagens.ANO_2014, Mensagens.ANO_2015, Mensagens.ANO_2016,
				Mensagens.ANO_2017, Mensagens.ANO_2018, Mensagens.ANO_2019, Mensagens.ANO_2020 }));
		cbAnoVeiculo.setBounds(406, 160, 73, 27);
		this.add(cbAnoVeiculo);

		cbCorVeiculo = new JComboBox();
		cbCorVeiculo.setEnabled(false);
		cbCorVeiculo.setModel(new DefaultComboBoxModel(new String[] { "", Mensagens.COR_AZUL, Mensagens.COR_BRANCO,
				Mensagens.COR_PRATA, Mensagens.COR_PRETO, Mensagens.COR_VERMELHO }));
		cbCorVeiculo.setBounds(487, 160, 66, 27);
		add(cbCorVeiculo);

		JButton btnSalvarVeiculo = new JButton(" Salvar");
		btnSalvarVeiculo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				VeiculoVO novoVeiculo = new VeiculoVO();

				novoVeiculo.setPlaca(txtPlaca.getText());
				novoVeiculo.setRenavam(txtRenavam.getText());
				novoVeiculo.setChassi(txtChassi.getText());
				novoVeiculo.setMarca((String) (cbMarcaVeiculo.getSelectedItem()));
				novoVeiculo.setModelo(txtModelo.getText());
				novoVeiculo.setAno(Integer.parseInt(cbAnoVeiculo.getSelectedItem().toString()));
				novoVeiculo.setCor((String) (cbCorVeiculo.getSelectedItem()));
				novoVeiculo.setMotor((String) (cbDadosVeiculoMotor.getSelectedItem()));
				novoVeiculo.setTransmissao((String) cbDadosVeiculoTransmissao.getSelectedItem());

				VeiculoController veiculoController = new VeiculoController();
				JOptionPane.showMessageDialog(null, veiculoController.cadastrarVeiculo(novoVeiculo));

			}

		});
		btnSalvarVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarVeiculo.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvarVeiculo.setForeground(new Color(0, 0, 139));
		btnSalvarVeiculo.setBackground(new Color(240, 248, 255));
		btnSalvarVeiculo.setBounds(432, 323, 109, 41);
		this.add(btnSalvarVeiculo);

		btnEditarVeiculo = new JButton("Editar");
		btnEditarVeiculo.setEnabled(false);
		btnEditarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtPlaca.setEnabled(true);
				txtRenavam.setEnabled(true);
				txtChassi.setEnabled(true);
				cbMarcaVeiculo.setEnabled(true);
				txtModelo.setEnabled(true);
				cbAnoVeiculo.setEnabled(true);
				cbCorVeiculo.setEnabled(true);
				cbDadosVeiculoMotor.setEnabled(true);
				cbDadosVeiculoTransmissao.setEnabled(true);

			}
		});

		btnEditarVeiculo.setForeground(new Color(0, 0, 139));
		btnEditarVeiculo.setBounds(194, 323, 109, 41);
		this.add(btnEditarVeiculo);

		btnConsultarPlacaVeiculo = new JButton("");
		btnConsultarPlacaVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditarVeiculo.setEnabled(true);
				btnVeiculoExcluir.setEnabled(true);

				String placa = txtPlaca.getText();

				VeiculoDAO dao = new VeiculoDAO();
				VeiculoVO veiculo = dao.pesquisarPorPlaca(placa);

				for (VeiculoVO v : dao.pesquisarTodos()) {

					txtPlaca.setText(veiculo.getPlaca());
					txtRenavam.setText(veiculo.getRenavam());
					txtChassi.setText(veiculo.getChassi());
					cbMarcaVeiculo.setSelectedItem(veiculo.getMarca());
					txtModelo.setText(veiculo.getModelo());
					cbAnoVeiculo.setSelectedItem(veiculo.getAno());
					cbCorVeiculo.setSelectedItem(veiculo.getCor());
					cbDadosVeiculoMotor.setSelectedItem(veiculo.getMotor());
					cbDadosVeiculoTransmissao.setSelectedItem(veiculo.getTransmissao());
				}
			}
		});
		btnConsultarPlacaVeiculo.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/pesquisapequeno.png")));
		btnConsultarPlacaVeiculo.setBounds(188, 101, 36, 27);
		this.add(btnConsultarPlacaVeiculo);

		JButton btnVeiculoNovo = new JButton("Novo");
		btnVeiculoNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtPlaca.setEnabled(true);
				txtRenavam.setEnabled(true);
				txtChassi.setEnabled(true);
				cbMarcaVeiculo.setEnabled(true);
				txtModelo.setEnabled(true);
				cbAnoVeiculo.setEnabled(true);
				cbCorVeiculo.setEnabled(true);
				cbDadosVeiculoMotor.setEnabled(true);
				cbDadosVeiculoTransmissao.setEnabled(true);

				limparTela();
			}
		});
		btnVeiculoNovo.setForeground(new Color(0, 0, 139));
		btnVeiculoNovo.setBackground(new Color(240, 248, 255));
		btnVeiculoNovo.setBounds(75, 323, 109, 41);
		add(btnVeiculoNovo);

		btnVeiculoExcluir = new JButton("Excluir");
		btnVeiculoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int resposta = 0;
				
				resposta = JOptionPane.showConfirmDialog(getRootPane(), "Deseja realmente excluir? ");
				if(resposta == JOptionPane.YES_OPTION) {
					veiculoVO.setPlaca(txtPlaca.getText());
					veiculoDAO.excluir(veiculoVO.getPlaca());
					
					limparTela();
				}
			}
		});
		btnVeiculoExcluir.setForeground(new Color(0, 0, 139));
		btnVeiculoExcluir.setEnabled(false);
		btnVeiculoExcluir.setBackground(new Color(240, 248, 255));
		btnVeiculoExcluir.setBounds(313, 323, 109, 41);
		add(btnVeiculoExcluir);

	}

	protected void limparTela() {
		txtPlaca.setText("");
		txtRenavam.setText("");
		txtChassi.setText("");
		cbMarcaVeiculo.setSelectedItem("");
		txtModelo.setText("");
		cbAnoVeiculo.setSelectedItem("");
		cbCorVeiculo.setSelectedItem("");
		cbDadosVeiculoMotor.setSelectedItem("");
		cbDadosVeiculoTransmissao.setSelectedItem("");
	}
}
