package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import br.com.senac.controller.ClienteController;
import br.com.senac.model.vo.ClienteVO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PainelCadastroCliente extends JPanel {

	
	private JFormattedTextField txtNomeCliente;
	private JFormattedTextField txtSobrenomeCliente;
	private JFormattedTextField txtEmail;
	private JFormattedTextField txtClienteCNH;
	private JFormattedTextField txtEnderecoCliente;
	private JFormattedTextField txtClienteCpf;
	private JFormattedTextField txtCidadeCliente;
	private JFormattedTextField txtTelefoneCliente;
	private JFormattedTextField txtEstadoClienteField;
	private JFormattedTextField txtCepCliente;
	private JPanel contentPane;
	private JFormattedTextField txtCpfCliente;
	private JButton btnSalvarCliente;
	private JFormattedTextField txtCEPCliente;

	
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroCliente(){
		setLayout(null);
		
		JLabel lblDadosClientes = new JLabel("Dados do Cliente");
		lblDadosClientes.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosClientes.setBounds(25, 42, 141, 14);
		add(lblDadosClientes);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 85, 46, 14);
		add(lblNome);
		
		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(81, 100, 135, 25);
		add(txtNomeCliente);
		
		JLabel lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(247, 85, 78, 14);
		add(lblSobreNome);
		
		txtSobrenomeCliente = new JFormattedTextField();
		txtSobrenomeCliente.setBounds(247, 100, 135, 25);
		add(txtSobrenomeCliente);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(419, 85, 46, 14);
		add(lblCPF);
						
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(81, 145, 52, 14);
		add(lblEmail);
		
		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(81, 160, 135, 25);
		add(txtEmail);
		
		JLabel lblTelefoneCliente = new JLabel("Telefone");
		lblTelefoneCliente.setBounds(247, 145, 61, 14);
		add(lblTelefoneCliente);
			
		JLabel lblClienteCNH = new JLabel("CNH");
		lblClienteCNH.setBounds(419, 145, 61, 14);
		add(lblClienteCNH);
		
		txtClienteCNH = new JFormattedTextField();
		txtClienteCNH.setBounds(419, 160, 135, 25);
		add(txtClienteCNH);
		
		JLabel lblEnderecoCliente = new JLabel("Endereço");
		lblEnderecoCliente.setBounds(81, 205, 61, 14);
		add(lblEnderecoCliente);
		
		txtEnderecoCliente = new JFormattedTextField();
		txtEnderecoCliente.setBounds(81, 220, 135, 25);
		add(txtEnderecoCliente);
		
		JLabel lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(247, 205, 61, 14);
		add(lblCidadeCliente);
		
		txtCidadeCliente = new JFormattedTextField();
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
				
		JSeparator separator = new JSeparator();
		separator.setBounds(81, 272, 473, 2);
		add(separator); 
		
		btnSalvarCliente = new JButton(" Salvar");
		btnSalvarCliente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				ClienteVO novoCliente = new ClienteVO();
					
				String cpf = txtClienteCpf.getText().replace("-", "").replace(".", "");
				
				novoCliente.setNome(txtNomeCliente.getText());
				novoCliente.setSobrenome(txtSobrenomeCliente.getText());
			/*	novoCliente.setCpf(txtClienteCpf.getText().replace("-", "").replace(".", ""));
				novoCliente.setEmail(txtEmail.getText());
				novoCliente.setCnh(txtClienteCNH.getText());
				novoCliente.setTelefone(txtTelefoneCliente.getText());
				novoCliente.setEndereco(txtEnderecoCliente.getText());
				novoCliente.setCidade(txtCidadeCliente.getText());
				novoCliente.setEstado(txtEstadoClienteField.getText());
				novoCliente.setCep(txtCepCliente.getText());   */
							
				
				ClienteController clienteController = new ClienteController();
				JOptionPane.showMessageDialog(null, clienteController.salvar(novoCliente));
			} 

		});
		btnSalvarCliente.setVerticalAlignment(SwingConstants.TOP);
		btnSalvarCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/Salvar.png")));
		btnSalvarCliente.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarCliente.setForeground(new Color(0, 0, 139));
		btnSalvarCliente.setBackground(new Color(240, 248, 255));
		btnSalvarCliente.setBounds(140, 322, 111, 41);
		add(btnSalvarCliente);

		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
					
			txtCpfCliente = new JFormattedTextField(mascaraCpf);
			txtCpfCliente.setBounds(419, 100, 135, 26);
			add(txtCpfCliente);
			
			txtTelefoneCliente = new JFormattedTextField(mascaraTelefone);
			txtTelefoneCliente.setBounds(247, 160, 135, 25);
			add(txtTelefoneCliente);
						
			txtCEPCliente = new JFormattedTextField(mascaraCep);
			txtCEPCliente.setBounds(475, 220, 79, 25);
			add(txtCEPCliente);
			
			JButton btnEditarVeiculo = new JButton("Editar");
			btnEditarVeiculo.setBounds(274, 322, 111, 41);
			add(btnEditarVeiculo);
			
			JButton btnExcluirVeiculo = new JButton("Excluir");
			btnExcluirVeiculo.setBounds(410, 322, 111, 41);
			add(btnExcluirVeiculo);
			
			JButton btnConsultarCpfCliente = new JButton("");
			btnConsultarCpfCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/pesquisapequeno.png")));
			btnConsultarCpfCliente.setBounds(556, 99, 46, 26);
			add(btnConsultarCpfCliente);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceÃ§Ã£o: " + e.getMessage());
		}
		
	}
	
	/*	protected ClienteVO construirNovoCliente() {
		ClienteVO novoCliente = new ClienteVO();
		
		novoCliente.setNome(txtNomeCliente.getText());
		novoCliente.setSobrenome(txtSobrenomeCliente.getText());
		novoCliente.setCpf(txtClienteCpf.getText());
		novoCliente.setEmail(txtEmail.getText());
		novoCliente.setCnh(txtClienteCNH.getText());
		novoCliente.setTelefone(txtTelefoneCliente.getText());
		novoCliente.setEndereco(txtEnderecoCliente.getText());
		novoCliente.setCidade(txtCidadeCliente.getText());
		novoCliente.setEstado(txtEstadoClienteField.getText());
		novoCliente.setCep(txtCepCliente.getText()); 
					
		return novoCliente;  
	} */
}