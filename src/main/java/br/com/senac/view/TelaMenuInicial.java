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
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;

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
		setBounds(100, 100, 638, 495);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuClientes = new JMenu("Clientes");
		menuClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/User.png")));
		menuBar.add(menuClientes);
		
		JMenuItem menuItemCadastrarClientes = new JMenuItem("Cadastrar");
		menuItemCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelCadastroCliente painelCliente = new PainelCadastroCliente();
				setContentPane(painelCliente);
				revalidate();
			}
		});
		menuItemCadastrarClientes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		menuItemCadastrarClientes.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/addUser.png")));
		menuClientes.add(menuItemCadastrarClientes);
		
		JMenuItem menuItemRelatorioClientes = new JMenuItem("Relatórios");
		menuItemRelatorioClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PainelRelatorioCliente painelCliente = new PainelRelatorioCliente();
				setContentPane(painelCliente);
				revalidate();
			}
		});
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
		menuItemReservaLocacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		menuItemReservaLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelReservaLocacao painelReserva = new PainelReservaLocacao();
				setContentPane(painelReserva);
				revalidate();
			
			}
		});
		menuItemReservaLocacao.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Reserva.png")));
		menuLocacao.add(menuItemReservaLocacao);
		
		JMenuItem menuItemRelatorioLocacao = new JMenuItem("Relatórios");
		menuItemRelatorioLocacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelRelatorioLocacao painelReserva = new PainelRelatorioLocacao();
				setContentPane(painelReserva);
				revalidate();
			}
		});
		menuItemRelatorioLocacao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F9, 0));
		menuItemRelatorioLocacao.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Relatorio.png")));
		menuLocacao.add(menuItemRelatorioLocacao);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 11, 602, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenuFloricar = new JLabel("FLORICAR\r ");
		lblMenuFloricar.setToolTipText("");
		lblMenuFloricar.setFont(new Font("Castellar", Font.BOLD, 18));
		lblMenuFloricar.setBounds(10, 11, 132, 41);
		panel.add(lblMenuFloricar);
		
		JLabel lblImagemVeiculoMenu = new JLabel("");
		lblImagemVeiculoMenu.setIcon(new ImageIcon(TelaMenuInicial.class.getResource("/icons/Veiculo512pix.png")));
		lblImagemVeiculoMenu.setBounds(79, 25, 513, 390);
		panel.add(lblImagemVeiculoMenu);
		
		JLabel lblMenuLocadoraDeVeiculos = new JLabel("LOCADORA DE VEÍCULOS");
		lblMenuLocadoraDeVeiculos.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
		lblMenuLocadoraDeVeiculos.setBounds(36, 38, 189, 14);
		panel.add(lblMenuLocadoraDeVeiculos);
		
		JLabel lblFloricarEndMenu = new JLabel("Florianópolis | Mauro Ramos, nº 555, Centro - (48) 9999-9999");
		lblFloricarEndMenu.setFont(new Font("Arial Narrow", Font.PLAIN, 11));
		lblFloricarEndMenu.setBounds(10, 375, 342, 14);
		panel.add(lblFloricarEndMenu);
	}

}
