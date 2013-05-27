package br.poo2013.projeto;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;

public class Tela extends JFrame implements ActionListener {
	// // criamos um JFrame chamado 'janela'
	// JFrame janela = new JFrame();
	// // criamos um JPanel chamado painel1
	// JPanel painel1 = new JPanel();
	// // criamos um JPanel chamado painel2
	// JPanel painel2 = new JPanel();
	// // criamos um JLabel chamado rotulo1
	// JLabel rotulo1 = new JLabel("Painel 1", JLabel.CENTER);
	// // criamos um JLabel chamado rotulo2
	// JLabel rotulo2 = new JLabel("Painel 2", JLabel.CENTER);
	// // criamos dois botoes e um painel para alternar entre os paineis
	// JPanel painelSelecao = new JPanel();
	// JButton botao1 = new JButton("Login");
	// JButton botao2 = new JButton("Join");
	// JButton botao3 = new JButton("Play");
	// JButton botao4 = new JButton("Rank");
	// // criamos o painelCard que será gerenciado pelo CardLayout
	// JPanel painelCard = new JPanel();

	private static Tela tela;

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
		// // definimos o título da janela
		// janela.setTitle("Exemplo de um CardLayout");
		// // definimos a largura e a altura da janela
		// janela.setSize(800, 600);
		// // define a posição da janela na tela
		// janela.setLocation(150, 150);
		// // define que ao fechar a janela, encerre a aplicação
		// janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// // definimos o layout da janela
		// janela.setLayout(new BorderLayout());
		// // definimos o painelselecao com o GridLayout e incluimos os botoes
		// painelSelecao.setLayout(new GridLayout(1, 2));
		// painelSelecao.add(botao1);
		// painelSelecao.add(botao2);
		// painelSelecao.add(botao3);
		// painelSelecao.add(botao4);
		// // adicionamos os rotulos a seus respectivos paineis
		// painel1.add(rotulo1);
		// painel2.add(rotulo2);
		// // definimos o layout do painelCard
		// painelCard.setLayout(new CardLayout());
		// // adicionamos os paineis quem contém os rotulos ao painelCard
		// painelCard.add(painel1, "p1");
		// painelCard.add(painel2, "p2");
		// // adicionamos os paineis à janela
		// janela.add("North", painelSelecao);
		// janela.add("Center", painelCard);
		// // registra os botoes para tratarmos os eventos gerados por eles
		// botao1.addActionListener(this);
		// botao2.addActionListener(this);
		// // mostramos a janela
		// janela.setVisible(true);
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
				// Tela.GetInstance().TrocaPainel(new TelaUpdate());
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
		Dimension tamanho_max = new Dimension(898, 576); // dimensoes da imagem
															// de fundo
		this.setTitle("Batalha Naval");
		this.add(new JLabel("Jogo de Batalha Naval"));
		this.setMinimumSize(tamanho_min); // ALTEREI AQUI
		this.setMaximumSize(tamanho_max);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]) {
		//new UsuarioDAO().conectarDB();
		Tela.GetInstance().TrocaPainel(new TelaInicial());
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
