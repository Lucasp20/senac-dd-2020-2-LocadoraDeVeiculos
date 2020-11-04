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
import javax.swing.ImageIcon;

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
		setTitle("Floricar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuVeiculo = new JMenu("Veículos");
		menuVeiculo.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Veiculo.png")));
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
		
		JMenuItem menuItemRelatorioVeiculo = new JMenuItem("Relatório");
		menuItemRelatorioVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelRelatorioVeiculo painelVeiculo = new PainelRelatorioVeiculo();
				setContentPane(painelVeiculo);
				revalidate();
			}
		});
		menuVeiculo.add(menuItemRelatorioVeiculo);
		
		JMenu menuLocacao = new JMenu("Locação");
		menuBar.add(menuLocacao);
		
		JMenuItem menuItemReservar = new JMenuItem("Reservar");
		menuLocacao.add(menuItemReservar);
		
		JMenuItem menuItemRelatorioLocacao = new JMenuItem("Relatório");
		menuLocacao.add(menuItemRelatorioLocacao);
		
		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/User.png")));
		menuBar.add(menuClientes);
		
		JMenuItem menuItemCadastroClientes = new JMenuItem("Cadastrar");
		menuClientes.add(menuItemCadastroClientes);
		
		JMenuItem menuItemRelatorioClientes = new JMenuItem("Relatório");
		menuClientes.add(menuItemRelatorioClientes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
