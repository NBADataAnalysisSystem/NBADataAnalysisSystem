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
	
	JCheckBox forward = new JCheckBox("ǰ��");
	JCheckBox center = new JCheckBox("�з�");
	JCheckBox guard = new JCheckBox("����");
	
	JCheckBox atlanticDivision = new JCheckBox("��������");
	JCheckBox centralDivision = new JCheckBox("������");
	JCheckBox southeastDivision = new JCheckBox("������");
	JCheckBox southwestDivision = new JCheckBox("������");
	JCheckBox northwestDivision = new JCheckBox("������");
	JCheckBox pacificDivision = new JCheckBox("̫ƽ����");

	JRadioButton scoring = new JRadioButton("�÷�");
	JRadioButton numOfRebound = new JRadioButton("������");
	JRadioButton numOfAssist = new JRadioButton("����");
	JRadioButton scoring_rebound_assist = new JRadioButton("�÷�/����/����");
	JRadioButton numOfBlockShot = new JRadioButton("��ñ");
	JRadioButton numOfSteal = new JRadioButton("����");	
	JRadioButton numOfFoul = new JRadioButton("����");
	JRadioButton numOfTurnOver = new JRadioButton("ʧ��");
	JRadioButton minute = new JRadioButton("����");
	JRadioButton efficiency= new JRadioButton("Ч��");
	JRadioButton numOfShot = new JRadioButton("Ͷ��");
	JRadioButton numOfThreePoint = new JRadioButton("����");
	JRadioButton numOfFreeThrow = new JRadioButton("����");
	JRadioButton doubleDouble = new JRadioButton("��˫");

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
		
		this.setTitle("ɸѡ��Ϣ");
		this.setSize(400, 500);
		this.setUndecorated(true);
		resetLocation();
		
		GridLayout gridLayout = new GridLayout(4, 1);
		setLayout(gridLayout);
		
		JPanel positionPanel = new JPanel();
		positionPanel.setLayout(new GridLayout(1,3));
		positionPanel.setBorder(BorderFactory.createTitledBorder("��Աλ��"));// ����һ�����ı߿���ʾ��
		positionPanel.add(forward);
		forward.setSelected(false);
		positionPanel.add(center);
		center.setSelected(false);
		positionPanel.add(guard);
		guard.setSelected(false);
		add(positionPanel);
		
		JPanel unionPanel = new JPanel();
		unionPanel.setLayout(new GridLayout(2,3));
		unionPanel.setBorder(BorderFactory.createTitledBorder("��Ա����"));// ����һ�����ı߿���ʾ��
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
		otherPanel.setBorder(BorderFactory.createTitledBorder("��������"));// ����һ�����ı߿���ʾ��
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
//		if(alreadySelected.contains("ǰ��")){
//			forward.setSelected(true);
//		}if(alreadySelected.contains("�з�")){
//			center.setSelected(true);
//		} if(alreadySelected.contains("����")){
//			guard.setSelected(true);
//		}if(alreadySelected.contains("��������")){
//			atlanticDivision.setSelected(true);
//		} if(alreadySelected.contains("������")){
//			southeastDivision.setSelected(true);
//		}if(alreadySelected.contains("������")){
//			southwestDivision .setSelected(true);
//		}if(alreadySelected.contains("������")){
//			northwestDivision.setSelected(true);
//		}if(alreadySelected.contains("������")){
//			centralDivision.setSelected(true);
//		}if(alreadySelected.contains("̫ƽ����")){
//			pacificDivision .setSelected(true);
//		} if(alreadySelected.contains("�÷�")){
//			scoring.setSelected(true);
//		}if(alreadySelected.contains("������")){
//			numOfRebound.setSelected(true);
//		}if(alreadySelected.contains("����")){
//			numOfAssist.setSelected(true);
//		}if(alreadySelected.contains("�÷�/����/����")){
//			scoring_rebound_assist.setSelected(true);
//		}if(alreadySelected.contains("��ñ")){
//			numOfBlockShot.setSelected(true);
//		}if(alreadySelected.contains("����")){
//			numOfFoul .setSelected(true);
//		}if(alreadySelected.contains("����")){
//			numOfBlockShot.setSelected(true);
//		}if(alreadySelected.contains("ʧ��")){
//			numOfTurnOver.setSelected(true);
//		}if(alreadySelected.contains("����")){
//			minute.setSelected(true);
//		}if(alreadySelected.contains("Ч��")){
//			efficiency.setSelected(true);
//		}	if(alreadySelected.contains("Ͷ��")){
//			numOfShot.setSelected(true);
//		}if(alreadySelected.contains("����")){
//			numOfThreePoint.setSelected(true);
//		}if(alreadySelected.contains("����")){
//			numOfFreeThrow.setSelected(true);
//		}if(alreadySelected.contains("��˫")){
//			doubleDouble .setSelected(true);
//		}
}

public void checkBoxSelected() {
      //��ȡ�ı�ĸ�ѡ����
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
