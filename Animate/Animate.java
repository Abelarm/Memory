package Animate;

import java.awt.*;
import java.net.URL;

import javax.swing.*;

 @SuppressWarnings("serial")
public class Animate extends JPanel implements Runnable {
	 private ImageIcon imagearray[];
	 private int delay=80, totalFrames=24, currentFrame=0,voto=0;
	 private JFrame memory=null;
	 URL url=null;
	 
	 public Animate(int m,JFrame memory){
		 this.memory=memory;
		 imagearray=new ImageIcon[totalFrames];
		 voto=m;
		 for(int i=0;i<imagearray.length;i++){
			 url=ClassLoader.getSystemResource("Immagini/"+i+".JPG");
			 imagearray[i]=new ImageIcon(url);
		 }
	 }
  
	 public void paintComponent (Graphics g){
		 super.paintComponent(g);
		 if(currentFrame>=imagearray.length){
			 currentFrame=0;
			}
		 currentFrame++;
		 try{
		 imagearray[currentFrame].paintIcon(this,g,0,0);}
		 catch(Exception e){}
	 }

	 
	 public void anima(){
		voto+=(totalFrames-1);
		 for(int j=0;j<voto;j++){
			 try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {}
			 repaint();
		 }
	 }

	@Override
	public void run() {
		this.anima();
		JFrame prova=(JFrame) this.getParent().getParent().getParent().getParent();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prova.setVisible(false);
		this.memory.setEnabled(true);
	}
}
