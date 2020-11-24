package br.com.senac.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class PainelSobre extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelSobre() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PainelSobre.class.getResource("/icons/Carro48pix.png")));
		lblNewLabel.setBounds(10, 11, 56, 48);
		add(lblNewLabel);
		
		JLabel lblSobre = new JLabel("FLORICAR LOCADORA DE VEICULOS");
		lblSobre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSobre.setBounds(64, 29, 251, 14);
		add(lblSobre);
		
		JLabel lblSobreVersão = new JLabel("Versão 0.1.1 ");
		lblSobreVersão.setFont(new Font("Arial", Font.ITALIC, 10));
		lblSobreVersão.setBounds(471, 384, 93, 14);
		add(lblSobreVersão);
		
		JLabel lblSobreAutoresLucas = new JLabel("Lucas Pereira Mendes");
		lblSobreAutoresLucas.setFont(new Font("Arial", Font.ITALIC, 11));
		lblSobreAutoresLucas.setBounds(87, 142, 154, 14);
		add(lblSobreAutoresLucas);
		
		JLabel lblSobreAutoresLeo = new JLabel("Leonardo Simone");
		lblSobreAutoresLeo.setFont(new Font("Arial", Font.ITALIC, 11));
		lblSobreAutoresLeo.setBounds(87, 167, 154, 14);
		add(lblSobreAutoresLeo);
		
		JLabel lblSobreAplicacao = new JLabel("Projeto desenvolvido pela equipe:");
		lblSobreAplicacao.setFont(new Font("Arial", Font.ITALIC, 11));
		lblSobreAplicacao.setBounds(87, 117, 269, 14);
		add(lblSobreAplicacao);
		
		JLabel lblSobreEndereco = new JLabel("Florianópolis | Mauro Ramos, nº 555, Centro - (48) 9999-9999");
		lblSobreEndereco.setFont(new Font("Arial", Font.ITALIC, 10));
		lblSobreEndereco.setBounds(10, 384, 359, 14);
		add(lblSobreEndereco);
	}
}
