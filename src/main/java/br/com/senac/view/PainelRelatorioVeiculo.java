package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class PainelRelatorioVeiculo extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PainelRelatorioVeiculo() {
		setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Placa", "New column", "Marca", "Modelo"
			}
		));
		table.setBounds(31, 77, 515, 259);
		add(table);

	}
}
