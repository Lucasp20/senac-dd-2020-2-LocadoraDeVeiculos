package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dialog.ModalExclusionType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import br.com.senac.controller.ClienteController;
import br.com.senac.controller.VeiculoController;
import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.bo.VeiculoBO;
import br.com.senac.model.dao.Banco;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.vo.ClienteVO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

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
	private JFormattedTextField txtCidadeCliente;
	private JFormattedTextField txtTelefoneCliente;
	private JFormattedTextField txtClienteCPF;
	private JComboBox cbEstadoCliente;
	private JFormattedTextField txtCepCliente;
	private JLabel lblCEPCliente;
	private JPanel contentPane;
	private JSeparator separator;
	private JButton btnSalvarCliente;
	private JFormattedTextField txtCEPCliente;
	private JButton btnEditarCliente;
	private JButton btnConsultarCpfCliente;
	private JLabel lblTelefoneCliente; 
	private JLabel lblClienteCNH;
	private JLabel lblEnderecoCliente;
	private JLabel lblCidadeCliente;
	private JLabel lblEstadoCliente;
	private JButton btnClienteNovo;
	private JButton btnClienteExcluir;
	private ClienteController controlador = new ClienteController();
	private ClienteVO cliente = new ClienteVO();

	public PainelCadastroCliente() {
		setLayout(null);

		lblDadosClientes = new JLabel("Dados do Cliente");
		lblDadosClientes.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosClientes.setBounds(25, 42, 141, 14);
		this.add(lblDadosClientes);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(81, 85, 46, 14);
		this.add(lblNome);

		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setEnabled(false);
		txtNomeCliente.setBounds(81, 100, 135, 25);
		this.add(txtNomeCliente);

		lblSobreNome = new JLabel("Sobrenome");
		lblSobreNome.setBounds(247, 85, 78, 14);
		this.add(lblSobreNome);

		txtSobrenomeCliente = new JFormattedTextField();
		txtSobrenomeCliente.setEnabled(false);
		txtSobrenomeCliente.setBounds(247, 100, 135, 25);
		this.add(txtSobrenomeCliente);

		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(419, 85, 46, 14);
		this.add(lblCPF);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(81, 145, 52, 14);
		this.add(lblEmail);

		txtEmail = new JFormattedTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(81, 160, 135, 25);
		this.add(txtEmail);

		lblTelefoneCliente = new JLabel("Telefone");
		lblTelefoneCliente.setBounds(247, 145, 61, 14);
		this.add(lblTelefoneCliente);

		lblClienteCNH = new JLabel("CNH");
		lblClienteCNH.setBounds(419, 145, 61, 14);
		this.add(lblClienteCNH);

		lblEnderecoCliente = new JLabel("Endereço");
		lblEnderecoCliente.setBounds(81, 205, 61, 14);
		this.add(lblEnderecoCliente);

		txtEnderecoCliente = new JFormattedTextField();
		txtEnderecoCliente.setEnabled(false);
		txtEnderecoCliente.setBounds(81, 220, 135, 25);
		this.add(txtEnderecoCliente);

		lblCidadeCliente = new JLabel("Cidade");
		lblCidadeCliente.setBounds(247, 205, 61, 14);
		this.add(lblCidadeCliente);

		txtCidadeCliente = new JFormattedTextField();
		txtCidadeCliente.setEnabled(false);
		txtCidadeCliente.setBounds(247, 220, 135, 25);
		this.add(txtCidadeCliente);

		lblEstadoCliente = new JLabel("Estado");
		lblEstadoCliente.setBounds(419, 205, 46, 14);
		this.add(lblEstadoCliente);

		cbEstadoCliente = new JComboBox();
		cbEstadoCliente.setEnabled(false);
		cbEstadoCliente.setModel(new DefaultComboBoxModel(new String[] {"", "RS", "RJ", "SP", "SC"}));
		cbEstadoCliente.setBounds(419, 220, 46, 25);
		this.add(cbEstadoCliente);

		lblCEPCliente = new JLabel("CEP");
		lblCEPCliente.setBounds(475, 205, 46, 14);
		this.add(lblCEPCliente);

		separator = new JSeparator();
		separator.setBounds(81, 272, 473, 2);
		this.add(separator); 
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			MaskFormatter mascaraTelefone = new MaskFormatter("(##)#####-####");
			MaskFormatter mascaraCep = new MaskFormatter("#####-###");
			MaskFormatter mascaraCnh = new MaskFormatter("###########");

			txtClienteCPF = new JFormattedTextField(mascaraCpf);
			txtClienteCPF.setText("");
			txtClienteCPF.setBounds(419, 100, 135, 26);
			this.add(txtClienteCPF);

			txtTelefoneCliente = new JFormattedTextField(mascaraTelefone);
			txtTelefoneCliente.setEnabled(false);
			txtTelefoneCliente.setBounds(247, 160, 135, 25);
			this.add(txtTelefoneCliente);

			txtCEPCliente = new JFormattedTextField(mascaraCep);
			txtCEPCliente.setEnabled(false);
			txtCEPCliente.setBounds(475, 220, 79, 25);
			this.add(txtCEPCliente);

			txtClienteCNH = new JFormattedTextField(mascaraCnh);
			txtClienteCNH.setEnabled(false);
			txtClienteCNH.setBounds(419, 160, 135, 25);
			this.add(txtClienteCNH);

			btnEditarCliente = new JButton("Editar");
			btnEditarCliente.setForeground(new Color(0, 0, 139));
			btnEditarCliente.setBackground(new Color(240, 248, 255));
			btnEditarCliente.setEnabled(false);
			btnEditarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNomeCliente.setEnabled(true);
					txtSobrenomeCliente.setEnabled(true);
					txtClienteCPF.setEnabled(true);
					txtEmail.setEnabled(true);
					txtClienteCNH.setEnabled(true);
					txtTelefoneCliente.setEnabled(true);
					txtEnderecoCliente.setEnabled(true);
					cbEstadoCliente.setEnabled(true);
					txtCidadeCliente.setEnabled(true);
					txtCEPCliente.setEnabled(true);		

				}
			});

			btnEditarCliente.setBounds(200, 322, 109, 41);
			btnEditarCliente.setBackground(new Color(240, 248, 255));
			this.add(btnEditarCliente);

			btnSalvarCliente = new JButton(" Salvar");
			btnSalvarCliente.setEnabled(false);
			btnSalvarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				/*	String nome = txtNomeCliente.getText();
					String sobrenome = txtSobrenomeCliente.getText();
					String endereco = txtEnderecoCliente.getText();
					String cidade = txtCidadeCliente.getText();
					
					if(!nome.substring(0,0).equals(nome.substring(0,0).toUpperCase())
							|| !sobrenome.substring(0,0).equals(sobrenome.substring(0,0).toUpperCase())
							|| !endereco.substring(0,0).equals(endereco.substring(0,0).toUpperCase())
							|| !cidade.substring(0,0).equals(cidade.substring(0,0).toUpperCase())) {
								JOptionPane.showMessageDialog(null, "Nome deve iniciar com letra maiúscula.");  
				
					}else{ */
						
					ClienteVO novoCliente = new ClienteVO();
											
						novoCliente.setNome(textoFormatado(txtNomeCliente.getText()+" "));
						novoCliente.setSobrenome(textoFormatado(txtSobrenomeCliente.getText()+" "));
						novoCliente.setCpf(txtClienteCPF.getText().replace(".","").replace("-",""));
						novoCliente.setEmail(txtEmail.getText().toLowerCase());
						novoCliente.setCnh(txtClienteCNH.getText());
						novoCliente.setTelefone(txtTelefoneCliente.getText());
						novoCliente.setEndereco(textoFormatado(txtEnderecoCliente.getText() + " "));
						novoCliente.setCidade(textoFormatado(txtCidadeCliente.getText() +" "));
						novoCliente.setEstado(cbEstadoCliente.getSelectedItem().toString());
						novoCliente.setCep(txtCEPCliente.getText());  
		
					ClienteController clienteController = new ClienteController();
					JOptionPane.showMessageDialog(null, clienteController.cadastrarCliente(novoCliente));
					
				}


			});

			btnSalvarCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/Salvar.png")));
			btnSalvarCliente.setHorizontalAlignment(SwingConstants.LEFT);
			btnSalvarCliente.setForeground(new Color(0, 0, 139));
			btnSalvarCliente.setBackground(new Color(240, 248, 255));
			btnSalvarCliente.setBounds(436, 322, 109, 41);
			this.add(btnSalvarCliente);
			
			btnConsultarCpfCliente = new JButton("");	
			btnConsultarCpfCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnEditarCliente.setEnabled(true);
					btnClienteExcluir.setEnabled(true);
			
					cliente = controlador.pesquisarPorCpf(txtClienteCPF.getText());

					if(cliente !=null) {
						
						txtClienteCPF.setText(cliente.getCpf());
						txtNomeCliente.setText(cliente.getNome());
						txtSobrenomeCliente.setText(cliente.getSobrenome());
						txtEmail.setText(cliente.getEmail());
						txtTelefoneCliente.setText(cliente.getTelefone());
						txtClienteCNH.setText(cliente.getCnh());
						txtEnderecoCliente.setText(cliente.getEndereco());
						txtCidadeCliente.setText(cliente.getCidade());
						cbEstadoCliente.setSelectedItem(cliente.getEstado());
						txtCEPCliente.setText(cliente.getCep());  

					}else{
						JOptionPane.showMessageDialog(null, "Cliente não existe no banco de dados");
					}
				}
			});
			btnConsultarCpfCliente.setIcon(new ImageIcon(PainelCadastroCliente.class.getResource("/icons/pesquisapequeno.png")));
			btnConsultarCpfCliente.setBounds(555, 100, 24, 25);
			this.add(btnConsultarCpfCliente);

				
			btnClienteNovo = new JButton("Novo");
			btnClienteNovo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnSalvarCliente.setEnabled(true);
					
					txtNomeCliente.setEnabled(true);
					txtSobrenomeCliente.setEnabled(true);
					txtClienteCPF.setEnabled(true);
					txtEmail.setEnabled(true);
					txtClienteCNH.setEnabled(true);
					txtTelefoneCliente.setEnabled(true);
					txtEnderecoCliente.setEnabled(true);
					cbEstadoCliente.setEnabled(true);
					txtCidadeCliente.setEnabled(true);
					txtCEPCliente.setEnabled(true);

					limparTela();
				}
			});
			btnClienteNovo.setForeground(new Color(0, 0, 139));
			btnClienteNovo.setBackground(new Color(240, 248, 255));
			btnClienteNovo.setBounds(81, 322, 109, 41);
			add(btnClienteNovo);

			btnClienteExcluir = new JButton("Excluir");
			btnClienteExcluir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
			
					int resposta = 0;

					resposta = JOptionPane.showConfirmDialog(getRootPane(), "Deseja realmente excluir? ");
					if(resposta == JOptionPane.YES_OPTION) {
						controlador.excluirCliente(cliente.getCpf());
						
						ClienteBO clienteBO = new ClienteBO();
						JOptionPane.showMessageDialog(null, clienteBO.excluir(txtClienteCPF.getText()));

						limparTela();
					}

				}
			});
			btnClienteExcluir.setBackground(new Color(240, 248, 255));
			btnClienteExcluir.setForeground(new Color(0, 0, 139));
			btnClienteExcluir.setEnabled(false);
			btnClienteExcluir.setBounds(319, 322, 109, 41);
			this.add(btnClienteExcluir);
			
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceÃ§Ã£o: " + e.getMessage());
		}
	}
	
	protected void limparTela() {
		txtNomeCliente.setText("");
		txtSobrenomeCliente.setText("");
		txtClienteCPF.setText("");
		txtEmail.setText("");
		txtClienteCNH.setText("");
		txtTelefoneCliente.setText("");
		txtEnderecoCliente.setText("");
		cbEstadoCliente.setSelectedItem("");
		txtCidadeCliente.setText("");
		txtCEPCliente.setText("");
	}
	
	private String textoFormatado(String str) {
		String[] array = str.split(" ");
		String texto =" ";
		for (int i = 0; i < str.split(" ").length; i++) {
			texto += array[i].substring(0,1).toUpperCase() + array[i].substring(1).toLowerCase();
			if (i < str.split(" ").length - 1) {
				texto += " ";
			}
		}
		return texto;
	}
}
