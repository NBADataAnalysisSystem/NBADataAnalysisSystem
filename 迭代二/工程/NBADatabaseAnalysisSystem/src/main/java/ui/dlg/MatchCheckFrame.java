package ui.dlg;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.awt.AWTUtilities;



public class MatchCheckFrame extends JFrame implements  ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980271968002702909L;
	private static Point origin = new Point();
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
	JPanel playerPanel;
	
//	String player;
//	String[] season;
//	String[] match;
	String teamA;
	String teamB;
	ImageIcon iconA;
	ImageIcon iconB;
	String[][] infoA;
	String[][] infoB;
	String matchID;
	
	public MatchCheckFrame(String teamA,String teamB,String id){
			this.teamA = teamA;
			this.teamB = teamB;
			matchID=id;
			getData();
			backgroundPanel = new JPanel();
			height = Toolkit.getDefaultToolkit().getScreenSize().height*4/5;
			width = Toolkit.getDefaultToolkit().getScreenSize().width*1/2;
			x=(Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
			y=(Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
			this.setUndecorated(true);
			this.setSize(width, height);
			this.setLocation(x,y);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setLayout(null);
		
			backgroundPanel.setSize(width,height);
			backgroundPanel.setLayout(null);

			ImageIcon background ;
			background = new ImageIcon("resource/check.png");
			background.setImage(background.getImage().getScaledInstance(backgroundPanel.getWidth(), backgroundPanel.getHeight(),Image.SCALE_DEFAULT));
		
			JLabel placeBackgroundIcon = new JLabel();
			placeBackgroundIcon.setIcon(background);
			placeBackgroundIcon.setBounds(0, 0,backgroundPanel.getWidth() , backgroundPanel.getHeight());
			placeBackgroundIcon.setOpaque(false);

		      
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0,width, height);
			mainPanel.setLayout(new GridLayout(2,1));
			mainPanel.setOpaque(false);
			
			setTeamPanel(teamA);
			setTeamPanel(teamB);
			
			
			JButton btn_Close = new JButton("×");
			btn_Close.setMargin(new Insets(0,0,0,0));
			btn_Close.setBounds(this.getWidth()-30,0,30, 30);
			btn_Close.addActionListener( this);
			btn_Close.setContentAreaFilled(false);
			btn_Close.setForeground(Color.decode("#3A5FCD"));
			btn_Close.setFont(new Font("Serif",0, 30));
			btn_Close.setName("close");
		      //TODO
			backgroundPanel.add(placeBackgroundIcon);
			backgroundPanel.setBackground(Color.white);
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
	/**
	 * 获取teamA,teamB的数据
	 * iconA.B为球队图片
	 * info[][]为参赛球员数据，打开FRAME查看
	 * matchID为比赛ID
	 */
	private void getData() {
		// TODO Auto-generated method stub
		iconA = new ImageIcon("resource/BackgroundOfHot.png");
		iconB = new ImageIcon("resource/BackgroundOfHot.png");
		infoA = new String[30][21];
		infoB = new String[30][21];
	}
	
	public void setMatchID(String id){
		
		this.matchID = id;
		
	}
	
	@SuppressWarnings("static-access")
	private void setTeamPanel(final String team){
		String[][] info ;
		final ImageIcon icon;
		System.out.println(teamA);
		System.out.println(team);
		if(team == (teamA)){
			info = infoA;
			icon = iconA;
		}else{
			info = infoB;
			icon = iconB;
		}
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		panel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText(team);
		final JFrame tempFrame =this;
		lineLabel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								TeamCheckFrame check = new TeamCheckFrame(team);
								check.setFatherFrame(fatherFrame);
								tempFrame.dispose();

					}          
				}
				);    
		icon.setImage(icon.getImage().getScaledInstance(height/10, height/10,Image.SCALE_DEFAULT));
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.BLACK);
		lineLabel.setHorizontalTextPosition(lineLabel.RIGHT);
		lineLabel.setHorizontalAlignment(lineLabel.LEFT);
		panel.add(lineLabel);


		JScrollPane playerSp ;
		String [] header = new String[21];
		final String[][] tableString = new String[info.length+1][21];
		header= new String[]{"姓名","位置","分钟","%","命中","出手","三分%","三分命中","三分出手","罚球%","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
		for(int i = 0;i<info.length;i++){
			tableString[1+i] = info[i];
		}
		DefaultTableModel model = new DefaultTableModel(tableString,header);
		final JTable table = new JTable(model);
		playerSp = new JScrollPane(table);
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=6;
		layout.setConstraints(playerSp, s);
		playerSp.getViewport().setOpaque(false);
		playerSp.setOpaque(false);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(header[i].length()*height/30);	
		}
		table.setFont(new Font("宋体",0,height/56));
		table.getColumnModel().getColumn(0).setPreferredWidth(6*height/30);	
		table.setRowHeight(height/23);
		table.setRowHeight(0, 1);
		table.setEnabled(false);
		table.setGridColor(new Color(0,0,0,0));
		//table.setPreferredScrollableViewportSize(new Dimension(tableString.length*height/23,width+200));
		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		playerSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		playerSp.setColumnHeaderView(table.getTableHeader());//设置头部（HeaderView部分）  
		table.getTableHeader().setOpaque(false);
		playerSp.setOpaque(false);
		playerSp.getColumnHeader().setOpaque(false);
		table.setOpaque(false);
		table.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								PlayerCheckFrame check = new PlayerCheckFrame(tableString[table.rowAtPoint(e.getPoint())][0]);
								check.setFatherFrame(fatherFrame);
								tempFrame.dispose();

					}          
				}
				);    
		playerSp.getViewport().setOpaque(false);
	//	playerSp.getHorizontalScrollBar().setUI();
		panel.add(playerSp);
		
		mainPanel.add(panel);
	}





	private JFrame fatherFrame;
	public void setFatherFrame(JFrame frame){
		fatherFrame = frame;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		MatchCheckFrame test = new MatchCheckFrame("","","");
	}

	 @SuppressWarnings("serial")
	class MyTableCellRenderrer extends DefaultTableCellRenderer{
	        
         @Override
         public Component getTableCellRendererComponent(JTable table,
                 Object value, boolean isSelected, boolean hasFocus, int row,
                 int column)
         {
             // TODO Auto-generated method stub
             Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//             if(row == 0){
//            	 comp.setBackground(Color.GRAY);
//             }else
            	 if(row%2 ==1){
            	// ((JComponent) comp).setOpaque(false);
            	 
            	  comp.setBackground(Color.decode("#D1EEEE"));
             }else if(row%2 ==0 ){
           	  comp.setBackground(Color.white);
            }
             return comp;
         }
 }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
					AWTUtilities.setWindowOpacity(fatherFrame, 1f);
			//	  System.exit(0);
			}
		}
		
	}
	


}

