package ui.dlg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		//设置26个字母效果
		for(int i = 0;i < 26;i++){
			
			int tempW = (width - 40)/26;
			char temp = (char) ('A' + i);
			final JButton tempBtn = new JButton();
			tempBtn.setBounds(20 + i*tempW , 0, tempW, tempW);
			tempBtn.setFont(new Font("宋体",1, 20));//设置字体
			tempBtn.setBorderPainted(false);
			tempBtn.setMargin(new Insets(0,0,0,0));
			final JPanel panel = this;
			final JLabel btnChoosedLabel = new JLabel();
			tempBtn.addMouseListener(       new MouseAdapter(){
					public void mouseReleased(MouseEvent e){
		        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(tempBtn.getWidth(), tempBtn.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(tempBtn.getX(), tempBtn.getY(), tempBtn.getWidth(), tempBtn.getHeight());
					}
		            public void mouseEntered(MouseEvent e){

		        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(tempBtn.getWidth(), tempBtn.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(tempBtn.getX(), tempBtn.getY(), tempBtn.getWidth(), tempBtn.getHeight());
		            	tempBtn.setForeground(Color.decode("#FF0000"));
		            }
		            public void mouseExited(MouseEvent e){
		            	panel.remove(btnChoosedLabel);
		            	tempBtn.setBackground(null);
		            	tempBtn.setForeground(null);
		            }
		            public void mousePressed(MouseEvent e){
		            	
		            	ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButtonP.png");
		        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(tempBtn.getWidth(), tempBtn.getHeight(),Image.SCALE_DEFAULT));
		        		
		        		btnChoosedLabel.setIcon(btnChoosedIcon);
		        		btnChoosedLabel.setOpaque(false);
		        		
		        		panel.add(btnChoosedLabel);
		        		btnChoosedLabel.setBounds(tempBtn.getX(), tempBtn.getY(), tempBtn.getWidth(), tempBtn.getHeight());
		            	
		            }
		        
			}
   );
		//	tempBtn.setOpaque(false);
			tempBtn.setMargin(new Insets(0,0,0,0));
			tempBtn.setText(temp+"");
			tempBtn.	setContentAreaFilled(false);
			tempBtn.setBorderPainted(false);
			tempBtn.setFocusPainted(false);
		//	this.setOpaque(false);
			this.add(tempBtn);
			letterList.add(tempBtn);
			
		}
		
		selectTeam = new JComboBox<String>();
		this.add(selectTeam);
		selectTeam.setName("根据球队查找");
		selectTeam.setOpaque(false);
		selectTeam.setBounds(30 , (width - 40)/26+10, 200, (width - 40)/26);
		
		this.setLayout(null);
	}
	
	public static void main(String [] args){
		
		JFrame test = new JFrame();
		test.setSize(972, 97);
		test.setUndecorated(true);
		PlayerBasicInfoPanel panel = new PlayerBasicInfoPanel(0,0,972,97);
		panel.setBackground(Color.decode("#FF0000"));
	//	panel.setForeground(Color.decode("#FF0000"));
		panel.setVisible(true);
		test.add(panel);
		test.setVisible(true);
		
		
		
		
		
		
	}
	


}
