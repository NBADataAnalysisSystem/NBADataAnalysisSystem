package ui.playerui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.awt.AWTUtilities;

@SuppressWarnings("serial")
public class PlayerFrame extends JFrame implements ActionListener{
	
	JPanel playerPanel;
	JScrollPane sp ;
	PlayerModel model;
	JTable table;
	
	
	@SuppressWarnings("static-access")
	public PlayerFrame(){
		super();

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
		
		
		JButton btn_Add = new JButton("");
		btn_Add.setName("add");
		btn_Add.addActionListener(this);
		leftPane.add(btn_Add);
		
		model = new PlayerModel();
		table  = new JTable(model);
		sp = new JScrollPane(table);
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO 用于存放表格的Frame ，无法存放在原Frame中。窗口为绝对位置。
		JFrame tableContain = new JFrame();
		tableContain.add(sp);
		//设置位置和大小
		tableContain.setLocation(300, 133);
		tableContain.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		//去除边框等装饰，才能用AWTUtilities.setWindowOpacity
		tableContain.setUndecorated(true);
		//方法弊端：不支持跨平台
		AWTUtilities.setWindowOpacity(tableContain, 0.4F);
		//让表格始终位于最前端
		tableContain.setAlwaysOnTop(true);
		//tableContain.setLocationRelativeTo(null);
		
		//this.add(tableContain);
		this.setVisible(true);
		tableContain.setVisible(true);
		this.add(playerPanel);
		playerPanel.setVisible(true);

		
	}
	
	private void center(JFrame frame) {
	       Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	        int width = frame.getWidth();
	        int height = frame.getHeight();
	        frame.setLocation( (screensize.width - width) / 2,
	                      (screensize.height - height) / 2);
		
	}

	class PlayerModel extends DefaultTableModel {
		private final String[] COLUMNS = new String[] {
				"1","2","3","4"
				
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
	/**
	 * 初始话列表，刷新表格信息
	 */
	public void refreshData() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		PlayerFrame test = new PlayerFrame();
	}

}
