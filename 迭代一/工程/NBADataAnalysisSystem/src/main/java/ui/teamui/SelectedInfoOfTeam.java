package ui.teamui;

import java.util.ArrayList;

public class SelectedInfoOfTeam {
	
	private static  ArrayList<String> selectedInfo;
	private String IDOfTeam;
	private String fullName;
	private String abeerName;
	private String location;
	private String zone;
	private String division;
	private String homeCourt;
	private String builtTime;
	private String rebounds;
	private String assists;
	private String presenceTime;
	private String offences;
	private String defences;
	private String steals;
	private String blockShots;
	private String turnOvers;
	private String fouls;
	private String score;
	private String shootings;
	private String shots;
	private String threePointShots;
	private String threePointShootings;
	private String freeThrowShots;
	private String freeThrowShoots;
	private String numOfMatch;
	
	private String aveRebounds;
	private String aveAssists;
	private String avePresenceTime;
	private String aveOffences;
	private String aveDefences;
	private String aveSteals;
	private String aveBlockShots;
	private String aveTurnOvers;
	private String aveFouls;
	private String aveScore;
	private String aveShootings;
	private String aveShots;
	private String aveThreePointShots;
	private String aveThreePointShootings;
	private String aveFreeThrowShots;
	private String aveFreeThrowShoots;
	
	public SelectedInfoOfTeam(){
		
		 selectedInfo = new ArrayList<>();
		 
		 IDOfTeam = "ID";
		 fullName = "ȫ��";
		 abeerName = "���";
		 location = "λ��";
		 zone = "����";
		 division = "����";
		 homeCourt = "����";
		 builtTime = "����ʱ��";
		rebounds = "������";
		assists = "������";
		presenceTime = "�ڳ�ʱ�䣨�룩";
		offences = "������";
		defences = "������";
		steals = "������";
		blockShots = "��ñ��";
		turnOvers = "ʧ����";
		fouls = "������";
		score = "�÷�";
		shootings = "Ͷ��������";
		shots = "Ͷ����";
		threePointShots = "��������";
		threePointShootings = "������������";
		 freeThrowShots = "������";
		freeThrowShoots = "����������";
		numOfMatch = "������";
		
		aveRebounds = "����������";
		aveAssists = "����������";
		avePresenceTime = "�����ڳ�ʱ�䣨�룩";
		aveOffences = "����������";
		aveDefences = "����������";
		aveSteals = "����������";
		aveBlockShots = "������ñ��";
		aveTurnOvers = "����ʧ����";
		aveFouls = "����������";
		aveScore = "�����÷�";
		aveShootings = "����Ͷ��������";
		aveShots = "����Ͷ����";
		aveThreePointShots = "������������";
		aveThreePointShootings = "����������������";
		aveFreeThrowShots = "����������";
		aveFreeThrowShoots = "��������������";
		


	}

		public void selectIDOfTeam(){
			
			selectedInfo.add(IDOfTeam);
			
		}
	
	
		public void selectFullName (){
			
			selectedInfo.add(fullName);
			
		}
	
		
		public void selectAbeerName(){
			
			selectedInfo.add(abeerName);
			
		}
	
		
		public void selectLocation(){
			
			selectedInfo.add(location);
			
		}
	
		
		public void selectZone(){
			
			selectedInfo.add(zone);
		}
	
		
		public void selectDivision(){
			
			selectedInfo.add(division);
			
		}
	
		
		public void selectHomeCourt (){
			
			selectedInfo.add(homeCourt);
			
		}
		
	
		public void selectRebounds(){
			
			selectedInfo.add(rebounds);
		
		}
		
		public void selectAssists(){
			
			selectedInfo.add(assists);
		
		}
		
		public void selectPresenceTime(){
			
			selectedInfo.add(presenceTime);
		
		}
		
		public void selectOffences(){
			
			selectedInfo.add(offences);
		
		}
		
		public void selectDefences(){
			
			selectedInfo.add(defences);
		
		}
		
		public void selectSteals(){
			
			selectedInfo.add(steals);
		
		}
		
		public void selectBlockShots(){
			
			selectedInfo.add(blockShots);
		
		}
		
		public void selectTurnOvers(){
			
			selectedInfo.add(turnOvers);
		
		}
		
		public void selectFouls(){
			
			selectedInfo.add(fouls);
		
		}
		
		public void selectScore(){
			
			selectedInfo.add(score);
		
		}
		
		public void selectShootings(){
			
			selectedInfo.add(shootings);
		
		}
		
		public void selectShots(){
			
			selectedInfo.add(shots);
		
		}
		
		public void selectThreePointShots(){
			
			selectedInfo.add(threePointShots);
		
		}
		public void selectThreePointShootings(){
			
			selectedInfo.add(threePointShootings);
			
		}
		
		public void selectFreeThrowShots(){
			
			selectedInfo.add(freeThrowShots);
		
		}
		
		
		public void selectFreeThrowShoots(){
			
			selectedInfo.add(freeThrowShoots);
		
		}
		
		public void selectNumOfMatch(){
			
			selectedInfo.add(numOfMatch);
		
		}
		
		public void selectBuiltTime(){
			
			selectedInfo.add(builtTime);
		
		}
		

		public void selectAveRebounds(){
			
			selectedInfo.add(aveRebounds);
		
		}
		
		public void selectAveAssists(){
			
			selectedInfo.add(aveAssists);
		
		}
		
		public void selectAvePresenceTime(){
			
			selectedInfo.add(avePresenceTime);
		
		}
		
		public void selectAveOffences(){
			
			selectedInfo.add(aveOffences);
		
		}
		
		public void selectAveDefences(){
			
			selectedInfo.add(aveDefences);
		
		}
		
		public void selectAveSteals(){
			
			selectedInfo.add(aveSteals);
		
		}
		
		public void selectAveBlockShots(){
			
			selectedInfo.add(aveBlockShots);
		
		}
		
		public void selectAveTurnOvers(){
			
			selectedInfo.add(aveTurnOvers);
		
		}
		
		public void selectAveFouls(){
			
			selectedInfo.add(aveFouls);
		
		}
		
		public void selectAveScore(){
			
			selectedInfo.add(aveScore);
		
		}
		
		public void selectAveShootings(){
			
			selectedInfo.add(aveShootings);
		
		}
		
		public void selectAveShots(){
			
			selectedInfo.add(aveShots);
		
		}
		
		public void selectAveThreePointShots(){
			
			selectedInfo.add(aveThreePointShots);
		
		}
		public void selectAveThreePointShootings(){
			
			selectedInfo.add(aveThreePointShootings);
			
		}
		
		public void selectAveFreeThrowShots(){
			
			selectedInfo.add(aveFreeThrowShots);
		
		}
		
		
		public void selectAveFreeThrowShoots(){
			
			selectedInfo.add(aveFreeThrowShoots);
		
		}
		
		
		
		
	
		public ArrayList<String> getSelectedList(){
			
			return selectedInfo;
			
		}
	

}
