package ui.dlg;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("serial")
public class HotPanel extends JPanel {
	int x;
	int y;
	static int width;
	static int height;
	JPanel mainPanel;
	
	String[][] hotInfo;
	JButton scoreP;
	JButton reboundP;
	JButton assistP;
	JButton blockShotP;
	JButton stealP;
	ArrayList<JButton> dayHotPlayerBtn;
	
	JButton aveScoreP;
	JButton aveAssistP;
	JButton aveReboundP;
	JButton aveBlockShotP;
	JButton threePointRateP;
	JButton rateP;
	JButton freeShotRateP;
	ArrayList<JButton> seasonHotPlayerBtn;
	
	JButton scoreT;
	JButton reboundT;
	JButton assistT;
	JButton blockShotT;
	JButton stealT;
	JButton threePointRateT;
	JButton rateT;
	JButton freeShotRateT;
	ArrayList<JButton> seasonHotTeamBtn;
	
//	JButton aveScoreI;
//	JButton aveAssistI;
//	JButton aveReboundI;
//	ArrayList<JButton> improvePlayerBtn;
	
	ImageIcon lineIcon;
	JLabel lineLabel;
	JScrollPane sp;
	
	String clickedBtn;
	JPanel dayHotPlayerPanel;
	JPanel seasonHotPlayerPanel;
	JPanel seasonHotTeamPanel;
//	JPanel improvePlayerPanel;
	
	int rowNum;

	@SuppressWarnings("static-access")
	public HotPanel(int xa,int ya,int widtha,int heighta){
		mainPanel = new JPanel();
		clickedBtn = new String();
		sp = new JScrollPane(mainPanel);
		this.x = xa;
		this.y = ya;
		this.width = widtha;
		this.height = heighta;
		this.setBounds(x, y, width, height);
		rowNum = 2;
		this.setLayout(null);
		
		hotInfo = new String [5][5];
		lineIcon = new ImageIcon("resource/Line.png");

		scoreP = new JButton("得分");
		reboundP = new JButton("篮板");
		assistP = new JButton("助攻");
		blockShotP =  new JButton("盖帽");
		stealP =  new JButton("抢断");
		dayHotPlayerBtn =  new ArrayList<JButton>();
		dayHotPlayerBtn.add(scoreP);
		dayHotPlayerBtn.add(reboundP);
		dayHotPlayerBtn.add(assistP);
		dayHotPlayerBtn.add(blockShotP);
		dayHotPlayerBtn.add(stealP);
		
		aveScoreP = new JButton("场均得分");
		aveAssistP = new JButton("场均助攻");
		aveReboundP= new JButton("场均篮板");
		aveBlockShotP= new JButton("场均盖帽");
		threePointRateP= new JButton("三分%");
		rateP= new JButton("%");
		freeShotRateP= new JButton("罚球%");
		seasonHotPlayerBtn=  new ArrayList<JButton>();
		seasonHotPlayerBtn.add(aveScoreP);
		seasonHotPlayerBtn.add(aveAssistP) ;
		seasonHotPlayerBtn.add(aveReboundP);
		seasonHotPlayerBtn.add(aveBlockShotP);
		seasonHotPlayerBtn.add(threePointRateP);
		seasonHotPlayerBtn.add(rateP);
		seasonHotPlayerBtn.add(freeShotRateP);
		
		scoreT = new JButton("得分");
		reboundT= new JButton("篮板");
		assistT= new JButton("助攻");
		blockShotT= new JButton("盖帽");
		stealT= new JButton("抢断");
		threePointRateT= new JButton("三分%");
		rateT= new JButton("%");
		freeShotRateT= new JButton("罚球%");
		seasonHotTeamBtn=  new ArrayList<JButton>();
		seasonHotTeamBtn.add(scoreT);
		seasonHotTeamBtn.add(reboundT);
		seasonHotTeamBtn.add(assistT);
		seasonHotTeamBtn.add(blockShotT);
		seasonHotTeamBtn.add(stealT);
		seasonHotTeamBtn.add(threePointRateT);
		seasonHotTeamBtn.add(rateT);
		seasonHotTeamBtn.add(freeShotRateT);
		
		
//		aveScoreI = new JButton("场均得分");
//		aveAssistI = new JButton("场均助攻");
//		aveReboundI = new JButton("场均篮板");
//		improvePlayerBtn=  new ArrayList<JButton>();
//		improvePlayerBtn.add(aveScoreI);
//		improvePlayerBtn.add(aveAssistI);
//		improvePlayerBtn.add(aveReboundI);

		
		dayHotPlayerPanel = new JPanel();
		dayHotPlayerPanel.setName("当日热点球员");
		clickedBtn = dayHotPlayerPanel.getName() + scoreP.getText();
		setPanel(dayHotPlayerBtn,dayHotPlayerPanel);
		mainPanel.add(dayHotPlayerPanel);
		
		seasonHotPlayerPanel = new JPanel();
		seasonHotPlayerPanel.setName("赛季热点球员");
		clickedBtn = seasonHotPlayerPanel.getName() + aveScoreP.getText();
		setPanel(seasonHotPlayerBtn,seasonHotPlayerPanel);
		mainPanel.add(seasonHotPlayerPanel);
		
		seasonHotTeamPanel = new JPanel();
		seasonHotTeamPanel.setName("赛季热点球队");
		clickedBtn = seasonHotTeamPanel.getName() + scoreT.getText();
		setPanel(seasonHotTeamBtn,seasonHotTeamPanel);
		mainPanel.add(seasonHotTeamPanel);
		
//		improvePlayerPanel = new JPanel();
//		improvePlayerPanel.setName("进步最快球员");
//		clickedBtn = improvePlayerPanel.getName() + aveScoreI.getText();
//		setPanel(improvePlayerBtn,improvePlayerPanel);
//		mainPanel.add(improvePlayerPanel);
		
		
		



		
	

		
		dayHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		dayHotPlayerPanel.setOpaque(false);
		seasonHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotPlayerPanel.setOpaque(false);
		seasonHotTeamPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotTeamPanel.setOpaque(false);
//		improvePlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
//		improvePlayerPanel.setOpaque(false);
		
		
//		mainPanel.add(dayHotPlayerPanel);
//		mainPanel.add(seasonHotPlayerPanel);
//		mainPanel.add(seasonHotTeamPanel);
//		mainPanel.add(improvePlayerPanel);
		
		mainPanel.setBounds(0, 0, width, height*3/(rowNum));
		GridLayout layout = new GridLayout(3,1);
		mainPanel.setLayout(layout);
		mainPanel.setOpaque(false);
		mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(),mainPanel.getHeight()));
		sp.setBounds(0,height/10,mainPanel.getWidth(),height*9/10);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		//sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
		this.add(sp);
		this.setOpaque(false);
	}
	/**
	 * 根据clickedBtn设置hotInfo[][]的值。第一维为排名(01234)
	 * 第二唯[0]为球队/球员名字 [1]为该项排名数据 [2]为所属球队名（若排名为球队排名则为""）[3]为球员/球队icon地址[4]为球队ICON（若为球队排名则为""）
	 */
	private void getData(){
		for(int i = 0;i<5;i++){
			hotInfo[i][0] = "球员名字";
			hotInfo[i][1] = "55";
			hotInfo[i][2] = "球队";
			hotInfo[i][3] = "resource/BackgroundOfHot.png";
			hotInfo[i][4] = "resource/BackgroundOfHot.png";
		}

	}

	@SuppressWarnings("static-access")
	private void setPanel(final ArrayList<JButton> btn,final JPanel panel){
		panel.removeAll();
		System.out.println(clickedBtn);
		ImageIcon icon = new ImageIcon();
		GridBagLayout panelLayout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		//s.insets = new Insets(0,0,0,0);
		getData();
		panel.setLayout(panelLayout);
		JLabel lineLabel = new JLabel();
		lineLabel.setOpaque(false);
		s.gridwidth=0;
		s.weightx = 16; 
		s.weighty=1;
		panelLayout.setConstraints(lineLabel, s);
		lineIcon.setImage(lineIcon.getImage().getScaledInstance(width, height/(rowNum*8),Image.SCALE_DEFAULT));
		lineLabel.setIcon(lineIcon);
		lineLabel.setText(panel.getName());
		lineLabel.setHorizontalTextPosition(lineLabel.CENTER);
		lineLabel.setForeground(Color.WHITE);
		panel.add(lineLabel);
		
		for(int i = 0;i<btn.size()-1;i++){
			s.gridwidth= 1;
			s.weightx = 16/btn.size(); 
			s.weighty=1;
			panelLayout.setConstraints(btn.get(i), s);
			panel.add(btn.get(i));
			btn.get(i).setBorder(BorderFactory.createTitledBorder(""));
			btn.get(i).setOpaque(false);
		}
		s.gridwidth= 0;
		s.weightx =16/btn.size(); 
		s.weighty=1;
		panelLayout.setConstraints(btn.get(btn.size()-1), s);
		panel.add(btn.get(btn.size()-1));
		btn.get(btn.size()-1).setBorder(BorderFactory.createTitledBorder(""));
		btn.get(btn.size()-1).setOpaque(false);
		for(int i = 0;i<btn.size();i++){
			final JButton tempBtn = btn.get(i);
			btn.get(i).addMouseListener(       new MouseAdapter(){
		
            public void mouseClicked(MouseEvent e){
            	//TODO
            	if(clickedBtn.equals( panel.getName()+tempBtn.getText())==false){
 
            		clickedBtn = panel.getName()+tempBtn.getText();
            		setPanel (btn,panel);
            			}
            		}      
				}
			);
		}
		JPanel bottomPanel = new JPanel();
		bottomPanel.setOpaque(false);
		s.gridwidth= 0;
		s.weightx =16; 
		s.weighty=4;
		panelLayout.setConstraints(bottomPanel, s);
		panel.add(bottomPanel);
		
		panelLayout = new GridBagLayout();
		bottomPanel.setLayout(panelLayout);
		s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		JPanel firstPanel = new JPanel();
		firstPanel.setOpaque(false);
		s.gridwidth=1;
		s.weightx =8; 
		s.weighty=4;
		panelLayout.setConstraints(firstPanel, s);
		bottomPanel.add(firstPanel);
		firstPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel numPanel = new JPanel();
		numPanel.setOpaque(false);
		s.gridwidth=1;
		s.weightx = 1; 
		s.weighty=4;
		panelLayout.setConstraints(numPanel, s);
		bottomPanel.add(numPanel);
		numPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel othPanel = new JPanel();
		othPanel.setOpaque(false);
		s.gridwidth=0;
		s.weightx =7; 
		s.weighty=4;
		panelLayout.setConstraints(othPanel, s);
		bottomPanel.add(othPanel);
		othPanel.setBorder(BorderFactory.createTitledBorder(""));
		//设置第一名界面
		firstPanel.setLayout(new GridLayout(1,4));
		JLabel firstIconLabel = new JLabel();
		firstIconLabel.setOpaque(false);
		firstIconLabel.setBorder(BorderFactory.createTitledBorder(""));
		icon =  new ImageIcon(hotInfo[0][3]);
		icon.setImage(icon.getImage().getScaledInstance(width/10, width/8,Image.SCALE_DEFAULT));
		firstIconLabel.setIcon(icon);
		firstIconLabel.setHorizontalAlignment(firstIconLabel.CENTER);
		firstIconLabel.setHorizontalTextPosition(firstIconLabel.CENTER);
		
		firstPanel.add(firstIconLabel);
		
		JLabel firstTemp = new JLabel();
		firstTemp.setOpaque(false);
		firstTemp.setText("1");
		firstTemp.setFont(new Font("宋体",1, 100));
		firstTemp.setHorizontalAlignment(firstIconLabel.RIGHT);
		firstPanel.add(firstTemp);
		
		JPanel firstInfoPanel = new JPanel();
		firstInfoPanel.setOpaque(false);
		firstInfoPanel.setLayout(new GridLayout(5,1));
		firstInfoPanel.add(new JLabel());
		final JLabel firstName = new JLabel();
		firstName.setOpaque(false);
		firstName.setText(hotInfo[0][0]);
		firstName.setFont(new Font("宋体",1, 20));
		firstName.setVerticalAlignment(firstName.BOTTOM);
		firstInfoPanel.add(firstName);
		firstName.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						
							String name = firstName.getText();
							if(panel.getName().equals("当日热点球员")||panel.getName().equals("进步最快球员")||panel.getName().equals("赛季热点球员")){
								PlayerCheckFrame check = new PlayerCheckFrame(name);
								check.setFatherFrame(frame);
							}else if(panel.getName().equals("赛季热点球队")){
								TeamCheckFrame check = new TeamCheckFrame(name);
								check.setFatherFrame(frame);
							}
							AWTUtilities.setWindowOpacity(frame, 0.5f);

					}          
				}
				);    
		
		final JLabel firstTeamName = new JLabel();
		firstTeamName.setOpaque(false);
		firstTeamName.setText(hotInfo[0][2]);
		firstTeamName.setFont(new Font("宋体",0, 10));
		firstTeamName.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						
							String name = firstTeamName.getText();
							if(panel.getName().equals("当日热点球员")||panel.getName().equals("进步最快球员")||panel.getName().equals("赛季热点球员")){
								PlayerCheckFrame check = new PlayerCheckFrame(name);
								check.setFatherFrame(frame);
							}else if(panel.getName().equals("赛季热点球队")){
								TeamCheckFrame check = new TeamCheckFrame(name);
								check.setFatherFrame(frame);
							}
							AWTUtilities.setWindowOpacity(frame, 0.5f);

					}          
				}
				); 
		firstInfoPanel.add(firstTeamName);
		
		JLabel firstInfo = new JLabel();
		firstInfo.setOpaque(false);
		firstInfo.setText(hotInfo[0][1]);
		firstInfo.setFont(new Font("宋体",1, 20));
		firstInfo.setVerticalAlignment(firstName.TOP);
		firstInfoPanel.add(firstInfo);
		
		firstInfoPanel.add(new JLabel());
		
		firstPanel.add(firstInfoPanel);
		
		JLabel firstTeamPanel = new JLabel();
		firstTeamPanel.setOpaque(false);
		firstIconLabel.setBorder(BorderFactory.createTitledBorder(""));
		icon =  new ImageIcon(hotInfo[0][4]);
		icon.setImage(icon.getImage().getScaledInstance(width/16, width/16,Image.SCALE_DEFAULT));
		firstTeamPanel.setIcon(icon);
		firstTeamPanel.setVerticalAlignment(firstTeamPanel.TOP);
		firstPanel.add(firstTeamPanel);
		
		//设置2-5名界面
		othPanel.setLayout(new GridLayout(4,1));
		for(int i = 1;i<5;i++){
			JPanel temp = new JPanel();
			temp.setOpaque(false);
			temp.setLayout(new GridLayout(1,3));
			
			final JLabel tempName = new JLabel();
			tempName.setOpaque(false);
			icon =  new ImageIcon(hotInfo[i][3]);
			icon.setImage(icon.getImage().getScaledInstance(width/40, width/40,Image.SCALE_DEFAULT));
			tempName.setIcon(icon);
			tempName.setText(hotInfo[i][0]);
			tempName.setHorizontalAlignment(firstIconLabel.CENTER);
			tempName.setHorizontalTextPosition(firstIconLabel.RIGHT);
			tempName.setFont(new Font("宋体",0, width/50));
			tempName.addMouseListener(
					new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
						//	selectedRow = Integer.parseInt(e.getComponent().getName());
							
								String name = tempName.getText();
								if(panel.getName().equals("当日热点球员")||panel.getName().equals("进步最快球员")||panel.getName().equals("赛季热点球员")){
									PlayerCheckFrame check = new PlayerCheckFrame(name);
									check.setFatherFrame(frame);
								}else if(panel.getName().equals("赛季热点球队")){
									TeamCheckFrame check = new TeamCheckFrame(name);
									check.setFatherFrame(frame);
								}
								AWTUtilities.setWindowOpacity(frame, 0.5f);

						}          
					}
					); 
			temp.add(tempName);
			
			JLabel tempIcon = new JLabel();
			tempIcon.setOpaque(false);
			icon =  new ImageIcon(hotInfo[i][4]);
			icon.setImage(icon.getImage().getScaledInstance(width/40, width/40,Image.SCALE_DEFAULT));
			tempIcon.setIcon(icon);
			tempIcon.setHorizontalAlignment(firstIconLabel.RIGHT);
			temp.add(tempIcon);
			
			JLabel tempInfo = new JLabel();
			tempInfo.setOpaque(false);
			tempInfo.setText(hotInfo[i][1]);
			tempInfo.setHorizontalAlignment(tempInfo.CENTER);
			temp.add(tempInfo);
			othPanel.add(temp);
		}
		
		
		
		
		
		//设置
		numPanel.setLayout(new GridLayout(4,1));
		numPanel.setBackground(Color.WHITE);
		for(int i = 2;i<6;i++){
			JLabel numLabel = new JLabel();
			numLabel.setOpaque(false);
			numLabel.setText(i+"");
			numLabel.setHorizontalAlignment(lineLabel.CENTER);
			numLabel.setFont(new Font("宋体",1, 25));
			numPanel.add(numLabel);
		}


		mainPanel.repaint();
		mainPanel.revalidate();
//		sp.repaint();
//		this.repaint();
	}
	
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame = frame;
	}
	public static void main(String [] args){
	
	JFrame test = new JFrame();
	test.setSize(972, 500);
	test.setUndecorated(true);
	HotPanel panel = new HotPanel(0,0,972,500);
	//panel.setBackground(Color.decode("#FF0000"));
//	panel.setForeground(Color.decode("#FF0000"));
	panel.setVisible(true);
	test.add(panel);
	test.setVisible(true);
	


	}
}
