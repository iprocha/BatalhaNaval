package br.poo2013.projeto;

import java.awt.Button;
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

public class TelaCadastro extends JPanel {
	JTextField texto_login = new JTextField(20);
	JTextField texto_senha = new JTextField(10);
	JTextField texto_senha_confirma = new JTextField(10);

	JLabel texto_login_label = new JLabel("Login: ");
	JLabel texto_senha_label = new JLabel("Senha: ");
	JLabel texto_senha_conf_label = new JLabel("Repita a Senha: ");

	public TelaCadastro() {
		JButton botao = new JButton();
		JButton voltar = new JButton();

		botao.setText("Cadastrar");
		voltar.setText("Voltar");

		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioModel user = new UsuarioModel(texto_login.getText(),
						texto_senha.getText());
				UsuarioDAO userDAO = Tela.getUserDAO();

					try {
						verificaCamposCadastro(user.getLogin(),
								user.getSenha(),
								(String) texto_senha_confirma.getText());

						System.out.println("Login: " + user.getLogin());
						System.out.println("Senha: " + user.getSenha());
						try{
							userDAO.cadastrar(user);
							JOptionPane.showMessageDialog(null,
									"\"" + user.getLogin() + "\""
											+ " foi cadastrado(a)", "Sucesso",
									JOptionPane.INFORMATION_MESSAGE);
							Tela.GetInstance().TrocaPainel(new TelaInicial());
						} catch (SQLException erro_sql){
							JOptionPane.showMessageDialog(null, "Não foi possível inserir",
									"Erro", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception erro) {
						JOptionPane.showMessageDialog(null, erro.getMessage(),
								"Erro", JOptionPane.ERROR_MESSAGE);
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
		this.add(texto_login_label, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 6;

		c.gridx = 4;
		c.gridy = 0;
		this.add(texto_login, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 1;
		this.add(texto_senha_label, c);

		c.gridx = 4;
		c.gridy = 1;
		this.add(texto_senha, c);

		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 2;
		this.add(texto_senha_conf_label, c);

		c.gridx = 4;
		c.gridy = 2;
		this.add(texto_senha_confirma, c);

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

	private void verificaCamposCadastro(String login, String senha,
			String senha_confirma) throws Exception {
		char[] vlogin = login.toCharArray();
		char[] vsenha = senha.toCharArray();
		char[] vsenha_confirma = senha_confirma.toCharArray();
		if ((vlogin.length == 0) || (vlogin.length > 20)) {
			throw new Exception(
					"O campo \"Login\" deve ser preenchido com até 20 caracteres.");
		}
		if ((vsenha.length == 0) || (vsenha.length > 20)) {
			throw new Exception(
					"O campo \"Senha\" deve ser preenchido com até 10 caracteres.");
		}
		if ((vsenha_confirma.length == 0) || (vsenha_confirma.length > 20)) {
			throw new Exception(
					"O campo \"Repita a Senha\" deve ser preenchido com até 10 caracteres.");
		}
		if (!senha.equals(senha_confirma)) {
			throw new Exception(
					"O campo \"Senha\" deve ser igual ao campo \"Repita a Senha\".");
		}
	}
}
