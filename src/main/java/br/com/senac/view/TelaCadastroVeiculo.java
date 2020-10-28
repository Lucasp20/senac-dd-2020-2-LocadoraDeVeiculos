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
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.UIManager;

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
		setBounds(100, 100, 613, 390);
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
		txtMarca.setBounds(56, 163, 146, 22);
		contentPane.add(txtMarca);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(56, 148, 46, 14);
		contentPane.add(lblMarca);
		
		TextField txtModelo = new TextField();
		txtModelo.setBounds(223, 163, 146, 22);
		contentPane.add(txtModelo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(223, 148, 46, 14);
		contentPane.add(lblModelo);
		
		TextField txtAno = new TextField();
		txtAno.setBounds(388, 163, 76, 22);
		contentPane.add(txtAno);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(388, 148, 46, 14);
		contentPane.add(lblAno);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(470, 148, 46, 14);
		contentPane.add(lblCor);
		
		TextField txtCor = new TextField();
		txtCor.setBounds(470, 163, 64, 22);
		contentPane.add(txtCor);
		
		chkArCondicionado = new JCheckBox("Ar condicionado");
		chkArCondicionado.setBackground(UIManager.getColor("240, 248, 255"));
		chkArCondicionado.setBounds(56, 250, 123, 23);
		contentPane.add(chkArCondicionado);
		
		JCheckBox chkDirecaoHidraulica = new JCheckBox("Dire\u00E7\u00E3o Hidraulica");
		chkDirecaoHidraulica.setBackground((Color) null);
		chkDirecaoHidraulica.setBounds(195, 250, 129, 23);
		contentPane.add(chkDirecaoHidraulica);
		
		JCheckBox chkVidroEletrico = new JCheckBox("Vidro El\u00E9trico");
		chkVidroEletrico.setBackground((Color) null);
		chkVidroEletrico.setBounds(466, 250, 111, 23);
		contentPane.add(chkVidroEletrico);
		
		JCheckBox chkDirecaoEletrica = new JCheckBox("Dire\u00E7\u00E3o El\u00E9trica");
		chkDirecaoEletrica.setBackground((Color) null);
		chkDirecaoEletrica.setBounds(335, 250, 123, 23);
		contentPane.add(chkDirecaoEletrica);
	}
}
