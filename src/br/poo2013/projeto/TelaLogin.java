package br.poo2013.projeto;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaLogin extends JPanel {
	JTextField texto = new JTextField(20);
	JTextField texto_senha = new JTextField(10);

	String texto2 = "";
	JLabel texto_label = new JLabel("Login: ");
	JLabel texto_senha_label = new JLabel("Senha: ");

	public TelaLogin() {

		JButton botao = new JButton();
		JButton voltar = new JButton();

		voltar.setText("Voltar");
		botao.setText("Login");

		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.out.println("Login: " + texto.getText());
				System.out.println("Senha: " + texto_senha.getText());
				UsuarioDAO userDAO = Tela.getUserDAO();

				try {
					Tela.setUser(userDAO.efetuaLogin((String) texto.getText(),
							(String) texto_senha.getText()));
					JOptionPane.showMessageDialog(null,
							"\"" + Tela.getUser().getLogin() + "\""
									+ " logado(a) com sucesso!", "Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
					Tela.GetInstance().TrocaPainel(new TelaInicial());
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null,
							"ERRO! Usuário não cadastrado!", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tela.GetInstance().TrocaPainel(new TelaInicial());
			}
		});

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		this.add(texto_label, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 6;

		c.gridx = 4;
		c.gridy = 0;
		this.add(texto, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		this.add(texto_senha_label, c);

		c.gridx = 4;
		c.gridy = 1;
		this.add(texto_senha, c);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.insets = new Insets(20, 5, 0, 0);
		this.add(botao, c);

		c.gridx = 3;
		c.gridy = 5;
		c.insets = new Insets(20, 5, 0, 0);
		c.gridwidth = 2;
		this.add(voltar, c);

	}

}
