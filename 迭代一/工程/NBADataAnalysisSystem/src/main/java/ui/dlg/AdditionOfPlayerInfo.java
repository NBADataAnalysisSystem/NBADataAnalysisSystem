package ui.dlg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

import ui.playerui.PlayerFrame;
import ui.playerui.SelectedInfoOfPlayer;

@SuppressWarnings("serial")
public class AdditionOfPlayerInfo extends InputDialog  {
	
	private JCheckBox numOfPlayer;
	private JCheckBox positionOfPlayer;
	private JCheckBox heightOfPlayer;
	private JCheckBox weightOfPlayer;
	private JCheckBox birthOfPlayer;
	private JCheckBox ageOfPlayer;
	private JCheckBox expOfPlayer;
	private JCheckBox schoolOfPlayer;
	private JCheckBox teamOfPlayer;
	private JCheckBox numOfEntryField;
	private JCheckBox numOfStartingField;
	private JCheckBox numOfRebound;
	private JCheckBox numOfAssist;
	private JCheckBox timeOfPresence;
	private JCheckBox numOfOffense;
	private JCheckBox numOfSteal;
	private JCheckBox numOfBlockShot;
	private JCheckBox numOfTurnOver;
	private JCheckBox numOfFoul;
	private JCheckBox scorling;
	
	SelectedInfoOfPlayer selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("勾选信息");
		this.setSize(500,250);
		this.setUndecorated(true);
		resetLocation();

		selectedItem = new SelectedInfoOfPlayer();
		selectedInfo = new ArrayList<>();
		
		numOfPlayer = new JCheckBox("号数");
		numOfPlayer.setSelected(false);
		
		positionOfPlayer = new JCheckBox("位置");
		positionOfPlayer.setSelected(false);
		
		heightOfPlayer = new JCheckBox("身高");
		heightOfPlayer.setSelected(false);
		
		weightOfPlayer = new JCheckBox("体重");
		weightOfPlayer.setSelected(false);
		
		birthOfPlayer = new JCheckBox("出生日期");
		birthOfPlayer.setSelected(false);
		
		ageOfPlayer = new JCheckBox("年龄");
		ageOfPlayer.setSelected(false);
		
		expOfPlayer = new JCheckBox("球龄");
		expOfPlayer.setSelected(false);
		
		schoolOfPlayer = new JCheckBox("学校");
		schoolOfPlayer.setSelected(false);
		
		teamOfPlayer = new JCheckBox("所在球队");
		teamOfPlayer.setSelected(false);
		
		numOfEntryField = new JCheckBox("参赛场数");
		numOfEntryField.setSelected(false);
		
		numOfStartingField = new JCheckBox("先发场数");
		numOfStartingField.setSelected(false);
		
		numOfRebound = new JCheckBox("篮板数");
		numOfRebound.setSelected(false);
		
		numOfAssist = new JCheckBox("助攻数");
		numOfAssist.setSelected(false);
		
		timeOfPresence = new JCheckBox("在场时间");
		timeOfPresence.setSelected(false);
		
		numOfOffense = new JCheckBox("防守数");
		numOfOffense.setSelected(false);
		
		numOfSteal = new JCheckBox("抢断数");
		numOfSteal.setSelected(false);
		
		numOfBlockShot = new JCheckBox("盖帽数");
		numOfBlockShot.setSelected(false);
		
		numOfTurnOver = new JCheckBox("失误数");
		numOfTurnOver.setSelected(false);
		
		numOfFoul = new JCheckBox("犯规数");
		numOfFoul.setSelected(false);
		
		scorling = new JCheckBox("得分");
		scorling.setSelected(false);
		
		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		checkPanel.add(numOfPlayer);
		checkPanel.add(positionOfPlayer);
		checkPanel.add(heightOfPlayer);
		checkPanel.add(weightOfPlayer);
		checkPanel.add(birthOfPlayer);
		checkPanel.add(ageOfPlayer);
		checkPanel.add(expOfPlayer);
		checkPanel.add(schoolOfPlayer);
		checkPanel.add(teamOfPlayer);
		checkPanel.add(numOfEntryField);
		checkPanel.add(numOfStartingField);
		checkPanel.add(numOfRebound);
		checkPanel.add(numOfAssist);
		checkPanel.add(timeOfPresence);
		checkPanel.add(numOfOffense);
		checkPanel.add(numOfSteal);
		checkPanel.add(numOfBlockShot);
		checkPanel.add(numOfTurnOver);
		checkPanel.add(numOfFoul);
		checkPanel.add(scorling);
		checkPanel.setSize(500, 500);
		
		 //numOfPlayer.addItemListener(this);
//		 positionOfPlayer.addItemListener(this);
//		 heightOfPlayer.addItemListener(this);
//		 weightOfPlayer.addItemListener(this);
//		 birthOfPlayer.addItemListener(this);
//		 ageOfPlayer.addItemListener(this);
//		 expOfPlayer.addItemListener(this);
//		 schoolOfPlayer.addItemListener(this);
//		 teamOfPlayer.addItemListener(this);
//		 numOfEntryField.addItemListener(this);
//		 numOfStartingField.addItemListener(this);
//		 numOfRebound.addItemListener(this);
//		 numOfAssist.addItemListener(this);
//		 timeOfPresence.addItemListener(this);
//		 numOfOffense.addItemListener(this);
//		 numOfSteal.addItemListener(this);
//		 numOfBlockShot.addItemListener(this);
//		 numOfTurnOver.addItemListener(this);
//		 numOfFoul.addItemListener(this);
//		 scorling.addItemListener(this);
		
		checkPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(checkPanel);
		checkPanel.setVisible(true);
		this.setAlwaysOnTop(true);
		
		JPanel bp = new JPanel();
		bp.setBorder(BorderFactory.createEtchedBorder());
		bp.add(btn_apply);
		bp.add(btn_cancel);
		this.add(bp, BorderLayout.SOUTH);
		
		
	}
	
	PlayerFrame frame;

	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
		alreadySelected = frame.getList();
		judgeSelect();

	}

	public void judgeSelect(){
			if(alreadySelected.contains("号数")){
				numOfPlayer.setSelected(true);
			}if(alreadySelected.contains("位置")){
				positionOfPlayer.setSelected(true);
			} if(alreadySelected.contains("身高")){
				heightOfPlayer.setSelected(true);
			}if(alreadySelected.contains("体重")){
				weightOfPlayer.setSelected(true);
			} if(alreadySelected.contains("出生日期")){
				birthOfPlayer.setSelected(true);
			}if(alreadySelected.contains("年龄")){
				ageOfPlayer.setSelected(true);
			}if(alreadySelected.contains("球龄")){
				expOfPlayer.setSelected(true);
			}if(alreadySelected.contains("学校")){
				schoolOfPlayer.setSelected(true);
			}if(alreadySelected.contains("所在球队")){
				teamOfPlayer.setSelected(true);
			} if(alreadySelected.contains("参赛场数")){
				numOfEntryField.setSelected(true);
			}if(alreadySelected.contains("先发场数")){
				numOfStartingField.setSelected(true);
			}if(alreadySelected.contains("篮板数")){
				numOfRebound.setSelected(true);
			}if(alreadySelected.contains("助攻数")){
				numOfAssist.setSelected(true);
			}if(alreadySelected.contains("在场时间")){
				timeOfPresence.setSelected(true);
			}if(alreadySelected.contains("防守数")){
				numOfOffense.setSelected(true);
			}if(alreadySelected.contains("抢断数")){
				numOfSteal.setSelected(true);
			}if(alreadySelected.contains("盖帽数")){
				numOfBlockShot.setSelected(true);
			}if(alreadySelected.contains("失误数")){
				numOfTurnOver.setSelected(true);
			}if(alreadySelected.contains("犯规数")){
				numOfFoul.setSelected(true);
			}if(alreadySelected.contains("得分")){
				scorling.setSelected(true);
			}	
	}

	public void checkBoxSelected() {
	      //获取改变的复选按键
	      // Object source = e.getItemSelectable();
	       if (numOfPlayer.isSelected() == true) {
	    	   
	    	   selectedItem.selectNumOfPlayer();
	    	   
	       }  if(positionOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectPositionOfPlayer();
	        
	       }if(heightOfPlayer.isSelected() == true){
	      
	    	   selectedItem.selectHeightOfPlayer();
	    	   
	       }if(weightOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectWeightOfPlayer();
	  
	       }if(birthOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectBirthOfPlayer();
	  
	       }if(ageOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectAgeOfPlayer();
	  
	       }if(expOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectExpOfPlayer();
	  
	       }if(schoolOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectSchoolOfPlayer();
	  
	       }if(teamOfPlayer.isSelected() == true){
	    	   
	    	   selectedItem.selectTeamOfPlayer();
	  
	       }if(numOfEntryField.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfEntryField();
	  
	       }if(numOfStartingField.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfStartingField();
	  
	       }if(numOfRebound.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfRebound();
	  
	       }if(numOfAssist.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfAssist();
	  
	       }if(timeOfPresence.isSelected() == true){
	    	   
	    	   selectedItem.selectTimeOfPresence();
	  
	       }if(numOfOffense.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfOffense();
	  
	       }if(numOfSteal.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfSteal();
	  
	       }if(numOfBlockShot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfBlockShot();
	  
	       }if(numOfTurnOver.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfTurnOver();
	  
	       }if(numOfFoul.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfFoul();
	  
	       }if(scorling.isSelected() == true){
	    	   
	    	   selectedItem.selectScorling();
	  
	       }
	       
		ArrayList<String> tempList = selectedItem.getSelectedList();
	       selectedInfo = tempList;
	      
	        
	    }
	public void setList(ArrayList<String> temp){
		
		selectedInfo = temp;
		
	}
	
	public ArrayList<String> getList(){
		
		return selectedInfo;
		
	}
	
	public void apply(){
		
		checkBoxSelected();
//		ArrayList<String> tempList = new ArrayList<>(); 
//		tempList = frame.getList();
//		for (int i = 0;i<selectedInfo.size();i++){
//			if( frame.getList().contains(selectedInfo.get(i)) ){
//				//tempList.remove(tempList.indexOf(selectedInfo.get(i)));
//				selectedInfo.remove(i);
//				i--;
//			}
//		}
		//System.out.println(this.getList().get(0));
//		selectedInfo = tempList;
		frame.setList(selectedInfo);
		frame.setString();
		frame.refreshData();
		frame.changeTableColumns();
		AWTUtilities.setWindowOpacity(frame, 1f);
		dispose();
		
	}

}
