package serviceimp.playerserviceimp;

import java.util.ArrayList;

import dao.playerdao.PlayerDao;
import dao.playerdao.PlayerDaoJdbcImp;
import service.playerservice.GetPlayerSeasonTotalInfoService;

public class GetPlayerSeasonTotalInfoImp implements GetPlayerSeasonTotalInfoService {

	public ArrayList<String> getPlayer(String[] sift) {
		PlayerDao dao = new PlayerDaoJdbcImp();
		try {
			if (sift[0] != null) {
				if (sift[0].equals("东部")) {
					sift[0] = "E";
				} else if (sift[0].equals("西部")) {
					sift[0] = "W";
				} else if (sift[0].equals("大西洋区")) {
					sift[0] = "Atlantic";
				} else if (sift[0].equals("中央区")) {
					sift[0] = "Central";
				} else if (sift[0].equals("东南区")) {
					sift[0] = "Southeast";
				} else if (sift[0].equals("西南区")) {
					sift[0] = "Southwest";
				} else if (sift[0].equals("西北区")) {
					sift[0] = "Northwest";
				} else if (sift[0].equals("太平洋区")) {
					sift[0] = "Pacific";
				}
			}
			if (sift[1] != null) {
				if (sift[1].equals("前锋")) {
					sift[1] = "F";
				} else if (sift[1].equals("中锋")) {
					sift[1] = "C";
				} else if (sift[1].equals("后卫")) {
					sift[1] = "G";
				}
			}
			if (sift[2] != null) {
				if (sift[2].equals("得分")) {
					sift[2] = "ssc";
				} else if (sift[2].equals("篮板")) {
					sift[2] = "sr";
				} else if (sift[2].equals("助攻")) {
					sift[2] = "sa";
				} else if (sift[2].equals("得分/篮板/助攻")) {
					sift[2] = "round((ssc + sr + sa) / 3, 1)";
				} else if (sift[2].equals("盖帽")) {
					sift[2] = "sbs";
				} else if (sift[2].equals("抢断")) {
					sift[2] = "sst";
				} else if (sift[2].equals("犯规")) {
					sift[2] = "sfo";
				} else if (sift[2].equals("失误")) {
					sift[2] = "sto";
				} else if (sift[2].equals("分钟")) {
					sift[2] = "spt";
				} else if (sift[2].equals("效率")) {
					sift[2] = "''";
				} else if (sift[2].equals("投篮")) {
					sift[2] = "sp";
				} else if (sift[2].equals("三分")) {
					sift[2] = "tpsp";
				} else if (sift[2].equals("罚球")) {
					sift[2] = "ftsp";
				} else if (sift[2].equals("两双")) {
					sift[2] = "1.0*t5.dd/dmi";
				}
			}
			return dao.getPlayerSeasonTotalInfo(sift);
		} finally {
			dao.close();
		}
	}

}

