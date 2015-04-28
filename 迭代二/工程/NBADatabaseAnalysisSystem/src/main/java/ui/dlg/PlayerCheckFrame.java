package ui.dlg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;

import ui.frame.FrameInterface;


public class PlayerCheckFrame extends JFrame implements  ActionListener{

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
	JScrollPane sp;
	JPanel infoPanel;
	JPanel seasonPanel;
	JPanel matchPanel;
	

	
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
			
			infoPanel = new JPanel();
			infoPanel.setBounds(0, height/3, width, height*2/3);
			infoPanel.setLayout(new GridLayout(2,1));
			infoPanel.setOpaque(false);
			
			seasonPanel = new JPanel();
			setSeasonPanel();
			infoPanel.add(seasonPanel);
			
			mainPanel.add(infoPanel);
			JButton btn_Close = new JButton("×");
			btn_Close.setMargin(new Insets(0,0,0,0));
			btn_Close.setBounds(this.getWidth()-30,0,30, 30);
			btn_Close.addActionListener( this);
			btn_Close.setContentAreaFilled(false);
			btn_Close.setForeground(Color.decode("#3A5FCD"));
			btn_Close.setFont(new Font("Serif",0, 30));//设置字体
			btn_Close.setName("close");
		      //TODO
			mainPanel.add(basicPanel);
			backgroundPanel.add(placeBackgroundIcon);
			this.add(backgroundPanel);
			this.add(mainPanel,0);
			this.add(btn_Close,0);
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


	private void setSeasonPanel() {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("static-access")
	private void setBasicPanel() {
		ImageIcon icon = new ImageIcon();
		basicPanel.setLayout(new GridLayout(1,4));
		JLabel playerPhoto = new JLabel();
		icon =  new ImageIcon("resource/BackgroundOfHot.png");
		icon.setImage(icon.getImage().getScaledInstance(width/4, height/3,Image.SCALE_DEFAULT));
		playerPhoto.setIcon(icon);
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
		englishName.setHorizontalAlignment(number.LEFT);
		contain.add(englishName);
		JLabel chineseName = new JLabel();
		chineseName.setText("中文-中文中文");
		chineseName.setFont(new Font("宋体",1,15));
		chineseName.setHorizontalAlignment(chineseName.LEFT);
		contain.add(chineseName);
		JLabel teamChinese = new JLabel();
		teamChinese.setText("中文中文中文");
		teamChinese.setFont(new Font("宋体",0,15));
		teamChinese.setForeground(Color.BLUE);
		teamChinese.setHorizontalAlignment(teamChinese.LEFT);
		teamChinese.setVerticalAlignment(teamChinese.BOTTOM);
		contain.add(teamChinese);
		JLabel position = new JLabel();
		position.setText("中文");
		position.setFont(new Font("Courier",0,15));
		position.setHorizontalAlignment(position.LEFT);
		position.setVerticalAlignment(position.TOP);
		contain.add(position);
		dataPanel.add("Center",contain);
		/**
		 * 设置三个场均信息
		 */
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(2,3));
		JLabel temp1 =new JLabel();
		temp1.setText("场均得分");
		temp1.setFont(new Font("宋体",0,10));
		temp1.setForeground(Color.decode("#9B30FF"));
		contain.add(temp1);
		JLabel temp2 =new JLabel();
		temp2.setText("场均篮板");
		temp2.setFont(new Font("宋体",0,10));
		temp2.setForeground(Color.decode("#9B30FF"));
		contain.add(temp2);
		JLabel temp3 =new JLabel();
		temp3.setText("场均助攻");
		temp3.setFont(new Font("宋体",0,10));
		temp3.setForeground(Color.decode("#9B30FF"));
		contain.add(temp3);
		JLabel temp1A =new JLabel();
		temp1A.setText("11");
		temp1A.setFont(new Font("宋体",1,20));
		contain.add(temp1A);
		JLabel temp2A =new JLabel();
		temp2A.setText("22");
		temp2A.setFont(new Font("宋体",1,20));
		contain.add(temp2A);
		JLabel temp3A =new JLabel();
		temp3A.setText("33");
		temp3A.setFont(new Font("宋体",1,20));
		contain.add(temp3A);
		dataPanel.add("South",contain);
		dataPanel.setOpaque(false);
		basicPanel.add(dataPanel);
		/**
		 * 设置个人信息
		 */		
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setOpaque(false);
		basicInfoPanel.setLayout(new GridLayout(8,1));
		basicInfoPanel.add(new JLabel());
		JLabel whRate = new JLabel();
		whRate.setText("身高"+"/"+"体重");
		whRate.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(whRate);
		JLabel birthDay = new JLabel();
		birthDay.setText("生日"+":"+"1111-11-11");
		birthDay.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(birthDay);
		JLabel exp = new JLabel();
		exp.setText("经历"+":"+"2年");
		exp.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(exp);
		JLabel school = new JLabel();
		school.setText("加入NBA之前"+":"+"Baylor/United States");
		school.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(school);
		basicPanel.add(basicInfoPanel);
		
		JLabel teamIcon = new JLabel();
		icon =  new ImageIcon("resource/BackgroundOfHot.png");
		icon.setImage(icon.getImage().getScaledInstance(width/8, height/6,Image.SCALE_DEFAULT));
		teamIcon.setHorizontalAlignment(teamChinese.RIGHT);
		teamIcon.setVerticalAlignment(teamChinese.CENTER);
		teamIcon.setIcon(icon);
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
