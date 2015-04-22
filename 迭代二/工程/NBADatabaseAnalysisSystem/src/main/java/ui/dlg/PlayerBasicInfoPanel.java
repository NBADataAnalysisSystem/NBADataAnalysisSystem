package ui.dlg;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlayerBasicInfoPanel extends JPanel{
	
	JComboBox<String> selectTeam;
	JComboBox<String> selectPosition;
	
	ArrayList<JButton> letterList ;
	
	int x;
	int y;
	int width;
	int height;
	
	public PlayerBasicInfoPanel(int x,int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setBounds(x, y, width, height);
		letterList = new ArrayList<JButton>();
		
		for(int i = 0;i < 26;i++){
			
			int tempW = (width - 40)/26;
			char temp = (char) ('A' + i);
			final JButton tempBtn = new JButton(temp+"");
			this.add(tempBtn);
			tempBtn.setBounds(20 + i*tempW , 0, tempW, tempW);
			tempBtn.setOpaque(false);
			tempBtn.setBorderPainted(false);
			tempBtn.setMargin(new Insets(0,0,0,0));
			tempBtn.addMouseMotionListener(       new MouseAdapter(){
		            public void mouseEntered(MouseEvent e){

		            	tempBtn.setBackground(Color.decode("#B0E0E6"));
		            }
		            public void mouseExited(MouseEvent e){
		            	tempBtn.setBackground(null);
		            }
			}
   );
			letterList.add(tempBtn);
			
		}
	}
	


}
