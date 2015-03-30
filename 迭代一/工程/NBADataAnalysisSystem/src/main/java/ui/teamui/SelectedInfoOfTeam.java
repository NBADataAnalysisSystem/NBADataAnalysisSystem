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
	
	public SelectedInfoOfTeam(){
		
		 selectedInfo = new ArrayList<>();
		 
		 IDOfTeam = "ID";
		 fullName = "全称";
		 abeerName = "简称";
		 location = "位置";
		 zone = "赛区";
		 division = "联盟";
		 homeCourt = "主场";
		 builtTime = "成立时间";
		rebounds = "篮板数";
		assists = "助攻数";
		presenceTime = "在场时间";
		offences = "防守数";
		defences = "进攻数";
		steals = "抢断数";
		blockShots = "盖帽数";
		turnOvers = "失误数";
		fouls = "犯规数";
		score = "得分";
		shootings = "投篮命中数";
		shots = "投篮数";
		threePointShots = "三分球数";
		threePointShootings = "三分球命中数";
		 freeThrowShots = "罚球数";
		freeThrowShoots = "罚球命中数";
		numOfMatch = "比赛数";

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
		
		
		
		
	
		public ArrayList<String> getSelectedList(){
			
			return selectedInfo;
			
		}
	

}
