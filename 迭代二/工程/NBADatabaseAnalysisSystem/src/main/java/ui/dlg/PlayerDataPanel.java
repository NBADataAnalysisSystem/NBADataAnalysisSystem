package ui.dlg;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerDataPanel extends JPanel {
	int x;
	int y;
	int width;
	int height;
	
	public PlayerDataPanel(int x,int y,int widthn,int heightn){
		
		this.x = x;
		this.y = y;
		this.width = widthn;
		this.height = heightn;
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		
		
	
		this.setOpaque(false);
		
	}
	
	JFrame frame;
	public void setFatherFrame(JFrame frame){
		this.frame = frame;
	}
}

