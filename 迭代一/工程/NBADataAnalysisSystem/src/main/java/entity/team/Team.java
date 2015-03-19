package entity.team;

import java.util.Map;

public class Team {

	private Map<TeamInfo, String> teamInfo;

	public Team(Map<TeamInfo, String> teamInfo) {
		this.teamInfo = teamInfo;
	}
	
	/**
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamInfo.get(TeamInfo.TEAM_ID);
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return teamInfo.get(TeamInfo.FULL_NAME);
	}

	/**
	 * @return the abbrName
	 */
	public String getAbbrName() {
		return teamInfo.get(TeamInfo.ABBR_NAME);
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return teamInfo.get(TeamInfo.LOCATION);
	}

	/**
	 * @return the zone
	 */
	public String getZone() {
		return teamInfo.get(TeamInfo.ZONE);
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return teamInfo.get(TeamInfo.DIVISION);
	}

	/**
	 * @return the homeCourt
	 */
	public String getHomeCourt() {
		return teamInfo.get(TeamInfo.HOME_COURT);
	}

	/**
	 * @return the builtTime
	 */
	public String getBuiltTime() {
		return teamInfo.get(TeamInfo.BUILT_TIME);
	}
	
}