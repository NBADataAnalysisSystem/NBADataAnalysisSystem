package ui.dlg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

import com.sun.awt.AWTUtilities;

import controller.teamcontroller.GetTeamSeasonAvgBasicInfoRequest;
import controller.teamcontroller.GetTeamSeasonAvgBasicInfoResponse;
import controller.teamcontroller.GetTeamSeasonEffInfoRequest;
import controller.teamcontroller.GetTeamSeasonEffInfoResponse;
import controller.teamcontroller.GetTeamSeasonRateInfoRequest;
import controller.teamcontroller.GetTeamSeasonRateInfoResponse;
import controller.teamcontroller.GetTeamSeasonTotalBasicInfoRequest;
import controller.teamcontroller.GetTeamSeasonTotalBasicInfoResponse;
import controller.teamcontroller.TeamController;
import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;

@SuppressWarnings({ "serial", "restriction" })
public class TeamAdvancedPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	int selectedRow;
	String[] header;
	String[][] table;
	JComboBox<String> year;
	JComboBox<String> oth;
	JComboBox<String> union;
	JComboBox<String> type;
	JComboBox<String> season;
	int rowNum;
	String yearSelected;
	String othSelected;
	String unionSelected;
	String typeSelected;
	String seasonSelected;
	JButton submit;
	String[] sift;
	
	JScrollPane sp;
	MyTableHeaderPanel headerPanel;
	MyTablePanel tablePanel ;
	
	public TeamAdvancedPanel(int x,int y,int widthn,int heightn){
		final JPanel panel = this;
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		rowNum = 12;
		yearSelected = new String();
		sift = new String[4];
		
		
		type = new JComboBox<String>();
		this.add(type);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		type.setFont(new Font("Serif",1, 15));
		type.addItem("总数");
		type.addItem("场均");
		type.setEditable(false);
		type.setOpaque(false);
		type.setBounds(width/25,0,width/5,height/15);
		type.setBackground(Color.WHITE);
		
		
		year = new JComboBox<String>();
		this.add(year);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		year.setFont(new Font("Serif",1, 15));
		year.addItem("2013-2014");
		year.addItem("2012-2013");
		year.setEditable(false);
		year.setOpaque(false);
		year.setBounds(width/25 + type.getWidth()+width*4/25 ,0, width/5, height/15);
		year.setBackground(Color.WHITE);

		oth = new JComboBox<String>();
		this.add(oth);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		oth.setFont(new Font("Serif",1, 15));
		oth.addItem("基础");
		oth.addItem("比率");
		oth.addItem("效率");
		oth.setEditable(false);
		oth.setOpaque(false);
		oth.setBounds(width/25 + type.getWidth()*2+width*8/25 ,0, width/5, height/15);
		oth.setBackground(Color.WHITE);
		if(oth.getSelectedItem().toString().equals("比率")==false&&oth.getSelectedItem().toString().equals("效率")==false){
			oth.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent arg0) {
					if(oth.getSelectedItem().toString().equals("比率")||oth.getSelectedItem().toString().equals("效率")){
						panel.remove(type);
						panel.repaint();
					}else if(oth.getSelectedItem().toString().equals("比率")==false&&oth.getSelectedItem().toString().equals("效率")==false){
						panel.remove(type);
						panel.add(type);
						//panel.revalidate();
						panel.repaint();
					}
				}   
			});
		}
		
		season = new JComboBox<String>();
		this.add(season);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		season.setFont(new Font("Serif",1, 15));
		season.addItem("常规赛");
		season.addItem("季后赛");
		season.addItem("季前赛");
		season.setEditable(false);
		season.setOpaque(false);
		season.setBounds(width/25 ,height/15+10, width/5, height/15);
		season.setBackground(Color.WHITE);

		
		union = new JComboBox<String>();
		this.add(union);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		union.setFont(new Font("Serif",1, 15));
		union.addItem("全部联盟");
		union.addItem("东部");
		union.addItem("大西洋区");
		union.addItem("中央区");
		union.addItem("东南区");
		union.addItem("西部");
		union.addItem("西南区");
		union.addItem("西北区");
		union.addItem("太平洋区");
		union.setEditable(false);
		union.setOpaque(false);
		union.setBounds(width/25 + type.getWidth()+width*4/25 ,height/15+10, width/5, height/15);
		union.setBackground(Color.WHITE);
		
		yearSelected = year.getSelectedItem().toString();
		othSelected = oth.getSelectedItem().toString();
		unionSelected = union.getSelectedItem().toString();
		typeSelected = type.getSelectedItem().toString();
		seasonSelected = season.getSelectedItem().toString();
		
		submit = new JButton();
		submit.setBounds(width/25 + type.getWidth()*2+width*8/25,height/15+10,width/5, height/15);
		submit.setFont(new Font("宋体",1, 20));//设置字体
		submit.setBorderPainted(false);
		submit.setMargin(new Insets(0,0,0,0));
		final JLabel btnChoosedLabel = new JLabel();
		submit.addMouseListener(       new MouseAdapter(){
				public void mouseReleased(MouseEvent e){
					if(panel.getComponentAt(panel.getMousePosition()) == submit){
		        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
		        		yearSelected = year.getSelectedItem().toString();
		        		othSelected = oth.getSelectedItem().toString();
		        		unionSelected = union.getSelectedItem().toString();
		        		seasonSelected = season.getSelectedItem().toString();
		        		if(othSelected.equals("比率")==false&&othSelected.equals("效率")==false){
		        			typeSelected = type.getSelectedItem().toString();
		        		}else{
		        			typeSelected = "oth";
		        		}
		        		
		        		setHeader();
		        		sift();
		        		panel.remove(sp);
		        		setTable(width/25,height/5,(width - width/12)/header.length,((height) - (height/5)-(height/25))/rowNum,header,table);
		        		panel.repaint();
					}
				}
	            public void mouseEntered(MouseEvent e){

	        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
	        		submit.setForeground(Color.decode("#FF0000"));
	            }
	            public void mouseExited(MouseEvent e){
	            	panel.remove(btnChoosedLabel);
	            	submit.setBackground(null);
	            	submit.setForeground(null);
	            }
	            public void mousePressed(MouseEvent e){
	            	
	            	ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButtonP.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
	            	
	            }
	        
		}
);
	//	tempBtn.setOpaque(false);
		submit.setMargin(new Insets(0, 0, 0, 0));
		submit.setText("提交");
		submit.	setContentAreaFilled(false);
		submit.setBorderPainted(false);
		submit.setFocusPainted(false);
		this.setOpaque(false);
		this.add(submit);
		
		setHeader();
		table = setTableContent(header);
		setTable(width/25,height/5,(width - width/12)/header.length,((height) - (height/5)-(height/25))/rowNum,header,table);
		
//		 Timer t = new Timer(5000,new ActionListener(){
//             public void actionPerformed(ActionEvent arg0){
//            	 
//     				sift();
//     				panel.remove(sp);
//     				setTable(width/25,height/5,(width - width/12)/header.length,((height) - (height/5)-(height/25))/rowNum,header,table);
//	        		panel.repaint();
//     				System.out.println(table.length);
//     	
//             			}
//		 			}
//				 );
//		 t.start();
		
	}
	
	protected void sift() {
		//根据header 及	yearSelected； othSelected;unionSelected;typeSelected;进行筛选,其实有点多余，直接写在setTableContent里头就行。。。。。
		//暂用
		sift[0] = yearSelected;
		sift[1] = unionSelected;
		sift[2] = othSelected;
		sift[3] = typeSelected;
		table = setTableContent(header);
	}
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame = frame;
	}

	private void setTable(int x,int y,int cellWidth,int cellHeight,final String[] header,final String[][] table){

		headerPanel  = new MyTableHeaderPanel(1,header.length,1,header.length,cellWidth*header.length,cellHeight);
		tablePanel = new MyTablePanel(table.length,header.length,table.length,header.length,cellWidth*header.length,cellHeight*table.length);
		
		headerPanel.setContent(header);
		tablePanel.setContent(table);
		headerPanel.setPreferredSize(new Dimension(cellWidth*header.length,cellHeight));
		tablePanel.setPreferredSize(new Dimension(cellWidth*header.length,cellHeight*table.length));

		sp= new JScrollPane(tablePanel);
		sp.setColumnHeaderView(headerPanel);
		//sp.getColumnHeader().setSize(headerPanel.getWidth(), headerPanel.getHeight());
		sp.setSize(cellWidth*header.length+20, cellHeight*rowNum);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
//		JPanel temp =this;
		final int tempWidth = cellWidth;
		headerPanel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						selectedRow=Integer.parseInt(e.getComponent().getComponentAt(headerPanel.getMousePosition()).getName());
						for(int i = 0;i<header.length;i++){
							if(header[i].equals("名称")== false){
								int sort = (int) (headerPanel.getMousePosition().getX()/tempWidth);
								sortInfo(sort);
							}
						}
					}          
				}
				);    
		
		tablePanel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						selectedRow=Integer.parseInt(e.getComponent().getComponentAt(tablePanel.getMousePosition()).getName());
						for(int i = 0;i<header.length;i++){
							if(header[i].equals("名称")){
								//System.out.println(tableContent[selectedRow][i]);
								TeamCheckFrame check = new TeamCheckFrame(table[selectedRow][i]);
								check.setFatherFrame(frame);
								AWTUtilities.setWindowOpacity(frame, 0.5f);
							}
						}
					}          
				}
				);    
		sp.setLocation(x,y);
		this.add(sp);
//		System.out.println(mainPanel.getHeight()*2/11);
		tablePanel.setOpaque(false);
		headerPanel.setOpaque(false);
		
		ImageIcon rowIconA ;
		rowIconA = new ImageIcon("resource/PlayerRowA1.png");
		rowIconA.setImage(rowIconA.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon rowIconB ;
		rowIconB = new ImageIcon("resource/PlayerRowB1.png");
		rowIconB.setImage(rowIconB.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon tableHeaderIcon ;
		tableHeaderIcon = new ImageIcon("resource/PlayerHeaderRow1.png");
		tableHeaderIcon.setImage(tableHeaderIcon.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		for(int i = 0; i <table.length;){
			tablePanel.setRowBackground(rowIconA, i++);
			tablePanel.setRowBackground(rowIconB, i++);
	}
		headerPanel.setRowBackground(tableHeaderIcon, 0);
		
		tablePanel.setTableFont(new Font("Serif",0, 12));
		headerPanel.setTableFont(new Font("Serif",1, 10));
		headerPanel.setFontColor(Color.decode("#FFFFFF"));
		
	}
	
	private void setHeader(){
		if(othSelected.equals("基础")&&typeSelected.equals("总数")){
			header = new String[]{"名称","比赛场数","投篮出手","投篮命中","三分出手","三分命中","罚球出手","罚球命中",
					"进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		}else if(othSelected.equals("比率")){
			header = new String[]{"名称","胜率","%","三分%","罚球%"};
		}else if(othSelected.equals("效率")){
			header = new String[]{"名称","进攻回合","防守回合","进攻效率","防守效率","进攻篮板效率","防守篮板效率","抢断效率","助攻率"};
		}else if(othSelected.equals("基础")&&typeSelected.equals("场均")){
			header = new String[]{"名称","比赛场数","投篮出手","投篮命中","三分出手","三分命中","罚球出手","罚球命中",
					"进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		}
	}
	
	private String[][] setTableContent(String[] header){
		if(othSelected.equals("基础")&&typeSelected.equals("总数")){
			TeamController controller = new TeamController();
			GetTeamSeasonTotalBasicInfoResponse getTeamSeasonTotalBasicInfoResponse = 
					(GetTeamSeasonTotalBasicInfoResponse) controller.processRequest(
							new GetTeamSeasonTotalBasicInfoRequest(sift));
			ArrayList<String[]> tempList = getTeamSeasonTotalBasicInfoResponse.getList();
			String[][] content = new String[tempList.size()][header.length];
			int i = 0;
			for (String[] strings:tempList) {
				for (int j = 0; j < strings.length; j++) {
					content[i][j] = strings[j];
				}
				i++;
			}
			return content;
		}else if(othSelected.equals("比率")){
			TeamController controller = new TeamController();
			GetTeamSeasonRateInfoResponse getTeamSeasonRateInfoResponse = 
					(GetTeamSeasonRateInfoResponse) controller.processRequest(
							new GetTeamSeasonRateInfoRequest(sift));
			ArrayList<String[]> tempList = getTeamSeasonRateInfoResponse.getList();
			String[][] content = new String[tempList.size()][header.length];
			int i = 0;
			for (String[] strings:tempList) {
				for (int j = 0; j < strings.length; j++) {
					content[i][j] = strings[j];
				}
				i++;
			}
			return content;
		}else if(othSelected.equals("效率")){
			TeamController controller = new TeamController();
			GetTeamSeasonEffInfoResponse getTeamSeasonEffInfoResponse = 
					(GetTeamSeasonEffInfoResponse) controller.processRequest(
							new GetTeamSeasonEffInfoRequest(sift));
			ArrayList<String[]> tempList = getTeamSeasonEffInfoResponse.getList();
			String[][] content = new String[tempList.size()][header.length];
			int i = 0;
			for (String[] strings:tempList) {
				for (int j = 0; j < strings.length; j++) {
					content[i][j] = strings[j];
				}
				i++;
			}
			return content;
		}else if(othSelected.equals("基础")&&typeSelected.equals("场均")){
			TeamController controller = new TeamController();
			GetTeamSeasonAvgBasicInfoResponse getTeamSeasonAvgBasicInfoResponse = 
					(GetTeamSeasonAvgBasicInfoResponse) controller.processRequest(
							new GetTeamSeasonAvgBasicInfoRequest(sift));
			ArrayList<String[]> tempList = getTeamSeasonAvgBasicInfoResponse.getList();
			String[][] content = new String[tempList.size()][header.length];
			int i = 0;
			for (String[] strings:tempList) {
				for (int j = 0; j < strings.length; j++) {
					content[i][j] = strings[j];
				}
				i++;
			}
			return content;
		}
		return null;
	}

	private void sortInfo(int column){
		JPanel tempPanel = this;
		String[] temp;
		for(int i = 0;i<table.length;i++){
			for(int j = i+1;j<table.length;j++){
				if(Double.valueOf(table[j][column])>Double.valueOf(table[i][column])){
					temp=table[i];
					table[i] = table[j];
					table[j] = temp;
				}
			}
		}
		tempPanel.remove(sp);
		setTable(width/25,height/5,(width - width/12)/header.length,((height) - (height/5)-(height/25))/rowNum,header,table);
		tempPanel.repaint();
		
	}
	public static void main(String [] args){
	
	JFrame test = new JFrame();
	test.setSize(972, 500);
	test.setUndecorated(true);
	TeamAdvancedPanel panel = new TeamAdvancedPanel(0,0,972,500);
	//panel.setBackground(Color.decode("#FF0000"));
	panel.setOpaque(false);
//	panel.setForeground(Color.decode("#FF0000"));
	panel.setVisible(true);
	test.add(panel);
	test.setVisible(true);
	
	
	
	
	
	
}
}
