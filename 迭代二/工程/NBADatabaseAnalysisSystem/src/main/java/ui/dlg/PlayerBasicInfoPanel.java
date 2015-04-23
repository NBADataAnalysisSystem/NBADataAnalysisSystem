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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import ui.frame.PlayerFrame;

@SuppressWarnings("serial")
public class PlayerBasicInfoPanel extends JPanel{
	JComboBox<String> selectTeam;
	JComboBox<String> selectPosition;
	ArrayList<String> infoToShow;
	
	PlayerFrame frame;
	
	ArrayList<JButton> letterList ;
	
	int x;
	int y;
	int width;
	int height;
	
	String[] sift = new String[3];
	
	public PlayerBasicInfoPanel(int x,int y,int width,int height){
		
		UIManager.put("ComboBox.background", new Color(0,0,0,0));//me
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setBounds(x, y, width, height);
		letterList = new ArrayList<JButton>();
		infoToShow = new ArrayList<String>();
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
						if(panel.getComponentAt(panel.getMousePosition()) == tempBtn){
			        		ImageIcon btnChoosedIcon = new ImageIcon("resource/LetterButton.png");
			        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(tempBtn.getWidth(), tempBtn.getHeight(),Image.SCALE_DEFAULT));
			        		
			        		btnChoosedLabel.setIcon(btnChoosedIcon);
			        		btnChoosedLabel.setOpaque(false);
			        		
			        		panel.add(btnChoosedLabel);
			        		btnChoosedLabel.setBounds(tempBtn.getX(), tempBtn.getY(), tempBtn.getWidth(), tempBtn.getHeight());
			        		sift[0] = tempBtn.getText();
			        		sift();
		        		}
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
			tempBtn.setMargin(new Insets(0, 0, 0, 0));
			tempBtn.setText(temp+"");
			tempBtn.	setContentAreaFilled(false);
			tempBtn.setBorderPainted(false);
			tempBtn.setFocusPainted(false);
			this.setOpaque(false);
			this.add(tempBtn);
			letterList.add(tempBtn);
			
		}
		
		selectTeam = new JComboBox<String>();
		this.add(selectTeam);
		//selectTeam.setBackground(Color.decode("#FFFFFF"));//me
		selectTeam.setFont(new Font("Serif",1, 15));
		selectTeam.addItem("根据球队查找");
		selectTeam.setEditable(false);
		selectTeam.setOpaque(false);
		selectTeam.setBounds(30 , (width - 40)/26+10, 200, (width - 40)/26);
		
		selectTeam.setUI(new BasicComboBoxUI() {
			public void installUI(JComponent comboBox) {
				super.installUI(comboBox);
				listBox.setForeground(new Color(0, 0, 0, 0));
				listBox.setSelectionBackground(new Color(0, 0, 0, 0));
				listBox.setSelectionForeground(Color.BLACK);
			}
			
			protected JButton createArrowButton() {
				return new BasicArrowButton(BasicArrowButton.SOUTH);
			}
		});//me
		
		selectTeam.addMouseListener(       new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
					if(selectTeam.getSelectedItem().toString().equals("根据球队查找") == false){
						sift[1] = selectTeam.getSelectedItem().toString();
						sift();
					}
				}
			}
		);
		
		selectPosition = new JComboBox<String>();
		this.add(selectPosition);
		selectPosition.setBackground(Color.decode("#FFFFFF"));
		selectPosition.setFont(new Font("Serif",1, 15));
		selectPosition.addItem("根据位置查找");
		selectPosition.addItem("前锋");
		selectPosition.addItem("中锋");
		selectPosition.addItem("后卫");
		selectPosition.setEditable(false);
		selectPosition.setOpaque(false);
		selectPosition.setBounds(width-280 , (width - 40)/26+10, 200, (width - 40)/26);
		selectPosition.addMouseListener(       new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e){
					if(selectPosition.getSelectedItem().toString().equals("根据位置查找") == false){
						sift[2] = selectPosition.getSelectedItem().toString();
						sift();
					}
				}
			}
		);
		
		this.setLayout(null);
	}
	
	public void addTeamList(ArrayList<String> team){
		
		for(int i = 0;i < team.size() ; i++){
			selectTeam.addItem(team.get(i));
		}
		
	}
	
	public void setList(){
		
		infoToShow.add("号数");
		infoToShow.add("位置");
		infoToShow.add("身高");
		infoToShow.add("体重");
		infoToShow.add("出生日期");
		infoToShow.add("年龄");
		infoToShow.add("球龄");
		infoToShow.add("学校");
		infoToShow.add("球队");
		
	}
	
	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
		
	}
	
	public ArrayList<String> getList(){
		return infoToShow;
	}
	
	public void sift(){
		//根据sift[]对表格进行处理，sift[0]为首字母，sift[1]为球队，sift[2]为位置
	}
	

//	public static void main(String [] args){
//		
//		JFrame test = new JFrame();
//		test.setSize(972, 97);
//		test.setUndecorated(true);
//		PlayerBasicInfoPanel panel = new PlayerBasicInfoPanel(0,0,972,97);
//		panel.setBackground(Color.decode("#FF0000"));
//	//	panel.setForeground(Color.decode("#FF0000"));
//		panel.setVisible(true);
//		test.add(panel);
//		test.setVisible(true);
//		
//		
//		
//		
//		
//		
//	}
//	
	
	


}
