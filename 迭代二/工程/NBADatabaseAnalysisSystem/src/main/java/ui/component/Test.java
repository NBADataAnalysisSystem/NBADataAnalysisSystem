package ui.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Test{
	static JPanel panel = new JPanel();
	static JLabel background = new JLabel();
	static MyTablePanel testTable;
	static MyTableHeaderPanel testHeader;
	static int high = 700;
	static int width = 700;
	public Test(int high,int width){

	}
	
	public static void main(String[] orgs){
		String[][] s = new String[high][width];
		for(int i = 0; i < high; i++){
			for(int j = 0; j < width; j++){
				s[i][j] = new String(i + "  " + j);
			}
		}
		ImageIcon icon ;
		icon = new ImageIcon("resource/test.png");
		icon.setImage(icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		
		ImageIcon iconT ;
		iconT = new ImageIcon("resource/testB.png");
		iconT.setImage(iconT.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT));
		
		ImageIcon iconB ;
		iconB = new ImageIcon("resource/BackgroundOfPlayerChecking.png");
		iconB.setImage(iconB.getImage().getScaledInstance(700, 700,Image.SCALE_DEFAULT));
		
		
		JFrame frame = new JFrame();
		frame.setSize(high, width);
		testTable = new MyTablePanel(10,10,10,10,1000,1000);
		panel.setLayout(null);
		panel.setSize(high, width);
		panel.setLocation(0, 0);
		testTable.setContent(s);
		testTable.setLocation(0, 0);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		testTable.setPreferredSize(new Dimension(1000,1000));
		for(int i = 0; i <10;){
				testTable.setRowBackground(icon, i++);
				testTable.setRowBackground(iconT, i++);
		}
		
		testHeader = new MyTableHeaderPanel(1,10,1,10,1000,50);
		testHeader.setContent(s[0]);
		//testHeader.setLocation(0, 0);
		//TODO 重要，保证testTable大小大于JSCROLLPANE.
		testHeader.setPreferredSize(new Dimension(1000,50));
		testHeader.setRowBackground(iconT, 0);
		
		
		
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		background.setIcon(iconB);
		background.setBounds(0,0,700,700); //添加图片到frame的第二层 
		background.setOpaque(false);
	//	frame.getRootPane().add(background,new Integer(Integer.MIN_VALUE)); //获取frame的最上层面板为了设置其背景颜色]
		//panel.add(testTable);
		JScrollPane scroll = new JScrollPane(testTable);
		scroll.setColumnHeaderView(testHeader);
		scroll.setSize(600, 600);
//		scroll.setViewportView(testTable);
	    scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setOpaque(false);
		scroll.getViewport().setOpaque(false); 
		panel.add(scroll);
		panel.add(background);
		
		frame.setVisible(true);
	}

}
