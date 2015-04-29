package Core;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.*;

/**
 * A Java text area (JTextArea) with a background image.
 * You can use this class to add a watermark image to a Java text area,
 * or any other background image you like.
 * Alvin Alexander, http://devdaily.com
 */
public class Segnapunti extends JTextPane
{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final BufferedImage bufferedImage;
  private final TexturePaint texturePaint;

  /**
   * Supply an image file as an input field.
   * TODO - It would be a good idea to accept an image url as a separate constructor.
   */
  public Segnapunti(URL url) throws IOException
  {
    super();
    File file;
    try{
    	file=new File(url.toURI());
    }catch(URISyntaxException e){
    	file= new File(url.getPath());
    }
    
    bufferedImage = ImageIO.read(file);
    Rectangle rect = new Rectangle(0, 0, bufferedImage.getWidth(null), bufferedImage.getHeight(null));
    texturePaint = new TexturePaint(bufferedImage, rect);
    setOpaque(false);
    this.setEditable(false);
  }

  /**
   * Override the painComponent method to do our image drawing.
   */
  public void paintComponent(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    g2.setPaint(texturePaint);
    g.fillRect(0, 0, getWidth(), getHeight());
    super.paintComponent(g);
  }

}