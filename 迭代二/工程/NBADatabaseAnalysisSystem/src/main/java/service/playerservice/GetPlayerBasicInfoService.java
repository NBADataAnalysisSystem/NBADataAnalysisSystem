package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerEntity;

public interface GetPlayerBasicInfoService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer();
	
}
