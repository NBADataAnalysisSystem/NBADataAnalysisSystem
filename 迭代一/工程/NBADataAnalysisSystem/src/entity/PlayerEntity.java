package entity;

import java.util.Map;

public class PlayerEntity {

	private Map<PlayerInfo, String> playerInfo;
	
	public PlayerEntity(Map<PlayerInfo, String> playerInfo) {
		this.playerInfo = playerInfo;
	}

	/**
	 * @return the playerID
	 */
	public String getPlayerID() {
		return playerInfo.get(PlayerInfo.playerID);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return playerInfo.get(PlayerInfo.name);
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return playerInfo.get(PlayerInfo.number);
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return playerInfo.get(PlayerInfo.position);
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return playerInfo.get(PlayerInfo.height);
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return playerInfo.get(PlayerInfo.weight);
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return playerInfo.get(PlayerInfo.birth);
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return playerInfo.get(PlayerInfo.age);
	}

	/**
	 * @return the exp
	 */
	public String getExp() {
		return playerInfo.get(PlayerInfo.exp);
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return playerInfo.get(PlayerInfo.school);
	}

	/**
	 * @return the actionURL
	 */
	public String getActionURL() {
		String actionURL = playerInfo.get(PlayerInfo.filePath)
				+ "players\\action" 
				+ playerInfo.get(PlayerInfo.name);
		return actionURL;
	}

	/**
	 * @return the portraitURL
	 */
	public String getPortraitURL() {
		String portraitURL = playerInfo.get(PlayerInfo.filePath)
				+ "players\\portrait" 
				+ playerInfo.get(PlayerInfo.name);
		return portraitURL;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return playerInfo.get(PlayerInfo.team);
	}

	/**
	 * @return the numOfEntryField
	 */
	public String getNumOfEntryField() {
		return playerInfo.get(PlayerInfo.numOfEntryField);
	}

	/**
	 * @return the numOfStartingField
	 */
	public String getNumOfStartingField() {
		return playerInfo.get(PlayerInfo.numOfStartingField);
	}

	/**
	 * @return the numOfRebound
	 */
	public String getNumOfRebound() {
		return playerInfo.get(PlayerInfo.numOfRebound);
	}

	/**
	 * @return the numOfAssist
	 */
	public String getNumOfAssist() {
		return playerInfo.get(PlayerInfo.numOfAssist);
	}

	/**
	 * @return the timeOfPresence
	 */
	public String getTimeOfPresence() {
		return playerInfo.get(PlayerInfo.timeOfPresence);
	}

	/**
	 * @return the numOfOffense
	 */
	public String getNumOfOffense() {
		return playerInfo.get(PlayerInfo.numOfOffense);
	}

	/**
	 * @return the numOfDefense
	 */
	public String getNumOfDefense() {
		return playerInfo.get(PlayerInfo.numOfDefense);
	}

	/**
	 * @return the numOfSteal
	 */
	public String getNumOfSteal() {
		return playerInfo.get(PlayerInfo.numOfSteal);
	}

	/**
	 * @return the numOfBlockShot
	 */
	public String getNumOfBlockShot() {
		return playerInfo.get(PlayerInfo.numOfBlockShot);
	}

	/**
	 * @return the numOfTurnOver
	 */
	public String getNumOfTurnOver() {
		return playerInfo.get(PlayerInfo.numOfTurnOver);
	}

	/**
	 * @return the numOfFoul
	 */
	public String getNumOfFoul() {
		return playerInfo.get(PlayerInfo.numOfFoul);
	}

	/**
	 * @return the scoring
	 */
	public String getScoring() {
		return playerInfo.get(PlayerInfo.scoring);
	}
			
}
