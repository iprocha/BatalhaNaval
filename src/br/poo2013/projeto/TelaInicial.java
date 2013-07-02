package br.poo2013.projeto;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;


public class TelaInicial extends JPanel {

	//Image image;
	private BufferedImage image;

	public TelaInicial() {
		try {
			image = javax.imageio.ImageIO.read(new java.net.URL(getClass()
					.getResource("batalha_naval.jpg"), "batalha_naval.jpg"));
			//image = new ImageIcon("batalha_naval.jpg").getImage();
			//image = ImageIO.read(new File("batalha_naval.jpg"));
		} catch (Exception e) { /* handled in paintComponent() */
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		//if (image != null)
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
	}

}
