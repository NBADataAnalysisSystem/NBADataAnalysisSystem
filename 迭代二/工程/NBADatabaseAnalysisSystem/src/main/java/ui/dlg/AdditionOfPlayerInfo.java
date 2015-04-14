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

import ui.frame.PlayerFrame;

import com.sun.awt.AWTUtilities;


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
	private JCheckBox efficiency;
	private JCheckBox effOfGmSc;
	private JCheckBox truePersentageOfShooting ;
	private JCheckBox effOfShooting ;
	private JCheckBox rateOfRound ;
	private JCheckBox rateOfOffensiveRound ;
	private JCheckBox rateOfDefensiveRound ;
	private JCheckBox rateOfSteal ;
	private JCheckBox rateOfAssist;
	private JCheckBox rateOfBlockShot;
	private JCheckBox rateOfTurnOver;
	private JCheckBox rateOfUse;
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
	
	ArrayList<JCheckBox> additionGroup;
	
	JComboBox<String> sort = new JComboBox<String>();
	JComboBox<String> infoOfSort = new JComboBox<String>();
	JLabel sortLabel = new JLabel("升/降序依据");
	String sortTrans = new String();
	
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<String>();
	private String[] infoToShow;
	
	JPanel aveSeasonInfoPanel;
	JPanel basicInfoPanel;
	JPanel seasonInfoPanel ;
		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		 additionGroup = new ArrayList<JCheckBox>();
		
		this.setTitle("勾选信息");
		this.setSize(500,700);
		this.setUndecorated(true);
		resetLocation();
		
		selectedInfo = new ArrayList<String>();
		
		numOfPlayer = new JCheckBox("号数");
		positionOfPlayer = new JCheckBox("位置");
		heightOfPlayer = new JCheckBox("身高");
		weightOfPlayer = new JCheckBox("体重");
		birthOfPlayer = new JCheckBox("出生日期");
		ageOfPlayer = new JCheckBox("年龄");
		expOfPlayer = new JCheckBox("球龄");
		schoolOfPlayer = new JCheckBox("学校");
		teamOfPlayer = new JCheckBox("所在球队");
		numOfEntryField = new JCheckBox("参赛场数");
		numOfStartingField = new JCheckBox("先发场数");
		numOfRebound = new JCheckBox("篮板数");
		numOfAssist = new JCheckBox("助攻数");
		timeOfPresence = new JCheckBox("在场时间（秒）");	
		numOfOffense = new JCheckBox("进攻数");
		numOfDffense = new JCheckBox("防守数");
		numOfSteal = new JCheckBox("抢断数");
		numOfBlockShot = new JCheckBox("盖帽数");
		numOfBlockShot.setSelected(false);		
		numOfTurnOver = new JCheckBox("失误数");
		numOfFoul = new JCheckBox("犯规数");
		scorling = new JCheckBox("得分");
		numOfShoot = new JCheckBox("投篮命中数");
		numOfShot = new JCheckBox("投篮数");
		numOfThreePointShoot  =new JCheckBox( "三分球命中数");
		numOfThreePointShot =new JCheckBox( "三分球总数");
		numOfFreeThrowShoot = new JCheckBox("罚球命中数");
		numOfFreeThrowShot = new JCheckBox("罚球总数");
		efficiency=new JCheckBox( "效率");
		effOfGmSc=new JCheckBox( "GmSc效率");
		truePersentageOfShooting= new JCheckBox("真实投篮命中率") ;
		effOfShooting = new JCheckBox("投篮效率");
		rateOfRound = new JCheckBox("篮板率");
		rateOfOffensiveRound = new JCheckBox("进攻篮板率");
		rateOfDefensiveRound =new JCheckBox( "防守篮板率");
		rateOfAssist = new JCheckBox("助攻率");
		rateOfSteal=new JCheckBox( "抢断率");
		rateOfBlockShot=new JCheckBox( "盖帽率");
		rateOfTurnOver=new JCheckBox( "失误率");
		rateOfUse= new JCheckBox("使用率");
		aveNumOfRebound = new JCheckBox("场均篮板数");
		aveNumOfAssist= new JCheckBox("场均助攻数");
		aveNumOfOffense= new JCheckBox("场均进攻数");
		aveNumOfDffense= new JCheckBox("场均防守数");
		aveNumOfSteal= new JCheckBox("场均抢断数");
		aveNumOfBlockShot= new JCheckBox( "场均盖帽数");
		aveNumOfTurnOver= new JCheckBox( "场均失误数");
		aveNumOfFoul= new JCheckBox("场均犯规数");
		aveTimeOfPresence = new JCheckBox("场均在场时间（秒）");
		aveScorling= new JCheckBox("场均得分");
		aveNumOfShoot = new JCheckBox("场均投篮命中数");
		aveNumOfShot= new JCheckBox("场均投篮数");
		aveNumOfThreePointShoot  = new JCheckBox("场均三分球命中数");
		aveNumOfThreePointShot = new JCheckBox( "场均三分球总数");
		aveNumOfFreeThrowShoot = new JCheckBox("场均罚球命中数");
		aveNumOfFreeThrowShot = new JCheckBox("场均罚球总数");
		additionGroup.add(numOfPlayer);

		additionGroup.add(positionOfPlayer);
		additionGroup.add(heightOfPlayer);
		additionGroup.add(weightOfPlayer);
		additionGroup.add(birthOfPlayer);
		additionGroup.add(ageOfPlayer);
		additionGroup.add(expOfPlayer);
		additionGroup.add(schoolOfPlayer);
		additionGroup.add(teamOfPlayer);
		additionGroup.add(numOfEntryField);
		additionGroup.add(numOfStartingField);
		additionGroup.add(numOfRebound);
		additionGroup.add(numOfAssist);
		additionGroup.add(timeOfPresence);
		additionGroup.add(numOfOffense);
		additionGroup.add(numOfDffense);
		additionGroup.add(numOfSteal);
		additionGroup.add(numOfBlockShot);
		additionGroup.add(numOfTurnOver);
		additionGroup.add(numOfFoul);
		additionGroup.add(scorling);
		additionGroup.add(numOfShoot) ;
		additionGroup.add(numOfShot);
		additionGroup.add(numOfThreePointShoot)  ;
		additionGroup.add(numOfThreePointShot );
		additionGroup.add(numOfFreeThrowShoot );
		additionGroup.add(numOfFreeThrowShot );
		additionGroup.add(efficiency);
		additionGroup.add(effOfGmSc);
		additionGroup.add(truePersentageOfShooting) ;
		additionGroup.add(effOfShooting );
		additionGroup.add(rateOfRound );
		additionGroup.add(rateOfOffensiveRound );
		additionGroup.add(rateOfDefensiveRound );
		additionGroup.add(rateOfSteal );
		additionGroup.add(rateOfAssist);
		additionGroup.add(rateOfBlockShot);
		additionGroup.add(rateOfTurnOver);
		additionGroup.add(rateOfUse);
		additionGroup.add(aveNumOfRebound);
		additionGroup.add(aveNumOfAssist);
		additionGroup.add(aveNumOfOffense);
		additionGroup.add(aveNumOfDffense);
		additionGroup.add(aveTimeOfPresence);
		additionGroup.add(aveNumOfSteal);
		additionGroup.add(aveNumOfBlockShot);
		additionGroup.add(aveNumOfTurnOver);
		additionGroup.add(aveNumOfFoul);
		additionGroup.add(aveScorling);
		additionGroup.add(aveNumOfShoot) ;
		additionGroup.add(aveNumOfShot);
		additionGroup.add(aveNumOfThreePointShoot)  ;
		additionGroup.add(aveNumOfThreePointShot );
		additionGroup.add(aveNumOfFreeThrowShoot );
		additionGroup.add(aveNumOfFreeThrowShot );
		
		basicInfoPanel = new JPanel(new GridLayout(3,3));
		basicInfoPanel.setBorder(BorderFactory.createTitledBorder("基础信息"));

		
		seasonInfoPanel = new JPanel(new GridLayout(10,3));
		seasonInfoPanel.setBorder(BorderFactory.createTitledBorder("赛季信息"));
		
		aveSeasonInfoPanel = new JPanel(new GridLayout(6,3));
		aveSeasonInfoPanel.setBorder(BorderFactory.createTitledBorder("场均信息"));
		
		setBasicInfoPanel();
		setSeasonInfoPanel();
		setAveSeasonInfoPanel();
		
	
		
		JPanel totalPanel = new JPanel(new GridLayout(4,1));

		sort.addItem("升序");
		sort.addItem("降序");
//		sort.addItem("字母序");
//TODO
		infoOfSort.addItem("ID");
		for(int i = 0;i<additionGroup.size();i++){
			infoOfSort.addItem(additionGroup.get(i).getText());
		}
		
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
	

	public void setBasicInfoPanel(){
		
		basicInfoPanel.add(numOfPlayer);
		basicInfoPanel.add(positionOfPlayer);
		basicInfoPanel.add(heightOfPlayer);
		basicInfoPanel.add(weightOfPlayer);
		basicInfoPanel.add(birthOfPlayer);
		basicInfoPanel.add(ageOfPlayer);
		basicInfoPanel.add(expOfPlayer);
		basicInfoPanel.add(schoolOfPlayer);
		basicInfoPanel.add(teamOfPlayer);
	}
	
	public void setSeasonInfoPanel(){
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
		seasonInfoPanel.add(efficiency);
		seasonInfoPanel.add(effOfGmSc);
		seasonInfoPanel.add(truePersentageOfShooting) ;
		seasonInfoPanel.add(effOfShooting);
		seasonInfoPanel.add(rateOfRound );
		seasonInfoPanel.add(rateOfOffensiveRound );
		seasonInfoPanel.add(rateOfDefensiveRound);
		seasonInfoPanel.add(rateOfSteal );
		seasonInfoPanel.add(rateOfAssist);
		seasonInfoPanel.add(rateOfBlockShot);
		seasonInfoPanel.add(rateOfTurnOver);
		seasonInfoPanel.add(rateOfUse);
	}
	
	public void setAveSeasonInfoPanel(){

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
		
	}

	public void judgeSelect(){
		for(int i = 0;i<additionGroup.size();i++){
			if(alreadySelected.contains(additionGroup.get(i).getText())){
				additionGroup.get(i).setSelected(true);
			}
		}
			
	}

	PlayerFrame frame;
	
	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
		//alreadySelected = frame.getList();
		judgeSelect();
		
	}
	public void checkBoxSelected() {
	      //获取改变的复选按键
	      // Object source = e.getItemSelectable();
		
		ArrayList<String> tempList = new ArrayList<String>();
		for(int i=0;i<additionGroup.size();i++){
			if(additionGroup.get(i).isSelected() == true){
				tempList.add(additionGroup.get(i).getText());
			}
		}
	       
	       selectedInfo = tempList;
	      
	        
	    }
	public void setList(ArrayList<String> temp){
		
		infoToShow = new String[temp.size()];
		for(int i=0;i<temp.size();i++){
			infoToShow[i] = temp.get(i);
		}
		
	}
	
	public String[] getList(){
		
		return infoToShow;
		
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
		this.setList(selectedInfo);
		frame.setList(infoToShow);
	//	frame.setString();
	//	frame.setSort(sortTrans);
	//	frame.changeTableColumns();
		AWTUtilities.setWindowOpacity(frame, 1f);
		frame.refreshData();
		dispose();
		
	}

}
