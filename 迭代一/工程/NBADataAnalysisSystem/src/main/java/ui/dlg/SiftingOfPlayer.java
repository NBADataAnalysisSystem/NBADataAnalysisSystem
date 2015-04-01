package ui.dlg;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.sun.awt.AWTUtilities;

import ui.playerui.PlayerFrame;
import ui.playerui.SiftingOfOth;
import ui.playerui.SiftingOfPosition;
import ui.playerui.SiftingOfUnion;

@SuppressWarnings({ "serial", "restriction" })
public class SiftingOfPlayer extends InputDialog{
	
	JCheckBox forward = new JCheckBox("前锋");
	JCheckBox center = new JCheckBox("中锋");
	JCheckBox guard = new JCheckBox("后卫");
	
	JCheckBox atlanticDivision = new JCheckBox("大西洋区");
	JCheckBox centralDivision = new JCheckBox("中央区");
	JCheckBox southeastDivision = new JCheckBox("东南区");
	JCheckBox southwestDivision = new JCheckBox("西南区");
	JCheckBox northwestDivision = new JCheckBox("西北区");
	JCheckBox pacificDivision = new JCheckBox("太平洋区");

	JRadioButton scoring = new JRadioButton("得分");
	JRadioButton numOfRebound = new JRadioButton("篮板数");
	JRadioButton numOfAssist = new JRadioButton("助攻");
	JRadioButton scoring_rebound_assist = new JRadioButton("得分/篮板/助攻");
	JRadioButton numOfBlockShot = new JRadioButton("盖帽");
	JRadioButton numOfSteal = new JRadioButton("抢断");	
	JRadioButton numOfFoul = new JRadioButton("犯规");
	JRadioButton numOfTurnOver = new JRadioButton("失误");
	JRadioButton minute = new JRadioButton("分钟");
	JRadioButton efficiency= new JRadioButton("效率");
	JRadioButton numOfShot = new JRadioButton("投篮");
	JRadioButton numOfThreePoint = new JRadioButton("三分");
	JRadioButton numOfFreeThrow = new JRadioButton("罚球");
	JRadioButton doubleDouble = new JRadioButton("两双");

	ButtonGroup groupOfOth = new ButtonGroup();
	ArrayList<SiftingOfPosition> listOfPosition;
	ArrayList<SiftingOfUnion> listOfUnion;
	ArrayList<SiftingOfOth> listOfOth;
	
	//private ArrayList<String> alreadySelected = new ArrayList<>();
	
	public SiftingOfPlayer(JFrame parent) {
		super(parent);
		
		listOfPosition = new ArrayList<>();
		listOfUnion = new ArrayList<>();
		listOfOth = new ArrayList<>();
		
		this.setTitle("筛选信息");
		this.setSize(400, 500);
		this.setUndecorated(true);
		resetLocation();
		
		GridLayout gridLayout = new GridLayout(4, 1);
		setLayout(gridLayout);
		
		JPanel positionPanel = new JPanel();
		positionPanel.setLayout(new GridLayout(1,3));
		positionPanel.setBorder(BorderFactory.createTitledBorder("球员位置"));// 定义一个面板的边框显示条
		positionPanel.add(forward);
		forward.setSelected(false);
		positionPanel.add(center);
		center.setSelected(false);
		positionPanel.add(guard);
		guard.setSelected(false);
		add(positionPanel);
		
		JPanel unionPanel = new JPanel();
		unionPanel.setLayout(new GridLayout(2,3));
		unionPanel.setBorder(BorderFactory.createTitledBorder("球员联盟"));// 定义一个面板的边框显示条
		unionPanel.add(atlanticDivision);
		atlanticDivision.setSelected(false);
		unionPanel.add(centralDivision);
		centralDivision.setSelected(false);
		unionPanel.add(southeastDivision);
		southeastDivision.setSelected(false);
		unionPanel.add(southwestDivision);
		southwestDivision.setSelected(false);
		unionPanel.add(northwestDivision);
		northwestDivision.setSelected(false);	
		unionPanel.add(pacificDivision);
		pacificDivision.setSelected(false);
		add(unionPanel);
		
		JPanel otherPanel = new JPanel();
		otherPanel.setLayout(new GridLayout(5,3));
		otherPanel.setBorder(BorderFactory.createTitledBorder("排序依据"));// 定义一个面板的边框显示条
		otherPanel.add(scoring);
		scoring.setSelected(false);
		otherPanel.add(numOfRebound);
		numOfRebound.setSelected(false);
		otherPanel.add(numOfAssist);
		numOfAssist.setSelected(false);
		otherPanel.add(scoring_rebound_assist);
		scoring_rebound_assist.setSelected(false);
		otherPanel.add(numOfBlockShot );
		numOfBlockShot .setSelected(false);	
		otherPanel.add(numOfSteal );
		numOfSteal .setSelected(false);
		otherPanel.add(numOfFoul );
		numOfFoul .setSelected(false);
		otherPanel.add(numOfTurnOver);
		numOfTurnOver.setSelected(false);
		otherPanel.add(minute);
		minute.setSelected(false);
		otherPanel.add(efficiency);
		efficiency.setSelected(false);
		otherPanel.add(numOfShot);
		numOfShot.setSelected(false);	
		otherPanel.add(numOfThreePoint );
		numOfThreePoint .setSelected(false);
		otherPanel.add(numOfFreeThrow  );
		numOfFreeThrow  .setSelected(false);
		otherPanel.add(numOfThreePoint );
		numOfThreePoint .setSelected(false);
		otherPanel.add(doubleDouble  );
		doubleDouble .setSelected(false);
		add(otherPanel);
		
		groupOfOth.add(scoring);
		groupOfOth.add(numOfRebound);
		groupOfOth.add(numOfAssist );
		groupOfOth.add(scoring_rebound_assist );
		groupOfOth.add(numOfBlockShot );
		groupOfOth.add(numOfSteal );
		groupOfOth.add(numOfFoul );
		groupOfOth.add(numOfTurnOver );
		groupOfOth.add(minute );
		groupOfOth.add(efficiency);
		groupOfOth.add(numOfShot );
		groupOfOth.add(numOfThreePoint );
		groupOfOth.add(numOfFreeThrow );
		groupOfOth.add(doubleDouble );
		
		
		
		JPanel bp = new JPanel();
		bp.setBorder(BorderFactory.createEtchedBorder());
		bp.add(btn_apply);
		bp.add(btn_cancel);
		add(bp, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	PlayerFrame frame;
	
	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
//			alreadySelected = frame.getList();
//			judgeSelect();
		
	}
	
	public void judgeSelect(){
//		if(alreadySelected.contains("前锋")){
//			forward.setSelected(true);
//		}if(alreadySelected.contains("中锋")){
//			center.setSelected(true);
//		} if(alreadySelected.contains("后卫")){
//			guard.setSelected(true);
//		}if(alreadySelected.contains("大西洋区")){
//			atlanticDivision.setSelected(true);
//		} if(alreadySelected.contains("东南区")){
//			southeastDivision.setSelected(true);
//		}if(alreadySelected.contains("西南区")){
//			southwestDivision .setSelected(true);
//		}if(alreadySelected.contains("西北区")){
//			northwestDivision.setSelected(true);
//		}if(alreadySelected.contains("中央区")){
//			centralDivision.setSelected(true);
//		}if(alreadySelected.contains("太平洋区")){
//			pacificDivision .setSelected(true);
//		} if(alreadySelected.contains("得分")){
//			scoring.setSelected(true);
//		}if(alreadySelected.contains("篮板数")){
//			numOfRebound.setSelected(true);
//		}if(alreadySelected.contains("助攻")){
//			numOfAssist.setSelected(true);
//		}if(alreadySelected.contains("得分/篮板/助攻")){
//			scoring_rebound_assist.setSelected(true);
//		}if(alreadySelected.contains("盖帽")){
//			numOfBlockShot.setSelected(true);
//		}if(alreadySelected.contains("抢断")){
//			numOfFoul .setSelected(true);
//		}if(alreadySelected.contains("犯规")){
//			numOfBlockShot.setSelected(true);
//		}if(alreadySelected.contains("失误")){
//			numOfTurnOver.setSelected(true);
//		}if(alreadySelected.contains("分钟")){
//			minute.setSelected(true);
//		}if(alreadySelected.contains("效率")){
//			efficiency.setSelected(true);
//		}	if(alreadySelected.contains("投篮")){
//			numOfShot.setSelected(true);
//		}if(alreadySelected.contains("三分")){
//			numOfThreePoint.setSelected(true);
//		}if(alreadySelected.contains("罚球")){
//			numOfFreeThrow.setSelected(true);
//		}if(alreadySelected.contains("两双")){
//			doubleDouble .setSelected(true);
//		}
}

public void checkBoxSelected() {
      //获取改变的复选按键
      // Object source = e.getItemSelectable();


       if ( forward.isSelected() == true) {
    	   
    	   listOfPosition.add(SiftingOfPosition.FORWARD);
    	   
       }  if(center.isSelected() == true){
    	   
    	   listOfPosition.add(SiftingOfPosition.CENTER);
        
       }if(guard.isSelected() == true){
      
    	   listOfPosition.add(SiftingOfPosition.GUARD);
    	   
       }if(atlanticDivision.isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.ATLANTICDIVISION);
  
       }if(centralDivision .isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.CENTRALDIVISION);
  
       }if( southeastDivision.isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.SOUTHEASTDIVISION);
  
       }if(southwestDivision.isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.SOUTHWESTDIVISION);
  
       }if(northwestDivision.isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.NORTHWESTDIVISION);
  
       }if(pacificDivision .isSelected() == true){
    	   
    	   listOfUnion.add(SiftingOfUnion.PACIFICDIVISION);
  
       }if(scoring.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.SCORING);
  
       }if(numOfRebound.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_REBOUND);
  
       }if(numOfAssist.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_ASSIST);
  
       }if(scoring_rebound_assist.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.SCORING_REBOUND_ASSIST);
  
       }if(numOfBlockShot.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_BLOCK_SHOT);
  
       }if(numOfSteal .isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_STEAL);
  
       }if( numOfFoul .isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_FOUL);
  
       }if(numOfTurnOver.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_TURN_OVER);
  
       }if(efficiency.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.EFFICIENCY);
  
       }if(numOfShot .isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_SHOT);
  
       }if(numOfThreePoint.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_THREE_POINT);
  
       }if(numOfFreeThrow.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.NUM_OF_FREE_THROW);
  
       }if(doubleDouble.isSelected() == true){
    	   
    	   listOfOth.add(SiftingOfOth.DOUBLE_DOUBLE);
  
       }
//       
//	ArrayList<String> tempList = selectedItem.getSelectedList();
//       selectedInfo = tempList;
//      
        
    }

public void apply(){
	
	checkBoxSelected();
//	ArrayList<String> tempList = new ArrayList<>(); 
//	tempList = frame.getList();
//	for (int i = 0;i<selectedInfo.size();i++){
//		if( frame.getList().contains(selectedInfo.get(i)) ){
//			//tempList.remove(tempList.indexOf(selectedInfo.get(i)));
//			selectedInfo.remove(i);
//			i--;
//		}
//	}
	//System.out.println(this.getList().get(0));
//	selectedInfo = tempList;
	AWTUtilities.setWindowOpacity(frame, 1f);
	frame.refreshData();
	dispose();
	
}
}
