package Core;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleConstants.CharacterConstants;

import Intro.Intro;
import Musica.GestoreMusica;
import Timer.MyTimer;

@SuppressWarnings("serial")
public class Memory extends JFrame{
	
	public MemoryListener mem1=null;
	public JPanel buttonPanel=null;
	public JTextPane segnapunti=null;
	public JPanel gestoremusica=null;
	public String punti=null;
	public JPanel destra=null;
	public Locale lingua=Locale.ITALY;
	Timer t=null;
	public JLabel tempo=null;
    
	
	public Memory() throws IOException{
		mem1 = new MemoryListener();
		this.Disegna();
    }
	
    public void Disegna() throws IOException{
        
       buttonPanel = CreaAreaCarte();
  
       URL url= ClassLoader.getSystemResource("Immagini/sfondo.png");
       
       segnapunti= new Segnapunti(url); 
       
       JScrollPane scrollPane = new JScrollPane(segnapunti);
       scrollPane.setPreferredSize(new Dimension(277,475));
       
       ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",this.lingua);
       String Libretto= messages.getString("Libretto");
       
       
       punti = Libretto;
       
       segnapunti.setText(punti);
      
       SimpleAttributeSet attribs = new SimpleAttributeSet();  
       StyleConstants.setAlignment(attribs , StyleConstants.ALIGN_CENTER);
       attribs.addAttribute(CharacterConstants.Size,20);
       segnapunti.setParagraphAttributes(attribs,true);

       
       gestoremusica= new GestoreMusica(this);
       
        setLayout(new BorderLayout());
        
        setJMenuBar(new MenuBar(this));
        
        setSize(745,620);
        setTitle("Memory");
        
        destra = new JPanel();
        destra.setLayout(new BorderLayout());
        
        Font f= new Font("Serif",Font.BOLD,20);
        
        tempo=new JLabel();
        tempo.setFont(f);
        
        messages= ResourceBundle.getBundle("MessagesBundle",lingua);
		String temporim= messages.getString("tempo");
        
		tempo.setText(temporim+"70 sec.");
        tempo.setHorizontalAlignment(JLabel.CENTER);
        
        destra.add(tempo,BorderLayout.CENTER);
        destra.add(scrollPane,BorderLayout.NORTH);
        destra.add(gestoremusica,BorderLayout.SOUTH);
        
        add(buttonPanel,BorderLayout.CENTER);
        
        add(destra,BorderLayout.EAST);
        

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        this.setLocationRelativeTo(null);
        
        t = new Timer(1000,new MyTimer(this));
		t.start();
        
        setVisible(true);
        
    }
	
	
    private JPanel CreaAreaCarte(){
    	JPanel buttonPanel = new JPanel();
        
        buttonPanel.setLayout(new GridLayout(4, 4,10,10));
 
      
        for (int i = 0; i < 16; i++)
        {
            CharButton b = new CharButton(this.getCharacter());
            buttonPanel.add(b);
            b.addActionListener(mem1);
            b.cover();
        }
		return buttonPanel;
    }
    
    
    public void RidisegnaAreaGioco() throws IOException{
    	
    	String[] labels2 = { "1", "2", "3", "4", "5", "6", "7", "8","1", "2", "3", "4", "5", "6", "7", "8"};

    	labels=labels2;
    	 
        dim = labels.length;
    	
        mem1.ResettaCoppie();
        
    	remove(buttonPanel);
    	
    	buttonPanel = CreaAreaCarte();
    	
    	ResourceBundle messages= ResourceBundle.getBundle("MessagesBundle",this.lingua);
        String Libretto= messages.getString("Libretto");
        
        
        punti = Libretto;
        
        
        segnapunti.setText(punti);
        tempo.setForeground(Color.black);
        
        messages= ResourceBundle.getBundle("MessagesBundle",lingua);
		String temporim= messages.getString("tempo");
        
		tempo.setText(temporim+"70 sec.");
        add(buttonPanel, BorderLayout.CENTER);
        
        t.stop();
        t = new Timer(1000,new MyTimer(this));
		t.start();
        
        setVisible(true);
        
    	
    }
   
    
    public void ModificaSegnapunti(String punti){
    	this.punti+=punti;
    	segnapunti.setText(this.punti);
    }
    
    private String[] labels = { "1", "2", "3", "4", "5", "6", "7", "8","1", "2", "3", "4", "5", "6", "7", "8"};

    private int dim = labels.length;

    private String getCharacter()
    {
        int ran = (int) (Math.random() * 100) % dim;
        String ran1 = labels[ran];

        for (int i = ran + 1; i < dim; i++)
        {
            labels[i - 1] = labels[i];
        }
        dim--;
        return ran1;
    }

   public static void main(String[] args) throws Exception
    {

		Intro i= new Intro();
		Thread.sleep(3000);
		i.setVisible(false);
        @SuppressWarnings("unused")
		Memory m = new Memory();
    }
}