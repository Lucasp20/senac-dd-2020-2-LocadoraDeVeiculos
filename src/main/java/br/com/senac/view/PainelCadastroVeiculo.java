package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
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
	private JFormattedTextField txtMotor;
	
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
		setBounds(100, 100, 605, 422);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		MaskFormatter mascaraPlaca = new MaskFormatter("UUU-####");
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(56, 86, 46, 14);
		this.add(lblPlaca);
		
		txtPlaca = new JFormattedTextField(mascaraPlaca);
		txtPlaca.setBounds(56, 101, 146, 22);
		this.add(txtPlaca);
		
		lblRenavam = new JLabel("Renavam");
		lblRenavam.setBounds(223, 86, 59, 14);
		this.add(lblRenavam);
		
		txtRenavam = new JFormattedTextField();
		txtRenavam.setBounds(223, 101, 146, 22);
		this.add(txtRenavam);
		
		lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(387, 86, 59, 14);
		this.add(lblChassi);
		
		txtChassi = new JFormattedTextField();
		txtChassi.setBounds(388, 101, 146, 22);
		this.add(txtChassi);
		
		lblDadosVeiculo = new JLabel("Dados do Ve\u00EDculo");
		lblDadosVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosVeiculo.setBounds(21, 31, 146, 14);
		this.add(lblDadosVeiculo);
		
		txtMarca = new JFormattedTextField();
		txtMarca.setBounds(56, 160, 146, 22);
		this.add(txtMarca);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(56, 145, 46, 14);
		this.add(lblMarca);
		
		txtModelo = new JFormattedTextField();
		txtModelo.setBounds(223, 160, 146, 22);
		this.add(txtModelo);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(223, 145, 46, 14);
		this.add(lblModelo);
		
		txtAno = new JFormattedTextField();
		txtAno.setBounds(388, 160, 76, 22);
		this.add(txtAno);
		
		lblAno = new JLabel("Ano");
		lblAno.setBounds(388, 145, 46, 14);
		this.add(lblAno);
		
		lblCor = new JLabel("Cor");
		lblCor.setBounds(470, 145, 46, 14);
		this.add(lblCor);
		
		txtCor = new JFormattedTextField();
		txtCor.setBounds(470, 160, 64, 22);
		this.add(txtCor);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 250, 482, 2);
		this.add(separator);
		
		JButton btnSalvarVeiculo = new JButton(" Salvar");
		btnSalvarVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Passou pelo bot�o SALVAR");
			}
		});
		btnSalvarVeiculo.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarVeiculo.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvarVeiculo.setForeground(new Color(0, 0, 139));
		btnSalvarVeiculo.setBackground(new Color(240, 248, 255));
		btnSalvarVeiculo.setBounds(111, 330, 111, 41);
		this.add(btnSalvarVeiculo);
		
		txtMotor = new JFormattedTextField();
		txtMotor.setBounds(56, 214, 146, 22);
		this.add(txtMotor);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(56, 199, 76, 14);
		this.add(lblMotor);
		
		JLabel lblTransmissao = new JLabel("Transmiss\u00E3o");
		lblTransmissao.setBounds(223, 199, 88, 14);
		this.add(lblTransmissao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"            Selecione", "Automática", "Manual"}));
		comboBox.setBounds(223, 214, 146, 22);
		this.add(comboBox);
		
		JButton btnExcluirVeiculo = new JButton("Excluir");
		btnExcluirVeiculo.setBounds(382, 330, 111, 41);
		add(btnExcluirVeiculo);
		
		JButton btnEditarVeiculo = new JButton("Editar");
		btnEditarVeiculo.setBounds(246, 330, 111, 41);
		add(btnEditarVeiculo);
	}
}

/*teste commit*/