package dao.playerdao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import entity.PlayerEntity;

public class PlayerEnumToField {

	private Map<PlayerEntity, String> map;
	
	public PlayerEnumToField() {
		map = new HashMap<PlayerEntity, String>();
		//编号，唯一
		map.put(PlayerEntity.ID, "id");
		
		//基本信息
		//球员名称
		map.put(PlayerEntity.PLAYER_NAME, "player_name");
		//球衣号码
		map.put(PlayerEntity.JERSEY_NUMBER, "jersey_number");
		//球员位置
		map.put(PlayerEntity.POSITION, "position");
		//身高
		map.put(PlayerEntity.HEIGHT, "height");
		//体重
		map.put(PlayerEntity.WEIGHT, "weight");
		//生日
		map.put(PlayerEntity.BIRTH, "birth");
		//年龄
		map.put(PlayerEntity.AGE, "age");
		//球龄
		map.put(PlayerEntity.EXP, "exp");
		//毕业学校
		map.put(PlayerEntity.SCHOOL, "school");
		//所属球队
		map.put(PlayerEntity.TEAM, "fn");
		
		map.put(PlayerEntity.NUM_OF_MATCH, "num_of_match");
		map.put(PlayerEntity.NUM_OF_START, "num_of_start");
		map.put(PlayerEntity.REBOUNDS, "rebounds");
		map.put(PlayerEntity.ASSISTS, "assists");
		map.put(PlayerEntity.PRESENCE_TIME, "presence_time");
		map.put(PlayerEntity.SHOOTING_PERSENTAGE, "shooting_persentage");
		map.put(PlayerEntity.THREE_POINT_SHOOTING_PERSENTAGE, "three_point_shooting_persentage");
		map.put(PlayerEntity.FREE_THROW_SHOOTING_PERSENTAGE, "free_throw_shooting_persentage");
		map.put(PlayerEntity.OFFENCES, "offences");
		map.put(PlayerEntity.DEFENCES, "defences");
		map.put(PlayerEntity.STEALS, "steals");
		map.put(PlayerEntity.BLOCK_SHOTS, "block_shots");
		map.put(PlayerEntity.TURN_OVERS, "turn_overs");
		map.put(PlayerEntity.FOULS, "fouls");
		map.put(PlayerEntity.SCORE, "score");
	}
	
	public String translate(PlayerEntity playerEntity) {
		return map.get(playerEntity);
	}
	
	public PlayerEntity reverseTranslate(String string) {
		Iterator<Entry<PlayerEntity, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<PlayerEntity, String> entry = iterator.next();
			if (entry.getValue().equals(string)) {
				return (PlayerEntity) entry.getKey();
			}
		}
		return null;
	}
	
}
