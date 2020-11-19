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

	private JLabel lblNome;
	private JLabel lblDadosClientes;
	private JLabel lblSobreNome;
	private JLabel lblCPF;
	private JLabel lblEmail;
	private JFormattedTextField txtNomeCliente;
	private JFormattedTextField txtSobrenomeCliente;
	private JFormattedTextField txtEmail;
	private JFormattedTextField txtClienteCNH;
	private JFormattedTextField txtEnderecoCliente;
	private JFormattedTextField txtClienteCpf;
	private JFormattedTextField txtCidadeCliente;
	private JFormattedTextField txtTelefoneCliente;
	private JComboBox cbEstadoCliente;
	private JFormattedTextField txtCepCliente;
	private JPanel contentPane;
	private JButton btnSalvarCliente;
	private JFormattedTextField txtCEPCliente;
	private JButton btnEditarVeiculo;
	private JButton btnExcluirVeiculo;
	private JButton btnConsultarCpfCliente;
	private JLabel lblTelefoneCliente; 
	private JLabel lblClienteCNH;
	private JLabel lblEnderecoCliente;
	private JLabel lblCidadeCliente;
	private JLabel lblEstadoCliente;

	
	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PainelCadastroCliente(){
		setLayout(null);
		
		lblDadosClientes = new JLabel("Dados do Cliente");
		lblDadosClientes.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosClientes.setBounds(25, 42, 141, 14);
		this.add(lblDadosClientes);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 85, 46, 14);
		this.add(lblNome);
		
		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(81, 100, 135, 25);
		this.add(txtNomeCliente);
		
		lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(247, 85, 78, 14);
		this.add(lblSobreNome);
		
		txtSobrenomeCliente = new JFormattedTextField();
		txtSobrenomeCliente.setBounds(247, 100, 135, 25);
		this.add(txtSobrenomeCliente);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(419, 85, 46, 14);
		this.add(lblCPF);
						
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(81, 145, 52, 14);
		this.add(lblEmail);
		
		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(81, 160, 135, 25);
		this.add(txtEmail);
		
		lblTelefoneCliente = new JLabel("Telefone");
		lblTelefoneCliente.setBounds(247, 145, 61, 14);
		this.add(lblTelefoneCliente);
				
		lblClienteCNH = new JLabel("CNH");
		lblClienteCNH.setBounds(419, 145, 61, 14);
		this.add(lblClienteCNH);
		
		txtClienteCNH = new JFormattedTextField();
		txtClienteCNH.setBounds(419, 160, 135, 25);
		this.add(txtClienteCNH);
		
		lblEnderecoCliente = new JLabel("Endereço");
		lblEnderecoCliente.setBounds(81, 205, 61, 14);
		this.add(lblEnderecoCliente);
		
		txtEnderecoCliente = new JFormattedTextField();
		txtEnderecoCliente.setBounds(81, 220, 135, 25);
		this.add(txtEnderecoCliente);
		
		lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(247, 205, 61, 14);
		this.add(lblCidadeCliente);
		
		txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setBounds(247, 220, 135, 25);
		this.add(txtCidadeCliente);
		
		lblEstadoCliente = new JLabel("Estado");
		lblEstadoCliente.setBounds(419, 205, 46, 14);
		this.add(lblEstadoCliente);
		
		cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"", "RS", "RJ", "SP", "SC"}));
		cbEstadoCliente.setBounds(419, 220, 46, 25);
		this.add(cbEstadoCliente);
		
		JLabel lblCEPCliente = new JLabel("CEP");
		lblCEPCliente.setBounds(475, 205, 46, 14);
		this.add(lblCEPCliente);
				
		JSeparator separator = new JSeparator();
		separator.setBounds(81, 272, 473, 2);
		this.add(separator); 
	
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
					
			txtClienteCpf = new JFormattedTextField(mascaraCpf);
			txtClienteCpf.setBounds(419, 100, 135, 26);
			this.add(txtClienteCpf);
			
			txtTelefoneCliente = new JFormattedTextField(mascaraTelefone);
			txtTelefoneCliente.setBounds(247, 160, 135, 25);
			this.add(txtTelefoneCliente);
						
			txtCEPCliente = new JFormattedTextField(mascaraCep);
			txtCEPCliente.setBounds(475, 220, 79, 25);
			this.add(txtCEPCliente);
			
			btnEditarVeiculo = new JButton("Editar");
			btnEditarVeiculo.setBounds(274, 322, 111, 41);
			this.add(btnEditarVeiculo);
			
			btnExcluirVeiculo = new JButton("Excluir");
			btnExcluirVeiculo.setBounds(410, 322, 111, 41);
			this.add(btnExcluirVeiculo);
			
			
			btnConsultarCpfCliente = new JButton("");
			btnConsultarCpfCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/pesquisapequeno.png")));
			btnConsultarCpfCliente.setBounds(556, 99, 46, 26);
			this.add(btnConsultarCpfCliente);
		
			btnSalvarCliente = new JButton(" Salvar");
			btnSalvarCliente.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent arg0) {
					ClienteVO novoCliente = new ClienteVO();
						
					String cpf = txtClienteCpf.getText().replace("-"," ").replace("."," ");
					
					novoCliente.setNome(txtNomeCliente.getText());
					novoCliente.setSobrenome(txtSobrenomeCliente.getText());
					novoCliente.setCpf(txtClienteCpf.getText().replace("."," ").replace("-"," "));
					novoCliente.setEmail(txtEmail.getText());
					novoCliente.setCnh(txtClienteCNH.getText());
					novoCliente.setTelefone(txtTelefoneCliente.getText());
					novoCliente.setEndereco(txtEnderecoCliente.getText());
					novoCliente.setCidade(txtCidadeCliente.getText());
					novoCliente.setEstado(cbEstadoCliente.getSelectedItem().toString());
					novoCliente.setCep(txtCEPCliente.getText());   
								
					ClienteController controller = new ClienteController();
					
					String mensagem = controller.salvar(novoCliente);
					
					JOptionPane.showMessageDialog(null, mensagem);
				} 

			});
			btnSalvarCliente.setVerticalAlignment(SwingConstants.TOP);
			btnSalvarCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/Salvar.png")));
			btnSalvarCliente.setHorizontalAlignment(SwingConstants.LEFT);
			btnSalvarCliente.setForeground(new Color(0, 0, 139));
			btnSalvarCliente.setBackground(new Color(240, 248, 255));
			btnSalvarCliente.setBounds(140, 322, 111, 41);
			add(btnSalvarCliente);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceÃ§Ã£o: " + e.getMessage());
		}
		
	}

}