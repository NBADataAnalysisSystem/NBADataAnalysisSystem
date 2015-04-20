package ui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;

public class PlayerDetailInfo extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 5980271968002702909L;
	//设置窗体大小
	private int height=0;
	private int width=0;
	private int tableHeight;
	private int tableWidth;
	private int cellHeight;
	private int cellWidth;
	private int x;
	private int y;
	
	private JPanel tablePanel;
	private JPanel MatchtablePanel;
	private JPanel TotaltablePanel;
	private JPanel backPanel;
	public JScrollPane sp;
	
	public MyTablePanel table;
	public MyTableHeaderPanel tableHeaderList;
	
	
	private String[] tableHeader;
	private String[][] tableContent;
	
	private String[][] MatchtableContent;
	
	
	JButton j1;
	JLabel j2;
	JLabel j3;
	JLabel j4;
	JLabel j5;
	JLabel j6;
	JLabel j7;
	JLabel j8;
	JLabel j9;
	JLabel j10;
	JLabel j11;
	JLabel j12;
	JLabel j13;
	JLabel j14;
	JLabel j15;
	JLabel j16;
	JLabel j17;
	JLabel j18;
	JLabel j19;
	JLabel j20;
	JButton j21;
	JLabel j22;
	JLabel j23;
	JLabel j24;
	JLabel j25;
	
	public PlayerDetailInfo(){
		
		backPanel = new JPanel();
		
		height = Toolkit.getDefaultToolkit().getScreenSize().height*4/5;
		width = Toolkit.getDefaultToolkit().getScreenSize().width*1/2;
		//设置Frame原点d
		x=(Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
		y=(Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
		
		this.setSize(width, height);
		this.setLocation(x,y);
		this.setUndecorated(true );
		this.setLayout(null);
        
		backPanel.setSize(width,height);
		backPanel.setLayout(null);
	
		JLabel placeBackgroundIcon = new JLabel();
		placeBackgroundIcon.setBounds(0, 0,backPanel.getWidth() , backPanel.getHeight());
		
		JButton closeButton = new JButton("×");
		closeButton.setMargin(new Insets(0,0,0,0));
		closeButton.setBounds(685,0,30, 30);
		closeButton.addActionListener(this);
		closeButton.setName("close");
		
		
		closeButton.setContentAreaFilled(false);
		closeButton.setForeground(Color.decode("#3A5FCD"));
		closeButton.setFont(new Font("Serif",0, 30));//设置字体
		backPanel.add(closeButton);
			
		j1 = new JButton();
		
		j1.setBounds(30,30, 150, 300);
		j1.setBorderPainted(false);
		j1.setContentAreaFilled(false);
		j1.setOpaque(false);
		j1.setIcon(new ImageIcon("resource/backgroundOfPlayerChecking.png"));//存放图片路径
		backPanel.add(j1, 0);
		
		j2 = new JLabel("球员姓名");
		j2.setFont(new Font("宋体",1, 20));//设置字体
		j2.setBounds(220, 40, 100, 50);
		j2.setOpaque(false);
		backPanel.add(j2);
	    
		j3 = new JLabel("aaa   ");//aaa调用方法传入名字的string
		j3.setFont(new Font("宋体",1, 20));
		j3.setBounds(340, 40, 200, 50);
		j3.setOpaque(false);
		backPanel.add(j3);
		
		j4 = new JLabel("球衣号码");
		j4.setFont(new Font("宋体",1, 20));//设置字体
		j4.setBounds(220, 70, 100, 50);
		j4.setOpaque(false);
		backPanel.add(j4);
	    
		j5 = new JLabel("aaa   ");//aaa调用方法传入号码
		j5.setFont(new Font("宋体",1, 20));
		j5.setBounds(340, 70, 200, 50);
		j5.setOpaque(false);
		backPanel.add(j5);
		
		j6 = new JLabel("球员位置");
		j6.setFont(new Font("宋体",1, 20));//设置字体
		j6.setBounds(220, 100, 100, 50);
		j6.setOpaque(false);
		backPanel.add(j6);
	    
		j7 = new JLabel("aaa   ");//aaa调用方法传入
		j7.setFont(new Font("宋体",1, 20));
		j7.setBounds(340, 100, 200, 50);
		j7.setOpaque(false);
		backPanel.add(j7);
		
		j8 = new JLabel("身高");
		j8.setFont(new Font("宋体",1, 20));//设置字体
		j8.setBounds(220, 130, 100, 50);
		j8.setOpaque(false);
		backPanel.add(j8);
	    
		j9 = new JLabel("aaa   ");//aaa调用方法传入
		j9.setFont(new Font("宋体",1, 20));
		j9.setBounds(340, 130, 200, 50);
		j9.setOpaque(false);
		backPanel.add(j9);
		
		j10 = new JLabel("体重");
		j10.setFont(new Font("宋体",1, 20));//设置字体
		j10.setBounds(220, 160, 100, 50);
		j10.setOpaque(false);
		backPanel.add(j10);
	    
		j11 = new JLabel("aaa   ");//aaa调用方法传入
		j11.setFont(new Font("宋体",1, 20));
		j11.setBounds(340, 160, 200, 50);
		j11.setOpaque(false);
		backPanel.add(j11);
		
		j12 = new JLabel("生日");
		j12.setFont(new Font("宋体",1, 20));//设置字体
		j12.setBounds(220, 190, 100, 50);
		j12.setOpaque(false);
		backPanel.add(j12);
	    
		j13 = new JLabel("aaa   ");//aaa调用方法传入
		j13.setFont(new Font("宋体",1, 20));
		j13.setBounds(340, 190, 200, 50);
		j13.setOpaque(false);
		backPanel.add(j13);
		
		j14 = new JLabel("年龄");
		j14.setFont(new Font("宋体",1, 20));//设置字体
		j14.setBounds(220, 220, 100, 50);
		j14.setOpaque(false);
		backPanel.add(j14);
	    
		j15 = new JLabel("aaa   ");//aaa调用方法传入
		j15.setFont(new Font("宋体",1, 20));
		j15.setBounds(340, 220, 200, 50);
		j15.setOpaque(false);
		backPanel.add(j15);
		
		j16 = new JLabel("球龄");
		j16.setFont(new Font("宋体",1, 20));//设置字体
		j16.setBounds(220, 250, 100, 50);
		j16.setOpaque(false);
		backPanel.add(j16);
	    
		j17 = new JLabel("aaa   ");//aaa调用方法传入
		j17.setFont(new Font("宋体",1, 20));
		j17.setBounds(340, 250, 200, 50);
		j17.setOpaque(false);
		backPanel.add(j17);
		
		j18 = new JLabel("毕业学校");
		j18.setFont(new Font("宋体",1, 20));//设置字体
		j18.setBounds(220, 280, 100, 50);
		j18.setOpaque(false);
		backPanel.add(j18);
	    
		j19 = new JLabel("aaa   ");//aaa调用方法传入
		j19.setFont(new Font("宋体",1, 20));
		j19.setBounds(340, 280, 200, 50);
		j19.setOpaque(false);
		backPanel.add(j19);
		
		j20 = new JLabel("所属球队");
		j20.setFont(new Font("宋体",1, 20));//设置字体
		j20.setBounds(540, 50, 100, 50);
		j20.setOpaque(false);
		backPanel.add(j20);
		
		j21 = new JButton();
		j21.setBounds(510,100, 150, 150);
		j21.setBorderPainted(false);
		j21.setContentAreaFilled(false);
		j21.setOpaque(false);
		j21.setIcon(new ImageIcon("resource/backgroundOfPlayerChecking.png"));//存放图片路径
		backPanel.add(j21, 0);
		
		j22 = new JLabel("aaa");
		j22.setFont(new Font("宋体",1, 20));//设置字体
		j22.setBounds(540, 240, 100, 50);
		j22.setOpaque(false);
		backPanel.add(j22);
		
		j23 = new JLabel("赛季平均数据:");
		j23.setFont(new Font("宋体",1, 20));//设置字体
		j23.setBounds(10, 320, 150, 50);
		j23.setOpaque(false);
		backPanel.add(j23);
		
		j24 = new JLabel("赛季总数据:");
		j24.setFont(new Font("宋体",1, 20));//设置字体
		j24.setBounds(10, 420, 150, 50);
		j24.setOpaque(false);
		backPanel.add(j24);
		
		j25 = new JLabel("近期比赛数据:");
		j25.setFont(new Font("宋体",1, 20));//设置字体
		j25.setBounds(10, 520, 150, 50);
		j25.setOpaque(false);
		backPanel.add(j25);
		
		tableContent = new String[1][27];
	
		tableContent[0][0]="参赛场数";
		tableContent[0][1]="先发场数";
		tableContent[0][2]="篮板数";
		tableContent[0][3]="助攻数";
		tableContent[0][4]="在场时间";
		tableContent[0][5]="投篮命中率";
		tableContent[0][6]="三分命中率";
		tableContent[0][7]="罚球命中率";
		tableContent[0][8]="进攻数";
		tableContent[0][9]="防守数";
		tableContent[0][10]="抢断数";
		tableContent[0][11]="盖帽数";
		tableContent[0][12]="失误数";
		tableContent[0][13]="犯规数";
		tableContent[0][14]="得分";
		tableContent[0][15]="效率";
		tableContent[0][16]="GmSc效率值";
		tableContent[0][17]="真实命中率";
		tableContent[0][18]="投篮效率";
		tableContent[0][19]="篮板率";
		tableContent[0][20]="进攻篮板率";
		tableContent[0][21]="防守篮板率";
		tableContent[0][22]="助攻率";
		tableContent[0][23]="抢断率";
		tableContent[0][24]="盖帽率";
		tableContent[0][25]="失误率";
		tableContent[0][26]="使用率";
		
		
		
		tableHeader = new String[27];
		tableHeader = tableContent[0];
		

		
		setTablePanel();
		tablePanel.setBounds(0, 325, 1000, 250);
		
		backPanel.add(tablePanel);
	
		backPanel.add(placeBackgroundIcon);
		
		setTotalTablePanel();
		TotaltablePanel.setBounds(0, 425, 1000, 250);
		
		backPanel.add(TotaltablePanel);
	
		backPanel.add(placeBackgroundIcon);
		
		setMatchTablePanel();
		MatchtablePanel.setBounds(0, 525, 800, 300);
		backPanel.add(MatchtablePanel);
		
		backPanel.add(placeBackgroundIcon);
		
		
		this.add(backPanel);
		this.setVisible(true);
//		backgroundPanel.setBackground(Color.blue);
	
	}
	
	public void setTablePanel() {

		tablePanel = new JPanel();
		tablePanel.setSize(width, height*1/3);
		
		tableHeight = tablePanel.getHeight()*1/4;
		tableWidth = tablePanel.getWidth()+15;
		
		cellHeight = tableHeight/3;
		cellWidth = tableWidth/6;
		
		buidTablePanel(tableContent[0].length,tableHeader.length,10,6);
		
		tablePanel.setLayout(null);
		tablePanel.add(sp);
		
		sp.setLocation((tablePanel.getWidth()-sp.getWidth())/10, (tablePanel.getHeight())-tablePanel.getHeight()*4/5);
//		sp.setLocation((tablePanel.getWidth()-sp.getWidth())/2, (tablePanel.getHeight()-sp.getHeight())/2);
//		tablePanel.setLocation(0,btnPanel.getHeight());
		tablePanel.setOpaque(false);
		tableHeaderList.setOpaque(false);
		
		//设置表格背景
		ImageIcon rowIconA ;
		rowIconA = new ImageIcon("resource/PlayerRowA.png");
		rowIconA.setImage(rowIconA.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon rowIconB ;
		rowIconB = new ImageIcon("resource/PlayerRowB.png");
		rowIconB.setImage(rowIconB.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon tableHeaderIcon ;
		tableHeaderIcon = new ImageIcon("resource/PlayerHeaderRow.png");
		tableHeaderIcon.setImage(tableHeaderIcon.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		for(int i = 0; i <tableContent.length;){
			table.setRowBackground(rowIconA, i++);
			table.setRowBackground(rowIconB, i++);
	}
		tableHeaderList.setRowBackground(tableHeaderIcon, 0);
		
		table.setTableFont(new Font("Serif",0, 15));
		tableHeaderList.setTableFont(new Font("Serif",1, 15));
		tableHeaderList.setFontColor(Color.decode("#FFFFFF"));

		
	}

	public void buidTablePanel(int allRow, int allColumn, int pageRow,
			int pageColumn) {
		//设置表头
		tableHeaderList = new MyTableHeaderPanel(1,allColumn,1,allColumn,cellWidth*allColumn,cellHeight);
		tableHeaderList.setContent(tableHeader);
		
		//testHeader.setLocation(0, 0);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		tableHeaderList.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight));
//		tableHeaderList.setRowBackground(iconT, 0);
		//设置表格
		table = new MyTablePanel(allRow,allColumn,allRow,allColumn,cellWidth*allColumn,cellHeight*allRow);
//		table.setContent(tableContent);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		table.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight*allRow));
		//设置JSCROLLPANE
		sp = new JScrollPane(table);
		sp.setColumnHeaderView(tableHeaderList);
		sp.setSize(tableWidth, tableHeight);
//	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
			
		
	}
	public void setTotalTablePanel() {

		TotaltablePanel = new JPanel();
		TotaltablePanel.setSize(width, height*1/3);
		
		tableHeight = TotaltablePanel.getHeight()*1/4;
		tableWidth = TotaltablePanel.getWidth()+15;
		
		cellHeight = tableHeight/3;
		cellWidth = tableWidth/6;
		
		buidTablePanel(tableContent[0].length,tableHeader.length,10,6);
		
		TotaltablePanel.setLayout(null);
		TotaltablePanel.add(sp);
		
		sp.setLocation((TotaltablePanel.getWidth()-sp.getWidth())/10, (TotaltablePanel.getHeight())-TotaltablePanel.getHeight()*4/5);
//		sp.setLocation((tablePanel.getWidth()-sp.getWidth())/2, (tablePanel.getHeight()-sp.getHeight())/2);
//		tablePanel.setLocation(0,btnPanel.getHeight());
		TotaltablePanel.setOpaque(false);
		tableHeaderList.setOpaque(false);
		
		//设置表格背景
		ImageIcon rowIconA ;
		rowIconA = new ImageIcon("resource/PlayerRowA.png");
		rowIconA.setImage(rowIconA.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon rowIconB ;
		rowIconB = new ImageIcon("resource/PlayerRowB.png");
		rowIconB.setImage(rowIconB.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon tableHeaderIcon ;
		tableHeaderIcon = new ImageIcon("resource/PlayerHeaderRow.png");
		tableHeaderIcon.setImage(tableHeaderIcon.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		for(int i = 0; i <tableContent.length;){
			table.setRowBackground(rowIconA, i++);
			table.setRowBackground(rowIconB, i++);
	}
		tableHeaderList.setRowBackground(tableHeaderIcon, 0);
		
		table.setTableFont(new Font("Serif",0, 15));
		tableHeaderList.setTableFont(new Font("Serif",1, 15));
		tableHeaderList.setFontColor(Color.decode("#FFFFFF"));

		
	}

	public void buidTatalTablePanel(int allRow, int allColumn, int pageRow,
			int pageColumn) {
		//设置表头
		tableHeaderList = new MyTableHeaderPanel(1,allColumn,1,allColumn,cellWidth*allColumn,cellHeight);
		tableHeaderList.setContent(tableHeader);
		//testHeader.setLocation(0, 0);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		tableHeaderList.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight));
//		tableHeaderList.setRowBackground(iconT, 0);
		//设置表格
		table = new MyTablePanel(allRow,allColumn,allRow,allColumn,cellWidth*allColumn,cellHeight*allRow);
	//	table.setContent(tableContent);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		table.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight*allRow));
		//设置JSCROLLPANE
		sp = new JScrollPane(table);
		sp.setColumnHeaderView(tableHeaderList);
		sp.setSize(tableWidth, tableHeight);
//	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
			
		
	}
	


	
	public void setMatchTablePanel() {
		
		MatchtableContent = new String[5][27];
		MatchtableContent[0][0]="比赛时间";
		MatchtableContent[0][1]="比赛对手";
		MatchtableContent[0][2]="篮板数";
		MatchtableContent[0][3]="助攻数";
		MatchtableContent[0][4]="在场时间";
		MatchtableContent[0][5]="投篮命中率";
		MatchtableContent[0][6]="三分命中率";
		MatchtableContent[0][7]="罚球命中率";
		MatchtableContent[0][8]="进攻数";
		MatchtableContent[0][9]="防守数";
		MatchtableContent[0][10]="抢断数";
		MatchtableContent[0][11]="盖帽数";
		MatchtableContent[0][12]="失误数";
		MatchtableContent[0][13]="犯规数";
		MatchtableContent[0][14]="得分";
		MatchtableContent[0][15]="效率";
		MatchtableContent[0][16]="GmSc效率值";
		MatchtableContent[0][17]="真实命中率";
		MatchtableContent[0][18]="投篮效率";
		MatchtableContent[0][19]="篮板率";
		MatchtableContent[0][20]="进攻篮板率";
		MatchtableContent[0][21]="防守篮板率";
		MatchtableContent[0][22]="助攻率";
		MatchtableContent[0][23]="抢断率";
		MatchtableContent[0][24]="盖帽率";
		MatchtableContent[0][25]="失误率";
		MatchtableContent[0][26]="使用率";
		
		
		
		tableHeader = new String[27];
		tableHeader = MatchtableContent[0];
		

		MatchtablePanel = new JPanel();
		MatchtablePanel.setSize(width, height*1/3);
		
		tableHeight = MatchtablePanel.getHeight()*1/2+25;
		tableWidth = MatchtablePanel.getWidth();
		
		cellHeight = tableHeight/5;
		cellWidth = tableWidth/6;
		
		buidTablePanel(MatchtableContent[0].length,tableHeader.length,10,6);
		
		MatchtablePanel.setLayout(null);
		MatchtablePanel.add(sp);
		
		sp.setLocation((MatchtablePanel.getWidth()-sp.getWidth())/10, (MatchtablePanel.getHeight())-MatchtablePanel.getHeight()*4/5);
//		sp.setLocation((tablePanel.getWidth()-sp.getWidth())/2, (tablePanel.getHeight()-sp.getHeight())/2);
//		tablePanel.setLocation(0,btnPanel.getHeight());
		MatchtablePanel.setOpaque(false);
		tableHeaderList.setOpaque(false);
		
		//设置表格背景
		ImageIcon rowIconA ;
		rowIconA = new ImageIcon("resource/PlayerRowA.png");
		rowIconA.setImage(rowIconA.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon rowIconB ;
		rowIconB = new ImageIcon("resource/PlayerRowB.png");
		rowIconB.setImage(rowIconB.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		ImageIcon tableHeaderIcon ;
		tableHeaderIcon = new ImageIcon("resource/PlayerHeaderRow.png");
		tableHeaderIcon.setImage(tableHeaderIcon.getImage().getScaledInstance(cellWidth, cellHeight,Image.SCALE_DEFAULT));
		
		for(int i = 0; i <MatchtableContent.length;){
			table.setRowBackground(rowIconA, i++);
			table.setRowBackground(rowIconB, i++);
	}
		tableHeaderList.setRowBackground(tableHeaderIcon, 0);
		
		table.setTableFont(new Font("Serif",0, 15));
		tableHeaderList.setTableFont(new Font("Serif",1, 15));
		tableHeaderList.setFontColor(Color.decode("#FFFFFF"));

		
	}

	public void buidMatchTablePanel(int allRow, int allColumn, int pageRow,
			int pageColumn) {
		//设置表头
		tableHeaderList = new MyTableHeaderPanel(1,allColumn,1,allColumn,cellWidth*allColumn,cellHeight);
		tableHeaderList.setContent(tableHeader);
		//testHeader.setLocation(0, 0);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		tableHeaderList.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight));
//		tableHeaderList.setRowBackground(iconT, 0);
		//设置表格
		table = new MyTablePanel(allRow,allColumn,allRow,allColumn,cellWidth*allColumn,cellHeight*allRow);
//		table.setContent(tableContent);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		table.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight*allRow));
		//设置JSCROLLPANE
		sp = new JScrollPane(table);
		sp.setColumnHeaderView(tableHeaderList);
		sp.setSize(tableWidth, tableHeight);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
			
		
	}
	

	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		PlayerDetailInfo test = new PlayerDetailInfo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}
		}
	}

	



}
