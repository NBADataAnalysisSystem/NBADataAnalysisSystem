package ui.dlg;


import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.sun.awt.AWTUtilities;

import controller.playerdetailcontroller.GetPlayerDetailInfoRequest;
import controller.playerdetailcontroller.GetPlayerDetailInfoResponse;
import controller.playerdetailcontroller.PlayerDetailController;



@SuppressWarnings("restriction")
public class PlayerCheckFrame extends JFrame implements  ActionListener{

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
	//资料界面子界面
	JPanel infoPanel;
	JPanel seasonPanel;
	JPanel matchPanel;
	//数据界面子界面
	JPanel lifePanel;
	JPanel playoffPanel;
	//比赛界面子界面
	JPanel allMatchPanel;
	//PS:然而上面三个界面似乎没什么卵用
	//设置界面
	JPanel setPanel;
	final ImageIcon setIcon = new ImageIcon("resource/set.png");
	final ImageIcon lineIcon = new ImageIcon("resource/Line.png");
	String player;
	String[] season;
	String[] match;
	String[] basicInfo;
	//资料页面信息，最近一年的赛季信息及最近五场比赛
	String[][] seasonInfo;
	String[][] matchInfo;
	//数据页面信息,全部的季后赛信息及职业生涯数据
	String[][] playoffData;
	String[][] lifeData;
	//比赛页面信息，该球员全部比赛信息
	String[][] allMatch;
	
	PlayerChartPanel chartPanel;
	
	public PlayerCheckFrame(String tocheck){
		UIManager.put("Table.background", new ColorUIResource(Color.WHITE));
		UIManager.put("Table.alternateRowColor", Color.decode("#D1EEEE"));
			player = tocheck;
			season = new String[]{"年度","球队","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
			match = new String[]{"日期","对手","分钟","%","命中","出手","三分%","三分命中","三分出手","罚球%","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
			basicInfo = new String[15];
			seasonInfo = new String[2][17];
			matchInfo = new String[5][22];
			getInfo();
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
			mainPanel.setOpaque(false);
			
			lineIcon.setImage(lineIcon.getImage().getScaledInstance(width,height/14,Image.SCALE_DEFAULT));
			setIcon.setImage(setIcon.getImage().getScaledInstance(height/14,height/14,Image.SCALE_DEFAULT));
			setPanel = new JPanel();
			setPanel.setBackground(Color.decode("#696969"));
			setPanel.setSize(width/7, height/3);
			
			setInfoPanel();
	
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
	@SuppressWarnings("static-access")
	private void setSetPanel(int x,int y){
		final JFrame tempFrame =this;
		setPanel.removeAll();
		JRadioButton infoButton = new JRadioButton("资料");
		JRadioButton dataButton = new JRadioButton("数据");
		JRadioButton matchButton = new JRadioButton("比赛");
		JRadioButton chartButton = new JRadioButton("图表");
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(infoButton);
		buttons.add(dataButton);
		buttons.add(matchButton);
		buttons.add(chartButton);
		
		infoButton.setOpaque(false);
		dataButton.setOpaque(false);
		matchButton.setOpaque(false);
		chartButton.setOpaque(false);
		
		infoButton.setFont(new Font("黑体",1,height/24));
		dataButton.setFont(new Font("黑体",1,height/24));
		matchButton.setFont(new Font("黑体",1,height/24));
		chartButton.setFont(new Font("黑体",1,height/24));
		
		infoButton.setForeground(Color.WHITE);
		dataButton.setForeground(Color.WHITE);
		matchButton.setForeground(Color.WHITE);
		chartButton.setForeground(Color.WHITE);
		
		infoButton.setHorizontalAlignment(infoButton.CENTER);
		dataButton.setHorizontalAlignment(dataButton.CENTER);
		matchButton.setHorizontalAlignment(matchButton.CENTER);
		chartButton.setHorizontalAlignment(matchButton.CENTER);
		
		infoButton.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								tempFrame.remove(setPanel);
								setInfoPanel();
								tempFrame.revalidate();
								tempFrame.repaint();

					}          
				}
				);    
		
		dataButton.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								tempFrame.remove(setPanel);
								setDataPanel();
								tempFrame.revalidate();
								tempFrame.repaint();

					}          
				}
				);    
		
		matchButton.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								tempFrame.remove(setPanel);
								setAllMatchPanel();
								tempFrame.revalidate();
								tempFrame.repaint();

					}          
				}
				);    
		
		chartButton.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								tempFrame.remove(setPanel);
								setChartPanel();
								tempFrame.revalidate();
								tempFrame.repaint();

					}          
				}
				);   
		
		
		setPanel.setLayout(new GridLayout(4,1));
		setPanel.add(infoButton);
		setPanel.add(dataButton);
		setPanel.add(matchButton);
		setPanel.add(chartButton);
		this.add(setPanel,0);
		this.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								if(e.getComponent().getComponentAt(tempFrame.getMousePosition()) !=setPanel){
									tempFrame.remove(setPanel);
									tempFrame.repaint();
								}

					}          
				}
				);    
		this.revalidate();
		this.repaint();
		setPanel.setLocation(x, y);
		
	}
	
	@SuppressWarnings("static-access")
	private void setChartPanel(){
		mainPanel.removeAll();
		mainPanel.setLayout(null);
		

		
		final JLabel lineLabel =new JLabel();
		lineLabel.setText("球员季度场均得分图");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//				);
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		lineLabel.setSize(width-height/14, height/14);
		lineLabel.setLocation(0, 30);
		mainPanel.add(lineLabel);
		
		final JLabel setLabel =new JLabel();
//		setLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				setIcon.setImage(setIcon.getImage().getScaledInstance(setLabel.getWidth(), setLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		setLabel.setIcon(setIcon);
		setLabel.setSize(height/14, height/14);
		setLabel.setLocation( lineLabel.getWidth(), 30);
		setLabel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						setSetPanel(setLabel.getWidth()+setLabel.getX()-setPanel.getWidth(),setLabel.getY()+setLabel.getHeight());

					}          
				}
				);   
	//	setLabel.setHorizontalTextPosition(setLabel.CENTER);
		mainPanel.add(setLabel);
		
		//TODO 连好数据后使用
//		getData();
//		
//		String[][] chartData = new String[lifeData.length][2];
//		for(int i = 0;i<lifeData.length;i++){
//			chartData[i][0] = lifeData[i][0];
//			chartData[i][1] = lifeData[i][lifeData[i].length-1];
//		}
		
		String[][] chartData = new String[5][2];
		for(int i = 0 ;i<5;i++){
			chartData[i][0] = i+"";
			chartData[i][1] = i+"";
		}
		
		chartPanel = new PlayerChartPanel(0,30+lineLabel.getHeight(),width,height-30,chartData);
		chartPanel.setOpaque(false);
		mainPanel.add(chartPanel);
		
		
	}
	/**
	 * 设置球员资料界面
	 */
	private void setInfoPanel(){
		
		mainPanel.removeAll();
		mainPanel.setLayout(null);
		basicPanel = new JPanel();
		basicPanel.setBounds(0, 0, width, height/3);
		basicPanel.setOpaque(false);
		setBasicPanel();
		
		infoPanel = new JPanel();
		infoPanel.setBounds(0, height/3, width, height*2/3);
		infoPanel.setLayout(new GridLayout(2,1));
		infoPanel.setOpaque(false);
		
		seasonPanel = new JPanel();
		seasonPanel.setOpaque(false);
		setSeasonPanel();
		infoPanel.add(seasonPanel);
		
		matchPanel = new JPanel();
		matchPanel.setOpaque(false);
		matchPanel.setBorder(BorderFactory.createEmptyBorder());
		setMatchPanel();
		infoPanel.add(matchPanel);
		
		mainPanel.add(infoPanel);
		mainPanel.add(basicPanel);
	}

	/**
	 * 设置球员数据界面
	 * 包括职业生涯数据和季后赛数据
	 */
	@SuppressWarnings("static-access")
	private void setDataPanel(){
		mainPanel.removeAll();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 

		mainPanel.setLayout(layout);
		
		JPanel temp = new JPanel();
		temp.setOpaque(false);
		s.gridwidth=0;
		s.gridheight=1;
		s.weightx = 1; 
		s.weighty=2;
		layout.setConstraints(temp, s);
		mainPanel.add(temp);
		
		final JLabel lineLabel =new JLabel();
		s.gridwidth=1;
		s.gridheight=1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("职业生涯数据");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//				);
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		mainPanel.add(lineLabel);
		
		final JLabel setLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0; 
		s.weighty=0;
		layout.setConstraints(setLabel, s);
//		setLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				setIcon.setImage(setIcon.getImage().getScaledInstance(setLabel.getWidth(), setLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		setLabel.setIcon(setIcon);
		setLabel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						setSetPanel(setLabel.getWidth()+setLabel.getX()-setPanel.getWidth(),setLabel.getY()+setLabel.getHeight());

					}          
				}
				);   
	//	setLabel.setHorizontalTextPosition(setLabel.CENTER);
		mainPanel.add(setLabel);

		getData();
		
		lifePanel = new JPanel();
		setDataSp(lifePanel,lifeData);
		s.gridwidth=0;
		s.gridheight=16;
		s.weightx = 1; 
		s.weighty=16;
		layout.setConstraints(sp, s);
		mainPanel.add(sp);
		
		
		final JLabel lineLabels =new JLabel();
		s.gridwidth=0;
		s.gridheight=1;
		s.weightx = 23; 
		s.weighty=0;
		layout.setConstraints(lineLabels, s);
		lineLabels.setText("季后赛数据");
//		lineLabels.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabels.getWidth(), lineLabels.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//				);
		lineLabels.setIcon(lineIcon);
		lineLabels.setFont(new Font("宋体",1,height/24));
		lineLabels.setForeground(Color.WHITE);
		lineLabels.setHorizontalTextPosition(lineLabels.CENTER);
		mainPanel.add(lineLabels);
		
		playoffPanel = new JPanel();
		setDataSp(playoffPanel,playoffData);
		s.gridwidth=0;
		s.gridheight=0;
		s.weightx = 1; 
		s.weighty=16;
		layout.setConstraints(sp, s);
		mainPanel.add(sp);
		
		
		this.revalidate();
		this.repaint();
	}
	
	/**
	 * 设置球员比赛界面
	 * 球员所有比赛的数据
	 */
	@SuppressWarnings("static-access")
	private void setAllMatchPanel(){
		mainPanel.removeAll();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 

		mainPanel.setLayout(layout);
		
		JPanel temp = new JPanel();
		temp.setOpaque(false);
		s.gridwidth=0;
		s.gridheight=1;
		s.weightx = 1; 
		s.weighty=2;
		layout.setConstraints(temp, s);
		mainPanel.add(temp);
		
		final JLabel lineLabel =new JLabel();
		s.gridwidth=1;
		s.gridheight=1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("所有比赛数据");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//				);
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		mainPanel.add(lineLabel);
		
		final JLabel setLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0; 
		s.weighty=0;
		layout.setConstraints(setLabel, s);
//		setLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				setIcon.setImage(setIcon.getImage().getScaledInstance(setLabel.getWidth(), setLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		setLabel.setIcon(setIcon);
		setLabel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						setSetPanel(setLabel.getWidth()+setLabel.getX()-setPanel.getWidth(),setLabel.getY()+setLabel.getHeight());

					}          
				}
				);   
	//	setLabel.setHorizontalTextPosition(setLabel.CENTER);
		mainPanel.add(setLabel);

		getMatchData();
		
		allMatchPanel = new JPanel();
		setMatchSp(allMatchPanel,allMatch);
		s.gridwidth=0;
		s.gridheight=0;
		s.weightx = 1; 
		s.weighty=32;
		layout.setConstraints(sp, s);
		mainPanel.add(sp);
		
		
		this.revalidate();
		this.repaint();
	}
	/**
	 * 获取资料页面的信息
	 * 	player = tocheck;
	 *season = new String[]{"年度","球队","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
	*match = new String[]{"日期","对手","分钟","%","命中","出手","三分%","三分命中","三分出手","罚球%","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
	*21为比赛ID（不显示）
	*basicInfo = new String[16];
	*seasonInfo = new String[2][17];
	*matchInfo = new String[5][22];
	*获取数据的方法 player为球员名称，用来获取basicInfo
	*basicInfo[]:0:号数1:英文名2:球队3:位置4身高5:体重6:生日7:经历8:学校9:球员图片10:球队图片
	*season为赛季数据的信息
	*seasonInfo[0]为平均[1]为总数 。[n][17]就是上面那一串。。。
	*matchInfo为最近五场比赛信息[0]-[4]为比赛。后面你懂得。。。
	 */
	private void getInfo() {
		// TODO Auto-generated method stub
		PlayerDetailController controller = new PlayerDetailController();
		GetPlayerDetailInfoResponse response = (GetPlayerDetailInfoResponse) controller.processRequest(new GetPlayerDetailInfoRequest(player));
		basicInfo = response.getBasicInfo();
		seasonInfo = response.getSeasonInfo();
		matchInfo = response.getMatchInfo();
	}
	/**
	 * 获取数据页面的信息
	 * 	player = tocheck;
	 *season = new String[]{"年度","球队","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
	*获取数据的方法 player为球员名称，用来获取basicInfo
	*根据获取到的数据设置数组的行值，这里暂时取100
	 */
	private void getData(){
		playoffData = new String[100][17];
		lifeData = new String[100][17];
	}
	/**
	 * 获取比赛页面的信息
	 * match = new String[]{"日期","对手","分钟","%","命中","出手","三分%","三分命中","三分出手","罚球%","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
	 */
	private void getMatchData(){
		allMatch = new String[100][22];
	}


	//设置数据界面的两个子界面
	@SuppressWarnings("serial")
	private void setDataSp(JPanel panel,String[][] content){
		String [] tempHeader = new String[17];
		final Object[][] tableString = new Object[content.length][17];
		tempHeader= season;
				
		for(int i = 0;i<tableString.length;i++){
			for(int j = 0 ; j<tableString[0].length;j++){
				if(j <= 1){
						tableString[i][j] = content[i][j] ;
				}else{
						if(content[i][j]!=null){
							tableString[i][j] = Double.parseDouble(content[i][j]);
						}else{
							tableString[i][j] = content[i][j];
						}
				}
			}
		}
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader) {  
			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int column) {  
		        Class returnValue;  
		        if ((column >=2) && (column < getColumnCount())) {  
		            returnValue = Double.class;  
		            
		        } else {  
		            returnValue = Object.class;  
		        }  
		        return returnValue;  
		    }  
		};
		JTable table = new JTable(model);
		MyTableBodyCellRenderrer render = new MyTableBodyCellRenderrer();
		//	render.setOpaque(false); 
	     
	        table.setDefaultRenderer(Object.class,render);  
			for(int i = 0;i<table.getColumnCount();i++){
				table.getColumnModel().getColumn(i).setPreferredWidth(tempHeader[i].length()*height/25);	
			}
			table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
			table.getColumnModel().getColumn(1).setPreferredWidth(4*height/21);	
			table.getColumnModel().getColumn(4).setPreferredWidth(3*height/21);	
			table.setRowHeight(height/26);
			table.setEnabled(false);
			table.setGridColor(Color.decode("#D1EEEE"));
		
		sp = new JScrollPane(table);
		
		this.revalidate();
		this.repaint();
		
	}
	
	//设置比赛界面的两个子界面
		@SuppressWarnings("serial")
		private void setMatchSp(JPanel panel,String[][] content){
			String [] tempHeader = new String[22];
			final Object[][] tableString = new Object[content.length][22];
			tempHeader= season;
					
			for(int i = 0;i<tableString.length;i++){
				for(int j = 0 ; j<tableString[0].length;j++){
					if(j <= 1){
							tableString[i][j] = content[i][j] ;
					}else{
							if(content[i][j]!=null){
								tableString[i][j] = Double.parseDouble(content[i][j]);
							}else{
								tableString[i][j] = content[i][j];
							}
					}
				}
			}
			DefaultTableModel model = new DefaultTableModel(tableString,tempHeader) {  
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int column) {  
			        Class returnValue;  
			        if ((column >=2) && (column < getColumnCount())) {  
			            returnValue = Double.class;  
			            
			        } else {  
			            returnValue = Object.class;  
			        }  
			        return returnValue;  
			    }  
			};
			final JTable table = new JTable(model);
			MyTableBodyCellRenderrer render = new MyTableBodyCellRenderrer();
			//	render.setOpaque(false); 
		     
		        table.setDefaultRenderer(Object.class,render);  
				for(int i = 0;i<table.getColumnCount();i++){
					table.getColumnModel().getColumn(i).setPreferredWidth(tempHeader[i].length()*height/25);	
				}
				table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
				table.getColumnModel().getColumn(1).setPreferredWidth(4*height/21);	
				table.getColumnModel().getColumn(4).setPreferredWidth(3*height/21);	
				table.setRowHeight(height/26);
				table.setEnabled(false);
				table.setGridColor(Color.decode("#D1EEEE"));
				
				final JFrame tempFrame =this;
				table.addMouseListener(
						new MouseAdapter(){
							public void mouseClicked(MouseEvent e){
							//	selectedRow = Integer.parseInt(e.getComponent().getName());
										MatchCheckFrame check = new MatchCheckFrame(basicInfo[2],(String) tableString[table.rowAtPoint(e.getPoint())][1],matchInfo[table.rowAtPoint(e.getPoint())-1][21]);
										check.setFatherFrame(fatherFrame);
										tempFrame.dispose();

							}          
						}
						);    
			
			sp = new JScrollPane(table);
			
			this.revalidate();
			this.repaint();
			
		}
	@SuppressWarnings("static-access")
	private void setMatchPanel() {
	//	final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		matchPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=1;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("最近五场比赛");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("宋体",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		matchPanel.add(lineLabel);

		String [] tempHeader = new String[21];
		final String[][] tableString = new String[6][21];
		tableString[0]= new String[]{"日期","对手","分钟","%","命中","出手","三分%","三分命中","三分出手","罚球%","罚球命中","罚球出手","进攻","防守","篮板","助攻","犯规","抢断","失误","盖帽","得分"};
		for(int i = 0;i<5;i++){
			tableString[i+1] = matchInfo[i];
		}
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader);
		final JTable table = new JTable(model);
		s.gridwidth=0;
		s.weightx = 1; 
		s.weighty=8;
		layout.setConstraints(table, s);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/26);	
		}
		final JFrame tempFrame =this;
		table.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								MatchCheckFrame check = new MatchCheckFrame(basicInfo[2],tableString[table.rowAtPoint(e.getPoint())][1],matchInfo[table.rowAtPoint(e.getPoint())-1][21]);
								check.setFatherFrame(fatherFrame);
								tempFrame.dispose();

					}          
				}
				);    
		table.setFont(new Font("宋体",0,height/54));
		table.getColumnModel().getColumn(0).setPreferredWidth(5*height/24);	
		table.getColumnModel().getColumn(3).setPreferredWidth(2*height/24);	
		table.setRowHeight(height/23);
		table.setEnabled(false);
		table.setGridColor(Color.GRAY);

		//table.setOpaque(false);

		matchPanel.add(table);
		
	}


	@SuppressWarnings("static-access")
	private void setSeasonPanel() {
		//final ImageIcon lineIcon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		seasonPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=1;
		s.gridheight = 1;
		s.weightx =23; 
		s.weighty=1;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("赛季数据");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("宋体",1,height/21));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		seasonPanel.add(lineLabel);
		
		final JLabel setLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 0; 
		s.weighty=1;
		layout.setConstraints(setLabel, s);
//		setLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				setIcon.setImage(setIcon.getImage().getScaledInstance(setLabel.getWidth(), setLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		setLabel.setIcon(setIcon);
		setLabel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						setSetPanel(setLabel.getWidth()+setLabel.getX()-setPanel.getWidth(),setLabel.getY()+basicPanel.getHeight()+setLabel.getHeight());

					}          
				}
				);   
	//	setLabel.setHorizontalTextPosition(setLabel.CENTER);
		seasonPanel.add(setLabel);

		String [] tempHeader = new String[17];
		String[][] tableString = new String[5][17];
		tableString[0]= new String[]{"年度","球队","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		tableString[1][0] = "赛季平均";
		tableString[2] = seasonInfo[0];
		tableString[3][0] = "赛季总计";
		tableString [4] = seasonInfo[1];
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader);
		JTable table = new JTable(model);
		s.gridwidth=0;
		s.gridheight = 0;
		s.weightx = 1; 
		s.weighty=5;
		layout.setConstraints(table, s);
		MyTableCellRenderrer render = new MyTableCellRenderrer();
	//	render.setOpaque(false); 
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tableString[0][i].length()*height/25);	
		}
		table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
		table.getColumnModel().getColumn(1).setPreferredWidth(4*height/21);	
		table.getColumnModel().getColumn(4).setPreferredWidth(3*height/21);	
		table.setRowHeight(height/19);
		table.setEnabled(false);
		table.setGridColor(Color.decode("#D1EEEE"));
		//table.setOpaque(false);

		seasonPanel.add(table);
	}


	@SuppressWarnings("static-access")
	private void setBasicPanel() {
		ImageIcon icon = new ImageIcon();
		basicPanel.setLayout(new GridLayout(1,4));
		JLabel playerPhoto = new JLabel();
		icon =  new ImageIcon(basicInfo[9]);
		icon.setImage(icon.getImage().getScaledInstance(width/4, height/3,Image.SCALE_DEFAULT));
		playerPhoto.setIcon(icon);
		basicPanel.add(playerPhoto);
		JPanel contain;

		JPanel dataPanel = new JPanel();
		dataPanel.setLayout(new BorderLayout());
		JLabel number = new JLabel();
		number.setText(basicInfo[0]);
		number.setForeground(Color.YELLOW);
		number.setFont(new Font("宋体",1,50));
		number.setBorder(BorderFactory.createLoweredBevelBorder());
		number.setHorizontalAlignment(number.RIGHT);
		dataPanel.add("West",number);
		contain = new JPanel();
		contain.setOpaque(false);
		contain.setLayout(new GridLayout(4,1));
		JLabel englishName = new JLabel();
		englishName.setText(basicInfo[1]);
		englishName.setFont(new Font("宋体",0,20));
		englishName.setHorizontalAlignment(number.LEFT);
		contain.add(englishName);
		JLabel teamChinese = new JLabel();
		teamChinese.setText(basicInfo[2]);
		teamChinese.setFont(new Font("宋体",0,15));
		teamChinese.setForeground(Color.BLUE);
		teamChinese.setHorizontalAlignment(teamChinese.LEFT);
		teamChinese.setVerticalAlignment(teamChinese.BOTTOM);
		final JFrame tempFrame =this;
		teamChinese.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								TeamCheckFrame check = new TeamCheckFrame(basicInfo[2]);
								check.setFatherFrame(tempFrame);
								AWTUtilities.setWindowOpacity(tempFrame, 0.5f);

					}          
				}
				);   
		contain.add(teamChinese);
		JLabel position = new JLabel();
		position.setText(basicInfo[3]);
		position.setFont(new Font("Courier",0,15));
		position.setHorizontalAlignment(position.LEFT);
		position.setVerticalAlignment(position.TOP);
		contain.add(position);
		dataPanel.add("Center",contain);

		contain = new JPanel();
		contain.setOpaque(false);
		dataPanel.add("South",contain);
		dataPanel.setOpaque(false);
		basicPanel.add(dataPanel);
		
		JPanel basicInfoPanel = new JPanel();
		basicInfoPanel.setOpaque(false);
		basicInfoPanel.setLayout(new GridLayout(8,1));
		basicInfoPanel.add(new JLabel());
		JLabel whRate = new JLabel();
		whRate.setText(basicInfo[4]+"/"+basicInfo[5]);
		whRate.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(whRate);
		JLabel birthDay = new JLabel();
		birthDay.setText("生日"+":"+basicInfo[6]);
		birthDay.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(birthDay);
		JLabel exp = new JLabel();
		exp.setText("经历"+":"+basicInfo[7]);
		exp.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(exp);
		JLabel school = new JLabel();
		school.setText("加入NBA之前"+":"+basicInfo[8]);
		school.setFont(new Font("Serif",0,11));
		basicInfoPanel.add(school);
		basicPanel.add(basicInfoPanel);
		
		JLabel teamIcon = new JLabel();
		icon =  new ImageIcon(basicInfo[10]);
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
	private JFrame fatherFrame;
	public void setFatherFrame(JFrame frame){
		fatherFrame = frame;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		PlayerCheckFrame test = new PlayerCheckFrame("");
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
		@SuppressWarnings("serial")
		class MyTableBodyCellRenderrer extends DefaultTableCellRenderer{
	        
	         @Override
	         public Component getTableCellRendererComponent(JTable table,
	                 Object value, boolean isSelected, boolean hasFocus, int row,
	                 int column)
	         {
	             // TODO Auto-generated method stub
	             Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
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
