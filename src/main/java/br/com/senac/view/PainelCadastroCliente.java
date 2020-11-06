package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PainelCadastroCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelCadastroCliente() {
		setLayout(null);
		
		JLabel lblDadosClientes = new JLabel("Dados do Cliente");
		lblDadosClientes.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosClientes.setBounds(25, 42, 141, 14);
		add(lblDadosClientes);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 85, 46, 14);
		add(lblNome);
		
		JFormattedTextField txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(81, 100, 135, 25);
		add(txtNomeCliente);
		
		JLabel lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(247, 85, 78, 14);
		add(lblSobreNome);
		
		JFormattedTextField txtSobrenomeCliente = new JFormattedTextField();
		txtSobrenomeCliente.setBounds(247, 100, 135, 25);
		add(txtSobrenomeCliente);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(419, 85, 46, 14);
		add(lblCPF);
		
		JFormattedTextField txtCpfCliente = new JFormattedTextField();
		txtCpfCliente.setBounds(419, 100, 135, 25);
		add(txtCpfCliente);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(81, 145, 52, 14);
		add(lblEmail);
		
		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setBounds(81, 160, 135, 25);
		add(txtEmail);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone");
		lblTelefoneCliente.setBounds(247, 145, 61, 14);
		add(lblTelefoneCliente);
		
		JFormattedTextField txtTelefoneCliente = new JFormattedTextField();
		txtTelefoneCliente.setBounds(247, 160, 135, 25);
		add(txtTelefoneCliente);
		
		JLabel lblClienteCNH = new JLabel("CNH");
		lblClienteCNH.setBounds(419, 145, 61, 14);
		add(lblClienteCNH);
		
		JFormattedTextField txtClienteCNH = new JFormattedTextField();
		txtClienteCNH.setBounds(419, 160, 135, 25);
		add(txtClienteCNH);
		
		JLabel lblEnderecoCliente = new JLabel("Endereço");
		lblEnderecoCliente.setBounds(81, 205, 61, 14);
		add(lblEnderecoCliente);
		
		JFormattedTextField txtEnderecoCliente = new JFormattedTextField();
		txtEnderecoCliente.setBounds(81, 220, 135, 25);
		add(txtEnderecoCliente);
		
		JLabel lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(247, 205, 61, 14);
		add(lblCidadeCliente);
		
		JFormattedTextField txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(247, 220, 135, 25);
		add(txtCidadeCliente);
		
		JLabel lblEstadoCliente = new JLabel("Estado");
		lblEstadoCliente.setBounds(419, 205, 46, 14);
		add(lblEstadoCliente);
		
		JComboBox cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"", "RS", "RJ", "SP", "SC"}));
		cbEstadoCliente.setBounds(419, 220, 46, 25);
		add(cbEstadoCliente);
		
		JLabel lblCEPCliente = new JLabel("CEP");
		lblCEPCliente.setBounds(475, 205, 46, 14);
		add(lblCEPCliente);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(475, 220, 79, 25);
		add(formattedTextField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(81, 272, 473, 2);
		add(separator);
		
		JButton btnSalvarCliente = new JButton(" Salvar");
		btnSalvarCliente.setVerticalAlignment(SwingConstants.TOP);
		btnSalvarCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/Salvar.png")));
		btnSalvarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarCliente.setForeground(new Color(0, 0, 139));
		btnSalvarCliente.setBackground(new Color(240, 248, 255));
		btnSalvarCliente.setBounds(271, 334, 111, 41);
		add(btnSalvarCliente);

	}
}
