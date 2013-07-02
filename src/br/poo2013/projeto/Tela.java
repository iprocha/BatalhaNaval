package br.poo2013.projeto;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Tela extends JFrame implements ActionListener {

	private static Tela tela;
	private static UsuarioDAO userDAO;
	private static UsuarioModel user;
	private static Controller controller; 
	

	public static UsuarioModel getUser() {
		return user;
	}

	public static void setUser(UsuarioModel user) {
		Tela.user = user;
	}

	public static UsuarioDAO getUserDAO() {
		return userDAO;
	}

	public static void setUserDAO() {
		Tela.userDAO = new UsuarioDAO();
	}

	static public Tela GetInstance() {
		if (tela == null)
			tela = new Tela();
		return tela;
	}

	public void TrocaPainel(JPanel painel) {
		Tela.GetInstance().remove(Tela.GetInstance().getContentPane());
		Tela.GetInstance().setContentPane(painel);
		Tela.GetInstance().setVisible(true);

	}

	private Tela() {
		// cria barra de menu
		JMenuBar menuBar = new JMenuBar();

		// criar menus
		JMenu mCadastro = new JMenu("Cadastro");
		JMenu mPlay = new JMenu("Jogo");

		// sub-itens do menu cadastro
		JMenuItem mLogin = new JMenuItem("Login");
		mLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Tela.GetInstance().TrocaPainel(new TelaLogin());
			}
		});
		mCadastro.add(mLogin);
		JMenuItem mCriar = new JMenuItem("Cadastrar");
		mCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tela.GetInstance().TrocaPainel(new TelaCadastro());
			}
		});
		mCadastro.add(mCriar);
		JMenuItem mAtualizar = new JMenuItem("Mudar Senha");
		// ao clicar em Atualizar ir para TelaUpdate
		mAtualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 Tela.GetInstance().TrocaPainel(new TelaUpdate());
			}
		});
		mCadastro.add(mAtualizar);
		menuBar.add(mCadastro);
		// sub-itens do menu Jogo
		JMenuItem mJogar = new JMenuItem("Jogar");
		mJogar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Tela.GetInstance().TrocaPainel(new Controller());
			}
		});
		mPlay.add(mJogar);
		JMenuItem mRank = new JMenuItem("Rank");
		mRank.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Tela.GetInstance().TrocaPainel(new TelaRank());
			}
		});
		mPlay.add(mRank);
		menuBar.add(mPlay);

		this.setJMenuBar(menuBar);

		// Dimension tamanho_min = new Dimension(578, 384);
		Dimension tamanho_min = new Dimension(898, 576);
		Dimension tamanho_max = new Dimension(1024, 768); // dimensoes da imagem
															// de fundo
		this.setTitle("Batalha Naval");
		this.add(new JLabel("Jogo de Batalha Naval"));
		this.setMinimumSize(tamanho_min); 
		this.setMaximumSize(tamanho_max);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		setUserDAO();
		try {
			controller = new Controller();
			controller.start();
			userDAO.conectarDB();
			Tela.GetInstance().TrocaPainel(new TelaInicial());
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar no BD",
					"Erro", JOptionPane.ERROR_MESSAGE);
			ex.printStackTrace();
		}
		
	}

	public void actionPerformed(ActionEvent e) {
		// // CardLayout cl = (CardLayout) painelCard.getLayout();
		// if (e.getSource() == botao1) {
		// // cl.show(painelCard, "p1");
		// TrocaPainel(new TelaLogin());
		// }
		// if (e.getSource() == botao2) {
		// // cl.show(painelCard, "p2");
		// }
		
	}
}
