package ui.frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class FrontFrame extends JFrame implements ActionListener{
	
	JPanel frontPanel;
	JButton teamButton;
	JButton playerButton;
	JButton matchButton;
	JButton hotButton;
	
	int tableWidth;
	int tableHeight;
	private static Point origin = new Point();
	
	public FrontFrame(){
		super();

		this.setUndecorated(true);
		this.setSize(750, 468);
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-750)/2,(Toolkit.getDefaultToolkit().getScreenSize().height-468)/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.center(this);
		this.setLayout(null);
		
		ImageIcon bg = new ImageIcon("resource/FrontBackground.jpg"); 
		@SuppressWarnings("static-access")
		Image temp = bg.getImage().getScaledInstance(bg.getIconWidth(),bg.getIconHeight(), bg.getImage().SCALE_DEFAULT);  
        bg = new ImageIcon(temp);
		JLabel label = new JLabel(bg); 
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight()); 
		this.getRootPane().add(label,new Integer(Integer.MIN_VALUE)); 
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);
		frontPanel = new JPanel();
		frontPanel.setLayout(new BorderLayout());
		frontPanel.setBounds(0, 0, bg.getIconWidth(),  bg.getIconHeight());
		frontPanel.setOpaque(false);	
		
		teamButton = new JButton();
		ImageIcon teamIconUnchoosed = new ImageIcon("resource/TeamUnchoosed.png");
		Image tempTeam = teamIconUnchoosed.getImage().getScaledInstance(teamIconUnchoosed.getIconWidth()/2,teamIconUnchoosed.getIconHeight()/2,Image.SCALE_DEFAULT);  
		teamIconUnchoosed.setImage(tempTeam);
		teamButton.setMargin(new Insets(0,0,0,0));
		teamButton.setIcon(teamIconUnchoosed);
		teamButton.setOpaque(false);
		teamButton.setBounds(this.getWidth()/16,this.getHeight()/5,teamIconUnchoosed.getIconWidth(), teamIconUnchoosed.getIconHeight());
		teamButton.addMouseListener(       new MouseAdapter(){
            public void mouseEntered(MouseEvent e){

        		
            	ImageIcon btnChoosedIcon = new ImageIcon("resource/TeamChoosed.png");
            	btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(teamButton.getWidth(), teamButton.getHeight(),Image.SCALE_DEFAULT));
        		teamButton.setIcon(btnChoosedIcon);
  
            }
            public void mouseExited(MouseEvent e){
            	ImageIcon btnUnhoosedIcon = new ImageIcon("resource/TeamUnchoosed.png");
            	btnUnhoosedIcon.setImage(btnUnhoosedIcon.getImage().getScaledInstance(teamButton.getWidth(), teamButton.getHeight(),Image.SCALE_DEFAULT));
        		teamButton.setIcon(btnUnhoosedIcon);
            }
            @SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e){
            	           	
            	TeamFrame teamFrame = new TeamFrame();
				dispose();
            }
        
	}
);
		teamButton.setName("team");
		teamButton.	setContentAreaFilled(false);
		teamButton.setBorderPainted(false);
		teamButton.setFocusPainted(false);
		this.add(teamButton);
		
		
		
		
		
		
		playerButton = new JButton();
		ImageIcon playerIcon = new ImageIcon("resource/PlayerUnchoosed.png");
		Image tempPlayer = playerIcon.getImage().getScaledInstance(playerIcon.getIconWidth()/2,playerIcon.getIconHeight()/2,Image.SCALE_DEFAULT);  
		playerIcon.setImage(tempPlayer);
		playerButton.setMargin(new Insets(0,0,0,0));
		playerButton.setIcon(playerIcon);
		playerButton.setBounds(5*this.getWidth()/16,this.getHeight()/5,playerIcon.getIconWidth(), playerIcon.getIconHeight());
		playerButton.addMouseListener(       new MouseAdapter(){
            public void mouseEntered(MouseEvent e){

        		
            	ImageIcon btnChoosedIcon = new ImageIcon("resource/PlayerChoosed.png");
            	btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(playerButton.getWidth(), playerButton.getHeight(),Image.SCALE_DEFAULT));
            	playerButton.setIcon(btnChoosedIcon);
  
            }
            public void mouseExited(MouseEvent e){
            	ImageIcon btnUnhoosedIcon = new ImageIcon("resource/PlayerUnchoosed.png");
            	btnUnhoosedIcon.setImage(btnUnhoosedIcon.getImage().getScaledInstance(playerButton.getWidth(), playerButton.getHeight(),Image.SCALE_DEFAULT));
            	playerButton.setIcon(btnUnhoosedIcon);
            }
            @SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e){
            	           	
            	PlayerFrame playerFrame = new PlayerFrame();
				dispose();
            }
        
	}
);
		playerButton.	setContentAreaFilled(false);
		playerButton.setBorderPainted(false);
		playerButton.setFocusPainted(false);
		this.add(playerButton);
		
		matchButton = new JButton();
		ImageIcon matchIcon = new ImageIcon("resource/MatchUnchoosed.png");
		Image tempMatch = matchIcon.getImage().getScaledInstance(matchIcon.getIconWidth()/2,matchIcon.getIconHeight()/2,Image.SCALE_DEFAULT);  
		matchIcon.setImage(tempMatch);
		matchButton.setMargin(new Insets(0,0,0,0));
		matchButton.setIcon(matchIcon);
		matchButton.setBounds(9*this.getWidth()/16,this.getHeight()/5,matchIcon.getIconWidth(), matchIcon.getIconHeight());
		matchButton.addMouseListener(       new MouseAdapter(){
            public void mouseEntered(MouseEvent e){

        		
            	ImageIcon btnChoosedIcon = new ImageIcon("resource/MatchChoosed.png");
            	btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(matchButton.getWidth(), matchButton.getHeight(),Image.SCALE_DEFAULT));
            	matchButton.setIcon(btnChoosedIcon);
  
            }
            public void mouseExited(MouseEvent e){
            	ImageIcon btnUnhoosedIcon = new ImageIcon("resource/MatchUnchoosed.png");
            	btnUnhoosedIcon.setImage(btnUnhoosedIcon.getImage().getScaledInstance(matchButton.getWidth(), matchButton.getHeight(),Image.SCALE_DEFAULT));
            	matchButton.setIcon(btnUnhoosedIcon);
            }
            @SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e){
            	           	
            	MatchFrame playerFrame = new MatchFrame();
				dispose();
            }
        
	}
);
		matchButton.	setContentAreaFilled(false);
		matchButton.setBorderPainted(false);
		matchButton.setFocusPainted(false);
		this.add(matchButton);
		
		hotButton = new JButton();
		ImageIcon hotIcon = new ImageIcon("resource/HotUnchoosed.png");
		Image tempHot = hotIcon.getImage().getScaledInstance(hotIcon.getIconWidth()/2,hotIcon.getIconHeight()/2,Image.SCALE_DEFAULT);  
		hotIcon.setImage(tempHot);
		hotButton.setMargin(new Insets(0,0,0,0));
		hotButton.setIcon(hotIcon);
		hotButton.setBounds(13*this.getWidth()/16,this.getHeight()/5,hotIcon.getIconWidth(), hotIcon.getIconHeight());
		hotButton.addMouseListener(       new MouseAdapter(){
            public void mouseEntered(MouseEvent e){

        		
            	ImageIcon btnChoosedIcon = new ImageIcon("resource/HotChoosed.png");
            	btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(hotButton.getWidth(), hotButton.getHeight(),Image.SCALE_DEFAULT));
            	hotButton.setIcon(btnChoosedIcon);
  
            }
            public void mouseExited(MouseEvent e){
            	ImageIcon btnUnhoosedIcon = new ImageIcon("resource/HotUnchoosed.png");
            	btnUnhoosedIcon.setImage(btnUnhoosedIcon.getImage().getScaledInstance(hotButton.getWidth(), hotButton.getHeight(),Image.SCALE_DEFAULT));
            	hotButton.setIcon(btnUnhoosedIcon);
            }
            @SuppressWarnings("unused")
			public void mouseClicked(MouseEvent e){
            	           	
            	HotFrame playerFrame = new HotFrame();
				dispose();
            }
        
	}
);
		hotButton.	setContentAreaFilled(false);
		hotButton.setBorderPainted(false);
		hotButton.setFocusPainted(false);
		this.add(hotButton);
		
		JButton closeButton = new JButton();
		ImageIcon closeIcon = new ImageIcon("resource/FrontCloseButton.jpg");
		Image tempClose = closeIcon.getImage().getScaledInstance(closeIcon.getIconWidth()/3,closeIcon.getIconHeight()/3,Image.SCALE_DEFAULT);  
		closeIcon.setImage(tempClose);
		closeButton.setMargin(new Insets(0,0,0,0));
		closeButton.setIcon(closeIcon);
		closeButton.setBounds(680,20,closeIcon.getIconWidth(), closeIcon.getIconHeight());
		closeButton.addActionListener(this);
		closeButton.setName("close");
		this.add(closeButton);
		
		this. addMouseListener( 
		        new MouseAdapter(){
		            public void mousePressed(MouseEvent e){
		              origin.x = e.getX();
		              origin.y = e.getY();
		            }
		            @Override
		            public void mouseEntered(MouseEvent e) {
		              repaint();              
		            }            
		          }
		      );

		      this.addMouseMotionListener(
		          new MouseMotionAdapter(){
		            public void mouseDragged(MouseEvent e){
		              Point p =    getLocation();
		              setLocation(p.x + e.getX() - origin.x, p.y + e.getY() - origin.y );
		            }          
		          }
		      );    

				this.add(frontPanel);
				frontPanel.setVisible(true);
				this.setVisible(true);
		
	}
	
	private void center(JFrame frame) {
	       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = frame.getWidth();
	        int height = frame.getHeight();
	        frame.setLocation( (screensize.width - width) / 2,
	                      (screensize.height - height) / 2);
		
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}
		}
	}

	
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		FrontFrame test = new FrontFrame();
	}

}
