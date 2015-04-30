package service.playerdetailservice;

public interface GetPlayerDetailInfoService {

	public String[][] getPlayerSeasonInfo(String playerName);
	public String[][] getPlayerLatestFiveMatchInfo(String playerName);
	public String[] getPlayerBasicInfo(String playerName);
	public void close();
	
}
