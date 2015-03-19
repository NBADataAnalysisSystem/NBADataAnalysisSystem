package ui.playerui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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

import ui.ButtonOperation;
import ui.dlg.AdditionOfPlayerInfo;

import com.sun.awt.AWTUtilities;

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
	
	
	@SuppressWarnings("static-access")
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
		
		
		JButton btn_Add = new JButton("��ѡ��Ϣ");
		btn_Add.setName("add");
		btn_Add.addActionListener(this);
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
		//��JScrollPane����Ϊ͸��
		sp.getViewport().setOpaque(false);  //jScrollPanel Ϊtable��ŵ�������һ����Swing��    //  �����ʱ�����Զ����ɣ�ԭ����Ϊ��jScrollPane1 = new javax.swing.JScrollPane();
		sp.setOpaque(false);     //���м��viewport����Ϊ͸��
		sp.setViewportView(table); //װ�ر�� 
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO ���ڴ�ű���Frame ���޷������ԭFrame�С�����Ϊ����λ�á�
		tableContain = new JFrame();
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(sp, BorderLayout.CENTER);
		tablePanel.setOpaque(true);
		tableWidth = bg.getIconWidth()-123;
		tableHeight =  bg.getIconHeight()-36;
		

		
		//TODO TABLE͸��������
		//tableContain.add(tablePanel);
		//����λ�úʹ�С
		//tableContain.setLocation(300, 133);
		//tableContain.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		//ȥ���߿��װ�Σ�������AWTUtilities.setWindowOpacity
		//tableContain.setUndecorated(true);
		//�����׶ˣ���֧�ֿ�ƽ̨
		//AWTUtilities.setWindowOpacity(tableContain, 0.4F);
		//�ñ��ʼ��λ����ǰ��
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
		tablePanel.setSize(500, 500);
		tablePanel.setOpaque(false);
		this.add(playerPanel);
		playerPanel.setVisible(true);
		this.add(tablePanel);//TODO
		tablePanel.setVisible(true);
		this.setVisible(true);
		


		listToShow = new ArrayList<String>();
		
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
				"ID","����"
				
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
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void add(){
		
		AdditionOfPlayerInfo addition = new AdditionOfPlayerInfo(this);
		addition.setPlayerFrame(this);
		addition.setVisible(true);	
		
	}
	//����LIST��ֵ
	public void setList(ArrayList<String> list){
		
		listToShow.addAll(list);
	}
	
	//��ListתΪString[]
	static String[] stringToShow;
	public void setString(){
		
		stringToShow = new String [listToShow.size()];
		for(int i = 0;i<listToShow.size();i++){
			
			stringToShow[i] = listToShow.get(i);
			
		}
		
	}
	//TODO ��ͷ�ı䲻�ˡ�
	public void refreshData() {
		listToShow.set(0, "ID");
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
		System.out.println(model.getColumnName(2));
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		PlayerFrame test = new PlayerFrame();
	}

}
