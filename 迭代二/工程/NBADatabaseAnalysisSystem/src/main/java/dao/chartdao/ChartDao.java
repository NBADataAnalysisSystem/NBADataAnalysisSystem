package dao.chartdao;

public interface ChartDao {
	
	public String[][] getPlayerEfficiency(String playerName);
	
	public  String[] getLeagueInfo();
	
	public String[] getPlayerLeagueInfo();
	
	public String[][] getTeamPlayerEfficiency(String teamAbb);
	
	public String[][] getPlayerScoreAtPosition();
	
	public String[][] getTeamRate();
	
	public String[][] getPlayerCareerInfo(String playerName);
	
	public String[][] getTeamMatchInfo(String teamName);
	
	public void close();

}
