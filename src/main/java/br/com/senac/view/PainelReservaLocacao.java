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
		lblReservaLocacaoCliente.setBounds(55, 90, 46, 14);
		add(lblReservaLocacaoCliente);
		
		JLabel lblReservaLocacaoVeiculo = new JLabel("Veículo");
		lblReservaLocacaoVeiculo.setBounds(263, 90, 46, 14);
		add(lblReservaLocacaoVeiculo);
		
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
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
		ReservaDataLocacaoVeiculo.getComponentToggleCalendarButton().setText("");
		ReservaDataLocacaoVeiculo.getComponentDateTextField().setEditable(false);
		ReservaDataLocacaoVeiculo.setBounds(55, 168, 182, 25);
		add(ReservaDataLocacaoVeiculo);
		
		JLabel lblReservaLocacaoDataDevolucao = new JLabel("Data da Devolução");
		lblReservaLocacaoDataDevolucao.setBounds(263, 154, 105, 14);
		add(lblReservaLocacaoDataDevolucao);
		
		DatePicker ReservaDataDevolucaoVeiculo = new DatePicker();
		ReservaDataDevolucaoVeiculo.getComponentToggleCalendarButton().setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Calendario16pix.png")));
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(66, 287, 473, 2);
		add(separator);
		
		JButton btnSalvarReserva = new JButton("Reservar");
		btnSalvarReserva.setIcon(new ImageIcon(PainelReservaLocacao.class.getResource("/icons/Salvar.png")));
		btnSalvarReserva.setHorizontalAlignment(SwingConstants.LEFT);
		btnSalvarReserva.setForeground(new Color(0, 0, 139));
		btnSalvarReserva.setBackground(new Color(240, 248, 255));
		btnSalvarReserva.setBounds(127, 340, 129, 41);
		add(btnSalvarReserva);
		
		JButton btnEditarVeiculo = new JButton("Devolver");
		btnEditarVeiculo.setBounds(284, 340, 111, 41);
		add(btnEditarVeiculo);
		
		JComboBox cbCliente = new JComboBox();
		cbCliente.setBounds(55, 106, 182, 20);
		add(cbCliente);
		
		JComboBox cbVeiculo = new JComboBox();
		cbVeiculo.setBounds(263, 106, 182, 20);
		add(cbVeiculo);
		
		

	}
}
