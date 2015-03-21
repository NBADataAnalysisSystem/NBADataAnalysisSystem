package ui.Frontui;

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
import javax.swing.SwingUtilities;

import ui.playerui.PlayerFrame;
import ui.teamui.TeamFrame;

@SuppressWarnings("serial")
public class FrontFrame extends JFrame implements ActionListener{
	
	JPanel frontPanel;
	int tableWidth;
	int tableHeight;
	private static Point origin = new Point();
	
	public FrontFrame(){
		super();

		this.setUndecorated(true);
		this.setSize(750, 468);
		this.setLocation(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.center(this);
		this.setLayout(null);
		
		//设置背景图片 TODO
		ImageIcon bg = new ImageIcon("resource/FrontBackground.jpg"); // 把背景图片显示在一个标签里
		@SuppressWarnings("static-access")
		Image temp = bg.getImage().getScaledInstance(bg.getIconWidth(),bg.getIconHeight(), bg.getImage().SCALE_DEFAULT);  
        bg = new ImageIcon(temp);
		JLabel label = new JLabel(bg); //把标签的大小位置设置为图片刚好填充整个面
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight()); //添加图片到frame的第二层 
		this.getRootPane().add(label,new Integer(Integer.MIN_VALUE)); //获取frame的最上层面板为了设置其背景颜色]
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);//设置透明 
		//jp.setVisible(true);
		frontPanel = new JPanel();
		frontPanel.setLayout(new BorderLayout());
		frontPanel.setBounds(0, 0, bg.getIconWidth(),  bg.getIconHeight());
		frontPanel.setOpaque(false);//设置透明 	
		
		JButton teamButton = new JButton();
		ImageIcon teamIcon = new ImageIcon("resource/FrontTeamSelect.jpg");
		Image tempTeam = teamIcon.getImage().getScaledInstance(teamIcon.getIconWidth()/2,teamIcon.getIconHeight()/2,Image.SCALE_DEFAULT);  
		teamIcon.setImage(tempTeam);
		teamButton.setMargin(new Insets(0,0,0,0));
		teamButton.setIcon(teamIcon);
		teamButton.setBounds(2*this.getWidth()/9,this.getHeight()/5,teamIcon.getIconWidth(), teamIcon.getIconHeight());
		teamButton.addActionListener(this);
		teamButton.setName("team");
		this.add(teamButton);
		
		JButton playerButton = new JButton();
		ImageIcon playerIcon = new ImageIcon("resource/FrontPlayerSelect.jpg");
		Image tempPlayer = playerIcon.getImage().getScaledInstance(playerIcon.getIconWidth()/2,playerIcon.getIconHeight()/2,Image.SCALE_DEFAULT);  
		playerIcon.setImage(tempPlayer);
		playerButton.setMargin(new Insets(0,0,0,0));
		playerButton.setIcon(playerIcon);
		playerButton.setBounds(5*this.getWidth()/8,this.getHeight()/5,playerIcon.getIconWidth(), playerIcon.getIconHeight());
		playerButton.addActionListener(this);
		playerButton.setName("player");
		this.add(playerButton);
		
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
		
		//设置拖动窗体的方法
		this. addMouseListener( 
		        new MouseAdapter(){
		            public void mousePressed(MouseEvent e){
		              origin.x = e.getX();
		              origin.y = e.getY();
		            }

//		            public void mouseReleased(MouseEvent e) {
//		              ( (MouseListener) this).mouseReleased(e);
//		            }
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

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("team".equals(name)){
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						TeamFrame teamFrame = new TeamFrame();
						dispose();
					}
				});
			}else if("player".equals(name)){
					PlayerFrame playerFrame = new PlayerFrame();
					dispose();
			}else if("close".equals(name)){
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
