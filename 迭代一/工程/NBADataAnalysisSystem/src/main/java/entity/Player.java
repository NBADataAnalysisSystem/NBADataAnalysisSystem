package entity;

import java.util.Map;

public class Player {

	private Map<PlayerInfo, String> playerInfo;
	
	public Player(Map<PlayerInfo, String> playerInfo) {
		this.playerInfo = playerInfo;
	}

	/**
	 * @return the playerID
	 */
	public String getPlayerID() {
		return playerInfo.get(PlayerInfo.PLAYER_ID);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return playerInfo.get(PlayerInfo.NAME);
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return playerInfo.get(PlayerInfo.NUMBER);
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return playerInfo.get(PlayerInfo.POSITION);
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return playerInfo.get(PlayerInfo.HEIGHT);
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return playerInfo.get(PlayerInfo.WEIGHT);
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return playerInfo.get(PlayerInfo.BIRTH);
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return playerInfo.get(PlayerInfo.AGE);
	}

	/**
	 * @return the exp
	 */
	public String getExp() {
		return playerInfo.get(PlayerInfo.EXP);
	}

	/**
	 * @return the school
	 */
	public String getSchool() {
		return playerInfo.get(PlayerInfo.SCHOOL);
	}

	/**
	 * @return the actionURL
	 */
	public String getActionURL() {
		String actionURL = playerInfo.get(PlayerInfo.FILE_PATH)
				+ "players\\action" 
				+ playerInfo.get(PlayerInfo.NAME);
		return actionURL;
	}

	/**
	 * @return the portraitURL
	 */
	public String getPortraitURL() {
		String portraitURL = playerInfo.get(PlayerInfo.FILE_PATH)
				+ "players\\portrait" 
				+ playerInfo.get(PlayerInfo.NAME);
		return portraitURL;
	}

	/**
	 * @return the team
	 */
	public String getTeam() {
		return playerInfo.get(PlayerInfo.TEAM);
	}

	/**
	 * @return the numOfEntryField
	 */
	public String getNumOfEntryField() {
		return playerInfo.get(PlayerInfo.NUM_OF_ENTRY_FIELD);
	}

	/**
	 * @return the numOfStartingField
	 */
	public String getNumOfStartingField() {
		return playerInfo.get(PlayerInfo.NUM_OF_STARTING_FIELD);
	}

	/**
	 * @return the numOfRebound
	 */
	public String getNumOfRebound() {
		return playerInfo.get(PlayerInfo.NUM_OF_REBOUND);
	}

	/**
	 * @return the numOfAssist
	 */
	public String getNumOfAssist() {
		return playerInfo.get(PlayerInfo.NUM_OF_ASSIST);
	}

	/**
	 * @return the timeOfPresence
	 */
	public String getTimeOfPresence() {
		return playerInfo.get(PlayerInfo.TIME_OF_PRESENCE);
	}

	/**
	 * @return the numOfOffense
	 */
	public String getNumOfOffense() {
		return playerInfo.get(PlayerInfo.NUM_OF_OFFENSE);
	}

	/**
	 * @return the numOfDefense
	 */
	public String getNumOfDefense() {
		return playerInfo.get(PlayerInfo.NUM_OF_DEFENSE);
	}

	/**
	 * @return the numOfSteal
	 */
	public String getNumOfSteal() {
		return playerInfo.get(PlayerInfo.NUM_OF_STEAL);
	}

	/**
	 * @return the numOfBlockShot
	 */
	public String getNumOfBlockShot() {
		return playerInfo.get(PlayerInfo.NUM_OF_BLOCK_SHOT);
	}

	/**
	 * @return the numOfTurnOver
	 */
	public String getNumOfTurnOver() {
		return playerInfo.get(PlayerInfo.NUM_OF_TURN_OVER);
	}

	/**
	 * @return the numOfFoul
	 */
	public String getNumOfFoul() {
		return playerInfo.get(PlayerInfo.NUM_OF_FOUL);
	}

	/**
	 * @return the scoring
	 */
	public String getScoring() {
		return playerInfo.get(PlayerInfo.SCORING);
	}
			
}
