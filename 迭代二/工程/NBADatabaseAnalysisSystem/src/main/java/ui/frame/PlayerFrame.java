package ui.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

import com.sun.awt.AWTUtilities;

import controller.playercontroller.GetPlayerRequest;
import controller.playercontroller.GetPlayerResponse;
import controller.playercontroller.PlayerController;
import entity.PlayerEntity;
import ui.component.MyTableHeaderPanel;
import ui.component.MyTablePanel;
import ui.dlg.AdditionOfPlayerInfo;

public class PlayerFrame extends JFrame implements FrameInterface, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980271968002702909L;
	private static Point origin = new Point();
	//设置窗体大小
	private int height=0;
	private int width=0;
	private int tableHeight;
	private int tableWidth;
	private int cellHeight;
	private int cellWidth;
	private int x;
	private int y;
	
	private JPanel btnPanel;
	private JPanel tablePanel;
	private JPanel backgroundPanel;
	public JScrollPane sp;
	int selectedRow = -1;
	
	public MyTablePanel table ;
	public MyTableHeaderPanel tableHeaderList;
	
	@SuppressWarnings("unused")
	private JButton btn_add;
	@SuppressWarnings("unused")
	private JButton btn_sift;
	@SuppressWarnings("unused")
	private JButton btn_close;
	@SuppressWarnings("unused")
	private JButton btn_reduce;
	@SuppressWarnings("unused")
	private JButton btn_back;
	
	ArrayList<String> temp= new ArrayList<String>();;
	private String[] tableHeader;
	private String[][] tableContent;
	
	public PlayerFrame(){
		
		backgroundPanel = new JPanel();
		tablePanel = new JPanel();
		height = Toolkit.getDefaultToolkit().getScreenSize().height*3/4;
		width = Toolkit.getDefaultToolkit().getScreenSize().width*3/4;
		//设置Frame原点d
		x=(Toolkit.getDefaultToolkit().getScreenSize().width-width)/2;
		y=(Toolkit.getDefaultToolkit().getScreenSize().height-height)/2;
		this.setUndecorated(true);
		this.setSize(width, height);
		this.setLocation(x,y);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		backgroundPanel.setSize(width,height);
		backgroundPanel.setLayout(null);

		//设置背景图片
		ImageIcon background ;
		background = new ImageIcon("resource/backgroundOfPlayerChecking.png");
		background.setImage(background.getImage().getScaledInstance(backgroundPanel.getWidth(), backgroundPanel.getHeight(),Image.SCALE_DEFAULT));
		
		JLabel placeBackgroundIcon = new JLabel();
		placeBackgroundIcon.setIcon(background);
		placeBackgroundIcon.setBounds(0, 0,backgroundPanel.getWidth() , backgroundPanel.getHeight());
		placeBackgroundIcon.setOpaque(false);

		//TODO 测试用内容
//		tableContent = new String[30][30];
////		for(int i = 0; i < 30; i++){
////			for(int j = 0; j < 30; j++){
////				tableContent[i][j] = new String(i + "  " + j);
////			}
////		}
//		tableHeader = new String[30];
		
		
		this. addMouseListener( 
		        new MouseAdapter(){
		            public void mousePressed(MouseEvent e){
		              origin.x = e.getX();
		              origin.y = e.getY();
		            }

//		            public void mouseReleased(MouseEvent e) {
//		              ( (MouseListener) this).mouseReleased(e);
//		            }
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
		
		     // setList(null);

		      setBtnPanel();
		      setList(temp);
		      refreshData();
		      
		      setTablePanel();
		      
		      backgroundPanel.add(btnPanel);
		      backgroundPanel.add(tablePanel);
		      backgroundPanel.add(placeBackgroundIcon);
		      this.add(backgroundPanel);
		      this.setVisible(true);
		      
	}
	//设置主要按钮
	public void setBtnPanel() {

		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setSize(width, height/10);
		btnPanel.setLocation(0,0);
		btnPanel.setOpaque(false);
		
		JButton btn_Add = new JButton("自定义");
		btn_Add.setName("add");
		btn_Add.addActionListener(this);

		btn_Add.setContentAreaFilled(false);
		btn_Add.setForeground(Color.decode("#FF0000"));
		btn_Add.setFont(new Font("宋体",1, 20));//设置字体
		btnPanel.add(btn_Add);
		btn_Add.setBounds(20,(btnPanel.getHeight())/2-10,100,30);
		
		JButton btn_Sift = new JButton("筛  选");
		btn_Sift.setName("sift");
		btn_Sift.addActionListener(this);

		btn_Sift.setContentAreaFilled(false);
		btn_Sift.setForeground(Color.decode("#FF0000"));
		btn_Sift.setFont(new Font("宋体",1, 20));//设置字体
		btnPanel.add(btn_Sift);
		btn_Sift.setBounds(btn_Add.getWidth()+btn_Add.getX()+20,(btnPanel.getHeight())/2-10,100,30);
		
		JButton btn_Close = new JButton("×");
		btn_Close.setMargin(new Insets(0,0,0,0));
		btn_Close.setBounds(btnPanel.getWidth()-50,(btnPanel.getHeight())/2-10,30, 30);
		btn_Close.addActionListener(this);
		btn_Close.setName("close");
		
		
		btn_Close.setContentAreaFilled(false);
		btn_Close.setForeground(Color.decode("#3A5FCD"));
		btn_Close.setFont(new Font("Serif",0, 30));//设置字体
		btnPanel.add(btn_Close);
		
		JButton btn_Back = new JButton("←");
		btn_Back.setMargin(new Insets(0,0,0,0));
		btn_Back.setBounds(btnPanel.getWidth()-60-btn_Close.getWidth(),(btnPanel.getHeight())/2-10,30, 30);
		btn_Back.addActionListener(this);
		btn_Back.setName("back");
		
		btn_Back.setContentAreaFilled(false);
		btn_Back.setForeground(Color.decode("#3A5FCD"));
		btn_Back.setFont(new Font("Serif",0, 20));//设置字体
		btnPanel.add(btn_Back);
		
		JButton reduceButton = new JButton("—");
		reduceButton.setMargin(new Insets(0,0,0,0));
		reduceButton.setBounds(btnPanel.getWidth()-70-2*btn_Close.getWidth(),(btnPanel.getHeight())/2-10,30,30);
		reduceButton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	            setExtendedState(JFrame.ICONIFIED);
	        }
	    });
		
		reduceButton.setContentAreaFilled(false);
		reduceButton.setForeground(Color.decode("#3A5FCD"));
		reduceButton.setFont(new Font("Serif",0, 20));//设置字体
		btnPanel.add(reduceButton);

	}
	//建立表格区，设定表格大小、颜色等基础信息
	public void setTablePanel() {

		tablePanel.setSize(width, height*9/10);
		
		tableHeight = tablePanel.getHeight()*4/5;
		tableWidth = tablePanel.getWidth()*4/5;
		
		if(tableHeader.length < 6){
			cellHeight = tableHeight/10;
			cellWidth = tableWidth/tableHeader.length;
		}else{
			cellHeight = tableHeight/10;
			cellWidth = tableWidth/6;
		}
		buidTablePanel(tableContent.length,tableHeader.length,10,6);		
		tablePanel.setLayout(null);
		tablePanel.removeAll();
		tablePanel.add(sp);
		
		
		sp.setLocation((tablePanel.getWidth()-sp.getWidth())/2, (tablePanel.getHeight()-sp.getHeight())/2);
		tablePanel.setLocation(0,btnPanel.getHeight());
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
		
		table.setTableFont(new Font("Serif",0, 20));
		tableHeaderList.setTableFont(new Font("Serif",1, 20));
		tableHeaderList.setFontColor(Color.decode("#FFFFFF"));
		
		
	}
//建立表头，设定表格内容及SCROLLPANE
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
		table.setContent(tableContent);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		table.setPreferredSize(new Dimension(cellWidth*allColumn,cellHeight*allRow));
		//设置JSCROLLPANE
		tableHeaderList.updateUI();
		sp = new JScrollPane(table);
		sp.setColumnHeaderView(tableHeaderList);
		sp.setSize(tableWidth, tableHeight);
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setOpaque(false);
		sp.getViewport().setOpaque(false); 
		sp.getColumnHeader().setOpaque(false);//再取出头部，并设置为透明 
		
		table.addMouseListener(
				new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
					//	selectedRow = Integer.parseInt(e.getComponent().getName());
						
						selectedRow=Integer.parseInt(e.getComponent().getComponentAt(table.getMousePosition()).getName());
						showData();
					}          
				}
				);    

	}
//更换表头及表格数据
	public void setTableContent(String [] headerContent,String[][] content) {
		
		tableHeader = new String[headerContent.length];
		tableContent = new String [content.length][headerContent.length];
		tableHeader = headerContent;
		tableContent = content;
		setTablePanel();
		this.revalidate();
		this.repaint();
		
	}
//显示详细信息。
	public void showData() {
		//selectedRow为选择行数，即二维数组第一维

	}

	public ArrayList<String> getList() {
		return temp;
		// TODO Auto-generated method stub

	}
//设置表头内容，根据自定义中传输的数据设定
	public void setList(ArrayList<String> list) {
		temp.removeAll(temp);
		temp.add("ID");
		temp.add("名字");
//		for(int i = 0 ;i<tableHeader.length;i++){
//			temp.add(tableHeader[i]);
//		}
		
		for(int i = 0 ;i<list.size() ;i++){
			if(temp.contains(list.get(i)) == false){
				temp.add(list.get(i));
			}
		}
		
		tableHeader = new String[temp.size()];
		for(int i = 0 ; i<temp.size();i++){
			tableHeader[i] = temp.get(i);
		}
//		for(int i = 0;i<list.length;i++){
//			if(tableHeader == false){
//				tableHeader.add(list.get(i));
//			}
//		}//TODO


	}

	public void add(){
		AWTUtilities.setWindowOpacity(this, 0.5f);
		AdditionOfPlayerInfo addition = new AdditionOfPlayerInfo(this);
		addition.setPlayerFrame(this);
		addition.setVisible(true);	
		
	}
	
	public void setSort(String string) {
//		if (string.split(";")[0].equals("升序")) {
//			sortType = SortType.SORT;
//		} else {
//			sortType = SortType.REVERSE_SORT;
//		}
//		PlayerTableTranslation playerTableTranslation = new PlayerTableTranslation();
//		sortBy = playerTableTranslation.translation(string.split(";")[1]);
	}
	//刷新信息，并根据信息（由tableHeader（String[]）决定）设定内容@Dalec Gu TODO
	public void refreshData() {
		//TODO
		//传入表格数据,以下30为传入数据行数，根据tableHeader获取数据后更改大小及具体数值（可自己建立ArrayList暂时存储数据，可能较为方便）
		PlayerController controller = new PlayerController();
		PlayerHeaderToEnum translation = new PlayerHeaderToEnum();
		ArrayList<PlayerEntity> columnList = new ArrayList<PlayerEntity>();
		for (String string:tableHeader) {
			columnList.add(translation.translate(string));
		}
		GetPlayerResponse response = (GetPlayerResponse) controller.processRequest(
				new GetPlayerRequest(columnList));
		ArrayList<Map<PlayerEntity, String>> tempList = response.getList();
		tableContent = new String[tempList.size()][tableHeader.length];
		int i = 0;
		for (Map<PlayerEntity, String> map:tempList) {
			int j = 0;
			for (String string:tableHeader) {
				tableContent[i][j] = map.get(translation.translate(string));
				j++;
			}
			i++;
		}
		setTableContent(tableHeader,tableContent);
	}

	public JLabel setLabelIcon(Icon icon) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args){
		
		@SuppressWarnings("unused")
		PlayerFrame test = new PlayerFrame();
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton){
			JButton btn = (JButton)e.getSource();
			String name = btn.getName();
			if("add".equals(name)){
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						add();
					}
				});
			}else if("sift".equals(name)){
				SwingUtilities.invokeLater(new Runnable(){
					public void run(){
						//sift();
					}
				});
			}else if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}else if("back".equals(name)){
				  this.setVisible(false);
				  this.dispose();
		//		  @SuppressWarnings("unused")
			//	FrontFrame front = new FrontFrame();
			}
		}
		
	}



}
