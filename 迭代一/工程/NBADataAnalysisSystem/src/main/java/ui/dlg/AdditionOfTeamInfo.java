package ui.dlg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.awt.AWTUtilities;

import ui.teamui.SelectedInfoOfTeam;
import ui.teamui.TeamFrame;

@SuppressWarnings({ "serial", "restriction" })
public class AdditionOfTeamInfo extends InputDialog  {
	
//	private JCheckBox fullName;
//	private JCheckBox abeerName;
	private JCheckBox location;
	private JCheckBox zone;
	private JCheckBox division;
	private JCheckBox homeCourt;
	private JCheckBox builtTime;
	private JCheckBox rebounds;
	private JCheckBox assists;
	private JCheckBox presenceTime;
	private JCheckBox offences;
	private JCheckBox defences;
	private JCheckBox steals;
	private JCheckBox blockShots;
	private JCheckBox turnOvers;
	private JCheckBox fouls;
	private JCheckBox score;
	private JCheckBox shootings;
	private JCheckBox shots;
	private JCheckBox threePointShots;
	private JCheckBox threePointShootings;
	private JCheckBox  freeThrowShots;
	private JCheckBox freeThrowShoots;
	private JCheckBox numOfMatch;
	
	JComboBox<String> sort = new JComboBox<String>();
	JComboBox<String> infoOfSort = new JComboBox<String>();
	JLabel sortLabel = new JLabel("升/降序依据");
	String sortTrans = new String();

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
		
//		fullName = new JCheckBox("全称");
//		fullName.setSelected(false);
//		
//		abeerName = new JCheckBox("简称");
//		abeerName.setSelected(false);
		
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
		
		rebounds = new JCheckBox("篮板数");
		assists = new JCheckBox("助攻数");
		presenceTime = new JCheckBox("在场时间（秒）");
		offences = new JCheckBox("防守数");
		defences =new JCheckBox( "进攻数");
		steals = new JCheckBox("抢断数");
		blockShots = new JCheckBox("盖帽数");
		turnOvers = new JCheckBox("失误数");
		fouls =new JCheckBox( "犯规数");
		score =new JCheckBox( "得分");
		shootings = new JCheckBox("投篮命中数");
		shots =new JCheckBox( "投篮数");
		threePointShots =new JCheckBox( "三分球数");
		threePointShootings =new JCheckBox( "三分球命中数");
		 freeThrowShots = new JCheckBox("罚球数");
		freeThrowShoots = new JCheckBox("罚球命中数");
		numOfMatch =new JCheckBox( "比赛数");

		
		JPanel checkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		checkPanel.add(fullName);
//		checkPanel.add(abeerName);
		checkPanel.add(location);
		checkPanel.add(zone);
		checkPanel.add(division);
		checkPanel.add(homeCourt);
		checkPanel.add(builtTime);
		checkPanel.add(rebounds);
		checkPanel.add(assists);
		checkPanel.add(presenceTime);
		checkPanel.add(offences);
		checkPanel.add(defences);
		checkPanel.add(steals);
		checkPanel.add(blockShots);
		checkPanel.add(turnOvers);
		checkPanel.add(fouls);
		checkPanel.add(score);
		checkPanel.add(shootings);
		checkPanel.add(shots);
		checkPanel.add(threePointShots);
		checkPanel.add(threePointShootings);
		checkPanel.add(freeThrowShots);
		checkPanel.add(freeThrowShoots);
		checkPanel.add(numOfMatch);
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
		sort.addItem("升序");
		sort.addItem("降序");
		sort.addItem("字母序");

		infoOfSort.addItem("ID");
		infoOfSort.addItem("全称");
		infoOfSort.addItem("简称");
		infoOfSort.addItem("位置");	
		infoOfSort.addItem("赛区");
		infoOfSort.addItem("联盟");	
		infoOfSort.addItem("主场");	
		infoOfSort.addItem("成立时间");
		infoOfSort.addItem("篮板数");
		infoOfSort.addItem("助攻数");
		infoOfSort.addItem("在场时间");
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
		infoOfSort.addItem("比赛数");
		
		checkPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(checkPanel);
		checkPanel.setVisible(true);
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
		this.add(bp, BorderLayout.SOUTH);
		
		
	}
	
	TeamFrame frame;

	public void setTeamFrame(TeamFrame frame){
		this.frame = frame;
		alreadySelected = frame.getList();
		judgeSelect();

	}

	public void judgeSelect(){
//			if(alreadySelected.contains("全称")){
//				fullName.setSelected(true);
//			}if(alreadySelected.contains("简称")){
//				abeerName.setSelected(true);
//			}
		if(alreadySelected.contains("位置")){
				location.setSelected(true);
			}if(alreadySelected.contains("赛区")){
				zone.setSelected(true);
			} if(alreadySelected.contains("联盟")){
				division.setSelected(true);
			}if(alreadySelected.contains("主场")){
				homeCourt.setSelected(true);
			}if(alreadySelected.contains("成立时间")){
				builtTime.setSelected(true);
			}if(alreadySelected.contains("篮板数")){
				rebounds.setSelected(true);
			}if(alreadySelected.contains("助攻数")){
				assists.setSelected(true);
			}if(alreadySelected.contains("在场时间")){
				presenceTime.setSelected(true);
			}if(alreadySelected.contains("防守数")){
				offences.setSelected(true);
			}if(alreadySelected.contains("进攻数")){
				defences.setSelected(true);
			}if(alreadySelected.contains("抢断数")){
				steals.setSelected(true);
			}if(alreadySelected.contains("盖帽数")){
				blockShots.setSelected(true);
			}if(alreadySelected.contains("失误数")){
				turnOvers.setSelected(true);
			}if(alreadySelected.contains("犯规数")){
				fouls.setSelected(true);
			}if(alreadySelected.contains("得分")){
				score.setSelected(true);
			}if(alreadySelected.contains("投篮命中数")){
				shootings.setSelected(true);
			}if(alreadySelected.contains("投篮数")){
				shots.setSelected(true);
			}if(alreadySelected.contains("三分球数")){
				threePointShots.setSelected(true);
			}if(alreadySelected.contains("三分球命中数")){
				threePointShootings.setSelected(true);
			}if(alreadySelected.contains("罚球数")){
				freeThrowShots.setSelected(true);
			}if(alreadySelected.contains("罚球命中数")){
				freeThrowShoots.setSelected(true);
			}if(alreadySelected.contains("比赛数")){
				numOfMatch.setSelected(true);
			}
	}

	public void checkBoxSelected() {
	      //获取改变的复选按键
	      // Object source = e.getItemSelectable();
//	       if (fullName.isSelected() == true) {
//	    	   
//	    	   selectedItem.selectFullName();
//	    	   
//	       }  if(abeerName.isSelected() == true){
//	    	   
//	    	   selectedItem.selectAbeerName();
//	        
//	       }
		if(location.isSelected() == true){
	      
	    	   selectedItem.selectLocation();
	    	   
	       }if(zone.isSelected() == true){
	    	   
	    	   selectedItem.selectZone();
	  
	       }if(division.isSelected() == true){
	    	   
	    	   selectedItem.selectDivision();
	  
	       }if(homeCourt.isSelected() == true){
	    	   
	    	   selectedItem.selectHomeCourt();
	  
	       }if(builtTime.isSelected() == true){
	    	   
	    	   selectedItem.selectBuiltTime();
	  
	       }if(rebounds.isSelected() == true){
	    	   
	    	   selectedItem.selectRebounds();
	  
	       }if(assists.isSelected() == true){
	    	   
	    	   selectedItem.selectAssists();
	  
	       }if(presenceTime.isSelected() == true){
	    	   
	    	   selectedItem.selectPresenceTime();
	  
	       }if(offences.isSelected() == true){
	    	   
	    	   selectedItem.selectOffences();
	  
	       }if(defences.isSelected() == true){
	    	   
	    	   selectedItem.selectDefences();
	  
	       }if(steals.isSelected() == true){
	    	   
	    	   selectedItem.selectSteals();
	  
	       }if(blockShots.isSelected() == true){
	    	   
	    	   selectedItem.selectBlockShots();
	  
	       }if(turnOvers.isSelected() == true){
	    	   
	    	   selectedItem.selectTurnOvers();
	  
	       }if(fouls.isSelected() == true){
	    	   
	    	   selectedItem.selectFouls();
	  
	       }if(score.isSelected() == true){
	    	   
	    	   selectedItem.selectScore();
	  
	       }if(shootings.isSelected() == true){
	    	   
	    	   selectedItem.selectShootings();
	  
	       }if(shots.isSelected() == true){
	    	   
	    	   selectedItem.selectShots();
	  
	       }if(threePointShots.isSelected() == true){
	    	   
	    	   selectedItem.selectThreePointShots();
	  
	       }if(threePointShootings.isSelected() == true){
	    	   
	    	   selectedItem.selectThreePointShootings();
	  
	       }if(freeThrowShots.isSelected() == true){
	    	   
	    	   selectedItem.selectFreeThrowShots();
	  
	       }if(freeThrowShoots.isSelected() == true){
	    	   
	    	   selectedItem.selectFreeThrowShoots();
	  
	       }if(numOfMatch.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfMatch();
	  
	       }
	       
		ArrayList<String> tempList = selectedItem.getSelectedList();
	       selectedInfo = tempList;
	      
	        
	    }
	public void setList(ArrayList<String> temp){
		
		selectedInfo = temp;
		
	}
	
	public void setSort(){
		
		sortTrans = sort.getSelectedItem().toString() + ";" + infoOfSort.getSelectedItem().toString();
		
	}
	
	public String getSort(){
		
		return sortTrans;
		
	}
	
	public ArrayList<String> getList(){
		
		return selectedInfo;
		
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
		frame.refreshData();
		frame.changeTableColumns();
		AWTUtilities.setWindowOpacity(frame, 1f);
		dispose();
		
	}

}
