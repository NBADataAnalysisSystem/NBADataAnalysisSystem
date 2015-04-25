package ui.dlg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;

@SuppressWarnings("serial")
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
	int rowNum;
	String yearSelected;
	String othSelected;
	String unionSelected;
	String typeSelected;
	JButton submit;
	
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
		year.addItem("2014-2015");
		year.setEditable(false);
		year.setOpaque(false);
		year.setBounds(width/25 + type.getWidth()+width*4/25 ,0, width/5, height/15);
		year.setBackground(Color.WHITE);

		oth = new JComboBox<String>();
		this.add(oth);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		oth.setFont(new Font("Serif",1, 15));
		oth.addItem("进攻");
		oth.addItem("防守");
		oth.addItem("违规");
		oth.addItem("比率");
		oth.addItem("综合数据");
		oth.setEditable(false);
		oth.setOpaque(false);
		oth.setBounds(width/25 + type.getWidth()*2+width*8/25 ,0, width/5, height/15);
		oth.setBackground(Color.WHITE);
		if(oth.getSelectedItem().toString().equals("比率")==false&&oth.getSelectedItem().toString().equals("综合数据")==false){
			oth.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent arg0) {
					if(oth.getSelectedItem().toString().equals("比率")||oth.getSelectedItem().toString().equals("综合数据")){
						panel.remove(type);
						panel.repaint();
					}else if(oth.getSelectedItem().toString().equals("比率")==false&&oth.getSelectedItem().toString().equals("综合数据")==false){
						panel.remove(type);
						panel.add(type);
						//panel.revalidate();
						panel.repaint();
					}
				}   
			});
		}

		
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
		        		if(othSelected.equals("比率")==false&&othSelected.equals("综合数据")==false){
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
		
	}
	
	protected void sift() {
		//根据header 及	yearSelected； othSelected;unionSelected;typeSelected;进行筛选,其实有点多余，直接写在setTableContent里头就行。。。。。
		//暂用
		table = setTableContent(header);
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
		sp.setSize(cellWidth*header.length+20, cellHeight*rowNum);
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
		if(typeSelected.equals("总数")&&othSelected.equals("进攻")){
			header = new String[]{"排名","球队","场数","分钟","控球","得分","出手","命中","罚球出手","罚球命中","三分出手","三分命中","助攻"};
//			header = new String[]{"排名","球队","场数","命中","出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		}else if(typeSelected.equals("总数")&&othSelected.equals("防守")){
//			System.out.println();
			header = new String[]{"排名","球队","场数","分钟","控球","篮板","进攻篮板","防守篮板","抢断","盖帽"};
		}else if(typeSelected.equals("总数")&&othSelected.equals("违规")){
//			System.out.println();
			header = new String[]{"排名","球队","场数","分钟","控球","失误","犯规"};
		}else	if(typeSelected.equals("场均")&&othSelected.equals("进攻")){
			header = new String[]{"排名","球队","场数","分钟","控球","得分","出手","命中","%","罚球出手","罚球命中","罚球%","三分出手","三分命中","三分%","助攻"};
//			header = new String[]{"排名","球队","场数","命中","出手","三分命中","三分出手","罚球命中","罚球出手","进攻篮板","防守篮板","篮板","助攻","抢断","盖帽","失误","犯规","得分"};
		}else if(typeSelected.equals("场均")&&othSelected.equals("防守")){
//			System.out.println();
			header = new String[]{"排名","球队","场数","分钟","控球","篮板","进攻篮板","防守篮板","抢断","盖帽"};
		}else if(typeSelected.equals("场均")&&othSelected.equals("违规")){
//			System.out.println();
			header = new String[]{"排名","球队","场数","分钟","控球","失误","犯规"};
		}else if(othSelected.equals("比率")){
			header = new String[]{"排名","球队","场数","分钟","控球","助攻%","防守%","有效命中%","罚球命中%","罚球出手%","进攻%","防守","进攻","篮板%","失误%"};
		}else if(othSelected.equals("综合数据")){
			header = new String[]{"排名","球队","场数","分钟","控球","命中%-助攻","命中%-非助攻","三分命中%-助攻","三分命中%-非助攻","二分出手%","二分得分%","中距离得分%","三分出手%","三分得分%","罚球得分%","篮下得分"};
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
	TeamAdvancedPanel panel = new TeamAdvancedPanel(0,0,972,500);
	//panel.setBackground(Color.decode("#FF0000"));
	panel.setOpaque(false);
//	panel.setForeground(Color.decode("#FF0000"));
	panel.setVisible(true);
	test.add(panel);
	test.setVisible(true);
	
	
	
	
	
	
}
}
