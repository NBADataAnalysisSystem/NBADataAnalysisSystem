package dao.matchdao;

import java.util.ArrayList;

public interface MatchDao {

	public ArrayList<String[]>getMatchSectionInfo(String[] sift);
	public void close();
	
}
