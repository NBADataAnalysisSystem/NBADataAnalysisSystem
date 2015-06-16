package ui.dlg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;

@SuppressWarnings("serial")
public class TeamInfoPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	int selectedRow;
	String[] header;
	String[][] table;
	JComboBox<String> year;
	JRadioButton typeAve;
	JRadioButton typeAll;
	ButtonGroup type;
	int rowNum;
	String yearSelected;
	JButton submit;
	
	JScrollPane sp;
	MyTableHeaderPanel headerPanel;
	MyTablePanel tablePanel ;
	
	public TeamInfoPanel(int x,int y,int widthn,int heightn){
		final JPanel panel = this;
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		rowNum = 12;
		yearSelected = new String();
		
		typeAll = new JRadioButton("总数");
		typeAve = new JRadioButton("平均");
		typeAll.setBounds(width/25,0,width/10,height/20);
		typeAll.setFont(new Font("微软雅黑",1, 15));
		typeAll.setOpaque(false);
		typeAll.setMargin(new Insets(0, 0, 0, 0));
		typeAll.setBorderPainted(false);
		typeAll.setContentAreaFilled(false);
		typeAll.setBorderPainted(false);
//		typeAll.setFocusPainted(false);
		typeAve.setBounds(width/25,typeAll.getHeight(),width/10,height/20);
		typeAve.setFont(new Font("微软雅黑",1, 15));
		typeAve.setOpaque(false);
		typeAve.setMargin(new Insets(0, 0, 0, 0));
		typeAve.setBorderPainted(false);
		typeAve.setContentAreaFilled(false);
		typeAve.setBorderPainted(false);
		typeAve.setFocusPainted(false);
		type = new ButtonGroup();
		type.add(typeAll);
		type.add(typeAve);
		typeAve.setSelected(true);
		
		typeAve.addMouseListener(     new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					setHeader();
					table = setTableContent(header);
					panel.remove(sp);
					setTable(width/25,height/10,(width - width/12)/header.length,((height) - (height/10)-(height/25))/rowNum,header,table);
				}	
			}
		);
		typeAll.addMouseListener(     new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				setHeader();
				table = setTableContent(header);
				panel.remove(sp);
				setTable(width/25,height/10,(width - width/12)/header.length,((height) - (height/10)-(height/25))/rowNum,header,table);
			}	
		}
	);
		this.add(typeAll);
		this.add(typeAve);
		
		setHeader();
		table = setTableContent(header);
		setTable(width/25,height/10,(width - width/12)/header.length,((height) - (height/10)-(height/25))/rowNum,header,table);
		
		year = new JComboBox<String>();
		this.add(year);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		year.setFont(new Font("Serif",1, 15));
		year.addItem("2013-2014");
		year.addItem("2014-2015");
		year.setEditable(false);
		year.setOpaque(false);
		year.setBounds(width-width/10 - 200 - 40 ,0, 200, height/15);
		year.setBackground(Color.WHITE);

		submit = new JButton();
		submit.setBounds(width-width/10,0,width/10, height/15);
		submit.setFont(new Font("微软雅黑",1, 20));//设置字体
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
		        		sift();
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
		
	}
	
	protected void sift() {
		// TODO Auto-generated method stub
		
	}

	private void setTable(int x,int y,int cellWidth,int cellHeight,String[] header,String[][] table){

		headerPanel  = new MyTableHeaderPanel(1,header.length,1,header.length,cellWidth*header.length,cellHeight);
		tablePanel = new MyTablePanel(table.length,header.length,table.length,header.length,cellWidth*header.length,cellHeight*table.length);
		
		headerPanel.setContent(header);
		tablePanel.setContent(table);
		headerPanel.setPreferredSize(new Dimension(cellWidth*header.length,cellHeight));
		tablePanel.setPreferredSize(new Dimension(cellWidth*header.length,cellHeight*table.length));

		sp= new JScrollPane(tablePanel);
		sp.setColumnHeaderView(headerPanel);
		//sp.getColumnHeader().setSize(headerPanel.getWidth(), headerPanel.getHeight());
		sp.setSize(cellWidth*header.length+cellWidth/3+5, cellHeight*rowNum);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
		
		tablePanel.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						
						selectedRow=Integer.parseInt(e.getComponent().getComponentAt(tablePanel.getMousePosition()).getName());
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
		if(typeAll.isSelected()){
			header = new String[]{"排名","球队","场数","命中","出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		}else{
//			System.out.println();
			header = new String[]{"排名","球队","场数","%","三分%","罚球%","进攻篮板","防守篮板","场均篮板","场均助攻","场均抢断","场均盖帽","失误","犯规","场均得分"};
		}
	}
	
	private String[][] setTableContent(String[] header){
		//根据header获取列表信息，其中一维表示二维所代表的分区下的球队,@Dalec Gu
		String[][] content = new String[30][header.length];
		
		return content;
	}

	public static void main(String [] args){
	
	JFrame test = new JFrame();
	test.setSize(972, 500);
	test.setUndecorated(true);
	TeamInfoPanel panel = new TeamInfoPanel(0,0,972,500);
	//panel.setBackground(Color.decode("#FF0000"));
	panel.setOpaque(false);
//	panel.setForeground(Color.decode("#FF0000"));
	panel.setVisible(true);
	test.add(panel);
	test.setVisible(true);
	
	
	
	
	
	
}
}
