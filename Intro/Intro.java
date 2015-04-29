package Intro;


import java.net.URL;

import javax.swing.*;

public class Intro extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Intro(){
		JLabel immagine = new JLabel();
		URL url = ClassLoader.getSystemResource("Immagini/Iniziale.jpg");
		immagine.setIcon(new ImageIcon(url));
		this.add(immagine);
		this.setSize(800,533);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
