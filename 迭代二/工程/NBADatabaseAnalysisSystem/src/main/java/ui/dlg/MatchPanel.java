package ui.dlg;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	JPanel datePanel ;
	JPanel mainPanel;
	JTextField dateFindingField;
	JButton btn_Find;
	
	String dateToFind ;
	String dateToShow;
	String[][] match;
	
	ImageIcon lineIcon;
	JLabel lineLabel;
	
	int rowNum;

	public MatchPanel(int xa,int ya,int widtha,int heighta){
		
		this.x = xa;
		this.y = ya;
		this.width = widtha;
		this.height = heighta;
		dateToFind = new String();
		dateToShow = new String();
		//暂用
		dateToShow = "2015-01-01";
		rowNum = 3;
		this.setLayout(null);
		
		lineIcon = new ImageIcon("resource/Line.png");

		
		mainPanel = new JPanel();
		//日期
		datePanel = new JPanel();
		datePanel.setLayout(null);
		datePanel.setBounds(0, 0, width, height/10);
		dateFindingField = new JTextField(15);
		dateFindingField.setFont(new Font("宋体",1, 20));
		dateFindingField.setText("2014-04-01");
		dateFindingField.setBounds(0, datePanel.getHeight()/4, datePanel.getWidth()/5, datePanel.getHeight()/2);
		btn_Find = new JButton("查询");
		btn_Find.setBounds(dateFindingField.getWidth()+20, datePanel.getHeight()/4, datePanel.getWidth()/10, datePanel.getHeight()/2);
		btn_Find.addMouseListener(       new MouseAdapter(){
			
            public void mouseClicked(MouseEvent e){
            	//TODO
            	dateToShow = dateFindingField.getText();
            	setMatchPanel();

            }
        
	}
);
		datePanel.add(dateFindingField);
		datePanel.add(btn_Find);
		
		this.findMatch(dateToShow);
		
		this.setMatchPanel();
		
		mainPanel.setBounds(0, height/10, width, height*(match.length+match.length%2)/(rowNum*2));
		GridLayout layout = new GridLayout(0,2);
		mainPanel.setLayout(layout);
		mainPanel.setOpaque(false);
		this.add(datePanel);
		this.add(mainPanel);
		this.setOpaque(false);
	}
	
	private void setMatchPanel(){
		mainPanel.setBorder(BorderFactory.createTitledBorder(dateToShow));
		//TODO
		for(int i = 0;i< match.length;i++){
			JPanel newMatch = this.setMatch(match[i]);
			newMatch.setBorder(BorderFactory.createTitledBorder(""));
//			lineLabel = new JLabel();
//			lineLabel.setBounds(0, 0, width, height*(match.length+match.length%2)/(rowNum*2)/5);
//			lineIcon.setImage(lineIcon.getImage().getScaledInstance(lineLabel.getWidth(), lineLabel.getHeight(),Image.SCALE_DEFAULT));
//			lineLabel.setIcon(lineIcon);
//			lineLabel.setOpaque(false);
//			mainPanel.add(lineLabel);
			mainPanel.add(newMatch);
		}
		//mainPanel.add(c);
		//TODO
		mainPanel.repaint();
	}
	
	private void findMatch(String date) {
		//TODO
		match = new String [30][6];
	}

	public JPanel setMatch(String[] info){
		JPanel newMatch = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		newMatch.setLayout(layout);
		JLabel detail = new JLabel("技术分析");
		detail.setBackground(Color.BLUE);
		detail.setForeground(Color.BLUE);
		s.gridwidth=0;
		s.weightx = 16; 
		s.weighty=1;
		layout.setConstraints(detail, s);
		JLabel teamA = new JLabel("info[0]");
		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(teamA, s);
		JLabel teamB = new JLabel("info[1]");
		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(teamB, s);
		JLabel point = new JLabel("info[2]");
		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(point, s);
		teamA.setBorder(BorderFactory.createTitledBorder(""));
		teamB.setBorder(BorderFactory.createTitledBorder(""));
		detail.setBorder(BorderFactory.createTitledBorder(""));
		point.setBorder(BorderFactory.createTitledBorder(""));
	
		newMatch.add(detail);
		newMatch.add(teamA);
		newMatch.add(point);
		newMatch.add(teamB);
		newMatch.setOpaque(false);
		return newMatch;
	}
	public static void main(String [] args){
	
	JFrame test = new JFrame();
	test.setSize(972, 500);
	test.setUndecorated(true);
	MatchPanel panel = new MatchPanel(0,0,972,500);
	//panel.setBackground(Color.decode("#FF0000"));
//	panel.setForeground(Color.decode("#FF0000"));
	panel.setVisible(true);
	test.add(panel);
	test.setVisible(true);
	


	}
}
