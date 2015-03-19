package ui.dlg;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.SelectedInfoOfPlayer;
import ui.playerui.PlayerFrame;

@SuppressWarnings("serial")
public class AdditionOfPlayerInfo extends InputDialog implements ItemListener {
	
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
	
	private ArrayList<String> selectedInfo;

		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("��ѡ��Ϣ");
		this.setSize(500,250);
		resetLocation();
		
		selectedItem = new SelectedInfoOfPlayer();
		selectedInfo = new ArrayList<>();
		
		numOfPlayer = new JCheckBox("����");
		numOfPlayer.setSelected(false);
		
		positionOfPlayer = new JCheckBox("λ��");
		positionOfPlayer.setSelected(false);
		
		heightOfPlayer = new JCheckBox("���");
		heightOfPlayer.setSelected(false);
		
		weightOfPlayer = new JCheckBox("����");
		weightOfPlayer.setSelected(false);
		
		birthOfPlayer = new JCheckBox("��������");
		birthOfPlayer.setSelected(false);
		
		ageOfPlayer = new JCheckBox("����");
		ageOfPlayer.setSelected(false);
		
		expOfPlayer = new JCheckBox("����");
		expOfPlayer.setSelected(false);
		
		schoolOfPlayer = new JCheckBox("ѧУ");
		schoolOfPlayer.setSelected(false);
		
		teamOfPlayer = new JCheckBox("�������");
		teamOfPlayer.setSelected(false);
		
		numOfEntryField = new JCheckBox("��������");
		numOfEntryField.setSelected(false);
		
		numOfStartingField = new JCheckBox("�ȷ�����");
		numOfStartingField.setSelected(false);
		
		numOfRebound = new JCheckBox("������");
		numOfRebound.setSelected(false);
		
		numOfAssist = new JCheckBox("������");
		numOfAssist.setSelected(false);
		
		timeOfPresence = new JCheckBox("�ڳ�ʱ��");
		timeOfPresence.setSelected(false);
		
		numOfOffense = new JCheckBox("������");
		numOfOffense.setSelected(false);
		
		numOfSteal = new JCheckBox("������");
		numOfSteal.setSelected(false);
		
		numOfBlockShot = new JCheckBox("��ñ��");
		numOfBlockShot.setSelected(false);
		
		numOfTurnOver = new JCheckBox("ʧ����");
		numOfTurnOver.setSelected(false);
		
		numOfFoul = new JCheckBox("������");
		numOfFoul.setSelected(false);
		
		scorling = new JCheckBox("�÷���");
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
		
		 numOfPlayer.addItemListener(this);
		 positionOfPlayer.addItemListener(this);
		 heightOfPlayer.addItemListener(this);
		 weightOfPlayer.addItemListener(this);
		 birthOfPlayer.addItemListener(this);
		 ageOfPlayer.addItemListener(this);
		 expOfPlayer.addItemListener(this);
		 schoolOfPlayer.addItemListener(this);
		 teamOfPlayer.addItemListener(this);
		 numOfEntryField.addItemListener(this);
		 numOfStartingField.addItemListener(this);
		 numOfRebound.addItemListener(this);
		 numOfAssist.addItemListener(this);
		 timeOfPresence.addItemListener(this);
		 numOfOffense.addItemListener(this);
		 numOfSteal.addItemListener(this);
		 numOfBlockShot.addItemListener(this);
		 numOfTurnOver.addItemListener(this);
		 numOfFoul.addItemListener(this);
		 scorling.addItemListener(this);
		
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
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
	      //��ȡ�ı�ĸ�ѡ����
	       Object source = e.getItemSelectable();
	       if (source == numOfPlayer) {
	    	   
	    	   selectedItem.selectNumOfPlayer();
	    	   
	       } else if(source == positionOfPlayer){
	    	   
	    	   selectedItem.selectPositionOfPlayer();
	        
	       }else if(source == heightOfPlayer){
	      
	    	   selectedItem.selectHeightOfPlayer();
	    	   
	       }else if(source ==  weightOfPlayer){
	    	   
	    	   selectedItem.selectWeightOfPlayer();
	  
	       }else if(source == birthOfPlayer){
	    	   
	    	   selectedItem.selectBirthOfPlayer();
	  
	       }else if(source == ageOfPlayer){
	    	   
	    	   selectedItem.selectAgeOfPlayer();
	  
	       }else if(source == expOfPlayer){
	    	   
	    	   selectedItem.selectExpOfPlayer();
	  
	       }else if(source ==  schoolOfPlayer){
	    	   
	    	   selectedItem.selectSchoolOfPlayer();
	  
	       }else if(source ==teamOfPlayer){
	    	   
	    	   selectedItem.selectTeamOfPlayer();
	  
	       }else if(source == numOfEntryField){
	    	   
	    	   selectedItem.selectNumOfEntryField();
	  
	       }else if(source == numOfStartingField){
	    	   
	    	   selectedItem.selectNumOfStartingField();
	  
	       }else if(source ==numOfRebound){
	    	   
	    	   selectedItem.selectNumOfRebound();
	  
	       }else if(source == numOfAssist){
	    	   
	    	   selectedItem.selectNumOfAssist();
	  
	       }else if(source == timeOfPresence){
	    	   
	    	   selectedItem.selectTimeOfPresence();
	  
	       }else if(source == numOfOffense){
	    	   
	    	   selectedItem.selectNumOfOffense();
	  
	       }else if(source ==  numOfSteal){
	    	   
	    	   selectedItem.selectNumOfSteal();
	  
	       }else if(source == numOfBlockShot){
	    	   
	    	   selectedItem.selectNumOfBlockShot();
	  
	       }else if(source == numOfTurnOver){
	    	   
	    	   selectedItem.selectNumOfTurnOver();
	  
	       }else if(source == numOfFoul){
	    	   
	    	   selectedItem.selectNumOfFoul();
	  
	       }else if(source == scorling){
	    	   
	    	   selectedItem.selectScorling();
	  
	       }
	       
	       ArrayList<String> tempList = selectedItem.getSelectedList();
	       selectedInfo = tempList;
	      
	        
	    }
	
	public ArrayList<String> getList(){
		
		return selectedInfo;
		
	}
	
	public void apply(){
		
		frame.setList(this.getList());
		frame.setString();
		frame.refreshData();
		frame.changeTableColumns();
		
	}

}
