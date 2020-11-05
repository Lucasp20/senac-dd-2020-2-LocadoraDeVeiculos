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
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

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
		
		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/User.png")));
		menuBar.add(menuClientes);
		
		JMenuItem menuItemCadastrarClientes = new JMenuItem("Cadastrar");
		menuItemCadastrarClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuItemCadastrarClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/addUser.png")));
		menuClientes.add(menuItemCadastrarClientes);
		
		JMenuItem menuItemRelatorioClientes = new JMenuItem("Relatórios");
		menuItemRelatorioClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		menuItemRelatorioClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Relatorio.png")));
		menuClientes.add(menuItemRelatorioClientes);
		
		JMenu menuVeiculo = new JMenu("Veículos");
		menuVeiculo.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Veiculo.png")));
		menuBar.add(menuVeiculo);
		
		JMenuItem MenuItemCadastroVeiculo = new JMenuItem("Cadastrar");
		MenuItemCadastroVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		MenuItemCadastroVeiculo.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/+Carro.png")));
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
		
		JMenuItem menuItemRelatorioVeiculo = new JMenuItem("Relatórios");
		menuItemRelatorioVeiculo.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Relatorio.png")));
		menuItemRelatorioVeiculo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		menuItemRelatorioVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelRelatorioVeiculo painelVeiculo = new PainelRelatorioVeiculo();
				setContentPane(painelVeiculo);
				revalidate();
			}
		});
		menuVeiculo.add(menuItemRelatorioVeiculo);
		
		JMenu menuLocacao = new JMenu("Locação");
		menuLocacao.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/LocalCarro.png")));
		menuBar.add(menuLocacao);
		
		JMenuItem menuItemReservaLocacao = new JMenuItem("Reservas");
		menuItemReservaLocacao.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Reserva.png")));
		menuLocacao.add(menuItemReservaLocacao);
		
		JMenuItem menuItemRelatorioLocacao = new JMenuItem("Relatórios");
		menuItemRelatorioLocacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		menuItemRelatorioLocacao.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Relatorio.png")));
		menuLocacao.add(menuItemRelatorioLocacao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
