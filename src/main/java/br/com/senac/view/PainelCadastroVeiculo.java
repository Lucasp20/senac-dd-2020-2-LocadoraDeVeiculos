package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.senac.controller.ClienteController;
import br.com.senac.controller.VeiculoController;
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

public class PainelCadastroVeiculo extends JPanel {

	private JLabel lblPlaca;
	private JFormattedTextField txtPlaca;
	private JLabel lblRenavam;
	private JFormattedTextField txtRenavam;
	private JLabel lblChassi;
	private JFormattedTextField txtChassi;
	private JLabel lblDadosVeiculo;
	private JFormattedTextField txtMarca;
	private JLabel lblMarca;
	private JFormattedTextField txtModelo;
	private JLabel lblModelo;
	private JFormattedTextField txtAno;
	private JLabel lblAno;
	private JLabel lblCor;
	private JFormattedTextField txtCor;
	private JButton btnConsultarCpfCliente;
	private JComboBox cbDadosVeiculoMotor;
	private JComboBox cbDadosVeiculoTransmissao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PainelCadastroVeiculo frame = new PainelCadastroVeiculo();
					frame.setVisible(true);
					/* Deixar a tela maximizada
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); */
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public PainelCadastroVeiculo() throws ParseException {
		setBounds(100, 100, 609, 410);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		MaskFormatter mascaraPlaca = new MaskFormatter("UUU-####");
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(75, 86, 46, 14);
		this.add(lblPlaca);
		
		txtPlaca = new JFormattedTextField(mascaraPlaca);
		txtPlaca.setBounds(75, 101, 96, 27);
		this.add(txtPlaca);
		
		lblRenavam = new JLabel("Renavam");
		lblRenavam.setBounds(242, 86, 59, 14);
		this.add(lblRenavam);
		
		txtRenavam = new JFormattedTextField();
		txtRenavam.setBounds(242, 101, 146, 27);
		this.add(txtRenavam);
		
		lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(406, 86, 59, 14);
		this.add(lblChassi);
		
		txtChassi = new JFormattedTextField();
		txtChassi.setBounds(407, 101, 146, 27);
		this.add(txtChassi);
		
		lblDadosVeiculo = new JLabel("Dados do Ve\u00EDculo");
		lblDadosVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosVeiculo.setBounds(21, 31, 146, 14);
		this.add(lblDadosVeiculo);
		
		txtMarca = new JFormattedTextField();
		txtMarca.setBounds(75, 160, 146, 27);
		this.add(txtMarca);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(75, 145, 46, 14);
		this.add(lblMarca);
		
		txtModelo = new JFormattedTextField();
		txtModelo.setBounds(242, 160, 146, 27);
		this.add(txtModelo);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(242, 145, 46, 14);
		this.add(lblModelo);
		
		txtAno = new JFormattedTextField();
		txtAno.setBounds(407, 160, 76, 27);
		this.add(txtAno);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(407, 145, 46, 14);
		this.add(lblAno);
		
		lblCor = new JLabel("Cor");
		lblCor.setBounds(489, 145, 46, 14);
		this.add(lblCor);
		
		txtCor = new JFormattedTextField();
		txtCor.setBounds(489, 160, 64, 27);
		this.add(txtCor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(71, 263, 482, 2);
		this.add(separator);
		
		JButton btnSalvarVeiculo = new JButton(" Salvar");
		btnSalvarVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Passou pelo bot�o SALVAR");
				
				VeiculoController controlador = new VeiculoController();
				VeiculoVO novoVeiculo = construirNovoVeiculo();
				String situacao = controlador.salvar(novoVeiculo);
				JOptionPane.showMessageDialog(null, situacao);		
				
				
				
			}

		});
		btnSalvarVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarVeiculo.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvarVeiculo.setForeground(new Color(0, 0, 139));
		btnSalvarVeiculo.setBackground(new Color(240, 248, 255));
		btnSalvarVeiculo.setBounds(133, 327, 111, 41);
		this.add(btnSalvarVeiculo);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(75, 199, 76, 14);
		this.add(lblMotor);
		
		JLabel lblTransmissao = new JLabel("Transmiss\u00E3o");
		lblTransmissao.setBounds(242, 199, 88, 14);
		this.add(lblTransmissao);
		
		JComboBox cbDadosVeiculoTransmissao = new JComboBox();
		cbDadosVeiculoTransmissao.setToolTipText("");
		cbDadosVeiculoTransmissao.setModel(new DefaultComboBoxModel(new String[] {"            Selecione", "Automática", "Manual"}));
		cbDadosVeiculoTransmissao.setBounds(242, 214, 146, 27);
		this.add(cbDadosVeiculoTransmissao);
		
		JButton btnExcluirVeiculo = new JButton("Excluir");
		btnExcluirVeiculo.setBounds(404, 327, 111, 41);
		add(btnExcluirVeiculo);
		
		JButton btnEditarVeiculo = new JButton("Editar");
		btnEditarVeiculo.setBounds(268, 327, 111, 41);
		add(btnEditarVeiculo);
		
		btnConsultarCpfCliente = new JButton("");
		btnConsultarCpfCliente.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/pesquisapequeno.png")));
		btnConsultarCpfCliente.setBounds(173, 101, 51, 27);
		add(btnConsultarCpfCliente);
		
		cbDadosVeiculoMotor = new JComboBox();
		cbDadosVeiculoMotor.setModel(new DefaultComboBoxModel(new String[] {"             Selecione   ", "1.0", "1.4", "1.6", "2.0"}));
		cbDadosVeiculoMotor.setBounds(75, 214, 146, 27);
		add(cbDadosVeiculoMotor);
	}
	private VeiculoVO construirNovoVeiculo() {
		VeiculoVO novoVeiculo = new VeiculoVO();
		novoVeiculo.setMarca(txtMarca.getText());
		novoVeiculo.setAno(Integer.parseInt(txtAno.getText()));
		novoVeiculo.setChassi(txtChassi.getText());
		novoVeiculo.setModelo(txtModelo.getText());
		novoVeiculo.setCor(txtCor.getText());
		novoVeiculo.setMotor((String) cbDadosVeiculoMotor.getSelectedItem());
		novoVeiculo.setPlaca(txtPlaca.getText());
		novoVeiculo.setRenavam(txtRenavam.getText());
		novoVeiculo.setTransmissao((String) cbDadosVeiculoTransmissao.getSelectedItem());
				
		return novoVeiculo;
	}
}

/*teste commit*/