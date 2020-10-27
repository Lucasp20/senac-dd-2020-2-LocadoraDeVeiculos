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

public class TelaCadastroVeiculo extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 613, 448);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa");
		lblPlaca.setBounds(56, 86, 46, 14);
		contentPane.add(lblPlaca);
		
		TextField txtPlaca = new TextField();
		txtPlaca.setBounds(56, 101, 126, 22);
		contentPane.add(txtPlaca);
		
		JLabel lblRenavam = new JLabel("Renavam");
		lblRenavam.setBounds(223, 86, 59, 14);
		contentPane.add(lblRenavam);
		
		TextField txtRenavam = new TextField();
		txtRenavam.setBounds(223, 101, 126, 22);
		contentPane.add(txtRenavam);
		
		JLabel lblChassi = new JLabel("Renavam");
		lblChassi.setBounds(387, 86, 59, 14);
		contentPane.add(lblChassi);
		
		TextField txtChassi = new TextField();
		txtChassi.setBounds(388, 101, 126, 22);
		contentPane.add(txtChassi);
		
		JLabel lblDadosVeiculo = new JLabel("Dados do Ve\u00EDculo");
		lblDadosVeiculo.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosVeiculo.setBounds(21, 31, 146, 14);
		contentPane.add(lblDadosVeiculo);
	}
}
