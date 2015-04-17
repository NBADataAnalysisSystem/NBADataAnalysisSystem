package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import entity.PlayerEntity;

public interface GetPlayerService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(
			ArrayList<PlayerEntity> columnList);
	
}
