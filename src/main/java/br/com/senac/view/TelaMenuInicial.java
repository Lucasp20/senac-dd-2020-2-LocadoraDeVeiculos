package br.com.senac.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaMenuInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMenuInicial frame = new TelaMenuInicial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaMenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuVeiculo = new JMenu("Veículo");
		menuBar.add(menuVeiculo);
		
		JMenuItem MenuItemCadastroVeiculo = new JMenuItem("Cadastrar");
		MenuItemCadastroVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelCadastroVeiculo painelVeiculo = null;
				try {
					painelVeiculo = new PainelCadastroVeiculo();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				setContentPane(painelVeiculo);
				revalidate();
			}
		});
		menuVeiculo.add(MenuItemCadastroVeiculo);
		
		JMenu mnNewMenu_1 = new JMenu("New menu");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
