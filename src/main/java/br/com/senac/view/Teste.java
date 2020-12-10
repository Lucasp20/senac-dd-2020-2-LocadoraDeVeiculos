package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import br.com.senac.model.bo.ClienteBO;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.vo.ClienteVO;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class Teste extends JPanel {

	private JButton btnPesquisar;
	private JFormattedTextField txtCpf;
	private ClienteDAO clienteDAO = new ClienteDAO();
	private ClienteVO cliente = new ClienteVO();
	private ClienteBO bo = new ClienteBO();
	private JFormattedTextField txtNome;
	private JLabel lblNome;
	
	public Teste() {
		setLayout(null);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(44, 80, 46, 14);
		add(lblCPF);
		
		
		try {
			MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
			txtCpf = new JFormattedTextField(mascaraCpf);
			txtCpf.setBounds(44, 95, 119, 20);
			add(txtCpf);
			
			txtNome = new JFormattedTextField();
			txtNome.setBounds(44, 158, 102, 20);
			add(txtNome);
			
			btnPesquisar = new JButton("Pesquisar");
			btnPesquisar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					cliente = clienteDAO.pesquisarPorCpf(txtCpf.getText());

					if(cliente !=null) {
						
						String cpf = txtCpf.getText().replace("-", "").replace(".", "");
						
						txtCpf.setText(cliente.getCpf());
						txtNome.setText(cliente.getNome().trim().replace("."," ").replace("-"," "));
					/*	txtSobrenomeCliente.setText(cliente.getSobrenome());
						txtEmail.setText(cliente.getEmail());
						txtTelefoneCliente.setText(cliente.getTelefone());
						txtClienteCNH.setText(cliente.getCnh());
						txtEnderecoCliente.setText(cliente.getEndereco());
						txtCidadeCliente.setText(cliente.getCidade());
						cbEstadoCliente.setSelectedItem(cliente.getEstado());
						txtCEPCliente.setText(cliente.getCep());  */

					}else{
						JOptionPane.showMessageDialog(null, "Cliente não existe no banco de dados");
					}
				}
			});
			btnPesquisar.setBounds(173, 94, 89, 23);
			add(btnPesquisar);
			
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	
		
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(44, 142, 46, 14);
		add(lblNome);

	}
}
