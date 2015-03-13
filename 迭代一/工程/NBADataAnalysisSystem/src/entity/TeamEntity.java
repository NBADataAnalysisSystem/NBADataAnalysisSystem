package entity;

import java.util.ArrayList;

public class TeamEntity {

	private String teamID;
	private String fullName;
	private String abbrName;
	private String location;
	private String zone;
	private String division;
	private String homeCourt;
	private String builtTime;
	
	/**
	 * @param teamInfoList
	 * information of a team
	 */
	public TeamEntity(ArrayList<String> teamInfoList) {
		teamID = teamInfoList.get(0);
		fullName = teamInfoList.get(1);
		abbrName = teamInfoList.get(2);
		location = teamInfoList.get(3);
		zone = teamInfoList.get(4);
		division = teamInfoList.get(5);
		homeCourt = teamInfoList.get(6);
		builtTime = teamInfoList.get(7);
	}

	/**
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamID;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @return the abbrName
	 */
	public String getAbbrName() {
		return abbrName;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return zone;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @return the homeCourt
	 */
	public String getHomeCourt() {
		return homeCourt;
	}

	/**
	 * @return the builtTime
	 */
	public String getBuiltTime() {
		return builtTime;
	}
	
}
