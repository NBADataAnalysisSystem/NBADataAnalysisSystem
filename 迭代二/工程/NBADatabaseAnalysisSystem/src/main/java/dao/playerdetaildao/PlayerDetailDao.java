package dao.playerdetaildao;

public interface PlayerDetailDao {

	public String[][] getPlayerSeasonInfo(String playerName);
	public String[][] getPlayerLatestFiveMatchInfo(String playerName);
	public String[] getPlayerBasicInfo(String playerName);
	public void close();
	
}
