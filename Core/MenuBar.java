package Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import Musica.GestoreMusica;

public class MenuBar extends JMenuBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Memory istanzaOggetto=null;
	JMenu Partita=null;
	JMenu lingua=null;
	JMenuItem NuovaPartita=null;
	JMenuItem Esci=null;
	JMenuItem Italiano=null;
	JMenuItem Inglese=null;

	public MenuBar(Memory istanza){
		
		super();
		
		istanzaOggetto=istanza;
		
		ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",istanzaOggetto.lingua);
	    String stringa= messages.getString("Partita");
	      	       
		
		Partita= new JMenu(stringa);
			
		stringa=messages.getString("NuovaPartita");
				
			NuovaPartita = new JMenuItem(stringa);
					  NuovaPartita.addActionListener( new NewActionListener());
			
		stringa=messages.getString("Esci");
			
			Esci = new JMenuItem(stringa);
				Esci.addActionListener(new ExitActionListener());
			
		Partita.add(NuovaPartita);
		Partita.addSeparator();
		Partita.add(Esci);
		
		stringa=messages.getString("Lingua");
		
		lingua= new JMenu(stringa);
	
		stringa=messages.getString("Italiano");
			Italiano = new JMenuItem(stringa);
			Italiano.addActionListener(new ITActionListener(this));
		
		stringa=messages.getString("Inglese");
			
			Inglese = new JMenuItem(stringa);
			Inglese.addActionListener(new USActionListener(this));
			
		lingua.add(Italiano);
		lingua.add(Inglese);
		
		
		this.add(Partita);
		this.add(lingua);
		
			
	}
	
	private class ExitActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
    }
	
	private class ITActionListener implements ActionListener {
		MenuBar m=null;
		
		public ITActionListener(MenuBar m){
			super();
			this.m=m;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",istanzaOggetto.lingua);
			String eliminare= (messages.getString("TitoloVittoria"))+"\n"+(messages.getString("Vittoria"));
			istanzaOggetto.lingua=Locale.ITALY;
			messages= ResourceBundle.getBundle("MessagesBundle",istanzaOggetto.lingua);
			String stringa= messages.getString("Partita");
			m.Partita.setText(stringa);
			stringa= messages.getString("Lingua");
			m.lingua.setText(stringa);
			stringa= messages.getString("NuovaPartita");
			m.NuovaPartita.setText(stringa);
			stringa= messages.getString("Esci");
			m.Esci.setText(stringa);
			stringa= messages.getString("Italiano");
			m.Italiano.setText(stringa);
			stringa= messages.getString("Inglese");
			m.Inglese.setText(stringa);
			GestoreMusica g=(GestoreMusica) istanzaOggetto.gestoremusica;
			stringa= messages.getString("Play");
			g.play.setToolTipText(stringa);
			stringa= messages.getString("Stop");
			g.stop.setToolTipText(stringa);
			stringa= messages.getString("scelta");
			g.scelta.setToolTipText(stringa);
			String punteggio=istanzaOggetto.segnapunti.getText();
			stringa=messages.getString("Libretto");
			String dopo=punteggio.substring(22);
			punteggio=stringa+dopo;
			if(punteggio.endsWith(eliminare)==true){
				int lettere=punteggio.length();
				lettere-=eliminare.length();
				dopo=punteggio.substring(0,lettere);
				stringa= (messages.getString("TitoloVittoria"))+"\n"+(messages.getString("Vittoria"));
				punteggio=dopo+stringa;
			}
			istanzaOggetto.segnapunti.setText(punteggio);
			istanzaOggetto.punti=punteggio;
		}
    }
	
	
	private class USActionListener implements ActionListener {
		MenuBar m=null;
		
		public USActionListener(MenuBar m){
			super();
			this.m=m;
		}
		
		public void actionPerformed(ActionEvent arg0) {
			ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",istanzaOggetto.lingua);
			String eliminare= (messages.getString("TitoloVittoria"))+"\n"+(messages.getString("Vittoria"));
			istanzaOggetto.lingua=Locale.US;
			messages= ResourceBundle.getBundle("MessagesBundle",istanzaOggetto.lingua);
			String stringa= messages.getString("Partita");
			m.Partita.setText(stringa);
			stringa= messages.getString("Lingua");
			m.lingua.setText(stringa);
			stringa= messages.getString("NuovaPartita");
			m.NuovaPartita.setText(stringa);
			stringa= messages.getString("Esci");
			m.Esci.setText(stringa);
			stringa= messages.getString("Italiano");
			m.Italiano.setText(stringa);
			stringa= messages.getString("Inglese");
			m.Inglese.setText(stringa);
			GestoreMusica g=(GestoreMusica) istanzaOggetto.gestoremusica;
			stringa= messages.getString("Play");
			g.play.setToolTipText(stringa);
			stringa= messages.getString("Stop");
			g.stop.setToolTipText(stringa);
			stringa= messages.getString("scelta");
			g.scelta.setToolTipText(stringa);
			String punteggio=istanzaOggetto.segnapunti.getText();
			stringa=messages.getString("Libretto");
			String dopo=punteggio.substring(26);
			punteggio=stringa+dopo;
			if(punteggio.endsWith(eliminare)==true){
				int lettere=punteggio.length();
				lettere-=eliminare.length();
				dopo=punteggio.substring(0,lettere);
				stringa= (messages.getString("TitoloVittoria"))+"\n"+(messages.getString("Vittoria"));
				punteggio=dopo+stringa;
			}
			istanzaOggetto.segnapunti.setText(punteggio);
			istanzaOggetto.punti=punteggio;
		}
    }
	
	private class NewActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			try {
				istanzaOggetto.RidisegnaAreaGioco();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
    }
	
	
	
	


}
