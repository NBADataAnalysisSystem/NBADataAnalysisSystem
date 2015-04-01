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
	
	private JCheckBox aveRebounds;
	private JCheckBox aveAssists;
	private JCheckBox avePresenceTime;
	private JCheckBox aveOffences;
	private JCheckBox aveDefences;
	private JCheckBox aveSteals;
	private JCheckBox aveBlockShots;
	private JCheckBox aveTurnOvers;
	private JCheckBox aveFouls;
	private JCheckBox aveScore;
	private JCheckBox aveShootings;
	private JCheckBox aveShots;
	private JCheckBox aveThreePointShots;
	private JCheckBox aveThreePointShootings;
	private JCheckBox  aveFreeThrowShots;
	private JCheckBox aveFreeThrowShoots;
	
	JComboBox<String> sort = new JComboBox<String>();
	JComboBox<String> infoOfSort = new JComboBox<String>();
	JLabel sortLabel = new JLabel("��/��������");
	String sortTrans = new String();

	SelectedInfoOfTeam selectedItem;
	
	private  ArrayList<String> selectedInfo;
	private ArrayList<String> alreadySelected = new ArrayList<>();

		
	public AdditionOfTeamInfo(JFrame parent) {
		super(parent);
		
		this.setTitle("��ѡ��Ϣ");
		this.setSize(500,500);
		this.setUndecorated(true);
		resetLocation();

		selectedItem = new SelectedInfoOfTeam();
		selectedInfo = new ArrayList<>();
		
//		fullName = new JCheckBox("ȫ��");
//		fullName.setSelected(false);
//		
//		abeerName = new JCheckBox("���");
//		abeerName.setSelected(false);
		
		location = new JCheckBox("λ��");
		location.setSelected(false);
		
		zone = new JCheckBox("����");
		zone.setSelected(false);
		
		division = new JCheckBox("����");
		division.setSelected(false);
		
		homeCourt = new JCheckBox("����");
		homeCourt.setSelected(false);
		
		builtTime = new JCheckBox("����ʱ��");
		builtTime.setSelected(false);
		
		rebounds = new JCheckBox("������");
		assists = new JCheckBox("������");
		presenceTime = new JCheckBox("�ڳ�ʱ�䣨�룩");
		offences = new JCheckBox("������");
		defences =new JCheckBox( "������");
		steals = new JCheckBox("������");
		blockShots = new JCheckBox("��ñ��");
		turnOvers = new JCheckBox("ʧ����");
		fouls =new JCheckBox( "������");
		score =new JCheckBox( "�÷�");
		shootings = new JCheckBox("Ͷ��������");
		shots =new JCheckBox( "Ͷ����");
		threePointShots =new JCheckBox( "��������");
		threePointShootings =new JCheckBox( "������������");
		 freeThrowShots = new JCheckBox("������");
		freeThrowShoots = new JCheckBox("����������");
		numOfMatch =new JCheckBox( "������");

		aveRebounds = new JCheckBox( "����������");
		aveAssists = new JCheckBox( "����������");
		avePresenceTime = new JCheckBox( "�����ڳ�ʱ�䣨�룩");
		aveOffences = new JCheckBox( "����������");
		aveDefences = new JCheckBox( "����������");
		aveSteals =new JCheckBox(  "����������");
		aveBlockShots = new JCheckBox( "������ñ��");
		aveTurnOvers = new JCheckBox( "����ʧ����");
		aveFouls =new JCheckBox(  "����������");
		aveScore =new JCheckBox(  "�����÷�");
		aveShootings = new JCheckBox( "����Ͷ��������");
		aveShots = new JCheckBox( "����Ͷ����");
		aveThreePointShots =new JCheckBox(  "������������");
		aveThreePointShootings = new JCheckBox( "����������������");
		aveFreeThrowShots = new JCheckBox( "����������");
		aveFreeThrowShoots = new JCheckBox( "��������������");
		
		JPanel basicInfoPanel = new JPanel(new GridLayout(2,3));
		basicInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
		basicInfoPanel.add(location);
		basicInfoPanel.add(zone);
		basicInfoPanel.add(division);
		basicInfoPanel.add(homeCourt);
		basicInfoPanel.add(builtTime);
		
		JPanel seasonInfoPanel = new JPanel(new GridLayout(6,3));
		seasonInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
		seasonInfoPanel.add(rebounds);
		seasonInfoPanel.add(assists);
		seasonInfoPanel.add(presenceTime);
		seasonInfoPanel.add(offences);
		seasonInfoPanel.add(defences);
		seasonInfoPanel.add(steals);
		seasonInfoPanel.add(blockShots);
		seasonInfoPanel.add(turnOvers);
		seasonInfoPanel.add(fouls);
		seasonInfoPanel.add(score);
		seasonInfoPanel.add(shootings);
		seasonInfoPanel.add(shots);
		seasonInfoPanel.add(threePointShots);
		seasonInfoPanel.add(threePointShootings);
		seasonInfoPanel.add(freeThrowShots);
		seasonInfoPanel.add(freeThrowShoots);
		seasonInfoPanel.add(numOfMatch);
		
		JPanel aveInfoPanel = new JPanel(new GridLayout(6,3));
		aveInfoPanel.setBorder(BorderFactory.createTitledBorder("������Ϣ"));
		aveInfoPanel.add(aveRebounds);
		aveInfoPanel.add(aveAssists);
		aveInfoPanel.add(avePresenceTime);
		aveInfoPanel.add(aveOffences);
		aveInfoPanel.add(aveDefences);
		aveInfoPanel.add(aveSteals);
		aveInfoPanel.add(aveBlockShots);
		aveInfoPanel.add(aveTurnOvers);
		aveInfoPanel.add(aveFouls);
		aveInfoPanel.add(aveScore);
		aveInfoPanel.add(aveShootings);
		aveInfoPanel.add(aveShots);
		aveInfoPanel.add(aveThreePointShots);
		aveInfoPanel.add(aveThreePointShootings);
		aveInfoPanel.add(aveFreeThrowShots);
		aveInfoPanel.add(aveFreeThrowShoots);
		
		sort.addItem("����");
		sort.addItem("����");
		sort.addItem("��ĸ��");

		infoOfSort.addItem("ID");
		infoOfSort.addItem("ȫ��");
		infoOfSort.addItem("���");
		infoOfSort.addItem("λ��");	
		infoOfSort.addItem("����");
		infoOfSort.addItem("����");	
		infoOfSort.addItem("����");	
		infoOfSort.addItem("����ʱ��");
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
		infoOfSort.addItem("������");
		
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
		
		JPanel totalPanel = new JPanel(new GridLayout(4,1));
//		basicInfoPanel.setBorder(BorderFactory.createEtchedBorder());
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
		totalPanel.add(aveInfoPanel);
		totalPanel.add(bp);

		this.add(totalPanel);


		
		
	}
	
	TeamFrame frame;

	public void setTeamFrame(TeamFrame frame){
		this.frame = frame;
		alreadySelected = frame.getList();
		judgeSelect();

	}

	public void judgeSelect(){
//			if(alreadySelected.contains("ȫ��")){
//				fullName.setSelected(true);
//			}if(alreadySelected.contains("���")){
//				abeerName.setSelected(true);
//			}
		if(alreadySelected.contains("λ��")){
				location.setSelected(true);
			}if(alreadySelected.contains("����")){
				zone.setSelected(true);
			} if(alreadySelected.contains("����")){
				division.setSelected(true);
			}if(alreadySelected.contains("����")){
				homeCourt.setSelected(true);
			}if(alreadySelected.contains("����ʱ��")){
				builtTime.setSelected(true);
			}if(alreadySelected.contains("������")){
				rebounds.setSelected(true);
			}if(alreadySelected.contains("������")){
				assists.setSelected(true);
			}if(alreadySelected.contains("�ڳ�ʱ��")){
				presenceTime.setSelected(true);
			}if(alreadySelected.contains("������")){
				offences.setSelected(true);
			}if(alreadySelected.contains("������")){
				defences.setSelected(true);
			}if(alreadySelected.contains("������")){
				steals.setSelected(true);
			}if(alreadySelected.contains("��ñ��")){
				blockShots.setSelected(true);
			}if(alreadySelected.contains("ʧ����")){
				turnOvers.setSelected(true);
			}if(alreadySelected.contains("������")){
				fouls.setSelected(true);
			}if(alreadySelected.contains("�÷�")){
				score.setSelected(true);
			}if(alreadySelected.contains("Ͷ��������")){
				shootings.setSelected(true);
			}if(alreadySelected.contains("Ͷ����")){
				shots.setSelected(true);
			}if(alreadySelected.contains("��������")){
				threePointShots.setSelected(true);
			}if(alreadySelected.contains("������������")){
				threePointShootings.setSelected(true);
			}if(alreadySelected.contains("������")){
				freeThrowShots.setSelected(true);
			}if(alreadySelected.contains("����������")){
				freeThrowShoots.setSelected(true);
			}if(alreadySelected.contains("������")){
				numOfMatch.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveRebounds.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveAssists.setSelected(true);
			}if(alreadySelected.contains("�����ڳ�ʱ��")){
				avePresenceTime.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveOffences.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveDefences.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveSteals.setSelected(true);
			}if(alreadySelected.contains("������ñ��")){
				aveBlockShots.setSelected(true);
			}if(alreadySelected.contains("����ʧ����")){
				aveTurnOvers.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveFouls.setSelected(true);
			}if(alreadySelected.contains("�����÷�")){
				aveScore.setSelected(true);
			}if(alreadySelected.contains("����Ͷ��������")){
				aveShootings.setSelected(true);
			}if(alreadySelected.contains("����Ͷ����")){
				aveShots.setSelected(true);
			}if(alreadySelected.contains("������������")){
				aveThreePointShots.setSelected(true);
			}if(alreadySelected.contains("����������������")){
				aveThreePointShootings.setSelected(true);
			}if(alreadySelected.contains("����������")){
				aveFreeThrowShots.setSelected(true);
			}if(alreadySelected.contains("��������������")){
				aveFreeThrowShoots.setSelected(true);
			}
	}

	public void checkBoxSelected() {
	      //��ȡ�ı�ĸ�ѡ����
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
	  
	       }if(aveRebounds.isSelected() == true){
	    	   
	    	   selectedItem.selectAveRebounds();
	  
	       }if(aveAssists.isSelected() == true){
	    	   
	    	   selectedItem.selectAveAssists();
	  
	       }if(avePresenceTime.isSelected() == true){
	    	   
	    	   selectedItem.selectAvePresenceTime();
	  
	       }if(aveOffences.isSelected() == true){
	    	   
	    	   selectedItem.selectAveOffences();
	  
	       }if(aveDefences.isSelected() == true){
	    	   
	    	   selectedItem.selectAveDefences();
	  
	       }if(aveSteals.isSelected() == true){
	    	   
	    	   selectedItem.selectAveSteals();
	  
	       }if(aveBlockShots.isSelected() == true){
	    	   
	    	   selectedItem.selectAveBlockShots();
	  
	       }if(aveTurnOvers.isSelected() == true){
	    	   
	    	   selectedItem.selectAveTurnOvers();
	  
	       }if(aveFouls.isSelected() == true){
	    	   
	    	   selectedItem.selectAveFouls();
	  
	       }if(aveScore.isSelected() == true){
	    	   
	    	   selectedItem.selectAveScore();
	  
	       }if(aveShootings.isSelected() == true){
	    	   
	    	   selectedItem.selectAveShootings();
	  
	       }if(aveShots.isSelected() == true){
	    	   
	    	   selectedItem.selectAveShots();
	  
	       }if(aveThreePointShots.isSelected() == true){
	    	   
	    	   selectedItem.selectAveThreePointShots();
	  
	       }if(aveThreePointShootings.isSelected() == true){
	    	   
	    	   selectedItem.selectAveThreePointShootings();
	  
	       }if(aveFreeThrowShots.isSelected() == true){
	    	   
	    	   selectedItem.selectAveFreeThrowShots();
	  
	       }if(aveFreeThrowShoots.isSelected() == true){
	    	   
	    	   selectedItem.selectAveFreeThrowShoots();
	  
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
