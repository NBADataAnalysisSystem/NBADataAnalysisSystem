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

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class HotPanel extends JPanel {
	int x;
	int y;
	static int width;
	static int height;
	JPanel mainPanel;
	
	String[][] dayHotPlayer;
	JRadioButton scoreP;
	JRadioButton reboundP;
	JRadioButton assistP;
	JRadioButton blockShotP;
	JRadioButton stealP;
	ButtonGroup dayHotPlayerBtn;
	
	String[][] seasonHotPlayer;
	JRadioButton aveScoreP;
	JRadioButton aveAssistP;
	JRadioButton aveReboundP;
	JRadioButton aveBlockShotP;
	JRadioButton threePointRateP;
	JRadioButton rateP;
	JRadioButton freeShotRateP;
	ButtonGroup seasonHotPlayerBtn;
	
	String[][] seasonHotTeam;
	
	String[][] improvePlayer;
	
	
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
		
		this.x = xa;
		this.y = ya;
		this.width = widtha;
		this.height = heighta;
		this.setBounds(x, y, width, height);
		
		dayHotPlayerPanel = new JPanel();
		seasonHotPlayerPanel = new JPanel();
		seasonHotTeamPanel	= new JPanel();
		improvePlayerPanel	= new JPanel();

		rowNum = 2;
		this.setLayout(null);
		
		lineIcon = new ImageIcon("resource/Line.png");

		
		mainPanel = new JPanel();
	
		
		sp = new JScrollPane(mainPanel);
		
		dayHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotPlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		seasonHotTeamPanel.setBorder(BorderFactory.createTitledBorder(""));
		improvePlayerPanel.setBorder(BorderFactory.createTitledBorder(""));
		
		
		
		mainPanel.add(dayHotPlayerPanel);
		mainPanel.add(seasonHotPlayerPanel);
		mainPanel.add(seasonHotTeamPanel);
		mainPanel.add(improvePlayerPanel);
		
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
