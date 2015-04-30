package dao.hotdao;

import java.util.ArrayList;

public interface HotDao {
	
	public ArrayList<String[]> getHotInfo(String[] sift);
	public void close();
	
}
