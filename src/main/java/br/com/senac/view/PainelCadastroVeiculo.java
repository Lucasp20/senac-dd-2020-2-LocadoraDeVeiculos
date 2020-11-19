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
	private JLabel lblMarca;
	private JFormattedTextField txtModelo;
	private JLabel lblModelo;
	private JLabel lblAno;
	private JLabel lblCor;
	private JButton btnConsultarCpfCliente;
	private JComboBox cbDadosVeiculoMotor;
	private JComboBox cbDadosVeiculoTransmissao;
	private JComboBox cbMarcaVeiculo;
	private JComboBox cbAnoVeiculo;
	private JComboBox cbCorVeiculo ;

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
		
		MaskFormatter mascaraPlaca = new MaskFormatter("UUU-#*##");
		
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
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(75, 145, 46, 14);
		this.add(lblMarca);
				
		txtModelo = new JFormattedTextField();
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
		cbDadosVeiculoTransmissao.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbDadosVeiculoTransmissao.setToolTipText("");
		cbDadosVeiculoTransmissao.setModel(new DefaultComboBoxModel(new String[] {"            Selecione", "Automática", "Manual"}));
		cbDadosVeiculoTransmissao.setBounds(242, 214, 146, 27);
		this.add(cbDadosVeiculoTransmissao);
		
		cbDadosVeiculoMotor = new JComboBox();
		cbDadosVeiculoMotor.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbDadosVeiculoMotor.setModel(new DefaultComboBoxModel(new String[] {"             Selecione   ", "1.0", "1.4", "1.6", "2.0"}));
		cbDadosVeiculoMotor.setBounds(75, 214, 146, 27);
		this.add(cbDadosVeiculoMotor);

		cbMarcaVeiculo = new JComboBox();
		cbMarcaVeiculo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cbMarcaVeiculo.setModel(new DefaultComboBoxModel(new String[] {"               Selecione", "Audi", "BMW", "Citroën", "Dodge", "Fiat", 
															"Ford", "Chevrolet", "Honda", "Hyndai", "Jac", "Jeep", "Kia", "Nissan", "Peugeot", "Renault", "Toyota"}));
		cbMarcaVeiculo.setBounds(73, 160, 151, 27);
		this.add(cbMarcaVeiculo);
		
		cbAnoVeiculo = new JComboBox();
		cbAnoVeiculo.setModel(new DefaultComboBoxModel(new String[] {"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		cbAnoVeiculo.setBounds(406, 160, 73, 27);
		this.add(cbAnoVeiculo);
		
		cbCorVeiculo = new JComboBox();
		cbCorVeiculo.setModel(new DefaultComboBoxModel(new String[] {"", "Branco", "Prata", "Preto", "Vermelho"}));
		cbCorVeiculo.setBounds(487, 160, 66, 27);
		add(cbCorVeiculo);
		
		JButton btnSalvarVeiculo = new JButton(" Salvar");
		btnSalvarVeiculo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				VeiculoVO novoVeiculo = new VeiculoVO();
				
				novoVeiculo.setPlaca(txtPlaca.getText());
				novoVeiculo.setRenavam(txtRenavam.getText());
				novoVeiculo.setChassi(txtChassi.getText());
				novoVeiculo.setMarca((String)(cbMarcaVeiculo.getSelectedItem()));
				novoVeiculo.setModelo(txtModelo.getText());
				novoVeiculo.setAno(Integer.parseInt(cbAnoVeiculo.getSelectedItem().toString()));
				novoVeiculo.setCor((String) cbCorVeiculo.getSelectedItem());
				novoVeiculo.setMotor((String) cbDadosVeiculoMotor.getSelectedItem());
				novoVeiculo.setTransmissao((String) cbDadosVeiculoTransmissao.getSelectedItem());
										
				VeiculoController veiculoController = new VeiculoController();
				JOptionPane.showMessageDialog(null, veiculoController.cadastrarVeiculo(novoVeiculo));
					
			}

		});
		btnSalvarVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarVeiculo.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvarVeiculo.setForeground(new Color(0, 0, 139));
		btnSalvarVeiculo.setBackground(new Color(240, 248, 255));
		btnSalvarVeiculo.setBounds(133, 327, 111, 41);
		this.add(btnSalvarVeiculo);
				
		JButton btnExcluirVeiculo = new JButton("Excluir");
		btnExcluirVeiculo.setForeground(new Color(0, 0, 139));
		btnExcluirVeiculo.setBounds(404, 327, 111, 41);
		this.add(btnExcluirVeiculo);
		
		JButton btnEditarVeiculo = new JButton("Editar");
		btnEditarVeiculo.setForeground(new Color(0, 0, 139));
		btnEditarVeiculo.setBounds(268, 327, 111, 41);
		this.add(btnEditarVeiculo);
		
		btnConsultarCpfCliente = new JButton("");
		btnConsultarCpfCliente.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/pesquisapequeno.png")));
		btnConsultarCpfCliente.setBounds(173, 101, 51, 27);
		this.add(btnConsultarCpfCliente);
				
	}
}

/*teste commit*/