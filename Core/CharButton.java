package Core;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;


class CharButton extends JButton
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String indice;

    CharButton(String lab){
        super(lab);
        indice = lab;
        setText("");
    }

    void uncover(){
    	URL url=ClassLoader.getSystemResource("Immagini/Carta"+indice+".jpg");
    	this.setIcon(new ImageIcon(url));
    	this.setDisabledIcon(new ImageIcon(url));
    }

    void cover(){
    	URL url=ClassLoader.getSystemResource("Immagini/retro.jpg");
        this.setIcon(new ImageIcon(url));
        
    }

    String getChar()
    {
        return indice;
    }
}
