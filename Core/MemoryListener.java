package Core;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import Animate.Animate;

class MemoryListener implements ActionListener
{
    private CharButton prima = null;
    private CharButton seconda = null;
    private int Coppie = 0;
    private int voti[]={29,30,0,18,19,20,21,22,23,24,25,26,0,18,19,20,21,22,23,24,25,26,27,28};
    private String esami[]={"Lp1 ","MD  ","Algo","Arc ","PD  ","AN  ","Reti","TSW "};
    String punteggi=null;

    public MemoryListener()
    {
        super();
        
    }

    
    public void ResettaCoppie(){
    	Coppie=0;
    }
  
    public void actionPerformed(ActionEvent e)
    {
        CharButton mem2 = (CharButton) e.getSource();
      
        if (prima == null){
            prima = mem2;
            mem2.setEnabled(false);
            mem2.uncover();
        }
        else{ 
        	if (seconda == null){
        		mem2.setEnabled(false);
        		mem2.uncover();
        		seconda = mem2;

        		if (prima.getChar().equals(seconda.getChar())){
        			
        			
        			int indice=(int) (Math.random()*23);
        			if(indice==0){
        				indice=1;
        			}
        			int voto= voti[indice];
        			int prof=Integer.parseInt(prima.getChar())-1;
        			String esame=esami[prof];

        			Memory m=(Memory) prima.getParent().getParent().getParent().getParent().getParent();
        			
        			JFrame prova = new JFrame();
        			Animate s = new Animate(indice,m);
        			Thread p= new Thread(s);
        			
        			prova.add(s);
        			prova.setSize(600,620);
        			prova.setVisible(true);
        			prova.setLocationRelativeTo(null);
        			
        			m.setEnabled(false);
        			
        			p.start();
        			 
        			
        			if(voto==0){
        				prima.setEnabled(true);
        				seconda.setEnabled(true);
        				prima.cover();
        				seconda.cover();
        				
        			}
        			else{
        				Coppie++;
        				m.ModificaSegnapunti(esame+"\t\t\t\t\t\t"+voto+"\n");
        			}
        			
        			prima = null;
        			seconda = null;

        			if (Coppie == 8){
        				ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",m.lingua);
        				String Vittoria= messages.getString("Vittoria");
        				String TitoloVittoria= messages.getString("TitoloVittoria");
        				m.ModificaSegnapunti("\n\n\n");
        				m.ModificaSegnapunti(TitoloVittoria+"\n"+Vittoria);
        				m.t.stop();
        			}
        		}
            else{
            	
            }
        }
        else{
        	mem2.setEnabled(false);
            mem2.uncover();
            prima.cover();
            prima.setEnabled(true);
            prima = mem2;
            seconda.cover();
            seconda.setEnabled(true);
            seconda = null;
        }
        }
    
    }
    
    
}