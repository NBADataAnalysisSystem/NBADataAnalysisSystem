package service.playerservice;

import java.util.ArrayList;
import java.util.Map;

import dao.playerdao.PlayerInfoType;
import entity.PlayerEntity;

public interface GetPlayerService {

	public ArrayList<Map<PlayerEntity, String>> getPlayer(
			PlayerInfoType type);
	
}
