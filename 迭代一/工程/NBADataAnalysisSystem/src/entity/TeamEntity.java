package entity;

import java.util.Map;

public class TeamEntity {

	private Map<TeamInfo, String> teamInfo;

	public TeamEntity(Map<TeamInfo, String> teamInfo) {
		this.teamInfo = teamInfo;
	}
	
	/**
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamInfo.get(TeamInfo.teamID);
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return teamInfo.get(TeamInfo.fullName);
	}

	/**
	 * @return the abbrName
	 */
	public String getAbbrName() {
		return teamInfo.get(TeamInfo.abbrName);
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return teamInfo.get(TeamInfo.location);
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return teamInfo.get(TeamInfo.zone);
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return teamInfo.get(TeamInfo.division);
	}

	/**
	 * @return the homeCourt
	 */
	public String getHomeCourt() {
		return teamInfo.get(TeamInfo.homeCourt);
	}

	/**
	 * @return the builtTime
	 */
	public String getBuiltTime() {
		return teamInfo.get(TeamInfo.builtTime);
	}
	
}