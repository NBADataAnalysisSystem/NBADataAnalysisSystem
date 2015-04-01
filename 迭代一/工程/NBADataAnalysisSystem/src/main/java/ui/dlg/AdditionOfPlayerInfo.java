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
	JLabel sortLabel = new JLabel("��/��������");
	String sortTrans = new String();
	
	SelectedInfoOfPlayer selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfPlayerInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("��ѡ��Ϣ");
		this.setSize(500,500);
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
		
		aveNumOfRebound = new JCheckBox( "����������");
		aveNumOfAssist= new JCheckBox("����������");
		aveNumOfOffense= new JCheckBox("����������");
		aveNumOfDffense= new JCheckBox("����������");
		aveNumOfSteal= new JCheckBox("����������");
		aveNumOfBlockShot= new JCheckBox( "������ñ��");
		aveNumOfTurnOver= new JCheckBox( "����ʧ����");
		aveNumOfFoul= new JCheckBox("����������");
		aveTimeOfPresence = new JCheckBox("�����ڳ�ʱ��");
		aveScorling= new JCheckBox("�����÷�");
		aveNumOfShoot = new JCheckBox("����Ͷ��������");
		aveNumOfShot= new JCheckBox("����Ͷ����");
		aveNumOfThreePointShoot  = new JCheckBox("����������������");
		aveNumOfThreePointShot = new JCheckBox( "��������������");
		aveNumOfFreeThrowShoot = new JCheckBox("��������������");
		aveNumOfFreeThrowShot = new JCheckBox("������������");
		
		JPanel basicInfoPanel = new JPanel(new GridLayout(3,3));
		basicInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
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
		seasonInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
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
		aveSeasonInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
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
		infoOfSort.addItem("�ڳ�ʱ�䣨�룩");
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
		
		infoOfSort.addItem("����������");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("�����ڳ�ʱ�䣨�룩");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("������ñ��");
		infoOfSort.addItem("����ʧ����");
		infoOfSort.addItem("����������");
		infoOfSort.addItem("�����÷�");
		infoOfSort.addItem("����Ͷ��������");
		infoOfSort.addItem("����Ͷ����");
		infoOfSort.addItem( "����������������");
		infoOfSort.addItem( "��������������");
		infoOfSort.addItem("��������������");
		infoOfSort.addItem("������������");
		
		
		
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
			}if(alreadySelected.contains("�ڳ�ʱ�䣨�룩")){
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
			}if(alreadySelected.contains("����Ͷ��������")){
				aveNumOfShoot.setSelected(true);
			}if(alreadySelected.contains("����Ͷ����")){
				aveNumOfShot.setSelected(true);
			}if(alreadySelected.contains("����������������")){
				aveNumOfThreePointShoot.setSelected(true);
			}if(alreadySelected.contains("��������������")){
				aveNumOfThreePointShot .setSelected(true);
			}if(alreadySelected.contains("��������������")){
				aveNumOfFreeThrowShoot.setSelected(true);
			}if(alreadySelected.contains("������������")){
				aveNumOfFreeThrowShot.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfRebound.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfAssist.setSelected(true);
			}if(alreadySelected.contains("�����ڳ�ʱ�䣨�룩")){
				aveTimeOfPresence.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfOffense.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfDffense.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfSteal.setSelected(true);
			}if(alreadySelected.contains("������ñ��")){
				aveNumOfBlockShot.setSelected(true);
			}if(alreadySelected.contains("����ʧ����")){
				aveNumOfTurnOver.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveNumOfFoul.setSelected(true);
			}if(alreadySelected.contains("�����÷�")){
				aveScorling.setSelected(true);
			}if(alreadySelected.contains("����Ͷ��������")){
				aveNumOfShoot.setSelected(true);
			}if(alreadySelected.contains("����Ͷ����")){
				aveNumOfShot.setSelected(true);
			}if(alreadySelected.contains("����������������")){
				aveNumOfThreePointShoot.setSelected(true);
			}if(alreadySelected.contains("��������������")){
				aveNumOfThreePointShot .setSelected(true);
			}if(alreadySelected.contains("��������������")){
				aveNumOfFreeThrowShoot.setSelected(true);
			}if(alreadySelected.contains("������������")){
				aveNumOfFreeThrowShot.setSelected(true);
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
