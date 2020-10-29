package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;
	private JLabel lblPlaca;
	private TextField txtPlaca;
	private JCheckBox chkArCondicionado;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroVeiculo frame = new TelaCadastroVeiculo();
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
	 */
	public TelaCadastroVeiculo() {
		setTitle("Cadastro de Veiculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(56, 86, 46, 14);
		contentPane.add(lblPlaca);
		
		txtPlaca = new TextField();
		txtPlaca.setBounds(56, 101, 146, 22);
		contentPane.add(txtPlaca);
		
		JLabel lblRenavam = new JLabel("Renavam");
		lblRenavam.setBounds(223, 86, 59, 14);
		contentPane.add(lblRenavam);
		
		TextField txtRenavam = new TextField();
		txtRenavam.setBounds(223, 101, 146, 22);
		contentPane.add(txtRenavam);
		
		JLabel lblChassi = new JLabel("Chassi");
		lblChassi.setBounds(387, 86, 59, 14);
		contentPane.add(lblChassi);
		
		TextField txtChassi = new TextField();
		txtChassi.setBounds(388, 101, 146, 22);
		contentPane.add(txtChassi);
		
		JLabel lblDadosVeiculo = new JLabel("Dados do Ve\u00EDculo");
		lblDadosVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosVeiculo.setBounds(21, 31, 146, 14);
		contentPane.add(lblDadosVeiculo);
		
		TextField txtMarca = new TextField();
		txtMarca.setBounds(56, 160, 146, 22);
		contentPane.add(txtMarca);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(56, 145, 46, 14);
		contentPane.add(lblMarca);
		
		TextField txtModelo = new TextField();
		txtModelo.setBounds(223, 160, 146, 22);
		contentPane.add(txtModelo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(223, 145, 46, 14);
		contentPane.add(lblModelo);
		
		TextField txtAno = new TextField();
		txtAno.setBounds(388, 160, 76, 22);
		contentPane.add(txtAno);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(388, 145, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(470, 145, 46, 14);
		contentPane.add(lblCor);
		
		TextField txtCor = new TextField();
		txtCor.setBounds(470, 160, 64, 22);
		contentPane.add(txtCor);
		
		chkArCondicionado = new JCheckBox("Ar condicionado");
		chkArCondicionado.setBackground(UIManager.getColor("240, 248, 255"));
		chkArCondicionado.setBounds(60, 259, 123, 23);
		contentPane.add(chkArCondicionado);
		
		JCheckBox chkDirecaoHidraulica = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		chkDirecaoHidraulica.setBackground((Color) null);
		chkDirecaoHidraulica.setBounds(221, 259, 129, 23);
		contentPane.add(chkDirecaoHidraulica);
		
		JCheckBox chkVidroEletrico = new JCheckBox("Vidro El\u00E9trico");
		chkVidroEletrico.setBackground((Color) null);
		chkVidroEletrico.setBounds(391, 285, 111, 23);
		contentPane.add(chkVidroEletrico);
		
		JCheckBox chkDirecaoEletrica = new JCheckBox("Dire\u00E7\u00E3o El\u00E9trica");
		chkDirecaoEletrica.setBackground((Color) null);
		chkDirecaoEletrica.setBounds(391, 259, 123, 23);
		contentPane.add(chkDirecaoEletrica);
		
		JCheckBox chkDuasPortas = new JCheckBox("2 Portas");
		chkDuasPortas.setBackground((Color) null);
		chkDuasPortas.setBounds(60, 285, 123, 23);
		contentPane.add(chkDuasPortas);
		
		JCheckBox chkQuatroPortas = new JCheckBox("4 Portas");
		chkQuatroPortas.setBackground((Color) null);
		chkQuatroPortas.setBounds(221, 285, 123, 23);
		contentPane.add(chkQuatroPortas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 250, 482, 2);
		contentPane.add(separator);
		
		JButton btnSalvar = new JButton(" Salvar");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"Passou pelo bot�o SALVAR");
			}
		});
		btnSalvar.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvar.setIcon(new ImageIcon(TelaCadastroVeiculo.class.getResource("/icons/Salvar.png")));
		btnSalvar.setForeground(new Color(0, 0, 139));
		btnSalvar.setBackground(new Color(240, 248, 255));
		btnSalvar.setBounds(223, 330, 111, 41);
		contentPane.add(btnSalvar);
		
		TextField txtMotor = new TextField();
		txtMotor.setBounds(56, 214, 146, 22);
		contentPane.add(txtMotor);
		
		JLabel lblMotor = new JLabel("Motor");
		lblMotor.setBounds(56, 199, 76, 14);
		contentPane.add(lblMotor);
		
		JLabel lblTransmissao = new JLabel("Transmiss\u00E3o");
		lblTransmissao.setBounds(223, 199, 88, 14);
		contentPane.add(lblTransmissao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"            Selecione", "Autom\u00E1tica", "Manual"}));
		comboBox.setBounds(223, 214, 146, 22);
		contentPane.add(comboBox);
	}
}

/*teste commit*/