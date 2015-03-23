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
		
	
		public void selectBuiltTime(){
			
			selectedInfo.add(builtTime);
		
		}
	
		public ArrayList<String> getSelectedList(){
			
			return selectedInfo;
			
		}
	

}
