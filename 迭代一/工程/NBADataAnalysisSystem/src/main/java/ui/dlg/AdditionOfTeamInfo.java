package ui.dlg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

import ui.teamui.SelectedInfoOfTeam;
import ui.teamui.TeamFrame;

@SuppressWarnings("serial")
public class AdditionOfTeamInfo extends InputDialog  {
	
	private JCheckBox fullName;
	private JCheckBox abeerName;
	private JCheckBox location;
	private JCheckBox zone;
	private JCheckBox division;
	private JCheckBox homeCourt;
	private JCheckBox builtTime;
	
	SelectedInfoOfTeam selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfTeamInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("勾选信息");
		this.setSize(500,250);
		this.setUndecorated(true);
		resetLocation();

		selectedItem = new SelectedInfoOfTeam();
		selectedInfo = new ArrayList<>();
		
		fullName = new JCheckBox("全称");
		fullName.setSelected(false);
		
		abeerName = new JCheckBox("简称");
		abeerName.setSelected(false);
		
		location = new JCheckBox("位置");
		location.setSelected(false);
		
		zone = new JCheckBox("赛区");
		zone.setSelected(false);
		
		division = new JCheckBox("联盟");
		division.setSelected(false);
		
		homeCourt = new JCheckBox("主场");
		homeCourt.setSelected(false);
		
		builtTime = new JCheckBox("成立时间");
		builtTime.setSelected(false);
		
		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		checkPanel.add(fullName);
		checkPanel.add(abeerName);
		checkPanel.add(location);
		checkPanel.add(zone);
		checkPanel.add(division);
		checkPanel.add(homeCourt);
		checkPanel.add(builtTime);
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
	
	TeamFrame frame;

	public void setTeamFrame(TeamFrame frame){
		this.frame = frame;
		alreadySelected = frame.getList();
		judgeSelect();

	}

	public void judgeSelect(){
			if(alreadySelected.contains("全称")){
				fullName.setSelected(true);
			}if(alreadySelected.contains("简称")){
				abeerName.setSelected(true);
			} if(alreadySelected.contains("位置")){
				location.setSelected(true);
			}if(alreadySelected.contains("赛区")){
				zone.setSelected(true);
			} if(alreadySelected.contains("联盟")){
				division.setSelected(true);
			}if(alreadySelected.contains("主场")){
				homeCourt.setSelected(true);
			}if(alreadySelected.contains("成立时间")){
				builtTime.setSelected(true);
			}
	}

	public void checkBoxSelected() {
	      //获取改变的复选按键
	      // Object source = e.getItemSelectable();
	       if (fullName.isSelected() == true) {
	    	   
	    	   selectedItem.selectFullName();
	    	   
	       }  if(abeerName.isSelected() == true){
	    	   
	    	   selectedItem.selectAbeerName();
	        
	       }if(location.isSelected() == true){
	      
	    	   selectedItem.selectLocation();
	    	   
	       }if(zone.isSelected() == true){
	    	   
	    	   selectedItem.selectZone();
	  
	       }if(division.isSelected() == true){
	    	   
	    	   selectedItem.selectDivision();
	  
	       }if(homeCourt.isSelected() == true){
	    	   
	    	   selectedItem.selectHomeCourt();
	  
	       }if(builtTime.isSelected() == true){
	    	   
	    	   selectedItem.selectBuiltTime();
	  
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
