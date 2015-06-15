package ui.dlg;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.PlayerInfoType;
import ui.frame.PlayerFrame;

@SuppressWarnings("serial")
public class PlayerSeasonInfoPanel extends JPanel{
	
	JComboBox<String> selectUnion;
	JComboBox<String> selectPosition;
	JComboBox<String> selectOth;
	JComboBox<String> selectYear;
	JComboBox<String> selectType;
	//JComboBox<String> selectSeason;
	ArrayList<String> infoToShow;
	
	PlayerFrame frame;
	
	JButton submit ;
	
	int x;
	int y;
	int width;
	int height;
	
	String[] sift = new String[5];
	
	public PlayerSeasonInfoPanel(int x,int y,int width,int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.setBounds(x, y, width, height);
		infoToShow = new ArrayList<String>();
		this.setOpaque(false);
		this.setLayout(null);
		
		selectUnion = new JComboBox<String>();
		this.add(selectUnion);
		selectUnion.setFont(new Font("Serif",1, 15));
		selectUnion.setBackground(Color.decode("#FFFFFF"));
		selectUnion.addItem("全部联盟");
		selectUnion.addItem("东部");
		selectUnion.addItem("大西洋区");
		selectUnion.addItem("中央区");
		selectUnion.addItem("东南区");
		selectUnion.addItem("西部");
		selectUnion.addItem("西南区");
		selectUnion.addItem("西北区");
		selectUnion.addItem("太平洋区");
		selectUnion.setEditable(false);
		selectUnion.setOpaque(false);
		selectUnion.setBounds(50 ,0, (width - 300)/3, (height-20)/2);
		/*selectUnion.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (selectUnion.getSelectedItem().toString().equals("全部联盟")) {
					sift[0] = null;
				} else {
					sift[0] = selectUnion.getSelectedItem().toString();
				}
			}
		});*/
		
		selectPosition = new JComboBox<String>();
		this.add(selectPosition);
		selectPosition.setFont(new Font("Serif",1, 15));
		selectPosition.setBackground(Color.decode("#FFFFFF"));
		selectPosition.addItem("全部位置");
		selectPosition.addItem("前锋");
		selectPosition.addItem("中锋");
		selectPosition.addItem("后卫");
		selectPosition.setEditable(false);
		selectPosition.setOpaque(false);
		selectPosition.setBounds(50 + selectUnion.getWidth()+100 ,0, (width - 300)/3, (height-20)/2);
		/*selectPosition.addMouseListener(       new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				if (selectPosition.getSelectedItem().toString().equals("全部位置")) {
					sift[1] = null;
				} else {
					sift[1] = selectPosition.getSelectedItem().toString();
				}
			}
		});*/
		
		selectOth = new JComboBox<String>();
		this.add(selectOth);
		selectOth.setBackground(Color.decode("#FFFFFF"));
		selectOth.setFont(new Font("Serif",1, 15));
		selectOth.addItem("得分");
		selectOth.addItem("篮板");
		selectOth.addItem("助攻");
		selectOth.addItem("得分/篮板/助攻");
		selectOth.addItem("盖帽");
		selectOth.addItem("抢断");
		selectOth.addItem("犯规");
		selectOth.addItem("失误");
		selectOth.addItem("分钟");
		selectOth.addItem("效率");
		selectOth.addItem("投篮");
		selectOth.addItem("三分");
		selectOth.addItem("罚球");
		selectOth.addItem("两双");

		selectOth.setEditable(false);
		selectOth.setOpaque(false);
		selectOth.setBounds(50 + 2*selectUnion.getWidth()+200 ,0, (width - 300)/3, (height-20)/2);
		/*selectOth.addMouseListener(       new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
					sift[2] = selectOth.getSelectedItem().toString();
			}
		});*/
		
		selectYear = new JComboBox<String>();
		this.add(selectYear);
		selectYear.setBackground(Color.decode("#FFFFFF"));
		selectYear.setFont(new Font("Serif",1, 15));
		selectYear.addItem("2014-2015");
		selectYear.addItem("2013-2014");
		selectYear.addItem("2012-2013");
		selectYear.setEditable(false);
		selectYear.setOpaque(false);
		selectYear.setBounds(50 ,height/2, (width - 300)/3, (height-20)/2);
		/*selectYear.addMouseListener(       new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				sift[3] = selectYear.getSelectedItem().toString();
			}
		});*/
		
//		selectSeason = new JComboBox<String>();
//	//	this.add(selectSeason);
//		selectSeason.setBackground(Color.decode("#FFFFFF"));
//		selectSeason.setFont(new Font("Serif",1, 15));
//		selectSeason.addItem("常规赛");
//		selectSeason.addItem("季后赛");
//		selectSeason.addItem("季前赛");
//		selectSeason.setEditable(false);
//		selectSeason.setOpaque(false);
//		selectSeason.setBounds(50+  (width - 300)/6+10,height/2, (width - 300)/6-5, (height-20)/2);
//		/*selectYear.addMouseListener(       new MouseAdapter(){
//			public void mouseClicked(MouseEvent e){
//				sift[3] = selectYear.getSelectedItem().toString();
//			}
//		});*/
		
		selectType = new JComboBox<String>();
		this.add(selectType);
		selectType.setBackground(Color.decode("#FFFFFF"));
		selectType.setFont(new Font("Serif",1, 15));
		selectType.addItem("总数");
		selectType.addItem("场均");
		selectType.setEditable(false);
		selectType.setOpaque(false);
		selectType.setBounds(50 + selectUnion.getWidth()+100 ,height/2, (width - 300)/3, (height-20)/2);
		/*selectType.addMouseListener(       new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				sift[4] = selectType.getSelectedItem().toString();
			}
		});*/
		submit = new JButton("提交");
		submit.setFont(new Font("Serif",1, 15));
		this.add(submit);
		submit.setBounds(50 +2* selectUnion.getWidth()+200 ,height/2, (width - 300)/3, (height-20)/2);
		submit.setOpaque(false);
		submit.	setContentAreaFilled(false);
		submit.setBorderPainted(false);
		submit.setFocusPainted(false);
		final JPanel panel = this;
		final JLabel btnChoosedLabel = new JLabel();
		this.add(btnChoosedLabel);
		ImageIcon btnChoosedIcon = new ImageIcon("resource/SubmitUn.png");
		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
		
		btnChoosedLabel.setIcon(btnChoosedIcon);
		btnChoosedLabel.setOpaque(false);
		
		panel.add(btnChoosedLabel);
		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
		submit.addMouseListener(       new MouseAdapter(){
			
			public void mouseReleased(MouseEvent e){
	        		ImageIcon btnChoosedIcon = new ImageIcon("resource/SubmitUn.png");
	        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
	        		
	        		btnChoosedLabel.setIcon(btnChoosedIcon);
	        		btnChoosedLabel.setOpaque(false);
	        		
	        		panel.add(btnChoosedLabel);
	        		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
      
			}
            public void mousePressed(MouseEvent e){
            	
            	ImageIcon btnChoosedIcon = new ImageIcon("resource/SubmitP.png");
        		btnChoosedIcon.setImage(btnChoosedIcon.getImage().getScaledInstance(submit.getWidth(), submit.getHeight(),Image.SCALE_DEFAULT));
        		
        		btnChoosedLabel.setIcon(btnChoosedIcon);
        		btnChoosedLabel.setOpaque(false);
        		
        		panel.add(btnChoosedLabel);
        		btnChoosedLabel.setBounds(submit.getX(), submit.getY(), submit.getWidth(), submit.getHeight());
            	
            }
            
            public void mouseClicked(MouseEvent e){
            	
				if (selectUnion.getSelectedItem().toString().equals("全部联盟")) {
					sift[0] = null;
				} else {
					sift[0] = selectUnion.getSelectedItem().toString();
				}
				if (selectPosition.getSelectedItem().toString().equals("全部位置")) {
					sift[1] = null;
				} else {
					sift[1] = selectPosition.getSelectedItem().toString();
				}
            	sift[2] = selectOth.getSelectedItem().toString();
            	sift[3] = selectYear.getSelectedItem().toString();
            	sift[4] = selectType.getSelectedItem().toString();
            	//sift[5] = selectSeason.getSelectedItem().toString();
            	setList();
            	frame.setList(infoToShow);
            	if (sift[4].equals("总数")) {
                	frame.setPlayerInfoType(PlayerInfoType.PLAYER_SEASON_TOTAL_INFO);
            	} else {
                	frame.setPlayerInfoType(PlayerInfoType.PLAYER_SEASON_AVG_INFO);
            	}
            	changeInfo();
            	
            }
        
	}
		);
		
	}
	
	protected void changeInfo() {
		// TODO Auto-generated method stub
		frame.refreshData();
	}

	public void addTeamList(ArrayList<String> team){
		
		for(int i = 0;i < team.size() ; i++){
			selectUnion.addItem(team.get(i));
		}
		
	}
	
	public void setSift() {
		sift[2] = "得分";
		sift[3] = "2013-2014";
		sift[4] = "总数";
	//	sift[5] = "常规赛";
	}
	
	public void setList(){
		infoToShow.removeAll(infoToShow);
		if(sift[4].equals("总数")){
			infoToShow.add("排名");
			infoToShow.add("名字");
			infoToShow.add("球队");
			infoToShow.add("场数");
			infoToShow.add("先发");
			infoToShow.add("篮板");
			infoToShow.add("助攻");
			infoToShow.add("分钟");
			infoToShow.add("%");
			infoToShow.add("三分%");
			infoToShow.add("罚球%");
			infoToShow.add("进攻");
			infoToShow.add("防守");
			infoToShow.add("抢断");
			infoToShow.add("盖帽");
			infoToShow.add("失误");
			infoToShow.add("犯规");
			infoToShow.add("得分");
		}else{
			infoToShow.add("排名");
			infoToShow.add("名字");
			infoToShow.add("球队");
			infoToShow.add("场数");
			infoToShow.add("先发");
			infoToShow.add("场均篮板");
			infoToShow.add("场均助攻");
			infoToShow.add("分钟");
			infoToShow.add("效率");
			infoToShow.add("%");
			infoToShow.add("三分%");
			infoToShow.add("罚球%");
			infoToShow.add("进攻");
			infoToShow.add("防守");
			infoToShow.add("场均抢断");
			infoToShow.add("场均盖帽");
			infoToShow.add("失误");
			infoToShow.add("犯规");
			infoToShow.add("场均得分");
		}
		
	}
	
	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
		
	}
	
	public ArrayList<String> getList(){
		return infoToShow;
	}
	
	public String[] getSift(){
		//根据sift[]对表格进行处理，sift[0]为联盟，sift[1]为位置，sift[2]为排序依据，sift[3]为赛季，sift[4]为场均/总数
		return sift;
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
