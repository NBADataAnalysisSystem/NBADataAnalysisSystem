package ui.playerui;

import java.util.ArrayList;

public class SelectedInfoOfPlayer {
	
	private static  ArrayList<String> selectedInfo;
	private String IDOfPlayer;
	private String nameOfPlayer;
	private String numOfPlayer;
	private String positionOfPlayer;
	private String heightOfPlayer;
	private String weightOfPlayer;
	private String birthOfPlayer;
	private String ageOfPlayer;
	private String expOfPlayer;
	private String schoolOfPlayer;
	private String filePathOfPlayer;
	private String teamOfPlayer;
	private String numOfEntryField;
	private String numOfStartingField;
	private String numOfRebound;
	private String numOfAssist;
	private String timeOfPresence;
	private String numOfOffense;
	private String numOfDffense;
	private String numOfSteal;
	private String numOfBlockShot;
	private String numOfTurnOver;
	private String numOfFoul;
	private String scorling;
	private String numOfShoot;
	private String numOfShot;
	private String numOfThreePointShoot;
	private String numOfThreePointShot;
	private String numOfFreeThrowShoot;
	private String numOfFreeThrowShot;
	private String efficiency;
	private String effOfGmSc;
	private String truePersentageOfShooting ;
	private String effOfShooting ;
	private String rateOfRound ;
	private String rateOfOffensiveRound ;
	private String rateOfDefensiveRound ;
	private String rateOfSteal ;
	private String rateOfAssist;
	private String rateOfBlockShot;
	private String rateOfTurnOver;
	private String rateOfUse;
	
	private String aveNumOfRebound;
	private String aveNumOfAssist;
	private String aveNumOfOffense;
	private String aveTimeOfPresence;
	private String aveNumOfDffense;
	private String aveNumOfSteal;
	private String aveNumOfBlockShot;
	private String aveNumOfTurnOver;
	private String aveNumOfFoul;
	private String aveScorling;
	private String aveNumOfShoot;
	private String aveNumOfShot;
	private String aveNumOfThreePointShoot;
	private String aveNumOfThreePointShot;
	private String aveNumOfFreeThrowShoot;
	private String aveNumOfFreeThrowShot;
	
	
	public SelectedInfoOfPlayer(){
		
		 selectedInfo = new ArrayList<>();
		 
		 IDOfPlayer = "ID";
		 nameOfPlayer = "名字";
		 numOfPlayer = "号数";
		 positionOfPlayer = "位置";
		 heightOfPlayer= "身高";
		 weightOfPlayer = "体重";
		 birthOfPlayer = "出生日期";
		 ageOfPlayer = "年龄";
		 expOfPlayer = "球龄";
		 schoolOfPlayer = "学校";
		 filePathOfPlayer = "";
		 teamOfPlayer = "所在球队";
		 numOfEntryField = "参赛场数";
		 numOfStartingField = "先发场数";
		numOfRebound = "篮板数";
		 numOfAssist = "助攻数";
		 timeOfPresence = "在场时间（秒）";
		 numOfOffense = "进攻数";
		 numOfDffense = "防守数";
		 numOfSteal = "抢断数"; 
		 numOfBlockShot = "盖帽数";
		 numOfTurnOver = "失误数";
		 numOfFoul = "犯规数";
		 scorling = "得分";
		numOfShoot = "投篮命中数";
		numOfShot = "投篮数";
		numOfThreePointShoot  = "三分球命中数";
		numOfThreePointShot = "三分球总数";
		numOfFreeThrowShoot = "罚球命中数";
		numOfFreeThrowShot = "罚球总数";
		efficiency= "效率";
		effOfGmSc= "GmSc效率";
		truePersentageOfShooting= "真实投篮命中率" ;
		effOfShooting = "投篮效率";
		rateOfRound = "篮板率";
		rateOfOffensiveRound = "进攻篮板率";
		rateOfDefensiveRound = "防守篮板率";
		rateOfAssist= "助攻率";
		rateOfSteal= "抢断率";
		rateOfBlockShot= "盖帽率";
		rateOfTurnOver= "失误率";
		rateOfUse= "使用率";
		
		aveNumOfRebound = "场均篮板数";
		aveNumOfAssist = "场均助攻数";
		aveTimeOfPresence = "场均在场时间（秒）";
		aveNumOfOffense = "场均进攻数";
		aveNumOfDffense = "场均防守数";
		aveNumOfSteal = "场均抢断数"; 
		aveNumOfBlockShot = "场均盖帽数";
		aveNumOfTurnOver = "场均失误数";
		aveNumOfFoul = "场均犯规数";
		aveScorling = "场均得分";
		aveNumOfShoot = "场均投篮命中数";
		aveNumOfShot = "场均投篮数";
		aveNumOfThreePointShoot  = "场均三分球命中数";
		aveNumOfThreePointShot = "场均三分球总数";
		aveNumOfFreeThrowShoot = "场均罚球命中数";
		aveNumOfFreeThrowShot = "场均罚球总数";

	}

		public void selectIDOfPlayer(){
			
			selectedInfo.add(IDOfPlayer);
			
		}
	
	
		public void selectNameOfPlayer (){
			
			selectedInfo.add(nameOfPlayer);
			
		}
	
		
		public void selectNumOfPlayer(){
			
			selectedInfo.add(numOfPlayer);
			
		}
	
		
		public void selectPositionOfPlayer(){
			
			selectedInfo.add(positionOfPlayer);
			
		}
	
		
		public void selectHeightOfPlayer(){
			
			selectedInfo.add(heightOfPlayer);
		}
	
		
		public void selectWeightOfPlayer(){
			
			selectedInfo.add(weightOfPlayer);
			
		}
	
		
		public void selectBirthOfPlayer (){
			
			selectedInfo.add(birthOfPlayer);
			
		}
		
	
		public void selectAgeOfPlayer(){
			
			selectedInfo.add(ageOfPlayer);
		
		}
		
	
		public void selectExpOfPlayer(){
			
			selectedInfo.add(expOfPlayer);
			
		}
		
	
		public void selectSchoolOfPlayer(){
			
			selectedInfo.add(schoolOfPlayer);
			
		}
		
	
		public void selectFilePathOfPlayer(){
			
			selectedInfo.add(filePathOfPlayer);
			
		}
		
	
		public void selectTeamOfPlayer(){
			
			selectedInfo.add(teamOfPlayer);
			
		}
		
	
		public void selectNumOfEntryField(){
			
			selectedInfo.add(numOfEntryField);
			
		}
		
	
		public void selectNumOfStartingField (){
	 		
			selectedInfo.add(numOfStartingField);
			
	 	}
	 	
	
		public void selectNumOfRebound (){
	 		
			selectedInfo.add(numOfRebound);
			
	 	}
	 	
	
		public void selectNumOfAssist(){
	 		
			selectedInfo.add(numOfAssist);
			
	 	}
	 	
	
		public void selectTimeOfPresence(){
	 		
			selectedInfo.add(timeOfPresence);
			
	 	}
	 	
	
		public void selectNumOfOffense(){
	 		
			selectedInfo.add(numOfOffense);
			
	 	}
		
		public void selectNumOfDffense(){
	 		
			selectedInfo.add(numOfDffense);
			
	 	}
	 	
	
		public void selectNumOfSteal(){
	 		
			selectedInfo.add(numOfSteal);
			
	 	}
	 	
	
		public void selectNumOfBlockShot (){
	 		
			selectedInfo.add(numOfBlockShot);
			
	 	}
	 	
	
		public void selectNumOfTurnOver (){
	 		
			selectedInfo.add(numOfTurnOver);
			
	 	}
	 	
		
		public void selectAveTimeOfPresence(){
	 		
			selectedInfo.add(aveTimeOfPresence);
			
	 	}
	
		public void selectNumOfFoul(){
			
			selectedInfo.add(numOfFoul);
			
		}
	
		public void selectNumOfShoot(){
			
			selectedInfo.add(numOfShoot);
			
		}
		
		public void selectNumOfShot(){
			
			selectedInfo.add(numOfShot);
			
		}
		
		public void selectNumOfThreePointShoot (){
			
			selectedInfo.add(numOfThreePointShoot );
			
		}
		
		public void selectNumOfThreePointShot(){
			
			selectedInfo.add(numOfThreePointShot);
			
		}
		
		public void selectNumOfFreeThrowShoot (){
			
			selectedInfo.add(numOfFreeThrowShoot );
			
		}
		
		public void selectNumOfFreeThrowShot(){
			
			selectedInfo.add(numOfFreeThrowShot);
			
		}
		
		public void selectScorling(){
			
			selectedInfo.add(scorling);
			
		}
		
		//

		public void selectAveNumOfRebound (){
	 		
			selectedInfo.add(aveNumOfRebound);
			
	 	}
	 	
	
		public void selectAveNumOfAssist(){
	 		
			selectedInfo.add(aveNumOfAssist);
			
	 	}
	 	
	
		public void selectAveNumOfOffense(){
	 		
			selectedInfo.add(aveNumOfOffense);
			
	 	}
		
		public void selectAveNumOfDffense(){
	 		
			selectedInfo.add(aveNumOfDffense);
			
	 	}
	 	
	
		public void selectAveNumOfSteal(){
	 		
			selectedInfo.add(aveNumOfSteal);
			
	 	}
	 	
	
		public void selectAveNumOfBlockShot (){
	 		
			selectedInfo.add(aveNumOfBlockShot);
			
	 	}
	 	
	
		public void selectAveNumOfTurnOver (){
	 		
			selectedInfo.add(aveNumOfTurnOver);
			
	 	}
	 	
	
		public void selectAveNumOfFoul(){
			
			selectedInfo.add(aveNumOfFoul);
			
		}
	
		public void selectAveNumOfShoot(){
			
			selectedInfo.add(aveNumOfShoot);
			
		}
		
		public void selectAveNumOfShot(){
			
			selectedInfo.add(aveNumOfShot);
			
		}
		
		public void selectAveNumOfThreePointShoot (){
			
			selectedInfo.add(aveNumOfThreePointShoot );
			
		}
		
		public void selectAveNumOfThreePointShot(){
			
			selectedInfo.add(aveNumOfThreePointShot);
			
		}
		
		public void selectAveNumOfFreeThrowShoot (){
			
			selectedInfo.add(aveNumOfFreeThrowShoot );
			
		}
		
		public void selectAveNumOfFreeThrowShot(){
			
			selectedInfo.add(aveNumOfFreeThrowShot);
			
		}
		
		public void selectAveScorling(){
			
			selectedInfo.add(aveScorling);
			
		}
		
		public void selectEfficiency (){
			
			selectedInfo.add(efficiency );
			
		}
		
		public void selectEffOfGmSc (){
			
			selectedInfo.add(effOfGmSc );
			
		}
		
		public void selectTruePersentageOfShooting (){
			
			selectedInfo.add(truePersentageOfShooting );
			
		}
		
		public void selectEffOfShooting (){
			
			selectedInfo.add(effOfShooting );
			
		}
		
		public void selectRateOfRound (){
			
			selectedInfo.add(rateOfRound );
			
		}
		
		public void selectRateOfOffensiveRound (){
			
			selectedInfo.add(rateOfOffensiveRound );
			
		}
		
		public void selectRateOfDefensiveRound (){
			
			selectedInfo.add(rateOfDefensiveRound );
			
		}
		
		public void selectRateOfSteal (){
			
			selectedInfo.add(rateOfSteal );
			
		}
		
		public void selectRateOfAssist (){
			
			selectedInfo.add(rateOfAssist );
			
		}
		
		public void selectRateOfBlockShot (){
			
			selectedInfo.add(rateOfBlockShot );
			
		}
		
		public void selectRateOfTurnOver (){
			
			selectedInfo.add(rateOfTurnOver );
			
		}
		
		public void selectRateOfUse (){
			
			selectedInfo.add(rateOfUse );
			
		}
		
		
		
	
		public ArrayList<String> getSelectedList(){
			
			return selectedInfo;
			
		}
	

}
