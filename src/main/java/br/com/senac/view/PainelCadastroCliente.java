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
		lblNome.setBounds(56, 88, 46, 14);
		add(lblNome);
		
		JFormattedTextField txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(56, 103, 135, 20);
		add(txtNomeCliente);
		
		JLabel lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(222, 88, 78, 14);
		add(lblSobreNome);
		
		JFormattedTextField txtSobrenomeCliente = new JFormattedTextField();
		txtSobrenomeCliente.setBounds(222, 103, 135, 20);
		add(txtSobrenomeCliente);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(394, 88, 46, 14);
		add(lblCPF);
		
		JFormattedTextField txtCpfCliente = new JFormattedTextField();
		txtCpfCliente.setBounds(394, 103, 135, 20);
		add(txtCpfCliente);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(56, 148, 52, 14);
		add(lblEmail);
		
		JFormattedTextField txtEmail = new JFormattedTextField();
		txtEmail.setBounds(56, 163, 135, 20);
		add(txtEmail);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone");
		lblTelefoneCliente.setBounds(222, 148, 61, 14);
		add(lblTelefoneCliente);
		
		JFormattedTextField txtTelefoneCliente = new JFormattedTextField();
		txtTelefoneCliente.setBounds(222, 163, 135, 20);
		add(txtTelefoneCliente);
		
		JLabel lblClienteCNH = new JLabel("CNH");
		lblClienteCNH.setBounds(394, 148, 61, 14);
		add(lblClienteCNH);
		
		JFormattedTextField txtClienteCNH = new JFormattedTextField();
		txtClienteCNH.setBounds(394, 163, 135, 20);
		add(txtClienteCNH);
		
		JLabel lblEnderecoCliente = new JLabel("Endereço");
		lblEnderecoCliente.setBounds(56, 208, 61, 14);
		add(lblEnderecoCliente);
		
		JFormattedTextField txtEnderecoCliente = new JFormattedTextField();
		txtEnderecoCliente.setBounds(56, 223, 135, 20);
		add(txtEnderecoCliente);
		
		JLabel lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(222, 208, 61, 14);
		add(lblCidadeCliente);
		
		JFormattedTextField txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(222, 223, 135, 20);
		add(txtCidadeCliente);
		
		JLabel lblEstadoCliente = new JLabel("Estado");
		lblEstadoCliente.setBounds(394, 208, 46, 14);
		add(lblEstadoCliente);
		
		JComboBox cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"", "RS", "RJ", "SP", "SC"}));
		cbEstadoCliente.setBounds(394, 223, 46, 20);
		add(cbEstadoCliente);
		
		JLabel lblCEPCliente = new JLabel("CEP");
		lblCEPCliente.setBounds(450, 208, 46, 14);
		add(lblCEPCliente);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(450, 223, 79, 20);
		add(formattedTextField);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(56, 275, 473, 2);
		add(separator);
		
		JButton btnSalvarCliente = new JButton(" Salvar");
		btnSalvarCliente.setVerticalAlignment(SwingConstants.TOP);
		btnSalvarCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/Salvar.png")));
		btnSalvarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarCliente.setForeground(new Color(0, 0, 139));
		btnSalvarCliente.setBackground(new Color(240, 248, 255));
		btnSalvarCliente.setBounds(246, 337, 111, 41);
		add(btnSalvarCliente);

	}
}
