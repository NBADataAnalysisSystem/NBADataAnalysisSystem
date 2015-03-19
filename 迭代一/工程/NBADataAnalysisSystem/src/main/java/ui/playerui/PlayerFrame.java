package ui.playerui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import ui.dlg.AdditionOfPlayerInfo;

@SuppressWarnings("serial")
public class PlayerFrame extends JFrame implements ActionListener{
	
	JPanel playerPanel;
	static JScrollPane sp ;
	static PlayerModel model;
	static JTable table;
	JFrame tableContain;
	JPanel 	tablePanel;
	static ArrayList<String> listToShow;
	int tableWidth;
	int tableHeight;
	
	
	@SuppressWarnings({ "static-access", "unused" })
	public PlayerFrame(){
		super();

		this.setUndecorated(true);
		this.setSize(1000, 562);
		this.setLocation(500,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.center(this);
		this.setLayout(null);
		
		//设置背景图片 TODO
		ImageIcon bg = new ImageIcon("resource/BackgroundOfPlayerChecking.png"); // 把背景图片显示在一个标签里
		Image temp = bg.getImage().getScaledInstance(2*bg.getIconWidth(),2* bg.getIconHeight(), bg.getImage().SCALE_DEFAULT);  
        bg = new ImageIcon(temp);
		JLabel label = new JLabel(bg); //把标签的大小位置设置为图片刚好填充整个面
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight()); //添加图片到frame的第二层 
		this.getRootPane().add(label,new Integer(Integer.MIN_VALUE)); //获取frame的最上层面板为了设置其背景颜色]
		JPanel jp=(JPanel)this.getContentPane();
		jp.setOpaque(false);//设置透明 
		//jp.setVisible(true);
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new BorderLayout());
		playerPanel.setBounds(0, 0, bg.getIconWidth(),  bg.getIconHeight());
		playerPanel.setOpaque(false);//设置透明 	
		
		JPanel xp = new JPanel();
		xp.setOpaque(false);//设置透明 
		playerPanel.add(xp, BorderLayout.WEST);
		
		JPanel leftPane = new JPanel();
		leftPane.setLayout(new GridLayout(0,1));
		leftPane.setOpaque(false);
		xp.add(leftPane);
		
		
		JButton btn_Add = new JButton();
		btn_Add.setName("add");
		btn_Add.addActionListener(this);
		ImageIcon selectIcon = new ImageIcon("resource/SelectInfo.jpg");
		Image tempSelect = selectIcon.getImage().getScaledInstance(selectIcon.getIconWidth(),selectIcon.getIconHeight(),Image.SCALE_DEFAULT);  
		selectIcon.setImage(tempSelect);
		btn_Add.setMargin(new Insets(0,0,0,0));
		btn_Add.setIcon(selectIcon);
		btn_Add.setBounds(950,0,selectIcon.getIconWidth(), selectIcon.getIconHeight());
		leftPane.add(btn_Add);
		
		tablePanel = new JPanel();
		model = new PlayerModel();
		table  = new JTable(model);
		sp = new JScrollPane();
		
		//TODO
		table.setOpaque(true);
		DefaultTableCellRenderer render = new DefaultTableCellRenderer();
		Dimension viewSize = new Dimension();
		viewSize.width = table.getColumnModel().getTotalColumnWidth();;
		viewSize.height = 10*table.getRowHeight();
		table.setPreferredScrollableViewportSize(viewSize);
		//将JScrollPane设置为透明
		sp.getViewport().setOpaque(false);  //jScrollPanel 为table存放的容器，一般在Swing创    //  建表格时，它自动生成，原代码为：jScrollPane1 = new javax.swing.JScrollPane();
		sp.setOpaque(false);     //将中间的viewport设置为透明
		sp.setViewportView(table); //装载表格 
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO 用于存放表格的Frame ，无法存放在原Frame中。窗口为绝对位置。
		tableContain = new JFrame();
		table.setEnabled(false);
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(sp, BorderLayout.CENTER);
		tablePanel.setOpaque(true);
		tableWidth = bg.getIconWidth()-123;
		tableHeight =  bg.getIconHeight()-36;
		

		
		//TODO TABLE透明度设置
		//tableContain.add(tablePanel);
		//设置位置和大小
		//tableContain.setLocation(300, 133);
		//tableContain.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		//去除边框等装饰，才能用AWTUtilities.setWindowOpacity
		//tableContain.setUndecorated(true);
		//方法弊端：不支持跨平台
		//AWTUtilities.setWindowOpacity(tableContain, 0.4F);
		//让表格始终位于最前端
		//tableContain.setAlwaysOnTop(true);
		//tableContain.setLocationRelativeTo(null);
		
//		String  CloseImg="resource/UntouchedClose.png";
//		ButtonOperation CloseButton = new ButtonOperation(CloseImg,this);
//		//CloseButton.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//CloseButton.setAlwaysOnTop(true);
//		this.add(CloseButton);
//		CloseButton.setVisible(true);
		

		//this.add(tableContain);
		//tableContain.setVisible(true);
		
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
		
		
		tablePanel.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		tablePanel.setLocation(122,35);
		tablePanel.setOpaque(false);
		this.add(playerPanel);
		playerPanel.setVisible(true);
		this.add(tablePanel);//TODO
		tablePanel.setVisible(true);
		this.setVisible(true);
		


		listToShow = new ArrayList<String>();
		listToShow.add("ID");
		listToShow.add("名字");
		
		//refreshData();
		
	}
	
	private void center(JFrame frame) {
	       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = frame.getWidth();
	        int height = frame.getHeight();
	        frame.setLocation( (screensize.width - width) / 2,
	                      (screensize.height - height) / 2);
		
	}

	class PlayerModel extends DefaultTableModel {
		private String[] COLUMNS = new String[]{
				"ID","名字"
				
		};
		public boolean isCellEditable(int row, int column) {
			return false;
		}
		public int getColumnCount() {
			return COLUMNS.length;
		}
		public String getColumnName(int column) {
			return COLUMNS[column];
		}
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
			}else if("close".equals(name)){
				  this.setVisible(false);
				  this.dispose();
				  System.exit(0);
			}
		}
	}
	
	public void add(){
		
		AdditionOfPlayerInfo addition = new AdditionOfPlayerInfo(this);
		addition.setPlayerFrame(this);
		addition.setVisible(true);	
		
	}
	//设置LIST的值
	public void setList(ArrayList<String> list){

			for(int i = 0;i<list.size();i++){
				if(listToShow.contains(list.get(i)) == false){
					listToShow.add(list.get(i));
				}
			}
	}
	
	//把List转为String[]
	static String[] stringToShow;
	public void setString(){
		
		stringToShow = new String [listToShow.size()];
		for(int i = 0;i<listToShow.size();i++){
			
			stringToShow[i] = listToShow.get(i);
			
		}
		
	}
	
	public void refreshData() {
		
	}
	
	public void changeTableColumns(){
	
//		listToShow.set(0, "ID");
		this.setString();
		model.COLUMNS = stringToShow;
		tablePanel.removeAll();
		sp.getViewport().removeAll();
		table = new JTable(model);
		sp.getViewport().add(table);
		tablePanel.add(sp);
//		tableContain.add(tablePanel);
		revalidate();
		repaint();
		
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		PlayerFrame test = new PlayerFrame();
	}

}
