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
	
	JComboBox<String> sort = new JComboBox<String>();
	JComboBox<String> infoOfSort = new JComboBox<String>();
	JLabel sortLabel = new JLabel("��/��������");
	String sortTrans = new String();
	
	SelectedInfoOfPlayer selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("��ѡ��Ϣ");
		this.setSize(500,250);
		this.setUndecorated(true);
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
		
		numOfDffense = new JCheckBox("������");
		numOfDffense.setSelected(false);
		
		numOfSteal = new JCheckBox("������");
		numOfSteal.setSelected(false);
		
		numOfBlockShot = new JCheckBox("��ñ��");
		numOfBlockShot.setSelected(false);
		
		numOfTurnOver = new JCheckBox("ʧ����");
		numOfTurnOver.setSelected(false);
		
		numOfFoul = new JCheckBox("������");
		numOfFoul.setSelected(false);
		
		scorling = new JCheckBox("�÷�");
		scorling.setSelected(false);
		
		numOfShoot = new JCheckBox("Ͷ��������");
		numOfShot = new JCheckBox("Ͷ����");
		numOfThreePointShoot  =new JCheckBox( "������������");
		numOfThreePointShot =new JCheckBox( "����������");
		numOfFreeThrowShoot = new JCheckBox("����������");
		numOfFreeThrowShot = new JCheckBox("��������");
		
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
		checkPanel.add(numOfDffense);
		checkPanel.add(numOfSteal);
		checkPanel.add(numOfBlockShot);
		checkPanel.add(numOfTurnOver);
		checkPanel.add(numOfFoul);
		checkPanel.add(scorling);
		checkPanel.add(numOfShoot);
		checkPanel.add(numOfShot);
		checkPanel.add(numOfThreePointShoot);
		checkPanel.add(numOfThreePointShot );
		checkPanel.add(numOfFreeThrowShoot);
		checkPanel.add(numOfFreeThrowShot);
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
		sort.addItem("����");
		sort.addItem("����");
		sort.addItem("��ĸ��");

		infoOfSort.addItem("ID");
		infoOfSort.addItem("����");
		infoOfSort.addItem("���");
		infoOfSort.addItem("����");	
		infoOfSort.addItem("��������");
		infoOfSort.addItem("����");	
		infoOfSort.addItem("����");	
		infoOfSort.addItem("��������");
		infoOfSort.addItem("�ȷ�����");
		infoOfSort.addItem("������");
		infoOfSort.addItem("������");
		infoOfSort.addItem("�ڳ�ʱ��");
		infoOfSort.addItem("������");
		infoOfSort.addItem("������");
		infoOfSort.addItem("������");
		infoOfSort.addItem("��ñ��");
		infoOfSort.addItem("ʧ����");
		infoOfSort.addItem("������");
		infoOfSort.addItem("�÷�");
		infoOfSort.addItem("Ͷ��������");
		infoOfSort.addItem("Ͷ����");
		infoOfSort.addItem( "������������");
		infoOfSort.addItem( "����������");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("��������");
		
		
		
		checkPanel.setBorder(BorderFactory.createEtchedBorder());
		this.add(checkPanel,BorderLayout.CENTER);
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
	
	PlayerFrame frame;

	public void setPlayerFrame(PlayerFrame frame){
		this.frame = frame;
		alreadySelected = frame.getList();
		judgeSelect();

	}

	public void judgeSelect(){
			if(alreadySelected.contains("����")){
				numOfPlayer.setSelected(true);
			}if(alreadySelected.contains("λ��")){
				positionOfPlayer.setSelected(true);
			} if(alreadySelected.contains("���")){
				heightOfPlayer.setSelected(true);
			}if(alreadySelected.contains("����")){
				weightOfPlayer.setSelected(true);
			} if(alreadySelected.contains("��������")){
				birthOfPlayer.setSelected(true);
			}if(alreadySelected.contains("����")){
				ageOfPlayer.setSelected(true);
			}if(alreadySelected.contains("����")){
				expOfPlayer.setSelected(true);
			}if(alreadySelected.contains("ѧУ")){
				schoolOfPlayer.setSelected(true);
			}if(alreadySelected.contains("�������")){
				teamOfPlayer.setSelected(true);
			} if(alreadySelected.contains("��������")){
				numOfEntryField.setSelected(true);
			}if(alreadySelected.contains("�ȷ�����")){
				numOfStartingField.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfRebound.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfAssist.setSelected(true);
			}if(alreadySelected.contains("�ڳ�ʱ��")){
				timeOfPresence.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfOffense.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfDffense.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfSteal.setSelected(true);
			}if(alreadySelected.contains("��ñ��")){
				numOfBlockShot.setSelected(true);
			}if(alreadySelected.contains("ʧ����")){
				numOfTurnOver.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfFoul.setSelected(true);
			}if(alreadySelected.contains("�÷�")){
				scorling.setSelected(true);
			}if(alreadySelected.contains("Ͷ��������")){
				numOfShoot.setSelected(true);
			}if(alreadySelected.contains("Ͷ����")){
				numOfShot.setSelected(true);
			}if(alreadySelected.contains("������������")){
				numOfThreePointShoot.setSelected(true);
			}if(alreadySelected.contains("����������")){
				numOfThreePointShot .setSelected(true);
			}if(alreadySelected.contains("����������")){
				numOfFreeThrowShoot.setSelected(true);
			}if(alreadySelected.contains("��������")){
				numOfFreeThrowShot.setSelected(true);
			}
			
	}

	public void checkBoxSelected() {
	      //��ȡ�ı�ĸ�ѡ����
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
	  
	       }if(numOfShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfShoot();
	  
	       }if(numOfShot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfShot();
	  
	       }if(numOfThreePointShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfThreePointShoot();
	  
	       }if(numOfThreePointShot .isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfThreePointShot ();
	  
	       }if(numOfFreeThrowShoot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfFreeThrowShoot();
	  
	       }if(numOfFreeThrowShot.isSelected() == true){
	    	   
	    	   selectedItem.selectNumOfFreeThrowShot();
	  
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
