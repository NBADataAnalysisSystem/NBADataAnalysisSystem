package ui.component;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test{
	static JPanel panel = new JPanel();
	static JLabel background = new JLabel();
	static MyTablePanel testTable;
	static int high = 1000;
	static int width = 1000;
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
		iconB.setImage(iconB.getImage().getScaledInstance(1000, 1000,Image.SCALE_DEFAULT));
		
		
		JFrame frame = new JFrame();
		frame.setSize(high, width);
		testTable = new MyTablePanel(10,10,10,10,high,width);
		panel.setLayout(null);
		panel.setSize(high, width);
		panel.setLocation(0, 0);
		testTable.setContent(s);
		testTable.setLocation(0, 0);
		for(int i = 0; i <10;){
				testTable.setRowBackground(icon, i++);
				testTable.setRowBackground(iconT, i++);
		}
		
		
		frame.setLocationRelativeTo(null);
		frame.add(panel);
		background.setIcon(iconB);
		background.setBounds(0,0,1000,1000); //添加图片到frame的第二层 
		background.setOpaque(false);
	//	frame.getRootPane().add(background,new Integer(Integer.MIN_VALUE)); //获取frame的最上层面板为了设置其背景颜色]
		panel.add(testTable);
		panel.add(background);

		frame.setVisible(true);
	}

}
