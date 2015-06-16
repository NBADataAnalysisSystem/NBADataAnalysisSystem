package ui.component;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoadingPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	public LoadingPanel(int x,int y){
		this.x=x;
		this.y=y;
		this.width = 100;
		this.height = 100;
		
		this.setBounds(x, y, width, height);
		this.setOpaque(false);
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		// ImageIcon icon = new ImageIcon("D:\\1.jpg");
		ImageIcon icon = new ImageIcon("resource/Loading.gif");
		g.drawImage(icon.getImage(), 0, 0, 100, 100, this);
		}
	
	public static void main(String[] args){
		JFrame test = new JFrame();
		test.setBounds(200, 200, 500, 500);
		LoadingPanel panel = new LoadingPanel(0,0);
		test.add(panel);
		test.setVisible(true);
		test.repaint();
	}
	

}
