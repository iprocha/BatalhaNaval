package br.poo2013.projeto;

import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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

public class TelaCadastro extends JPanel {
	JTextField texto_login = new JTextField(20);
	JTextField texto_senha = new JTextField(10);
	
	JLabel texto_login_label = new JLabel("Login: ");
	JLabel texto_senha_label = new JLabel("Senha: ");
	
	public TelaCadastro(){
		JButton botao = new JButton();
		JButton voltar = new JButton();
		
		botao.setText("Cadastrar");
		voltar.setText("Voltar");
		
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioModel user = new UsuarioModel(texto_login.getText(), texto_senha.getText());
				UsuarioDAO userDAO = new UsuarioDAO();
				
				System.out.println("Login: "+user.getLogin());
				System.out.println("Senha: "+user.getLogin());
				userDAO.cadastrar(user);
				
				
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
