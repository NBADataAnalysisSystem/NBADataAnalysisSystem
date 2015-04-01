package ui.dlg;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

import ui.playerui.PlayerFrame;
import ui.playerui.SelectedInfoOfPlayer;

@SuppressWarnings({ "serial", "restriction" })
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
	private JCheckBox numOfDffense;
	private JCheckBox numOfSteal;
	private JCheckBox numOfBlockShot;
	private JCheckBox numOfTurnOver;
	private JCheckBox numOfFoul;
	private JCheckBox scorling;
	private JCheckBox numOfShoot ;
	private JCheckBox numOfShot;
	private JCheckBox numOfThreePointShoot  ;
	private JCheckBox numOfThreePointShot ;
	private JCheckBox numOfFreeThrowShoot ;
	private JCheckBox numOfFreeThrowShot ;
	
	private JCheckBox aveNumOfRebound;
	private JCheckBox aveNumOfAssist;
	private JCheckBox aveNumOfOffense;
	private JCheckBox aveNumOfDffense;
	private JCheckBox aveTimeOfPresence;
	private JCheckBox aveNumOfSteal;
	private JCheckBox aveNumOfBlockShot;
	private JCheckBox aveNumOfTurnOver;
	private JCheckBox aveNumOfFoul;
	private JCheckBox aveScorling;
	private JCheckBox aveNumOfShoot ;
	private JCheckBox aveNumOfShot;
	private JCheckBox aveNumOfThreePointShoot  ;
	private JCheckBox aveNumOfThreePointShot ;
	private JCheckBox aveNumOfFreeThrowShoot ;
	private JCheckBox aveNumOfFreeThrowShot ;
	
	JComboBox<String> sort = new JComboBox<String>();
	JComboBox<String> infoOfSort = new JComboBox<String>();
	JLabel sortLabel = new JLabel("升/降序依据");
	String sortTrans = new String();
	
	SelectedInfoOfPlayer selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("勾选信息");
		this.setSize(500,500);
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
		
		numOfOffense = new JCheckBox("进攻数");
		numOfOffense.setSelected(false);
		
		numOfDffense = new JCheckBox("防守数");
		numOfDffense.setSelected(false);
		
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
		
		numOfShoot = new JCheckBox("投篮命中数");
		numOfShot = new JCheckBox("投篮数");
		numOfThreePointShoot  =new JCheckBox( "三分球命中数");
		numOfThreePointShot =new JCheckBox( "三分球总数");
		numOfFreeThrowShoot = new JCheckBox("罚球命中数");
		numOfFreeThrowShot = new JCheckBox("罚球总数");
		
		aveNumOfRebound = new JCheckBox( "场均篮板数");
		aveNumOfAssist= new JCheckBox("场均助攻数");
		aveNumOfOffense= new JCheckBox("场均进攻数");
		aveNumOfDffense= new JCheckBox("场均防守数");
		aveNumOfSteal= new JCheckBox("场均抢断数");
		aveNumOfBlockShot= new JCheckBox( "场均盖帽数");
		aveNumOfTurnOver= new JCheckBox( "场均失误数");
		aveNumOfFoul= new JCheckBox("场均犯规数");
		aveTimeOfPresence = new JCheckBox("场均在场时间");
		aveScorling= new JCheckBox("场均得分");
		aveNumOfShoot = new JCheckBox("场均投篮命中数");
		aveNumOfShot= new JCheckBox("场均投篮数");
		aveNumOfThreePointShoot  = new JCheckBox("场均三分球命中数");
		aveNumOfThreePointShot = new JCheckBox( "场均三分球总数");
		aveNumOfFreeThrowShoot = new JCheckBox("场均罚球命中数");
		aveNumOfFreeThrowShot = new JCheckBox("场均罚球总数");
		
		JPanel basicInfoPanel = new JPanel(new GridLayout(3,3));
		basicInfoPanel.setBorder(BorderFactory.createTitledBorder("基础信息"));
		basicInfoPanel.add(numOfPlayer);
		basicInfoPanel.add(positionOfPlayer);
		basicInfoPanel.add(heightOfPlayer);
		basicInfoPanel.add(weightOfPlayer);
		basicInfoPanel.add(birthOfPlayer);
		basicInfoPanel.add(ageOfPlayer);
		basicInfoPanel.add(expOfPlayer);
		basicInfoPanel.add(schoolOfPlayer);
		basicInfoPanel.add(teamOfPlayer);
		
		JPanel seasonInfoPanel = new JPanel(new GridLayout(6,3));
		seasonInfoPanel.setBorder(BorderFactory.createTitledBorder("赛季信息"));
		seasonInfoPanel.add(numOfEntryField);
		seasonInfoPanel.add(numOfStartingField);
		seasonInfoPanel.add(numOfRebound);
		seasonInfoPanel.add(numOfAssist);
		seasonInfoPanel.add(timeOfPresence);
		seasonInfoPanel.add(numOfOffense);
		seasonInfoPanel.add(numOfDffense);
		seasonInfoPanel.add(numOfSteal);
		seasonInfoPanel.add(numOfBlockShot);
		seasonInfoPanel.add(numOfTurnOver);
		seasonInfoPanel.add(numOfFoul);
		seasonInfoPanel.add(scorling);
		seasonInfoPanel.add(numOfShoot);
		seasonInfoPanel.add(numOfShot);
		seasonInfoPanel.add(numOfThreePointShoot);
		seasonInfoPanel.add(numOfThreePointShot );
		seasonInfoPanel.add(numOfFreeThrowShoot);
		seasonInfoPanel.add(numOfFreeThrowShot);
		
		JPanel aveSeasonInfoPanel = new JPanel(new GridLayout(6,3));
		aveSeasonInfoPanel.setBorder(BorderFactory.createTitledBorder("场均信息"));
		aveSeasonInfoPanel.add(aveNumOfRebound);
		aveSeasonInfoPanel.add(aveNumOfAssist);
		aveSeasonInfoPanel.add(aveNumOfOffense);
		aveSeasonInfoPanel.add(aveNumOfDffense);
		aveSeasonInfoPanel.add(aveTimeOfPresence);
		aveSeasonInfoPanel.add(aveNumOfSteal);
		aveSeasonInfoPanel.add(aveNumOfBlockShot);
		aveSeasonInfoPanel.add(aveNumOfTurnOver);
		aveSeasonInfoPanel.add(aveNumOfFoul);
		aveSeasonInfoPanel.add(aveScorling);
		aveSeasonInfoPanel.add(aveNumOfShoot);
		aveSeasonInfoPanel.add(aveNumOfShot);
		aveSeasonInfoPanel.add(aveNumOfThreePointShoot);
		aveSeasonInfoPanel.add(aveNumOfThreePointShot );
		aveSeasonInfoPanel.add(aveNumOfFreeThrowShoot);
		aveSeasonInfoPanel.add(aveNumOfFreeThrowShot);
		
		JPanel totalPanel = new JPanel(new GridLayout(4,1));

		sort.addItem("升序");
		sort.addItem("降序");
		sort.addItem("字母序");

		infoOfSort.addItem("ID");
		infoOfSort.addItem("号数");
		infoOfSort.addItem("身高");
		infoOfSort.addItem("体重");	
		infoOfSort.addItem("出生日期");
		infoOfSort.addItem("年龄");	
		infoOfSort.addItem("球龄");	
		infoOfSort.addItem("参赛场数");
		infoOfSort.addItem("先发场数");
		infoOfSort.addItem("篮板数");
		infoOfSort.addItem("助攻数");
		infoOfSort.addItem("在场时间（秒）");
		infoOfSort.addItem("防守数");
		infoOfSort.addItem("进攻数");
		infoOfSort.addItem("抢断数");
		infoOfSort.addItem("盖帽数");
		infoOfSort.addItem("失误数");
		infoOfSort.addItem("犯规数");
		infoOfSort.addItem("得分");
		infoOfSort.addItem("投篮命中数");
		infoOfSort.addItem("投篮数");
		infoOfSort.addItem( "三分球命中数");
		infoOfSort.addItem( "三分球总数");
		infoOfSort.addItem("罚球命中数");
		infoOfSort.addItem("罚球总数");
		
		infoOfSort.addItem("场均篮板数");
		infoOfSort.addItem("场均助攻数");
		infoOfSort.addItem("场均在场时间（秒）");
		infoOfSort.addItem("场均防守数");
		infoOfSort.addItem("场均进攻数");
		infoOfSort.addItem("场均抢断数");
		infoOfSort.addItem("场均盖帽数");
		infoOfSort.addItem("场均失误数");
		infoOfSort.addItem("场均犯规数");
		infoOfSort.addItem("场均得分");
		infoOfSort.addItem("场均投篮命中数");
		infoOfSort.addItem("场均投篮数");
		infoOfSort.addItem( "场均三分球命中数");
		infoOfSort.addItem( "场均三分球总数");
		infoOfSort.addItem("场均罚球命中数");
		infoOfSort.addItem("场均罚球总数");
		
		
		
		//basicInfoPanel.setBorder(BorderFactory.createEtchedBorder());
		basicInfoPanel.setVisible(true);
		this.setAlwaysOnTop(true);
		
		JPanel sortPanel = new JPanel();
		sortPanel.setBorder(BorderFactory.createEtchedBorder());
		sortPanel.add(sortLabel);
		sortPanel.add(sort);
		sortPanel.add(infoOfSort);
		sortPanel.setSize(500, 20);
		
		
		JPanel bp = new JPanel();
		bp.setBorder(BorderFactory.createEtchedBorder());
		bp.add(sortPanel,BorderLayout.NORTH);
		bp.add(btn_apply);
		bp.add(btn_cancel);
		
		totalPanel.add(basicInfoPanel);
		totalPanel.add(seasonInfoPanel);
		totalPanel.add(aveSeasonInfoPanel);
		totalPanel.add(bp);

		this.add(totalPanel);
		
		
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
			}if(alreadySelected.contains("在场时间（秒）")){
				timeOfPresence.setSelected(true);
			}if(alreadySelected.contains("进攻数")){
				numOfOffense.setSelected(true);
			}if(alreadySelected.contains("防守数")){
				numOfDffense.setSelected(true);
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
			}if(alreadySelected.contains("场均投篮命中数")){
				aveNumOfShoot.setSelected(true);
			}if(alreadySelected.contains("场均投篮数")){
				aveNumOfShot.setSelected(true);
			}if(alreadySelected.contains("场均三分球命中数")){
				aveNumOfThreePointShoot.setSelected(true);
			}if(alreadySelected.contains("场均三分球总数")){
				aveNumOfThreePointShot .setSelected(true);
			}if(alreadySelected.contains("场均罚球命中数")){
				aveNumOfFreeThrowShoot.setSelected(true);
			}if(alreadySelected.contains("场均罚球总数")){
				aveNumOfFreeThrowShot.setSelected(true);
			}if(alreadySelected.contains("场均篮板数")){
				aveNumOfRebound.setSelected(true);
			}if(alreadySelected.contains("场均助攻数")){
				aveNumOfAssist.setSelected(true);
			}if(alreadySelected.contains("场均在场时间（秒）")){
				aveTimeOfPresence.setSelected(true);
			}if(alreadySelected.contains("场均进攻数")){
				aveNumOfOffense.setSelected(true);
			}if(alreadySelected.contains("场均防守数")){
				aveNumOfDffense.setSelected(true);
			}if(alreadySelected.contains("场均抢断数")){
				aveNumOfSteal.setSelected(true);
			}if(alreadySelected.contains("场均盖帽数")){
				aveNumOfBlockShot.setSelected(true);
			}if(alreadySelected.contains("场均失误数")){
				aveNumOfTurnOver.setSelected(true);
			}if(alreadySelected.contains("场均犯规数")){
				aveNumOfFoul.setSelected(true);
			}if(alreadySelected.contains("场均得分")){
				aveScorling.setSelected(true);
			}if(alreadySelected.contains("场均投篮命中数")){
				aveNumOfShoot.setSelected(true);
			}if(alreadySelected.contains("场均投篮数")){
				aveNumOfShot.setSelected(true);
			}if(alreadySelected.contains("场均三分球命中数")){
				aveNumOfThreePointShoot.setSelected(true);
			}if(alreadySelected.contains("场均三分球总数")){
				aveNumOfThreePointShot .setSelected(true);
			}if(alreadySelected.contains("场均罚球命中数")){
				aveNumOfFreeThrowShoot.setSelected(true);
			}if(alreadySelected.contains("场均罚球总数")){
				aveNumOfFreeThrowShot.setSelected(true);
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
	  
	       }if(numOfDffense.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfDffense();
	  
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
	  
	       }if(aveNumOfShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfShoot();
	  
	       }if(aveNumOfShot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfShot();
	  
	       }if(aveNumOfThreePointShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfThreePointShoot();
	  
	       }if(aveNumOfThreePointShot .isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfThreePointShot ();
	  
	       }if(aveNumOfFreeThrowShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfFreeThrowShoot();
	  
	       }if(aveNumOfFreeThrowShot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfFreeThrowShot();
	  
	       }if(aveNumOfRebound.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfRebound();
	  
	       }if(aveNumOfAssist.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfAssist();
	  
	       }if(aveTimeOfPresence.isSelected() == true){
	    	   
	    	   selectedItem.selectAveTimeOfPresence();
	  
	       }if(aveNumOfOffense.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfOffense();
	  
	       }if(aveNumOfDffense.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfDffense();
	  
	       }if(aveNumOfSteal.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfSteal();
	  
	       }if(aveNumOfBlockShot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfBlockShot();
	  
	       }if(aveNumOfTurnOver.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfTurnOver();
	  
	       }if(aveNumOfFoul.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfFoul();
	  
	       }if(aveScorling.isSelected() == true){
	    	   
	    	   selectedItem.selectAveScorling();
	  
	       }if(aveNumOfShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfShoot();
	  
	       }if(aveNumOfShot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfShot();
	  
	       }if(aveNumOfThreePointShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfThreePointShoot();
	  
	       }if(aveNumOfThreePointShot .isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfThreePointShot ();
	  
	       }if(aveNumOfFreeThrowShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfFreeThrowShoot();
	  
	       }if(aveNumOfFreeThrowShot.isSelected() == true){
	    	   
	    	   selectedItem.selectAveNumOfFreeThrowShot();
	  
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
	
	public void setSort(){
	
		sortTrans = sort.getSelectedItem().toString() + ";" + infoOfSort.getSelectedItem().toString();
		
	}
	
	public String getSort(){
		
		return sortTrans;
		
	}
	
	public void apply(){
		
		this.setSort();
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
		frame.setSort(sortTrans);
		frame.changeTableColumns();
		AWTUtilities.setWindowOpacity(frame, 1f);
		frame.refreshData();
		dispose();
		
	}

}
