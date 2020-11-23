package br.com.senac.view;

import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;

import br.com.senac.controller.LocacaoController;
import br.com.senac.model.dao.Banco;
import br.com.senac.model.dao.ClienteDAO;
import br.com.senac.model.dao.VeiculoDAO;
import br.com.senac.model.vo.ClienteVO;
import br.com.senac.model.vo.LocacaoVO;
import br.com.senac.model.vo.VeiculoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemEvent;

public class PainelReservaLocacao extends JPanel {

	private JButton btnSalvarReserva;
	private DatePicker ReservaDataLocacaoVeiculo;
	private DatePicker ReservaDataDevolucaoVeiculo;
	private JFormattedTextField txtReservaVeiculoKmAtual;
	private JLabel lblReservaLocacaoDataDevolucao;
	private JComboBox cbCliente;
	private JComboBox cbVeiculo;
	private JFormattedTextField txtReservaVeiculoKmDevolucao;
	private JPanel tela;
	
	/**
	 * Create the panel.
	 */
	
	public PainelReservaLocacao() {
		setLayout(null);
				
		JLabel lblDadosDaReserva = new JLabel("Dados da Reserva");
		lblDadosDaReserva.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosDaReserva.setBounds(23, 35, 146, 14);
		this.add(lblDadosDaReserva);
		
		JLabel lblReservaLocacaoCliente = new JLabel("Cliente");
		lblReservaLocacaoCliente.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblReservaLocacaoCliente.setBounds(90, 90, 46, 14);
		this.add(lblReservaLocacaoCliente);
		
		JLabel lblReservaLocacaoVeiculo = new JLabel("Veículo");
		lblReservaLocacaoVeiculo.setBounds(298, 90, 46, 14);
		this.add(lblReservaLocacaoVeiculo);
		
		JLabel lblReservaDataLocacao = new JLabel("Data da Locação");
		lblReservaDataLocacao.setBounds(90, 154, 95, 14);
		this.add(lblReservaDataLocacao);
		
		ReservaDataLocacaoVeiculo = new DatePicker();
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataLocacaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataLocacaoVeiculo.setBounds(90, 168, 182, 25);
		this.add(ReservaDataLocacaoVeiculo);
		
		lblReservaLocacaoDataDevolucao = new JLabel("Data da Devolução");
		lblReservaLocacaoDataDevolucao.setBounds(298, 154, 105, 14);
		this.add(lblReservaLocacaoDataDevolucao);
		
		ReservaDataDevolucaoVeiculo = new DatePicker();
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataDevolucaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataDevolucaoVeiculo.setBounds(298, 168, 182, 25);
		this.add(ReservaDataDevolucaoVeiculo);
		
		JLabel lblReservaLocacaoKmAtual = new JLabel("KM Atual");
		lblReservaLocacaoKmAtual.setBounds(90, 219, 57, 14);
		this.add(lblReservaLocacaoKmAtual);
		
		JLabel lblReservaLocacaoKmDevolucao = new JLabel("KM Devolução");
		lblReservaLocacaoKmDevolucao.setBounds(298, 219, 105, 14);
		this.add(lblReservaLocacaoKmDevolucao);

		JSeparator separator = new JSeparator();
		separator.setBounds(66, 287, 464, 2);
		this.add(separator);
								
		try {
			MaskFormatter mascaraKmAtual = new MaskFormatter("######");
			MaskFormatter mascaraKmDevolucao = new MaskFormatter("######");
		
			txtReservaVeiculoKmAtual = new JFormattedTextField(mascaraKmAtual);
			txtReservaVeiculoKmAtual.setBounds(90, 233, 182, 25);
			this.add(txtReservaVeiculoKmAtual);
			
			txtReservaVeiculoKmDevolucao = new JFormattedTextField(mascaraKmDevolucao);
			txtReservaVeiculoKmDevolucao.setBounds(298, 233, 182, 25);
			this.add(txtReservaVeiculoKmDevolucao);
		
			btnSalvarReserva = new JButton("  Reservar");
			btnSalvarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					LocacaoVO novaLocacao = new LocacaoVO();
					
					novaLocacao.setCliente((ClienteVO)cbCliente.getSelectedItem());
					novaLocacao.setVeiculo((VeiculoVO)cbVeiculo.getSelectedItem()); 
					novaLocacao.setDataLocacao(ReservaDataLocacaoVeiculo.getDate());
					novaLocacao.setKmLocacao((int)txtReservaVeiculoKmAtual.getValue());
				/*	novaLocacao.setDataEntrega(ReservaDataDevolucaoVeiculo.getDate());
					novaLocacao.setKmLocacao(Integer.parseInt(txtReservaVeiculoKmDevolucao.getValue().toString()));;  */
							
					LocacaoController controller = new LocacaoController();

					String mensagem = controller.salvar(novaLocacao);
					JOptionPane.showMessageDialog(null, mensagem);
				
				}
					
			});
			btnSalvarReserva.setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Salvar.png")));
			btnSalvarReserva.setHorizontalAlignment(SwingConstants.LEFT);
			btnSalvarReserva.setForeground(new Color(0, 0, 139));
			btnSalvarReserva.setBackground(new Color(240, 248, 255));

			btnSalvarReserva.setBounds(144, 325, 128, 41);
			this.add(btnSalvarReserva);
			
			JButton btnEditarVeiculo = new JButton("Devolver");
			btnEditarVeiculo.setBounds(292, 326, 111, 41);
			this.add(btnEditarVeiculo);
				
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro no sistema, entre em contato com o administrador.");
			System.out.println("Causa da exceÃ§Ã£o: " + e.getMessage());
	}
	
		cbCliente = new JComboBox();
		cbCliente.setBounds(90, 106, 182, 25);
		this.add(cbCliente);
		
		ClienteDAO clientes = new ClienteDAO();
		for(ClienteVO cliente: clientes.pesquisarTodos()) {
		cbCliente.addItem(cliente); 
		
		}
		
		cbVeiculo = new JComboBox();
		cbVeiculo.setBounds(298, 106, 182, 25);
		this.add(cbVeiculo);
		
		VeiculoDAO veiculos = new VeiculoDAO();
		for(VeiculoVO veiculo: veiculos.pesquisarTodos()) {
		cbVeiculo.addItem(veiculo);		
		
		}
	}
}



