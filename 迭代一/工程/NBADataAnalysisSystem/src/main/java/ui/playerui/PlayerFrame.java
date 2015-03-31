package ui.playerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
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
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.sun.awt.AWTUtilities;

import controller.playercontroller.GetPlayerRequest;
import controller.playercontroller.GetPlayerResponse;
import controller.playercontroller.PlayerController;
import entity.PlayerInfo;
import entity.SortType;
import ui.dlg.AdditionOfPlayerInfo;
import ui.dlg.SiftingOfPlayer;

@SuppressWarnings({ "serial", "restriction" })
public class PlayerFrame extends JFrame implements ActionListener{
	
	JPanel playerPanel;
	static JScrollPane sp ;
	static PlayerModel model;
	static JTable table;
	JPanel 	tablePanel;
	static ArrayList<String> listToShow;
	static SortType sortType;
	static PlayerInfo sortBy;
	static ArrayList<String> data;
	int tableWidth;
	int tableHeight;
	private static Point origin = new Point();
	
	
	@SuppressWarnings({ "static-access" })
	public PlayerFrame(){
		super();

		this.setUndecorated(true);
		this.setSize(1000, 562);
		this.setLocation(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.center(this);
		this.setLayout(null);
		
		//���ñ���ͼƬ TODO
		ImageIcon bg = new ImageIcon("resource/BackgroundOfPlayerChecking.png"); // �ѱ���ͼƬ��ʾ��һ����ǩ��
		Image temp = bg.getImage().getScaledInstance(2*bg.getIconWidth(),2* bg.getIconHeight(), bg.getImage().SCALE_DEFAULT);  
        bg = new ImageIcon(temp);
		JLabel label = new JLabel(bg); //�ѱ�ǩ�Ĵ�Сλ������ΪͼƬ�պ����������
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight()); //���ͼƬ��frame�ĵڶ��� 
		this.getRootPane().add(label,new Integer(Integer.MIN_VALUE)); //��ȡframe�����ϲ����Ϊ�������䱳����ɫ]
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);//����͸�� 
		//jp.setVisible(true);
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());
		playerPanel.setBounds(0, 0, bg.getIconWidth(),  bg.getIconHeight());
		playerPanel.setOpaque(false);//����͸�� 	
		
		JPanel xp = new JPanel();
		xp.setOpaque(false);//����͸�� 
		playerPanel.add(xp, BorderLayout.WEST);
		
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new GridLayout(0,1));
		leftPane.setOpaque(false);
		xp.add(leftPane);
		
		
		JButton btn_Add = new JButton();
		btn_Add.setName("add");
		btn_Add.addActionListener(this);
		ImageIcon selectIcon = new ImageIcon("resource/SelectInfoButton.jpg");
		Image tempSelect = selectIcon.getImage().getScaledInstance(selectIcon.getIconWidth(),selectIcon.getIconHeight(),Image.SCALE_DEFAULT);  
		selectIcon.setImage(tempSelect);
		btn_Add.setMargin(new Insets(0,0,0,0));
		btn_Add.setIcon(selectIcon);
		btn_Add.setBounds(950,0,selectIcon.getIconWidth(), selectIcon.getIconHeight());
		leftPane.add(btn_Add);

		//TODO
		JButton btn_Sift = new JButton();
		btn_Sift.setName("sift");
		ImageIcon siftIcon = new ImageIcon("resource/SiftingButton.jpg");
		Image tempSift = siftIcon.getImage().getScaledInstance(siftIcon.getIconWidth(),siftIcon.getIconHeight(),Image.SCALE_DEFAULT);  
		siftIcon.setImage(tempSift);
		btn_Sift.setMargin(new Insets(0,0,0,0));
		btn_Sift.setIcon(siftIcon);
		btn_Sift.setBounds(900,0,siftIcon.getIconWidth(), siftIcon.getIconHeight());
		btn_Sift.addActionListener(this);
		leftPane.add(btn_Sift);
		
		tablePanel = new JPanel();
		model = new PlayerModel();
		table  = new JTable(model);
		sp = new JScrollPane();
		
		//TODO
		table.setOpaque(false);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setOpaque(false); //����Ⱦ������Ϊ͸��  
     
        table.setDefaultRenderer(Object.class,render);  
		Dimension viewSize = new Dimension();
		viewSize.width = table.getColumnModel().getTotalColumnWidth();;
		viewSize.height = 10*table.getRowHeight();
		table.setPreferredScrollableViewportSize(viewSize);
		
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i = 0;i<table.getColumnCount();i++){//TODO
		table.getColumn(table.getColumnName(i)).setMinWidth(200);}
		//��JScrollPane����Ϊ͸��
		sp.getViewport().setOpaque(false);  //jScrollPanel Ϊtable��ŵ�������һ����Swing��    //  �����ʱ�����Զ����ɣ�ԭ����Ϊ��jScrollPane1 = new javax.swing.JScrollPane();
		sp.setOpaque(false);     //���м��viewport����Ϊ͸��
		sp.setViewportView(table); //װ�ر�� 
		sp.setColumnHeaderView(table.getTableHeader());//����ͷ����HeaderView���֣�  
	    sp.getColumnHeader().setOpaque(false);//��ȡ��ͷ����������Ϊ͸�� 
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO ���ڴ�ű���Frame ���޷������ԭFrame�С�����Ϊ����λ�á�
		table.setEnabled(false);
		table.setForeground(Color.decode("#7CFC00"));
		table.setRowHeight(25);//���ñ��ÿ�д�С
		table.setFont(new Font("����",1, 20));//��������
		JTableHeader tableHeader ;
		tableHeader = table.getTableHeader();
//		tableHeader.setForeground(Color.decode("#f0949c"));
		tableHeader.setPreferredSize(new Dimension(30, 26));   
		tableHeader.setOpaque(false);//����ͷ��Ϊ͸��  
		tableHeader.getTable().setOpaque(false);//����ͷ������ı��͸��  
		
//		sp.setViewportView(tableHeader); //װ�ر�ͷ
		render = new DefaultTableCellRenderer();
		render.setOpaque(false); //����Ⱦ������Ϊ͸��  
		/* 
		 * ͷ���ı��Ҳ��ǰ��ı������һ��������Ҫ������ĵ�Ԫ������Ϊ͸�� 
		 * ���ͬ����Ҫ��ͷ����Ԫ�����͸�������ã����ﻹ������Ⱦ���� 
		 */  
		tableHeader.setDefaultRenderer(render);  
		TableCellRenderer headerRenderer = tableHeader.getDefaultRenderer();   
		if (headerRenderer instanceof JLabel)   
		{  
			//((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
			((JLabel) headerRenderer).setOpaque(false);   
		}  
		//table.setGridColor(Color.decode("#fa1428"));
		table.setTableHeader(tableHeader);
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(sp, BorderLayout.CENTER);
		tablePanel.setOpaque(false);
		tableWidth = bg.getIconWidth()-123;
		tableHeight =  bg.getIconHeight()-36;
		
		JButton closeButton = new JButton();
		ImageIcon closeIcon = new ImageIcon("resource/CloseButton.jpg");
		Image tempClose = closeIcon.getImage().getScaledInstance(closeIcon.getIconWidth()/3,closeIcon.getIconHeight()/3,Image.SCALE_DEFAULT);  
		closeIcon.setImage(tempClose);
		closeButton.setMargin(new Insets(0,0,0,0));
		closeButton.setIcon(closeIcon);
		closeButton.setBounds(950,0,closeIcon.getIconWidth(), closeIcon.getIconHeight());
		closeButton.addActionListener(this);
		closeButton.setName("close");
		this.add(closeButton);
		
		JButton reduceButton = new JButton();
		ImageIcon reduceIcon = new ImageIcon("resource/ReduceButton.jpg");
		Image tempReduce = reduceIcon.getImage().getScaledInstance(reduceIcon.getIconWidth()/3,reduceIcon.getIconHeight()/3,Image.SCALE_DEFAULT);  
		reduceIcon.setImage(tempReduce);
		reduceButton.setMargin(new Insets(0,0,0,0));
		reduceButton.setIcon(reduceIcon);
		reduceButton.setBounds(900,0,reduceIcon.getIconWidth(), reduceIcon.getIconHeight());
		reduceButton.addActionListener(this);
		reduceButton.addActionListener(new ActionListener(){
	        @Override public void actionPerformed(ActionEvent e){
	            setExtendedState(JFrame.ICONIFIED);
	        }
	    });
		this.add(reduceButton);
		
		
		
		tablePanel.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		tablePanel.setLocation(122,35);
		tablePanel.setOpaque(false);
		this.add(playerPanel);
		playerPanel.setVisible(true);
		this.add(tablePanel);//TODO
		tablePanel.setVisible(true);
		this.setVisible(true);
	
		//�����϶�����ķ���
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

		listToShow = new ArrayList<String>();
		listToShow.add("ID");
		listToShow.add("����");
		sortType = SortType.SORT;
		sortBy = PlayerInfo.PLAYER_ID;
		data = new ArrayList<String>();

		refreshData();
		
	}
	
	private void center(JFrame frame) {
	       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = frame.getWidth();
	        int height = frame.getHeight();
	        frame.setLocation( (screensize.width - width) / 2,
	                      (screensize.height - height) / 2);
		
	}

	class PlayerModel extends DefaultTableModel {
//		private String[] COLUMNS = new String[]{
//				"ID","����"
//				
//		};
		{
			setColumnIdentifiers(new String[]{"ID", "����"});
		}
		public boolean isCellEditable(int row, int column) {
			return false;
		}
//		public int getColumnCount() {
//			return COLUMNS.length;
//		}
//		public String getColumnName(int column) {
//			return COLUMNS[column];
//		}
	}

	@Override
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
						sift();
					}
				});
			}else if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void showPlayerData() {
		
		model.getDataVector().clear();
		for (String vo : data) {
			Vector<String> v = new Vector<String>();
			String[] temp = vo.split(";");
			for (String string:temp) {
				v.add(string);
			}
			model.getDataVector().add(v);
		}
		table.updateUI();
		
	}
	
	public void add(){
		AWTUtilities.setWindowOpacity(this, 0.5f);
		AdditionOfPlayerInfo addition = new AdditionOfPlayerInfo(this);
		addition.setPlayerFrame(this);
		addition.setVisible(true);	
		
	}
	
	public void sift(){
		AWTUtilities.setWindowOpacity(this, 0.5f);
		SiftingOfPlayer sifting = new SiftingOfPlayer(this);
		sifting.setPlayerFrame(this);
		sifting.setVisible(true);	
		
	}
	
	public ArrayList<String> getList(){
		
		return listToShow;
		
	}
	public void setSort(String string) {
		if (string.split(";")[0].equals("����")) {
			sortType = SortType.SORT;
		} else {
			sortType = SortType.REVERSE_SORT;
		}
		PlayerTableTranslation playerTableTranslation = new PlayerTableTranslation();
		sortBy = playerTableTranslation.translation(string.split(";")[1]);
	}
	//����LIST��ֵ
	public void setList(ArrayList<String> list){
			listToShow.removeAll(listToShow);
			listToShow.add("ID");
			listToShow.add("����");
			for(int i = 0;i<list.size();i++){
				if(listToShow.contains(list.get(i)) == false){
					listToShow.add(list.get(i));
				}
			}
//			for(int i = 0;i<listToShow.size();i++){
//				if(list.contains(listToShow.get(i)) == true&&listToShow.get(i).equals("ID") == false && listToShow.get(i).equals("����") == false){
//					listToShow.remove(i);
//				}
//			}
	}
	
	//��ListתΪString[]
	static String[] stringToShow;
	public void setString(){
		
		stringToShow = new String [listToShow.size()];
		for(int i = 0;i<listToShow.size();i++){
			
			stringToShow[i] = listToShow.get(i);
			
		}
		
	}
	
	public void refreshData() {
		data.clear();
		PlayerController controller = new PlayerController();
		ArrayList<PlayerInfo> columnList = new ArrayList<PlayerInfo>();
		PlayerTableTranslation playerTableTranslation = new PlayerTableTranslation();
		for (String string:listToShow) {
			columnList.add(playerTableTranslation.translation(string));
		}
		GetPlayerResponse response = (GetPlayerResponse) controller.processRequest(
				new GetPlayerRequest(columnList, sortType, sortBy));
		ArrayList<Map<PlayerInfo, String>> tempList = response.getList();
		for (Map<PlayerInfo, String> map:tempList) {
			String tempString = "";
			for (String string:listToShow) {
				tempString+=map.get(playerTableTranslation.translation(string));
				tempString+=";";
			}
			data.add(tempString);
		}
		showPlayerData();
	}
	
	public void changeTableColumns(){
	
//		listToShow.set(0, "ID");
		this.setString();
//		model.COLUMNS = stringToShow;
//		model = new PlayerModel();
		model.setColumnIdentifiers(stringToShow);
		//model.setColumnIdentifiers(stringToShow);
		tablePanel.removeAll();
		sp.getViewport().removeAll();
//		table.getTableHeader().
//		for (String c : model.COLUMNS) {
//			model.addColumn(c);
//		}
//		System.out.println(model.getColumnCount());
		table = new JTable(model);
		sp.getViewport().add(table);
		//TODO
		table.setOpaque(false);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		render.setOpaque(false); //����Ⱦ������Ϊ͸��  
     
        table.setDefaultRenderer(Object.class,render);  
		Dimension viewSize = new Dimension();
		viewSize.width = table.getColumnModel().getTotalColumnWidth();;
		viewSize.height = 10*table.getRowHeight();
		table.setPreferredScrollableViewportSize(viewSize);
		if (table.getColumnCount()>=5){
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);}
		//��JScrollPane����Ϊ͸��
		sp.getViewport().setOpaque(false);  //jScrollPanel Ϊtable��ŵ�������һ����Swing��    //  �����ʱ�����Զ����ɣ�ԭ����Ϊ��jScrollPane1 = new javax.swing.JScrollPane();
		sp.setOpaque(false);     //���м��viewport����Ϊ͸��
		sp.setViewportView(table); //װ�ر�� 
		sp.setColumnHeaderView(table.getTableHeader());//����ͷ����HeaderView���֣�  
	    sp.getColumnHeader().setOpaque(false);//��ȡ��ͷ����������Ϊ͸�� 
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO ���ڴ�ű���Frame ���޷������ԭFrame�С�����Ϊ����λ�á�
	    for(int i = 0;i<table.getColumnCount();i++){//TODO
	    	table.getColumn(table.getColumnName(i)).setMinWidth(200);}
	    sp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		table.setEnabled(false);
		table.setForeground(Color.decode("#7CFC00"));
		table.setRowHeight(25);//���ñ��ÿ�д�С
		table.setFont(new Font("����",1, 20));//��������
		JTableHeader tableHeader ;
		tableHeader = table.getTableHeader();
//		tableHeader.setForeground(Color.decode("#f0949c"));
//		tableHeader.setPreferredSize(new Dimension(30, 26));   
		tableHeader.setOpaque(false);//����ͷ��Ϊ͸��  
		tableHeader.getTable().setOpaque(false);//����ͷ������ı��͸��
	//	sp.setViewportView(tableHeader); //װ�ر�ͷ
		render = new DefaultTableCellRenderer();
		render.setOpaque(false); //����Ⱦ������Ϊ͸��  
		/* 
		 * ͷ���ı��Ҳ��ǰ��ı������һ��������Ҫ������ĵ�Ԫ������Ϊ͸�� 
		 * ���ͬ����Ҫ��ͷ����Ԫ�����͸�������ã����ﻹ������Ⱦ���� 
		 */  
//		((DefaultTableCellRenderer) tableHeader.getDefaultRenderer()).setOpaque(false);
		tableHeader.setDefaultRenderer(render);  
		TableCellRenderer headerRenderer = tableHeader.getDefaultRenderer();   
		if (headerRenderer instanceof JLabel)   
		{  
			//((JLabel) headerRenderer).setHorizontalAlignment(JLabel.CENTER);   
			((JLabel) headerRenderer).setOpaque(false);   
		}  
		tablePanel.add(sp, BorderLayout.CENTER);
		tablePanel.setOpaque(false);
		//TODO
		revalidate();
		repaint();
		
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		PlayerFrame test = new PlayerFrame();
	}

}
