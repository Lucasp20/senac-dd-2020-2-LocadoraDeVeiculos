package br.com.senac.view;

import javax.swing.JPanel;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

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
		lblReservaLocacaoCliente.setBounds(55, 90, 46, 14);
		add(lblReservaLocacaoCliente);
		
		JFormattedTextField txtReservaCliente = new JFormattedTextField();
		txtReservaCliente.setBounds(55, 104, 182, 25);
		add(txtReservaCliente);
		
		JLabel lblReservaLocacaoVeiculo = new JLabel("Veículo");
		lblReservaLocacaoVeiculo.setBounds(263, 90, 46, 14);
		add(lblReservaLocacaoVeiculo);
		
		JFormattedTextField txtReservaVeiculo = new JFormattedTextField();
		txtReservaVeiculo.setBounds(263, 104, 182, 25);
		add(txtReservaVeiculo);
		
		JLabel lblReservaLocacaoSituacao = new JLabel("Situação");
		lblReservaLocacaoSituacao.setBounds(437, 217, 57, 14);
		add(lblReservaLocacaoSituacao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Locado", "Disponível"}));
		comboBox.setBounds(437, 231, 146, 24);
		add(comboBox);
		
		JLabel lblReservaDataLocacao = new JLabel("Data da Locação");
		lblReservaDataLocacao.setBounds(55, 154, 95, 14);
		add(lblReservaDataLocacao);
		
		DatePicker ReservaDataLocacaoVeiculo = new DatePicker();
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataLocacaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataLocacaoVeiculo.setBounds(55, 168, 182, 25);
		add(ReservaDataLocacaoVeiculo);
		
		JLabel lblReservaLocacaoDataDevolucao = new JLabel("Data da Devolução");
		lblReservaLocacaoDataDevolucao.setBounds(263, 154, 105, 14);
		add(lblReservaLocacaoDataDevolucao);
		
		DatePicker ReservaDataDevolucaoVeiculo = new DatePicker();
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataDevolucaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataDevolucaoVeiculo.setBounds(263, 168, 182, 25);
		add(ReservaDataDevolucaoVeiculo);
		
		JLabel lblReservaLocacaoKmAtual = new JLabel("KM Atual");
		lblReservaLocacaoKmAtual.setBounds(55, 217, 57, 14);
		add(lblReservaLocacaoKmAtual);
		
		JFormattedTextField txtReservaVeiculoKmAtual = new JFormattedTextField();
		txtReservaVeiculoKmAtual.setBounds(55, 231, 182, 25);
		add(txtReservaVeiculoKmAtual);
		
		JLabel lblReservaLocacaoKmDevolucao = new JLabel("KM Devolução");
		lblReservaLocacaoKmDevolucao.setBounds(263, 217, 105, 14);
		add(lblReservaLocacaoKmDevolucao);
		
		JFormattedTextField txtReservaVeiculoKmDevolucao = new JFormattedTextField();
		txtReservaVeiculoKmDevolucao.setBounds(263, 231, 164, 25);
		add(txtReservaVeiculoKmDevolucao);
		
		

	}
}
