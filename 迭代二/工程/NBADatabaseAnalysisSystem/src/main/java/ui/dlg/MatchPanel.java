package ui.dlg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

import com.sun.awt.AWTUtilities;

import controller.matchcontroller.GetMatchSectionInfoRequest;
import controller.matchcontroller.GetMatchSectionInfoResponse;
import controller.matchcontroller.MatchController;

@SuppressWarnings("serial")
public class MatchPanel extends JPanel {
	int x;
	int y;
	static int width;
	static int height;
	JPanel datePanel ;
	JPanel mainPanel;
	JTextField dateFindingField;
	JButton btn_Find;
	
	String dateToFind ;
	String dateToShow;
	String[][][] match;
	
	ImageIcon lineIcon;
	JLabel lineLabel;
	JScrollPane sp;
	
	int rowNum;

	@SuppressWarnings("static-access")
	public MatchPanel(int xa,int ya,int widtha,int heighta){
		
		this.x = xa;
		this.y = ya;
		this.width = widtha;
		this.height = heighta;
		this.setBounds(x, y, width, height);
		dateToFind = new String();
		dateToShow = new String();
		//暂用
		dateToShow = "2013-01-01";
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
		dateFindingField.setText("2013-01-01");
		dateFindingField.setBounds(0, datePanel.getHeight()/4, datePanel.getWidth()/5, datePanel.getHeight()/2);
		btn_Find = new JButton("查询");
		btn_Find.setBounds(dateFindingField.getWidth()+20, datePanel.getHeight()/4, datePanel.getWidth()/10, datePanel.getHeight()/2);
		btn_Find.addMouseListener(       new MouseAdapter(){
		
            public void mouseClicked(MouseEvent e){
            	//TODO
            	dateToShow = dateFindingField.getText();
            	findMatch(dateToShow);
            	mainPanel.removeAll();
            	setMatchPanel();

            }    
            public void mousePressed(MouseEvent e){
            	//TODO
            	btn_Find.setForeground(Color.BLUE);

            }
            public void mouseReleased(MouseEvent e){
            	//TODO
            	btn_Find.setForeground(Color.BLACK);

            }
        
	}
		
);
		btn_Find.setOpaque(false);
		btn_Find.setFont(new Font("宋体",1, 20));//设置字体
		btn_Find.setBorderPainted(false);
		btn_Find.setContentAreaFilled(false);
		datePanel.add(dateFindingField);
		datePanel.add(btn_Find);
		datePanel.setOpaque(false);
		
		
		sp = new JScrollPane(mainPanel);
		this.findMatch(dateToShow);
		
		this.setMatchPanel();
		
		mainPanel.setBounds(0, 0, width, height*(match.length+match.length%2)/(rowNum*2));
		GridLayout layout = new GridLayout(0,2);
		mainPanel.setLayout(layout);
		mainPanel.setOpaque(false);
		mainPanel.setPreferredSize(new Dimension(mainPanel.getWidth(),mainPanel.getHeight()));
		sp.setBounds(0,height/10,mainPanel.getWidth(),height*9/10);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		//sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
		this.add(datePanel);
		this.add(sp);
		this.setOpaque(false);
		 Timer t = new Timer(5000,new ActionListener(){
             public void actionPerformed(ActionEvent arg0){
            	 	
            	 	mainPanel.removeAll();
            	 	findMatch(dateToShow);
            	 	setMatchPanel();
     				mainPanel.repaint();
     				mainPanel.revalidate();
     				System.out.println(match.length);
     	
	               }
	           }
				 );
		 t.start();
		
	}
	
	private void setMatchPanel(){
		sp.setBorder(BorderFactory.createTitledBorder(dateToShow));
		//TODO
		for(int i = 0;i< match.length;i++){
			JPanel newMatch = this.setMatch(match[i]);
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

		sp.repaint();
		this.revalidate();
	}
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame  =frame;
	}
	/**
	 * 		//info为比赛数据，[0]为teamA [1]为teamB
		//第二维中,[0]为队名，，[1]~[4]为1-4节分数，[5]为总分，[6]为球队图标地址7ID）
	 * @param date 日期
	 */
	private void findMatch(String date) {
		//TODO
		String[] sift = new String[2];
		sift[0] = date.split("-")[0];
		sift[1] = date.split("-")[1] + "-" + date.split("-")[2];
		MatchController controller = new MatchController();
		GetMatchSectionInfoResponse response = (GetMatchSectionInfoResponse) controller.processRequest(
				new GetMatchSectionInfoRequest(sift));
		ArrayList<String[]> tempList = response.getList();
		match = new String [tempList.size()][2][8];
		for(int i = 0;i<match.length;i++){
			for(int j = 0;j<8;j++){
				match[i][0][j] = tempList.get(i)[j];
				match[i][1][j] = tempList.get(i)[j+8];
			}
		}

	}

	@SuppressWarnings("static-access")
	public JPanel setMatch(final String[][] info){
		//info为比赛数据，[0]为teamA [1]为teamB
		//第二维中,[0]为队名，，[1]~[4]为1-4节分数，[5]为总分，[6]为球队图标地址,[7]为比赛ID）
		JPanel newMatch = new JPanel();
		newMatch.addMouseListener(    new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
					MatchCheckFrame temp = new MatchCheckFrame(info[0][0],info[1][0],info[0][7]);
					temp.setFatherFrame(frame);
					AWTUtilities.setWindowOpacity(frame, 0.5f);
			}	
		});
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints s= new GridBagConstraints();
		s.fill = GridBagConstraints.BOTH; 
		newMatch.setLayout(layout);
		JLabel detail = new JLabel();
		lineIcon.setImage(lineIcon.getImage().getScaledInstance(width/2, height/(rowNum*5),Image.SCALE_DEFAULT));
		detail.setIcon(lineIcon);
		detail.setText("技术分析");
		detail.setHorizontalTextPosition(detail.CENTER);
//		detail.setHorizontalAlignment(0);
		detail.setForeground(Color.WHITE);
		
		s.gridwidth=0;
		s.weightx = 16; 
		s.weighty=1;
		layout.setConstraints(detail, s);
		JLabel teamA = new JLabel();
		ImageIcon teamAIcon = new ImageIcon(info[0][6]);
		teamAIcon.setImage(teamAIcon.getImage().getScaledInstance(width/10, width/10,Image.SCALE_DEFAULT));
		teamA.setIcon(teamAIcon);
		teamA.setText(info[0][0]);
		teamA.setOpaque(false);
		teamA.setHorizontalAlignment(teamA.CENTER);
		teamA.setVerticalTextPosition(teamA.BOTTOM);
		teamA.setHorizontalTextPosition(teamA.CENTER);

		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(teamA, s);
		
		JLabel teamB = new JLabel();
		ImageIcon teamBIcon = new ImageIcon(info[1][6]);
		teamBIcon.setImage(teamBIcon.getImage().getScaledInstance(width/10, width/10,Image.SCALE_DEFAULT));
		teamB.setIcon(teamBIcon);
		teamB.setText(info[1][0]);
		teamB.setOpaque(false);
		teamB.setHorizontalAlignment(teamB.CENTER);
		teamB.setVerticalTextPosition(teamB.BOTTOM);
		teamB.setHorizontalTextPosition(teamB.CENTER);
		if(Integer.parseInt(info[0][5])>Integer.parseInt(info[1][5])){
			teamA.setForeground(Color.RED);
		}else{
			teamB.setForeground(Color.RED);
		}
		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(teamB, s);
		JPanel point = new JPanel();
		point.setOpaque(false);
		s.gridwidth=1;
		s.weightx = 4; 
		s.weighty=4;
		layout.setConstraints(point, s);
		teamA.setBorder(BorderFactory.createTitledBorder(""));
		teamB.setBorder(BorderFactory.createTitledBorder(""));
		detail.setBorder(BorderFactory.createTitledBorder(""));
		point.setBorder(BorderFactory.createTitledBorder(""));
		
		point.setLayout(new GridLayout(0,3));
		//设置比分
		JPanel pointA = new JPanel();
		pointA.setOpaque(false);
		pointA.setLayout(new GridLayout(5,0));
		for(int i = 0;i<5;i++){
			JLabel n = new JLabel(info[0][1+i]);
			n.setOpaque(false);
			n.setHorizontalAlignment(n.RIGHT);
			n.setFont(new Font("宋体",1, 20));
			pointA.add(n);
			if(Integer.parseInt(info[0][1+i])>Integer.parseInt(info[1][1+i])){
				n.setForeground(Color.RED);
			}
		}
		JPanel pointB = new JPanel();
		pointB.setOpaque(false);
		pointB.setLayout(new GridLayout(5,0));
		for(int i = 0;i<5;i++){
			JLabel n = new JLabel(info[1][1+i]);
			n.setOpaque(false);
			n.setHorizontalAlignment(n.LEFT);
			n.setFont(new Font("宋体",1, 20));
			pointB.add(n);
			if(Integer.parseInt(info[1][1+i])>Integer.parseInt(info[0][1+i])){
				n.setForeground(Color.RED);
			}
		}
		JPanel pointT = new JPanel();
		pointT.setLayout(new GridLayout(5,0));
		JLabel n1 = new JLabel("第一节");
		n1.setHorizontalAlignment(n1.CENTER);
		n1.setOpaque(false);
		JLabel n2 = new JLabel("第二节");
		n2.setHorizontalAlignment(n2.CENTER);
		n2.setOpaque(false);
		JLabel n3 = new JLabel("第三节");
		n3.setHorizontalAlignment(n3.CENTER);
		n3.setOpaque(false);
		JLabel n4 = new JLabel("第四节");
		n4.setHorizontalAlignment(n4.CENTER);
		n4.setOpaque(false);
		JLabel n5 = new JLabel("总分");
		n5.setHorizontalAlignment(n5.CENTER);
		n5.setOpaque(false);
		pointT.add(n1);
		pointT.add(n2);
		pointT.add(n3);
		pointT.add(n4);
		pointT.add(n5);
		pointT.setOpaque(false);
		point.add(pointA);
		point.add(pointT);
		point.add(pointB);


		
		newMatch.add(detail);
		newMatch.add(teamA);
		newMatch.add(point);
		newMatch.add(teamB);
		newMatch.setOpaque(false);
		
//		lineLabel = new JLabel();
//		lineLabel.setBounds(0, 0, width, height*(match.length+match.length%2)/(rowNum*2)/5);
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
