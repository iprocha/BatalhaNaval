package br.poo2013.projeto;

import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class TelaUpdate extends JPanel{
	JTextField texto_senha = new JTextField(10);
	JTextField texto_senha_confirma = new JTextField(10);
	JLabel texto_senha_label = new JLabel("Nova Senha: ");
	JLabel texto_senha_conf_label = new JLabel("Repita a Nova Senha: ");
	
	public TelaUpdate(){
		JButton botao = new JButton();
		JButton voltar = new JButton();
		botao.setText("Mudar");
		voltar.setText("Voltar");
		
		
		if(!Tela.getUserDAO().isConnected()){
			JOptionPane.showMessageDialog(null, "Usuário não realizou o login!",
					"Erro", JOptionPane.ERROR_MESSAGE);
			Tela.GetInstance().TrocaPainel(new TelaInicial());
		}
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						verificaCamposUpdate(texto_senha.getText(), (String) texto_senha_confirma.getText());
						try{
							Tela.getUserDAO().alteraSenha(texto_senha.getText());
							Tela.getUser().setSenha(texto_senha.getText());
							JOptionPane.showMessageDialog(null,
									"Alteração realizada com sucesso!", "Sucesso",
									JOptionPane.INFORMATION_MESSAGE);
							Tela.GetInstance().TrocaPainel(new TelaInicial());
						} catch (SQLException erro_sql){
							JOptionPane.showMessageDialog(null, "Não foi possível alterar a senha",
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

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridwidth = 6;

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
	
	private void verificaCamposUpdate(String senha,
			String senha_confirma) throws Exception {
		char[] vsenha = senha.toCharArray();
		char[] vsenha_confirma = senha_confirma.toCharArray();
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
