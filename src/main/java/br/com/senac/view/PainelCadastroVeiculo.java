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
	private JCheckBox chkArCondicionado;
	private JCheckBox chkDirecaoHidraulica;
	private JCheckBox chkVidroEletrico;
	private JCheckBox chkDirecaoEletrica;
	private JCheckBox chkDuasPortas;
	private JCheckBox chkQuatroPortas;
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
		setBounds(100, 100, 604, 421);
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
		
		chkArCondicionado = new JCheckBox("Ar condicionado");
		chkArCondicionado.setBackground(UIManager.getColor("240, 248, 255"));
		chkArCondicionado.setBounds(60, 259, 123, 23);
		this.add(chkArCondicionado);
		
		chkDirecaoHidraulica = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		chkDirecaoHidraulica.setBackground((Color) null);
		chkDirecaoHidraulica.setBounds(221, 259, 129, 23);
		this.add(chkDirecaoHidraulica);
		
		chkVidroEletrico = new JCheckBox("Vidro El\u00E9trico");
		chkVidroEletrico.setBackground((Color) null);
		chkVidroEletrico.setBounds(391, 285, 111, 23);
		this.add(chkVidroEletrico);
		
		chkDirecaoEletrica = new JCheckBox("Dire\u00E7\u00E3o El\u00E9trica");
		chkDirecaoEletrica.setBackground((Color) null);
		chkDirecaoEletrica.setBounds(391, 259, 123, 23);
		this.add(chkDirecaoEletrica);
		
		chkDuasPortas = new JCheckBox("2 Portas");
		chkDuasPortas.setBackground((Color) null);
		chkDuasPortas.setBounds(60, 285, 123, 23);
		this.add(chkDuasPortas);
		
		chkQuatroPortas = new JCheckBox("4 Portas");
		chkQuatroPortas.setBackground((Color) null);
		chkQuatroPortas.setBounds(221, 285, 123, 23);
		this.add(chkQuatroPortas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 250, 482, 2);
		this.add(separator);
		
		JButton btnSalvar = new JButton(" Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Passou pelo bot�o SALVAR");
			}
		});
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvar.setIcon(new ImageIcon(PainelCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvar.setForeground(new Color(0, 0, 139));
		btnSalvar.setBackground(new Color(240, 248, 255));
		btnSalvar.setBounds(223, 330, 111, 41);
		this.add(btnSalvar);
		
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"            Selecione", "Autom\u00E1tica", "Manual"}));
		comboBox.setBounds(223, 214, 146, 22);
		this.add(comboBox);
	}
}

/*teste commit*/