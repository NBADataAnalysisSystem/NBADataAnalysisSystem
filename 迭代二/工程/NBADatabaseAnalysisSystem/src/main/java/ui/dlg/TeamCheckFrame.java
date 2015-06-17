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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.sun.awt.AWTUtilities;

import controller.teamdetailcontroller.GetTeamDetailInfoRequest;
import controller.teamdetailcontroller.GetTeamDetailInfoResponse;
import controller.teamdetailcontroller.TeamDetailController;
import dao.chartdao.ChartDao;
import dao.chartdao.ChartDaoJdbcImp;



@SuppressWarnings("restriction")
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
	JPanel setPanel;
	JPanel playoffPanel;
	JPanel allMatchPanel;
	
	final ImageIcon setIcon = new ImageIcon("resource/set.png");
	final ImageIcon lineIcon = new ImageIcon("resource/Line.png");
	
//	String player;
//	String[] season;
//	String[] match;
	String team;
	String[] basicInfo;
	String[] playoffHeader;
	String[] matchHeader;
	String[][] seasonInfo;
	String[][] aveInfo;
	String[][] playerInfo;
	String[][] playoffData;
	String[][] matchData;
//	String[][] matchInfo;
	String[][] pieChartData;
	String[][] barChartData;
	TeamPieChartPanel pieChartPanel;
	TeamBarChartPanel barChartPanel; 
	public TeamCheckFrame(String tocheck){
			UIManager.put("Table.background", new ColorUIResource(Color.WHITE));
			UIManager.put("Table.alternateRowColor", Color.decode("#D1EEEE"));
			playoffHeader = new String[]{"年度","场数","%","三分%","罚球%","进攻","防守","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
			matchHeader = new String[]{"日期","%"," 三分%"," 罚球%", "篮板" ,"助攻" ,"盖帽" ,"失误"};
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
			mainPanel.setOpaque(false);
			
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
	//	JRadioButton dataButton = new JRadioButton("数据");
		JRadioButton matchButton = new JRadioButton("比赛");
		JRadioButton chartButton = new JRadioButton("图表");
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(infoButton);
		//buttons.add(dataButton);
		buttons.add(matchButton);
		buttons.add(chartButton);
		
		infoButton.setOpaque(false);
	//	dataButton.setOpaque(false);
		matchButton.setOpaque(false);
		chartButton.setOpaque(false);
		
		infoButton.setFont(new Font("黑体",1,height/24));
	///	dataButton.setFont(new Font("黑体",1,height/24));
		matchButton.setFont(new Font("黑体",1,height/24));
		chartButton.setFont(new Font("黑体",1,height/24));
		
		infoButton.setForeground(Color.WHITE);
		//dataButton.setForeground(Color.WHITE);
		matchButton.setForeground(Color.WHITE);
		chartButton.setForeground(Color.WHITE);
		
		infoButton.setHorizontalAlignment(infoButton.CENTER);
	//	dataButton.setHorizontalAlignment(dataButton.CENTER);
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
		
//		dataButton.addMouseListener(
//				new MouseAdapter(){
//					public void mouseClicked(MouseEvent e){
//					//	selectedRow = Integer.parseInt(e.getComponent().getName());
//								tempFrame.remove(setPanel);
//								setDataPanel();
//								tempFrame.revalidate();
//								tempFrame.repaint();
//
//					}          
//				}
//				);    
		
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
		//setPanel.add(dataButton);
		setPanel.add(matchButton);
		setPanel.add(chartButton);
		this.add(setPanel,0);
		this.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								if(e.getComponent().getComponentAt(tempFrame.getMousePosition()) !=setPanel){
									tempFrame.remove(setPanel);
									tempFrame.revalidate();
									tempFrame.repaint();
								}

					}          
				}
				);    
		
		sp.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								if(e.getComponent().getComponentAt(tempFrame.getMousePosition()) !=setPanel){
									tempFrame.remove(setPanel);
									tempFrame.revalidate();
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
		lineLabel.setText("球队贡献与能力情况图");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//				);
		lineIcon.setImage(lineIcon.getImage().getScaledInstance(mainPanel.getWidth(),mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("微软雅黑",1,height/24));
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
		getPieChartData();
		getBarChartData();
//		
//		String[][] chartData = new String[lifeData.length][2];
//		for(int i = 0;i<lifeData.length;i++){
//			chartData[i][0] = lifeData[i][0];
//			chartData[i][1] = lifeData[i][lifeData[i].length-1];
//		}
		
		pieChartPanel = new TeamPieChartPanel(0,30+lineLabel.getHeight(),width,height*2/5,pieChartData);
		pieChartPanel.setOpaque(false);
		mainPanel.add(pieChartPanel);
		
		getBarChartData();
		barChartPanel = new TeamBarChartPanel(0,30+lineLabel.getHeight()+pieChartPanel.getHeight(),width,height*2/5,barChartData);
		barChartPanel.setOpaque(false);
		mainPanel.add(barChartPanel);
		
		
	}
	
private void setInfoPanel(){
		
		mainPanel.removeAll();
		mainPanel.setLayout(null);
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
		
		mainPanel.add(basicPanel);
		mainPanel.add(sp);
	}

//	@SuppressWarnings("static-access")
//	private void setDataPanel(){
//		mainPanel.removeAll();
//		GridBagLayout layout = new GridBagLayout();
//		GridBagConstraints s= new GridBagConstraints();
//		s.fill = GridBagConstraints.BOTH; 
//
//		mainPanel.setLayout(layout);
//		
//		JPanel temp = new JPanel();
//		temp.setOpaque(false);
//		s.gridwidth=0;
//		s.gridheight=1;
//		s.weightx = 1; 
//		s.weighty=2;
//		layout.setConstraints(temp, s);
//		mainPanel.add(temp);
//		
//		final JLabel lineLabel =new JLabel();
//		s.gridwidth=1;
//		s.gridheight=1;
//		s.weightx = 1; 
//		s.weighty=0;
//		layout.setConstraints(lineLabel, s);
//		lineLabel.setText("赛季数据");
////		lineLabel.addComponentListener(new ComponentAdapter(){
////			public void componentResized(ComponentEvent e){
////				lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
////			}
////		}
////				);
//		lineIcon.setImage(lineIcon.getImage().getScaledInstance(mainPanel.getWidth(),mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
//		lineLabel.setIcon(lineIcon);
//		lineLabel.setFont(new Font("微软雅黑",1,height/24));
//		lineLabel.setForeground(Color.WHITE);
//		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
//		mainPanel.add(lineLabel);
//		
//		final JLabel setLabel =new JLabel();
//		s.gridwidth=0;
//		s.gridheight = 1;
//		s.weightx = 0; 
//		s.weighty=0;
//		layout.setConstraints(setLabel, s);
////		setLabel.addComponentListener(new ComponentAdapter(){
////			public void componentResized(ComponentEvent e){
////				setIcon.setImage(setIcon.getImage().getScaledInstance(setLabel.getWidth(), setLabel.getHeight(),Image.SCALE_DEFAULT));
////			}
////		}
////	);
//		setIcon.setImage(setIcon.getImage().getScaledInstance(mainPanel.getHeight()/14,mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
//		setLabel.setIcon(setIcon);
//		setLabel.addMouseListener(
//				new MouseAdapter(){
//					public void mouseClicked(MouseEvent e){
//					//	selectedRow = Integer.parseInt(e.getComponent().getName());
//						setSetPanel(setLabel.getWidth()+setLabel.getX()-setPanel.getWidth(),setLabel.getY()+setLabel.getHeight());
//
//					}          
//				}
//				);   
//	//	setLabel.setHorizontalTextPosition(setLabel.CENTER);
//		mainPanel.add(setLabel);
//
//		getPlayoffData();
//		
//		playoffPanel = new JPanel();
//		setDataSp(playoffPanel,playoffData);
//		s.gridwidth=0;
//		s.gridheight=32;
//		s.weightx = 1; 
//		s.weighty=32;
//		layout.setConstraints(sp, s);
//		mainPanel.add(sp);
//		
//		
//		this.revalidate();
//		this.repaint();
//		
//	}
	
//	@SuppressWarnings("serial")
//	private void setDataSp(JPanel panel, String[][] content) {
//		String [] tempHeader = new String[14];
//		final Object[][] tableString = new Object[content.length][14];
//		tempHeader= playoffHeader;
//				
//		for(int i = 0;i<tableString.length;i++){
//			for(int j = 0 ; j<tableString[0].length;j++){
//				if(j <= 0){
//						tableString[i][j] = content[i][j] ;
//				}else{
//						if(content[i][j]!=null){
//							tableString[i][j] = Double.parseDouble(content[i][j]);
//						}else{
//							tableString[i][j] = content[i][j];
//						}
//				}
//			}
//		}
//		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader) {  
//			@SuppressWarnings({ "unchecked", "rawtypes" })
//			public Class getColumnClass(int column) {  
//		        Class returnValue;  
//		        if ((column >=1) && (column < getColumnCount())) {  
//		            returnValue = Double.class;  
//		            
//		        } else {  
//		            returnValue = Object.class;  
//		        }  
//		        return returnValue;  
//		    }  
//		};
//		JTable table = new JTable(model);
//		MyTableBodyCellRenderrer render = new MyTableBodyCellRenderrer();
//		//	render.setOpaque(false); 
//	     
//	        table.setDefaultRenderer(Object.class,render);  
//			for(int i = 0;i<table.getColumnCount();i++){
//				table.getColumnModel().getColumn(i).setPreferredWidth(tempHeader[i].length()*height/25);	
//			}
//			table.getColumnModel().getColumn(0).setPreferredWidth(4*height/21);	
//			table.getColumnModel().getColumn(2).setPreferredWidth(3*height/21);	
//			table.setRowHeight(height/26);
//			table.setEnabled(false);
//			table.setGridColor(Color.decode("#D1EEEE"));
//		
//		sp = new JScrollPane(table);
//		
//		this.revalidate();
//		this.repaint();
//		
//		
//	}
	
	//设置比赛界面的两个子界面
			@SuppressWarnings("serial")
			private void setMatchSp(JPanel panel,final String[][] content){
				String [] tempHeader = matchHeader;
				final Object[][] tableString = new Object[content.length][8];
		//		tempHeader= season;
						
				for(int i = 0;i<tableString.length;i++){
					for(int j = 0 ; j<tableString[0].length;j++){
						if(j <= 0){
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
//					table.getColumnModel().getColumn(0).setPreferredWidth(3*height/21);	
//					table.getColumnModel().getColumn(1).setPreferredWidth(3*height/21);	
//					table.getColumnModel().getColumn(2).setPreferredWidth(3*height/21);	
					table.setRowHeight(height/26);
					table.setEnabled(false);
					table.setGridColor(Color.decode("#D1EEEE"));
					
					final JFrame tempFrame =this;
					table.addMouseListener(
							new MouseAdapter(){
								@SuppressWarnings("unused")
								public void mouseClicked(MouseEvent e){
								//	selectedRow = Integer.parseInt(e.getComponent().getName());
									//TODO 比赛ID未知，日后设置
											MatchCheckFrame check = new MatchCheckFrame(basicInfo[0],"",content[table.rowAtPoint(e.getPoint())][8]);
										check.setFatherFrame(fatherFrame);
											tempFrame.dispose();

								}          
							}
							);    
				
				sp = new JScrollPane(table);
				
				this.revalidate();
				this.repaint();
				
			}
			//球员贡献，根据球员的per值划分。per值的计算。。。要30个变量，先处理好球员那边的再考虑这里吧。。。
			private void getPieChartData(){
				ChartDaoJdbcImp dataImp = new ChartDaoJdbcImp();
				String[][] temp = dataImp.getTeamPlayerEfficiency(team);
				for(int i = 0;i<temp.length;i++){
					temp[i][0] = temp[i][0].split(" ")[0];
				}
				pieChartData = temp;
//				for(int i = 0 ;i<5;i++){
//					pieChartData[i][0] = i+"";
//					pieChartData[i][1] = i+"";
//				}
			}
			
			//球队场均得分，场均篮板，场均助攻，罚球%，三分%与联盟均值对比
			private void getBarChartData(){
				ChartDaoJdbcImp dataImp = new ChartDaoJdbcImp();
				String[] temp = dataImp.getLeagueInfo();
				System.out.println(temp.length);
				barChartData = new String[2][6];
					barChartData[0][0] = team;
					barChartData[0][1] = aveInfo[aveInfo.length-1][13];
					barChartData[0][2] = aveInfo[aveInfo.length-1][7];
					barChartData[0][3] =aveInfo[aveInfo.length-1][8];
					barChartData[0][4] = Double.parseDouble(aveInfo[aveInfo.length-1][4])/10+"";
					barChartData[0][5] =Double.parseDouble(aveInfo[aveInfo.length-1][3])+"";
					
				barChartData[1][0] = "联盟";
				for(int i = 0;i<5;i++){
					barChartData[1][i+1] = temp[i];
				}
			}
////所有赛季的场均信息
//	private void getPlayoffData() {
//		// TODO Auto-generated method stub
//		playoffData = new String[100][14];
//		
//	}

	@SuppressWarnings({ "static-access" })
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
		lineIcon.setImage(lineIcon.getImage().getScaledInstance(mainPanel.getWidth(),mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
		lineLabel.setIcon(lineIcon);
		lineLabel.setFont(new Font("微软雅黑",1,height/24));
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
		setIcon.setImage(setIcon.getImage().getScaledInstance(mainPanel.getHeight()/14,mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
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

		getAllMatchData();
		
		allMatchPanel = new JPanel();
		setMatchSp(allMatchPanel,matchData);
		s.gridwidth=0;
		s.gridheight=0;
		s.weightx = 1; 
		s.weighty=32;
		layout.setConstraints(sp, s);
		mainPanel.add(sp);
		
		
		this.revalidate();
		this.repaint();
		
		
	}
	
	private void getAllMatchData(){
		ChartDao data = new ChartDaoJdbcImp();
		String temp[][] = data.getTeamMatchInfo(team);
//		for(int i = 0;i<temp.length;i++){
//			temp[i][0] = temp[i][0].substring(0,4);
//		}
		matchData = temp;
	}
	/**
	 * 	team = tocheck;
	*basicInfo = new String[11];
	*seasonInfo = new String[2][17];
	*matchInfo = new String[5][21];
	*获取数据的方法 team为球队名称，用来获取basicInfo
	*basicInfo[]:0:球队名1:所属联盟2:胜场3:负场4:场均得分5场均篮板6:场均助攻7:对手得分8:图片
	*seasonInfo为赛季信息[0]为2013-2014[1]为2014-2015 。[n][17]
	*aveInfo为场均信息。[0]为2013-2014[1]为2014-2015.[n][14]打开界面后查看
	*playerInfo为球员信息。[n][16]打开界面查看、。。。
	*请在获取球员列表后立即为playerInfo赋值= =。。这边暂用30个球员
	 */
	private void getData() {
		// TODO Auto-generated method stub
		TeamDetailController controller = new TeamDetailController();
		GetTeamDetailInfoResponse response = (GetTeamDetailInfoResponse) controller.processRequest(
				new GetTeamDetailInfoRequest(team));
		basicInfo = response.getBasicInfo();
		ArrayList<String[]> tempList = response.getSeasonTotalInfo();
		seasonInfo = new String[tempList.size()][17];
		for (int i = 0; i < tempList.size(); i++) {
			for (int j = 0; j < 17; j++) {
				seasonInfo[i][j] = tempList.get(i)[j];
			}
		}
		tempList = response.getSeasonAvgInfo();
		aveInfo = new String[tempList.size()][14];
		for (int i = 0; i < tempList.size(); i++) {
			for (int j = 0; j < 14; j++) {
				aveInfo[i][j] = tempList.get(i)[j];
			}
		}
		tempList = response.getPlayerInfo();
		playerInfo = new String[tempList.size()][16];
		for (int i = 0; i < tempList.size(); i++) {
			for (int j = 0; j < 16; j++) {
				playerInfo[i][j] = tempList.get(i)[j]; 
			}
		}
	}


	@SuppressWarnings({ "static-access", "serial", "unchecked", "rawtypes" })
	private void setPlayerPanel() {

		final ImageIcon icon = new ImageIcon("resource/Line.png");
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.insets = new Insets(0,0,0,0);
		s.fill = GridBagConstraints.BOTH; 
		playerPanel.setLayout(layout);
		final JLabel lineLabel =new JLabel();
		s.gridwidth=0;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("比赛阵容");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
				icon.setImage(icon.getImage().getScaledInstance(this.getWidth(),mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
//			}
//		}
//	);
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("微软雅黑",1,height/24));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		playerPanel.add(lineLabel);
		
		


		JScrollPane playerSp ;
		String [] tempHeader = new String[16];
		final Object[][] tableString = new Object[playerInfo.length][16];
		tempHeader= new String[]{"姓名","场数","先发","分钟","%","三分%","罚球%","进攻","防守","场均篮板","场均抢断","场均盖帽","场均助攻","犯规","失误","场均得分"};

		for(int i = 0;i<tableString.length;i++){
			for(int j = 0 ; j<tableString[0].length;j++){
				if(j == 0){
						tableString[i][j] = playerInfo[i][j] ;
				}else{
						if(playerInfo[i][j]!=null){
							tableString[i][j] = Double.parseDouble(playerInfo[i][j]);
						}else{
							tableString[i][j] = playerInfo[i][j];
						}
				}
			}
		}
		DefaultTableModel model = new DefaultTableModel(tableString,tempHeader) {  
			public Class getColumnClass(int column) {  
		        Class returnValue;  
		        if ((column >=1) && (column < getColumnCount())) {  
		            returnValue = Double.class;  
		            
		        } else {  
		            returnValue = Object.class;  
		        }  
		        return returnValue;  
		    }  
		};
		final JTable table = new JTable(model);
		playerSp = new JScrollPane(table);
		s.gridwidth=0;
		s.gridheight = 0;
		s.weightx = 1; 
		s.weighty=8;
		layout.setConstraints(playerSp, s);
		playerSp.getViewport().setOpaque(false);
		playerSp.setOpaque(false);
		MyTableBodyCellRenderrer render = new MyTableBodyCellRenderrer();
     
        table.setDefaultRenderer(Object.class,render);  
		for(int i = 0;i<table.getColumnCount();i++){
			table.getColumnModel().getColumn(i).setPreferredWidth(tempHeader[i].length()*height/24);	
		}
		table.setFont(new Font("微软雅黑",0,height/56));
		table.getColumnModel().getColumn(0).setPreferredWidth(5*height/24);	
		table.getColumnModel().getColumn(3).setPreferredWidth(3*height/24);	
		table.getColumnModel().getColumn(4).setPreferredWidth(2*height/24);	
		table.setRowHeight(height/23);
		final TableRowSorter sorter = new TableRowSorter(model); 
		table.setRowSorter(sorter);
		table.setEnabled(false);
		table.setGridColor(new Color(0,0,0,0));
		final JFrame tempFrame =this;
		table.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
								PlayerCheckFrame check = new PlayerCheckFrame((String) tableString[table.rowAtPoint(e.getPoint())][0]);
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
		s.gridwidth=1;
		s.gridheight = 1;
		s.weightx = 1; 
		s.weighty=0;
		layout.setConstraints(lineLabel, s);
		lineLabel.setText("赛季数据");
//		lineLabel.addComponentListener(new ComponentAdapter(){
//			public void componentResized(ComponentEvent e){
//				icon.setImage(icon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			}
//		}
//	);
		icon.setImage(icon.getImage().getScaledInstance(this.getWidth(),mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
		lineLabel.setIcon(icon);
		lineLabel.setFont(new Font("微软雅黑",1,height/21));
		lineLabel.setForeground(Color.WHITE);
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		seasonPanel.add(lineLabel);
		
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
		setIcon.setImage(setIcon.getImage().getScaledInstance(mainPanel.getHeight()/14,mainPanel.getHeight()/14,Image.SCALE_DEFAULT));
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

		JLabel header1 = new JLabel();
		header1.setText("场均");
		header1.setBackground(Color.decode("#D1EEEE"));
		header1.setOpaque(true);
		header1.setFont(new Font("微软雅黑",1,height/35));
		header1.setHorizontalAlignment(header1.LEFT);
		String [] tempHeader = new String[14];
		String[][] tableString = new String[3][14];
		for(int i = 0;i<aveInfo.length;i++){
			tableString[i] = aveInfo[i];
//			tableString[2] = aveInfo[1];
		}
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
		table.getColumnModel().getColumn(2).setPreferredWidth(2*height/21);	
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
		header1.setFont(new Font("微软雅黑",1,height/35));
		header1.setHorizontalAlignment(header1.LEFT);
		tempHeader = new String[17];
		tableString = new String[3][17];
		for(int i = 0;i<seasonInfo.length;i++){
			tableString[i] = seasonInfo[i];
//			tableString[2] = aveInfo[1];
		}
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
		icon =  new ImageIcon(basicInfo[8]);
		icon.setImage(icon.getImage().getScaledInstance(width/4, height/3,Image.SCALE_DEFAULT));
		playerPhoto.setIcon(icon);
		contain.add(playerPhoto);

		JPanel dataPanel = new JPanel();
		dataPanel.setOpaque(false);
		dataPanel.setLayout(new GridLayout(3,1));
		JLabel chineseName = new JLabel();
		chineseName.setText(basicInfo[0]);
		chineseName.setFont(new Font("微软雅黑",1,height/26));
	//	chineseName.setBorder(BorderFactory.createLoweredBevelBorder());
		chineseName.setHorizontalAlignment(chineseName.LEFT);
		chineseName.setVerticalAlignment(chineseName.BOTTOM);
		dataPanel.add(chineseName);
		JPanel contain1 = new JPanel();
		contain1.setLayout(new GridLayout(3,1));
		contain1 .setOpaque(false);
		JLabel rank = new JLabel();		
		rank.setText(basicInfo[1]);
		rank.setFont(new Font("微软雅黑",0,12));
		rank.setHorizontalAlignment(chineseName.LEFT);
		contain1.add(rank);
		contain1.add(new JLabel());
		dataPanel.add(contain1);
	
		dataPanel.add(new JLabel());
		contain.add(dataPanel);
	
		JPanel rankPanel = new JPanel();
		rankPanel.setOpaque(false);
		rankPanel.setLayout(new GridLayout(2,1));
		JLabel winLose = new JLabel();
		winLose.setText(basicInfo[2].split("\\.")[0]+"胜-"+basicInfo[3].split("\\.")[0]+"负");
		winLose.setForeground(Color.GRAY);
		winLose.setFont(new Font("微软雅黑",1,height/24));
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
		temp1.setFont(new Font("微软雅黑",0,12));
		temp1.setForeground(Color.GRAY);
		contain.add(temp1);
		JLabel temp2 =new JLabel();
		temp2.setText("<html>场均<br>篮板</html>");
		temp2.setVerticalAlignment(temp2.BOTTOM);
		temp2.setFont(new Font("微软雅黑",0,12));
		temp2.setForeground(Color.GRAY);
		contain.add(temp2);
		JLabel temp3 =new JLabel();
		temp3.setText("<html>场均<br>助攻</html>");
		temp3.setVerticalAlignment(temp3.BOTTOM);
		temp3.setFont(new Font("微软雅黑",0,12));
		temp3.setForeground(Color.GRAY);
		contain.add(temp3);
		JLabel temp4 =new JLabel();
		temp4.setText("<html>对手<br>得分</html>");
		temp4.setVerticalAlignment(temp4.BOTTOM);
		temp4.setFont(new Font("微软雅黑",0,12));
		temp4.setForeground(Color.GRAY);
		contain.add(temp4);
		contain.add(new JLabel());
		JLabel tempa = new JLabel();
		tempa.setText("");
		tempa.setFont(new Font("微软雅黑",0,12));
		tempa.setForeground(Color.decode("#9B30FF"));
		contain.add(tempa);
		JLabel tempb = new JLabel();
		tempb.setText("");
		tempb.setFont(new Font("微软雅黑",0,12));
		tempb.setForeground(Color.decode("#9B30FF"));
		contain.add(tempb);
		JLabel temp1A =new JLabel();
		temp1A.setText(basicInfo[4]);
		temp1A.setFont(new Font("微软雅黑",1,20));
		contain.add(temp1A);
		JLabel temp2A =new JLabel();
		temp2A.setText(basicInfo[5]);
		temp2A.setFont(new Font("微软雅黑",1,20));
		contain.add(temp2A);
		JLabel temp3A =new JLabel();
		temp3A.setText(basicInfo[6]);
		temp3A.setFont(new Font("微软雅黑",1,20));
		contain.add(temp3A);
		JLabel temp4A =new JLabel();
		temp4A.setText(basicInfo[7]);
		temp4A.setFont(new Font("微软雅黑",1,20));
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

