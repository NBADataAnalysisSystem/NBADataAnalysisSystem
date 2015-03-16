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
		
		
		JButton btn_Add = new JButton("");
		btn_Add.setName("add");
		btn_Add.addActionListener(this);
		leftPane.add(btn_Add);
		
		model = new PlayerModel();
		table  = new JTable(model);
		sp = new JScrollPane(table);
		//playerPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		//TODO ���ڴ�ű���Frame ���޷������ԭFrame�С�����Ϊ����λ�á�
		JFrame tableContain = new JFrame();
		tableContain.add(sp);
		//����λ�úʹ�С
		tableContain.setLocation(300, 133);
		tableContain.setSize(bg.getIconWidth()-123,  bg.getIconHeight()-36);
		//ȥ���߿��װ�Σ�������AWTUtilities.setWindowOpacity
		tableContain.setUndecorated(true);
		//�����׶ˣ���֧�ֿ�ƽ̨
		AWTUtilities.setWindowOpacity(tableContain, 0.4F);
		//�ñ��ʼ��λ����ǰ��
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
	 * ��ʼ���б�ˢ�±����Ϣ
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
