package ui.dlg;



import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.awt.AWTUtilities;



public class TeamCheckFrame extends JFrame implements  ActionListener{

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
	String team;
	String[] basicInfo;
	String[][] seasonInfo;
	String[][] aveInfo;
	String[][] playerInfo;
//	String[][] matchInfo;
	
	public TeamCheckFrame(String tocheck){
			team = tocheck;
			basicInfo = new String[11];
			seasonInfo = new String [2][17];
			aveInfo = new String[2][14];
			getData();
			backgroundPanel = new JPanel();
			height = Toolkit.getDefaultToolkit().getScreenSize().height*9/10;
			width = Toolkit.getDefaultToolkit().getScreenSize().width*2/3;
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
			mainPanel.setLayout(null);
			mainPanel.setOpaque(false);
	
			basicPanel = new JPanel();
			basicPanel.setBounds(0, 0, width, height/3);
			basicPanel.setOpaque(false);
			setBasicPanel();
			
			
			infoPanel = new JPanel();
			infoPanel.setBounds(0, 0, width-20, height*4/3);
			infoPanel.setPreferredSize(new Dimension(infoPanel.getWidth(),infoPanel.getHeight()));
			GridBagLayout layout = new GridBagLayout();
			infoPanel.setLayout(layout);
			infoPanel.setOpaque(false);
		//	sp.add(infoPanel);
			
			sp = new JScrollPane(infoPanel);
			sp.setBounds(0, height/3, width, height*2/3);
			sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			sp.setOpaque(false);
			sp.getViewport().setOpaque(false);
		//	sp.setLayout(null);
			
			seasonPanel = new JPanel();
			GridBagConstraints s= new GridBagConstraints();
			s.fill = GridBagConstraints.BOTH; 
			s.gridwidth=0;
			s.gridheight =1;
			s.weightx = 1; 
			s.weighty=0;
			layout.setConstraints(seasonPanel, s);
			seasonPanel.setOpaque(false);
			setSeasonPanel();
			infoPanel.add(seasonPanel);
			
			
			playerPanel = new JPanel();
			playerPanel.setOpaque(false);
			playerPanel.setBorder(BorderFactory.createEmptyBorder());
			s.fill = GridBagConstraints.BOTH; 
			s.gridwidth=0;
			s.gridheight = 0;
			s.weightx = 1; 
			s.weighty=5;
			layout.setConstraints(playerPanel, s);
			setPlayerPanel();
			infoPanel.add(playerPanel);
			
			JButton btn_Close = new JButton("×");
			btn_Close.setMargin(new Insets(0,0,0,0));
			btn_Close.setBounds(this.getWidth()-30,0,30, 30);
			btn_Close.addActionListener( this);
			btn_Close.setContentAreaFilled(false);
			btn_Close.setForeground(Color.decode("#3A5FCD"));
			btn_Close.setFont(new Font("Serif",0, 30));
			btn_Close.setName("close");
		      //TODO
			mainPanel.add(basicPanel);
			mainPanel.add(sp);
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
	 * 	team = tocheck;
	*basicInfo = new String[11];
	*seasonInfo = new String[2][17];
	*matchInfo = new String[5][21];
	*获取数据的方法 team为球队名称，用来获取basicInfo
	*basicInfo[]:0:球队名1:所属联盟2:联盟中排名3:教练4:胜场5:负场6:场均得分7:场均篮板8:场均助攻9:对手得分10:图片
	*seasonInfo为赛季信息[0]为2013-2014[1]为2014-2015 。[n][17]
	*aveInfo为场均信息。[0]为2013-2014[1]为2014-2015.[n][14]打开界面后查看
	*playerInfo为球员信息。[n][16]打开界面查看、。。。
	*请在获取球员列表后立即为playerInfo赋值= =。。这边暂用30个球员
	 */
	private void getData() {
		// TODO Auto-generated method stub
		playerInfo = new String [30][16];
	}


	@SuppressWarnings("static-access")
	private void setPlayerPanel() {

		final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		playerPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("季后赛 阵容");
		lineLabel.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e){
				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
			}
		}
	);
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		playerPanel.add(lineLabel);


		JScrollPane playerSp ;
//		String [] tempHeader = new String[16];
		final String[][] tableString = new String[playerInfo.length+1][16];
		tableString[0]= new String[]{"姓名","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均抢断","场均抢断","场均助攻","犯规","失误","场均得分"};
		for(int i = 0;i<playerInfo.length;i++){
			tableString[1+i] = playerInfo[i];
		}
		DefaultTableModel model = new DefaultTableModel(tableString,tableString[0]);
		final JTable table = new JTable(model);
		playerSp = new JScrollPane(table);
		s.gridwidth=0;
		s.gridheight = 0;
		s.weightx = 1; 
		s.weighty=8;
		layout.setConstraints(playerSp, s);
		playerSp.getViewport().setOpaque(false);
		playerSp.setOpaque(false);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/24);	
		}
		table.setFont(new Font("宋体",0,height/56));
		table.getColumnModel().getColumn(0).setPreferredWidth(5*height/24);	
		table.setRowHeight(height/23);
		table.setRowHeight(0, 1);
		table.setEnabled(false);
		table.setGridColor(new Color(0,0,0,0));
		final JFrame tempFrame =this;
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

		//table.setOpaque(false);
		
		playerPanel.add(playerSp);
		
	}


	@SuppressWarnings("static-access")
	private void setSeasonPanel() {
		final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		seasonPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("季后赛数据");
		lineLabel.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e){
				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
			}
		}
	);
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("宋体",1,height/21));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		seasonPanel.add(lineLabel);

		JLabel header1 = new JLabel();
		header1.setText("场均");
		header1.setBackground(Color.decode("#D1EEEE"));
		header1.setOpaque(true);
		header1.setFont(new Font("宋体",1,height/35));
		header1.setHorizontalAlignment(header1.LEFT);
		String [] tempHeader = new String[14];
		String[][] tableString = new String[3][14];
		tableString[1] = aveInfo[0];
		tableString[2] = aveInfo[1];
		tableString[0]= new String[]{"年度","场数","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader);
		JTable table = new JTable(model);
		s.gridwidth=0;
		s.gridheight = 3;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(table, s);
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(header1, s);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
	//	render.setOpaque(false); 
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/21);	
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
//		table.getColumnModel().getColumn(1).setPreferredWidth(4*height/21);	
		table.setRowHeight(height/24);
		table.getTableHeader().setSize(new Dimension(width,height/24));
		table.setEnabled(false);
		table.setGridColor(Color.decode("#D1EEEE"));
		//table.setOpaque(false);
		seasonPanel.add(header1);
		seasonPanel.add(table);
		

		header1 = new JLabel();
		header1.setText("总计");
		header1.setBackground(Color.decode("#D1EEEE"));
		header1.setOpaque(true);
		header1.setFont(new Font("宋体",1,height/35));
		header1.setHorizontalAlignment(header1.LEFT);
		tempHeader = new String[17];
		tableString = new String[3][17];
		tableString[1] = seasonInfo[0];
		tableString[2] = seasonInfo[1];
		tableString[0]= new String[]{"年度","场数","命中","出手","三分命中","三分出手","罚球命中","罚球出手","进攻","防守","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		model = new DefaultTableModel(tableString,tempHeader);
		table = new JTable(model);
		s.gridwidth=0;
		s.gridheight = 3;
		s.weightx = 1; 
		s.weighty=1;
		layout.setConstraints(table, s);
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(header1, s);
		render = new MyTableCellRenderrer();
	//	render.setOpaque(false); 
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/21);	
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
//		table.getColumnModel().getColumn(1).setPreferredWidth(4*height/21);	
		table.setRowHeight(height/24);
		table.getTableHeader().setSize(new Dimension(width,height/24));
		table.setEnabled(false);
		table.setGridColor(new Color(0,0,0,0));
		//table.setOpaque(false);
		seasonPanel.add(header1);
		seasonPanel.add(table);
		
	}


	@SuppressWarnings("static-access")
	private void setBasicPanel() {
		ImageIcon icon = new ImageIcon();
		basicPanel.setLayout(new GridLayout(1,2));
		JPanel contain;
		contain = new JPanel();
		basicPanel.add(contain);
		contain.setLayout(new GridLayout(1,2));
		contain.setOpaque(false);
		JLabel playerPhoto = new JLabel();
		icon =  new ImageIcon(basicInfo[10]);
		icon.setImage(icon.getImage().getScaledInstance(width/4, height/3,Image.SCALE_DEFAULT));
		playerPhoto.setIcon(icon);
		contain.add(playerPhoto);

		JPanel dataPanel = new JPanel();
		dataPanel.setOpaque(false);
		dataPanel.setLayout(new GridLayout(3,1));
		JLabel chineseName = new JLabel();
		chineseName.setText(team);
		chineseName.setFont(new Font("宋体",1,height/26));
		chineseName.setBorder(BorderFactory.createLoweredBevelBorder());
		chineseName.setHorizontalAlignment(chineseName.LEFT);
		chineseName.setVerticalAlignment(chineseName.BOTTOM);
		dataPanel.add(chineseName);
		JPanel contain1 = new JPanel();
		contain1.setLayout(new GridLayout(3,1));
		contain1 .setOpaque(false);
		JLabel rank = new JLabel();		
		rank.setText(basicInfo[1]+"中排名第"+basicInfo[2]);
		rank.setFont(new Font("宋体",0,12));
		rank.setHorizontalAlignment(chineseName.LEFT);
		contain1.add(rank);
		JLabel coach = new JLabel();
		coach.setText("教练:"+basicInfo[3]);
		coach.setFont(new Font("宋体",0,12));
		coach.setHorizontalAlignment(chineseName.LEFT);
		contain1.add(coach);
		dataPanel.add(contain1);
	
		dataPanel.add(new JLabel());
		contain.add(dataPanel);
	
		JPanel rankPanel = new JPanel();
		rankPanel.setOpaque(false);
		rankPanel.setLayout(new GridLayout(2,1));
		JLabel winLose = new JLabel();
		winLose.setText(basicInfo[4]+"胜-"+basicInfo[5]+"负");
		winLose.setForeground(Color.GRAY);
		winLose.setFont(new Font("宋体",1,height/24));
		winLose.setHorizontalAlignment(winLose.LEFT);
		winLose.setVerticalAlignment(winLose.CENTER);
		rankPanel.add(winLose);
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(2,7));
		contain.add(new JLabel());
		contain.add(new JLabel());
		contain.add(new JLabel());
		JLabel temp1 =new JLabel();
		temp1.setText("<html>场均<br>得分</html>");
		temp1.setVerticalAlignment(temp1.BOTTOM);
		temp1.setFont(new Font("宋体",0,12));
		temp1.setForeground(Color.GRAY);
		contain.add(temp1);
		JLabel temp2 =new JLabel();
		temp2.setText("<html>场均<br>篮板</html>");
		temp2.setVerticalAlignment(temp2.BOTTOM);
		temp2.setFont(new Font("宋体",0,12));
		temp2.setForeground(Color.GRAY);
		contain.add(temp2);
		JLabel temp3 =new JLabel();
		temp3.setText("<html>场均<br>助攻</html>");
		temp3.setVerticalAlignment(temp3.BOTTOM);
		temp3.setFont(new Font("宋体",0,12));
		temp3.setForeground(Color.GRAY);
		contain.add(temp3);
		JLabel temp4 =new JLabel();
		temp4.setText("<html>对手<br>得分</html>");
		temp4.setVerticalAlignment(temp4.BOTTOM);
		temp4.setFont(new Font("宋体",0,12));
		temp4.setForeground(Color.GRAY);
		contain.add(temp4);
		contain.add(new JLabel());
		JLabel tempa = new JLabel();
		tempa.setText("季后赛");
		tempa.setFont(new Font("宋体",0,12));
		tempa.setForeground(Color.decode("#9B30FF"));
		contain.add(tempa);
		JLabel tempb = new JLabel();
		tempb.setText("排名");
		tempb.setFont(new Font("宋体",0,12));
		tempb.setForeground(Color.decode("#9B30FF"));
		contain.add(tempb);
		JLabel temp1A =new JLabel();
		temp1A.setText(basicInfo[6]);
		temp1A.setFont(new Font("宋体",1,20));
		contain.add(temp1A);
		JLabel temp2A =new JLabel();
		temp2A.setText(basicInfo[7]);
		temp2A.setFont(new Font("宋体",1,20));
		contain.add(temp2A);
		JLabel temp3A =new JLabel();
		temp3A.setText(basicInfo[8]);
		temp3A.setFont(new Font("宋体",1,20));
		contain.add(temp3A);
		JLabel temp4A =new JLabel();
		temp4A.setText(basicInfo[9]);
		temp4A.setFont(new Font("宋体",1,20));
		contain.add(temp4A);
		rankPanel.add(contain);
		rankPanel.setOpaque(false);
		basicPanel.add(rankPanel);

		
		
	}


	public JLabel setLabelIcon(Icon icon) {
		// TODO Auto-generated method stub
		return null;
	}
	private JFrame fatherFrame;
	public void setFatherFrame(JFrame frame){
		fatherFrame = frame;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		TeamCheckFrame test = new TeamCheckFrame("");
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
             if(row == 0){
            	 comp.setBackground(Color.GRAY);
             }else if(row%2 ==1){
            	// ((JComponent) comp).setOpaque(false);
            	 
            	  comp.setBackground(Color.decode("#D1EEEE"));
             }else if(row%2 ==0 && row !=0){
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

