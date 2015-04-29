package ui.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.dlg.MatchPanel;


public class MatchFrame extends JFrame implements  ActionListener {

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
	
	private ImageIcon btnChoosedIcon;
	
	private JPanel btnPanel;
	private JPanel mainPanel;
	private JPanel backgroundPanel;
	
	private JButton btn_Match;
	@SuppressWarnings("unused")
	private JButton btn_close;
	@SuppressWarnings("unused")
	private JButton btn_reduce;
	@SuppressWarnings("unused")
	private JButton btn_back;
	
	ArrayList<String> temp= new ArrayList<String>();;
	
	static JLabel btnChoosedLabel = new JLabel();
	
	MatchPanel panel ;
	
	public MatchFrame(){
		
			backgroundPanel = new JPanel();
			mainPanel = new JPanel();
			height = Toolkit.getDefaultToolkit().getScreenSize().height*3/4;
			width = Toolkit.getDefaultToolkit().getScreenSize().width*3/4;
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
			background = new ImageIcon("resource/BackgroundOfMatch.png");
			background.setImage(background.getImage().getScaledInstance(backgroundPanel.getWidth(), backgroundPanel.getHeight(),Image.SCALE_DEFAULT));
		
			JLabel placeBackgroundIcon = new JLabel();
			placeBackgroundIcon.setIcon(background);
			placeBackgroundIcon.setBounds(0, 0,backgroundPanel.getWidth() , backgroundPanel.getHeight());
			placeBackgroundIcon.setOpaque(false);
		
		      setBtnPanel();
		      
		      //设置主要界面容器
		      
				mainPanel.setSize(width*19/20,height*13/14);
				mainPanel.setLayout(null);
				mainPanel.setLocation(width*1/40, btnPanel.getHeight());
				mainPanel.setOpaque(false);
				//设置背景图片
				ImageIcon mainBackground ;
				mainBackground = new ImageIcon("resource/MainWindow.png");
				mainBackground.setImage(mainBackground.getImage().getScaledInstance(mainPanel.getWidth(), mainPanel.getHeight(),Image.SCALE_DEFAULT));
				
				JLabel placeMainIcon = new JLabel();
				placeMainIcon.setIcon(mainBackground);
				placeMainIcon.setBounds(0, 0,mainPanel.getWidth() , mainPanel.getHeight());
				placeMainIcon.setOpaque(false);
		      

		      //TODO
				panel = new MatchPanel(mainPanel.getWidth()/30,mainPanel.getHeight()/30,mainPanel.getWidth()*14/15,mainPanel.getHeight()*27/30);
				panel.setFatherFrame(this);
		      backgroundPanel.add(btnPanel);
		      backgroundPanel.add(mainPanel);
		      mainPanel.add(panel,0);
		      mainPanel.add(placeMainIcon);
		      backgroundPanel.add(placeBackgroundIcon);
		      this.add(backgroundPanel);
		      
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
		      
			      this.setVisible(true);
	}
	//设置主要按钮
	public void setBtnPanel() {

		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setSize(width, height/14);
		btnPanel.setLocation(0,0);
		btnPanel.setOpaque(false);
		
		btn_Match = new JButton("比赛");

		btnChoosedIcon = new ImageIcon("resource/BtnChoosed.png");
		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(120, 30,Image.SCALE_DEFAULT));
		
		btnChoosedLabel.setIcon(btnChoosedIcon);
		btnChoosedLabel.setOpaque(false);
		
		btn_Match.setContentAreaFilled(false);
		btn_Match.setForeground(Color.decode("#FF0000"));
		btn_Match.setFont(new Font("宋体",1, 20));//设置字体
		btn_Match.setBorderPainted(false);
		btn_Match.setFocusPainted(false);
		//btn_Add.setOpaque(false);
		btnPanel.add(btn_Match);
		btnPanel.add(btnChoosedLabel);
		btn_Match.setBounds(mainPanel.getX()+50,btnPanel.getHeight()-30,120,30);
		btnChoosedLabel.setBounds(btn_Match.getX(), btn_Match.getY(),120 , 30);
		
		JButton btn_Close = new JButton("×");
		btn_Close.setMargin(new Insets(0,0,0,0));
		btn_Close.setBounds(btnPanel.getWidth()-50,(btnPanel.getHeight())/2-10,30, 30);
		btn_Close.addActionListener(this);
		btn_Close.setName("close");
		
		
		btn_Close.setContentAreaFilled(false);
		btn_Close.setForeground(Color.decode("#3A5FCD"));
		btn_Close.setFont(new Font("Serif",0, 30));//设置字体
		btnPanel.add(btn_Close);
		
		JButton btn_Back = new JButton("←");
		btn_Back.setMargin(new Insets(0,0,0,0));
		btn_Back.setBounds(btnPanel.getWidth()-60-btn_Close.getWidth(),(btnPanel.getHeight())/2-10,30, 30);
		btn_Back.addActionListener(this);
		btn_Back.setName("back");
		
		btn_Back.setContentAreaFilled(false);
		btn_Back.setForeground(Color.decode("#3A5FCD"));
		btn_Back.setFont(new Font("Serif",0, 20));//设置字体
		btnPanel.add(btn_Back);
		
		JButton reduceButton = new JButton("—");
		reduceButton.setMargin(new Insets(0,0,0,0));
		reduceButton.setBounds(btnPanel.getWidth()-70-2*btn_Close.getWidth(),(btnPanel.getHeight())/2-10,30,30);
		reduceButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            setExtendedState(JFrame.ICONIFIED);
	        }
	    });
		
		reduceButton.setContentAreaFilled(false);
		reduceButton.setForeground(Color.decode("#3A5FCD"));
		reduceButton.setFont(new Font("Serif",0, 20));//设置字体
		btnPanel.add(reduceButton);

	}
	//建立表格区，设定表格大小、颜色等基础信息
	public void setTablePanel() {

	}
//建立表头，设定表格内容及SCROLLPANE
	public void buidTablePanel(int allRow, int allColumn, int pageRow,
			int pageColumn) {
	

	}
//更换表头及表格数据
	public void setTableContent(String [] headerContent,String[][] content) {
	}
//显示详细信息。
	public void showData() {
		//selectedRow为选择行数，即二维数组第一维

	}

	public ArrayList<String> getList() {
		return temp;
		// TODO Auto-generated method stub

	}

	public void setList(ArrayList<String> list) {


	}
	public void setSort(String string) {
	}
	//刷新信息，并根据信息（由tableHeader（String[]）决定）设定内容@Dalec Gu TODO
	public void refreshData() {
	}

	public JLabel setLabelIcon(Icon icon) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		MatchFrame test = new MatchFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}else if("back".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  @SuppressWarnings("unused")
				FrontFrame front = new FrontFrame();
			}
		}
		
	}
	


}
