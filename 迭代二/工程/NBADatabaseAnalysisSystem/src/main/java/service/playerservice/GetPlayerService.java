package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerEntity;
import entity.PlayerInfoType;

public interface GetPlayerService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(
			PlayerInfoType type);
	
}
