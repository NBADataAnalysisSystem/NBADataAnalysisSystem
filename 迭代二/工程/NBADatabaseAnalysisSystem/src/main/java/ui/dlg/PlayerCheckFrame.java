package ui.dlg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerCheckFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980271968002702909L;
	private static Point origin = new Point();
	//设置窗体大小
	private int height=0;
	private int width=0;
	private int x;
	private int y;
	JPanel backgroundPanel;
	JPanel mainPanel;
	JPanel basicPanel;

	
	public PlayerCheckFrame(){
		
			backgroundPanel = new JPanel();
			height = Toolkit.getDefaultToolkit().getScreenSize().height*4/5;
			width = Toolkit.getDefaultToolkit().getScreenSize().width*1/2;
		//设置Frame原点d
			x=(Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
			y=(Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
			this.setUndecorated(true);
			this.setSize(width, height);
			this.setLocation(x,y);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
		
			backgroundPanel.setSize(width,height);
			backgroundPanel.setLayout(null);

			//设置背景图片
			ImageIcon background ;
			background = new ImageIcon("resource/check.png");
			background.setImage(background.getImage().getScaledInstance(backgroundPanel.getWidth(), backgroundPanel.getHeight(),Image.SCALE_DEFAULT));
		
			JLabel placeBackgroundIcon = new JLabel();
			placeBackgroundIcon.setIcon(background);
			placeBackgroundIcon.setBounds(0, 0,backgroundPanel.getWidth() , backgroundPanel.getHeight());
			placeBackgroundIcon.setOpaque(false);

		      
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0,width, height);
			mainPanel.setLayout(null);
			mainPanel.setOpaque(false);
	
			basicPanel = new JPanel();
			basicPanel.setBounds(0, 0, width, height/3);
			basicPanel.setOpaque(false);
			setBasicPanel();
	
		      //TODO
			mainPanel.add(basicPanel);
			backgroundPanel.add(placeBackgroundIcon);
			this.add(backgroundPanel);
			this.add(mainPanel,0);
			this.setVisible(true);
		      
		  	this. addMouseListener( 
			        new MouseAdapter(){
			            public void mousePressed(MouseEvent e){
			              origin.x = e.getX();
			              origin.y = e.getY();
			            }

//			            public void mouseReleased(MouseEvent e) {
//			              ( (MouseListener) this).mouseReleased(e);
//			            }
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
		      
	}


	@SuppressWarnings("static-access")
	private void setBasicPanel() {
		basicPanel.setLayout(new GridLayout(1,4));
		JLabel playerPhoto = new JLabel();
		basicPanel.add(playerPhoto);
		JPanel contain;
		/**
		 * 设置名、球队名、号数、位置
		 */
		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		JLabel number = new JLabel();
		number.setText("3");
		number.setForeground(Color.YELLOW);
		number.setFont(new Font("宋体",1,50));
		number.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		number.setHorizontalAlignment(number.RIGHT);
		dataPanel.add("West",number);
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(4,1));
		JLabel englishName = new JLabel();
		englishName.setText("ENGLISH");
		englishName.setFont(new Font("宋体",0,20));
		englishName.setHorizontalAlignment(number.CENTER);
		contain.add(englishName);
		JLabel chineseName = new JLabel();
		chineseName.setText("中文-中文中文");
		chineseName.setFont(new Font("宋体",1,15));
		chineseName.setHorizontalAlignment(chineseName.CENTER);
		contain.add(chineseName);
		JLabel teamChinese = new JLabel();
		teamChinese.setText("中文中文中文");
		teamChinese.setFont(new Font("宋体",0,15));
		teamChinese.setForeground(Color.BLUE);
		teamChinese.setHorizontalAlignment(teamChinese.CENTER);
		teamChinese.setVerticalAlignment(teamChinese.BOTTOM);
		contain.add(teamChinese);
		JLabel position = new JLabel();
		position.setText("中文");
		position.setFont(new Font("宋体",0,15));
		position.setHorizontalAlignment(position.CENTER);
		position.setVerticalAlignment(position.TOP);
		contain.add(position);
		dataPanel.add("Center",contain);
		/**
		 * 设置三个场均信息
		 */
		contain = new JPanel();
		contain.setLayout(new GridLayout(2,3));
		contain.setBorder(BorderFactory.createTitledBorder(""));
		JLabel temp =new JLabel("?");
		temp.setFont(new Font("宋体",1,30));
		contain.add(temp);
		dataPanel.add("South",contain);
		dataPanel.setOpaque(false);
		
		
		basicPanel.add(dataPanel);
		JPanel basicInfoPanel = new JPanel();
		basicPanel.add(basicInfoPanel);
		JLabel teamIcon = new JLabel();
		basicPanel.add(teamIcon);
		
		
	}


	public JLabel setLabelIcon(Icon icon) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		PlayerCheckFrame test = new PlayerCheckFrame();
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
	


}
