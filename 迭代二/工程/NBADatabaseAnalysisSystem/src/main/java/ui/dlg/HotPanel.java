package ui.dlg;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class HotPanel extends JPanel {
	int x;
	int y;
	static int width;
	static int height;
	JPanel mainPanel;
	
	String[][] dayHotPlayer;
	JButton scoreP;
	JButton reboundP;
	JButton assistP;
	JButton blockShotP;
	JButton stealP;
	ArrayList<JButton> dayHotPlayerBtn;
	
	String[][] seasonHotPlayer;
	JButton aveScoreP;
	JButton aveAssistP;
	JButton aveReboundP;
	JButton aveBlockShotP;
	JButton threePointRateP;
	JButton rateP;
	JButton freeShotRateP;
	ArrayList<JButton> seasonHotPlayerBtn;
	
	String[][] seasonHotTeam;
	JButton scoreT;
	JButton reboundT;
	JButton assistT;
	JButton blockShotT;
	JButton stealT;
	JButton threePointRateT;
	JButton rateT;
	JButton freeShotRateT;
	ArrayList<JButton> seasonHotTeamBtn;
	
	String[][] improvePlayer;
	JButton aveScoreI;
	JButton aveAssistI;
	JButton aveReboundI;
	ArrayList<JButton> improvePlayerBtn;
	
	ImageIcon lineIcon;
	JLabel lineLabel;
	JScrollPane sp;
	
	JPanel dayHotPlayerPanel;
	JPanel seasonHotPlayerPanel;
	JPanel seasonHotTeamPanel;
	JPanel improvePlayerPanel;
	
	int rowNum;

	@SuppressWarnings("static-access")
	public HotPanel(int xa,int ya,int widtha,int heighta){
		mainPanel = new JPanel();
		
		sp = new JScrollPane(mainPanel);
		this.x = xa;
		this.y = ya;
		this.width = widtha;
		this.height = heighta;
		this.setBounds(x, y, width, height);
		rowNum = 2;
		this.setLayout(null);
		
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
		
		
		aveScoreI = new JButton("场均得分");
		aveAssistI = new JButton("场均助攻");
		aveReboundI = new JButton("场均篮板");
		improvePlayerBtn=  new ArrayList<JButton>();
		improvePlayerBtn.add(aveScoreI);
		improvePlayerBtn.add(aveAssistI);
		improvePlayerBtn.add(aveReboundI);

		
		dayHotPlayerPanel = new JPanel();
		dayHotPlayerPanel.setName("当日热点球员");
		setPanel(dayHotPlayerBtn,dayHotPlayerPanel);
		seasonHotPlayerPanel = new JPanel();
		seasonHotPlayerPanel.setName("赛季热点球员");
		setPanel(seasonHotPlayerBtn,seasonHotPlayerPanel);
		seasonHotTeamPanel = new JPanel();
		seasonHotTeamPanel.setName("赛季热点球队");
		setPanel(seasonHotTeamBtn,seasonHotTeamPanel);
		improvePlayerPanel = new JPanel();
		improvePlayerPanel.setName("进步最快球员");
		setPanel(improvePlayerBtn,improvePlayerPanel);
		
		
		



		
	

		
		dayHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotTeamPanel.setBorder(BorderFactory.createTitledBorder(""));
		improvePlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		
		
//		mainPanel.add(dayHotPlayerPanel);
//		mainPanel.add(seasonHotPlayerPanel);
//		mainPanel.add(seasonHotTeamPanel);
//		mainPanel.add(improvePlayerPanel);
		
		mainPanel.setBounds(0, 0, width, height*4/(rowNum));
		GridLayout layout = new GridLayout(4,1);
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
	
	private void getData(){

	}

	@SuppressWarnings("static-access")
	private void setPanel(ArrayList<JButton> btn,JPanel panel){
		GridBagLayout panelLayout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		
		panel.setLayout(panelLayout);
		JLabel lineLabel = new JLabel();
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
		lineLabel.setBackground(Color.WHITE);
		for(int i = 0;i<btn.size()-1;i++){
			s.gridwidth= 16/btn.size();
			s.weightx = 16/btn.size(); 
			s.weighty=1;
			panelLayout.setConstraints(btn.get(i), s);
			panel.add(btn.get(i));
			btn.get(i).setBorder(BorderFactory.createTitledBorder(""));
		}
		s.gridwidth=0;
		s.weightx = 16/btn.size(); 
		s.weighty=1;
		panelLayout.setConstraints(btn.get(btn.size()-1), s);
		panel.add(btn.get(btn.size()-1));
		btn.get(btn.size()-1).setBorder(BorderFactory.createTitledBorder(""));
		JPanel firstPanel = new JPanel();
		s.gridwidth=8;
		s.weightx = 8; 
		s.weighty=4;
		panelLayout.setConstraints(firstPanel, s);
		panel.add(firstPanel);
		firstPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel numPanel = new JPanel();
		s.gridwidth=1;
		s.weightx =1; 
		s.weighty=4;
		panelLayout.setConstraints(numPanel, s);
		panel.add(numPanel);
		numPanel.setBorder(BorderFactory.createTitledBorder(""));
		JPanel othPanel = new JPanel();
		s.gridwidth=7;
		s.weightx =7; 
		s.weighty=4;
		panelLayout.setConstraints(othPanel, s);
		panel.add(othPanel);
		othPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		//设置
		numPanel.setLayout(new GridLayout(4,1));
		numPanel.setBackground(Color.WHITE);
		for(int i = 2;i<6;i++){
			JLabel numLabel = new JLabel();
			numLabel.setText(i+"");
			numLabel.setHorizontalAlignment(lineLabel.CENTER);
			numLabel.setFont(new Font("宋体",1, 25));
			numPanel.add(numLabel);
		}

		mainPanel.add(panel);
		mainPanel.repaint();
		sp.repaint();
		this.repaint();
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
