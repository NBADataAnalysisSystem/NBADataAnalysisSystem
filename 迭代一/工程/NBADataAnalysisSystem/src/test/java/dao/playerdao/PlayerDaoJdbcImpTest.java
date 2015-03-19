package dao.playerdao;

import java.util.ArrayList;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.player.PlayerInfo;

public class PlayerDaoJdbcImpTest {

	private PlayerDaoJdbcImp dao;
	
	@Before
	public void initialize() throws Exception {
		dao = new PlayerDaoJdbcImp();
	}
	
	@After
	public void closeDatabase() throws Exception {
		dao.close();
	}
	
	@Test
	public void testGetPlayer() throws Exception {
		ArrayList<PlayerInfo> columnList = new ArrayList<>();
		columnList.add(PlayerInfo.NAME);
		columnList.add(PlayerInfo.AGE);
		ArrayList<Map<PlayerInfo, String>> mapList = dao.getPlayer(columnList);
		for (Map<PlayerInfo, String> map:mapList) {
			System.out.println(map.get(PlayerInfo.NAME)+";"+map.get(PlayerInfo.AGE));
		}
	}

}
