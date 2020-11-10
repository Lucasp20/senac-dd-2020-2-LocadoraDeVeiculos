package br.com.senac.view;

import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;

public class PainelReservaLocacao extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelReservaLocacao() {
		setLayout(null);
		
		JLabel lblDadosDaReserva = new JLabel("Dados da Reserva");
		lblDadosDaReserva.setFont(new Font("Arial", Font.BOLD, 15));
		lblDadosDaReserva.setBounds(23, 35, 146, 14);
		add(lblDadosDaReserva);
		
		JLabel lblReservaLocacaoCliente = new JLabel("Cliente");
		lblReservaLocacaoCliente.setBounds(90, 90, 46, 14);
		add(lblReservaLocacaoCliente);
		
		JLabel lblReservaLocacaoVeiculo = new JLabel("Veículo");
		lblReservaLocacaoVeiculo.setBounds(298, 90, 46, 14);
		add(lblReservaLocacaoVeiculo);
		
		JLabel lblReservaDataLocacao = new JLabel("Data da Locação");
		lblReservaDataLocacao.setBounds(90, 154, 95, 14);
		add(lblReservaDataLocacao);
		
		DatePicker ReservaDataLocacaoVeiculo = new DatePicker();
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataLocacaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataLocacaoVeiculo.setBounds(90, 168, 182, 25);
		add(ReservaDataLocacaoVeiculo);
		
		JLabel lblReservaLocacaoDataDevolucao = new JLabel("Data da Devolução");
		lblReservaLocacaoDataDevolucao.setBounds(298, 154, 105, 14);
		add(lblReservaLocacaoDataDevolucao);
		
		DatePicker ReservaDataDevolucaoVeiculo = new DatePicker();
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataDevolucaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataDevolucaoVeiculo.setBounds(298, 168, 182, 25);
		add(ReservaDataDevolucaoVeiculo);
		
		JLabel lblReservaLocacaoKmAtual = new JLabel("KM Atual");
		lblReservaLocacaoKmAtual.setBounds(90, 219, 57, 14);
		add(lblReservaLocacaoKmAtual);
		
		JFormattedTextField txtReservaVeiculoKmAtual = new JFormattedTextField();
		txtReservaVeiculoKmAtual.setBounds(90, 233, 182, 25);
		add(txtReservaVeiculoKmAtual);
		
		JLabel lblReservaLocacaoKmDevolucao = new JLabel("KM Devolução");
		lblReservaLocacaoKmDevolucao.setBounds(298, 219, 105, 14);
		add(lblReservaLocacaoKmDevolucao);
		
		JFormattedTextField txtReservaVeiculoKmDevolucao = new JFormattedTextField();
		txtReservaVeiculoKmDevolucao.setBounds(298, 233, 182, 25);
		add(txtReservaVeiculoKmDevolucao);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 287, 464, 2);
		add(separator);
		
		JButton btnSalvarReserva = new JButton(" Salvar");
		btnSalvarReserva.setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Salvar.png")));
		btnSalvarReserva.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarReserva.setForeground(new Color(0, 0, 139));
		btnSalvarReserva.setBackground(new Color(240, 248, 255));
		btnSalvarReserva.setBounds(144, 325, 111, 41);
		add(btnSalvarReserva);
		
		JButton btnEditarVeiculo = new JButton("Editar");
		btnEditarVeiculo.setBounds(283, 325, 111, 41);
		add(btnEditarVeiculo);
		
		JComboBox cbCliente = new JComboBox();
		cbCliente.setBounds(90, 106, 182, 25);
		add(cbCliente);
		
		JComboBox cbVeiculo = new JComboBox();
		cbVeiculo.setBounds(298, 106, 182, 25);
		add(cbVeiculo);
		
		

	}
}
