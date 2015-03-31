package ui.playerui;

import java.util.ArrayList;

import javax.swing.JCheckBox;

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
	
	
	public SelectedInfoOfPlayer(){
		
		 selectedInfo = new ArrayList<>();
		 
		 IDOfPlayer = "ID";
		 nameOfPlayer = "����";
		 numOfPlayer = "����";
		 positionOfPlayer = "λ��";
		 heightOfPlayer= "���";
		 weightOfPlayer = "����";
		 birthOfPlayer = "��������";
		 ageOfPlayer = "����";
		 expOfPlayer = "����";
		 schoolOfPlayer = "ѧУ";
		 filePathOfPlayer = "";
		 teamOfPlayer = "�������";
		 numOfEntryField = "��������";
		 numOfStartingField = "�ȷ�����";
		numOfRebound = "������";
		 numOfAssist = "������";
		 timeOfPresence = "�ڳ�ʱ��";
		 numOfOffense = "������";
		 numOfDffense = "������";
		 numOfSteal = "������"; 
		 numOfBlockShot = "��ñ��";
		 numOfTurnOver = "ʧ����";
		 numOfFoul = "������";
		 scorling = "�÷�";
		numOfShoot = "Ͷ��������";
		numOfShot = "Ͷ����";
		numOfThreePointShoot  = "������������";
		numOfThreePointShot = "����������";
		numOfFreeThrowShoot = "����������";
		numOfFreeThrowShot = "��������";
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
		
	
		public ArrayList<String> getSelectedList(){
			
			return selectedInfo;
			
		}
	

}
