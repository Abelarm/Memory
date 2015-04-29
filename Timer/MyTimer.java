package Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Core.Memory;

public class MyTimer implements ActionListener{
	
	Memory m= null;
	int volte=69;
	
	public MyTimer(Memory gioco){
		m=gioco;
	}
	
public void actionPerformed(ActionEvent event){ 
	if(volte==0){
	ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",m.lingua);
	String temposcaduto= messages.getString("temposcaduto");	
	m.tempo.setText(temposcaduto);
	Timer t=(Timer)event.getSource();
	t.stop();
	JPanel perso= new JPanel();
	JLabel label= new JLabel();
	if(m.lingua==Locale.ITALY){
		URL url = ClassLoader.getSystemResource("Immagini/crisi.png");
		label.setIcon(new ImageIcon(url));
		}
	else{
		URL url= ClassLoader.getSystemResource("Immagini/crisi2.png");
		label.setIcon(new ImageIcon(url));
	}
	perso.add(label);
	m.remove(m.buttonPanel);
	m.add(perso,BorderLayout.CENTER);
	m.setVisible(true); 
	}
	else{
		ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",m.lingua);
		String tempo= messages.getString("tempo");
		m.tempo.setText(tempo+volte+" sec.");
		volte--;
		if(volte<10){
			m.tempo.setForeground(Color.red);
		}
	}
	}
	
}
